package testvalidation;

/**
 * Tous les objets.
 */
public class FieldObject {

    /**
     * Les objets sont caractérisés par un poids et des coordonnées.
     * Ils appartiennent à un terrain, et peuvent être portés ou non.
     */
    public Field field;
    public int weight;
    public double x, y;
    public boolean lifted;

    /**
     * Constructeur.
     *
     * @param f  Terrain sur lequel vit l'objet.
     * @param w  Poids
     * @param x  Abscisse
     * @param y  Ordonnée
     */
    public FieldObject(Field f, int w, double x, double y) {
        if (w <= 0){
            w = 1;
        }
        if (x <= 0){
            x = 0;
        }
        if (y <=0){
            y = 0;
        }

        if (x >= 10){
            x = 10;
        }
        if (y >= 8){
            y = 8;
        }

        field = f;
        weight = w;
        this.x = x;
        this.y = y;
    }

    /**
     * Renvoie le poids de l'objet.
     *
     * @return Poids
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Définit la position de l'objet.
     *
     * @param x  Abscisse
     * @param y  Ordonnée
     */
    public void unsafeSetPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
