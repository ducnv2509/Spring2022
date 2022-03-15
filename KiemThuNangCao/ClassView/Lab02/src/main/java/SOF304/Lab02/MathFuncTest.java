package SOF304.Lab02;

import javax.annotation.processing.Generated;

import org.junit.Assert;
import org.junit.Test;

@Generated(value = "org.junit-tools-1.1.0")
public class MathFuncTest {

	private MathFunc createTestSubject() {
		return new MathFunc();
	}

	@MethodRef(name = "factorial", signature = "(I)J")
	@Test
	public void testFactorial() throws Exception {
		MathFunc testSubject;
		int number = 0;
		long result;

		// test 1
		testSubject = createTestSubject();
		number = 0;
		result = testSubject.factorial(number);
		Assert.assertEquals(null, result);

		// test 2
		testSubject = createTestSubject();
		number = -1;
		result = testSubject.factorial(number);
		Assert.assertEquals(null, result);

		// test 3
		testSubject = createTestSubject();
		number = 1;
		result = testSubject.factorial(number);
		Assert.assertEquals(null, result);

		// test 4
		testSubject = createTestSubject();
		number = 21;
		result = testSubject.factorial(number);
		Assert.assertEquals(null, result);

		// test 5
		testSubject = createTestSubject();
		number = 20;
		result = testSubject.factorial(number);
		Assert.assertEquals(null, result);

		// test 6
		testSubject = createTestSubject();
		number = 22;
		result = testSubject.factorial(number);
		Assert.assertEquals(null, result);

		// test 7
		testSubject = createTestSubject();
		number = 1;
		result = testSubject.factorial(number);
		Assert.assertEquals(null, result);

		// test 8
		testSubject = createTestSubject();
		number = 0;
		result = testSubject.factorial(number);
		Assert.assertEquals(null, result);

		// test 9
		testSubject = createTestSubject();
		number = 2;
		result = testSubject.factorial(number);
		Assert.assertEquals(null, result);
	}

	@MethodRef(name = "plus", signature = "(II)J")
	@Test
	public void testPlus() throws Exception {
		MathFunc testSubject;
		int num1 = 0;
		int num2 = 0;
		long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.plus(num1, num2);
	}
}