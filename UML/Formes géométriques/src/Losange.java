
import interfaces.ILosange;

/**
 *
 * @author Diane Lakestani
 * @author Vincent Poirier
 */
public class Losange extends Parallelogramme implements ILosange {

    /**
     * Construit un losange sur la base de trois points. Les trois points
     * doivent pouvoir former un losange, peu importe à quel point se situe
     * l'angle.
     *
     * @param p1 Le premier point.
     * @param p2 Le second point.
     * @param p3 Le dernier point.
     * @throws IllegalArgumentException Lorsque les points ne peuvent pas former
     * un losange.
     */
    public Losange(Point p1, Point p2, Point p3) throws IllegalArgumentException {
        super(p1, p2, p3);
        Point p4;

        // Création des milieux
        Point milieuS1 = new Point(((p1.getX() + p2.getX()) * 0.5f), ((p1.getY() + p2.getY()) * 0.5f));
        Point milieuS2 = new Point(((p2.getX() + p3.getX()) * 0.5f), ((p2.getY() + p3.getY()) * 0.5f));
        Point milieuS3 = new Point(((p3.getX() + p1.getX()) * 0.5f), ((p3.getY() + p1.getY()) * 0.5f));

        // On calcule le dernier point. Pour ça il faut vérifier que les points forment bien un angle droit
        // et découvrir quel est le point sur lequel se situe l'angle.
        if (scalaire(milieuS1, p2, p3) == 0) {
            // L'angle droit est sur le milieu de S1
            p4 = new Point(2 * milieuS1.getX() - p3.getX(), 2 * milieuS1.getY() - p3.getY());
            s1 = new Segment(p1, p3);
            s2 = new Segment(p3, p2);
            s3 = new Segment(p2, p4);
            s4 = new Segment(p4, p1);
        } else if (scalaire(milieuS2, p3, p1) == 0) {
            // L'angle droit est sur le milieu de S2
            p4 = new Point(2 * milieuS2.getX() - p1.getX(), 2 * milieuS2.getY() - p1.getY());
            s1 = new Segment(p1, p2);
            s2 = new Segment(p2, p4);
            s3 = new Segment(p4, p3);
            s4 = new Segment(p3, p1);
        } else if (scalaire(milieuS3, p1, p2) == 0) {
            // L'angle droit est sur le milieu de S3
            p4 = new Point(2 * milieuS3.getX() - p2.getX(), 2 * milieuS3.getY() - p2.getY());
            s1 = new Segment(p1, p2);
            s2 = new Segment(p2, p3);
            s3 = new Segment(p3, p4);
            s4 = new Segment(p4, p1);
        } else {
            //Pas d'angle droit
            throw new IllegalArgumentException("Impossible de former un losange à partir de ces points.");
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
        return 0.5f * s1.getP1().distance(s3.getP1()) * s2.getP1().distance(s4.getP1());
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
        return "Losange formé par les points " + s1.getP1().affiche() + ", " + s2.getP1().affiche() + ", " + s3.getP1().affiche() + " et " + s4.getP1().affiche();
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
