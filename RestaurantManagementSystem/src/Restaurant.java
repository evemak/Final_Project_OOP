import java.util.ArrayList;

public class Restaurant {
    private String name;
    private Menu menu;                     // Has-A Menu
    private Inventory inventory;           // Has-A Inventory
    private ArrayList<String> reviews;     // List of customer reviews

    // Constructor
    public Restaurant(String name, Menu menu, Inventory inventory) {
        this.name = name;
        this.menu = menu;
        this.inventory = inventory;
        this.reviews = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    // Add a review
    public void addReview(String review) {
        reviews.add(review);
    }

    // Staff operations
    public void addItemToMenu(MenuItem item) {
        menu.addItem(item);
    }

    public void updateInventory(MenuItem item, int quantity) {
        inventory.updateQuantity(item, quantity);
    }

    public Bill generateBill(Customer customer) {
        return new Bill(customer.getOrderItems());
    }
}
