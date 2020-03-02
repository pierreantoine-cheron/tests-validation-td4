import static org.junit.Assert.*;
import org.junit.*;
import testvalidation.Field;

public class FieldTest {

    Field f;

    @Before
    public void initField() {
	f = new Field(8, 10);
    }

    // Tests du constructeur.
    // Création d'un terrain avec des dimensions positives ou négatives.
    @Test
    public void createFieldBothValid() {
	Field f0 = new Field(8, 10);
	assertEquals(8, f0.heigth);
	assertEquals(10, f0.width);
    }

    @Test
    public void createFieldNegHeigth() {
	Field f0 = new Field(-2, 10);
	assertEquals(1, f0.heigth);
	assertEquals(10, f0.width);
    }

    @Test
    public void createFieldNullHeigth() {
	Field f0 = new Field(0, 10);
	assertEquals(1, f0.heigth);
	assertEquals(10, f0.width);
    }

    @Test
    public void createFieldNegWidth() {
	Field f0 = new Field(8, -3);
	assertEquals(8, f0.heigth);
	assertEquals(1, f0.width);
    }

    @Test
    public void createFieldNullWidth() {
	Field f0 = new Field(8, 0);
	assertEquals(8, f0.heigth);
	assertEquals(1, f0.width);
    }

    // Test des fonctions de normalisation des coordonnées : X.
    @Test
    public void normalizeXValid() {
	double nX = f.normalizeX(3);
	assertEquals(3, nX, 0.0);
    }

    @Test
    public void normalizeXValidDownLimit() {
	double nX = f.normalizeX(0);
	assertEquals(0, nX, 0.0);
    }

    @Test
    public void normalizeXValidUpLimit() {
	double nX = f.normalizeX(10);
	assertEquals(10, nX, 0.0);
    }

    @Test
    public void normalizeXNeg() {
	double nX = f.normalizeX(-3);
	assertEquals(0, nX, 0.0);
    }

    @Test
    public void normalizeXBigger() {
	double nX = f.normalizeX(15);
	assertEquals(10, nX, 0.0);
    }

    @Test
    public void normalizeXBiggerLimit() {
	double nX = f.normalizeX(10.5);
	assertEquals(10, nX, 0.0);
    }

    // Test des fonctions de normalisation des coordonnées : Y.
    @Test
    public void normalizeYValid() {
	double nY = f.normalizeY(4);
	assertEquals(4, nY, 0.0);
    }

    @Test
    public void normalizeYValidDownLimit() {
	double nY = f.normalizeY(0);
	assertEquals(0, nY, 0.0);
    }

    @Test
    public void normalizeYValidUpLimit() {
	double nY = f.normalizeY(8);
	assertEquals(8, nY, 0.0);
    }

    @Test
    public void normalizeYNeg() {
	double nY = f.normalizeY(-3);
	assertEquals(0, nY, 0.0);
    }

    @Test
    public void normalizeYBigger() {
	double nY = f.normalizeY(15);
	assertEquals(8, nY, 0.0);
    }

    @Test
    public void normalizeYBiggerLimit() {
	double nY = f.normalizeY(8.1);
	assertEquals(8, nY, 0.0);
    }



}
