package Web.Bean;


import Module.WeddingManagement.ApplicationModel.*;
import Module.WeddingManagement.UseCase.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.awt.print.Book;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ManagedBean
@RequestScoped
public class CreateBookingBean {
    private Booking booking;
    private ShiftType shiftType;
    private Customer customer;
    private Employee employee;
    private Hall hll;
    private Set<Service> srvs;
    private Set<Food> fds;
    private Date weddingDate;

    private List<Customer> listCustomer;
    private List<Employee> listEmployees;
    private List<Hall> listHall;
    private List<Food> listFood;
    private List<Service> listService;

    public Set<Food> getFds() {
        return fds;
    }

    public void setFds(Set<Food> fds) {
        this.fds = fds;
    }

    public Date getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(Date weddingDate) {
        this.weddingDate = weddingDate;
    }

    public List<Service> getListService() {
        return listService;
    }

    public Hall getHll() {
        return hll;
    }

    public void setHll(Hall hll) {
        this.hll = hll;
    }

    public void setListService(List<Service> listService) {
        this.listService = listService;
    }

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
        listService = (new ListService()).GetList();
    }

    public String addBooking(){
        Booking booking = new Booking();
        booking.setCustomer(this.customer);
        booking.setEmployee(this.employee);
        booking.setServices(this.srvs);
        booking.setHall(this.hll);
        booking.setWeddingDate(this.weddingDate);
        booking.setCreatedAt(new Date());
        Menu menu = new Menu();
        menu.setFoods(this.fds);
        booking.setMenu(menu);
        return "Fail";
    }

    public Set<Service> getSrvs() {
        return srvs;
    }

    public void setSrvs(Set<Service> srvs) {
        this.srvs = srvs;
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
