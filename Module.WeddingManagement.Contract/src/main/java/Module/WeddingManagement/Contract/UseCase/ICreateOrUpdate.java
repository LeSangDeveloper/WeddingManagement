package Module.WeddingManagement.Contract.UseCase;

public interface ICreateOrUpdate<T> {
    void CreateOrUpdate(T item);
    void SetItemRepository(T item);
}
