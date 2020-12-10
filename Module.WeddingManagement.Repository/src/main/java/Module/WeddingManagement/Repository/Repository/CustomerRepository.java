package Module.WeddingManagement.Repository.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import Module.WeddingManagement.ApplicationModel.Customer;
import Module.WeddingManagement.Contract.Repository.ICustomerRepository;
import Module.WeddingManagement.Repository.Entity.CustomerEntity;
import Module.WeddingManagement.Repository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public Customer Find(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            CustomerEntity customerEntity = session.get(CustomerEntity.class, id);
            return toCustomer(customerEntity);
        }
    }

    private Customer toCustomer(CustomerEntity customerEntity)
    {
        Customer result = new Customer(customerEntity.getCustomerId(), customerEntity.getName(),customerEntity.getPhone(),customerEntity.getAddress());
        return result;
    }

    @Override
    public List<Customer> FindAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            Query<CustomerEntity> query = session.createQuery("FROM CustomerEntity");
            List<CustomerEntity> customerEntities = query.list();
            if (customerEntities.isEmpty())
                return null;
            List<Customer> result = new ArrayList<>();
            for (CustomerEntity i : customerEntities)
            {
                result.add(toCustomer(i));
            }
            return  result;
        }
    }

    @Override
    public void Persist(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setPhone(customer.getPhone());
        customerEntity.setName(customer.getName());
        customerEntity.setAddress(customer.getAddress());
        entityManager.persist(customerEntity);
    }

    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

}
