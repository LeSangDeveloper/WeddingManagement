package Web.Bean;


import Module.WeddingManagement.ApplicationModel.*;
import Module.WeddingManagement.UseCase.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class CreateBookingBean {
    private Booking booking;
    private ShiftType shiftType;
    private Customer customer;
    private Employee employee;
    private List<Customer> listCustomer;
    private List<Employee> listEmployees;
    private List<Hall> listHall;
    private List<Food> listFood;

    public ShiftType getShiftType() {
        return shiftType;
    }

    public List<Hall> getListHall() {
        return listHall;
    }

    public void setListHall(List<Hall> listHall) {
        this.listHall = listHall;
    }

    public CreateBookingBean(){
        listCustomer = (new ListCustomer()).GetList();
        listEmployees = (new ListEmployee()).GetList();
        listHall = (new ListHall()).GetList();
        listFood = (new ListFood()).GetList() ;
    }

    public String CreateBooking(){
        return "Lỗi";
    }

    public List<Food> getListFood() {
        return listFood;
    }

    public void setListFood(List<Food> listFood) {
        this.listFood = listFood;
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public static void main(String[] args) {
        List<Employee> emps = (new ListEmployee()).GetList();
        List<Customer> cus = (new ListCustomer()).GetList();
        System.out.println(emps);
        System.out.println(cus);


    }

    public List<Employee> getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(List<Employee> listEmployees) {
        this.listEmployees = listEmployees;
    }

    public void setListCustomer(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
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
}
