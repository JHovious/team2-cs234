import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;


/**
 * Method prints all employee info when selected in UserMenu.
 * @author Justin Hovious
 */
public class Staff {

    //Instantiates instance variables. Will be changed to read from employee list later. 
    private String employeeName;
    private String employeeId;
    private String hireDate;
    private String employeeTitle;
    private String employeeEmail;
    private String employeePhone;
    private Byte pto;
    private Byte sickTime;
    private Byte unpaidTime;
    
    //Constructor
    public Staff(){
        this.employeeName = "John Doe";
        this.employeeId = "001";
        this.hireDate = "2022-01-01";
        this.employeeTitle = "Cashier";
        this.employeeEmail = "john.doe@example.com";
        this.employeePhone = "555-555-5555";
        this.pto = 20;
        this.sickTime = 20;
        this.unpaidTime = 80;
                
    }

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
        System.out.println("Schedule for Next Week: ");
        showSchedule();
        System.out.println("Enter '0' to return to the main menu.");
        String input = scanner.nextLine();
        
        //Loop to prevent user from being sent back to main menu before exiting.
        if (input.equals("0")) {
            exit = true;
        } else {
            System.out.println("Invalid input, please try again.");
        }
      }

   }
   //Initializes the date and sets parameters for the following week. 
    private void showSchedule() {
        LocalDate today = LocalDate.now();
        LocalDate nextSunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate nextSaturday = nextSunday.plusDays(6);

       //Loop checks what date is being shown and only prints hours for the 
        // employees scheduled days. Otherwise prints "OFF".
        LocalDate currentDate = nextSunday;
        while (!currentDate.isAfter(nextSaturday)) {
            String schedule = (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) ? "OFF" : "9a-5p";
            System.out.println(currentDate + ": " + schedule);
            currentDate = currentDate.plusDays(1);
        }
    }
    
    //ManagerMenu method to create new staff
    public void createNew(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name: ");
        this.employeeName = sc.nextLine();
        System.out.println("Enter the ID: ");
        this.employeeId = sc.nextLine();
        System.out.println("Enter hire date: ");
        this.hireDate = sc.nextLine();
        System.out.println("Enter employee title: ");
        this.employeeTitle = sc.nextLine();
        System.out.println("Enter employee email: ");
        this.employeeEmail = sc.nextLine();
        System.out.println("Enter phone number: ");
        this.employeePhone = sc.nextLine();
        this.pto = 20;
        this.sickTime = 20;
        this.unpaidTime = 80;
        
    }
    
    //ManagerMenu method to update staff
    public void update(int option){
        
    }
}
