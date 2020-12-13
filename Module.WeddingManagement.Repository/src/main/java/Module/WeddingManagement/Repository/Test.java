package Module.WeddingManagement.Repository;

import Module.WeddingManagement.ApplicationModel.*;
import org.hibernate.Session;

import org.hibernate.Query;

import java.math.BigDecimal;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Hall> entities = DBContext.getHalls().FindAll();
        for (Hall entity : entities) {
            System.out.println(entity.getId() + " " + entity.getPrice() + " " + entity.getType() + " " + entity.getName());
        }

        List<Menu> menus = DBContext.getMenus().FindAll();
        for (Menu menu : menus) {
            System.out.println(menu.getId());
            for (Food food : menu.getFoods()) {
                System.out.println(food.getName() + " " + food.getPrice());
            }
        }

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
