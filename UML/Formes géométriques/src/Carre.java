
import interfaces.ICarre;

/**
 *
 * @author Diane Lakestani
 * @author Vincent Poirier
 */
public class Carre extends Rectangle implements ICarre {

    /**
     * Construit un carré sur la base de deux points formant la diagonale.
     *
     * @param p1 Un extrémité de la diagonale.
     * @param p2 L'autre extrémité de la diagonale.
     */
    public Carre(Point p1, Point p2) {
        super(p1, p2);

        // Calcul du milieu
        Point m = new Point(((p1.getX() + p2.getX()) * 0.5f), ((p1.getY() + p2.getY()) * 0.5f));

        // Demi-diagonale
        Point d = new Point(((p1.getX() - p2.getX()) * 0.5f), ((p1.getY() - p2.getY()) * 0.5f));

        // Derniers points
        Point p3 = new Point(m.getX() - d.getY(), m.getY() + d.getX());
        Point p4 = new Point(m.getX() + d.getY(), m.getY() - d.getX());

        s1 = new Segment(p1, p3);
        s2 = new Segment(p3, p2);
        s3 = new Segment(p2, p4);
        s4 = new Segment(p4, p1);
    }

    /**
     * Calcule la surface de l'objet.
     *
     * @return La surface de l'objet.
     */
    @Override
    public float calculAire() {
        return s1.longueur() * s1.longueur();
    }

    /**
     * Calcule le périmètre de l'objet.
     *
     * @return Le périmètre de l'objet.
     */
    @Override
    public float calculPerimetre() {
        return 4 * s1.longueur();
    }

    /**
     * Renvoie la représentation de l'objet.
     *
     * @return Chaîne représentant l'objet.
     */
    @Override
    public String affiche() {
        return "Carré formé par les points " + s1.getP1().affiche() + ", " + s2.getP1().affiche() + ", " + s3.getP1().affiche() + " et " + s4.getP1().affiche();
    }

    /**
     * Renvoie la confirmation que l'objet est un losange.
     *
     * @return Chaîne confirmant que l'objet est un losange.
     */
    @Override
    public String typeLosange() {
        return "L'objet est un losange.";
    }

    /**
     * Renvoie le premier segment de l'objet.
     *
     * @return Le premier segment de l'objet.
     */
    @Override
    public Segment getS1() {
        return s1;
    }

    /**
     * Renvoie le second segment de l'objet.
     *
     * @return Le second segment de l'objet.
     */
    @Override
    public Segment getS2() {
        return s2;
    }

    /**
     * Renvoie le troisième segment de l'objet.
     *
     * @return Le troisième segment de l'objet.
     */
    @Override
    public Segment getS3() {
        return s3;
    }

    /**
     * Renvoie le quatrième semgent de l'objet.
     *
     * @return Le quatrième segment de l'objet.
     */
    @Override
    public Segment getS4() {
        return s4;
    }
}
