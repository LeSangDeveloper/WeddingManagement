package Module.WeddingManagement.Contract.UseCase;

public interface IList<T> {
    void ListItems(IListOuput listOuput);
    void SetRepository(T repository);
}
