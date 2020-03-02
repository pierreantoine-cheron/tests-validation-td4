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
     * @param f Terrain sur lequel vit l'objet.
     * @param w Poids
     * @param x Abscisse
     * @param y Ordonnée
     */
    public Moveable(Field f, int w, double x, double y) {
        super(f, w, x, y);
        this.fuel = 10;
    }

    /**
     * Calcul de la distance à un point de coordonnées données.
     *
     * @param x Abscisse
     * @param y Ordonnée
     * @return Distance
     */
    protected double dist(double x, double y) {
        double distance = Math.sqrt(Math.pow((x - super.x), 2) + Math.pow((y - super.y), 2));
        return distance;
    }

    /**
     * Se déplacer vers un point de coordonnées données.
     *
     * @param x Abscisse cible
     * @param y Ordonnée cible
     */
    public void goTo(double x, double y) {
        if (x > 10) {
            x = 10;
        }
        if (y >= 10) {
            y = 8;
        }

        double backup_fuel = this.fuel - dist(x, y);

        if (backup_fuel >= 0) {
            this.fuel = backup_fuel;
            this.unsafeSetPosition(x, y);
        }

        else {
            double backup_x = x;
            double backup_y = y;
            double backup_xBis = x;
            double backup_yBis = y;

            double distanceX = Math.abs(x - super.x);
            double distanceY = Math.abs(y - super.y);

            if (this.x > x)
                backup_xBis = this.x - (distanceX * (fuel / dist(backup_x, backup_y)));
            else
                backup_xBis = this.x + (distanceX * (fuel / dist(backup_x, backup_y)));

            if (this.y > y)
                backup_yBis = this.y - (distanceY * (fuel / dist(backup_x, backup_y)));

            else
                backup_yBis = this.y + (distanceY * (fuel / dist(backup_x, backup_y)));

            this.x = backup_xBis;
            this.y = backup_yBis;
            this.fuel = 0;







        }
    }
}

