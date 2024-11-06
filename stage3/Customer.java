import java.util.LinkedList;

/**
 * Class handles the database for customers. 
 * Commands to modify or create customers must be handled in a separate menu. 
 * @author Justin Hovious
 */
class Customer {
    // Private variables and list creation.
    private String name;
    private String phoneNumber;
    private int rewardNumber;
    private short rewardPoint;
    private static LinkedList<Customer> customerDataBase = new LinkedList<>();

    // Constructor to initialize values.
    public Customer(String name, String phoneNumber, int rewardNumber, short rewardPoint) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rewardNumber = rewardNumber;
        this.rewardPoint = rewardPoint;
        customerDataBase.add(this);  // Add new customer to the database
    }

    // Method to create a new customer.
    public static void createCustomer(String name, String phoneNumber, int rewardNumber, short rewardPoint) {
        new Customer(name, phoneNumber, rewardNumber, rewardPoint);
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
    public static void deleteCustomer(int rewardNumber) {
        customerDataBase.removeIf(customer -> customer.rewardNumber == rewardNumber);
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
}
