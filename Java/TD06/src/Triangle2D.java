
/**
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Triangle2D implements FormeGeometrique2D, Cloneable {

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

    @Override
    public String toString() {
        return "Triangle formé par les points "
                + s1.getP1().toString() + ", "
                + s2.getP1().toString() + " et "
                + s3.getP1().toString() + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final Triangle2D other = (Triangle2D) obj;
        if (!s1.equals(other.s1)) {
            return false;
        }

        if (!s2.equals(other.s2)) {
            return false;
        }

        return s3.equals(other.s3);
    }

    @Override
    public void deplace(double dx, double dy) {
        Segment2D[] tab = {s1, s2, s3};
        for (Segment2D s : tab) {
            s.deplace(dx, dy);
        }
    }

    @Override
    public boolean estIdentique(Object o) {
        return equals(o);
    }

    @Override
    public void affiche() {
        System.out.println(this);
    }

    @Override
    public Triangle2D clone() throws CloneNotSupportedException {
        return new Triangle2D(s1.getP1(), s2.getP1(), s3.getP1());
    }
}
