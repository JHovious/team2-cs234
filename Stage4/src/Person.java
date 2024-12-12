/**
 *
 * Christian Kurdi
 * Version: 1.0
 */
import java.util.Scanner;

public class Person {
    
    //Instance Variables
    public String name;
    
    
    //Constructor
    public Person(){
        name = "default";
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
}
