package Module.WeddingManagement.Repository;

import Module.WeddingManagement.ApplicationModel.*;

public class DBContext {

    private static RepositoryGeneric<Booking> bookings;
    private static RepositoryGeneric<Customer> customers;
    private static RepositoryGeneric<Employee> employees;
    private static RepositoryGeneric<Food> foods;
    private static RepositoryGeneric<Hall> halls;
    private static RepositoryGeneric<Menu> menus;
    private static RepositoryGeneric<Service> services;
    private static RepositoryGeneric<Order> orders;

    static {
        customers = new RepositoryGeneric<Customer>(Customer.class);
        employees = new RepositoryGeneric<Employee>(Employee.class);
        bookings = new RepositoryGeneric<Booking>(Booking.class);
        foods = new RepositoryGeneric<Food>(Food.class);
        halls = new RepositoryGeneric<Hall>(Hall.class);
        menus = new RepositoryGeneric<Menu>(Menu.class);
        services = new RepositoryGeneric<Service>(Service.class);
        orders = new RepositoryGeneric<Order>(Order.class);
    }

    public static RepositoryGeneric<Order> getOrders() {
        return orders;
    }

    public static void setOrders(RepositoryGeneric<Order> orders) {
        DBContext.orders = orders;
    }

    public static RepositoryGeneric<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(RepositoryGeneric<Customer> customers) {
        DBContext.customers = customers;
    }

    public static RepositoryGeneric<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(RepositoryGeneric<Employee> employees) {
        DBContext.employees = employees;
    }

    public static RepositoryGeneric<Booking> getBookings() {
        return bookings;
    }

    public static void setBookings(RepositoryGeneric<Booking> bookings) {
        DBContext.bookings = bookings;
    }

    public static RepositoryGeneric<Food> getFoods() {
        return foods;
    }

    public static void setFoods(RepositoryGeneric<Food> foods) {
        DBContext.foods = foods;
    }

    public static RepositoryGeneric<Hall> getHalls() {
        return halls;
    }

    public static void setHalls(RepositoryGeneric<Hall> halls) {
        DBContext.halls = halls;
    }

    public static RepositoryGeneric<Menu> getMenus() {
        return menus;
    }

    public static void setMenus(RepositoryGeneric<Menu> menus) {
        DBContext.menus = menus;
    }

    public static RepositoryGeneric<Service> getServices() {
        return services;
    }

    public static void setServices(RepositoryGeneric<Service> services) {
        DBContext.services = services;
    }

}
