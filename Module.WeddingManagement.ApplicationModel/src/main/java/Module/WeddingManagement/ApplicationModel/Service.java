package Module.WeddingManagement.ApplicationModel;

public class Service extends AbstractModel {
    private int serviceId;
    private double price;
    private String note;
    private String type;

    public Service(double price, String note, String type) {
        this.price = price;
        this.note = note;
        this.type = type;
    }

    public int getServiceId() {
        return serviceId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}