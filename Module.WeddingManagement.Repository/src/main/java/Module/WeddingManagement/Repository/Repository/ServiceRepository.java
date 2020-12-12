package Module.WeddingManagement.Repository.Repository;

import Module.WeddingManagement.ApplicationModel.Employee;
import Module.WeddingManagement.ApplicationModel.Service;
import Module.WeddingManagement.Contract.Repository.IServiceRepository;
import Module.WeddingManagement.Repository.Entity.EmployeeEntity;
import Module.WeddingManagement.Repository.Entity.ServiceEntity;
import Module.WeddingManagement.Repository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository{

    @Override
    public Service Find(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            ServiceEntity serviceEntity = session.get(ServiceEntity.class, id);
            return toService(serviceEntity);
        }
    }

    private Service toService(ServiceEntity serviceEntity) {
        Service service = new Service(serviceEntity.getId(), serviceEntity.getPrice(), serviceEntity.getNote(), serviceEntity.getType());
        return service;
    }

    @Override
    public List<Service> FindAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            Query<ServiceEntity> query = session.createQuery("FROM ServiceEntity");
            List<ServiceEntity> list= query.list();

            if (list.isEmpty())
                return null;
            List<Service> result = new ArrayList<>();
            for (ServiceEntity i : list)
            {
                result.add(toService(i));
            }
            return result;
        }
    }

    public void Persist(Service service) {

    }

}