import java.io.*;
import java.net.*;
import java.util.*;

public class HelloServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9090);
			while (true){
				Socket client = server.accept();	
				PrintWriter output = new PrintWriter(client.getOutputStream(), true);
				Scanner input = new Scanner(client.getInputStream());
				output.println("Hello from Akhil!");
				client.close();
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}	

	}

}
