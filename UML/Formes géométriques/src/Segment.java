
import interfaces.ISegment;

/**
 *
 * @author Diane Lakestani
 * @author Vincent Poirier
 */
public class Segment extends Forme implements ISegment {

    private Point p1;
    private Point p2;

    /**
     * Construit un segment avec ses deux extrémités.
     *
     * @param p1 Une extrémité du segment.
     * @param p2 L'autre extrémité du segment.
     */
    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Calcule et retourne la longueur du segment.
     *
     * @return La longueur du segment.
     */
    public float longueur() {
        return (float) Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    /**
     * Renvoie la première extrémité du segment.
     *
     * @return La première extrémité du segment.
     */
    public Point getP1() {
        return p1;
    }

    /**
     * Renvoie la deuxième extrémité du segment.
     *
     * @return La deuxième extrémité du segment.
     */
    public Point getP2() {
        return p2;
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
        return this.longueur();
    }

    /**
     * Renvoie la représentation de l'objet.
     *
     * @return Chaîne représentant l'objet.
     */
    @Override
    public String affiche() {
        return "Segment reliant " + p1.affiche() + " et " + p2.affiche();
    }

}
