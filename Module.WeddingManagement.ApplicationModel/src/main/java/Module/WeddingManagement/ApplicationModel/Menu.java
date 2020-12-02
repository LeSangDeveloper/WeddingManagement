package Module.WeddingManagement.ApplicationModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Menu extends AbstractModel {

    private Date createdAt;

    public Menu(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
