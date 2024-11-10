
import java.util.Scanner;

/**
 *
 * Christian Kurdi
 * Version 1.1
 */
public class UserMenu {
    
    //Instance Variables
    private int option;
    private boolean choice;
    private Staff staff;
    

    
    //Constructor
    public UserMenu(){
        option = 9; //Default number to be changed with working program
        choice = true;
        staff = new Staff();
        
        
    }
    
    
    public void showOption(String userID){
        
        do{
            System.out.println("======Hardware Store User Menu======");
            System.out.println("1. Tickets Menu");
            System.out.println("2. Inventory Menu");
            System.out.println("3. Customer Menu");
            System.out.println("4. Staff Menu");
            System.out.println("5. Purchase Menu");
            System.out.println("6. Store Info");
            System.out.println("7. Manager Menu");
            System.out.println("8. Exit Program");
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            
            switch(option){
                case 1: 
                    Tickets aTicket = new Tickets();
                    aTicket.showTicketMenu();
                    break;
                case 2:
                    Inventory item = new Inventory();
                    item.showInventoryMenu(userID);
                    break;
//                case 3:
                case 4:
                    System.out.println("-----Staff Menu-----");
                    Staff staff = new Staff();
                    staff.showStaffInfo();
                    break;
                //case 5:
                    //PurchaseMenu purchaseMenu = new PurchaseMenu();
                    //purchaseMenu.showPurchaseMenu();
                    //break;
                case 6:
                    StoreInfo info = new StoreInfo();
                    info.showName();
                    info.showAddress();
                    info.showHours();
		    break;
                   
                case 7:
                    EmployeeManager accessMenu = new EmployeeManager();
                    accessMenu.showManagerMenu();
                    break;
                    
			
                case 8: System.out.println("Exiting program, goodbye!"); 
                choice = false; 
                break;
                
                default: 
                    System.out.println("Incorrect option, please try again.");
            }
        } while (choice);    
    }
        
}
