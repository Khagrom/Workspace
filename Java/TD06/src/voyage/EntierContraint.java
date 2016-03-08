package voyage;


/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 *
 * Représente un nombre entier contraint.
 */
public class EntierContraint {

    private final int min;
    private final int max;
    private int val;

    public EntierContraint(int min, int max) {
        this(min, max, min);
    }

    public EntierContraint(int min, int max, int val) throws IllegalArgumentException {
        if (min > max) {
            throw new IllegalArgumentException("Intervalle non valide : min > max.");
        }
        if (val < min || val > max) {
            throw new IllegalArgumentException("Le nombre n'est pas entre min et max.");
        }

        this.min = min;
        this.max = max;
        this.val = val;
    }

    @Override
    public String toString() {
        return val + " dans [" + min + ", " + max + "]";
    }

    /**
     * Fixe le nouveau nombre.
     *
     * @param num Le nombre à fixer. Doit être entre les bornes.
     * @throws IllegalArgumentException si le nombre spécifié n'est pas entre
     * les bornes.
     */
    public void setVal(int num) throws IllegalArgumentException {
        if (num < min || num > max) {
            throw new IllegalArgumentException("Nombre non valide : hors de l'intervalle [" + this.min + ", " + this.max + "]");
        }
        this.val = num;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getVal() {
        return val;
    }
}
