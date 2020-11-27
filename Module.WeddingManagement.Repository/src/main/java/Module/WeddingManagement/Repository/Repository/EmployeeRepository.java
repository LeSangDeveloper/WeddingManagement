package Module.WeddingManagement.Repository.Repository;

import javax.inject.Inject;
import javax.persistence.*;

import Module.WeddingManagement.ApplicationModel.Employee;
import Module.WeddingManagement.Contract.Repository.IEmployeeRepository;

import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public Employee Find(int Id) {
        return null;
    }

    @Override
    public List<Employee> FindAll() {
        return null;
    }

    @Override
    public void Persist(Employee employee) {

    }
}
