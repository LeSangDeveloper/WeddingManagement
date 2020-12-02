package Module.WeddingManagement.Repository.Entity;

import Module.WeddingManagement.ApplicationModel.Menu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Menus")
public class MenuEntity {
    public static final String QUERY_FIND_ALL_HALLS = "HallEntity.FindAll";
    public static final String QUERY_FIND_BY_ID = "HallEntity.FindById";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuId;

    @Basic
    private Date createdAt;

    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(
        name = "menu_food",
            joinColumns = {
                @JoinColumn(name = "menu_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "food_id")
            }
    )
    private List<FoodEntity> foods;

    public void AddFood(FoodEntity food)
    {
        foods.add(food);
        food.getInMenus().add(this);
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void RemoveFood(FoodEntity food)
    {
        foods.remove(food);
        food.getInMenus().remove(this);

    }

    public List<FoodEntity> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodEntity> foods) {
        this.foods = foods;
    }
}
