package SOF304.LAB01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.processing.Generated;

import org.junit.Test;

@Generated(value = "org.junit-tools-1.1.0")
public class CaculatorTest {

	private Caculator createTestSubject() {
		return new Caculator();
	}

	@Test
	public void testTong() throws Exception {
		Caculator testSubject;
		int a = 10;
		int b = 20;
		int result;
		int kyvong = 30;
		// default test
		testSubject = createTestSubject();
		result = testSubject.Tong(a, b);
		assertEquals(kyvong, result);
	}

	@Test
	public void testNhan() throws Exception {
		Caculator testSubject;
		int a = 7;
		int b = 3;
		int result;
		int kyvong = 21;
		// default test
		testSubject = createTestSubject();
		result = testSubject.Nhan(a, b);
		assertEquals(kyvong, result);
	}

	@Test
	public void testTru() throws Exception {
		Caculator testSubject;
		int a = 3;
		int b = 4;
		int result;
		int kyvong = 400;
		// default test
		testSubject = createTestSubject();
		result = testSubject.Tru(a, b);
		assertEquals(kyvong, result);
	}

	@Test
	public void testChia() throws Exception {
		Caculator testSubject;
		int a = 5;
		int b = 5;
		int result;
		int kyvong = 3;
		// default test
		testSubject = createTestSubject();
		result = testSubject.Chia(a, b);
		assertEquals(kyvong, result);
	}
}