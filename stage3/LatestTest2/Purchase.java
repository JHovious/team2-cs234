/*
 * Author: maya fisher
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;


public class Purchase {

    private String itemName;
    private String itemNumber;
    private float price;
    private String itemQuantity;
    private String removeQuantity;
    private Inventory inventory;
    private Payment payment;
    private Rewards rewards;
    private ArrayList<InventoryDB> cart;
    private float subtotal;
    private HashMap<Integer,InventoryDB> items;

    

    /*
     * constructor 
     * @param String itemName, String itemNumber, float price, String itemQuantity, String removeQuantity
     */
    public Purchase(String itemName, String itemNumber, float price, String itemQuantity, String removeQuantity) {
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.price = price;
        this.itemQuantity = itemQuantity;
        this.removeQuantity = removeQuantity;
        this.inventory =  new Inventory();
        this.payment = payment;
        this.rewards = new Rewards("", (short)0, (short)100, new LinkedList<>()); 
        this.cart = new ArrayList<>();
        this.subtotal = 0;

        
    
    }

    public void getInventoryItems(Integer itemNumber) {
        InventoryDB item = inventory.getItems().get(itemNumber);
        if(item != null) {
            System.out.println("Item Name: " + item.getName());
            System.out.println("Item Details: " + item.getDetails());
            System.out.println("Item Price: " + item.getPrice());
            System.out.println("Item Quantity: " + item.getQuantity());
            System.out.println("Item Location: " + item.getLocation());
        }
        else {
            System.out.println("item not found in inventory");
        }

       
    }


    /*
     * Returns the name of the item.
     * @return String itemName
     */
    public String getItem() {
        return itemName;
    }
    /*
     * Prints the details of the item, including the item name, item number, price, and quantity.
     */
    public void showItem() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Number: " + itemNumber);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + itemQuantity);
    }
    /*
     * calculates the subtotal by multiplying the price of the item by the quantity. 
     * The itemQuantity is converted from a string to a float for the calculation.
     * @return float subtotal
     */
    public float getSubtotal() {
        return subtotal;
    }

    /*
     * attempts to remove a given quantity from the current item quantity.
     * If the removal quantity is less than or equal to the current quantity then the item quantity is updated.
     * If the removal quanity is greater than the current quantity an error message is displayed.
     * @param String removeQuantity
     */

    public void removeItemQuantity(int itemNumber, int removeQuantity) {
        InventoryDB item = inventory.getItems().get(itemNumber);
        if(item != null) {
            int currentQuantity = item.getQuantity();
            if (removeQuantity <= currentQuantity) {
                int newQuantity = currentQuantity - removeQuantity;
                item.setQuantity(newQuantity);
                System.out.println("The item has been removed successfully. New quantity: " + newQuantity);
            } else {
                System.out.println("Error. Cannot remove more items than available.");
            }
        } else {
            System.out.println("Item not found in inventory.");

        }
        
    }

    /*
     * Updates item quantity by adding a given quantity to the current item quantity.
     * If the result is negative, an error message is displayed and 0 is returned.
     * Otherwise, the item quantity is updated and returned as a short value
     * @param String newQuantity
     * @return short currentQuantity or 0 if update fails
     */

public short updateItemQuantity(int itemNumber, String newQuantity) {
    InventoryDB item = inventory.getItems().get(itemNumber);
    if (item != null) {
        int currentQuantity = item.getQuantity();
        int quantityChange = Integer.parseInt(newQuantity);

        if (currentQuantity + quantityChange < 0) {
            System.out.println("Error. Cannot update quantity to a negative value.");
            return 0;
        } else {
            currentQuantity += quantityChange;
            item.setQuantity(currentQuantity);
            System.out.println("The item quantity has been updated. New quantity: " + currentQuantity);
            return (short) currentQuantity;
        }
    } else {
        System.out.println("Item not found in inventory.");
        return 0;
    }
}

public void checkout() {
    Scanner scanner = new Scanner(System.in);
    int itemNumber;
    int quantity;
    subtotal = 0;

    while (true) { 
        System.out.println("Enter item number to add to cart (1,2,3 for demonstration purposes)(or 0 to finish): ");
        itemNumber = scanner.nextInt();

        if(itemNumber == 0) {
            break;
        }

        InventoryDB item = inventory.getItems().get(itemNumber);
        if(item != null) {
            // Display item details
            System.out.println("Item Name: " + item.getName());
            System.out.println("Item Number: " + itemNumber);
            System.out.println("Item Price: $" + item.getPrice());
            System.out.println("Item Quantity: " + item.getQuantity());

            System.out.println("Enter quantity: ");
            quantity = scanner.nextInt();

            if(quantity <= item.getQuantity()) {
                cart.add(item);
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


public void processPayment(float total, String paymentType, String customerLookup, String rewardsLookup, float tax) {
    payment = new Payment(total, paymentType, customerLookup, rewardsLookup, tax);

   if (payment.verifyPayment(paymentType)) {
        payment.getPayment();
        String transactionNumber = payment.generateTransactionNumber();
        payment.storeTransactionNumber(transactionNumber);
        System.out.println("Payment processed successfully.");
    } else {
        System.out.println("Invalid payment type. Please try again.");
    }


} 
}
