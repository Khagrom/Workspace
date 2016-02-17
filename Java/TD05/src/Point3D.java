
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Point3D extends Point2D {

    private int z;

    public void setPosition(int x, int y, int z) {
        super.setPosition(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }
}
