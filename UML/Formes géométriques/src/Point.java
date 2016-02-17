
import interfaces.IPoint;

/**
 *
 * @author Diane Lakestani
 * @author Vincent Poirier
 */
public class Point extends Forme implements IPoint {

    private float x;
    private float y;

    /**
     * Construit un point à l'origine.
     */
    public Point() {
        this(0, 0);
    }

    /**
     * Construit un point à partir de son abscisse.
     *
     * @param abs L'abscisse du point.
     */
    public Point(float abs) {
        this(abs, 0);
    }

    /**
     * Construit un point à partir de ses deux coordonnées cartésiennes.
     *
     * @param x La coordonnée selon l'axe des abscisses.
     * @param y La coordonnée selon l'axe des ordonnées.
     */
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Calcule la distance entre ce point et un point spécifié.
     *
     * @param pt Le point spécifié.
     * @return La distance entre ce point et le point spécifié.
     */
    public float distance(Point pt) {
        return (float) Math.sqrt(Math.pow(pt.x - this.x, 2) + Math.pow(pt.y - this.y, 2));
    }

    /**
     * Calcule la surface de l'objet.
     *
     * @return La surface de l'objet.
     */
    @Override
    public float calculAire() {
        return 0f;
    }

    /**
     * Calcule le périmètre de l'objet.
     *
     * @return Le périmètre de l'objet.
     */
    @Override
    public float calculPerimetre() {
        return 0f;
    }
    
    /**
     * Renvoie la représentation de l'objet.
     *
     * @return Chaîne représentant l'objet.
     */
    @Override
    public String affiche() {
        return "[" + x + ", " + y + "]";
    }

    /**
     * Renvoie la coordonnée du point selon l'axe des abscisses.
     *
     * @return La coordonnée du point selon l'axe des abscisses.
     */
    public float getX() {
        return x;
    }

    /**
     * Renvoie la coordonnée du point selon l'axe des ordonnées.
     *
     * @return La coordonnée du point selon l'axe des ordonnées.
     */
    public float getY() {
        return y;
    }
}
