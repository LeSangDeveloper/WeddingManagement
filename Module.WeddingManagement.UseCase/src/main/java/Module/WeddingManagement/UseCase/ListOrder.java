package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Order;
import Module.WeddingManagement.Contract.UseCase.IListOutput;
import Module.WeddingManagement.Repository.DBContext;

import java.util.List;

public class ListOrder implements IListOutput<Order> {

    @Override
    public List<Order> GetList() {
        List<Order> result = DBContext.getOrders().FindAll();
        return result;
    }
}
