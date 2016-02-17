
/**
 * Quatrième exercice du TD1
 * 
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Exercice4 {

    public static void main(String[] args) {
        int n = 0;
        do {
            if (n % 2 == 0) {
                System.out.println(n + " est pair");
                n += 3;
                continue;
            }

            if (n % 3 == 0) {
                System.out.println(n + " est multiple de 3");
                n += 5;
            }

            if (n % 5 == 0) {
                System.out.println(n + " est multiple de 5");
                break;
            }
            n += 1;
        } while (true);

    }
}
