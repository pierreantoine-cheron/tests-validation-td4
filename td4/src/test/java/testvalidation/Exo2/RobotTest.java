import static org.junit.Assert.*;
import org.junit.*;

public class RobotTest {

    Field f;
    Robot r2d2;
    Robot c3po;
    FieldObject lightSaber;
    FieldObject deathStarMap;
    FieldObject bolt;

    @Before
    public void initField() {
	f    = new Field(8, 10);
	r2d2 = new Robot(f, 19, 2.0, 2.0, 20);
	c3po = new Robot(f, 16, 3.0, 3.0, 2);
	lightSaber   = new FieldObject(f, 4, 3.0, 2.0);
	deathStarMap = new FieldObject(f, 2, 3.0, 4.0);
	bolt         = new FieldObject(f, 1, 2.0, 4.0);
    }

    // Tests du constructeur.
    @Test
    public void createRobot() {
	Robot r = new Robot(f, 12, 4.0, 5.0, 3);
	assertEquals(3, r.maxLoad);
    }

    @Test
    public void createRobotNegLoad() {
	Robot r = new Robot(f, 12, 4.0, 5.0, -33);
	assertEquals(0, r.maxLoad);
    }

    // Tests de la méthode lift.
    @Test
    public void liftSuccess() {
	r2d2.lift(lightSaber);
	assertTrue(r2d2.cargo.contains(lightSaber));
	assertTrue(lightSaber.lifted);
    }

    @Test
    public void liftFailureTooFarDiag() {
	r2d2.lift(c3po);
	assertFalse(r2d2.cargo.contains(c3po));
	assertFalse(c3po.lifted);
    }

    @Test
    public void liftFailureTooFarStraight() {
	r2d2.lift(bolt);
	assertFalse(r2d2.cargo.contains(bolt));
	assertFalse(bolt.lifted);
    }

    @Test
    public void liftSuccessHeavy() {
	c3po.lift(lightSaber);
	assertTrue(c3po.cargo.contains(lightSaber));
	assertTrue(lightSaber.lifted);
    }

    @Test
    public void liftSuccessMultiple() {
	r2d2.lift(lightSaber);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	assertTrue(r2d2.cargo.contains(lightSaber));
	assertTrue(r2d2.cargo.contains(c3po));
	assertTrue(lightSaber.lifted);
	assertTrue(c3po.lifted);
    }

    @Test
    public void liftSuccessNested() {
	r2d2.goTo(2, 3);
	c3po.lift(deathStarMap);
	r2d2.lift(c3po);
	assertFalse(r2d2.cargo.contains(deathStarMap));
	assertTrue(r2d2.cargo.contains(c3po));
	assertTrue(deathStarMap.lifted);
	assertTrue(c3po.lifted);
    }

    // Test de la méthode dropOff.
    @Test
    public void dropOffContains() {
	r2d2.lift(lightSaber);
	r2d2.dropOff(lightSaber);
	assertFalse(lightSaber.lifted);
	assertEquals(2, lightSaber.x, 0.0);
	assertEquals(2, lightSaber.y, 0.0);
    }

    @Test
    public void dropOffEmpty() {
	r2d2.dropOff(lightSaber);
	assertFalse(lightSaber.lifted);
	assertEquals(3, lightSaber.x, 0.0);
	assertEquals(2, lightSaber.y, 0.0);
    }
    
    @Test
    public void dropOffOther() {
	r2d2.lift(lightSaber);
	r2d2.dropOff(bolt);
	assertTrue(lightSaber.lifted);
	assertFalse(bolt.lifted);
	assertEquals(2, bolt.x, 0.0);
	assertEquals(4, bolt.y, 0.0);
    }

    @Test
    public void dropOffDoNotSteal() {
	c3po.lift(lightSaber);
	r2d2.dropOff(lightSaber);
	assertTrue(lightSaber.lifted);
    }

    @Test
    public void dropOffFailureLifted() {
	c3po.lift(lightSaber);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	c3po.dropOff(lightSaber);
	assertTrue(lightSaber.lifted);
    }

    @Test
    public void dropOffNestedFailure() {
	c3po.lift(lightSaber);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	r2d2.dropOff(lightSaber);
	assertTrue(c3po.lifted);
	assertTrue(lightSaber.lifted);
    }
    
    @Test
    public void dropOffNested() {
	c3po.lift(lightSaber);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	r2d2.dropOff(c3po);
	assertFalse(c3po.lifted);
	assertTrue(lightSaber.lifted);
    }
    

    // Test de la méthode cargoWeight.
    @Test
    public void cargoWeightEmpty() {
	int w = c3po.cargoWeight();
	assertEquals(0, w);
    }

