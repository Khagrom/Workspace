package tests;

import geometry.zeroDim.Point2D;
import geometry.oneDim.Segment2D;

/**
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class TestSegment2D {

    public static void main(String[] args) {
        Segment2D s1 = new Segment2D(new Point2D(-1, -1), new Point2D(1, 1));
        Segment2D s2 = new Segment2D(new Point2D(-1, 1), new Point2D(1, -1));
        System.out.println("Coordonnées du segment S1 : " + s1.toString());

        // Affichage des caractéristiques de S1
        System.out.println("Longueur de S1 : " + s1.longueur());
        System.out.println("Première extrémité de S1 : " + s1.getP1());
        System.out.println("Deuxième extrémité de S1 : " + s1.getP2());

    }

}
