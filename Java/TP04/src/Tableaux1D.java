
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Tableaux1D {

    public static void main(String[] args) {
        carres(10);
    }

    /**
     * Cette méthode répond à la question 2.
     *
     * @param n Le nombre de carrés à générer.
     */
    public static void carres(int n) {
        int car[] = new int[n];

        // Assignation des valeurs
        for (int i = 0; i < car.length; i++) {
            car[i] = (int) (Math.pow(2 * i, 2));
        }

        // Lecture avec syntaxe normale
        for (int i = 0; i < car.length; i++) {
            System.out.println(car[i]);
        }

        // Lecture avec syntaxe foreach
        for (int num : car) {
            System.out.println(num);
        }
    }

    /**
     * Cette méthode répond à la question 1.
     */
    public static void erreurs() {
        int n = 10;
        final int p = 5;
        int t1[] = {1, 3, 5};
        int t2[] = {n - 1, n, n + 2};
        int t3[] = {p - 2, p, p + 3};
        int t4[];
        // Jusqu'ici OK

        // La ligne suivante ne compile pas.
        // t4 = {1, 2, 3};
        // On peut la remplacer par la suivante pour déclarer un tableau vide de 3 cases.
        // t4 = new int[3];
        // En revanche, il faudra les initialiser une par une.
        // On peut mettre des int dans des float, ils seront convertis (ajustement).
        float x1[] = {1, 2, p, p + 7};

        // Par contre on ne peut pas mettre des double dans des float sans perte d'information.
        // Le compilateur refuse donc la ligne suivante.
        // float x2[] = {1.25, 2.5, 5};
        // On peut la remplacer par cette ligne si on souhaite des float, ou déclarer le tableau comme double.
        float x2[] = {1.25f, 2.5f, 5};
    }
}
