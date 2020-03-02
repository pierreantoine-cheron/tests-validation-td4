package testvalidation;

import java.util.ArrayList;

/**
 * Les robots.
 */
public class Robot extends Moveable {

    /**
     * Charge maximale et objets transportés.
     */
    public int maxLoad;
    public ArrayList<FieldObject> cargo;

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
	if (l <= 0){
	    l = 0;
    }
	this.maxLoad = l;

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
