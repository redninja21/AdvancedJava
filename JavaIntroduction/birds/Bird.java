import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bird extends Actor
{
    /**
     * Act - do whatever the Bird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(3);
        checkKeys();
        checkPoopKey();
           
        
        
        
    }   
    
    public void avoidWorldEdge(){
    
    
    }
    
    public void checkKeys(){

        if(Greenfoot.isKeyDown("up")){
            move(7);

        }
        
        if(Greenfoot.isKeyDown("down")){
        move(-7);
        
        }
        
        if(Greenfoot.isKeyDown("right")){
        turn(5);
        
        }
        
        if(Greenfoot.isKeyDown("left")){
        turn(-5);
        
        }

    
    }

    public void checkPoopKey(){
        if("space".equals(Greenfoot.getKey())){
            firePoop(); 

        }

    }
    
    public void firePoop(){
        Poop p1 = new Poop();
        
        getWorld().addObject(p1,getX(),getY() );
   
    }

    
}
