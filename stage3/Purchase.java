/*
 * Author: maya fisher
 */
public class Purchase {

    private String itemName;
    private String itemNumber;
    private float price;
    private String itemQuantity;
    private String removeQuantity;
    private Inventory inventory;
    private Payment payment;
    

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

        // Initialize inventory with dummy data
        InventoryDB item1 = new InventoryDB();
        item1.getName();
        item1.getDetails();
        item1.getPrice();
        item1.getQuantity();
        item1.getLocation();

        inventory.getItems().put(1, item1);   
    
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
    public float getSubtotal(int itemNumber) {
        InventoryDB item = inventory.getItems().get(itemNumber);
        if(item != null) {
            float price = Float.parseFloat(item.getPrice());
            int itemQuantity = item.getQuantity();
            float subtotal = price * itemQuantity;
            return subtotal;
        }
        else {
            System.out.println("Item not found in inventory");
            return 0;
        }
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
}
