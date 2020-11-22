package Module.WeddingManagement.Contract.UseCase;

import java.util.List;

public interface ListItemsOutput <T> {
    void OnResponse(List<T> items);
}
