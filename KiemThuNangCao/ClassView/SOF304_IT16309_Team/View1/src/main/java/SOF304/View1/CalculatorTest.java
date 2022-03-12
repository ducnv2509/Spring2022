package SOF304.View1;

import static org.junit.Assert.*;
import javax.annotation.processing.Generated;

import org.junit.Test;
import java.util.*;
import org.junit.Assert;

@Generated(value = "org.junit-tools-1.1.0")
public class CalculatorTest {

	private Calculator createTestSubject() {
		return new Calculator();
	}

	@Test
	public void testChia() throws Exception {
		double a = 4;
		double b = 2;
		double result;
//		double kivong = 2;
		// default test
		result = Calculator.Chia(a, b);
//		assertEquals(kivong, result);
	}

	@Test
	public void testNhan() throws Exception {
		double a = 0.0;
		double b = 0.0;
		double result;

		// default test
		result = Calculator.Nhan(a, b);
	}

	@Test
	public void testTong() throws Exception {
		double a = 0.0;
		double b = 0.0;
		double result;

		// default test
		result = Calculator.Tong(a, b);
	}

	@Test
	public void testTru() throws Exception {
		double a = 0.0;
		double b = 0.0;
		double result;

		// default test
		result = Calculator.Tru(a, b);
	}

	@Test
	public void testMain() throws Exception {
		String[] args = new String[] { "" };

		// default test
		Calculator.main(args);
	}
}