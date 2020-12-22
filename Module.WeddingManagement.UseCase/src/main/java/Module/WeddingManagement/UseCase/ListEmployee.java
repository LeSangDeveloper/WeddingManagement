package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Employee;
import Module.WeddingManagement.Contract.UseCase.IListOutput;
import Module.WeddingManagement.Repository.DBContext;

import java.util.List;

public class ListEmployee implements IListOutput<Employee> {
    @Override
    public List<Employee> GetList() {
        return DBContext.getEmployees().FindAll();
    }
}
