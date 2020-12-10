package Module.WeddingManagement.Repository.Repository;

import Module.WeddingManagement.ApplicationModel.Employee;
import Module.WeddingManagement.ApplicationModel.Food;
import Module.WeddingManagement.Contract.Repository.IFoodRepository;
import Module.WeddingManagement.Repository.Entity.EmployeeEntity;
import Module.WeddingManagement.Repository.Entity.FoodEntity;
import Module.WeddingManagement.Repository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository implements IFoodRepository {
    @Override
    public Food Find(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            FoodEntity foodEntity = session.get(FoodEntity.class, id);
            return toFood(foodEntity);
        }
    }

    private Food toFood(FoodEntity foodEntity) {
        Food food = new Food(foodEntity.getFoodId(), foodEntity.getName(), foodEntity.getPrice(), foodEntity.getNote(), foodEntity.getType());
        return  food;
    }

    @Override
    public List<Food> FindAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            Query<FoodEntity> query = session.createQuery("FROM FoodEntity");
            List<FoodEntity> list= query.list();

            if (list.isEmpty())
                return null;
            List<Food> result = new ArrayList<>();
            for (FoodEntity i : list)
            {
                result.add(toFood(i));
            }
            return result;
        }
    }

    @Override
    public void Persist(Food food) {

    }
}
