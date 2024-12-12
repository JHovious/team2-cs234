import java.util.HashMap;
import java.util.Scanner;
/*
*Handles the purchase functionality of the system
* Author: Maya Fisher
*/
public class Purchase {

    private  String itemName;
    private  String itemNumber;
    private float price;
    private  String itemQuantity;
    private HashMap<Integer,InventoryDB> items;
    private HashMap <Integer, Integer>cart;
    private float subtotal;

   /*
    *Constructor intializing the items, cart hashmap, and subtotal.
    * @param HashMap<Integer,InventoryDB> items
    */
    public Purchase(HashMap<Integer,InventoryDB> items) {
        this.items = items; 
        this.cart = new HashMap<>();
        this.subtotal = 0;
    }
    
    /*
    *Used to select an item by item number from the hashmap. 
    * Displays the items information. If the item is not found null is returned
    * @param int itemNumber
    * @return item or null  
    */
    public InventoryDB selectItem(int itemNumber) {
        InventoryDB item = items.get(itemNumber);
        if (item != null) {
            System.out.println("You selected:");
            System.out.println("Name: " + item.getName());
            System.out.println("Price: $" + item.getPrice());
            System.out.println("Quantity Available: " + item.getQuantity());
            return item;
        } else {
            System.out.println("Invalid item number. Please try again.");
            return null;
        }
    }
    
    /*
    * gets an inventory item based off its item number and prints the items's information.
    * If the item is not found, a message is printed.
    * @param int itemNumber
    */
    public void getInventoryItems(int itemNumber) {
        InventoryDB item = items.get(itemNumber);
        if (item != null) {
            System.out.println("Item Name: " + item.getName());
            System.out.println("Item Details: " + item.getDetails());
            System.out.println("Item Price: " + item.getPrice());
            System.out.println("Item Quantity: " + item.getQuantity());
            System.out.println("Item Location: " + item.getLocation());
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    public String getItem() {
        return itemName;
    }
    
     
    public void showItem() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Number: " + itemNumber);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + itemQuantity);
    }

    public float getSubtotal() {
        return subtotal;
    }
     /*
      * Updates the item quantity in the inventory and the cart.
      * @param int itemNumber, String newQuantity
      */
    public void updateItemQuantity(int itemNumber, String newQuantity) {
        int newQuantityInt = Integer.parseInt(newQuantity);
        InventoryDB item = items.get(itemNumber);
        if(item == null) {
            System.out.println("Item not found in inventory.");
            return;
        }
        if(newQuantityInt < 0) {
            System.out.println("Error. Quantity cannot be negative.");
            return;

        }
         
        // checks if the item exists and retrieves the current quantity. If it does not exist returns the default value 0.
        int currentCartQuantity = cart.getOrDefault(itemNumber, 0);
        int currentStock = item.getQuantity();
        if(newQuantityInt > currentStock + currentCartQuantity) {
            System.out.println("Error. Not enough stock to add to cart.");
            return;
        }

        //updating inventory stock
        item.setQuantity(currentStock - newQuantityInt + currentCartQuantity);
        
        //updating cart
        if(newQuantityInt == 0) {
            cart.remove(itemNumber);
        }
        else {
            cart.put(itemNumber, newQuantityInt);
        }

        System.out.println("The item quantity has been updated in the cart. New cart quantity: " + newQuantity);
    }

    /*
     * Completes the checkout process by getting items added to cary and putting the item
     * quantity in the cart as well as updating the item quantity in the inventory.
     */
    public void checkout() {
        Scanner scanner = new Scanner(System.in);
        int itemNumber;
        int quantity;
        subtotal = 0;

        while (true) {

            showInventory();

            System.out.println("Enter item number to add to cart: ");
            itemNumber = scanner.nextInt();

            if (itemNumber == 0) {
                break;
            }

            InventoryDB item = selectItem(itemNumber);
            if (item != null) {
                System.out.println("Item Name: " + item.getName());
                System.out.println("Item Number: " + itemNumber);
                System.out.println("Item Price: $" + item.getPrice());
                System.out.println("Item Quantity: " + item.getQuantity());

                System.out.println("Enter quantity(put a - in front of the quantity): ");
                quantity = scanner.nextInt();

                if (quantity <= item.getQuantity()) {
                    cart.put(itemNumber, quantity);
                    subtotal += Float.parseFloat(item.getPrice()) * quantity;

                    updateItemQuantity(itemNumber, String.valueOf(-quantity));
                    System.out.println("Item added to cart.");
                } else {
                    System.out.println("Error. Not enough quantity in stock.");
                }
            } else {
                System.out.println("Item not found in inventory.");
            }
        }
        System.out.println("Checkout complete. Subtotal: $" + subtotal);
    }

    /*
     * proccesses the payment 
     * @param float total, String paymentType, String customerLookup, String rewardsLookup, float tax
     */
    public void processPayment(float total, String paymentType, String customerLookup, String rewardsLookup, float tax) {
        Payment payment = new Payment(total, paymentType, customerLookup, rewardsLookup, tax);

        if (payment.verifyPayment(paymentType)) {
            payment.getPayment();
            String transactionNumber = payment.generateTransactionNumber();
            payment.storeTransactionNumber(transactionNumber);
            System.out.println("Payment processed successfully.");
        } else {
            System.out.println("Invalid payment type. Please try again.");
        }
    }
    
    /*
     * Table for showing the inventory.
     */
    public void showInventory() {
        System.out.println("======== Inventory ========");
        System.out.println("Item # | Name       | Price | Quantity");

        for (Integer key : items.keySet()) {
            InventoryDB item = items.get(key);
            System.out.printf(
                "%-6d | %-15s | %-10.2f | %-10d%n",
                key,                        //Item number
                item.getName(),             
                Float.parseFloat(item.getPrice()), 
                item.getQuantity()          
            );
        }
    }
    
      public HashMap<Integer, InventoryDB> getItems() {
        return items;
    }
     
     public void setSubtotal(float subtotal) {
         this.subtotal = subtotal;
     
     }
     
     public float computeTax(float subtotal) {
         float tax = (float) (subtotal *1.05125);
         return tax;
         
     }
}