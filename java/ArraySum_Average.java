import java.util.*;
public class ArraySum_Average {
    public static void add(int n,int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        System.out.println("Sum is : "+sum);
        System.out.println("Avg is : "+(double)sum/n);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter arr size : ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter arr ele : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        add(n,arr);
    }
}
