import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TheCloset extends JFrame implements ActionListener {
	JTextArea area;
	JTextField field;
	ChatClient client;
	
	public static void main(String[] args) {
		new TheCloset();

	}

	public TheCloset(){
		super("The Closet");
		setSize(new Dimension(800,800));
		init();
		setVisible(true);
		
		Timer t = new Timer();
		t.scheduleAtFixedRate(new UpdateTask(), 1000, 100);
	}
   class UpdateTask extends TimerTask{
	   
		public void run() {
			String in = client.getInput();
			if(in!=null){
				area.append("\n");
				area.append(in);
				
			}
			
		}
		
	}

	

	
	public void init () {
		String ip = JOptionPane.showInputDialog("What is the server's IP Address?");
		client = new ChatClient(ip);
		area = new JTextArea(30,20);
		add(area,BorderLayout.NORTH);
		field = new JTextField(20);
		field.addActionListener(this);
		add(field,BorderLayout.SOUTH);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==field){
			client.SendOut(field.getText());
			field.setText("");
		}
		
	}
	
	
	}

