import java.util.*;
public class tryCatch {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a value : ");
        int a=sc.nextInt();
        System.out.println("Enter b value : ");
        int b=sc.nextInt();
        int sol=0;
        try {
            sol=a/b;
            System.out.println(sol);

        } catch (ArithmeticException e) {
            System.out.println("cannot divided by zero ,"+e.getMessage());
        }}
    }

