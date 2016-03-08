
import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Point2DTest {

    private final Point2D p1 = new Point2D(2, 3);
    private Point2D p2;
    private Point2D p3;
    private Object p4;

    @Before
    public void setUp() throws Exception {
        p2 = p1.clone();
        p3 = new Point2D(2, 3);
        p4 = p1.clone();
    }

    @After
    public void tearDown() throws Exception {
        p2 = null;
        p3 = null;
        p4 = null;
    }

    @Test
    public void testEgaliteClone() throws Exception {
        assertTrue("Egalité de clone.", p4.equals(p1));
    }

    @Test
    public void testDeplacement() throws Exception {
        p2.deplace(1, 1);
        assertTrue("Modification de p2", p2.getX() == 3 & p2.getY() == 4);
        assertTrue("Non-modification de p1", p1.getX() == 2 & p1.getY() == 3);
    }

    @Test
    public void testSymetrie() throws Exception {
        assertTrue("Symetrie sens direct", p4.equals(p1));
        assertTrue("Symétrie sens inverse", p1.equals(p4));
    }

    @Test
    public void testReflexivite() throws Exception {
        assertTrue("testReflexivite", p4.equals(p4));
    }

    @Test
    public void testNull() throws Exception {
        assertFalse(p4.equals(null));
    }

    @Test
    public void testTransitivite() throws Exception {
        assertTrue("1 vers 2", p1.equals(p2));
        assertTrue("2 vers 3", p2.equals(p3));
        assertTrue("1 vers 3", p1.equals(p3));
    }

}
