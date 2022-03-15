package SOF304.Lab02;

import javax.annotation.processing.Generated;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated(value = "org.junit-tools-1.1.0")
public class TInhToanTest {

	@Before
	public void setUp() throws Exception {

	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	private TInhToan createTestSubject() {
		return new TInhToan();
	}

	@Test
	public void testTong() throws Exception {
		TInhToan testSubject;
		int a = 0;
		int b = 0;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.Tong(a, b);
	}

	@Test
	public void testTru() throws Exception {
		TInhToan testSubject;
		int a = 0;
		int b = 0;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.Tru(a, b);
	}

	@Test
	public void testNhan() throws Exception {
		TInhToan testSubject;
		int a = 0;
		int b = 0;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.Nhan(a, b);
	}

	@Test
	public void testChia() throws Exception {
		TInhToan testSubject;
		int a = 0;
		int b = 0;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.Chia(a, b);
	}

	@Test
	public void testBinhPhuong() throws Exception {
		TInhToan testSubject;
		int a = 0;
		int b = 0;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.BinhPhuong(a, b);
	}

	@Test
	public void testCanBachai() throws Exception {
		TInhToan testSubject;
		int a = 0;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.canBachai(a);
	}

	@Test
	public void testIsEventNumber() throws Exception {
		TInhToan testSubject;
		int input = 0;
		boolean result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.isEventNumber(input);
	}
}