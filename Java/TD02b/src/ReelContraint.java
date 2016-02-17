
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 *
 * Représente un nombre réel contraint.
 */
public class ReelContraint {

    private final double min;
    private final double max;
    private double val;

    public ReelContraint(double min, double max) {
        this(min, max, min);
    }

    public ReelContraint(double min, double max, double val) throws IllegalArgumentException {
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
    public void setVal(double num) throws IllegalArgumentException {
        if (num < min || num > max) {
            throw new IllegalArgumentException("Nombre non valide : hors de l'intervalle [" + this.min + ", " + this.max + "]");
        }
        this.val = num;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getVal() {
        return val;
    }
}
