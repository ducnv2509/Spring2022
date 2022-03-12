import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestMavenTest {

    @Test
    void isEventNumber2() {
        assertTrue(new TestMaven().isEventNumber(2));
    }

    @Test
    void isEventNumber4() {
        assertTrue(new TestMaven().isEventNumber(4));
    }

    @Test
    void isEventNumber3() {
        assertTrue(new TestMaven().isEventNumber(3));
    }
}