package Web.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@ManagedBean
@Named(value = "Route")
@RequestScoped
public class RouteBean {

    private String message = "Welcome to our Website";
    public String getCustomer(){
        return "customer";
    }

    public String getMessage() {
        return message;
    }
}
