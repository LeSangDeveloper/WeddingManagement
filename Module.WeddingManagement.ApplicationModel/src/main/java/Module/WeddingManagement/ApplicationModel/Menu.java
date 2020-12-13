package Module.WeddingManagement.ApplicationModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Menu extends AbstractModel {

    private int id;
    private Date createdAt;
    private Set<Food> foods;

    public Menu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
