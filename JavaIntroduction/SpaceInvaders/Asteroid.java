import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor
{
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        SpaceWorld world = (SpaceWorld) getWorld();
        setLocation(getX()-5,getY() );
      
    
    if(atLeftofWorld()){
    getWorld().removeObject(this);
    
    }
}

public boolean atLeftofWorld(){
if(getX()<10){
return true;

}
return false;
}

}