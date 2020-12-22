package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Menu;
import Module.WeddingManagement.Contract.UseCase.IListOutput;
import Module.WeddingManagement.Repository.DBContext;

import java.util.List;

public class ListMenu implements IListOutput {

    @Override
    public List GetList() {
        List<Menu> menus = DBContext.getMenus().FindAll();
        return menus;
    }
}
