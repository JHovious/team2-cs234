public class Purchase {

    private String itemName;
    private String itemNumber;
    private float price;
    private String itemQuantity;
    private String removeQuantity;
    
    public Purchase(String itemName, String itemNumber, float price, String itemQuantity, String removeQuantity) {
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.price = price;
        this.itemQuantity = itemQuantity;
        this.removeQuantity = removeQuantity;

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
    /*
     * idk if i did this right.
     */
    public float getSubtotal() {
        float subtotal = price * Float.parseFloat(itemQuantity);
        return subtotal;
    }

    /*
     * changes the item quantity by the given amount.
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
     * updates the item quantity by the given amount 'new Quantity'.
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
