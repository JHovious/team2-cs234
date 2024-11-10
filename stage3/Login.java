import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class requests login credentials from the users and verifies them 
 * prior to allowing access to the rest of the system.
 * @author Justin Hovious
 */
public class Login {
    private String userID;
    private String password;
    private String loginStatus;
    private boolean managerCheck;
    private static Map<String, User> users = new HashMap<>();

    // Static block to initialize the users map with predefined users
    static {
        users.put("A001", new User("A001", "pass", true));  // John Doe as manager
        users.put("B002", new User("B002", "pass", false)); // Jane Doe as cashier
    }

    // Constructor to initialize the Login class
    public Login() {
        this.userID = "";
        this.password = "";
        this.loginStatus = "Logged Out";
        this.managerCheck = false;
    }

    // Method to ask for the username
    public void askUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Test Build: username is 'A001' or 'B002'");
        System.out.print("Enter username: ");
        this.userID = scanner.nextLine();
    }

    // Method to ask for the password
    public void askPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Test Build: password is 'pass'");
        System.out.print("Enter password: ");
        this.password = scanner.nextLine();
    }

    // Method to verify login credentials
    public boolean verifyLogin() {
        User user = users.get(this.userID);
        if (user != null && user.getPassword().equals(this.password)) {
            this.loginStatus = "Logged In";
            this.managerCheck = user.isManager();
            return true;
        } else {
            this.loginStatus = "Login Failed";
            return false;
        }
    }

    // Method to get the login status
    public String getLoginStatus() {
        return loginStatus;
    }

    // Method to check if the user is a manager
    public boolean isManager() {
        return managerCheck;
    }

    // Method to perform the entire login process
    public void performLogin() {
        // Ask for username and password
        askUsername();
        askPassword();

        // Verify login credentials
        if (verifyLogin()) {
            System.out.println("Login successful!");

            // Create a Tickets object to pass to the UserMenu
            Tickets tickets = new Tickets();
            
            // Call UserMenu with the Tickets object
            UserMenu user1 = new UserMenu();
            user1.showOption(tickets);

        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }

        // Display current login status
        System.out.println("Current status: " + getLoginStatus());
    }

    public static void main(String[] args) {
        // Create an instance of Login and perform the login process
        Login login = new Login();
        login.performLogin();
    }
}
