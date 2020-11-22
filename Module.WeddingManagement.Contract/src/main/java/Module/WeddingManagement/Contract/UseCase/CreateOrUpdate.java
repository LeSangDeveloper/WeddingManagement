package Module.WeddingManagement.Contract.UseCase;

public interface CreateOrUpdate <T> {
    void CreateOrUpdate(T item);
    void SetItemRepository(T item);
}
