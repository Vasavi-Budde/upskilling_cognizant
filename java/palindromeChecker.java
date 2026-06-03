import java.util.*;
public class palindromeChecker {
    public static void pal( String s){
        String rev="";
        char ch[]=s.toCharArray();
        for(int i=s.length()-1;i>=0;i--){
            rev+=ch[i];
        }
        if(s.equals(rev)){
            System.out.println("Palindrome");
        }
        else{
            System.out.print("not Palindrome");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string : ");
        String str=sc.nextLine();
        String s=str.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        pal(s);
    }
}
