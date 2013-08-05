import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        checkFireKey();
    }
    
    public void checkKeys(){
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY()-10);
        
        }
        
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+10);
        
        }
         if(Greenfoot.isKeyDown("r")){
            setLocation(getX(), getY()+15);
        
        }
         if(Greenfoot.isKeyDown("t")){
            setLocation(getX(), getY()-15);
        
        }
        
    
    }
    
    public void checkFireKey(){
        if("space".equals(Greenfoot.getKey())){
            fireProjectile();
        
        }
        
    
    }
    
    public void fireProjectile(){
        getWorld().addObject(new Projectile(),getX() , getY());
    
    }
}
