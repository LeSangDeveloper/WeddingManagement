package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Food;
import Module.WeddingManagement.ApplicationModel.Menu;
import Module.WeddingManagement.Contract.UseCase.ICreate;
import Module.WeddingManagement.Repository.DBContext;
import Module.WeddingManagement.Repository.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddMenu implements ICreate<Menu> {

    public Set<Food> foods = new HashSet<Food>();

    public AddMenu()
    {

    }

    public AddMenu(Set<Food> foods)
    {
        this.foods = foods;
    }

    @Override
    public Menu Create() {
        Set<Food> fsd = foods;
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            session.getTransaction().begin();
            Menu menu = new Menu();
            menu.setCreatedAt(new Date());
            session.persist(menu);
            session.getTransaction().commit();
        }
        List<Menu> menus = DBContext.getMenus().FindAll();
        Menu menu = menus.get(menus.size() - 1);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            menu.setFoods(fsd);
            session.saveOrUpdate(menu);
            session.getTransaction().commit();
        }
        return menu;
    }

    public Menu CreateMenu(Set<Food> fds) {
        Set<Food> fsd = fds;
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            session.getTransaction().begin();
            Menu menu = new Menu();
            menu.setCreatedAt(new Date());
            session.persist(menu);
            session.getTransaction().commit();
        }
        List<Menu> menus = DBContext.getMenus().FindAll();
        Menu menu = menus.get(menus.size() - 1);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            menu.setFoods(fsd);
            session.saveOrUpdate(menu);
            session.getTransaction().commit();
        }
        return menu;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }
}
