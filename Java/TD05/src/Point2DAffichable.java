
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Point2DAffichable extends Point2D {

    public void affiche() {
        System.out.println(this.getClass().getSimpleName() + " {\n\tx: " + this.getX() + ",\n\ty: " + this.getY() + "\n}");
    }

}
