import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

	public static void main(String[] args) {
		ArrayList <String> list = new ArrayList <String>();  
		try {
			ServerSocket server = new ServerSocket(9090);
			while (true){
				Socket client = server.accept();	
				ChatLink runnable = new ChatLink(client,list);
				Thread t = new Thread(runnable);
				t.start();
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}	

	}

}
class ChatLink implements Runnable{
	PrintWriter output;
	Scanner input;
	ArrayList <String> chatroom;
	int position = 0;
	
	public ChatLink(Socket client, ArrayList<String> list) throws IOException{
		output = new PrintWriter(client.getOutputStream(),true);
		input = new Scanner(client.getInputStream());
		chatroom = list;
	}

	public void run() {
		while(true){
			String in = input.nextLine();
			if(in != null){
				System.out.println(in);
				chatroom.add(in);
			}
			while(position < chatroom.size()){
				output.println(chatroom.get(position));
				position++;
			}
		}
	}
	
}