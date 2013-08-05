import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Poop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Poop extends Actor
{
    int altitude = 100;
    
    public Poop(){
    
    GreenfootImage image = getImage();
    image.scale(25,25);
    
    
    }
    
    public void scalePoop(){
    GreenfootImage image = getImage();
    image.scale(altitude/4, altitude/4);
    
    }
    
    /**
     * Act - do whatever the Poop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(altitude > 4){ 
       altitude = altitude - 1;
       scalePoop();
    }
    
    else {
        getWorld().removeObject(this);
    
    }
    
    if(altitude < 20){
    checkForPeople();
    }
    
    
    
}

public void checkForPeople(){
    
    
    }
}
     
        

    

