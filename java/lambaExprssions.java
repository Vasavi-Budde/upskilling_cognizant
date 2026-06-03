import java.util.*;
public class lambaExprssions {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Savitri");
        list.add("Ram");
         list.add("Anjali");
        list.add("Xerox");
        Collections.sort(list,(a,b)->a.compareTo(b));
        System.out.println(list);
    }
}
