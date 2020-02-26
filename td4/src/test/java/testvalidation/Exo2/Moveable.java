import static java.lang.Math.*;

/**
 * Les objets mobiles.
 */
public class Moveable extends FieldObject {

    /**
     * Niveau de carburant.
     */
    protected double fuel;

    /**
     * Constructeur.
     *
     * @param f  Terrain sur lequel vit l'objet.
     * @param w  Poids
     * @param x  Abscisse
     * @param y  Ordonnée
     */
    public Moveable(Field f, int w, double x, double y) {
	super(f, w, x, y);
	// À compléter.
    }

    /**
     * Calcul de la distance à un point de coordonnées données.
     *
     * @param x  Abscisse
     * @param y  Ordonnée
     * @return Distance
     */
    protected double dist(double x, double y) {
	// À compléter.
	return 0;
    }

    /**
     * Se déplacer vers un point de coordonnées données.
     *
     * @param x  Abscisse cible
     * @param y  Ordonnée cible
     */
    public void goTo(double x, double y) {
	// À compléter.
    }

}
