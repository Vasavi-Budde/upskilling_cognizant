import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class fileWrting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            FileWriter fw=new FileWriter("output.txt");
            System.out.println("  Enter some text to write");
            fw.write(sc.nextLine());
            fw.close();
            System.out.println("File written succesfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }}
    }

