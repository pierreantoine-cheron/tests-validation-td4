package testvalidation;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public int[] racineCarrees(int a, int b) {//calcule les racines carrees des nombres de A a B
        if (a>b) {
            throw new Exception("A must be <= B");//renvoie une exception si b > a
        }
        int[] tab = new int[b-a];
        for (int i = a; i < b; i++) {
            tab[i-a] = (int)Math.sqrt(i);
        }
        return tab;
    }

}
