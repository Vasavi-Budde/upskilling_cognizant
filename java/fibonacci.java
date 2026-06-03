import java.util.*;
public class fibonacci {
    public static int fib(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
        }

        // int a=0;
        // int b=1;
        // System.out.print(a +" "+b+" ");
        // for(int i=0;i<n;i++){
        //     int temp=a+b;
        //     a=b;
        //     b=temp;
        //     System.out.print(temp+" ");
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n=sc.nextInt();
        for(int i=0;i<=n;i++){
        System.out.println(fib(i));
        }
    }
}

