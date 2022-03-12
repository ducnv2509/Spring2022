import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void tong() {
        assertEquals(5, new Calculator().Tong(2,3));
    }

    @Test
    void tru() {
        assertEquals(3, new Calculator().Tru(2,4));

    }

    @Test
    void nhan() {
        assertEquals(14, new Calculator().Nhan(2,7));

    }

    @Test
    void chia() {
        assertEquals(6, new Calculator().Tong(14,2));
    }

    @Test
    void binhPhuong(){
        assertEquals(8, new Calculator().BinhPhuong(2,3));
    }
    @Test
    void canBacHai(){
        assertEquals(5, new Calculator().canBachai(25));
    }

    @Test
    void isEventNumber2() {
        assertTrue(new Calculator().isEventNumber(2));
    }

    @Test
    void isEventNumber4() {
        assertTrue(new Calculator().isEventNumber(4));
    }

    @Test
    void isEventNumber3() {
        assertTrue(new Calculator().isEventNumber(3));
    }

    @Test
    void delta() {
        assertEquals(8, new Calculator().delta(2, 4, 1));
    }
}