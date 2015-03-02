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
	
	@Test
	public void Run_NumberString_ReturnsNumber()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("1");
		
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void Run_AdditionString_ReturnsTwo()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("1 + 1");
		
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void Run_OnlyWhiteSpace_ReturnsZero()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("   \n");
		
		Assert.assertEquals(0, result);
	}
	
	@Test
	public void Run_DivisionString_ReturnsOne()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("3 / 3");
		
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void Run_ModuloString_ReturnsOne()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("4 % 3");
		
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void Run_MultiOperationString_ReturnsTen()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("3 * 4 / 3 + 5 + 1 * 1");
		
		Assert.assertEquals(10, result);
	}
	
	@Test
	public void Run_GroupedOperatorString_ReturnsTwo()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("16 / (4 + 4)");
		
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void Run_DoubleGroupedOperatorString_ReturnsTwo()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("(1+1) * (3 -2)");
		
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void Run_NestedParensString_ReturnsEight()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("(1*(1 + 7)) * (3 -2)");
		
		Assert.assertEquals(8, result);
	}
	
	@Test
	public void Run_PowerString_ReturnsFour()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("2 ^  2");
		
		Assert.assertEquals(4, result);
	}
	
	@Test
	public void Run_MultiOperatorPowerString_ReturnsFive()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("2 ^  2 + 1");
		
		Assert.assertEquals(5, result);
	}
	
	@Test
	public void Run_NegativeString_ReturnsNegativeOne()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run("  - 1");
		
		Assert.assertEquals(-1, result);
	}
	
	@Test
	public void Run_UnaryMinusString_ReturnsOne()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run(" 2+ - 1");
		
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void Run_LongOperatorString_ReturnsTwo()
	{
		StringCalculator calculator = new StringCalculator();
		int result = calculator.run(" 3 * 4 / 10 * 1 + .8");
		
		Assert.assertEquals(2, result);
	}
	
}