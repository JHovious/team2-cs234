

/**
 *
 * Christian Kurdi
 * Version 1.1
 * Needs: like everything for changes
 */
import java.util.ArrayList;


public class TicketDB {
    
    //Instance Variables
    private int ticketNumber;
    private String ticketMessage, ticketSubject, ticketPriority, ticketRecipient;
    
    
    //Constructor
    public  TicketDB(ArrayList<TicketDB> aTicketList){
        this.ticketNumber = aTicketList.size() +1;//I'm not sure if this will cause issues
        this.ticketMessage = "Enter a message";
        this.ticketSubject = "Enter the subject";
        this.ticketPriority = "default";
        this.ticketRecipient = "Manager";
        
    }
    
    
    //Method for the processes needed for reading a ticket like asking for ticket number and
    
   
    //Method to get ticket number
    public int getTicketNumber(){
        return this.ticketNumber;
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
