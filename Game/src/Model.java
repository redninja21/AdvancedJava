import java.util.*;
public class Model {
	int playerX = 10, playerY = 10;
	int playerXV, playerYV;
	int level = 1;
	
	Player player;	
	ArrayList <Enemy> enemies;
	ArrayList <Obstacle> obstacles;
	public Model(){
		player = new Player(15,15);
		enemies = new ArrayList <Enemy> ();
		obstacles = new ArrayList <Obstacle> ();
		enemies.add(new Enemy(200,300));
		enemies.add(new Enemy(200,350));
		enemies.add(new Enemy(200,400));
		enemies.add(new Enemy(200,450));
		enemies.add(new Enemy(200,250));
		enemies.add(new Enemy(200,200));
		enemies.add(new Enemy(200,150));
		enemies.add(new Enemy(200,100));
		enemies.add(new Enemy(200,50));
		obstacles.add(new Obstacle(30,5,20,460));
		
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public Enemy getEnemy(int index){
		return enemies.get(index);
	}
	
	public Obstacle getObstacle(int index){
		return obstacles.get(index);
	}
	
	public int getEnemyCount(){
		return enemies.size();
	}
	
	public int getObstacleCount(){
		return obstacles.size();
	}
	public int getEnemyX(int index){
		return enemies.get(index).x;
	}
	public int getEnemyY(int index){
		return enemies.get(index).y;
	}
	
	public void setPosition(int x, int y){
		playerX = x;
		playerY = y;
	}
	
		
	
		
		
	public void moveEnemies(){
		for(int i = 0; i < enemies.size();i++){
			
		}
	}
}
