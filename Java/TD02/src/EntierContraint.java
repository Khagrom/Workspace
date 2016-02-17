
/**
 * Cette classe représente un entier contraint.
 *
 * @author Vincent Poirier
 */
public class EntierContraint {

    /**
     * Borne inférieure de l'intervalle
     */
    private final int min;
    /**
     * Borne supérieure de l'intervalle
     */
    private final int max;
    /**
     * Valeur de l'entier
     */
    private int val;

    /**
     * Constructeur de l'intervalle
     *
     * @param min Borne inf.
     * @param max Bone sup.
     */
    public EntierContraint(int min, int max) {
        this(min, max, min);
    }

    /**
     * Constructeur avec valeur
     *
     * @param min Borne inf.
     * @param max Bone sup.
     * @param val Valeur
     * @throws ArithmeticException Si intervalle et/ou valeur non correcte
     */
    public EntierContraint(int min, int max, int val) throws ArithmeticException {
        if (min <= max && val >= min && val <= max) {
            this.min = min;
            this.max = max;
            this.val = val;
        } else {
            if (min > max) {
                throw new ArithmeticException("La valeur de la borne inférieure doit être inférieure à la valeur de la borne supérieure.");
            } else {
                throw new ArithmeticException("La valeur doit être comprise dans l'intervalle. " + val + " n'est pas acceptable.");
            }
        }
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

    /**
     * Permet de définir la valeur de l'entier
     *
     * @param val Valeur
     * @throws IndexOutOfBoundsException Si hors des bornes
     */
    public void setVal(int val) throws IndexOutOfBoundsException {
        if (val >= this.min && val <= this.max) {
            this.val = val;
        } else {
            throw new IndexOutOfBoundsException("La valeur doit être comprise dans l'intervalle : [" + this.min + ", " + this.max + "]. " + val + " n'est pas acceptable.");
        }
    }

    /**
     * Méthode permettant de saisir une nouvelle valeur pour l'entier.
     *
     * @deprecated Préférer l'emploi du mutateur standard
     */
    public void saisie() {
        boolean valid = false;
        while (!valid) {
            int input = Clavier.lireInt();
            if (input >= this.min && input <= this.max) {
                this.val = input;
                valid = true;
            } else {
                System.out.println("La valeur doit être comprise dans l'intervalle : [" + this.min + ", " + this.max + "]");
                System.out.print("Rééssayez : ");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.val));
        sb.append(" dans [");
        sb.append(Integer.toString(this.min));
        sb.append(",");
        sb.append(Integer.toString(this.max));
        sb.append("]");
        return sb.toString();
    }

    public void affiche() {
        System.out.println(this.toString());
    }

    /**
     * Permet d'incrémenter l'entier
     *
     * @param i Incrément
     * @throws IndexOutOfBoundsException Si la valeur calculée dépasse les
     * bornes de l'intervalle
     */
    public void incr(int i) throws IndexOutOfBoundsException {
        int newVal = this.val + i;
        if (newVal >= this.min && newVal <= this.max) {
            this.val = newVal;
        } else {
            throw new IndexOutOfBoundsException("La valeur doit être comprise dans l'intervalle : [" + this.min + ", " + this.max + "]. \n"
                    + newVal + " n'est pas acceptable.");
        }
    }
}
