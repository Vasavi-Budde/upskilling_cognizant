import java.util.*;
public class simpleCalculator {
    static void add(int a, int b,int ch){
        int result=0;
         switch(ch) {
            case '+':
                result=a+b;
                break;
            case '-':
                result=a-b;
                break;
            case '*':
                result=a*b;
                break;
            case '/':
                result=a/b;
                break;
            case '%':
                result=a%b;
                break;
            default:
                System.out.println("Enter correct option");
        }
        System.out.println("Result is : "+result);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a value : ");
        int a=sc.nextInt();
        System.out.println("Enter b value : ");
        int b=sc.nextInt();
        System.out.println("Enter any character(+,-,/,%,*)");
        char ch=sc.next().charAt(0);
        add(a,b,ch);
    }
}
