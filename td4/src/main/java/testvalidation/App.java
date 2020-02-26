package testvalidation;

public class App {
    public static void main(String[] args) {
        int[] tab = racineCarrees(5, 1);
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i] + "\n");
        }
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

}
