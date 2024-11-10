import java.util.Scanner;

/**
 * Class handles the CRUD capabilities for users with manager access to 
 * modify, create, or delete staff. 
 * @author Justin Hovious
 */
public class EmployeeManager {
    
    private Staff staff;

    public EmployeeManager(Staff staff) {
        this.staff = staff;
    }

    // Display the submenu for manager options
    public void showManagerMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("======Employee Manager Menu======");
            System.out.println("1. Create Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            switch(option) {
                case 1: 
                    createEmployee(scanner);
                    break;
                case 2:
                    deleteEmployee(scanner);
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4: 
                    exit = true;
                    break;
                default: 
                    System.out.println("Incorrect option, please try again.");
            }
        }
    }

    // Method to create a new employee
    private void createEmployee(Scanner scanner) {
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.println("Enter employee ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter hire date (YYYY-MM-DD): ");
        String hireDate = scanner.nextLine();
        System.out.println("Enter employee title: ");
        String title = scanner.nextLine();
        System.out.println("Enter employee email: ");
        String email = scanner.nextLine();
        System.out.println("Enter employee phone: ");
        String phone = scanner.nextLine();
        System.out.println("Enter PTO hours: ");
        byte pto = scanner.nextByte();
        System.out.println("Enter sick time hours: ");
        byte sickTime = scanner.nextByte();
        System.out.println("Enter unpaid time hours: ");
        byte unpaidTime = scanner.nextByte();
        scanner.nextLine();  // Consume newline
        
        staff.addStaffMember(name, id, hireDate, title, email, phone, pto, sickTime, unpaidTime);
        System.out.println("Employee created successfully.");
    }

    // Method to delete an employee
    private void deleteEmployee(Scanner scanner) {
        System.out.println("Enter employee ID to delete: ");
        String id = scanner.nextLine();
        
        if (staff.deleteStaffMember(id)) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Method to update an employee's information
    private void updateEmployee(Scanner scanner) {
        System.out.println("Enter employee ID to update: ");
        String id = scanner.nextLine();
        System.out.println("Enter new title: ");
        String newTitle = scanner.nextLine();
        System.out.println("Enter new email: ");
        String newEmail = scanner.nextLine();
        System.out.println("Enter new phone: ");
        String newPhone = scanner.nextLine();
        System.out.println("Enter new PTO hours: ");
        byte newPto = scanner.nextByte();
        System.out.println("Enter new sick time hours: ");
        byte newSickTime = scanner.nextByte();
        System.out.println("Enter new unpaid time hours: ");
        byte newUnpaidTime = scanner.nextByte();
        scanner.nextLine();  // Consume newline
        
        if (staff.updateStaffMember(id, newTitle, newEmail, newPhone, newPto, newSickTime, newUnpaidTime)) {
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}
