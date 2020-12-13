package Module.WeddingManagement.Contract.Repository;

import java.util.List;

public interface IRepository<T> {
    T Find(int Id);

    List<T> FindAll();

    T Add(T entity);

    T Update(int id, T entity);

    void Persist(T t);
}
