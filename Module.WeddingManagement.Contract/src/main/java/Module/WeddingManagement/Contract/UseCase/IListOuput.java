package Module.WeddingManagement.Contract.UseCase;

import java.util.List;

public interface IListOuput<T> {
    void OnResponse(List<T> items);
}
