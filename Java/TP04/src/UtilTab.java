
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class UtilTab {

    /**
     * Additionne les éléments dans le tableau.
     *
     * @param tab Un tableau de double.
     * @return La somme des éléments du tableau.
     */
    public static double somme(double tab[]) {
        double somme = 0;
        for (double n : tab) {
            somme += n;
        }

        return somme;
    }

    public static double moyenne(double tab[]) {
        if (tab.length == 0) {
            return 0;
        }
        return somme(tab) / tab.length;
    }

    public static double min(double tab[]) throws IllegalArgumentException {
        if (tab.length == 0) {
            throw new IllegalArgumentException("Tableau vide.");
        }

        double min = tab[0];

        for (double n : tab) {
            if (n < min) {
                min = n;
            }
        }

        return min;
    }

    public static double max(double tab[]) throws IllegalArgumentException {
        if (tab.length == 0) {
            throw new IllegalArgumentException("Tableau vide.");
        }

        double max = tab[0];

        for (double n : tab) {
            if (n > max) {
                max = n;
            }
        }

        return max;
    }

    public static void affichage(double tab[]) {
        System.out.print("[");
        int i;
        for (i = 0; i < tab.length - 1; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.println(tab[i] + "]");
    }

    /**
     * Copie les valeurs du premier tableau dans le second. Le second tableau
     * doit être plus grand que le premier.
     *
     * @param tab1 Le tableau à copier.
     * @param tab2 Le tableau dans lequel copier les valeurs.
     * @throws IllegalArgumentException Quand le tableau cible est trop petit.
     */
    public static void copie(double tab1[], double tab2[]) throws IllegalArgumentException {
        if (tab1.length > tab2.length) {
            throw new IllegalArgumentException("Le tableau cible est trop petit.");
        }

        System.arraycopy(tab1, 0, tab2, 0, tab1.length);

        /* Il s'agit de l'ancienne manière de procéder.
        for (int i = 0; i < tab.length; i++) {
            tab2[i] = tab[i];
        } 
         */
    }

    /**
     * Crée un nouveau tableau avec les valeurs de celui donné en argument.
     *
     * @param tab Le tableau à copier.
     * @return Le nouveau tableau avec les valeurs de celui donné en argument.
     */
    public static double[] copie(double tab[]) {
        double[] tab2 = new double[tab.length];
        copie(tab, tab2);
        return tab2;
    }

    /**
     * Cette méthode génère un tableau rempli de valeurs aléatoires entre 0
     * (inclus) et 100 (exclus).
     *
     * @param nbCases Le nombre de cases dans le tableau.
     * @return Un tableau de double rempli de valeurs aléatoires.
     */
    public static double[] genereTabAlea(int nbCases) {
        double[] tab = new double[nbCases];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = Math.random() * 100;
        }

        return tab;
    }

    public static float somme(float[][] tab) {
        float somme = 0;

        for (float[] t : tab) {
            for (float val : t) {
                somme += val;
            }
        }

        return somme;
    }

    public static int compteCases(float[][] tab) {
        int nbCases = 0;

        for (float[] t : tab) {
            nbCases += t.length;
        }

        return nbCases;
    }

    public static float moyenne(float[][] tab) {
        int compte = compteCases(tab);
        if (compte == 0) {
            return 0;
        }

        return somme(tab) / compte;
    }

    public static float sommeLigne(float[][] tab, int indiceL) {
        if (tab.length == 0) {
            return 0;
        }

        float somme = 0;

        for (float n : tab[indiceL]) {
            somme += n;
        }

        return somme;
    }

    public static float sommeColonne(float[][] tab, int indiceC) {
        float somme = 0;

        for (float[] aTab : tab) {
            if (aTab.length > indiceC) {
                somme += aTab[indiceC];
            }
        }

        return somme;
    }

    public static void affichage(float[][] tab) {
        System.out.print('[');
        int i;

        for (i = 0; i < tab.length - 1; i++) {
            affichage(tab[i]);
            System.out.println(',');
        }

        affichage(tab[i]);
        System.out.println(']');
    }

    public static void affichage(float tab[]) {
        System.out.print("[");
        int i;
        for (i = 0; i < tab.length - 1; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.print(tab[i] + "]");
    }

    public static float[][] copie(float[][] tab) {
        float[][] t = new float[tab.length][];

        for (int i = 0; i < tab.length; i++) {
            t[i] = new float[tab[i].length];
            System.arraycopy(tab[i], 0, t[i], 0, t[i].length);
        }

        return t;
    }
}
