package tests;

import geometry.twoDim.Rectangle2D;
import geometry.zeroDim.Point2D;

/**
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class TestRectangle2D {

    public static void main(String[] args) {
        // R1 sur 3 points
        Point2D p11 = new Point2D();
        Point2D p12 = new Point2D(3);
        Point2D p13 = new Point2D(3, 4);
        Rectangle2D r1 = new Rectangle2D(p11, p12, p13);
        System.out.println("Points du rectangle R1 : " + p11.toString() + ", " + p12.toString() + ", " + p13.toString() + " et " + r1.getS4().getP1().toString());

        // Surface et périmètre
        System.out.println("Surface de R1 : " + r1.surface());
        System.out.println("Périmètre de R1 : " + r1.perimetre());
        System.out.println();

        // R2 sur 2 points
        Point2D p21 = new Point2D(1, 1);
        Point2D p22 = new Point2D(2, 3);
        Rectangle2D r2 = new Rectangle2D(p21, p22);
        System.out.println("Points du rectangle R2 : " + p21.toString() + ", " + r2.getS2().getP1().toString() + ", " + p22.toString() + " et " + r2.getS4().getP1().toString());

        // Surface et périmètre
        System.out.println("Surface de R2 : " + r2.surface());
        System.out.println("Périmètre de R2 : " + r2.perimetre());

        
    }

}
