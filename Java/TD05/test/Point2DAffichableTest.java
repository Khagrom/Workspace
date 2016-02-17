
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Point2DAffichableTest {

    private Point2DAffichable pt;

    @Before
    public void setUp() throws Exception {
        pt = new Point2DAffichable();
        pt.setPosition(2, 3);
    }

    @After
    public void tearDown() {
        pt = null;
    }

    @Test
    public void testGetX() {
        assertEquals(2, pt.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(3, pt.getY());
    }
}
