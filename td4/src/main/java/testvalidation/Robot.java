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
	this.cargo = new ArrayList<>();
    }
    
    /**
     * Calcul de la charge actuelle.
     *
     * @return Charge actuelle
     */
    public int cargoWeight() {
        int result = 0;
        for (FieldObject fo : cargo){
            if (fo instanceof Robot){
                result = result + ((Robot) fo).cargoWeight();
            }
            result = result + fo.weight;
            System.out.println(result);
        }
        return result;
    }

    /**
     * Prendre un objet.
     *
     * @param o  Objet à prendre
     */
    public void lift(FieldObject o) {
        if (maxLoad > 0){
            if (Math.abs((o.x + o.y) - (this.x + this.y)) <= 1){
                cargo.add(o);
                o.lifted = true;
                maxLoad--;
            }

        }
    }

    /**
     * Déposer un objet.
     *
     * @param o  Objet à déposer
     */
    public void dropOff(FieldObject o) {

        if (!cargo.isEmpty()){
            if (cargo.remove(o)){
                maxLoad++;
                o.lifted = false;
                o.x = this.x;
                o.y = this.y;
            }
        }
    }

    @Override
    public int getWeight() {
        return weight + cargoWeight();
    }
}
