package Web.Bean;


import Module.WeddingManagement.ApplicationModel.*;
import Module.WeddingManagement.Repository.DBContext;
import Module.WeddingManagement.Repository.HibernateUtil;
import Module.WeddingManagement.UseCase.*;
import org.hibernate.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ManagedBean
@Named(value = "createBookingBean")
@RequestScoped
public class CreateBookingBean implements Serializable {
    private Booking booking;
    private ShiftType shiftType;
    private Customer customer;
    private Employee employee;
    private Hall hll;
    private Set<Service> srvs;
    private Set<Food> fds;
    private Date weddingDate;

    private int customerId;
    private int employeeId;
    private int hallId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    private String stringShiftType;

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

    public String submit(){
        System.out.printf("Hall %d\n",hallId);
        System.out.println(this.weddingDate);
        //System.out.println("add Booking");
        if (stringShiftType == "Evening") {
            this.shiftType = ShiftType.Evening;
        }
        else
            this.shiftType = ShiftType.Afternoon;
        Booking booking = new Booking();
        booking.setCustomer(this.customer);
        System.out.println("Test customer " + this.customer);
        booking.setEmployee(this.employee);
        System.out.println(this.employee);
//        booking.setServices(this.srvs);
//        System.out.println(this.srvs);
        booking.setHall(this.hll);
        System.out.println(this.hll);
        booking.setWeddingDate(this.weddingDate);
        booking.setCreatedAt(new Date());
        Menu menu = CreateMenu();
        System.out.println(this.fds);
        booking.setMenu(menu);
        System.out.println(menu);
        booking.setShift(this.shiftType);
        booking.setTables(50);
        booking.setNote("ABC");
        booking.setPrice(new BigDecimal(2000000));
        CreateBooking createBooking = new CreateBooking(booking);
        //createBooking.Create();
        DBContext.getBookings().Add(booking);
        return "booking?faces-redirect=true";
    }

    public Menu CreateMenu()
    {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            session.getTransaction().begin();
            Menu menu = new Menu();
            menu.setCreatedAt(new Date());
            session.persist(menu);
            session.getTransaction().commit();
        }
        List<Menu> menus = DBContext.getMenus().FindAll();
        Menu menu = menus.get(menus.size() - 1);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            menu.setFoods(fds);
            session.saveOrUpdate(menu);
            session.getTransaction().commit();
        }
        return menu;
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

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
    }

    public String getStringShiftType() {
        return stringShiftType;
    }

    public void setStringShiftType(String stringShiftType) {
        this.stringShiftType = stringShiftType;
    }
}
