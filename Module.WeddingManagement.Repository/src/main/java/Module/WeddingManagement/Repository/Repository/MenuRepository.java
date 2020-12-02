package Module.WeddingManagement.Repository.Repository;

import Module.WeddingManagement.ApplicationModel.Food;
import Module.WeddingManagement.ApplicationModel.Menu;
import Module.WeddingManagement.Contract.Repository.IMenuRepository;
import Module.WeddingManagement.Repository.Entity.MenuEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class MenuRepository implements IMenuRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public Menu Find(int Id) {
        return null;
    }

    @Override
    public List<Menu> FindAll() {
        return null;
    }

    @Override
    public void Persist(Menu menu) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setCreatedAt(menu.getCreatedAt());
        entityManager.persist(menuEntity);
    }
}
