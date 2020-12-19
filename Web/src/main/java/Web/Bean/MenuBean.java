package Web.Bean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@ManagedBean
@Named(value = "Menu")
@RequestScoped
public class MenuBean implements Serializable {

}
