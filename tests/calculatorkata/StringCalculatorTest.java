package calculatorkata;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
	@Test
	public void Run_EmptyString_ReturnsZero() {
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("");
		
		Assert.assertEquals(0, result);
	}

	@Test
	public void Run_NullString_ReturnsZero() {
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("");
		
		Assert.assertEquals(0, result);
	}
}