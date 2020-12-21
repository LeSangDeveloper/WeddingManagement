package Web.Bean;

import Module.WeddingManagement.ApplicationModel.Hall;
import Module.WeddingManagement.UseCase.ListHall;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "halls",eager = true)
@RequestScoped
public class HallBean {
    private List<Hall>listHall;

    public HallBean(){
        listHall = (new ListHall()).GetList();
        System.out.println("Hall Bean Calling");
        for(Hall hall : listHall){
            System.out.println(hall.getName());
        }
    }
    public String FindOne(){
        String result = "NULL";
        for(Hall hall : listHall){
            result = hall.getName();
            break;
        }
        return result;
    }

    public List<Hall> getListHall() {
        return listHall;
    }

    public void setListHall(List<Hall> listHall) {
        this.listHall = listHall;
    }
}