    @Test
    public void cargoWeightSimple() {
	c3po.lift(lightSaber);
	int w = c3po.cargoWeight();
	assertEquals(4, w);
    }

    @Test
    public void cargoWeightMultiple() {
	r2d2.lift(lightSaber);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	r2d2.goTo(2, 4);
	r2d2.lift(deathStarMap);
	int w = r2d2.cargoWeight();
	assertEquals(22, w);
    }

    @Test
    public void cargoWeightNested() {
	c3po.lift(lightSaber);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	int w = r2d2.cargoWeight();
	assertEquals(20, w);
    }

    @Test
    public void cargoWeightHybrid() {
	c3po.lift(lightSaber);
	c3po.lift(deathStarMap);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	int w = r2d2.cargoWeight();
	assertEquals(22, w);
    }

    @Test
    public void cargoWeightHybrid2() {
	r2d2.lift(lightSaber);
	c3po.lift(deathStarMap);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	int w = r2d2.cargoWeight();
	assertEquals(22, w);
    }


    // Test de la méthode getWeight.
    @Test
    public void getWeightEmpty() {
	int w = c3po.getWeight();
	assertEquals(16, w);
    }

    @Test
    public void getWeightSimple() {
	c3po.lift(lightSaber);
	int w = c3po.getWeight();
	assertEquals(20, w);
    }

    @Test
    public void getWeightMultiple() {
	r2d2.lift(lightSaber);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	r2d2.goTo(2, 4);
	r2d2.lift(deathStarMap);
	int w = r2d2.getWeight();
	assertEquals(41, w);
    }

    @Test
    public void getWeightNested() {
	c3po.lift(lightSaber);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	int w = r2d2.getWeight();
	assertEquals(39, w);
    }

    @Test
    public void getWeightHybrid() {
	c3po.lift(lightSaber);
	c3po.lift(deathStarMap);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	int w = r2d2.getWeight();
	assertEquals(41, w);
    }

    @Test
    public void getWeightHybrid2() {
	r2d2.lift(lightSaber);
	c3po.lift(deathStarMap);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	int w = r2d2.getWeight();
	assertEquals(41, w);
    }


    // Test de la méthode goTo.
    @Test
    public void goToFailureLifted() {
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	c3po.goTo(4, 5);
	assertFalse(4 == c3po.x);
	assertFalse(5 == c3po.y);
	assertEquals(10, c3po.fuel, 0.0);
    }

    @Test
    public void goToFailureTooHeavy() {
	c3po.lift(lightSaber);
	c3po.goTo(4, 5);
	assertEquals(3, c3po.x, 0.0);
	assertEquals(3, c3po.y, 0.0);
	assertEquals(10, c3po.fuel, 0.0);
    }

    @Test
    public void goToSuccessMultipleCargo() {
	r2d2.lift(lightSaber);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	r2d2.goTo(5, 3);
	assertEquals(5, r2d2.x, 0.0);
	assertEquals(3, r2d2.y, 0.0);
	assertEquals(6, r2d2.fuel, 0.0);	
    }

    @Test
    public void goToSuccessNestedCargo() {
	c3po.lift(lightSaber);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	r2d2.goTo(5, 3);
	assertEquals(5, r2d2.x, 0.0);
	assertEquals(3, r2d2.y, 0.0);
	assertEquals(6, r2d2.fuel, 0.0);
    }

    @Test
    public void goToFailureMultipleTooHeavy() {
	r2d2.lift(lightSaber);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	r2d2.goTo(2, 4);
	r2d2.lift(deathStarMap);
	r2d2.goTo(5, 3);
	assertEquals(2, r2d2.x, 0.0);
	assertEquals(4, r2d2.y, 0.0);
	assertEquals(8, r2d2.fuel, 0.0);	
    }

    @Test
    public void goToFailureNestedTooHeavy() {
	c3po.lift(lightSaber);
	c3po.lift(deathStarMap);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	r2d2.goTo(5, 3);
	assertEquals(2, r2d2.x, 0.0);
	assertEquals(3, r2d2.y, 0.0);
	assertEquals(9, r2d2.fuel, 0.0);	
    }

    @Test
    public void goToFailureHybridTooHeavy() {
	r2d2.lift(lightSaber);
	c3po.lift(deathStarMap);
	r2d2.goTo(2, 3);
	r2d2.lift(c3po);
	r2d2.goTo(5, 3);
	assertEquals(2, r2d2.x, 0.0);
	assertEquals(3, r2d2.y, 0.0);
	assertEquals(9, r2d2.fuel, 0.0);	
    }

}
