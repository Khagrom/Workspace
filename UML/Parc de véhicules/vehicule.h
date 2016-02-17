#ifndef VEHICULE_H_INCLUDED
#define VEHICULE_H_INCLUDED

class vehicule
{
protected :
    char matricule[12];
    int annee;
    int km;
    int puissance;
public :
    vehicule();
    vehicule(char UnMatricule[12],int UneAnnee, int UnKm, int UnePuissance);
    ~ vehicule();
    virtual void affichage();
    virtual void saisir();
    char* get_UnMatricule();
    int get_UneAnnee();
    int get_UnKm();
    int get_UnePuissance();
    virtual char* get_Type();
    void set_UnMatricule(char UnMatricule[]);
    void set_UneAnnee(int UneAnnee);
    void set_UnKm(int UnKm);
    void set_UnePuissance(int UnePuissance);
};

#endif // VEHICULE_H_INCLUDED
