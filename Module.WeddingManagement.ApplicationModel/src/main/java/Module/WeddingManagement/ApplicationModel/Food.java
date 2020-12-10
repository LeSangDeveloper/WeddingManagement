package Module.WeddingManagement.ApplicationModel;

import java.math.BigDecimal;
import java.util.Set;

public class Food extends AbstractModel {

    private int id;
    private String name;
    private BigDecimal price;
    private String note;
    private FoodType type;

    public Food(int id, String name, BigDecimal price, String note, FoodType type) {
        this.name = name;
        this.price = price;
        this.note = note;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public enum FoodType
    {
        Appertizers,
        Soup,
        Salad,
        Entree,
        Dessert
    }

}
