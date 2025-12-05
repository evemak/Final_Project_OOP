import java.util.ArrayList;

public class Restaurant {
    private String name;
    private Menu menu;
    private ArrayList<Inventory> inventoryList;
    private ArrayList<String> reviews;

    public Restaurant(String name, Menu menu) {
        this.name = name;
        this.menu = menu;
        this.inventoryList = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public void addInventory(Inventory inv) {
        inventoryList.add(inv);
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    // Getters 
    public String getName() { 
        return name; 
    } 
    
    public Menu getMenu() { 
        return menu; 
    } 
    
    public ArrayList<Inventory> getInventory() { 
        return inventoryList; 
    
    } public ArrayList<String> getReviews() { 
        return reviews; 
    }

    // Update specific item's inventory
    public void updateInventory(MenuItem item, int amount) {
        for (Inventory inv : inventoryList) {
            if (inv.getItem().equals(item)) {
                inv.setQuantity(amount);
                return;
            }
        }
    }

    public Bill generateBill(Customer customer) {
        return new Bill(customer); 
    }
}
