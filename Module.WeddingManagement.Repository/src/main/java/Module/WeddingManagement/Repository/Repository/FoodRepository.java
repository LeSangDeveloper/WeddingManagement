package Module.WeddingManagement.Repository.Repository;

import Module.WeddingManagement.ApplicationModel.Food;
import Module.WeddingManagement.Contract.Repository.IFoodRepository;

import java.util.List;

public class FoodRepository implements IFoodRepository {
    @Override
    public Food Find(int Id) {
        return null;
    }

    @Override
    public List<Food> FindAll() {
        return null;
    }

    @Override
    public void Persist(Food food) {

    }
}
