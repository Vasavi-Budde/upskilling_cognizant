import java.lang.reflect.Method;
class Student {
    public void display() {
        System.out.println("Hello from Student Class");
    }
}
public class reflection {
     public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Student");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method[] methods = cls.getDeclaredMethods();
        System.out.println("methods:");
        for(Method m : methods) {
            System.out.println(m.getName());
            m.invoke(obj);
        }
    }
}
