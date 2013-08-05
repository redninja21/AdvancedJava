import java.util.*;

public class Calculator {
	
	ArrayList <String> operators;
	ArrayList <Integer> numbers;
	
	
	public Calculator (){
		operators = new ArrayList<String>();
		numbers = new ArrayList<Integer>();
		
		
	}
	
	
	public int Calculate(String expr){
		numbers.clear();
		operators.clear();
		
		String[] parts = expr.split(" ");
		for(String p : parts){
			System.out.print("[" + p + "]");
			
		}
		
		return 0;
		
		
	}
	

	private void reduce(){
		int num1 = numbers.remove(numbers.size()-1);
		int num2 = numbers.remove(numbers.size()-1);
		String op = operators.remove(operators.size()-1);
		if(op.equals("+")){
			numbers.add(num1 + num2);
			
		}
		
		if(op.equals("-")){
			numbers.add(num2 - num1);
			
		}
		
		if(op.equals("*")){
			numbers.add(num1 * num2);
			
		}
		
		if(op.equals("/")){
			numbers.add(num2 / num1);
			
		}
			
	}
	
	private void AddNumber(String number){
		int value = Integer.parseInt(number);
		numbers.add(value);
		
		
	}
	
	private void addOp(String op){
		operators.add(op);		
		
	}
	
	private boolean shouldReduce(String op){
		
		if(Precedence(lastOp())>=Precedence(op)){
			return true;
			
		}
				
		return false;
		
	}
	
	private String lastOp(){
		if(operators.size()>0){
		return operators.get(operators.size()-1);
		}
		return "";
	}
	
	private int Precedence(String operator){
		
		if(operator.equals("+")||operator.equals("-")){
			return 1;
		}
		if(operator.equals("*")||operator.equals("/")){
			return 2;
		}		
		return 0;
	}
	
	
	
	
	
}
