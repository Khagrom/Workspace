
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class UtilStringTest {

    @Test
    public void testNbOccurences() throws Exception {
        assertEquals(2, UtilString.nbOccurences("abaabb", "ab"));
    }
}
