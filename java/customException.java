import java.util.*;
class InvalidAgeException extends Exception{

    public InvalidAgeException(String message) {
        super(message);
    }
    
}
public class customException {
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter age : ");
    int age=sc.nextInt();
    try {
        if(age<18){
            throw new InvalidAgeException("Age must be greater thean 18");
        }
        else{
            System.out.println("You are eligible");
        }
    } catch (InvalidAgeException e) {
        System.out.println(e.getMessage());
    }}

}
