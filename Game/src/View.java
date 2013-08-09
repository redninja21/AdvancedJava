import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;


public class View extends JPanel {
	Controller control;
	public View (){
		control = new Controller(this);
		addKeyListener(control);
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask(){

			
			public void run() {
				control.move();
				repaint();
				
			}
			
		}, 0, 50);
	}
	
	public void paintComponent(Graphics g){
		
		paintBackground(g);
		control.getPlayer().paint(g);
		for(int x = 0; x < control.getEnemyCount(); x++){
			control.getEnemy(x).paint(g);
		}
		
		
	}
	//Step 1 : paint the background
	public void paintBackground(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0,0, 500, 500);
		g.setColor(Color.lightGray);
		g.fillRect(5, 5, 490, 490);
		g.setColor(Color.black);
		for(int x = 0; x<control.getObstacleCount(); x++){
			control.getObstacle(x).paint(g);
		}
		g.setColor(Color.green);
		g.fillRect(410, 5, 85, 85);
		
	}
	//Step 2 : paint the player
	public void paintPlayer(Graphics g){
		g.setColor(Color.red);
		g.fillRect(control.getPlayerX()-10, control.getPlayerY()-10, 20, 20);
	}
	//Step 3: paint the enemy
	public void paintEnemy(Graphics g, int x, int y){
		g.setColor(Color.BLUE);
		g.fillOval(x - 10, y - 10, 20, 20);
	}
	//Step 4: paint the obstacle
	
	
	public Dimension getSize(){
		return new Dimension(500,522);
		
	}
	
}
