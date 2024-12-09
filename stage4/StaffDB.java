



/**
 *
 * Christian Kurdi
 */
import java.util.Scanner;

public class StaffDB {
    
    private String employeeName;
    private String employeeId;
    private String hireDate;
    private String employeeTitle;
    private String employeeEmail;
    private String employeePhone;
    private int pto;
    private int sickTime;
    private int unpaidTime;
    
    //Constructor
    public StaffDB(String name){
        this.employeeName = name;
        this.employeeId = "001";
        this.hireDate = "2022-01-01";
        this.employeeTitle = "Cashier";
        this.employeeEmail = "john.doe@example.com";
        this.employeePhone = "555-555-5555";
        this.pto = 20;
        this.sickTime = 20;
        this.unpaidTime = 80;
                
    }
    
    
    public StaffDB(String name, String employeeId, String hireDate, String employeeTitle,
            String employeeEmail, String employeePhone, int pto, int sickTime, int unpaidTime){
        this.employeeName = name;
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
    
    public String getName(){
        return this.employeeName;
    }
    
    public String getHireDate(){
        return this.hireDate;
    }
    
    public String getTitle(){
        return this.employeeTitle;
    }
    
    public String getEmail(){
        return this.employeeEmail;
    }
    
    public String getPhone(){
        return this.employeePhone;
    }
    
    public int getPTO(){
        return this.pto;
    }
    
    public int getsickTime(){
        return this.sickTime;
    }
    
    public int getUnpaid(){
        return this.unpaidTime;
    }
    
    public void setName(String name){
        this.employeeName = name;
    }
    
    public void setEmployeeID(String id){
        this.employeeId = id;
    }
    
    public void setHireDate(String hireDate){
        this.hireDate = hireDate;
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

    public void setPto(int pto) {
        this.pto = pto;
    }

    public void setSickTime(int sickTime) {
        this.sickTime = sickTime;
    }

    public void setUnpaidTime(int unpaidTime) {
        this.unpaidTime = unpaidTime;
    }    
    
}
