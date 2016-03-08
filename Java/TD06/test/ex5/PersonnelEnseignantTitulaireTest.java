package ex5;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class PersonnelEnseignantTitulaireTest {

    private static Personne personne;
    private static Personnel personnel;
    private static PersonnelEnseignant personnelEnseignant;
    private static PersonnelEnseignantTitulaire PersonnelEnseignantTitulaire;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        personne = new Personne("Poirier", "Vincent");
        personnel = new Personnel(personne, "Tuteur", 12, 9.6f);
        personnelEnseignant = new PersonnelEnseignant(personnel, "Java");
        PersonnelEnseignantTitulaire = new PersonnelEnseignantTitulaire(personnelEnseignant, 0);
    }

    @Test
    public void gettersTests() throws Exception {
        assertEquals("Nom", "Poirier", PersonnelEnseignantTitulaire.getNom());
        assertEquals("Prenom", "Vincent", PersonnelEnseignantTitulaire.getPrenom());
        assertEquals("Titre", "Tuteur", PersonnelEnseignantTitulaire.getTitre());
        assertEquals("No. bureau", 12, PersonnelEnseignantTitulaire.getNoBureau());
        assertEquals("Paye", 9.6f, PersonnelEnseignantTitulaire.getPaye(), Math.pow(10, -3));
        assertEquals("Discipline", "Java", PersonnelEnseignantTitulaire.getDiscipline());
        assertEquals("Echelon", 0, PersonnelEnseignantTitulaire.getEchelon());
    }

}