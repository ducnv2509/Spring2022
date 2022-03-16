import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
        System.out.println("start");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("End");
        calculator = null;
    }

    @Test
    public void tong() {
        assertEquals(7, calculator.Tong(4, 3));
    }

    @Test
    public void tru() {
        assertEquals(1, calculator.Tru(4, 3));

    }

    @Test
    public void nhan() {
        assertAll(() ->
                        assertEquals(21, calculator.Nhan(7, 3)),
                () -> assertEquals(18, calculator.Nhan(6, 3))
        );
    }

    @Test
    public void chia() {
        assertEquals(4, calculator.Chia(12, 3));
        assertEquals(0, calculator.Chia(0, 3));
        assertEquals(4, calculator.Chia(12, 3));
    }

    @Test
    public void binhPhuong() {
        assertEquals(8, calculator.BinhPhuong(2, 3));

    }

    @Test
    public void canBachai() {
        assertAll(
                () -> assertEquals(0, calculator.canBachai(0)),
                () -> assertEquals(0, calculator.canBachai(-1)),
                () -> assertEquals(1, calculator.canBachai(1)),
                () -> assertEquals(5, calculator.canBachai(25))
        );
    }

    @Test
    public void isEventNumber() {
        Assertions.assertTrue(calculator.isEventNumber(6));

    }


}