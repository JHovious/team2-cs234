import java.util.ArrayList;
import java.util.Scanner;

public class Purchase {

    private final String itemName;
    private final String itemNumber;
    private final float price;
    private final String itemQuantity;
    private final Inventory inventory;
    private final ArrayList<InventoryDB> cart;
    private float subtotal;

    /*
     * Constructor
     * @param Inventory inventory, String itemName, String itemNumber, float price, String itemQuantity
     */
    public Purchase(Inventory inventory, String itemName, String itemNumber, float price, String itemQuantity) {
        this.inventory = inventory;
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.price = price;
        this.itemQuantity = itemQuantity;
        this.cart = new ArrayList<>();
        this.subtotal = 0;
    }

    public void getInventoryItems(Integer itemNumber) {
        InventoryDB item = inventory.getItems().get(itemNumber);
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

    public void removeItemQuantity(int itemNumber, int removeQuantity) {
        InventoryDB item = inventory.getItems().get(itemNumber);
        if (item != null) {
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
            System.out.println("Enter item number to add to cart (1 for demonstration purposes)(or 0 to finish): ");
            itemNumber = scanner.nextInt();

            if (itemNumber == 0) {
                break;
            }

            InventoryDB item = inventory.getItems().get(itemNumber);
            if (item != null) {
                System.out.println("Item Name: " + item.getName());
                System.out.println("Item Number: " + itemNumber);
                System.out.println("Item Price: $" + item.getPrice());
                System.out.println("Item Quantity: " + item.getQuantity());

                System.out.println("Enter quantity: ");
                quantity = scanner.nextInt();

                if (quantity <= item.getQuantity()) {
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
}
