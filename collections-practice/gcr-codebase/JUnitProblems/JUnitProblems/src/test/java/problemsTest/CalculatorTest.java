package problemsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import problems.Calculator;

public class CalculatorTest {

	Calculator calculator = new Calculator();
	
	 @Test
	 void testAdd() {
	     assertEquals(10, calculator.add(5, 5));
	 }

	 @Test
	 void testSubtract() {
	     assertEquals(2, calculator.subtract(5, 3));
	 }

	 @Test
	 void testMultiply() {
	     assertEquals(15, calculator.multiply(3, 5));
	 }

	 @Test
	 void testDivide() {
	     assertEquals(4, calculator.divide(20, 5));
	 }

}
