import javax.swing.JFrame;


public class Game extends JFrame {
	public static void main(String [] args){
		new Game();
		
	}
	public Game(){
		super("The World's Hardest Game");
		View view = new View();
		add(view);
		addKeyListener(view.control);
		setSize(view.getSize());
		setVisible(true);
		setResizable(false);
	}
}
