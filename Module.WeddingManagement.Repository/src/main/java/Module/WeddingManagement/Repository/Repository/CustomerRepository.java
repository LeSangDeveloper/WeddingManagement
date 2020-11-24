package Module.WeddingManagement.Repository.Repository;

import javax.inject.Inject;
import javax.persistence.*;

import Module.WeddingManagement.ApplicationModel.Customer;
import Module.WeddingManagement.Contract.Repository.ICustomRepository;
import Module.WeddingManagement.Repository.Entity.CustomerEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public Customer Find(int id) {
        List<CustomerEntity> list = entityManager.createNamedQuery(CustomerEntity.QUERY_FIND_BY_ID, CustomerEntity.class)
                .setParameter("customerId", id).getResultList();
        if (list.isEmpty())
            return null;

        CustomerEntity customerEntity = list.get(0);
        return  toCustomer(customerEntity);
    }

    private Customer toCustomer(CustomerEntity customerEntity)
    {
        Customer result = new Customer("","","");
        result.setAddress(customerEntity.getAddress());
        result.setName(customerEntity.getName());
        result.setPhone(customerEntity.getPhone());
        return result;
    }

    @Override
    public List<Customer> FindAll() {
        List<CustomerEntity> list = entityManager.createNamedQuery(CustomerEntity.QUERY_FIND_BY_ID, CustomerEntity.class)
                .getResultList();
        if (list.isEmpty())
            return null;
        List<Customer> result = new ArrayList<>();
        for (CustomerEntity i : list)
        {
            result.add(toCustomer(i));
        }
        return result;
    }

    @Override
    public void Persist(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setName(customer.getName());
        customerEntity.setPhone(customer.getPhone());
        entityManager.persist(customerEntity);
    }

    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

}
