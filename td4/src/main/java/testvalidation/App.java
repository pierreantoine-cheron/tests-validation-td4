package testvalidation;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int [] tab= racineCarrees(10, 15);
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]+"\n");
        }
    }

    public static int[] racineCarrees(int a, int b) {//calcule les racines carrees des nombres de A a B
        try {
            if (a>b) {
                throw new Exception("A must be <= B");//renvoie une exception si b > a
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int[] tab = new int[b-a];
        for (int i = a; i < b; i++) {
            tab[i-a] = (int)Math.sqrt(i);
        }
        return tab;
    }

}
