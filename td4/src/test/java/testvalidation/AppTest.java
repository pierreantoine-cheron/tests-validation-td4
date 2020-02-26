package testvalidation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class AppTest 
{

    App a;

    @Before
    public void setup() {
        App a = new App();
    }

    @Test
    public void testPositif(){
        int[] test = {4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5};
        assertArrayEquals(test, a.racineCarrees(20, 30));
    }

    @Test
    public void testNbrNegatif(){
        try {
            int[] test = a.racineCarrees(-5, -1);
            assertNull(test);
        }
        catch (Exception e){
            assertTrue(false);
        }
    }


    @Test
    public void testAplusgrandqueB(){
        try {
            int[] test = a.racineCarrees(5, 1);
            assertNull(test);
        }
        catch (Exception e){
            assertTrue(false);
        }
    }

}
