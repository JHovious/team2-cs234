public class Purchase {

    private String itemName;
    private String itemNumber;
    private float price;
    private String itemQuantity;
    private String removeQuantity;
    

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
        float subtotal = price * Float.parseFloat(itemQuantity);
        return subtotal;
    }

    /*
     * attempts to remove a given quantity from the current item quantity.
     * If the removal quantity is less than or equal to the current quantity then the item quantity is updated.
     * If the removal quanity is greater than the current quantity an error message is displayed.
     * @param String removeQuantity
     */

    public void removeItem(String removeQuantity) {
        int removeItemQuantity = Integer.parseInt(removeQuantity);
        int currentQuantity = Integer.parseInt(itemQuantity);
        if (removeItemQuantity <= currentQuantity) {
            int newQuantity = currentQuantity -removeItemQuantity;
            itemQuantity = String.valueOf(newQuantity);
            System.out.println("The item has been removed successfully. New quantity:" + itemQuantity);
        }

        else {
            System.out.println("Error. Cannot remove more items than available.");
        }
    }

    /*
     * Updates item quantity by adding a given quantity to the current item quantity.
     * If the result is negative, an error message is displayed and 0 is returned.
     * Otherwise, the item quantity is updated and returned as a short value
     * @param String newQuantity
     * @return short currentQuantity or 0 if update fails
     */

    public short updateItemQuantity(String newQuantity) {
        int currentQuantity = Integer.parseInt(this.itemQuantity);
        int quantityChange = Integer.parseInt(newQuantity);
        
        if (currentQuantity + quantityChange < 0) {
            System.out.println("Error. Cannot update quantity to a negative value.");
            return 0;
        } else {
            currentQuantity += quantityChange;
            this.itemQuantity = String.valueOf(currentQuantity);
            System.out.println("The item quantity has been updated.");
            return (short) currentQuantity;
        }
    }

}
