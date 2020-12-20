package Web.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@ManagedBean
@Named(value = "helloBean")
@RequestScoped
public class HelloBean {

    private String message = "Welcome to our Website";

    public HelloBean() {
    }

    public String getMessage() {
        System.out.println("Kyo mat lon");
        return message;
    }
}
