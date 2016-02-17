
import interfaces.ICercle;

/**
 *
 * @author Diane Lakestani
 * @author Vincent Poirier
 */
public class Cercle extends Forme implements ICercle {

    private Point centre;
    private float rayon;

    /**
     * Construit un cercle sur la base d'un point et d'un rayon.
     *
     * @param centre Le centre du cercle.
     * @param rayon Le rayon du cercle.
     */
    public Cercle(Point centre, float rayon) {
        this.centre = centre;
        this.rayon = rayon;
    }

    /**
     * Calcule la surface de l'objet.
     *
     * @return La surface de l'objet.
     */
    @Override
    public float calculAire() {
        return (float) (Math.PI * Math.pow(rayon, 2));
    }

    /**
     * Calcule le périmètre de l'objet.
     *
     * @return Le périmètre de l'objet.
     */
    @Override
    public float calculPerimetre() {
        return (float) (Math.PI * 2 * rayon);
    }

    /**
     * Renvoie la représentation de l'objet.
     *
     * @return Chaîne représentant l'objet.
     */
    @Override
    public String affiche() {
        return "Cercle de centre " + centre.affiche() + " et de rayon " + rayon;
    }

    /**
     * Renvoie le centre du cercle.
     *
     * @return Le centre du cercle.
     */
    public Point getCentre() {
        return centre;
    }

    /**
     * Renvoie le rayon du cercle.
     *
     * @return Le rayon du cercle.
     */
    public float getRayon() {
        return rayon;
    }
}
