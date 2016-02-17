package geometry.twoDim;

import geometry.zeroDim.Point2D;
import geometry.oneDim.Segment2D;

/**
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Triangle2D {

    private final Segment2D s1;
    private final Segment2D s2;
    private final Segment2D s3;

    /**
     * Construit un triangle à partir de trois points.
     *
     * @param p1 Le premier point.
     * @param p2 Le second point.
     * @param p3 Le dernier point.
     */
    public Triangle2D(Point2D p1, Point2D p2, Point2D p3) {
        s1 = new Segment2D(p1, p2);
        s2 = new Segment2D(p2, p3);
        s3 = new Segment2D(p3, p1);
    }

    /**
     * Calcule la surface du triangle.
     *
     * @return La surface du triangle.
     */
    public double surface() {
        double l1 = s1.longueur();
        double l2 = s2.longueur();
        double l3 = s3.longueur();
        double l = 0.5 * (l1 + l2 + l3);
        return Math.sqrt(l * (l - l1) * (l - l2) * (l - l3));
    }

    /**
     * Calcule le périmètre du triangle.
     *
     * @return Le périmètre du triangle.
     */
    public double perimetre() {
        return s1.longueur() + s2.longueur() + s3.longueur();
    }
}
