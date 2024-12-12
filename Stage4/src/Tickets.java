

/**
 *
 *Christian Kurdi
 * Version: 1.3
 */

import java.util.HashMap;

import java.util.Scanner;

//I set it up so this class only shows the menu and creates the array list of tickets
public class Tickets {
    
    // Instance Variables
    private boolean choice;
    private int option;
    private TicketDB newTicket;
    private Scanner sc;
    private Scanner scan;
    private Scanner scanner;
    private HashMap<Integer,TicketDB> tickets;
    
    //Constructor
    public Tickets(HashMap<Integer,TicketDB> ticketsDB){
        choice = true;
        option = 9; //default number
        tickets = ticketsDB;
        newTicket = new TicketDB();
        sc = new Scanner(System.in);
        scan = new Scanner(System.in);
        scanner = new Scanner(System.in);
       
    }
    
    public Tickets(HashMap<Integer,TicketDB> ticketsDB, int num, String ticketMessage,
            String ticketSubject, String ticketPriority, String ticketRecipient){
        
        tickets = ticketsDB;
        newTicket = new TicketDB(num, ticketMessage, ticketSubject, ticketPriority, ticketRecipient);
        tickets.put(newTicket.getNum(), newTicket);
        sc = new Scanner(System.in);
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

                    
                    tickets.put(newTicket.getNum(), newTicket);
                    System.out.println("Ticket created successfully. The ticket number is " + newTicket.getNum());
                    choice = true;
                    break;
                    
                    
                    
                    
                case 2:
                    System.out.print("Enter the ticket number: ");
                    int lookUp = sc.nextInt();
                    if(tickets.get(lookUp) != null){
                        //Need to verify if key exists in map
                        String priority = tickets.get(lookUp).getTicketPriority();
                        String recipient = tickets.get(lookUp).getTicketRecipient();
                        String subject = tickets.get(lookUp).getTicketSubject();
                        String message = tickets.get(lookUp).getTicketMessage();
                        System.out.println("Ticket Priority: " + priority);
                        System.out.println("Ticket Recipient: " + recipient);
                        System.out.println("Ticket Subject: " + subject);
                        System.out.println("Ticket Message: " + message);
                    }else{
                        System.out.println("Number is not a ticket. Returning to Ticket Menu");
                    }
                    choice = true;
                    break;
                case 3:

                    update();

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
    
    public void update(){
        System.out.print("Enter the ticket number: ");
        int lookUp2 = scan.nextInt();
        if(tickets.get(lookUp2) != null){
            System.out.println("Enter 1 to Update Subject");
            System.out.println("Enter 2 to Update Message");
            int lookUp3 = scan.nextInt();
            switch(lookUp3){
                case 1:
                    System.out.println("Enter new subject: ");
                    
                    tickets.get(lookUp2).setSubject(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Enter new message: ");
                    tickets.get(lookUp2).setMessage(scanner.nextLine());
                    break;
                default:
                    System.out.println("Incorrect option. Returning to Ticket Menu");
            }
        } else{
            System.out.println("Number is not a ticket. Returning to Ticket Menu");
        }
    }
}
