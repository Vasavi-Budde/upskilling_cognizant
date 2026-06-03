public class methodOverloading {
    public static int add(int a , int b){
        return a+b;
    }
    public static double add(double a,double b){
        return a+b;
    }
    public static int add(int a, int b,int c){
        return a+b+c;
    }
    public static void main(String[] args) {
        System.out.println(add(1,2));
        System.out.println(add(5,20,12));
        System.out.println(add(15.2,18.5));
    }
}