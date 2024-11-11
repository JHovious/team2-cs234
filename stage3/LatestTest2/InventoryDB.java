/**
 *
 * Christian Kurdi
 */

import java.util.Scanner;

public class InventoryDB {
    
    //Instance Variables
    private String name, details, price, location;
    private int quantity, num;
    private Scanner sc, numScan;
    
    //Main constructor
    public InventoryDB(){
        this.name = "default";
        this.details = "No details";
        this.price = "20";
        this.quantity = 0;
        this.location = "Store";
        this.num = 1;
        sc = new Scanner(System.in);
        numScan = new Scanner(System.in);
    }
    
    //Dummy Constructor
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
        this.quantity = numScan.nextInt();
    }
    public void createItemLocation(){
        System.out.println("Enter item location: ");
        this.location = sc.nextLine();
    }
    
    public void createItemNumber(){
        System.out.println("Enter item number: ");
        this.num = numScan.nextInt();
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
