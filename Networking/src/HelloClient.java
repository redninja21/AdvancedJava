import java.io.*;
import java.net.*;
import java.util.*;

public class HelloClient {

	public static void main(String[]args){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the server's IP Adress: ");
		String ip = keyboard.nextLine();
		try {
			Socket sock = new Socket(ip,9090);
			PrintWriter output = new PrintWriter(sock.getOutputStream());
			Scanner input = new Scanner(sock.getInputStream());
			String in = input.nextLine();
			System.out.println(in);
			sock.close();

		} catch (UnknownHostException e) {
		} catch (IOException e) {
		}
	}
}
