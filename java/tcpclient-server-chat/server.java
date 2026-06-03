import java.io.*;
import java.net.*;
public class server {
    public static void main(String[] args) {
        try {
            ServerSocket ss =  new ServerSocket(5000);
            System.out.println("server started...");
            Socket sk = ss.accept();
            System.out.println("client connected");
            BufferedReader in = new BufferedReader(
                 new InputStreamReader(
                        sk.getInputStream()));
            PrintWriter out =new PrintWriter(
                sk.getOutputStream(), true);
            String message = in.readLine();
            System.out.println( "Client: " + message);
            out.println( "Hello client, i got message!");
            sk.close();
            ss.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
