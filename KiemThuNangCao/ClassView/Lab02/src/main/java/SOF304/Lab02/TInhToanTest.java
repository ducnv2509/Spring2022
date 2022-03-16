package SOF304.Lab02;


import static org.junit.Assert.*;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;

@Generated(value="org.junit-tools-1.1.0")
public class TInhToanTest{

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

	private TInhToan createTestSubject()  {
	 return new TInhToan();
	}

	@MethodRef(name="Tong", signature="(II)I")
	@Test
	public void testTong() throws Exception {
	TInhToan testSubject;int a = 0;
	int b = 0;
	int result;
	
	// default test
	testSubject=createTestSubject();result=testSubject.Tong(a, b);
	}

	@MethodRef(name="Tru", signature="(II)I")
	@Test
	public void testTru() throws Exception {
	TInhToan testSubject;int a = 0;
	int b = 0;
	int result;
	
	// default test
	testSubject=createTestSubject();result=testSubject.Tru(a, b);
	}

	@MethodRef(name="Nhan", signature="(II)I")
	@Test
	public void testNhan() throws Exception {
	TInhToan testSubject;int a = 0;
	int b = 0;
	int result;
	
	// default test
	testSubject=createTestSubject();result=testSubject.Nhan(a, b);
	}

	@MethodRef(name="Chia", signature="(II)I")
	@Test
	public void testChia() throws Exception {
	TInhToan testSubject;int a = 0;
	int b = 0;
	int result;
	
	// test 1
	testSubject=createTestSubject();a = 0;
	result=testSubject.Chia(a, b);
	Assert.assertEquals(0, result, 0);
	
	// test 2
	testSubject=createTestSubject();a = 1;
	result=testSubject.Chia(a, b);
	Assert.assertEquals(0, result, 0);
	}

	@MethodRef(name="BinhPhuong", signature="(II)I")
	@Test
	public void testBinhPhuong() throws Exception {
	TInhToan testSubject;int a = 0;
	int b = 0;
	int result;
	
	// default test
	testSubject=createTestSubject();result=testSubject.BinhPhuong(a, b);
	}

	@MethodRef(name="canBachai", signature="(I)I")
	@Test
	public void testCanBachai() throws Exception {
	TInhToan testSubject;int a = 0;
	int result;
	
	// test 1
	testSubject=createTestSubject();a = 0;
	result=testSubject.canBachai(a);
	Assert.assertEquals(0, result, 0);
	
	// test 2
	testSubject=createTestSubject();a = -1;
	result=testSubject.canBachai(a);
	Assert.assertEquals(0, result, 0);
	
	// test 3
	testSubject=createTestSubject();a = 1;
	result=testSubject.canBachai(a);
	Assert.assertEquals(0, result, 0);
	}

	@MethodRef(name="isEventNumber", signature="(I)Z")
	@Test
	public void testIsEventNumber() throws Exception {
	TInhToan testSubject;int input = 0;
	boolean result;
	
	// default test
	testSubject=createTestSubject();result=testSubject.isEventNumber(input);
	} 
}