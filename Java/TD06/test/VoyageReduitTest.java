
import voyage.*;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class VoyageReduitTest {

    private static Voyage[] tab;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        tab = new Voyage[4];
        tab[0] = new Voyage("Lyon", "Dijon", 196, 0.306);
        tab[1] = new Voyage("Lyon", "Paris", 466, 0.285);
        tab[2] = new VoyageReduit("Lyon", "Dijon", 196, 0.306, 0.605);
        tab[3] = new VoyageReduit("Lyon", "Dijon", 196, 0.306, 0.605);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        tab = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMauvaisTrajet() throws Exception {
        tab[0].comparerPrix(tab[1]);
    }

    @Test
    public void testMoinsCher() throws Exception {
        assertEquals(1, tab[0].comparerPrix(tab[2]));
    }

    @Test
    public void testMemePrix() throws Exception {
        assertEquals(0, tab[2].comparerPrix(tab[3]));
    }

    @Test
    public void testEgalite() throws Exception {
        assertTrue(tab[2].equals(tab[3]));
    }
}
