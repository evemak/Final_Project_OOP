# Restaurant Management System (CLI)

A console app that manages a restaurant’s menu, inventory, and orders. Staff can add/update menu items, serve orders, and generate bills; customers can browse the menu, place orders, view their bill, and leave reviews.

## Features
- Staff: add menu items with inventory, view menu with quantities, update stock (removes items at 0), serve orders (prints a statement to the customer), generate bills by customer ID.
- Customers: view available items, place orders, see a bill total, and leave reviews.

## Run Locally
```bash
# from the project root
javac src/*.java
java -cp src Main
```
The app starts by asking for a role. Enter `C` for customer, `S` for staff, or `X` to exit. Both roles have their own action menus, and “Switch role” returns you to the role prompt without quitting the program.

## Flow
1) Staff adds menu items with quantities (Staff option 1).  
2) Customer enters their ID, views the menu, and places orders (Customer options 1–2).  
3) Staff serves the order (Staff option 4) by entering the customer ID; this marks the bill as `SERVED` and prints a statement with items and totals.  
4) Customer can check their bill at any time (Customer option 3) or leave a review (option 4).

## Notes
- Serving requires an existing bill with items for that customer ID; otherwise a warning is shown.
- When stock hits zero, the item is removed from the menu/inventory until restocked by staff.
- Bills are kept in memory only for the current run.