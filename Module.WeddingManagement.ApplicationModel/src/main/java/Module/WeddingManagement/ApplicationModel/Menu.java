package Module.WeddingManagement.ApplicationModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Menu extends AbstractModel {
    private int menuId;
    private Date createdAt;
    private List<MenuFood> foods = new ArrayList<>();

    public Menu(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<MenuFood> getFoods() {
        return foods;
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
