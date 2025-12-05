import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    // Find menu item by name
    public MenuItem findItemByName(String name) {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    // Remove item from menu
    public boolean removeItem(String itemName) {
        MenuItem item = findItemByName(itemName);
        if (item != null) {
            items.remove(item);
            return true;
        }
        return false;
    }
}
