package ex5;

/**
 * @author Vincent Poirier
 * @author Fanny Rottee
 */
public final class PersonnelEnseignantTitulaire extends PersonnelEnseignant {

    private int echelon;

    public PersonnelEnseignantTitulaire(String nom, String prenom, String titre, long noBureau, double paye, String discipline, int echelon) {
        super(nom, prenom, titre, noBureau, paye, discipline);
        this.echelon = echelon;
    }

    public PersonnelEnseignantTitulaire(Personne p, String titre, long noBureau, double paye, String discipline, int echelon) {
        super(p, titre, noBureau, paye, discipline);
        this.echelon = echelon;
    }

    public PersonnelEnseignantTitulaire(Personnel p, String discipline, int echelon) {
        super(p, discipline);
        this.echelon = echelon;
    }

    public PersonnelEnseignantTitulaire(PersonnelEnseignant pe, int echelon) {
        super(pe);
        this.echelon = echelon;
    }
    
    public PersonnelEnseignantTitulaire(PersonnelEnseignantTitulaire pet) {
        this(pet.getNom(), pet.getPrenom(), pet.getTitre(), pet.getNoBureau(), pet.getPaye(), pet.getDiscipline(), pet.getEchelon());
    }

    public int getEchelon() {
        return echelon;
    }

    public void setEchelon(int echelon) {
        this.echelon = echelon;
    }
}
