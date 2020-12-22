package Module.WeddingManagement.Repository;

import Module.WeddingManagement.ApplicationModel.Customer;
import Module.WeddingManagement.Contract.Repository.IRepository;
import Module.WeddingManagement.Repository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RepositoryGeneric<T> implements IRepository<T> {

    private Class<T> entityType;

    public RepositoryGeneric(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public T Find(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            T result = session.get(entityType , id);
            return  result;
        }
    }

    @Override
    public List<T> FindAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            Query<T> query = session.createQuery("FROM " + entityType.getName());
            List<T> entities = query.list();
            if (entities.isEmpty())
                return null;

            return  entities;
        }
    }

    @Override
    public T Add(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.save(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public T Update(int id, T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.update(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public Boolean Delete(T entity){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            try {
                session.getTransaction().begin();
                session.delete(entity);
                session.getTransaction().commit();
            }catch (Exception exception){
                session.getTransaction().rollback();
                return false;
            }
        }
        return true;
    }

    @Override
    public void Persist(T t) {

    }
}

