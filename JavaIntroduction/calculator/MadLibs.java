
/**
 * MadLib generator!
 */

import java.util.Scanner;

public class MadLibs
{
    public static void main(String[] args)
    {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("Enter an adjective:");
    String adjective1 = keyboard.nextLine();  
    System.out.print("Enter a noun:");
    String noun1 = keyboard.nextLine();
    System.out.print("Enter a noun:");
    String noun2 = keyboard.nextLine();
    System.out.print("Enter a name:");
    String name1 = keyboard.nextLine(); 
    System.out.print("Enter an adjective:");
    String adjective2 = keyboard.nextLine();
    System.out.print("Enter an adjective:");
    String adjective3 = keyboard.nextLine();
    System.out.print("Enter a noun:");
    String noun3 = keyboard.nextLine();
    System.out.print("Enter a place:");
    String place1= keyboard.nextLine();
    
    
    System.out.println("Once upon a time there was a "+ adjective1 + " man who lived in a " + noun1 + "." );   
    System.out.println("His name was "+ name1 + ".");
    System.out.println("His life's goal was to kill a " + noun2 + "." );
    System.out.println("After many attempts to locate this " + adjective2 + " " + noun2 +", Gregory finally accomplished his goal. "  );
    System.out.println("In order to finish this " + adjective3 + " task, he had to get supplies from the four corners of the world." );
    System.out.println("He had to get the " + noun3 + " from the peculiar place of " + place1 + ".");
    System.out.println("At last he forgot about the other supplies but realized he could do with what he had collected already. In the end he went back to his beautiful home and lived happily ever after.");
    
    }
}
