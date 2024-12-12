/**
 *
 * Christian Kurdi
 */



public class InventoryDB {
    
    //Instance Variables
    private String name, details, price, location;
    private int quantity, num;
    
    //Main constructor
    public InventoryDB(){
        this.name = "default";
        this.details = "No details";
        this.price = "No price";
        this.quantity = 0;
        this.location = "Store";
        this.num = 0;
    }
    
    
    public InventoryDB(int num, String name, String details, String price, int quantity, String location){
        this.name = name;
        this.num = num;
        this.details = details;
        this.price = price;
        this.quantity = quantity;
        this.location = location;
    }
    
    public int getNum(){
        return this.num;
    }
    
    
    
    
    
    
    //Methods to get information
    public String getName(){
        return this.name;
    }
    
    public String getDetails(){
        return this.details;
    }
    
    public String getPrice(){
        return this.price;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public void setDetails(String newDetails){
        this.details = newDetails;
    }
    
    public void setPrice(String newPrice){
        this.price = newPrice;
    }
    
    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }
    
    public void setLocation(String newLocation){
        this.location = newLocation;
    }
    
    
    
}