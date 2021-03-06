import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Projectile represents a projectile that is launched from a rocket.
 * 
 * @author (your name)
 * @version 1.0
 */
public class Projectile extends Actor
{
    /**
     * A projectile should move, and destroy if it is hitting an asteroid or on the edge of the world.
     */
    public void act() 
    {
        move(10);
        
        if(atWorldEdge()){
        
            destroy();
        
        }
        
        else{
         checkForAsteroid();
        }
    }    
    
    /**
     * Checks if we are hitting an asteroid, and shrinks the asteroid if
     * we are in contact with one. Afterwards, the projectile disappears.
     */
    public void checkForAsteroid()
    {
        Asteroid a = (Asteroid) getOneObjectAtOffset(10, 10, Asteroid.class);
        if ( a != null )
        {
            a.shrink();
            destroy();
        }
    }
    
        public void moveTowardAsteroid()
    {
        Asteroid a = (Asteroid) getOneObjectAtOffset(100, 100, Asteroid.class);
        if ( a != null )
        {
           turnTowards(a.getX(),a.getY());
        }
    }
    
    
    /**
     * Checks if this projectile is at the edge of our world.
     */
    public boolean atWorldEdge()
    {
        
        if(getX()>=595){
            return true;
        }
        if(getX()<=5){
            return true;
        }
        if(getY()>=595){
            return true;
        }
        if(getY()<=5){
            return true;
        }
        return false;
    }
    
    /**
     * Removes this projectile from the world.
     */
    public void destroy()
    {
        World w = getWorld();
        w.removeObject(this);
    }
}
