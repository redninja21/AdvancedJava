/**
 * This project is in the public domain hosted by TechLab Education, and is licensed under a Creative Commons 
 * Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 */

import greenfoot.*;

/**
 * The Turtle class describes the behavior of all turtle objects.
 * @author (your name)
 */
public class Turtle extends Animal
{   

    public void act()
    {
        

        if(atWorldEdge()){

            turn(10); 
        }
        if(Greenfoot.isKeyDown("up"))
        {
            move(5);
        }

        if(Greenfoot.isKeyDown("left"))
        {
            turn(-5);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            turn(5);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            move(-5);   
        }

        if(canSee(Bear.class))
        {
          if(Greenfoot.isKeyDown("space"))
          {
            eat(Bear.class);   
            }
        }   
    }
}

