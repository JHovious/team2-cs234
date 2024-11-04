import java.util.Scanner;

public class Staff {

    private String employeeName = "John Doe";
    private String employeeId = "001";
    private String hireDate = "2022-01-01";
    private String employeeTitle = "Cashier";
    private String employeeEmail = "john.doe@example.com";
    private String employeePhone = "555-555-5555";
    private Byte pto = 20;
    private Byte sickTime = 20;
    private Byte unpaidTime = 80;

    // Method to show all staff info
    public void showStaffInfo() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {       
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Hire Date: " + hireDate);
        System.out.println("Employee Title: " + employeeTitle);
        System.out.println("Employee Email: " + employeeEmail);
        System.out.println("Employee Phone: " + employeePhone);
        System.out.println("PTO: " + pto + " hours");
        System.out.println("Sick Time: " + sickTime + " hours");
        System.out.println("Unpaid Time: " + unpaidTime + " hours");
        System.out.println(" ");
        System.out.println("Enter '0' to return to the main menu.");
        String input = scanner.nextLine();
        
        if (input.equals("0")) {
            exit = true;
        } else {
            System.out.println("Invalid input, please try again.");
        }
      }

   }
}
