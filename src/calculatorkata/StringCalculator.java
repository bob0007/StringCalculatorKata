package calculatorkata;

import java.util.Arrays;
import java.util.List;

public class StringCalculator implements Calculator {
	public int run(String statement) {
		if(statement == null) {
			return 0;
		}
		statement = statement.replace(" ", "").replace("\n", "");
		
		if (statement.length() == 0) {
			return 0;
		}
		return (int) Math.round(parseStatement(statement));
	}
	
	private double parseStatement(String statement) {
		if (statement.isEmpty()) {
			return 0;
		}
		if (statement.startsWith("(")) {
			int closingIndex = getIndexOfNextTopLevelClosingParens(statement);
			return parseOporatorExpression(parseStatement(statement.substring(1, closingIndex)), statement.substring(closingIndex + 1));
		}
		int opIndex = getIndexOfOporator(statement.substring(1)) + 1; //First char of statement can not be an operator
		if (opIndex == 0) {
			return Double.parseDouble(statement);
		}
		return parseOporatorExpression(Double.parseDouble(statement.substring(0, opIndex)), statement.substring(opIndex));
	}
	
	private int getIndexOfNextTopLevelClosingParens(String s) {
		int level = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				level++;
			}
			if (s.charAt(i) == ')') {
				level--;
				if (level == 0) {
					return i;
				}
			}
		}
		return -1;
	}
	
	
	List<Character> opList = Arrays.asList('(', '^', '*', '/', '-', '+', '%');
	private int getIndexOfOporator(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (opList.contains(s.charAt(i))) {
				return i;
			}
		}
		return -1;
	}
	
	private double parseOporatorExpression(double firstNumber, String opExpression) {
		if (opExpression.isEmpty()) {
			return firstNumber;
		}
		char currentOporator = opExpression.charAt(0);
		
		 if (currentOporator == '(') { //Implied multiplication case
				//To be implemented
				System.out.println("Implementation of implied multiplication pending.");
		}
		
		int nextOporatorIndex = getIndexOfOporator(opExpression.substring(1)) + 1;
		char nextOporator;
		if (nextOporatorIndex == 0) {//Only one operator so no second operator
			nextOporator = ' ';
		} else {
			nextOporator = opExpression.charAt(nextOporatorIndex);
		}
		if (nextOporator == '(') {
			int closeIndex = getIndexOfNextTopLevelClosingParens(opExpression); //Needs to me improved.  Will fail with expressions with two sets of non nested ()
			if (closeIndex == -1) {
				throw new RuntimeException("No closing )");
			}
			if (closeIndex == opExpression.length() - 1) {//Only one operator so no second operator
				nextOporator = ' ';
				nextOporatorIndex = 0;
			} else {
				nextOporatorIndex = closeIndex + 1;
				nextOporator = opExpression.charAt(nextOporatorIndex);
			}
		}
		
		boolean presidence;
		
		if (nextOporatorIndex == 1 && nextOporator == '-') {//Unary minus case
			nextOporatorIndex = getIndexOfOporator(opExpression.substring(2)) + 2;
			nextOporator = opExpression.charAt(nextOporatorIndex);
		}
		
		if (nextOporatorIndex == 0) {//Only one operator so no second operator.  Same operation as presidence false
			presidence = false;
		} else{
			presidence = opList.indexOf(currentOporator) <= opList.indexOf(nextOporator);
			
		}
		
		if (presidence) {
			double secondNum = parseStatement(opExpression.substring(1, nextOporatorIndex));
			String remainingStatement = opExpression.substring(nextOporatorIndex);
			switch (currentOporator) {
			case '^':
				return parseOporatorExpression(Math.pow(firstNumber, secondNum), remainingStatement);
			case '*':
				return parseOporatorExpression(firstNumber * secondNum, remainingStatement);
			case '/':
				return parseOporatorExpression(firstNumber / secondNum, remainingStatement);
			case '-':
				return parseOporatorExpression(firstNumber - secondNum, remainingStatement);
			case '+':
				return parseOporatorExpression(firstNumber + secondNum, remainingStatement);
			case '%':
				return parseOporatorExpression(firstNumber % secondNum, remainingStatement);
			default:
				throw new RuntimeException("Internal error: invalid oporator");
			}
		} else {//The logic in this section is flawed.  Just because the current operator does not have presidence over the next operator doesn't mean it does not have presidence over the entire remaining statement.  There still might be an even lower operator to come that it does have presidence over.
			switch (currentOporator) {
			case '^':
				return Math.pow(firstNumber, parseStatement(opExpression.substring(1)));
			case '*':
				return firstNumber * parseStatement(opExpression.substring(1));
			case '/':
				return firstNumber / parseStatement(opExpression.substring(1));
			case '-':
				return firstNumber - parseStatement(opExpression.substring(1));
			case '+':
				return firstNumber + parseStatement(opExpression.substring(1));
			case '%':
				return firstNumber % parseStatement(opExpression.substring(1));
			default:
				throw new RuntimeException("Internal error: invalid oporator");
				
			}
		}
	}
}