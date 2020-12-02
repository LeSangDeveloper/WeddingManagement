package Module.WeddingManagement.ApplicationModel;

import java.util.Set;

public class Food extends AbstractModel {

    private String name;
    private double price;
    private String note;
    private FoodType type;

    public Food(String name, double price, String note, FoodType type) {
        this.name = name;
        this.price = price;
        this.note = note;
        this.type = type;
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
