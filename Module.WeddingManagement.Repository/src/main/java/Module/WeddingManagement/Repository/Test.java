package Module.WeddingManagement.Repository;

import Module.WeddingManagement.ApplicationModel.Customer;
import Module.WeddingManagement.ApplicationModel.Employee;
import org.hibernate.Session;

import org.hibernate.Query;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Employee> entities = DBContext.getEmployees().FindAll();
        for (Employee entity : entities) {
            System.out.println(entity.getId() + " " + entity.getFullName() + " " + entity.getTitle());
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
    }
}
