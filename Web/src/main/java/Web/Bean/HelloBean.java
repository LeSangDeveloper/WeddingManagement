package Web.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@ManagedBean
@Named(value = "helloBean")
@RequestScoped
public class HelloBean {

    private String message = "Welcome to our Website";

    public String getMessage() {
        return message;
    }
}
