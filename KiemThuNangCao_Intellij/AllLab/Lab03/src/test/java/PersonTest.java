import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PersonTest {

//    Person ps;
    @Before
    public void setUp() throws Exception {
//        ps = new Person();
    }

    @After
    public void tearDown() throws Exception {
//        ps= null;
    }
    @Rule
    public ExpectedException exception  = ExpectedException.none();
    @Test
    public void testExpectedException(){
        exception.expect(IllegalArgumentException.class);
        new Person("Ducnv2509", -1);
    }

    @Test(expected =  IllegalArgumentException.class)
    public void testWithExpected() throws  Exception{
        new Person("Ducnv2509", -1);
    }

    @Test
    public void testWithTryCatch() throws Exception{
        try {
            new Person("Ducnv2509", -1);
            fail();
        }catch (IllegalArgumentException e){
//            assertEquals("Invalid age " , e.getMessage());
        }
    }

}