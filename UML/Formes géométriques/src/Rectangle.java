
import interfaces.IRectangle;

/**
 *
 * @author Diane Lakestani
 * @author Vincent Poirier
 */
public class Rectangle extends Parallelogramme implements IRectangle {

    /**
     * Construit un rectangle à partir de quatre points. Privé car non protégée.
     * Seuls les constructeurs publics l'appellent en s'assurant de la cohérence
     * des points (qu'ils forment bien un rectangle).
     *
     * @param p1 Le premier point.
     * @param p2 Le second point.
     * @param p3 Le troisième point.
     * @param p4 Le dernier point.
     */
    private Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3);
        s1 = new Segment(p1, p2);
        s2 = new Segment(p2, p3);
        s3 = new Segment(p3, p4);
        s4 = new Segment(p4, p1);
    }

    /**
     * Construit un rectangle sur la base de deux points formant la diagonale.
     * Le rectangle sera supposé aligné sur l'axe des abscisses et des
     * ordonnées.
     *
     * @param p1 Un extrémité de la diagonale.
     * @param p2 L'autre extrémité de la diagonale.
     */
    public Rectangle(Point p1, Point p2) {
        this(p1, new Point(p2.getX(), p1.getY()), p2, new Point(p1.getX(), p2.getY()));
    }

    /**
     * Construit un rectangle sur la base de trois points. Les trois points
     * doivent former un angle droit, peu importe à quel point se situe l'angle.
     *
     * @param p1 Le premier point.
     * @param p2 Le second point.
     * @param p3 Le dernier point.
     * @throws IllegalArgumentException Lorsque les points ne forment pas un
     * angle droit.
     */
    public Rectangle(Point p1, Point p2, Point p3) throws IllegalArgumentException {
        super(p1, p2, p3);
        Point p4;

        // On calcule le dernier point. Pour ça il faut vérifier que les points forment bien un angle droit
        // et découvrir quel est le point sur lequel se situe l'angle.
        if (scalaire(p1, p2, p3) == 0) {
            // L'angle droit est sur p1
            p4 = new Point(p3.getX() + p2.getX() - p1.getX(), p3.getY() + p2.getY() - p1.getY());
            s1 = new Segment(p1, p2);
            s2 = new Segment(p2, p4);
            s3 = new Segment(p4, p3);
            s4 = new Segment(p3, p1);
        } else if (scalaire(p2, p1, p3) == 0) {
            // L'angle droit est sur p2
            p4 = new Point(p1.getX() + p3.getX() - p2.getX(), p1.getY() + p3.getY() - p2.getY());
            s1 = new Segment(p1, p2);
            s2 = new Segment(p2, p3);
            s3 = new Segment(p3, p4);
            s4 = new Segment(p4, p1);
        } else if (scalaire(p3, p2, p1) == 0) {
            // L'angle droit est sur p3
            p4 = new Point(p1.getX() + p2.getX() - p3.getX(), p1.getY() + p2.getY() - p3.getY());
            s1 = new Segment(p1, p3);
            s2 = new Segment(p3, p2);
            s3 = new Segment(p2, p4);
            s4 = new Segment(p4, p1);
        } else {
            //Pas d'angle droit
            throw new IllegalArgumentException("Les trois points ne forment pas un angle droit.");
        }
    }

    /**
     * Calcule le produit scalaire des vecteurs p1-p2 et p1-p3.
     *
     * @param p1 Le point commun.
     * @param p2 Un point pour former l'angle.
     * @param p3 Le dernier point.
     * @return Le produit scalaire.
     */
    private static float scalaire(Point p1, Point p2, Point p3) {
        float x1 = p2.getX() - p1.getX();
        float y1 = p2.getY() - p1.getY();
        float x2 = p3.getX() - p1.getX();
        float y2 = p3.getY() - p1.getY();

        return x1 * x2 + y1 * y2;
    }
    
    /**
     * Calcule la surface de l'objet.
     *
     * @return La surface de l'objet.
     */
    @Override
    public float calculAire() {
        return s1.longueur() * s2.longueur();
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
        return "Rectangle formé par les points " + s1.getP1().affiche() + ", " + s2.getP1().affiche() + ", " + s3.getP1().affiche() + " et " + s4.getP1().affiche();
    }

    /**
     * Renvoie la confirmation que l'objet est un rectangle.
     *
     * @return Chaîne confirmant que l'objet est un rectangle.
     */
    @Override
    public String typeRectangle() {
        return "L'objet est un rectangle.";
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
