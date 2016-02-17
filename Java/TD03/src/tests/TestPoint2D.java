package tests;

import geometry.zeroDim.Point2D;

/**
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class TestPoint2D {

    public static void main(String[] args) {
        Point2D p1 = new Point2D(0, 0);
        Point2D p2 = new Point2D(-1, -1);

        // Affichage des coordonnées de P1 et P2
        System.out.println("Coordonnées de P1 : " + p1.toString());
        System.out.println("Coordonnées de P2 : " + p2.toString());
        System.out.println();

        // On déplace P1 de 2 en abscisse et de 3 en ordonnée
        p1.deplace(2, 3);
        System.out.println("On déplace P1 de 2 en abscisses en 3 en ordonnées.");
        System.out.println("Nouvelles coordonnées de P1 : " + p1.toString());
        System.out.println();

        // On affiche la distance entre P1 et P2
        System.out.println("Distance entre P1 et P2 : " + p1.distance(p2));
        System.out.println();

        // On replace P1 à [2, 2] et on fait une rotation de 3*PI/2
        p1.deplace(0, -1);
        p1.rotation(3 * Math.PI / 2);
        System.out.println("On tourne P1 d'un angle de 3*PI/2 par rapport à l'origine : "+p1.toString());
    }
}
