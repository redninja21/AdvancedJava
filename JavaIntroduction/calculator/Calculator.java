
/**
 * Calculator is a simple calculator written in Java.
 * 
 * @author (your name)
 */
public class Calculator
{
    /**
     * Returns whatever input you give to it.
     */
    public int returnMe(int num)
    {
        return num;
    }

    /**
     * Returns the input you give it, plus one.
     */
    public int addOne(int num)
    {
        return num + 1;
    }

    /**
     * Returns the sum of the two inputs.
     */
    public int add(int x, int y)
    {
        int sum;    // Create a space in memory named sum
        sum = x+y;  // Assign 0 to that place in memory
        return sum; // Return the value in that named place in memory
    }

    /**
     * Returns the difference between the two inputs.
     */
    public int subtract(int x, int y)
    {
        int difference = x-y;
        return difference;
    }

    /**
     * Returns the product of the two inputs.
     */
    public int multiply(int x, int y)
    {
        // Your code here
        return x*y;
    }

    /**
     * Returns the first input divided by the second input.
     */
    public int divide(int x, int y)
    {
        // Your code here
        return x/y;
    }

    /**
     * Returns the value of the greatest of the two inputs.
     */
    public int whichIsGreater(int x, int y)
    {

        if(x>y)
        {
            return x;
        }
        else
        {
            return y;
        }
    }

    /**
     * Returns the value of the greatest of the three inputs.
     */
    public int whichIsGreater(int x, int y, int z)
    {
        return whichIsGreater(whichIsGreater(x,y), z);

    }

    /**
     *  FORESHADOWING
     *  Saving data into this calculator (i.e. saving data in a class)
     */

    int saved;

    public void save(int number) {
        saved = number;
    }

    public int retrieve() {
        return saved;
    }
}
