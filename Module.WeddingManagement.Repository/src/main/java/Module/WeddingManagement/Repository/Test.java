package Module.WeddingManagement.Repository;

import Module.WeddingManagement.ApplicationModel.Employee;
import org.hibernate.Session;

import org.hibernate.Query;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("Test");
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            Query<Employee> sessionQuery = session.createQuery("FROM Service");

            List<Employee> employees = sessionQuery.list();

            if (employees.size() <= 0)
            {
                System.out.println("rong");
            }

        }
        System.out.println("Test finish");
    }
}
