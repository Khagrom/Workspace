package ex5;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class PersonnelAdministratifTest {

    private static Personne personne;
    private static Personnel personnel;
    private static PersonnelAdministratif personnelAdministratif;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        personne = new Personne("Poirier", "Vincent");
        personnel = new Personnel(personne, "Tuteur", 12, 9.6f);
        personnelAdministratif = new PersonnelAdministratif(personnel);
    }

    @Test
    public void gettersTests() throws Exception {
        assertEquals("Nom", "Poirier", personnelAdministratif.getNom());
        assertEquals("Prenom", "Vincent", personnelAdministratif.getPrenom());
        assertEquals("Titre", "Tuteur", personnelAdministratif.getTitre());
        assertEquals("No. bureau", 12, personnelAdministratif.getNoBureau());
        assertEquals("Paye", 9.6f, personnelAdministratif.getPaye(), Math.pow(10, -3));
    }

}