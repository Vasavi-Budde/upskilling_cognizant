import java.util.*;
public class numberGuessingGame {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        int randomNumber = r.nextInt(100)+1;
        while (true) { 
            System.out.println("guess a number between 1 to 100");
            int guess=sc.nextInt();
            if(guess >randomNumber){
                System.err.println("Too high");
            }
            else if(guess<randomNumber){
                System.out.println("Too low");
            }
            else{
                System.out.println("correct number");
                break;
            }
        }
        
    }
}
