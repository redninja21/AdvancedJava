import java.util.*;
public class Test {
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		int result = calc.Calculate("( 1 + 2 ) * ( 3 + 4 )");
		System.out.println("Result: " + result);
		
	}

}
