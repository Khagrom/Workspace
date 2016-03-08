package ex5;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class EtudiantBoursierTest {

    private static Personne personne;
    private static Etudiant etudiant;
    private static EtudiantBoursier etudiantBoursier;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        personne = new Personne("Poirier", "Vincent");
        etudiant = new Etudiant(personne, 11513113);
        etudiantBoursier = new EtudiantBoursier(etudiant, 0);
    }

    @Test
    public void gettersTests() throws Exception {
        assertEquals("Nom", "Poirier", etudiantBoursier.getNom());
        assertEquals("Prenom", "Vincent", etudiantBoursier.getPrenom());
        assertEquals("No. etudiant", 11513113, etudiantBoursier.getNoEtu());
        assertEquals("Mt. bourse", 0, etudiantBoursier.getMontantBourse(), Math.pow(10, -3));
    }

}