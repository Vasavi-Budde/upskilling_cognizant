import java.util.*;
public class hashmap {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter how many pairs : ");
        int n=sc.nextInt();
        HashMap<Integer,String> map=new HashMap<>();
        System.out.println("Enter key value pairs : ");
        for(int i=0;i<n;i++){
            map.put(sc.nextInt(),sc.next());
        }
        System.out.println(map);
        System.out.println("Enter number you want value : ");
        int val=sc.nextInt();
        if(map.containsKey(val)){
        System.out.println(map.get(val));
        }
        else{
            System.out.println("id not found");
        }
    }
}
