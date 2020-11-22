package Module.WeddingManagement.Contract.Repository;

import Module.WeddingManagement.ApplicationModel.Customer;

import java.util.List;

public interface ICustomRepository {

    Customer find(int Id);

    List<Customer> findAll();

    void persist(Customer customer);

}
