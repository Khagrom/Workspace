
import interfaces.ITriangle;

/**
 *
 * @author Diane Lakestani
 * @author Vincent Poirier
 */
public class Triangle extends Forme implements ITriangle {

    private Segment s1;
    private Segment s2;
    private Segment s3;

    /**
     * Construit un triangle à partir de trois points.
     *
     * @param p1 Le premier point.
     * @param p2 Le second point.
     * @param p3 Le dernier point.
     */
    public Triangle(Point p1, Point p2, Point p3) {
        s1 = new Segment(p1, p2);
        s2 = new Segment(p2, p3);
        s3 = new Segment(p3, p1);
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
        float l3 = s3.longueur();
        float l = 0.5f * (l1 + l2 + l3);
        return (float) Math.sqrt(l * (l - l1) * (l - l2) * (l - l3));
    }

    /**
     * Calcule le périmètre de l'objet.
     *
     * @return Le périmètre de l'objet.
     */
    @Override
    public float calculPerimetre() {
        return s1.longueur() + s2.longueur() + s3.longueur();
    }

    @Override
    public String affiche() {
        return "Triangle formé par les points  " + s1.getP1().affiche() + ", " + s2.getP1().affiche() + " et " + s3.getP1().affiche();
    }

    /**
     * Effectue une rotation de 90 degrés dans le sens inverse des aiguilles
     * d'une montre par rapport à l'origine.
     */
    @Override
    public void rotation() {
        float xn1 = this.s1.getP1().getX() * (float) Math.cos(Math.PI * 0.5) - this.s1.getP1().getY() * (float) Math.sin(Math.PI * 0.5);
        float yn1 = this.s1.getP1().getX() * (float) Math.sin(Math.PI * 0.5) + this.s1.getP1().getY() * (float) Math.cos(Math.PI * 0.5);
        Point pn1 = new Point(xn1, yn1);

        float xn2 = this.s2.getP1().getX() * (float) Math.cos(Math.PI * 0.5) - this.s2.getP1().getY() * (float) Math.sin(Math.PI * 0.5);
        float yn2 = this.s2.getP1().getX() * (float) Math.sin(Math.PI * 0.5) + this.s2.getP1().getY() * (float) Math.cos(Math.PI * 0.5);
        Point pn2 = new Point(xn2, yn2);

        float xn3 = this.s3.getP1().getX() * (float) Math.cos(Math.PI * 0.5) - this.s3.getP1().getY() * (float) Math.sin(Math.PI * 0.5);
        float yn3 = this.s3.getP1().getX() * (float) Math.sin(Math.PI * 0.5) + this.s3.getP1().getY() * (float) Math.cos(Math.PI * 0.5);
        Point pn3 = new Point(xn3, yn3);

        s1 = new Segment(pn1, pn2);
        s2 = new Segment(pn2, pn3);
        s3 = new Segment(pn3, pn1);
    }

    /**
     * Effectue une rotation du point d'un angle donné par rapport à l'origine.
     *
     * @param angleEnRadians L'angle en radians sur lequel faire la rotation.
     */
    @Override
    public void rotation(float angleEnRadians) {
        float xn1 = this.s1.getP1().getX() * (float) Math.cos(angleEnRadians) - this.s1.getP1().getY() * (float) Math.sin(angleEnRadians);
        float yn1 = this.s1.getP1().getX() * (float) Math.sin(angleEnRadians) + this.s1.getP1().getY() * (float) Math.cos(angleEnRadians);
        Point pn1 = new Point(xn1, yn1);

        float xn2 = this.s2.getP1().getX() * (float) Math.cos(angleEnRadians) - this.s2.getP1().getY() * (float) Math.sin(angleEnRadians);
        float yn2 = this.s2.getP1().getX() * (float) Math.sin(angleEnRadians) + this.s2.getP1().getY() * (float) Math.cos(angleEnRadians);
        Point pn2 = new Point(xn2, yn2);

        float xn3 = this.s3.getP1().getX() * (float) Math.cos(angleEnRadians) - this.s3.getP1().getY() * (float) Math.sin(angleEnRadians);
        float yn3 = this.s3.getP1().getX() * (float) Math.sin(angleEnRadians) + this.s3.getP1().getY() * (float) Math.cos(angleEnRadians);
        Point pn3 = new Point(xn3, yn3);

        s1 = new Segment(pn1, pn2);
        s2 = new Segment(pn2, pn3);
        s3 = new Segment(pn3, pn1);
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
}
