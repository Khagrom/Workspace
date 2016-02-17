
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class ConvertTest {

    private final double delta = Math.pow(10, -6);

    @Test
    public void testBooleanToString() throws Exception {
        assertTrue("Boolean vers String", "true".equals(Convert.booleanToString(true)));
    }

    @Test
    public void testByteToString() throws Exception {
        assertTrue("Byte vers String", "3".equals(Convert.byteToString((byte) 3)));
    }

    @Test
    public void testShortToString() throws Exception {
        assertTrue("Short vers String", "120".equals(Convert.shortToString((short) 120)));
    }

    @Test
    public void testIntToString() throws Exception {
        assertTrue("Int vers String", "11456".equals(Convert.intToString(11456)));
    }

    @Test
    public void testLongToString() throws Exception {
        assertTrue("Long vers String", "123456789".equals(Convert.longToString((long) 123456789)));
    }

    @Test
    public void testFloatToString() throws Exception {
        assertTrue("Float vers String", "12.56".equals(Convert.floatToString((float) 12.56)));
    }

    @Test
    public void testDoubleToString() throws Exception {
        assertTrue("Double vers String", "11456.123456789".equals(Convert.doubleToString(11456.123456789)));
    }

    @Test
    public void testCharToString() throws Exception {
        assertTrue("Char vers String", "g".equals(Convert.charToString('g')));
    }

    @Test
    public void testStringToBoolean() throws Exception {
        assertTrue("String vers Boolean", Convert.stringToBoolean("true"));
    }

    @Test
    public void testStringToByte() throws Exception {
        assertEquals("String vers Byte", 3, Convert.stringToByte("3"));
    }

    @Test
    public void testStringToShort() throws Exception {
        assertEquals("String vers Short", 12, Convert.stringToShort("12"));
    }

    @Test
    public void testStringToInt() throws Exception {
        assertEquals("String vers Int", 1342, Convert.stringToInt("1342"));
    }

    @Test
    public void testStringToLong() throws Exception {
        assertEquals("String vers Long", 124561209, Convert.stringToLong("124561209"));
    }

    @Test
    public void testStringToFloat() throws Exception {
        assertEquals("String vers Float", 13.42, Convert.stringToFloat("13.42"), delta);
    }

    @Test
    public void testStringToDouble() throws Exception {
        assertEquals("String vers Double", 12456.1209, Convert.stringToDouble("12456.1209"), delta);
    }

    @Test
    public void testStringToChar() throws Exception {
        assertTrue("String vers char", 'y' == Convert.stringToChar("y"));
    }

    @Test
    public void testStringCompareToBoolean() throws Exception {
        assertEquals("Comparaison String vers Boolean", 0, Convert.stringCompareToBoolean("true", true));
    }

    @Test
    public void testStringCompareToByte() throws Exception {
        assertTrue("Comparaison String vers Byte", Convert.stringCompareToByte("3", (byte) 8) < 0);
    }

    @Test
    public void testStringCompareToShort() throws Exception {
        assertTrue("Comparaison String vers Short", Convert.stringCompareToShort("12", (short) 8) > 0);
    }

    @Test
    public void testStringCompareToInt() throws Exception {
        assertTrue("Comparaison String vers Int", Convert.stringCompareToInt("145", 1234) < 0);
    }

    @Test
    public void testStringCompareToLong() throws Exception {
        assertEquals("Comparaison String vers Long", 0, Convert.stringCompareToLong("3456789", (long) 3456789));
    }

    @Test
    public void testStringCompareToFloat() throws Exception {
        assertTrue("Comparaison String vers Float", Convert.stringCompareToFloat("12.456", (float) 12.4569) < 0);
    }

    @Test
    public void testStringCompareToDouble() throws Exception {
        assertTrue("Comparaison String vers Double", Convert.stringCompareToDouble("34.5634", 34.5633) > 0);
        assertEquals("Comparaison String vers Double", 0, Convert.stringCompareToDouble("34.5634", 34.5634));
    }

    @Test
    public void testStringCompareToChar() throws Exception {
        assertTrue("Comparaison String vers Char", Convert.stringCompareToChar("a", 'b') < 0);
    }
}
