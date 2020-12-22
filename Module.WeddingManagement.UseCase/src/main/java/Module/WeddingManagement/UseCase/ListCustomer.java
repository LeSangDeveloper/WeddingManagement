package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Customer;
import Module.WeddingManagement.Contract.UseCase.IListOutput;
import Module.WeddingManagement.Repository.DBContext;

import java.util.List;

public class ListCustomer implements IListOutput<Customer> {
    @Override
    public List<Customer> GetList() {
        return DBContext.getCustomers().FindAll();
    }
}
