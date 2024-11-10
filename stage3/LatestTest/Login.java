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

    
    // Constructor to initialize the Login class
    public Login() {
        this.userID = "";
        this.password = "";
        this.loginStatus = "Logged Out";
        managerCheck = false;
        
    }

    // Method to ask for the username
    public void askUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Test Build: username is 'A001' for manager, 'B001' for employee");
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
    public boolean verifyLogin(String userID) {
        managerCheck = managerStatus(userID);
        if(managerCheck){
            if (userID.equals("AUser") && this.password.equals("pass")) {//Had to change to all letters for user id
                this.loginStatus = "Logged In";
                return true;
            } else {
                this.loginStatus = "Login Failed";
                return false;
            }
        }else if(!managerCheck){
            if (userID.equals("BUser") && this.password.equals("pass")) {
                this.loginStatus = "Logged In";
                return true;
            }else {
                this.loginStatus = "Login Failed";
                return false;
            }
        }
        return false;
    }
    
    //Method to verify manager status
    public boolean managerStatus(String userID){
        char[] letters;
        letters = userID.toCharArray();//makes list of letters in userID
        for(char letter : letters){//traverse letters
            
            if (letter == 'M'){//verifies manager status
                this.managerCheck = true;
                break;
            }else if(letter == 'E'){
                this.managerCheck = false;
                break;
            }
        }
        
        return managerCheck;
    }
  

    // Method to get the login status
    public String getLoginStatus() {
        return loginStatus;
    }

    // Method to perform the entire login process
    public void performLogin() {
        // Ask for username and password
        System.out.println("==========Login Menu==========");
        askUsername();
        askPassword();

        // Verify login credentials
        if (verifyLogin(this.userID)) {
            System.out.println("Login successful!");
            UserMenu user1 = new UserMenu();
        	user1.showOption(this.userID);
                        
        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }

        // Display current login status
        System.out.println("Current status: " + getLoginStatus());
    }

    
}
