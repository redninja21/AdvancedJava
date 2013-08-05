
/**
 * Let's have fun with Strings first!
 */
public class StringFun
{
    public StringFun()
    {
    }

    public String firstLetter(String str) {
        return str.substring(0, 1);
    }
    
    public String firstThreeLetters(String str) {
        return str.substring(0,3);
    }
    
    public String combine(String part1, String part2) {
        return part1 + part2;
    }
    
    public String firstNLetters(String str, int n) {
        return str.substring(0,n);
    }
    
    public String addFunnyEnding(String str) {
        return str.length() - 3 + "erge" ;
    }
    
    public boolean beginsWithA(String str) {
        char first = str.charAt(0);
        return (first == 'a');
        
    }
    
    public String reverse(String str) {
        String reverse = "";
        int a = str.length()-1;
        while(a>=0){
            reverse = reverse + str.substring(a,a+1);
            a = a-1;
        
        }
        return reverse;
    }
}
