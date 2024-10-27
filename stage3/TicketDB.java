

/**
 *
 * Christian Kurdi
 * Needs: like everything for changes
 */
public class TicketDB {
    
    //Instance Variables
    private int ticketNumber;
    private String ticketMessage, ticketPriority, ticketRecipient;
    
    
    //Constructor
    public Tickets(){
        this.ticketNumber = ticketDB.size() +1;
        this.ticketMessage = "Enter a message";
        this.ticketPriority = "default";
        this.ticketRecipient = "Manager";
        
    }
}
