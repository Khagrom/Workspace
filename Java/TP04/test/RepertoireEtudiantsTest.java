
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class RepertoireEtudiantsTest {

    private static Etudiant e2;
    private static Etudiant e3;
    private static RepertoireEtudiants r;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Etudiant e1 = new Etudiant("Rottee", "Fanny");
        e2 = new Etudiant("Poirier", "Vincent");
        e3 = new Etudiant("Quiniou", "Guillaume");
        r = new RepertoireEtudiants(10);
        r.ajouteEtudiant(e1);
        r.ajouteEtudiant(e2);
    }

    @Test
    public void testAjouteEtudiant() throws Exception {
        assertTrue(r.ajouteEtudiant(e3));
        assertTrue(r.supprimeEtudiant(e3));
    }

    @Test
    public void testGetNom() throws Exception {
        assertEquals("Rottee", r.getNom(1));
    }

    @Test
    public void testGetNumero() throws Exception {
        assertTrue(r.getNumero("rottee") > 0);
    }

    @Test
    public void testSupprimeEtudiant() throws Exception {
        assertTrue(r.supprimeEtudiant(e2));
    }
}
