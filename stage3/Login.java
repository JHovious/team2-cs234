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

    // Constructor to initialize the Login class
    public Login() {
        this.userID = "";
        this.password = "";
        this.loginStatus = "Logged Out";
    }

    // Method to ask for the username
    public void askUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Test Build: username is 'user'");
        System.out.print("Enter username: ");
        this.userID = scanner.nextLine();
    }

    // Method to get the username
    public String getUsername() {
        return userID;
    }

    // Method to ask for the password
    public void askPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Test Build: password is 'pass'");
        System.out.print("Enter password: ");
        this.password = scanner.nextLine();
    }

    // Method to get the password
    public String getPassword() {
        return password;
    }

    // Method to verify login credentials
    public boolean verifyLogin() {
        if (this.userID.equals("user") && this.password.equals("pass")) {
            this.loginStatus = "Logged In";
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

    // Method to perform the entire login process
    public void performLogin() {
        // Ask for username and password
        askUsername();
        askPassword();

        // Verify login credentials
        if (verifyLogin()) {
            System.out.println("Login successful!");
                        
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
