import java.util.Scanner;

public class PurchaseMenu {

    private boolean choice;
    private Scanner scanner;
    private Purchase purchase;

    public PurchaseMenu() {
        choice = true;
        scanner = new Scanner(System.in);
        // dummy data
        purchase = new Purchase("SampleItem", "123", 20.0f, "10", "2");
    }

    public void showPurchaseMenu() {
        do {
            System.out.println("====== Purchase Menu ======");
            System.out.println("1. View Item");
            System.out.println("2. Calculate Subtotal");
            System.out.println("3. Remove Item Quantity");
            System.out.println("4. Update Item Quantity");
            System.out.println("5. Exit Purchase Menu");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter item number to view enter'1' for demonstration purposes: ");
                     int itemNumber = scanner.nextInt();
                    purchase.getInventoryItems(itemNumber);
                    break;
                case 2:
                    System.out.println("Enter item number to get subtotal enter'1' for demonstration purposes: ");
                    int itemNumber2 = scanner.nextInt();
                    float subtotal = purchase.getSubtotal(itemNumber2);
                    System.out.println("Subtotal: $" + subtotal);
                    break;
                case 3:
                    System.out.print("Enter item number to remove quantity from enter'1' for demonstration purposes: ");
                    itemNumber = scanner.nextInt();
                    System.out.print("Enter quantity to remove: ");
                    int removeQuantity = scanner.nextInt();
                    purchase.removeItemQuantity(itemNumber, removeQuantity);
                    break;
                case 4:
                    System.out.print("Enter item number to update enter'1' for demonstration purposes: ");
                    itemNumber = scanner.nextInt();
                    System.out.print("Enter quantity to update: ");
                    String newQuantity = scanner.next();
                    purchase.updateItemQuantity(itemNumber, newQuantity);
                    break;                    
                case 5:
                    System.out.println("Exiting Purchase Menu.");
                    choice = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (choice);
    }
}
