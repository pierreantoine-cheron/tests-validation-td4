package testvalidation;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        /*
        int[] tab = racineCarrees(5, 1);
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i] + "\n");
        }
         */
        //genererMatrice(10, 10, 0, 0);
        triangle(14, 7, 7);
    }

    public static int[] racineCarrees(int a, int b) {// calcule les racines carrees des nombres de A a B
        try {
            if (a > b) {
                throw new Exception("A must be <= B");// renvoie une exception si b > a
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        try {
            if (a < 0 || b < 0) {
                throw new Exception("A & Bmust be > 0");// renvoie une exception si b > a
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        int[] tab = new int[b - a + 1];
        for (int i = a; i <= b; i++) {
            tab[i - a] = (int) Math.sqrt(i);
        }
        return tab;
    }


    /**
     *
     * @param m Ligne de la matrice
     * @param n Colonne de la matrice
     * @param a Borne inférieur du nombre à générer pour chaque case
     * @param b Borne supérieur du nombre à générer pour chaque case
     * @return Une matrice M*N dont les cases sont remplies aléatoirement avec un nombre allant de A à B
     */
    public static int[][] genererMatrice(int m, int n, int a, int b){
        //Initialisation de la fonction random
        Random r = new Random();

        //Diverses vérifications pour éviter des bugs
        try {
            if (b < a) {
                throw new Exception("A ne peux pas être plus grand que B");
            }

            if (b == 0){
                throw new Exception("B ne peut pas être égal à 0");
            }

            if (m <= 0) {
                throw new Exception("M ne peux pas être inférieur ou égal à 0");
            }

            if (n <= 0) {
                throw new Exception("N ne peux pas être inférieur ou égal à 0");
            }
        }

        //Si une des vérifications n'est pas bonne, alors le programme s'interrompt
        catch (Exception e){
                System.out.println(e.getMessage());
                return null;
        }

        // Création de la matrice
        int [][] matrice = new int[m][n];

        //Remplissage de la matrice
        for (int i = 0; i < m ; i++){
            for (int j = 0; j < n; j++){
                //Je l'ai honteusement pompé sur Internet, mais faut avouer que c'est du génie
                matrice[i][j] = r.nextInt(b-a) + a;
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println("");
        }
        return matrice;
    }

    public static int triangle(int a, int b, int c){

        //Diverses vérifications pour éviter des bugs
        try {
            if (a < 0) {
                throw new Exception("A ne peux pas être inférieur à 0");
            }
            if (b < 0) {
                throw new Exception("B ne peux pas être inférieur à 0");
            }
            if (c < 0) {
                throw new Exception("C ne peux pas être inférieur à 0");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }

        //Si A est plus grand que B et C réunis
        if (a >= b && a >= c){
            if (a > b + c){
                System.out.println("Ce n'est pas un triangle");
                return 4;
            }
        }

        //Si B est plus grand que A et C réunis
        if (b >= a && b >= c){
            if (b > a + c){
                System.out.println("Ce n'est pas un triangle");
                return 4;
            }
        }

        //Si C est plus grand que A et B réunis
        if (c >= a && c >= b){
            if (c > b + a){
                System.out.println("Ce n'est pas un triangle");
                return 4;
            }

        }

        //Si les trois côtés sont différents
        if (a != b && b != c && a != c){
            System.out.println("Triangle scalène");
            return 3;
        }

        //Si les trois côtés sont les mêmes
        if (a == b && b == c){
            System.out.println("Triangle équilatéral");
            return 2;
        }

        //Si deux côtés sont les mêmes, peu importe lesquelles
        if (a == c || b == c){
            System.out.println("Triangle isocèle");
            return 1;
        }

        return 0;
    }

}
