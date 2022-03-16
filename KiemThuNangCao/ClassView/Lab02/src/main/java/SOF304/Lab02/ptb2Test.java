package SOF304.Lab02;

import static org.junit.Assert.assertEquals;

import javax.annotation.processing.Generated;

import org.junit.Test;

@Generated(value = "org.junit-tools-1.1.0")
public class ptb2Test {

	private ptb2 createTestSubject() {
		return new ptb2();
	}

	@Test
	public void testGiaiPTB2() throws Exception {
		ptb2 testSubject;
		float a = 2;
		float b = 1;
		float c = -1;

		// test 1
		testSubject = createTestSubject();
		testSubject.giaiPTB2(a, b, c);

		// test 2
		testSubject = createTestSubject();
		testSubject.giaiPTB2(a, b, c);
		
		assertEquals(1, 2);
		
	}
}