import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class handles the database for customers. 
 * Commands to modify or create customers must be handled in a separate menu. 
 * Author: Justin Hovious
 */
class Customer extends Person{
    // Private variables and list creation.
    private int option;
    private boolean choice;
    String name;
    String phoneNumber;
    int rewardNumber;
    short rewardPoint;
    
    private static LinkedList<Customer> customerDataBase = new LinkedList<>();

    // Constructor to initialize values.
    public Customer(String name, String phoneNumber, int rewardNumber, short rewardPoint) {
        this.name = name;
        this.option = 9;
        this.choice = true;
        this.phoneNumber = phoneNumber;
        this.rewardNumber = rewardNumber;
        this.rewardPoint = rewardPoint;
        customerDataBase.add(this);  // Add new customer to the database

    }
    
    
    public static LinkedList<Customer> getCustomerDataBase() {
        return customerDataBase;
    }
    
    
    
    // Getter method for rewardNumber
    public int getRewardNumber() {
        return rewardNumber;
    }
    
    
    // Getter method for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Method to create a new customer.
    public static void createCustomer(String name, String phoneNumber, int rewardNumber, short rewardPoint) {
        Customer customer = new Customer(name, phoneNumber, rewardNumber, rewardPoint);
    }

    // Method to view all customers.
    public static void viewCustomers() {
        for (Customer customer : customerDataBase) {
            System.out.println(customer);
        }
    }
    
    
    // Method to view specific customers.
    public static void viewCustomer(int rewardNumber) {
        for (Customer customer : customerDataBase) {
            if (customer.rewardNumber == rewardNumber) {
                System.out.println(customer);
                return;
            }
        }
        System.out.println("Customer with reward number: " + rewardNumber + " not found.");
    }

    // Method to update existing customer information.
    public static void updateCustomer(int rewardNumber, String newName, String newPhoneNumber, short newRewardPoint) {
        for (Customer customer : customerDataBase) {
            if (customer.rewardNumber == rewardNumber) {
                customer.name = newName;
                customer.phoneNumber = newPhoneNumber;
                customer.rewardPoint = newRewardPoint;
                break;
            }
        }
    }

    // Method to delete a customer.
    public static boolean deleteCustomer(int rewardNumber) {
        for (Customer customer : customerDataBase) {
            if (customer.rewardNumber == rewardNumber) {
                return true;
            }
        }
        return false;
    }

    // Override toString() to display customer information.
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", rewardNumber=" + rewardNumber +
                ", rewardPoint=" + rewardPoint +
                '}';
    }

    // Method to display the customer menu
    public static void showCustomerMenu(boolean isManager) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("======Customer Menu======");
            System.out.println("1. View All Customers");
            System.out.println("2. View Specific Customer");
            System.out.println("3. Create New Customer");
            System.out.println("4. Update Customer");
            if (isManager) {
                System.out.println("5. Delete Customer");
            }
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();  
            switch(option) {
                case 1:
                    viewCustomers();
                    break;
                case 2:
                    System.out.print("Enter reward number: ");
                    int rewardNumber = scanner.nextInt();
                    viewCustomer(rewardNumber);
                    break;
                case 3:
                    createNewCustomer(scanner);
                    break;
                case 4:
                    updateExistingCustomer(scanner);
                    break;
                case 5:
                    if (isManager) {
                        System.out.print("Enter reward number to delete: ");
                        int deleteRewardNumber = scanner.nextInt();
                        deleteCustomer(deleteRewardNumber);
                        System.out.println("Customer deleted successfully.");
                    } else {
                        System.out.println("Access denied. Manager only.");
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Incorrect option, please try again.");
            }
        }
    }

    // Helper method to create a new customer
    private static void createNewCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter reward number: ");
        int rewardNumber = scanner.nextInt();
        System.out.print("Enter reward points: ");
        short rewardPoint = scanner.nextShort();
        createCustomer(name, phoneNumber, rewardNumber, rewardPoint);
        System.out.println("Customer created successfully.");
    }

    // Helper method to update an existing customer
    private static void updateExistingCustomer(Scanner scanner) {
        System.out.print("Enter reward number of the customer to update: ");
        int rewardNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new customer name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new customer phone number: ");
        String newPhoneNumber = scanner.nextLine();
        System.out.print("Enter new reward points: ");
        short newRewardPoint = scanner.nextShort();
        updateCustomer(rewardNumber, newName, newPhoneNumber, newRewardPoint);
        System.out.println("Customer updated successfully.");
    }
}
