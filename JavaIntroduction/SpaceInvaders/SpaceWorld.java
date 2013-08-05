import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceWorld extends World
{

    /**
     * Constructor for objects of class SpaceWorld.
     * 
     */
    public SpaceWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1); 
        addObject(new Rocket(), 181, 387);
        addObject(new Asteroid(), Greenfoot.getRandomNumber(800),Greenfoot.getRandomNumber(800));

    }
    public void act()
    {
        if(asteroids < 15 && Greenfoot.getRandomNumber(100) < 5){
            addObject(new Asteroid(), 792, Greenfoot.getRandomNumber(780) + 10);
            asteroids++;
        }    
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */

    static int asteroids = 0;
    public static int asteroids (){

        return asteroids;
    }

}
    
    