
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class TestPoints {

    public static void main(String[] args) {
        
        Point2DAffichable a = new Point2DAffichable();
        a.setPosition(2, 3);
        
        Point3DAffichable b = new Point3DAffichable();
        b.setPosition(1, 2, 3);

        a.affiche();
        b.affiche();
    }
}
