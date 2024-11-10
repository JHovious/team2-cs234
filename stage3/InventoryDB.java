/**
 *
 * Christian Kurdi
 */

import java.util.Scanner;

public class InventoryDB {
    
    //Instance Variables
    private String name, details, price, quantity, location;
    private Scanner sc;
    
    public InventoryDB(){
        this.name = "default";
        this.details = "No details";
        this.price = "No price";
        this.quantity = "0";
        this.location = "Store";
        sc = new Scanner(System.in);
    }
    
    
    //Methods for all users
    public void findItem(Integer itemNumber){
        
    }
    //Methods for manager
    public void createItemName(){
        System.out.println("Enter item name: ");
        this.name = sc.nextLine();
    }
    public void createItemDetails(){
        System.out.println("Enter item details: ");
        this.details = sc.nextLine();
    }
    public void createItemPrice(){
        System.out.println("Enter item price: ");
        this.price = sc.nextLine();
    }
    public void createItemQuantity(){
        System.out.println("Enter item quantity: ");
        this.quantity = sc.nextLine();
    }
    public void createItemLocation(){
        System.out.println("Enter item location: ");
        this.location = sc.nextLine();
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
    
    public String getQuantity(){
        return this.quantity;
    }
    
    public String getLocation(){
        return this.location;
    }
     public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
