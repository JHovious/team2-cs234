

/**
 *
 *Christian Kurdi
 * Version: 1.3
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

//I set it up so this class only shows the menu and creates the array list of tickets
public class Tickets {
    
    // Instance Variables
    private boolean choice;
    private int option;
    private Integer ticketNum;
    private TicketDB newTicket;
    private HashMap<Integer,TicketDB> tickets;
    private Scanner sc;
    
    //Constructor
    public Tickets(){
        choice = true;
        option = 9; //default number
       
        ticketNum = 1;
        newTicket = new TicketDB();
        //create a Hash Map for tickets objects
        tickets = new HashMap<>();
    }
    //Constructor 2
    public Tickets(Integer aTicket){
        choice = true;
        option = 9;
        ticketNum = aTicket;
    }
    
    //Method showTicketMenu
    public void showTicketMenu(){
        do{
            System.out.println("------Ticket Menu------");
            System.out.println("1. Create a Ticket");
            System.out.println("2. Read a Ticket");
            System.out.println("3. Update a Ticket");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");
            
            sc = new Scanner(System.in);
            option = sc.nextInt();
            
            switch(option){
                case 1:
                    System.out.println("Testing for create ticket");
                    newTicket = new TicketDB();
                    newTicket.createTicketSubject();
                    newTicket.createTicketPriority();
                    newTicket.createTicketRecipient();
                    newTicket.createTicketMessage();
                    
                    //Need to generate new number/Key
                    ticketNum = ticketNum + 1;
                    tickets.put(ticketNum, newTicket);
                    System.out.println("Ticket created successfully. The ticket number is " + ticketNum);
                    choice = true;
                    break;
                    
                    
                    
                    
                case 2:
                    System.out.print("Enter the ticket number: ");
                    Integer lookUp = sc.nextInt();
                    //Need to verify if key exists in map
                    String priority = tickets.get(lookUp).getTicketPriority();
                    String recipient = tickets.get(lookUp).getTicketRecipient();
                    String subject = tickets.get(lookUp).getTicketSubject();
                    String message = tickets.get(lookUp).getTicketMessage();
                    System.out.println("Ticket Priority: " + priority);
                    System.out.println("Ticket Recipient: " + recipient);
                    System.out.println("Ticket Subject: " + subject);
                    System.out.println("Ticket Message: " + message);
                    
                    choice = true;
                    break;
                case 3:
                    System.out.println("Testing for update");
                    System.out.print("Enter the ticket number: ");
                    Integer lookUp2 = sc.nextInt();
                    System.out.println("Enter 1 to Update Subject");
                    System.out.println("Enter 2 to Update Message");
                    Integer lookUp3 = sc.nextInt();
                    if(lookUp3 == 1){
                        System.out.print("Caution!! Old Subject will be erased!! Enter 1 to accent and continue: ");
                        Integer lookUp5 = sc.nextInt();
                        if(lookUp5 == 1){
                            tickets.get(lookUp2).createTicketSubject();
                        } else{
                            System.out.println("Returning to Ticket Menu");
                        }
                    } else if(lookUp3 == 2){
                        System.out.print("Caution!! Old message will be erased!! Enter 1 to accept and continue : ");
                        Integer lookUp4 = sc.nextInt();
                        if(lookUp4 == 1){
                            tickets.get(lookUp2).createTicketMessage();
                        } else{
                            System.out.println("Returning to Ticket Menu");
                        }
                    }
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
