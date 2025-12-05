public class Inventory {

    private MenuItem item;
    private int quantity;

    public Inventory(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public void setItem(MenuItem item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // used for when customer orders
    public void decreaseStock(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        }
    }

    @Override
    public String toString() {
        return item.getName() + " - Quantity: " + quantity;
    }
}
