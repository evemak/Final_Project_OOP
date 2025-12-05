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

    // Mark item as sold out (unavailable)
    public boolean markItemAsSoldOut(String itemName) {
        MenuItem item = findItemByName(itemName);
        if (item != null) {
            item.setAvailable(false);
            return true;
        }
        return false;
    }

    // Mark item as available
    public boolean markItemAsAvailable(String itemName) {
        MenuItem item = findItemByName(itemName);
        if (item != null) {
            item.setAvailable(true);
            return true;
        }
        return false;
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
