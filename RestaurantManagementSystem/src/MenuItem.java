public class MenuItem {
    private String name;
    private double price;
    private boolean available;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.available = true; // items are available by default
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
