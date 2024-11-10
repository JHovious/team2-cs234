
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
    private HashMap<String,StaffDB> employees = new HashMap<>();
    private StaffDB testStaff = new StaffDB(name);
    private Scanner sc;
    private Scanner scanner;
    
    public Staff(){
        choice = true;
        option = 9;
        sc = new Scanner(System.in);
        scanner = new Scanner(System.in);
        createDummy();
        
    }
    
    //Create dummy info
    private void createDummy(){
        this.setName("George");
        StaffDB staff1A = new StaffDB("George", "B003", "2020-03-15", "Salesman", "sales@hardware.com", "775-859-9568", 50, 40, 80);
        addStaff(staff1A);
        this.setName("Frank");
        StaffDB staff2A = new StaffDB("Frank", "A003", "2023-06-30", "Assistant Manager", "AM@hardware.com", "505-867-5309", 10, 10, 5);
        addStaff(staff2A);
    }
    
    public void showMenu(){
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
                    showStaffInfo();
                        
                    choice = true;
                    break;
                case 2:
                    showSchedule();
                    choice = true;
                    break;
                case 3:
                    showStaffReport();
                    choice = true;
                    break;
                case 4:
                    System.out.println("Returning to Main Menu");
                    choice = false;
                    break;
                default:
                    System.out.println("Incorrect option. Please try again.");
            }
        }while(choice);
    }
    
    public void showStaffInfo(){
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
    
    public void showStaffReport(){
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
    
    public void addStaff(StaffDB staff){
        employees.put(this.getName(), staff);
    }
    
    public StaffDB getStaff(String name){
        return employees.get(name);
    }
    
    public void removeStaff(String name){
        employees.remove(name);
    }
    
    
}