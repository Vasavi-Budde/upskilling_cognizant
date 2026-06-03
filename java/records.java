import java.util.*;
import java.util.stream.Collectors;
record Person(String name,int age){}
public class records {
    public static void main(String[] args) {
        Person p1=new Person("vasavi",20);
        Person p2=new Person("Roshini",25);
        Person p3=new Person("Tanmayee",16);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        List<Person> list = Arrays.asList(p1,p2,p3);
        List<Person> vote=list.stream()
        .filter(x -> x.age()>=18)
        .collect(Collectors.toList());
        System.out.println("Eligible : ");
        System.out.println(vote);
    }
}
