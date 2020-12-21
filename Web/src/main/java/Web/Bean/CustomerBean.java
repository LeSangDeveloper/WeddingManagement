package Web.Bean;

import Module.WeddingManagement.ApplicationModel.Customer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class CustomerBean {
    private List<Customer> listCustomer;

    public CustomerBean(){
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }
}
