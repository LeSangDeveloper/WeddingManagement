package Module.WeddingManagement.Repository.Repository;

import Module.WeddingManagement.ApplicationModel.Employee;
import Module.WeddingManagement.ApplicationModel.Food;
import Module.WeddingManagement.ApplicationModel.Hall;
import Module.WeddingManagement.Contract.Repository.IHallRepository;
import Module.WeddingManagement.Repository.Entity.EmployeeEntity;
import Module.WeddingManagement.Repository.Entity.FoodEntity;
import Module.WeddingManagement.Repository.Entity.HallEntity;
import Module.WeddingManagement.Repository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class HallRepository implements IHallRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public Hall Find(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            HallEntity hallEntity = session.get(HallEntity.class, id);
            return toHall(hallEntity);
        }
    }

    private Hall toHall(HallEntity entity)
    {
        Hall hall = new Hall(entity.getHallId(), entity.getName(), entity.getPrice(), entity.getType(), entity.getNote());
        return hall;
    }

    @Override
    public List<Hall> FindAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            Query<HallEntity> query = session.createQuery("FROM HallEntity");
            List<HallEntity> list= query.list();

            if (list.isEmpty())
                return null;
            List<Hall> result = new ArrayList<>();
            for (HallEntity i : list)
            {
                result.add(toHall(i));
            }
            return result;
        }
    }

    @Override
    public void Persist(Hall hall) {
        HallEntity hallEntity = new HallEntity();
        hallEntity.setName(hall.getName());
        hallEntity.setPrice(hall.getPrice());
        hallEntity.setNote(hall.getNote());
        hallEntity.setType(hall.getType());
    }

    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

}
