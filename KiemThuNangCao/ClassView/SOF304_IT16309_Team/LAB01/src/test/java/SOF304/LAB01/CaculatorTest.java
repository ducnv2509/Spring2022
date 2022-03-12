package SOF304.LAB01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CaculatorTest {

	@Test
	void testTong() {
		assertEquals(5, new Caculator().Tong(5, 5));
	}

	@Test
	void testNhan() {
		assertEquals(6, new Caculator().Nhan(2, 3));
	}

	@Test
	void testTru() {
		assertEquals(5, new Caculator().Tru(10, 5));
	}

	@Test
	void testChia() {
		assertEquals(10, new Caculator().Chia(12, 2));
	}

}
