import java.util.*;
import java.util.stream.Collectors;
public class sreamAPI {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(1,2,3,4,5,6);
        List<Integer> even= list.stream()
        .filter(x -> x%2==0)
        .collect(Collectors.toList());
        System.out.println(even);
    }
}
