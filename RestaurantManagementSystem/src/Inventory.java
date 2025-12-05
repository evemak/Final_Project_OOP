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

    public void increaseStock(int amount) {
        quantity += amount;
    }

    public void decreaseStock(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        }
    }

    public boolean isInStock() {
        return quantity > 0;
    }

    public boolean isSoldOut() {
        return quantity == 0;
    }

    @Override
    public String toString() {
        return item.getName() + " - Quantity: " + quantity;
    }
}
