//package Module.WeddingManagement.Repository.Repository;
//
//import Module.WeddingManagement.ApplicationModel.Food;
//import Module.WeddingManagement.ApplicationModel.Menu;
//import Module.WeddingManagement.Contract.Repository.IMenuRepository;
//import Module.WeddingManagement.Repository.Entity.FoodEntity;
//import Module.WeddingManagement.Repository.Entity.HallEntity;
//import Module.WeddingManagement.Repository.Entity.MenuEntity;
//import Module.WeddingManagement.Repository.HibernateUtil;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MenuRepository implements IMenuRepository {
//
//    @Inject
//    private EntityManager entityManager;
//
//    @Override
//    public Menu Find(int id) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            MenuEntity menuEntity = session.get(MenuEntity.class, id);
//            return toMenu(menuEntity);
//        }
//    }
//
//    private Menu toMenu(MenuEntity entity)
//    {
//        List<Food> foods = new ArrayList<Food>();
//        if (entity.getFoods().size() > 0)
//        {
//            for (FoodEntity foodEntity : entity.getFoods())
//            {
//                foods.add(toFood(foodEntity));
//            }
//        }
//        Menu menu = new Menu(entity.getId(), entity.getCreatedAt(), foods);
//        return menu;
//    }
//
//    private Food toFood(FoodEntity foodEntity) {
//        Food food = new Food(foodEntity.getFoodId(), foodEntity.getName(), foodEntity.getPrice(), foodEntity.getNote(), foodEntity.getType());
//        return  food;
//    }
//
//    @Override
//    public List<Menu> FindAll() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession())
//        {
//            Query<MenuEntity> query = session.createQuery("FROM MenuEntity");
//            List<MenuEntity> list= query.list();
//
//            if (list.isEmpty())
//                return null;
//            List<Menu> result = new ArrayList<>();
//            for (MenuEntity i : list)
//            {
//                result.add(toMenu(i));
//            }
//            return result;
//        }
//    }
//
//    @Override
//    public void Persist(Menu menu) {
//        MenuEntity menuEntity = new MenuEntity();
//        menuEntity.setCreatedAt(menu.getCreatedAt());
//        entityManager.persist(menuEntity);
//    }
//}
