package Module.WeddingManagement.Repository.Repository;

import Module.WeddingManagement.ApplicationModel.Employee;
import Module.WeddingManagement.ApplicationModel.Hall;
import Module.WeddingManagement.Contract.Repository.IHallRepository;
import Module.WeddingManagement.Repository.Entity.EmployeeEntity;
import Module.WeddingManagement.Repository.Entity.HallEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class HallRepository implements IHallRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public Hall Find(int id) {
        List<HallEntity> list = entityManager.createNamedQuery(HallEntity.QUERY_FIND_BY_ID, HallEntity.class)
                .setParameter("employeeId", id).getResultList();
        if (list.isEmpty())
            return null;

        HallEntity HallEntity = list.get(0);
        return  toHall(HallEntity);
    }

    private Hall toHall(HallEntity entity)
    {
        Hall hall = new Hall(entity.getName(), entity.getPrice(), entity.getType(), entity.getNote());
        return hall;
    }

    @Override
    public List<Hall> FindAll() {
        List<HallEntity> list = entityManager.createNamedQuery(HallEntity.QUERY_FIND_BY_ID, HallEntity.class)
                .getResultList();
        if (list.isEmpty())
            return null;
        List<Hall> result = new ArrayList<>();
        for (HallEntity i : list)
        {
            result.add(toHall(i));
        }
        return result;
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
