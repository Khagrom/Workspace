
/**
 * Deuxième exercice du TD1
 * 
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Exercice2 {

    public static void main(String[] args) {
        double x1 = 1e200, x2 = 1e210;
        double y, z;

        y = x1 * x2;
        x2 = x1;
        z = y / (x2 - x1);
        System.out.println(y + " / " + (x2 - x1) + " = " + z);
        // Infinity / 0.0 = Infinity

        y = 1;
        z = y / (x2 - x1);
        System.out.println(y + " / " + (x2 - x1) + " = " + z);
        // 1.0 / 0.0 = Infinity

        z = (x2 - x1) / (x2 - x1);
        System.out.println((x2 - x1) + " / " + (x2 - x1) + " = " + z);
        // 0.0 / 0.0 = NaN

        System.out.println(z + " + " + 1 + " = " + (z + 1));
        // NaN + 1 = NaN
    }
}
