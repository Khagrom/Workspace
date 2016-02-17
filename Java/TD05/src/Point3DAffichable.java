
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Point3DAffichable extends Point3D {

    public void affiche() {
        System.out.println(this.getClass().getSimpleName() 
                + " {\n\tx: " + this.getX() 
                + ",\n\ty: " + this.getY() 
                + ",\n\tz: " + this.getZ()
                + "\n}\n");
    }

}
