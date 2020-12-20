package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Food;
import Module.WeddingManagement.Contract.UseCase.IListOutput;
import Module.WeddingManagement.Repository.DBContext;

import java.util.List;

public class ListFood implements IListOutput<Food> {

    @Override
    public List<Food> GetList() {
        List<Food> foods = DBContext.getFoods().FindAll();
        return foods;
    }
}
