
/**
 *
 * Christian Kurdi
 * 
 */

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

public class Staff extends Person{
    
    private boolean choice;
    private int option;
    private StaffDB testStaff;
    private Scanner sc;
    private Scanner scanner;
    private HashMap<String, StaffDB> employees;
    
    public Staff(HashMap<String, StaffDB> employeesDB){
        choice = true;
        option = 9;
        sc = new Scanner(System.in);
        scanner = new Scanner(System.in);
        testStaff = new StaffDB(this.name);
        employees = employeesDB;
        employees.put(this.name, testStaff);
        
        
    }
      
    
    public Staff(HashMap<String, StaffDB> employeesDB, String name, String employeeId, String hireDate, String employeeTitle,
        String employeeEmail, String employeePhone, int pto, int sickTime, int unpaidTime){
        employees = employeesDB;
        this.name = name;
        StaffDB dummyStaff = new StaffDB(this.name, employeeId, hireDate, employeeTitle, employeeEmail, employeePhone, pto, sickTime, unpaidTime);
        employees.put(this.name, dummyStaff);
    }
    
     public void addDummyEmployees() {
        employees.put("Christian Kurdi", new StaffDB("Christian Kurdi", "001", "2022-01-01", "Manager", "krispykreme@tasty.com", "555-1234", 120, 80, 0));
        employees.put("Maya Fisher", new StaffDB("Maya Fisher", "002", "2023-03-05", "Assistant Manager", "the.og.fish@ocean.com", "555-4321", 80, 40, 3));
        employees.put("Justin Hovious", new StaffDB("Justin Hovious", "003", "1963-10-15", "Paint Chip Taster", "yungvapegod@aol.com", "555-0000", 1, 2, 4));
    }
    


	
   
    
    public void showMenu(HashMap<String, StaffDB> employees){
        do{
            System.out.println("------Staff Menu------");
            System.out.println("1. Show Staff Info");
            System.out.println("2. Show Schedule");
            System.out.println("3. Show Staff Report");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");
            
            option = sc.nextInt();
            
            switch(option){
                case 1: 
                    showStaffInfo(employees);
                        
                    choice = true;
                    break;
                case 2:
                    showSchedule();
                    choice = true;
                    break;
                case 3:
                    showStaffReport(employees);
                    choice = true;
                    break;
                case 4:
                    System.out.println("Returning to Staff Menu");
                    choice = false;
                    showMenu(employees);
                    break;
                default:
                    System.out.println("Incorrect option. Please try again.");
            }
        }while(choice);
    }
    
    public void showStaffInfo(HashMap<String, StaffDB> employees){
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        if (employees.get(name) != null){
            System.out.println("----Staff Info----");
            System.out.println("Employee Name: " + employees.get(name).getName());
            System.out.println("Employee ID: " + employees.get(name).getEmployeeId());
            System.out.println("Hire Date: " + employees.get(name).getHireDate());
            System.out.println("Employee Title: " + employees.get(name).getTitle());
            System.out.println("Employee Email: " + employees.get(name).getEmail());
            System.out.println("Employee Phone: " + employees.get(name).getPhone());
            System.out.println("PTO: " + employees.get(name).getPTO() + " hours");
            System.out.println("Sick Time: " + employees.get(name).getsickTime() + " hours");
            System.out.println("Unpaid Time: " + employees.get(name).getUnpaid() + " hours");
        }else {
            System.out.println("Employee not found. Returning to Staff Menu.");
        }
    }
    
    public void showStaffReport(HashMap<String, StaffDB> employees){
        Set<String> keySet = employees.keySet();
        System.out.println("----Staff Report----");           
        for (String key : keySet){
            
            System.out.printf("====Employee: %s====\n", employees.get(key).getName());
            System.out.println("Employee ID: " + employees.get(key).getEmployeeId());
            System.out.println("Hire Date: " + employees.get(key).getHireDate());
            System.out.println("Employee Title: " + employees.get(key).getTitle());
            System.out.println("Employee Email: " + employees.get(key).getEmail());
            System.out.println("Employee Phone: " + employees.get(key).getPhone());
            System.out.println("PTO: " + employees.get(key).getPTO() + " hours");
            System.out.println("Sick Time: " + employees.get(key).getsickTime() + " hours");
            System.out.println("Unpaid Time: " + employees.get(key).getUnpaid() + " hours");
            System.out.println(" ");
            System.out.println("Schedule for Next Week: ");
            showSchedule();
        }
        do{
            System.out.println("Enter 0 to return to the Staff menu.");
            int input = sc.nextInt();

            if (input == 0) {
                break;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        }while(true);
    }
    
    /**
     * Initializes the date and sets parameters for the following week.
     */
    private void showSchedule() {
        LocalDate today = LocalDate.now();
        LocalDate nextSunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate nextSaturday = nextSunday.plusDays(6);

        // Loop checks what date is being shown and only prints hours for the employees scheduled days. Otherwise prints "OFF".
        LocalDate currentDate = nextSunday;
        while (!currentDate.isAfter(nextSaturday)) {
            String schedule = (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) ? "OFF" : "9a-5p";
            System.out.println(currentDate + ": " + schedule);
            currentDate = currentDate.plusDays(1);
        }
    }
    
    
    
}