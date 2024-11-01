
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
    

    
    //Constructor
    public UserMenu(){
        option = 9; //Default number to be changed with working program
        choice = true;
        
        
    }
    
    
    public void showOption(Tickets aTicket){
        
        do{
            System.out.println("======Hardware Store User Menu======");
            System.out.println("1. Tickets Menu");
            System.out.println("2. Inventory Menu");
            System.out.println("3. Customer Menu");
            System.out.println("4. Staff Menu");
            System.out.println("5. Purchase Menu");
            System.out.println("6. Store Info");
            System.out.println("7. Exit Program");
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            
            switch(option){
                case 1: 

                    aTicket.showTicketMenu();
                    break;
//                case 2:
//                case 3:
//                case 4:
//                case 5:
//                case 6:
                case 7: System.out.println("Exiting program, goodbye!"); 
                choice = false; 
                break;
                
                default: 
                    System.out.println("Incorrect option, please try again.");
            }
        } while (choice);    
    }
        
}
