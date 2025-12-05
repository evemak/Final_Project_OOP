public class Main {
    public static void main(String[] args) {

        // Create Menu Items
        MenuItem burger = new MenuItem("Burger", 8.99);
        MenuItem fries = new MenuItem("Fries", 3.49);
        MenuItem soda = new MenuItem("Soda", 1.99);

        // Create Menu
        Menu menu = new Menu();
        menu.addItem(burger);
        menu.addItem(fries);
        menu.addItem(soda);

        // Set up Inventory
        Inventory invBurger = new Inventory(burger, 10);
        Inventory invFries = new Inventory(fries, 20);
        Inventory invSoda = new Inventory(soda, 30);

        // Create Restaurant
        Restaurant restaurant = new Restaurant("My Cafe", menu);
        restaurant.addInventory(invBurger);
        restaurant.addInventory(invFries);
        restaurant.addInventory(invSoda);

        // Create Customer 
        Customer customer = new Customer(101);

        // Customer Bill
        Bill bill = new Bill(customer);

        bill.addItem(burger);
        bill.addItem(fries);
        bill.addItem(soda);

        // Print Results
        System.out.println("===== Restaurant System Test =====");
        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("\nMenu:");
        for (MenuItem item : menu.getItems()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }

        System.out.println("\nCustomer Bill:");
        for (MenuItem item : bill.getItems()) {
            System.out.println("- " + item.getName());
        }

        System.out.println("\nTotal: $" + bill.getTotal());
        System.out.println("\nInventory Example:");
        System.out.println(invBurger);
        System.out.println(invFries);
        System.out.println(invSoda);

    }
}
