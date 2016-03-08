package ex5;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public class PersonnelEnseignant extends Personnel {

    private String discipline;

    public PersonnelEnseignant(String nom, String prenom, String titre, long noBureau, double paye, String discipline) {
        super(nom, prenom, titre, noBureau, paye);
        this.discipline = discipline;
    }

    public PersonnelEnseignant(Personne p, String titre, long noBureau, double paye, String discipline) {
        super(p, titre, noBureau, paye);
        this.discipline = discipline;
    }

    public PersonnelEnseignant(Personnel p, String discipline) {
        super(p);
        this.discipline = discipline;
    }

    public PersonnelEnseignant(PersonnelEnseignant pe) {
        this(pe.getNom(), pe.getPrenom(), pe.getTitre(), pe.getNoBureau(), pe.getPaye(), pe.getDiscipline());
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
