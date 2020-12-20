package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Service;
import Module.WeddingManagement.Contract.UseCase.IListOutput;
import Module.WeddingManagement.Repository.DBContext;

import java.util.List;

public class ListService implements IListOutput<Service> {
    @Override
    public List<Service> GetList() {
        List<Service> services = DBContext.getServices().FindAll();
        return services;
    }
}