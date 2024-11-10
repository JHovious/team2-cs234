/**
 *
 * Christian Kurdi
 * Version: 1.0
 * Need: 
 */
import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

public class Inventory {
    
    //Instance Variables
    private boolean choice;
    private int option;
    private Integer itemNum = 1;
    private HashMap<Integer,InventoryDB> items = new HashMap<>();
    private Scanner sc;
    EmployeeManager accessMenu;
    Login verify;
    
    public Inventory(){
        choice = true;
        option = 9;
        accessMenu = new EmployeeManager();
        verify = new Login(); 
        sc = new Scanner(System.in);
        dummyCreate();
        
    }
    public void showInventoryMenu(String userID){
        
        do{
            System.out.println("------Inventory Menu------");
            System.out.println("1. Find an Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Return to Main Menu");
            System.out.println("4. Manager Create");
            System.out.println("5. Manager Update");
            System.out.println("6. Manager Delete");
            System.out.print("Enter your choice: ");
            
            sc = new Scanner(System.in);
            option = sc.nextInt();
            
            switch(option){
                case 1:
                    findItem();
                    choice = true;
                    break;
                       
                    
                case 2:
                   Set<Integer> keySet = items.keySet();
                   System.out.println("Name | Item Number  |  Price  |  Quantity  |  Location");
                    for (Integer key : keySet){
                        String valueName = items.get(key).getName();
                        String valuePrice = items.get(key).getPrice();
                        int valueQuantity = items.get(key).getQuantity();
                        String valueLocation = items.get(key).getLocation();
                        System.out.println(valueName + "|" + key + "|" + valuePrice + "|" + valueQuantity + "|" + valueLocation);
                    }
                        
                    choice = true;
                    break;
                case 3:
                    
                    System.out.println("Returning to Main Menu");
                    choice = false;
                    break;
                    
                case 4:
                    if(verify.managerStatus(userID)){
                        managerCreate();
                        choice = true;
                    }else{
                        System.out.println("Invalid credentials");
                    }
                    break;
                    
                case 5:
                    if(verify.managerStatus(userID)){
                        managerUpdate();
                        choice = true;
                    }else{
                        System.out.println("Invalid credentials");
                    }
                    break;
                    
                case 6:
                    if(verify.managerStatus(userID)){
                        managerDelete();
                        choice = true;
                    }else{
                        System.out.println("Invalid credentials");
                    }
                    break;
                    
    
                    
                default:
                    System.out.println("Invalid option please try again");
                    choice = true;
            }
            
        } while(choice);
    }
    
    //Method to create dummy inventory
    private void dummyCreate(){
        InventoryDB item;
        
        item = new InventoryDB("Wrench", "It's a wrench", "5.99", 15, "A1");
        addItem(item);
        newNum();
        item = new InventoryDB("Tape Measure", "Measures lengths", "8.99", 50, "B1");
        addItem(item);
        newNum();
        item = new InventoryDB("Screwdriver", "Hex screwdriver", "3.99", 10, "B2");
        addItem(item);
        newNum();
    }
    
    //Method to increase ticket numbers
    public void newNum(){
        itemNum = itemNum + 1;
        
    }
    
    //Method to add to map
    public void addItem(InventoryDB item){
        items.put(itemNum, item);
    }
    
    public void managerCreate(){
        
        InventoryDB newItem = accessMenu.createItem();
        
        newNum();//Need to generate new number/Key
        addItem(newItem);//add the key/value pair
        System.out.println("The item number is " + itemNum);
    }
    
    public void managerUpdate(){
        System.out.print("Enter item number: ");
        Integer id = sc.nextInt();
        if (items.get(id) != null){
            System.out.println("1. Update name");
            System.out.println("2. Update details");
            System.out.println("3. Update price");
            System.out.println("4. Update quantity");
            System.out.println("5. Update location");
            int choiceUpdate = sc.nextInt();
            Scanner newScan = new Scanner(System.in);
            switch(choiceUpdate){
                case 1:
                    System.out.println("Enter new name: ");
                    String newName = newScan.nextLine();
                    items.get(id).setName(newName);
                    System.out.println("Update completed.");
                    break;
                case 2:
                    System.out.println("Enter new details: ");
                    String newDetails = newScan.nextLine();
                    items.get(id).setDetails(newDetails);
                    System.out.println("Update completed.");
                    break;
                case 3:
                    System.out.println("Enter new price: ");
                    String newPrice = newScan.nextLine();
                    items.get(id).setPrice(newPrice);
                    System.out.println("Update completed.");
                    break;
                case 4:
                    System.out.println("Enter new quantity: ");
                    int newQuantity = sc.nextInt();
                    items.get(id).setQuantity(newQuantity);
                    System.out.println("Update completed.");
                    break;
                case 5:
                    System.out.println("Enter new location: ");
                    String newLocation = newScan.nextLine();
                    items.get(id).setLocation(newLocation);
                    System.out.println("Update completed.");
                    break;
                default:
                    System.out.println("Incorrect option. Returning to Inventory Menu.");
            }
            
        }else{
            System.out.println("ID not in inventory. Returning to Inventory Menu.");
        }
    }
    
    public void managerDelete(){
        System.out.print("Enter item number: ");
        Integer id = sc.nextInt();
        if (items.get(id) != null){
            items.remove(id);
            System.out.println("Item deleted successfully.");
        }
    }
    
    public void findItem(){
        System.out.print("Enter item number: ");
        Integer findIt = sc.nextInt();
        if (items.get(findIt) != null){
            String name1 = items.get(findIt).getName();
            String details1 = items.get(findIt).getDetails();
                        //You can use similar code as below to get the price of an item in the items hashMap
            String price1 = items.get(findIt).getPrice();
            int quantity1 = items.get(findIt).getQuantity();
            String location1 = items.get(findIt).getLocation();
            System.out.println("Item Name: " + name1);
            System.out.println("Item Details: " + details1);
            System.out.println("Item Price: " + price1);
            System.out.println("Item Quantity: " + quantity1);
            System.out.println("Item Location: " + location1);
        }else {
            System.out.println("Item number not found. Returning to Inventory Menu.");
        }
    }
    
    
}
