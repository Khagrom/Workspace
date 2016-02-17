
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Point3DTest {

    private Point3D pt;

    @Before
    public void setUp() throws Exception {
        pt = new Point3D();
        pt.setPosition(1, 2, 3);
    }

    @After
    public void tearDown() {
        pt = null;
    }

    @Test
    public void testGetX() {
        assertEquals(1, pt.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(2, pt.getY());
    }

    @Test
    public void testGetZ() {
        assertEquals(3, pt.getZ());
    }
}
