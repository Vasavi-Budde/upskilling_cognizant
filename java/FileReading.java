
import java.io.*;
import java.util.*;

public class FileReading {
    public static void main(String args[]){
        try {
            File f=new File("output.txt");
            Scanner sc=new Scanner(f);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }}
    }




