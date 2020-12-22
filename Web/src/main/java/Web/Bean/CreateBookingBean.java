package Web.Bean;


import Module.WeddingManagement.ApplicationModel.Booking;
import Module.WeddingManagement.ApplicationModel.Customer;
import Module.WeddingManagement.ApplicationModel.Employee;
import Module.WeddingManagement.UseCase.CreateBooking;
import Module.WeddingManagement.UseCase.ListCustomer;
import Module.WeddingManagement.UseCase.ListEmployee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class CreateBookingBean {
    private Booking booking;
    private Customer customer;
    private Employee employee;
    private List<Customer> listCustomer;
    private List<Employee> listEmployees;

    public CreateBookingBean(){
        listCustomer = (new ListCustomer()).GetList();
        listEmployees = (new ListEmployee()).GetList();
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
