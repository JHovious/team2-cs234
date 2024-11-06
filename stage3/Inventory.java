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
    private Integer itemNum;
    private InventoryDB newItem;
    private HashMap<Integer,InventoryDB> items;
    private Scanner sc;
    
    public Inventory(){
        choice = true;
        option = 9;
        itemNum = 1;
        newItem = new InventoryDB();
        items = new HashMap<>();
        sc = new Scanner(System.in);
    }
    public void showInventoryMenu(){
        
        do{
            System.out.println("------Inventory Menu------");
            System.out.println("1. Find an Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Return to Main Menu");
            System.out.println("4. Manager Create");
            System.out.print("Enter your choice: ");
            
            sc = new Scanner(System.in);
            option = sc.nextInt();
            
            switch(option){
                case 1:
                    System.out.print("Enter item number: ");
                    Integer findIt = sc.nextInt();
                    if (items.get(findIt) != null){
                        String name1 = items.get(findIt).getName();
                        String details1 = items.get(findIt).getDetails();
                        String price1 = items.get(findIt).getPrice();
                        String quantity1 = items.get(findIt).getQuantity();
                        String location1 = items.get(findIt).getLocation();
                        System.out.println("Item Name: " + name1);
                        System.out.println("Item Details: " + details1);
                        System.out.println("Item Price: " + price1);
                        System.out.println("Item Quantity: " + quantity1);
                        System.out.println("Item Location: " + location1);
                    }else {
                        System.out.println("Item number not found. Returning to Inventory Menu.");
                    }
                    choice = true;
                    break;
                    
                    
                    
                    
                case 2:
                   System.out.println("Testing for view inventory");
                   Set<Integer> keySet = items.keySet();
                   System.out.println("Name  Item Number   Price   Quantity   Location");
                    for (Integer key : keySet){
                        String valueName = items.get(key).getName();
                        String valuePrice = items.get(key).getPrice();
                        String valueQuantity = items.get(key).getQuantity();
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
                    
                    newItem = new InventoryDB();
                    newItem.createItemName();
                    newItem.createItemDetails();
                    newItem.createItemQuantity();
                    newItem.createItemPrice();
                    newItem.createItemLocation();

                    //Need to generate new number/Key
                    itemNum = itemNum + 1;
                    items.put(itemNum, newItem);
                    System.out.println("Item created successfully. The item number is " + itemNum);
    
                    
                default:
                    System.out.println("Invalid option please try again");
                    choice = true;
            }
            
        } while(choice);
    }
    
    public void findItem(){
        
    }
    
    
}
