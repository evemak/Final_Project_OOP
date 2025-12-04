import java.util.ArrayList;

public class Restaurant {
    String name;
    Menu menu;
    ArrayList<String> reviews;
    Inventory Inventory;
    public Restaurant(String name, Menu menu, ArrayList<String> reviews){
        this.name = name;
        this.menu = menu;
        this.reviews = reviews;
    }
}
