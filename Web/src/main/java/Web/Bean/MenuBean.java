package Web.Bean;
import Module.WeddingManagement.ApplicationModel.Menu;
import Module.WeddingManagement.UseCase.ListMenu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class MenuBean {
    private List<Menu> listMenu ;

    public MenuBean(){
        listMenu = (new ListMenu()).GetList();
        System.out.println("MenuBean called");
    }

    public List<Menu> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<Menu> listMenu) {
        this.listMenu = listMenu;
    }
}
