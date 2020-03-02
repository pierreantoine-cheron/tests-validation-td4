package testvalidation;

import static java.lang.Math.*;

/**
 * Classe pour le terrain où évolueront les objets.
 */

public class Field {

    /**
     * Hauteur et largeur du terrain.
     */
    public int heigth, width;

    /**
     * Construction d'un terrain de dimensions données.
     *
     * @param h  Hauteur du terrain
     * @param w  Largeur du terrain
     */
    public Field(int h, int w) {
        if (h <= 0){
            h = 1;
        }
        if (w <= 0){
            w = 1;
        }
        heigth = h;
        width = w;
    }

    /**
     * Normalisation d'une abscisse.
     *
     * @param x  Abscisse quelconque
     * @return Abscisse normalisée
     */
    public double normalizeX(double x) {
        if (x > width){
            x = width;
        }
        if (x <= 0){
            x = 0;
        }
        return x;
    }

    /**
     * Normalisation d'une ordonnée.
     *
     * @param x  Ordonnée quelconque
     * @return Ordonnée normalisée
     */
    public double normalizeY(double y) {
        if (y > heigth){
            y = heigth;
        }
        if (y <= 0){
            y = 0;
        }
        return y;
    }

}
