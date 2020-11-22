package Module.WeddingManagement.Contract.Repository;

import java.util.List;

public interface IRepository<T> {
    T Find(int Id);

    List<T> FindAll();

    void Persist(T t);
}
