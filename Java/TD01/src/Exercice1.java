
/**
 * Premier exercice du TD1
 * 
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Exercice1 {

    /**
     * Imprime un nombre et son type.
     *
     * @param a Le nombre à imprimer.
     */
    public static void print(int a) {
        System.out.println("int : " + a);
    }

    /**
     * Imprime un nombre et son type.
     *
     * @param a Le nombre à imprimer.
     */
    public static void print(long a) {
        System.out.println("long : " + a);
    }

    /**
     * Imprime un nombre et son type.
     *
     * @param a Le nombre à imprimer.
     */
    public static void print(float a) {
        System.out.println("float : " + a);
    }

    /**
     * Imprime un nombre et son type.
     *
     * @param a Le nombre à imprimer.
     */
    public static void print(double a) {
        System.out.println("double : " + a);
    }

    public static void main(String[] args) {
        byte b1 = 10, b2 = 20;
        short p = 200;
        int n = 500;
        long q = 100;
        float x = 2.5f;
        //double y = 5.25;

        print(b1 + b2);
        /* Promotion de chaque variable en int,
         * b1 + b2.
         * => int 30
         */
        
        print(p + b1);
        /* Promotion de chaque variable en int,
         * p + b1.
         * => int 210
         */
        
        print(b1 * b2);
        /* Promotion de chaque variable en int,
         * b1 * b1.
         * => int 200
         */
        
        print(q + p * (b1 + b2));
        /* Promotion de b1 et b2 en int,
         * b1 + b2,
         * conversion d'ajustement de p en int,
         * p * (b1 + b2),
         * conversion d'ajustement du résultat en long,
         * q + p * (b1 + b2).
         * => long 6100
         */
        
        print(x + q * n);
        /* Conversion d'ajustement de n en long,
         * q * n,
         * conversion d'ajustement du résultat en float,
         * x + q * n.
         * => float 50002.5
         */
        
        print(b1 * q / x);
        /* Promotion puis conversion d'ajustement de b1 en long,
         * b1 * q,
         * conversion d'ajustement du résultat en float,
         * b1 * q / x.
         * => float 400.0
         */
        
        print(b1 * q * 2. / x);
        /* Promotion puis conversion d'ajustement de b1 en long,
         * b1 * q,
         * conversion d'ajustement du résultat en double,
         * b1 * q * 2.,
         * conversion d'ajustement de x en double,
         * b1 * q * 2. / x,
         * => double 800.0
         */
        
        print(b1 * q * 2.f / x);
        /* Promotion puis conversion d'ajustement de b1 en long,
         * b1 * q,
         * conversion d'ajustement du résultat en float,
         * b1 * q * 2.f,
         * b1 * q * 2.f / x,
         * => float 800.0
         */

        char c = 60, ce = 'e', cg = 'g';
        byte b = 10;

        print(c + 1);
        /* Promotion de c en int,
         * c + 1.
         * => int 61
         */
        
        print(2 * c);
        /* Promotion de c en int,
         * 2 * c.
         * => int 120
         */
        
        print(cg - ce);
        /* Promotion de chaque variable en int,
         * cg - ce.
         * => int 2
         */
        
        print(b * c);
        /* Promotion de chaque variable en int,
         * b * c.
         * => int 600
         */
    }
}
