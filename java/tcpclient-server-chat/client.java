
import java.io.*;
import java.net.*;
public class client {
    public static void main(String[] args) {
        try {
            Socket sok =new Socket("localhost", 5000);
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(
                                    sok.getInputStream()));
            PrintWriter out =
                    new PrintWriter(
                            sok.getOutputStream(),
                            true);
            out.println("hii server");
            String response = in.readLine();
            System.out.println( "server: " + response);
            sok.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
