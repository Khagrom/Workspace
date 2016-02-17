
/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class Convert {

    // Conversion d'un objet de type primitif en type String
    public static String booleanToString(boolean in) {
        return Boolean.toString(in);
    }

    public static String byteToString(byte in) {
        return Byte.toString(in);
    }

    public static String shortToString(short in) {
        return Short.toString(in);
    }

    public static String intToString(int in) {
        return Integer.toString(in);
    }

    public static String longToString(long in) {
        return Long.toString(in);
    }

    public static String floatToString(float in) {
        return Float.toString(in);
    }

    public static String doubleToString(double in) {
        return Double.toString(in);
    }

    public static String charToString(char in) {
        return Character.toString(in);
    }

    // Conversion d'un objet de type String en un type primitif
    public static boolean stringToBoolean(String in) {
        return Boolean.parseBoolean(in);
    }

    public static byte stringToByte(String in) {
        return Byte.parseByte(in);
    }

    public static short stringToShort(String in) {
        return Short.parseShort(in);
    }

    public static int stringToInt(String in) {
        return Integer.parseInt(in);
    }

    public static long stringToLong(String in) {
        return Long.parseLong(in);
    }

    public static float stringToFloat(String in) {
        return Float.parseFloat(in);
    }

    public static double stringToDouble(String in) {
        return Double.parseDouble(in);
    }

    public static char stringToChar(String in) {
        return in.charAt(0);
    }

    // Comparaison d'une valeur d'un type primitif et d'un objet de type String
    public static int stringCompareToBoolean(String comparande1, boolean comparande2) {
        return Boolean.compare(stringToBoolean(comparande1), comparande2);
    }

    public static int stringCompareToByte(String comparande1, byte comparande2) {
        return Byte.compare(stringToByte(comparande1), comparande2);
    }

    public static int stringCompareToShort(String comparande1, short comparande2) {
        return Short.compare(stringToShort(comparande1), comparande2);
    }

    public static int stringCompareToInt(String comparande1, int comparande2) {
        return Integer.compare(stringToInt(comparande1), comparande2);
    }

    public static int stringCompareToLong(String comparande1, long comparande2) {
        return Long.compare(stringToLong(comparande1), comparande2);
    }

    public static int stringCompareToFloat(String comparande1, float comparande2) {
        return Float.compare(stringToFloat(comparande1), comparande2);
    }

    public static int stringCompareToDouble(String comparande1, double comparande2) {
        return Double.compare(stringToDouble(comparande1), comparande2);
    }

    public static int stringCompareToChar(String comparande1, char comparande2) {
        return Character.compare(stringToChar(comparande1), comparande2);
    }
}
