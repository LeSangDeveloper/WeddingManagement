package Web.Bean;

import Module.WeddingManagement.ApplicationModel.*;
import Module.WeddingManagement.Repository.DBContext;
import Module.WeddingManagement.UseCase.CreateBooking;
import Module.WeddingManagement.UseCase.ListBooking;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TestCallData {

    public static void main(String[] args) {
        System.out.println("vo create booking");
        Employee employee = DBContext.getEmployees().Find(1);
        Customer customer = DBContext.getCustomers().Find(1);
        Hall hall = DBContext.getHalls().Find(1);
        ShiftType shift = ShiftType.Afternoon;
        Menu menu = DBContext.getMenus().Find(1);
        BigDecimal price = new BigDecimal(1000000);
        Date WeddingDate = new Date();
        Food food = DBContext.getFoods().Find(1);
        Set<Food> fds = new HashSet<>();
        fds.add(food);
        CreateBookingBean createBookingBean = new CreateBookingBean();
        Booking booking = new Booking();
        booking.setMenu(menu);
        booking.setCreatedAt(new Date());
        booking.setPrice(price);
        booking.setNote("ABC");
        booking.setTables(50);
        booking.setCustomer(customer);
        booking.setEmployee(employee);
        booking.setHall(hall);
        booking.setShift(shift);
        booking.setWeddingDate(WeddingDate);
        createBookingBean.setFds(fds);
        createBookingBean.setBooking(booking);

        System.out.println(createBookingBean.submit());
    }
}
