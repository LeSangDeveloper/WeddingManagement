package Module.WeddingManagement.ApplicationModel;

public class Employee extends AbstractModel {

    private int employeeId;
    private String title;
    private String fullName;
    private String username;
    private String password;

    public Employee(String title, String fullName, String username, String password) {
        this.title = title;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public int GetEmployeeId()
    {
        return this.employeeId;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getFullName()
    {
        return this.fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getUserName()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}