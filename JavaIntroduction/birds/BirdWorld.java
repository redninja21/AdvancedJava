import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BirdWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BirdWorld extends World
{

    /**
     * Constructor for objects of class BirdWorld.
     * 
     */
    public BirdWorld()
    {    
        
        super(800, 800, 1); 
        populate();
    }
    
    public void act(){
    
    
    if(Greenfoot.getRandomNumber(100) == 3 ){
        addObject(new Person(), Greenfoot.getRandomNumber(790), Greenfoot.getRandomNumber(790) );
    
    }
    
    }
    
    public void populate(){
    Bird b1 = new Bird();
    
    
    addObject(b1, 381,387);
    
    
    }
}
