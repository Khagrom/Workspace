
import interfaces.IParallelogramme;

/**
 *
 * @author Diane Lakestani
 * @author Vincent Poirier
 */
public class Parallelogramme extends Forme implements IParallelogramme {

    protected Segment s1;
    protected Segment s2;
    protected Segment s3;
    protected Segment s4;

    /**
     * Construit un parallélogramme sur la base de trois points. Le point p4 est
     * toujours construit à l'opposé de p2.
     *
     * @param p1 Le premier point.
     * @param p2 Le second point.
     * @param p3 Le dernier point.
     */
    public Parallelogramme(Point p1, Point p2, Point p3) {
        Point p4 = new Point(p1.getX() + p3.getX() - p2.getX(), p1.getY() + p3.getY() - p2.getY());
        s1 = new Segment(p1, p4);
        s2 = new Segment(p4, p3);
        s3 = new Segment(p3, p2);
        s4 = new Segment(p2, p1);
    }

    /**
     * Calcule la surface de l'objet.
     *
     * @return La surface de l'objet.
     */
    @Override
    public float calculAire() {
        float l1 = s1.longueur();
        float l2 = s2.longueur();
        float l3 = new Segment(s1.getP1(), s2.getP2()).longueur();
        float l = 0.5f * (l1 + l2 + l3);
        return (float) (2 * Math.sqrt(l * (l - l1) * (l - l2) * (l - l3)));
    }

    /**
     * Calcule le périmètre de l'objet.
     *
     * @return Le périmètre de l'objet.
     */
    @Override
    public float calculPerimetre() {
        return 2 * (s1.longueur() + s2.longueur());
    }

    /**
     * Renvoie la représentation de l'objet.
     *
     * @return Chaîne représentant l'objet.
     */
    @Override
    public String affiche() {
        return "Parallélogramme formé par les points " + s1.getP1().affiche() + ", " + s2.getP1().affiche() + ", " + s3.getP1().affiche() + " et " + s4.getP1().affiche();
    }

    /**
     * Renvoie le premier segment de l'objet.
     *
     * @return Le premier segment de l'objet.
     */
    public Segment getS1() {
        return s1;
    }

    /**
     * Renvoie le second segment de l'objet.
     *
     * @return Le second segment de l'objet.
     */
    public Segment getS2() {
        return s2;
    }

    /**
     * Renvoie le troisième segment de l'objet.
     *
     * @return Le troisième segment de l'objet.
     */
    public Segment getS3() {
        return s3;
    }

    /**
     * Renvoie le quatrième semgent de l'objet.
     *
     * @return Le quatrième segment de l'objet.
     */
    public Segment getS4() {
        return s4;
    }

}
