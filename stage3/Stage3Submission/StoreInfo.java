
/*
 * Author: Maya Fisher 
 */
import java.util.Scanner;
public class StoreInfo {
    private String name;
    private String storeAddress;
    private String hours;
    private boolean option;

    public StoreInfo() {
        this.name = "Test store";
        this.storeAddress = "123 Main St";
        this.hours = "Monday-Friday: 9:00 AM - 5:00 PM, Saturday: 10:00 AM - 4:00 PM, Sunday: Closed";
        this.option = true;
    }

    public void showStoreInfoMenu() {
        Scanner in = new Scanner(System.in);

        do { 

            System.out.println("===Store Information Menu===");
            System.out.println("1. Show Store Information");
            System.out.println("2. Update Store name");
            System.out.println("3. Update Store address");
            System.out.println("4. Update Store hours");
            System.out.println("5. Return to Main Menu");
            int choice = in.nextInt();
            in.nextLine();

            switch(choice) {
                case 1:
                    showName();
                    showAddress();
                    showHours();
                    break;
                case 2:
                    System.out.println("Enter the new store name: ");
                    updateName(in.nextLine());
                    System.out.println("Store name updated sucessfully!");
                    break;
                case 3:
                   System.out.println("Enter the new store address: ");
                   updateAddress(in.nextLine());
                   System.out.println("Store address updated successfully!");
                   break;
                case 4:
                   System.out.println("Enter the new store hours: (format: Monday-Friday: 9:00 AM - 5:00 PM, Saturday: 10:00 AM - 4:00 PM, Sunday: Closed) ");
                   updateHours(in.nextLine());
                   System.out.println("Store hours updated successfully!");
                   break;
                case 5:
                   System.out.println("Returning to Main Menu...");
                   option = false;
                   break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
   
           }
            
        } while (option);

    
       
        
    }
    public void showName() {
        System.out.println("Store Name: " + name);
    }

    public void showAddress() {
        System.out.println("Store Address: " + storeAddress);
    }

    public void showHours() {
        System.out.println("Store Hours: "  + hours);
    }

    public void updateHours(String hours) {
       this.hours = hours;
    }

    public void updateName(String name){
        this.name = name;
    }

    public void updateAddress(String address) {
        this.storeAddress = address;
    }

}

