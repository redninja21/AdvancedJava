import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnakeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeWorld extends World
{

    /**
     * Constructor for objects of class SnakeWorld.
     * 
     */
    public SnakeWorld()
    {    
        
        super(800, 800, 1);
        int plums = 0;
        while (plums < 15){
        addObject(new Plum(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(800));
        plums++;
        
        }
        
        addObject(new Snake(),Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(800));
    }
}
