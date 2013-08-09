import java.awt.Color;
import java.awt.Graphics;


public class Player {
	int x;
	int y;
	int xv;
	int yv;
	
	public Player (int startx, int starty){
		x = startx;
		y = starty;
		
	}
	public void keyPressed(String key){
		if (key.equals("left")){
			xv = -5;
		}
		
		if (key.equals("right")){
			xv = 5;
		}
		if (key.equals("up")){
			yv = -5;
		}
		if (key.equals("down")){
			yv = 5;
		}
	}
	
	public void keyReleased(String key){
		if (key.equals("left")){
			xv = 0;
		}
		
		if (key.equals("right")){
			xv = 0;
		}
		if (key.equals("up")){
			yv = 0;
		}
		if (key.equals("down")){
			yv = 0;
		}
	}
	
	public void movePlayer(){
		if(x > 490) {
			x = 490;
		}
		if(x <10){
			x = 10;
		}
		if(y > 490){
			y = 490;
		}
		if(y<10){
			y=10;
		}
		x = x + xv;
		y = y + yv;
	}
	public void setVelocity(int xvelocity, int yvelocity){
		xv = xvelocity;
		yv = yvelocity;
	}
	
	public void move(){
		x = x + xv;
		y = y + yv;
		if(x > 490) {
			x = 490;
		}
		if(x <10){
			x = 10;
		}
		if(y > 490){
			y = 490;
		}
		if(y<10){
			y=10;
		}
		x = x + xv;
		y = y + yv;
	}
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.fillRect(x - 10, y - 10, 20, 20);
	}
}
