package Module.WeddingManagement.ApplicationModel;

public class MenuFood {
    private int foodId;
    private int menuId;

    public MenuFood(int foodId, int menuId) {
        this.foodId = foodId;
        this.menuId = menuId;
    }

    public int getFoodId() {
        return foodId;
    }

    public int getMenuId() {
        return menuId;
    }

}
