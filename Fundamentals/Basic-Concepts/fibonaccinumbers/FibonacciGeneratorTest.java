package BasicJava.fibonaccinumbers;

import junit.framework.TestCase;

public class FibonacciGeneratorTest extends TestCase {
	
	// Test Number: 1
	// Test Objective: Check is -99 is shown if input is MIN_VALUE and is out of valid range
	// Test input(s):  Integer.MIN_VALUE
	// Test expected output(s): -99
	public void testcalculateNthValue001()
	{
		FibonacciGenerator generator = new FibonacciGenerator();
		assertEquals(-99, generator.calculateNthValue(Integer.MIN_VALUE));
	}
	
	// Test Number: 2
	// Test Objective: Check is -99 is shown if input is 0 and is out of valid range
	// Test input(s):  0
	// Test expected output(s): -99
	public void testcalculateNthValue002()
	{
		FibonacciGenerator generator = new FibonacciGenerator();
		assertEquals(-99, generator.calculateNthValue(0));
	}
	
	// Test Number: 3
	// Test Objective: Check if result is correct when a valid number is entered 
	// Test input(s):  1
	// Test expected output(s): 1
	public void testcalculateNthValue003()
	{
		FibonacciGenerator generator = new FibonacciGenerator();
		assertEquals(1, generator.calculateNthValue(1));
	}
	
	// Test Number: 4
	// Test Objective: Check if correct result is shown when valid number is entered
	// Test input(s): 46
	// Test expected output(s): 1836311903
	public void testcalculateNthValue004()
	{
		FibonacciGenerator generator = new FibonacciGenerator();
		assertEquals(1836311903, generator.calculateNthValue(46));
	}
	
	// Test Number: 5
	// Test Objective: Check if result is -99 when a invalid number is entered 
	// Test input(s):  47
	// Test expected output(s): -99
	public void testcalculateNthValue005()
	{
		FibonacciGenerator generator = new FibonacciGenerator();
		assertEquals(-99, generator.calculateNthValue(47));
	}
	
	// Test Number: 6
	// Test Objective: Check if result is -99 when a invalid number is entered 
	// Test input(s):  Integer.MAX_VALUE
	// Test expected output(s): -99
	public void testcalculateNthValue006()
	{
		FibonacciGenerator generator = new FibonacciGenerator();
		assertEquals(-99, generator.calculateNthValue(Integer.MAX_VALUE));
	}

}
