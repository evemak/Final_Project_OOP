import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Initialize restaurant
        Menu menu = new Menu();
        Restaurant restaurant = new Restaurant("Test Restaurant", menu);

        // Actor selection 
        while (true){
            System.out.println("Are you a (C)ustomer or (S)taff? Enter 'X' to exit the program.");
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
                continue;
                
            } 
            // Customer actions
            else if (role.equals("C")) {
                System.out.println("\nWelcome Customer to " + restaurant.getName() + "!");
                System.out.print("Please enter your customer ID: ");
                int customerId = Integer.parseInt(scanner.nextLine());
    
                Customer customer = new Customer(customerId);
                Bill bill = new Bill(customer);
    
                boolean customerRunning = true;
                while (customerRunning) {
                    System.out.println("\nCUSTOMER ACTIONS MENU");
                    System.out.println("1. View menu");
                    System.out.println("2. Place order");
                    System.out.println("3. View current bill");
                    System.out.println("4. Leave a review");
                    System.out.println("5. Exit");
                    System.out.print("\nChoose an option: ");
    
                    String choice = scanner.nextLine().trim();
    
                    switch (choice) {
                        case "1":
                            System.out.println("\n~~~VIEWING CURRENT MENU~~~");
                            if (menu.getItems().isEmpty()) {
                                System.out.println("Menu is empty.");
                            } else {
                                for (MenuItem item : menu.getItems()) {
                                    Inventory inv = restaurant.findInventoryByItem(item);
                                    if (inv != null && inv.getQuantity() > 0) {
                                        System.out.println(item.getName() + " - $" + item.getPrice() + " (Available: " + inv.getQuantity() + ")");
                                    }
                                }
                            }
                            break;
    
                        // Place order
                        case "2":
                            System.out.println("\n~~~PLACE AN ORDER~~~");
                            if (menu.getItems().isEmpty()) {
                                System.out.println("Menu is empty. Please ask staff to add items.");
                                break;
                            }
                            for (MenuItem item : menu.getItems()) {
                                System.out.println(item.getName() + " - $" + item.getPrice());
                            }
                            while(true){
                                System.out.print("Enter item name: ");
                                String orderItemName = scanner.nextLine();
                                MenuItem orderItem = menu.findItemByName(orderItemName);
        
                                if (orderItem == null) {
                                    System.out.println("Item not found on the menu.");
                                    break;
                                }
        
                                Inventory orderInv = restaurant.findInventoryByItem(orderItem);
                                if (orderInv == null || orderInv.getQuantity() <= 0) {
                                    System.out.println("Sorry, that item is out of stock.");
                                    break;
                                }
        
                                System.out.print("Enter quantity: ");
                                int orderQuantity = Integer.parseInt(scanner.nextLine());
        
                                if (orderQuantity <= 0) {
                                    System.out.println("Quantity must be at least 1.");
                                    break;
                                }
        
                                if (orderInv.getQuantity() < orderQuantity) {
                                    System.out.println("Not enough stock. Available: " + orderInv.getQuantity());
                                    break;
                                }
        
                                for (int i = 0; i < orderQuantity; i++) {
                                    bill.addItem(orderItem);
                                }
                                orderInv.decreaseStock(orderQuantity);
                                if (orderInv.getQuantity() == 0) {
                                    orderItem.setAvailable(false);
                                    menu.removeItem(orderItemName);
                                    restaurant.getInventory().remove(orderInv);
                                }
                                System.out.println("Added " + orderQuantity + " x " + orderItem.getName() + " to your order.");
                                System.out.println("Would you like to add another item? (Y)es or (N)o");
                                String add_again = scanner.nextLine();
                                if( add_again.equals("Y")){continue;}
                                break;

                            }
    
                        // View current bill
                        case "3":
                            System.out.println("\n~~~CURRENT BILL~~~");
                            if (bill.getItems().isEmpty()) {
                                System.out.println("No items ordered yet.");
                            } else {
                                for (MenuItem item : bill.getItems()) {
                                    System.out.println("  - " + item.getName() + ": $" + item.getPrice());
                                }
                                System.out.println("Total: $" + bill.getTotal());
                            }
                            break;
    
                        // Leave a review
                        case "4":
                            System.out.print("\nPlease leave your review: ");
                            String review = scanner.nextLine();
                            restaurant.addReview(review);
                            System.out.println("Received!");
                            break;
    
                        // Exit program
                        case "5":
                            System.out.println("~~~EXITED CUSTOMER MENU~~~");
                            customerRunning = false;
                            break;
    
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
                continue;
    
    
            } 

            else if (role.equals("X")) {
                break;
            }
            
            else {
                System.out.println("Invalid role. Please enter 'C' for Customer or 'S' for Staff.");
            }
            scanner.close();
        }
        
    }
}
