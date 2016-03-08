package ex5;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import static org.junit.Assert.*;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class PersonnelEnseignantVacataireTest {
    private static Personne personne;
    private static Personnel personnel;
    private static PersonnelEnseignant personnelEnseignant;
    private static PersonnelEnseignantVacataire  personnelEnseignantVacataire;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        personne = new Personne("Poirier", "Vincent");
        personnel = new Personnel(personne, "Tuteur", 12, 9.6f);
        personnelEnseignant = new PersonnelEnseignant(personnel, "Java");
        personnelEnseignantVacataire = new PersonnelEnseignantVacataire(personnelEnseignant, new Date("05/01/2016"), new Date("15/06/2016"));
    }

    @Test
    public void gettersTests() throws Exception {
        assertEquals("Nom", "Poirier", personnelEnseignantVacataire.getNom());
        assertEquals("Prenom", "Vincent", personnelEnseignantVacataire.getPrenom());
        assertEquals("Titre", "Tuteur", personnelEnseignantVacataire.getTitre());
        assertEquals("No. bureau", 12, personnelEnseignantVacataire.getNoBureau());
        assertEquals("Paye", 9.6f, personnelEnseignantVacataire.getPaye(), Math.pow(10, -3));
        assertEquals("Discipline", "Java", personnelEnseignantVacataire.getDiscipline());
        assertEquals("Début", new Date("05/01/2016"), personnelEnseignantVacataire.getDebutContrat());
        assertEquals("Fin", new Date("15/06/2016"), personnelEnseignantVacataire.getFinContrat());
    }

}