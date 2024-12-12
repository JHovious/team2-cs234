import java.util.HashMap;
import java.util.Scanner;

public class PurchaseMenu {

    private boolean choice;
    private Scanner scanner;
    private Purchase purchase;
    private  HashMap<Integer,InventoryDB> items;

    public PurchaseMenu( HashMap<Integer,InventoryDB> items) {
        scanner = new Scanner(System.in);
        choice = true;
        this.items = items;
        // Initialize Purchase with actual inventory
        purchase = new Purchase(items);
    }

    public void showPurchaseMenu() {
        do {
            System.out.println("======== Checkout ========");
            System.out.println("Subtotal: $" + purchase.getSubtotal());
            purchase.showInventory();
            System.out.println("(Enter item number '1'to add items)");
            System.out.println("(Enter '0' when ready to checkout)");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    
                    purchase.checkout();
                    break;
                case 0:
                    System.out.println("Proceeding to payment...");
                    processPayment();
                    choice = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } while (choice);
    }

    public void processPayment() {
        System.out.print("Enter total amount: ");
        float total = scanner.nextFloat();
        System.out.print("Enter payment type (card/cash): ");
        String paymentType = scanner.next();
        System.out.print("Enter customer lookup: ");
        String customerLookup = scanner.next();
        System.out.print("Enter rewards number: ");
        String rewardsLookup = scanner.next();
        System.out.print("Enter tax amount: ");
        float tax = scanner.nextFloat();
        purchase.processPayment(total, paymentType, customerLookup, rewardsLookup, tax);
    }
}