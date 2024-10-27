import java.util.Scanner;

/**
 * Initial user menu, directs user to either user login or manager login
 * @author Justin Hovious
 */
public class LoginMenu {
    public void showLoginMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select login type:");
        System.out.println("1. User Login");
        System.out.println("2. Manager Login");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        //Handles user input to call correct login method
        switch (choice) {
            case 1:
                Login userLogin = new Login();
                userLogin.performLogin();
                break;
            case 2:
                ManagerLogin managerLogin = new ManagerLogin();
                managerLogin.performLogin();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showLoginMenu(); // Recursive call to show the menu again
        }
    }
}
