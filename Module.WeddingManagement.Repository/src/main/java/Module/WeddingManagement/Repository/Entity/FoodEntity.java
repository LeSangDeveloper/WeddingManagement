package Module.WeddingManagement.Repository.Entity;

import Module.WeddingManagement.ApplicationModel.Food;
import Module.WeddingManagement.ApplicationModel.Menu;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Foods")
@NamedQueries({
        @NamedQuery(name = HallEntity.QUERY_FIND_ALL_HALLS, query = "SELECT i from HallEntity i where i.hallId = :hallId"),
        @NamedQuery(name = HallEntity.QUERY_FIND_BY_ID, query =  "SELECT i from HallEntity i")
})
public class FoodEntity {
    public static final String QUERY_FIND_ALL_HALLS = "HallEntity.FindAll";
    public static final String QUERY_FIND_BY_ID = "HallEntity.FindById";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long FoodId;

    @Basic
    private String name;
    @Basic
    private double price;
    @Basic
    private String note;
    @Basic
    private Food.FoodType type;

    @ManyToMany(mappedBy = "foods")
    private List<MenuEntity> inMenus;

    public List<MenuEntity> getInMenus() {
        return inMenus;
    }

    public long getFoodId() {
        return FoodId;
    }

    public void setFoodId(long foodId) {
        FoodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
