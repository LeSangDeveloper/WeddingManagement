package Module.WeddingManagement.Repository.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import Module.WeddingManagement.ApplicationModel.Employee;
import Module.WeddingManagement.Contract.Repository.IEmployeeRepository;
import Module.WeddingManagement.Repository.Entity.EmployeeEntity;
import Module.WeddingManagement.Repository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public Employee Find(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, id);
            return toEmployee(employeeEntity);
        }
    }

    private Employee toEmployee(EmployeeEntity employeeEntity)
    {
        Employee result = new Employee(employeeEntity.getEmployeeId(), employeeEntity.getTitle(), employeeEntity.getFullName(), employeeEntity.getUserName(), employeeEntity.getPassword());
        return result;
    }

    @Override
    public List<Employee> FindAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            Query<EmployeeEntity> query = session.createQuery("FROM EmployeeEntity");
            List<EmployeeEntity> list= query.list();

            if (list.isEmpty())
                return null;
            List<Employee> result = new ArrayList<>();
            for (EmployeeEntity i : list)
            {
                result.add(toEmployee(i));
            }
            return result;
        }
    }

    @Override
    public void Persist(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFullName(employee.getFullName());
        employeeEntity.setPassword(employee.getPassword());
        employeeEntity.setTitle(employee.getTitle());
        employeeEntity.setUserName(employee.getUserName());
        entityManager.persist(employeeEntity);
    }

    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

}
