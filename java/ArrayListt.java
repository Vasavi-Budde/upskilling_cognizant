import java.util.*;
public class ArrayListt {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> list=new ArrayList<>();
        System.out.println("How many names : ");
        int n=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter names : ");
        for(int i=0;i<n;i++){
        list.add(sc.nextLine());
        }
        System.out.println("Students are : ");
        for(String names : list){
        System.out.println(names);
    }
}
}
