package Module.WeddingManagement.ApplicationModel;

import java.util.Date;

public class Menu extends AbstractModel {
    private int menuId;
    private Date createdAt;

    public Menu(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getMenuId() {
        return menuId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
