import java.util.LinkedList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;

/**
 * Method prints all employee info when selected in UserMenu.
 * Author: Justin Hovious
 */
public class Staff {

    // LinkedList to store all staff members
    private LinkedList<StaffMember> staffList = new LinkedList<>();

    // Constructor to initialize the Staff class with predefined users
    public Staff() {
        // Adding predefined users
        addStaffMember("John Doe", "A001", "2022-01-01", "Manager", "john.doe@example.com", "555-555-5555", (byte) 20, (byte) 20, (byte) 80);
        addStaffMember("Jane Doe", "B002", "2023-01-01", "Cashier", "jane.doe@example.com", "555-555-5556", (byte) 15, (byte) 10, (byte) 70);
    }

    /**
     * Adds a new staff member to the list.
     */
    public void addStaffMember(String employeeName, String employeeId, String hireDate, String employeeTitle, String employeeEmail, String employeePhone, byte pto, byte sickTime, byte unpaidTime) {
        staffList.add(new StaffMember(employeeName, employeeId, hireDate, employeeTitle, employeeEmail, employeePhone, pto, sickTime, unpaidTime));
    }

    /**
     * Deletes a staff member from the list based on the employee ID.
     * @param employeeId the ID of the employee to be deleted.
     * @return true if the staff member was found and deleted, false otherwise.
     */
    public boolean deleteStaffMember(String employeeId) {
        for (StaffMember member : staffList) {
            if (member.getEmployeeId().equals(employeeId)) {
                staffList.remove(member);
                return true;
            }
        }
        return false;
    }

    /**
     * Updates a staff member's information based on the employee ID.
     * @param employeeId the ID of the employee to be updated.
     * @param newTitle the new title of the employee.
     * @param newEmail the new email address of the employee.
     * @param newPhone the new phone number of the employee.
     * @param newPto the new PTO hours of the employee.
     * @param newSickTime the new sick time hours of the employee.
     * @param newUnpaidTime the new unpaid time hours of the employee.
     * @return true if the staff member was found and updated, false otherwise.
     */
    public boolean updateStaffMember(String employeeId, String newTitle, String newEmail, String newPhone, byte newPto, byte newSickTime, byte newUnpaidTime) {
        for (StaffMember member : staffList) {
            if (member.getEmployeeId().equals(employeeId)) {
                member.setEmployeeTitle(newTitle);
                member.setEmployeeEmail(newEmail);
                member.setEmployeePhone(newPhone);
                member.setPto(newPto);
                member.setSickTime(newSickTime);
                member.setUnpaidTime(newUnpaidTime);
                return true;
            }
        }
        return false;
    }

    /**
     * Method to show all staff info
     */
    public void showStaffInfo() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            for (StaffMember member : staffList) {
                System.out.println("Employee Name: " + member.employeeName);
                System.out.println("Employee ID: " + member.employeeId);
                System.out.println("Hire Date: " + member.hireDate);
                System.out.println("Employee Title: " + member.employeeTitle);
                System.out.println("Employee Email: " + member.employeeEmail);
                System.out.println("Employee Phone: " + member.employeePhone);
                System.out.println("PTO: " + member.pto + " hours");
                System.out.println("Sick Time: " + member.sickTime + " hours");
                System.out.println("Unpaid Time: " + member.unpaidTime + " hours");
                System.out.println(" ");
                System.out.println("Schedule for Next Week: ");
                showSchedule();
                System.out.println("Enter '0' to return to the main menu.");
                String input = scanner.nextLine();
                
                if (input.equals("0")) {
                    exit = true;
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            }
        }
        scanner.close();
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

    /**
     * Inner class to represent a staff member.
     */
    private static class StaffMember {
        private String employeeName;
        private String employeeId;
        private String hireDate;
        private String employeeTitle;
        private String employeeEmail;
        private String employeePhone;
        private Byte pto;
        private Byte sickTime;
        private Byte unpaidTime;

        public StaffMember(String employeeName, String employeeId, String hireDate, String employeeTitle, String employeeEmail, String employeePhone, byte pto, byte sickTime, byte unpaidTime) {
            this.employeeName = employeeName;
            this.employeeId = employeeId;
            this.hireDate = hireDate;
            this.employeeTitle = employeeTitle;
            this.employeeEmail = employeeEmail;
            this.employeePhone = employeePhone;
            this.pto = pto;
            this.sickTime = sickTime;
            this.unpaidTime = unpaidTime;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeTitle(String employeeTitle) {
            this.employeeTitle = employeeTitle;
        }

        public void setEmployeeEmail(String employeeEmail) {
            this.employeeEmail = employeeEmail;
        }

        public void setEmployeePhone(String employeePhone) {
            this.employeePhone = employeePhone;
        }

        public void setPto(Byte pto) {
            this.pto = pto;
        }

        public void setSickTime(Byte sickTime) {
            this.sickTime = sickTime;
        }

        public void setUnpaidTime(Byte unpaidTime) {
            this.unpaidTime = unpaidTime;
        }
    }
}
