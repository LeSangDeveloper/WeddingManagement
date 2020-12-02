package Module.WeddingManagement.ApplicationModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Menu extends AbstractModel {

    private Date createdAt;
    private List<Food> foods;

    public Menu(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
