import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleChatClient {

	public static void main(String[]args){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the server's IP Adress: ");
		String ip = keyboard.nextLine();
		try {
			Socket sock = new Socket(ip,9090);
			PrintWriter output = new PrintWriter(sock.getOutputStream(), true);
			Scanner input = new Scanner(sock.getInputStream());
			
			while(true){
				System.out.print("You: ");
				String in = keyboard.nextLine();
				output.println(in);
				
			}
			

		} catch (UnknownHostException e) {
		} catch (IOException e) {
		}
	}
}
