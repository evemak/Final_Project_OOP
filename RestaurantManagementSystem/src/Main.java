import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Initialize restaurant
        Menu menu = new Menu();
        Restaurant restaurant = new Restaurant("Test Restaurant", menu);

        // Actor selection 
        System.out.println("Are you a (C)ustomer or (S)taff? Enter 'C' for Customer and 'S' for Staff");
        String role = scanner.nextLine().trim().toUpperCase();

        // Staff actions
        if (role.equals("S")) {
            System.out.println("\nWelcome Staff Member to " + restaurant.getName() + "!");
            
            boolean staffRunning = true;
            while (staffRunning) {
                System.out.println("\nSTAFF ACTIONS MENU");
                System.out.println("1. Add item to menu + inventory");
                System.out.println("2. View menu");
                System.out.println("3. Update inventory quantity");
                System.out.println("4. Serve order");
                System.out.println("5. Generate bill");
                System.out.println("6. Exit");
                System.out.print("\nChoose an option: ");
                
                String choice = scanner.nextLine().trim();
                
                switch (choice) {
                    // Add item to menu + inventory
                    case "1":
                        System.out.println("\n~~~ADDING ITEM TO MENU + INVENTORY~~~");
                        System.out.print("Enter item name: ");
                        String invItemName = scanner.nextLine();
                        System.out.print("Enter item price: ");
                        double invItemPrice = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        
                        MenuItem invItem = new MenuItem(invItemName, invItemPrice);
                        Inventory inventory = new Inventory(invItem, quantity);
                        restaurant.addInventory(inventory);
                        menu.addItem(invItem);
                        System.out.println("Item added to menu and inventory successfully!");
                        break;

                    // View menu
                    case "2":
                        System.out.println("\n~~~VIEWING CURRENT MENU + INVENTORY~~~");
                        if (menu.getItems().isEmpty()) {
                            System.out.println("Menu is empty.");
                        } 
                        else {
                            for (MenuItem item : menu.getItems()) {
                                Inventory inv = restaurant.findInventoryByItem(item);

                                if (inv != null) {
                                    System.out.println(item.getName() + " - $" + item.getPrice() + " (Quantity: " + inv.getQuantity() + ")");
                                } else {
                                    System.out.println(item.getName() + " - $" + item.getPrice() + " (Quantity: 0)");
                                }                            
                                        
                            }
                        }
                        break;
                    // Update inventory quantity
                    case "3":
                        System.out.println("\n~~~UPDATE INVENTORY QUANTITY~~~");
                        System.out.print("Enter item name: ");
                        String updateItemName = scanner.nextLine();
                        MenuItem updateItem = menu.findItemByName(updateItemName);
                        
                        if (updateItem != null) {
                            Inventory updateInv = restaurant.findInventoryByItem(updateItem);
                            if (updateInv != null) {
                                System.out.println("Current quantity: " + updateInv.getQuantity());
                                System.out.print("Enter new quantity: ");
                                int newQuantity = Integer.parseInt(scanner.nextLine());
                                updateInv.setQuantity(newQuantity);
                                
                                // If quantity is 0, remove from menu
                                if (newQuantity == 0) {
                                    menu.removeItem(updateItemName);
                                    restaurant.getInventory().remove(updateInv);
                                    System.out.println("Item sold out - removed from menu and inventory!");
                                } else {
                                    System.out.println("Inventory updated successfully!");
                                }
                            } else {
                                System.out.println("Item not found in inventory.");
                            }
                        } else {
                            System.out.println("Item not found in menu.");
                        }
                        break;
                    
                    // Serve order
                    case "4":
                        System.out.println("\n~~~SERVING ORDER~~~");
                        System.out.println("Order has been prepared and served to the customer!");
                        System.out.println("~~~ORDER SERVED SUCCESSFULLY~~~");
                        break;
                        
                    // Generate bill
                    case "5":
                        System.out.print("Enter customer ID: ");
                        int customerId = Integer.parseInt(scanner.nextLine());
                        
                        Customer customer = new Customer(customerId);
                        Bill bill = restaurant.generateBill(customer);
                        
                        System.out.println("\n~~~BILL GENERATED~~~");
                        System.out.println(bill);
                        System.out.println("Items:");
                        for (MenuItem item : bill.getItems()) {
                            System.out.println("  - " + item.getName() + ": $" + item.getPrice());
                        }
                        break;
                        
                    // Exit program
                    case "6":
                        System.out.println("~~~EXITED STAFF MENU~~~");
                        staffRunning = false;
                        break;
                        
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
            
        } 
        // Customer actions
        else if (role.equals("C")) {
            System.out.println("\nWelcome Customer to" + restaurant.getName() + "!");
            // ADD HERE!!!


        } else {
            System.out.println("Invalid role. Please enter 'C' for Customer or 'S' for Staff.");
        }
        
        scanner.close();
    }
}
