
/**
 * Troisième exercice du TD1
 * 
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Exercice3 {

    public static void main(String agrs[]) {
        int i = 10, j = 5;
        if (i < 5 && j++ < 10) {
            System.out.println("vrai");
        } else {
            System.out.println("faux");
        }

        System.out.println("i=" + i + " ; j=" + j);

        if (i < 5 & j++ < 10) {
            System.out.println("vrai");
        } else {
            System.out.println("faux");
        }

        System.out.println("i=" + i + " ; j=" + j);

        if (i < 15 && j++ < 10) {
            System.out.println("vrai");
        } else {
            System.out.println("faux");
        }

        System.out.println("i=" + i + " ; j=" + j);

        if (i < 15 || j++ < 10) {
            System.out.println("vrai");
        } else {
            System.out.println("faux");
        }

        System.out.println("i=" + i + " ; j=" + j);

        if (i < 5 || j++ < 10) {
            System.out.println("vrai");
        } else {
            System.out.println("faux");
        }

        System.out.println("i=" + i + " ; j=" + j);

        if (i < 15 | j++ < 10) {
            System.out.println("vrai");
        } else {
            System.out.println("faux");
        }

        System.out.println("i=" + i + " ; j=" + j);

    }
}
