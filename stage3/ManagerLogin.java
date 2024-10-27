import java.util.Scanner;

/**
 * Handles the login for manager specific access and directs user to the Manager Menu
 * Manager Menu call needs to be implemented.
 * @author jahov
 */
public class ManagerLogin {
    private String userID;
    private String password;
    private String loginStatus;

    //Initializes instance variables
    public ManagerLogin() {
        this.userID = "";
        this.password = "";
        this.loginStatus = "Logged Out";
    }

    //Asks user for username
    public void askUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Test Build: username is 'manager'");
        System.out.print("Enter username: ");
        this.userID = scanner.nextLine();
    }

    //Stores username input as stored return value
    public String getUsername() {
        return userID;
    }

    //Asks user for password
    public void askPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Test Build: password is 'pass'");
        System.out.print("Enter password: ");
        this.password = scanner.nextLine();
    }

    //Stores password input as stored return value
    public String getPassword() {
        return password;
    }

    // loop verifies if user and pass input matches returned values and provides login status
    public boolean verifyLogin() {
        if (this.userID.equals("manager") && this.password.equals("pass")) {
            this.loginStatus = "Logged In";
            return true;
        } else {
            this.loginStatus = "Login Failed";
            return false;
        }
    }

    //Stores login status as return value
    public String getLoginStatus() {
        return loginStatus;
    }

    /**
     * Calls login methods and loginStatus to either failed login state where user is redirected 
     * to retry login or is passed to manager menu
     */
    public void performLogin() {
        askUsername();
        askPassword();

        if (verifyLogin()) {
            System.out.println("Login successful!");
            //ADD OBJ instantiation and ManagerMenu() here

        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }

        System.out.println("Current status: " + getLoginStatus());
    }

    //Initializes obj ManagerLogin and calls performLogin()
    public static void main(String[] args) {
        ManagerLogin login = new ManagerLogin();
        login.performLogin();
    }
}
