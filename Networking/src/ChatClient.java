import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
	PrintWriter output;
	Scanner input;
	public ChatClient(String ip){
		
		try {			
			Socket sock = new Socket(ip,9090);
			output = new PrintWriter(sock.getOutputStream(), true);
			input = new Scanner(sock.getInputStream());
					

		} catch (UnknownHostException e) {
		} catch (IOException e) {
		}
	
	}
	public void SendOut(String out){
		output.println(out);
	}
	public String getInput(){
		return input.nextLine();
		
	}
	
}
 
