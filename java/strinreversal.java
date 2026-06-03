import java.util.*;
public class strinreversal {
    public static void rev(String s){
        StringBuilder reve=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            reve.append(s.charAt(i));
        }
        System.out.println(reve);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String : ");
        String s=sc.next();
        rev(s);
    }
}
