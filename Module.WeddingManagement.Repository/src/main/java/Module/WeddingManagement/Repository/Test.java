package Module.WeddingManagement.Repository;

import Module.WeddingManagement.ApplicationModel.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Session;

import org.hibernate.Query;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        Connection conn = null ;
//
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/WeddingManagement",
//                    "root","12345678");
//            System.out.println("Địt mẹ hibernate");
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }

//        Booking booking = DBContext.getBookings().Find(3);
//        Order order = new Order(booking,new Date(),new BigDecimal(100000));
//        DBContext.getOrders().Add(order);
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            Food food = new Food("A",new BigDecimal(10000),"a",FoodType.Salad);
            System.out.println(session.save(food).getClass().getName());
        }
//        List<Hall> entities = DBContext.getHalls().FindAll();
//        for (Hall entity : entities) {
//            System.out.println("------------------------------------------------ HALL ----------------------------------------------");
//            System.out.println(entity.getId() + " " + entity.getPrice() + " " + entity.getType() + " " + entity.getName() + " " + entity.getBookings());
//        }
//
//        List<Customer> customers = DBContext.getCustomers().FindAll();
//        for (Customer customer : customers) {
//            System.out.println("-------------------------------------------- Customer ----------------------------------------------");
//            System.out.println(customer.getId());
//            System.out.println(customer.getName());
//        }
//
//        List<Menu> menus = DBContext.getMenus().FindAll();
//        for (Menu menu : menus) {
//            System.out.println("-------------------------------------------- MENU ----------------------------------------------");
//            System.out.println(menu.getId());
//            for (Food food : menu.getFoods()) {
//                System.out.println(food.getName() + " " + food.getPrice());
//            }
//        }
//
//        List<Booking> bookings = DBContext.getBookings().FindAll();
//        for (Booking booking : bookings) {
//            System.out.println("-------------------------------------------- Booking --------------------------------------------");
//            System.out.println(booking.getCustomer());
//            System.out.println(booking.getPrice());
//            System.out.println(booking.getCreatedAt());
//            System.out.println(booking.getWeddingDate());
//            System.out.println(booking.getEmployee());
//            System.out.println(booking.getHall());
//            System.out.println(booking.getMenu());
//            System.out.println(booking.getServices());
//        }

//        Employee employee = new Employee();
//        employee.setFullName("Tri Quang");
//        employee.setTitle("Cu li");
//        employee.setUsername("quangncc");
//        employee.setPassword("123456");
//        DBContext.getEmployees().Add(employee);

//        Employee employee = new Employee();
//        employee.setId(2);
//        employee.setFullName("Tri Quang");
//        employee.setTitle("lao cong");
//        employee.setUsername("quangncc");
//        employee.setPassword("123456");
//        DBContext.getEmployees().Update(2, employee);

//        Food food = new Food();
//        food.setName("sushi");
//        food.setPrice(new BigDecimal(20.20));
//        food.setNote("fresh");
//        food.setType(FoodType.Appertizers);
//        DBContext.getFoods().Add(food);
    }
}
