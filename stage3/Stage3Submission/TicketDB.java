

/**
 *
 * Christian Kurdi
 * Needs: 
 * Version: 1.2
 */

import java.util.Scanner;


public class TicketDB {
    
    //Instance Variables
    
    private String ticketMessage, ticketSubject, ticketPriority, ticketRecipient;
    private int ticketNum;
    private Scanner sc;
    private Scanner numScan;
    
    
    //Constructor
    public  TicketDB(){
        
        this.ticketMessage = "Enter a message";
        this.ticketSubject = "Enter the subject";
        this.ticketPriority = "default";
        this.ticketRecipient = "Manager";
        this.ticketNum = 1;
        sc = new Scanner(System.in);
        numScan = new Scanner(System.in);
        
    }
    
    //Dummy Constructor
    public TicketDB(int num, String ticketMessage, String ticketSubject, String ticketPriority, String ticketRecipient){
        this.ticketMessage = ticketMessage;
        this.ticketSubject = ticketSubject;
        this.ticketPriority = ticketPriority;
        this.ticketRecipient = ticketRecipient;
        this.ticketNum = num;
    }
    
    //Methods to create a new information
    public void createTicketSubject(){
        System.out.println("Enter the subject: ");
        this.ticketSubject = sc.nextLine(); 
    }
    
    public void setSubject(String subject){
        this.ticketSubject = subject;
    }

    public void createTicketPriority(){
        System.out.println("Enter the priority 1-3: ");
        this.ticketPriority = sc.nextLine(); 
    }

    public void createTicketRecipient(){
        System.out.println("Enter the recipient: ");
        this.ticketRecipient = sc.nextLine(); 
    }

    public void createTicketMessage(){
        System.out.println("Enter the message: ");
        this.ticketMessage = sc.nextLine(); 
    }
    
    public void setMessage(String message){
        this.ticketMessage = message;
    }
    
    public void createNum(){
        System.out.println("Enter the ticket number: ");
        this.ticketNum = sc.nextInt();
    }
    
    public int getNum(){
        return this.ticketNum;
    }
       
    
    //Method to get ticket priority
    public String getTicketPriority(){
        return this.ticketPriority;
    }
    
    //Method to get ticket recipient
    public String getTicketRecipient(){
        return this.ticketRecipient;
    }
    
    //Method to get ticket Subject
    public String getTicketSubject(){
        return this.ticketSubject;
    }
    
    //Method to get ticket Message
    public String getTicketMessage(){
        return this.ticketMessage;
    }
}
