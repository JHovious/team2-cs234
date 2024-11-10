/**
 *
 * Christian Kurdi
 */

import java.util.Scanner;

public class ManagerMenu {
    private int option;
    private boolean choice;
    private Scanner sc;
    private Staff accessStaff;
    
    
    
    
    public ManagerMenu(){
        option = 9;
        choice = true;
        sc = new Scanner(System.in);
        accessStaff = new Staff();
    }
    
    public void showManagerMenu(){
        System.out.println("Manager Menu");
        System.out.println("1. Create Staff");
        System.out.println("2. Update Staff");
        System.out.println("3. Delete Staff");
        System.out.println("4. Return to Main Menu");
        System.out.print("Enter your choice: ");
        option = sc.nextInt();
        
        switch(option){
            case 1: 
                createItem();
                choice = true;
                break;
            case 2:
                updateStaff();
                choice = true;
                break;
            case 3:
                
                choice = true;
                break;
            case 4:
                System.out.println("Returning to Main Menu");
                choice = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
    }
    
    public InventoryDB createItem(){
        
        InventoryDB newItem = new InventoryDB();
        newItem.createItemName();
        newItem.createItemDetails();
        newItem.createItemQuantity();
        newItem.createItemPrice();
        newItem.createItemLocation();
        System.out.print("Item created successfully. ");
        return newItem;
        
    }
    
    public void createStaff(){
        Staff newStaff = new Staff();
        newStaff.createNew();
    }
    
    public void updateStaff(){
        boolean check2;
        do{
            System.out.println("1. Update Name");
            System.out.println("2. Update Title");
            System.out.println("3. Update Phone");
            System.out.println("4. Update Email");
            System.out.print("Enter the number for which field to update: ");
            int choice2 = sc.nextInt();
            if(choice2 == (int)choice2){
                accessStaff.update(choice2);
                check2 = false;
            }else{
                System.out.println("Please try again.");
                check2 = true;
            }
        }while(check2);
    }
    
    public void deleteStaff(){
        
    }
    
}
