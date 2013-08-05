import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wombat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bear extends Animal
{
    /**
     * Act - do whatever the Wombat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      
      
      if(atWorldEdge())
      {
         turn(Greenfoot.getRandomNumber(Greenfoot.getRandomNumber(20)+10)); 
        }
      if(canSee(Turtle.class))
      {
        if(Greenfoot.isKeyDown("shift"))
        {
        eat(Turtle.class);
        }
        }  
      if(Greenfoot.isKeyDown("a"))
      {
        turn(-5);
        }
      if(Greenfoot.isKeyDown("s"))
      {
        move(-5);
        }  
      if(Greenfoot.isKeyDown("d")){
        turn(5);
        }
      if(Greenfoot.isKeyDown("w"))
      {
        move(5);
        }  
      
     
    }    
 }
