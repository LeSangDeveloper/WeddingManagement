package Module.WeddingManagement.ApplicationModel;

import java.util.Date;
import java.util.List;

public class Booking extends AbstractModel {

    private int id;
    private Customer customer;
    private Employee employee;
    private Menu menu;
    private Hall hall;
    private List<Service> services;
    private Date createdAt;
    private Date dateOfPayment;
    private int tables;
    private ShiftType shift;
    private String note;
    private double price;

    public Booking(int id, Customer customer, Employee employee, Menu menu, Hall hall, List<Service> services, Date createdAt, Date dateOfPayment, int tables, ShiftType shift, String note, double price) {
        this.id = id;
        this.customer = customer;
        this.employee = employee;
        this.menu = menu;
        this.hall = hall;
        this.services = services;
        this.createdAt = createdAt;
        this.dateOfPayment = dateOfPayment;
        this.tables = tables;
        this.shift = shift;
        this.note = note;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public int getTables() {
        return tables;
    }

    public void setTables(int tables) {
        this.tables = tables;
    }

    public ShiftType getShift() {
        return shift;
    }

    public void setShift(ShiftType shift) {
        this.shift = shift;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
