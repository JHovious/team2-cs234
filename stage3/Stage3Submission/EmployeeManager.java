import java.util.HashMap;
import java.util.Scanner;

/**
 * Class handles the CRUD capabilities for users with manager access to 
 * modify, create, or delete staff. 
 * @author Justin Hovious and Christian Kurdi
 */
public class EmployeeManager {
    
    private Staff staff;
    private int option;
    private boolean choice;
    private Scanner sc;
    private Scanner scanner;
    private HashMap<Integer,InventoryDB> items;
    
    public EmployeeManager(HashMap<String, StaffDB> employees, Staff accessStaff,HashMap<Integer,InventoryDB> itemsDB){
        this.staff = accessStaff;
        option = 9;
        choice = true;
        items = itemsDB;
        sc = new Scanner(System.in);
        scanner = new Scanner(System.in);
    }
    

    // Display the submenu for manager options
    public void showManagerMenu(HashMap<String, StaffDB> employees){
        System.out.println("Manager Menu");
        System.out.println("1. Create Staff");
        System.out.println("2. Update Staff");
        System.out.println("3. Delete Staff");
        System.out.println("4. Return to Main Menu");
        System.out.print("Enter your choice: ");
        option = sc.nextInt();
        
        switch(option){
            case 1: 
                createEmployee(employees);
                choice = true;
                break;
            case 2:
                updateEmployee(employees);
                choice = true;
                break;
            case 3:
                String name;
                System.out.println("Enter name of employee to delete: ");
                name = scanner.nextLine();
                deleteEmployee(name, employees);
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

    // Method to create a new employee
    private void createEmployee(HashMap<String, StaffDB> employees) {
        
        System.out.println("Enter employee name");
        String name = sc.nextLine();
        System.out.println("Enter employee ID: ");
        String id = sc.nextLine();
        System.out.println("Enter hire date (YYYY-MM-DD): ");
        String hireDate = sc.nextLine();
        System.out.println("Enter employee title: ");
        String title = sc.nextLine();
        System.out.println("Enter employee email: ");
        String email = sc.nextLine();
        System.out.println("Enter employee phone: ");
        String phone = sc.nextLine();
        System.out.println("Enter PTO hours: ");
        byte pto = scanner.nextByte();
        System.out.println("Enter sick time hours: ");
        byte sickTime = scanner.nextByte();
        System.out.println("Enter unpaid time hours: ");
        byte unpaidTime = scanner.nextByte();
        
        Staff newPerson1 = new Staff(employees,name,id, hireDate, title, email, phone, pto, sickTime, unpaidTime);
        
        
        
        
        System.out.println("Employee created successfully.");
    }

    // Method to delete an employee
    public void deleteEmployee(String name, HashMap<String, StaffDB> employees) {
        
        employees.remove(name);
    }

    // Method to update an employee's information
    public void updateEmployee(HashMap<String, StaffDB> employees) {
        int choice;
        boolean check = true;
        String name;
        do{
            System.out.println("1. Update id");
            System.out.println("2. Update Title");
            System.out.println("3. Update Email");
            System.out.println("4. Update Phone");
            System.out.println("5. Update PTO");
            System.out.println("6. Update Sick Time");
            System.out.println("7. Update Unpaid Time");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            System.out.println("Enter name of employee: ");
            
            name = scanner.nextLine();
            if(employees.get(name) != null){
                switch(choice){

                    case 1:
                        System.out.println("Enter ID: ");
                        String id = scanner.nextLine();
                        employees.get(name).setEmployeeID(id);
                        System.out.println("ID updated successfully");
                        check = false;
                        break;
                    case 2:
                        System.out.println("Enter Title: ");
                        String title = scanner.nextLine();
                        employees.get(name).setEmployeeTitle(title);
                        System.out.println("Title updated successfully");
                        check = false;
                        break;
                    case 3:
                        System.out.println("Enter Email: ");
                        String email = scanner.nextLine();
                        employees.get(name).setEmployeeEmail(email);
                        System.out.println("Email updated successfully");
                        check = false;
                        break;
                    case 4:
                        System.out.println("Enter Phone Number: ");
                        String phone = scanner.nextLine();
                        employees.get(name).setEmployeePhone(phone);
                        System.out.println("Phone updated successfully");
                        check = false;
                        break;
                    case 5:
                        System.out.println("Enter PTO: ");
                        int pto = scanner.nextInt();
                        employees.get(name).setPto(pto);
                        System.out.println("PTO updated successfully");
                        check = false;
                        break;
                    case 6:
                        System.out.println("Enter Sick Time: ");
                        int sick = scanner.nextInt();
                        employees.get(name).setSickTime(sick);
                        System.out.println("Sick Time updated successfully");
                        check = false;
                        break;
                    case 7:
                        System.out.println("Enter Unpaid Time Off: ");
                        int unpaid = scanner.nextInt();
                        employees.get(name).setUnpaidTime(unpaid);
                        System.out.println("Unpaid Time Off updated successfully");
                        check = false;
                        break;

                    default:
                        System.out.println("Incorrect option. Returning to Manager Menu");
                        check = false;
                }
            }else{
                System.out.println("Name not in database. Returning to Manager Menu.");
                check = false;
            }
        }while(check);
       
    }
    
    public void createItem(){
       
        InventoryDB newItem = new InventoryDB();
        newItem.createItemName();
        newItem.createItemDetails();
        newItem.createItemQuantity();
        newItem.createItemPrice();
        newItem.createItemLocation();
        newItem.createItemNumber();
        items.put(newItem.getNum(), newItem);
        System.out.print("Item created successfully. ");
        System.out.println("The item number is " + newItem.getNum());
        
    }
}