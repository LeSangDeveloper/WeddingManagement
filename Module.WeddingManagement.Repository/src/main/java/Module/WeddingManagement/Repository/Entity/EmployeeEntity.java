package Module.WeddingManagement.Repository.Entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = EmployeeEntity.QUERY_FIND_ALL_EMPLOYEES, query = "SELECT i from EmployeeEntity i where i.employeeId = :employeeId"),
        @NamedQuery(name = EmployeeEntity.QUERY_FIND_BY_ID, query =  "SELECT i from EmployeeEntity i")
})
public class EmployeeEntity {
    public static final String QUERY_FIND_ALL_EMPLOYEES = "EmployeeEntity.FindAll";
    public static final String QUERY_FIND_BY_ID = "EmployeeEntity.FindById";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String title;

    @Basic
    private String fullName;

    @Basic
    private String userName;

    @Basic
    private String password;

    public int getEmployeeId() {
        return id;
    }

    public void setEmployeeId(int employeeId) {
        id = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
