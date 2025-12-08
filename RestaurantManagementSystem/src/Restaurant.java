import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {
    private String name;
    private Menu menu;
    private ArrayList<Inventory> inventoryList;
    private ArrayList<String> reviews;
    private HashMap<Integer, Bill> customerBills; 

    public Restaurant(String name, Menu menu) {
        this.name = name;
        this.menu = menu;
        this.inventoryList = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.customerBills = new HashMap<>();
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

    public Inventory findInventoryByItem(MenuItem item) {
    for (Inventory inv : inventoryList) {
        if (inv.getItem().getName().equalsIgnoreCase(item.getName())) {
            return inv;
        }
    }
    return null; 
}

    public Bill generateBill(Customer customer) {
        return new Bill(customer); 
    }

    // Register a customer's bill
    public void registerCustomerBill(int customerId, Bill bill) {
        customerBills.put(customerId, bill);
    }

    // Find a bill by customer ID
    public Bill findBillByCustomerId(int customerId) {
        return customerBills.get(customerId);
    }
}
