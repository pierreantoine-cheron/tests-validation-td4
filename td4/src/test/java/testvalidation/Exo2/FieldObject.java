import static java.lang.Math.*;

/**
 * Tous les objets.
 */
public class FieldObject {

    /**
     * Les objets sont caractérisés par un poids et des coordonnées.
     * Ils appartiennent à un terrain, et peuvent être portés ou non.
     */
    protected Field field;
    protected int weight;
    protected double x, y;
    protected boolean lifted;

    /**
     * Constructeur.
     *
     * @param f  Terrain sur lequel vit l'objet.
     * @param w  Poids
     * @param x  Abscisse
     * @param y  Ordonnée
     */
    public FieldObject(Field f, int w, double x, double y) {
	// À compléter.
    }

    /**
     * Renvoie le poids de l'objet.
     *
     * @return Poids
     */
    public int getWeight() {
	// À compléter.
	return 0;
    }

    /**
     * Définit la position de l'objet.
     *
     * @param x  Abscisse
     * @param y  Ordonnée
     */
    public void unsafeSetPosition(double x, double y) {
	// À compléter.
    }

}
