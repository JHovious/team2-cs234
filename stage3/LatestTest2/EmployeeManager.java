import java.util.Scanner;

/**
 * Class handles the CRUD capabilities for users with manager access to 
 * modify, create, or delete staff. 
 * @author Justin Hovious
 */
public class EmployeeManager {
    
    private Staff staff;
    private int option;
    private boolean choice;
    private Scanner sc;
    private Scanner scanner;
    
    public EmployeeManager(){
        staff = new Staff();
        option = 9;
        choice = true;
        sc = new Scanner(System.in);
        scanner = new Scanner(System.in);
    }
    

    // Display the submenu for manager options
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
                createEmployee();
                choice = true;
                break;
            case 2:
                updateEmployee();
                choice = true;
                break;
            case 3:
                String name;
                System.out.println("Enter name of employee to delete: ");
                name = scanner.nextLine();
                deleteEmployee(name);
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
    private void createEmployee() {
        Staff newStaff = new Staff();
        StaffDB newStaffInfo = new StaffDB(newStaff.getName());
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
        
        newStaffInfo.setEmployeeID(id);
        newStaffInfo.setHireDate(hireDate);
        newStaffInfo.setEmployeeTitle(title);
        newStaffInfo.setEmployeeEmail(email);
        newStaffInfo.setEmployeePhone(phone);
        newStaffInfo.setPto(pto);
        newStaffInfo.setSickTime(sickTime);
        newStaffInfo.setUnpaidTime(unpaidTime);
        newStaff.addStaff(newStaffInfo);
        
        
        
        System.out.println("Employee created successfully.");
    }

    // Method to delete an employee
    public void deleteEmployee(String name) {
        
        staff.removeStaff(name);
    }

    // Method to update an employee's information
    public void updateEmployee() {
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
            if(staff.getStaff(name) != null){
                switch(choice){

                    case 1:
                        System.out.println("Enter ID: ");
                        String id = scanner.nextLine();
                        staff.getStaff(name).setEmployeeID(id);
                        System.out.println("ID updated successfully");
                        check = false;
                        break;
                    case 2:
                        System.out.println("Enter Title: ");
                        String title = scanner.nextLine();
                        staff.getStaff(name).setEmployeeID(title);
                        System.out.println("Title updated successfully");
                        check = false;
                        break;
                    case 3:
                        System.out.println("Enter Email: ");
                        String email = scanner.nextLine();
                        staff.getStaff(name).setEmployeeID(email);
                        System.out.println("Email updated successfully");
                        check = false;
                        break;
                    case 4:
                        System.out.println("Enter Phone Number: ");
                        String phone = scanner.nextLine();
                        staff.getStaff(name).setEmployeeID(phone);
                        System.out.println("Phone updated successfully");
                        check = false;
                        break;
                    case 5:
                        System.out.println("Enter PTO: ");
                        String pto = scanner.nextLine();
                        staff.getStaff(name).setEmployeeID(pto);
                        System.out.println("PTO updated successfully");
                        check = false;
                        break;
                    case 6:
                        System.out.println("Enter Sick Time: ");
                        String sick = scanner.nextLine();
                        staff.getStaff(name).setEmployeeID(sick);
                        System.out.println("Sick Time updated successfully");
                        check = false;
                        break;
                    case 7:
                        System.out.println("Enter Unpaid Time Off: ");
                        String unpaid = scanner.nextLine();
                        staff.getStaff(name).setEmployeeID(unpaid);
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
}