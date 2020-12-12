package Module.WeddingManagement.ApplicationModel;

public class Hall extends AbstractModel {

    private int id;
    private String name;
    private double price;
    private HallType type;
    private String note;

    public Hall() {

    }

    public Hall(int id, String name, double price, HallType type, String note) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.note = note;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public HallType getType() {
        return type;
    }

    public void setType(HallType type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
