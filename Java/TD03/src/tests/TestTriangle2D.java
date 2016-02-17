package tests;

import geometry.zeroDim.Point2D;
import geometry.twoDim.Triangle2D;

/**
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class TestTriangle2D {

    public static void main(String[] args) {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3);
        Point2D p3 = new Point2D(3, 4);
        Triangle2D t1 = new Triangle2D(p1, p2, p3);
        System.out.println("Points du triangle T1 : " + p1.toString() + ", " + p2.toString() + " et " + p3.toString());

        // Surface et périmètre
        System.out.println("Surface de T1 : " + t1.surface());
        System.out.println("Périmètre de T1 : " + t1.perimetre());
    }

}
