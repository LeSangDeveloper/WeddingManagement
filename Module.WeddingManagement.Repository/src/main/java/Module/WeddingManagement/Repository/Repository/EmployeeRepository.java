package Module.WeddingManagement.Repository.Repository;

import javax.inject.Inject;
import javax.persistence.*;

import Module.WeddingManagement.ApplicationModel.Employee;
import Module.WeddingManagement.Contract.Repository.IEmployeeRepository;
import Module.WeddingManagement.Repository.Entity.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public Employee Find(int id) {
        List<EmployeeEntity> list = entityManager.createNamedQuery(EmployeeEntity.QUERY_FIND_BY_ID, EmployeeEntity.class)
                .setParameter("employeeId", id).getResultList();
        if (list.isEmpty())
            return null;

        EmployeeEntity employeeEntity = list.get(0);
        return  toEmployee(employeeEntity);
    }

    private Employee toEmployee(EmployeeEntity employeeEntity)
    {
        Employee result = new Employee(employeeEntity.getTitle(), employeeEntity.getFullName(), employeeEntity.getUserName(), employeeEntity.getPassword());
        return result;
    }

    @Override
    public List<Employee> FindAll() {
        List<EmployeeEntity> list = entityManager.createNamedQuery(EmployeeEntity.QUERY_FIND_BY_ID, EmployeeEntity.class)
                .getResultList();
        if (list.isEmpty())
            return null;
        List<Employee> result = new ArrayList<>();
        for (EmployeeEntity i : list)
        {
            result.add(toEmployee(i));
        }
        return result;
    }

    @Override
    public void Persist(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity(employee.getEmployeeId(), employee.getTitle(), employee.getFullName(), employee.getUserName(), employee.getPassword());
        entityManager.persist(employeeEntity);
    }

    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

}
