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
			if(p.equals("(")){
				operators.add(p);
			}
			else if(p.equals(")")){
				while(!lastOp().equals("(")){
					reduce();
										
				}
				operators.remove(operators.size()-1);
				
			}
			else if(isOperator(p)){
				while (shouldReduce(p)){
					reduce();					
				}
				addOp(p);

			}
			else {
				AddNumber(p);
			}
		}
		while(operators.size()>0){
			reduce();
		}

		return numbers.get(0);
	}
	private boolean isOperator(String p){
		return p.equals("*")||p.equals("/")||p.equals("+")||p.equals("-");

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
