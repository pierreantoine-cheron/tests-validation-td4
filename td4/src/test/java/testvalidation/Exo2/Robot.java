import static java.lang.Math.*;
import java.util.ArrayList;

/**
 * Les robots.
 */
public class Robot extends Moveable {

    /**
     * Charge maximale et objets transportés.
     */
    protected int maxLoad;
    protected ArrayList<FieldObject> cargo;

    /**
     * Constructeur.
     *
     * @param f  Terrain sur lequel vit l'objet.
     * @param w  Poids
     * @param x  Abscisse
     * @param y  Ordonnée
     * @param l  Charge maximale
     */
    public Robot(Field f, int w, double x, double y, int l) {
	super(f, w, x, y);
	// À compléter.
    }
    
    /**
     * Calcul de la charge actuelle.
     *
     * @return Charge actuelle
     */
    public int cargoWeight() {
	// À compléter.
	return 0;
    }

    /**
     * Prendre un objet.
     *
     * @param o  Objet à prendre
     */
    public void lift(FieldObject o) {
	// À compléter.
    }

    /**
     * Déposer un objet.
     *
     * @param o  Objet à déposer
     */
    public void dropOff(FieldObject o) {
	// À compléter.
    }

}
