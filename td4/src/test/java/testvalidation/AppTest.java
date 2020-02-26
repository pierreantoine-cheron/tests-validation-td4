package testvalidation;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class AppTest 
{

    App a;

    @Before
    public void setup() {
        App a = new App();
    }

    @Test
    public void testPositif(){
        int[] test = {4, 4, 4, 4, 4, 5, 5, 5, 5, 5};
        assertArrayEquals(test, a.racineCarrees(20, 30));
    }

    @Test
    public void testNbrNegatif(){
        try {
            a.racineCarrees(-5, -1);
            assertTrue(false);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void testAplusgrandqueB(){
        try {
            a.racineCarrees(5, 1);
            assertTrue(false);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }











}
