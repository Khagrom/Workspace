package geometry.twoDim;

import geometry.zeroDim.Point2D;
import geometry.oneDim.Segment2D;

/**
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Rectangle2D {

    private final Segment2D s1;
    private final Segment2D s2;
    private final Segment2D s3;
    private final Segment2D s4;

    /**
     * Construit un rectangle à partir de quatre points. Privé car non protégée.
     * Seuls les constructeurs publics l'appellent en s'assurant de la cohérence
     * des points (qu'ils forment bien un rectangle).
     *
     * @param p1 Le premier point.
     * @param p2 Le premier point.
     * @param p3 Le troisième point.
     * @param p4 Le dernier point.
     */
    private Rectangle2D(Point2D p1, Point2D p2, Point2D p3, Point2D p4) {
        s1 = new Segment2D(p1, p2);
        s2 = new Segment2D(p2, p3);
        s3 = new Segment2D(p3, p4);
        s4 = new Segment2D(p4, p1);
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
    public Rectangle2D(Point2D p1, Point2D p2, Point2D p3) throws IllegalArgumentException {
        Point2D p4;

        // On calcule le dernier point. Pour ça il faut vérifier que les points forment bien un angle droit
        // et découvrir quel est le point sur lequel se situe l'angle.
        if (scalaire(p1, p2, p3) == 0) {
            // L'angle droit est sur p1
            p4 = new Point2D(p3.getX() + p2.getX() - p1.getX(), p3.getY() + p2.getY() - p1.getY());
        } else if (scalaire(p2, p1, p3) == 0) {
            // L'angle droit est sur p2
            p4 = new Point2D(p1.getX() + p3.getX() - p2.getX(), p1.getY() + p3.getY() - p2.getY());
        } else if (scalaire(p3, p2, p1) == 0) {
            // L'angle droit est sur p3
            p4 = new Point2D(p1.getX() + p2.getX() - p3.getX(), p1.getY() + p2.getY() - p3.getY());
        } else {
            //Pas d'angle droit
            throw new IllegalArgumentException("Les trois points ne forment pas un angle droit.");
        }

        // On construit ensuite les segments normalement. On appelle pas le constructeur à quatre points
        // parce qu'on en a pas la possibilité : il faudrait que ce soit la première instruction.
        s1 = new Segment2D(p1, p2);
        s2 = new Segment2D(p2, p3);
        s3 = new Segment2D(p3, p4);
        s4 = new Segment2D(p4, p1);
    }

    /**
     * Construit un rectangle sur la base de deux points formant la diagonale.
     * Le rectangle sera supposé aligné sur l'axe des abscisses et des
     * ordonnées.
     *
     * @param p1 Un extrémité de la diagonale.
     * @param p2 L'autre extrémité de la diagonale.
     */
    public Rectangle2D(Point2D p1, Point2D p2) {
        this(p1, new Point2D(p2.getX(), p1.getY()), p2, new Point2D(p1.getX(), p2.getY()));
    }

    /**
     * Calcule la surface du rectangle.
     *
     * @return La surface du rectangle.
     */
    public double surface() {
        return s1.longueur() * s2.longueur();
    }

    /**
     * Calcule le périmètre du rectangle.
     *
     * @return Le périmètre du rectangle.
     */
    public double perimetre() {
        return 2 * (s1.longueur() + s2.longueur());
    }

    /**
     * Calcule le produit scalaire des vecteurs p1-p2 et p1-p3.
     *
     * @param p1 Le point commun.
     * @param p2 Un point pour former l'angle.
     * @param p3 Le dernier point.
     * @return Le produit scalaire.
     */
    private static double scalaire(Point2D p1, Point2D p2, Point2D p3) {
        double x1 = p2.getX() - p1.getX();
        double y1 = p2.getY() - p1.getY();
        double x2 = p3.getX() - p1.getX();
        double y2 = p3.getY() - p1.getY();

        return x1 * x2 + y1 * y2;
    }

    public Segment2D getS1() {
        return s1;
    }

    public Segment2D getS2() {
        return s2;
    }

    public Segment2D getS3() {
        return s3;
    }

    public Segment2D getS4() {
        return s4;
    }
}
