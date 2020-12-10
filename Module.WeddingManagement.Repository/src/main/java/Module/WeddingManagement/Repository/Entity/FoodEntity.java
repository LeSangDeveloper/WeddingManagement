package Module.WeddingManagement.Repository.Entity;

import Module.WeddingManagement.ApplicationModel.Food;
import Module.WeddingManagement.ApplicationModel.Menu;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "food")
public class FoodEntity {
    public static final String QUERY_FIND_ALL_HALLS = "HallEntity.FindAll";
    public static final String QUERY_FIND_BY_ID = "HallEntity.FindById";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String name;
    @Basic
    private BigDecimal price;
    @Basic
    private String note;
    @Basic
    private Food.FoodType type;

    @ManyToMany(mappedBy = "foods")
    private List<MenuEntity> inMenus;

    public List<MenuEntity> getInMenus() {
        return inMenus;
    }

    public int getFoodId() {
        return id;
    }

    public void setFoodId(int foodId) {
        id = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Food.FoodType getType() {
        return type;
    }

    public void setType(Food.FoodType type) {
        this.type = type;
    }

}
