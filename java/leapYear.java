import java.util.*;
public class leapYear {
    public static void leap(int n){
        if((n%4 == 0 && n%100 !=0 ) ||( n%400==0)){
            System.out.println("Leap year");
        }
        else{
            System.out.println("Not Leap year ");
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter year");
        int n=sc.nextInt();
        leap(n);
    }
}
