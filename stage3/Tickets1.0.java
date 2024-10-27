

/**
 *
 *Christian Kurdi
 */

import java.util.ArrayList;
import java.util.Scanner;

//I set it up so this class only shows the menu and creates the array list of tickets
public class Tickets {
    
    // Instance Variables
    private boolean choice;
    private int option;
    private ArrayList<TicketDB> ticketsDB;
    
    //Constructor
    public Tickets(){
        choice = true;
        option = 9; //default number
        //create an array list for tickets objects
        ticketsDB = new ArrayList<TicketDB>();
    }
    
    //Method showTicketMenu
    public void showTicketMenu(){
        
        do{
            System.out.println("------Ticket Menu------");
            System.out.println("1. Create a Ticket");
            System.out.println("2. Read a Ticket");
            System.out.println("3. Update a Ticket");
            System.out.println("4. Return to Main Menu");
            System.out.println("Enter your choice: ");
            
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            
            switch(option){
                case 1:
                    System.out.println("Test for create ticket complete");
                    choice = true;
                    break;
                case 2:
                    System.out.println("Test for read ticket complete");
                    choice = true;
                    break;
                case 3:
                    System.out.println("Test for update ticket complete");
                    choice = true;
                    break;
                case 4:
                    System.out.println("Returning to Main Menu");
                    choice = false;
                    break;
                default:
                    System.out.println("Invalid option please try again");
                    choice = true;
            }
            
        } while(choice);
    }
    
}
