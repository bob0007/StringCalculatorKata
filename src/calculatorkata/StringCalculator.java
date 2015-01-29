package calculatorkata;

public class StringCalculator implements Calculator {
	public int run(String statement) {
		if(statement == null || statement.length() == 0)
			return 0;
		
		return Integer.parseInt(statement);
	}
}