package testvalidation;

/**
 * Les objets mobiles.
 */
public class Moveable extends FieldObject {

    /**
     * Niveau de carburant.
     */
     public double fuel;

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
	this.fuel = 10;
    }

    /**
     * Calcul de la distance à un point de coordonnées données.
     *
     * @param x  Abscisse
     * @param y  Ordonnée
     * @return Distance
     */
    protected double dist(double x, double y) {
        double distance = Math.sqrt( Math.pow((x - super.x), 2) + Math.pow((y - super.y), 2));
        return distance;
    }

    /**
     * Se déplacer vers un point de coordonnées données.
     *
     * @param x  Abscisse cible
     * @param y  Ordonnée cible
     */
    public void goTo(double x, double y) {
        if (x > 10){
            x = 10;
        }
        if (y >= 10){
            y = 8;
        }
        this.fuel = this.fuel - dist(x, y);

        if (this.fuel >= 0){
            this.unsafeSetPosition(x, y);
        }

    }

}
