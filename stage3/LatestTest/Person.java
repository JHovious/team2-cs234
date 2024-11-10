/**
 *
 * Christian Kurdi
 * Version: 1.0
 */
import java.util.Scanner;

public class Person {
    
    //Instance Variables
    private String name, phoneNumber;
    private Scanner sc;
    
    
    //Constructor
    public Person(){
        sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        this.name = sc.nextLine();
       
        System.out.print("Enter Phone Number: ");
        this.phoneNumber = sc.nextLine();
    }
}
