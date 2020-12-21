package Web.Bean;

import Module.WeddingManagement.ApplicationModel.Hall;
import Module.WeddingManagement.ApplicationModel.Service;
import Module.WeddingManagement.UseCase.ListService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name="services",eager = true)
@RequestScoped
public class ServiceBean {
    private List<Service> listService;

    public ServiceBean(){
        listService = (new ListService()).GetList();
        System.out.println("ServiceBean called" + listService);
    }
    public String getFindOne(){
        String result = "NULL";
        for(Service service : listService){
            result = service.getNote();
            break;
        }
        System.out.println(result);
        return result;
    }

    public List<Service> getListService() {
        return listService;
    }

    public void setListService(List<Service> listService) {
        this.listService = listService;
    }
}
