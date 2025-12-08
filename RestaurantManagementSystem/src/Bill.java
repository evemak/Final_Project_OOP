import java.util.ArrayList;
import java.util.List;

public class Bill {

    public enum OrderStatus {
        PREPARING,    // Order is being prepared
        SERVED,       // Order has been served to customer
        CANCELLED     // Order has been cancelled
    }

    private Customer customer;
    private List<MenuItem> items;
    private OrderStatus status;

    public Bill(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PREPARING;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double getTotal() {
        // If order is cancelled, total is 0
        if (status == OrderStatus.CANCELLED) {
            return 0.0;
        }
        
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean canBeCancelled() {
        // Order can only be cancelled if it's still being prepared (not yet served)
        return status == OrderStatus.PREPARING;
    }

    public boolean cancelOrder() {
        if (canBeCancelled()) {
            status = OrderStatus.CANCELLED;
            items.clear();  
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bill for " + " Customer with ID: " + customer.getCustomerId() + ")\n" +
               "Status: " + status + "\n" +
               "Total: $" + getTotal();
    }
}
