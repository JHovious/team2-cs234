
import java.util.HashMap;
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
    private HashMap<String, StaffDB> employees;
    private HashMap<Integer,InventoryDB> items;
    private HashMap<Integer,TicketDB> tickets;
    private Inventory item;
    private Tickets ticket;
    
    

    
    //Constructor
    public UserMenu(HashMap<String, StaffDB> employeesDB, HashMap<Integer,InventoryDB>itemsDB, Staff staff1,HashMap<Integer,TicketDB> ticketsDB){
        option = 9; //Default number to be changed with working program
        choice = true;
        employees = employeesDB;
        staff = staff1;
        items = itemsDB;
        item = new Inventory(employees, staff, items);
        tickets = ticketsDB;
        ticket = new Tickets(tickets);
        
        
        
        
        
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
                    ticket.showTicketMenu();
                    break;
                case 2:
                    
                    item.showInventoryMenu(userID);
                    break;
//                case 3:
                case 4:
                    
                    staff.showMenu(employees);
                    break;
                //case 5:
		    //PurchaseMenu purchaseMenu = new PurchaseMenu(items);
                   // purchaseMenu.showPurchaseMenu();
                    //break;
                    
                case 6:
                    StoreInfo info = new StoreInfo();
                    info.showStoreInfoMenu();
		    break;
                   
                case 7:
                    EmployeeManager accessMenu = new EmployeeManager(employees, this.staff, items);
                    accessMenu.showManagerMenu(employees);
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
