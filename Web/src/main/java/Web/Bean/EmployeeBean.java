package Web.Bean;


import Module.WeddingManagement.ApplicationModel.Employee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class EmployeeBean {
    private List<Employee> listEmployee;

    public EmployeeBean(){
    }
}
