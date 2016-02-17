#ifndef VOITURE_H_INCLUDED
#define VOITURE_H_INCLUDED
#include "vehicule.h"


class voiture : virtual public vehicule
{
protected :
    int portes;
    int places;
    char couleur[20];
    bool loue;
public :
    voiture();
    voiture(int DesPlaces, int DesPortes, char UneCouleur[], bool Location, char UnMatricule[], int UneAnnee, int UnKm, int UnePuissance);
    ~ voiture();
    void affichage();
    void saisir();
    int get_DesPortes();
    int get_DesPlaces();
    char* get_UneCouleur();
    bool get_Location();
    char* get_Type();
    void set_DesPortes(int DesPortes);
    void set_DesPlaces(int DesPlaces);
    void set_UneCouleur(char UneCouleur[]);
    void set_Location(bool Location);
};

#endif // VOITURE_H_INCLUDED
