package SOF304.Demo;

import static org.junit.Assert.assertEquals;

import javax.annotation.processing.Generated;

import org.junit.Test;

@Generated(value = "org.junit-tools-1.1.0")
public class DemoTest {

	private Demo createTestSubject() {
		return new Demo();
	}

	@Test
	public void testChia() throws Exception {
		double a = 4;
		double b = 2;
		double result;

		// default test
		result = Demo.Chia(a, b);
		assertEquals(result, 2);
	}

	@Test
	public void testNhan() throws Exception {
		double a = 0.0;
		double b = 0.0;
		double result;

		// default test
		result = Demo.Nhan(a, b);
	}

	@Test
	public void testTong() throws Exception {
		double a = 0.0;
		double b = 0.0;
		double result;

		// default test
		result = Demo.Tong(a, b);
	}

	@Test
	public void testTru() throws Exception {
		double a = 0.0;
		double b = 0.0;
		double result;

		// default test
		result = Demo.Tru(a, b);
	}
}