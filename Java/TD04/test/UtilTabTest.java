
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class UtilTabTest {

    private final double[] doubleArray = {1.2, 5, 42.42, 24, 10};
    private final double[] emptyDouble = new double[0];
    private final float[][] floatArray = {{24, 10}, {1.2f, 5, 42.42f}, {26, 10}};
    private final float[][] emptyFloat = new float[0][0];

    private static final double DELTA_DOUBLE = Math.pow(10, -9);
    private static final double DELTA_FLOAT = Math.pow(10, -5);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() throws Exception {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() throws Exception {
        System.setOut(null);

    }

    @Test
    public void testSommeNormal() throws Exception {
        assertEquals("Calcul de la somme double", 82.62, UtilTab.somme(doubleArray), DELTA_DOUBLE);
        assertEquals("Calcul de la somme float", 118.62, UtilTab.somme(floatArray), DELTA_FLOAT);
    }

    @Test
    public void testSommeVide() throws Exception {
        assertEquals("Calcul de la somme vide double", 0, UtilTab.somme(emptyDouble), DELTA_DOUBLE);
        assertEquals("Calcul de la somme vide float", 0, UtilTab.somme(emptyFloat), DELTA_FLOAT);
    }

    @Test
    public void testMoyenne() throws Exception {
        assertEquals("Calcul de la moyenne double", 16.524, UtilTab.moyenne(doubleArray), DELTA_DOUBLE);
        assertEquals("Calcul de la moyenne float", 16.945714, UtilTab.moyenne(floatArray), DELTA_FLOAT);
    }

    @Test
    public void testMoyenneVide() throws Exception {
        assertEquals("Calcul de la moyenne double", 0, UtilTab.moyenne(emptyDouble), DELTA_DOUBLE);
        assertEquals("Calcul de la moyenne float", 0, UtilTab.moyenne(emptyFloat), DELTA_FLOAT);
    }

    @Test
    public void testMinMax() throws Exception {
        assertEquals("Obtention du min double", 1.2, UtilTab.min(doubleArray), DELTA_DOUBLE);
        assertEquals("Obtention du max double", 42.42, UtilTab.max(doubleArray), DELTA_DOUBLE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinVide() throws Exception {
        assertEquals("Obtention du min double", 0, UtilTab.min(emptyDouble), DELTA_DOUBLE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxVide() throws Exception {
        assertEquals("Obtention du max double", 0, UtilTab.max(emptyDouble), DELTA_DOUBLE);
    }

    @Test
    public void testCopie() throws Exception {
        double[] otherDouble = UtilTab.copie(doubleArray);
        float[][] otherFloat = UtilTab.copie(floatArray);

        assertArrayEquals("Copie du tableau double", doubleArray, otherDouble, DELTA_DOUBLE);
        assertArrayEquals("Copie du tableau float", floatArray, otherFloat);
    }

    @Test
    public void testSommeLigne() throws Exception {
        assertEquals("Calcul de la somme d'une ligne", 34, UtilTab.sommeLigne(floatArray, 0), DELTA_FLOAT);
    }

    @Test
    public void testSommeLigneVide() throws Exception {
        assertEquals("Calcul de la somme d'une ligne vide", 0, UtilTab.sommeLigne(emptyFloat, 0), DELTA_FLOAT);
    }

    @Test
    public void testSommeColonne() throws Exception {
        assertEquals("Calcul de la somme d'une colonne pleine", 51.2, UtilTab.sommeColonne(floatArray, 0), DELTA_FLOAT);
        assertEquals("Calcul de la somme d'une colonne partielle", 42.42, UtilTab.sommeColonne(floatArray, 2), DELTA_FLOAT);
    }

    @Test
    public void testSommeColonneVide() throws Exception {
        assertEquals("Calcul de la somme d'une colonne pleine", 0, UtilTab.sommeColonne(emptyFloat, 0), DELTA_FLOAT);
    }

    @Test
    public void testAlea() throws Exception {
        double[] alea = UtilTab.genereTabAlea(100);

        for (int i = 0; i < alea.length; i++) {
            assertTrue("Vérification borne haute de valeur " + i, alea[i] < 100);
            assertTrue("Vérification borne basse de valeur " + i, alea[i] >= 0);
        }
    }
}
