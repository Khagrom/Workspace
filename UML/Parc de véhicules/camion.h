#ifndef CAMION_H_INCLUDED
#define CAMION_H_INCLUDED
#include "vehicule.h"

class camion : virtual public vehicule
{
protected :
    int hauteur;
    int longueur;
    int tonnage;
public :
    camion();
    camion(int UneHauteur, int UneLongueur, int UnTonnage, char UnMatricule[], int UneAnnee, int UnKm, int UnePuissance);
    ~ camion();
    void affichage();
    void saisir();
    int get_UneHauteur();
    int get_UneLongueur();
    int get_UnTonnage();
    char* get_Type();
    void set_UneHauteur(int UneHauteur);
    void set_UneLongueur(int UneLongueur);
    void set_UnTonnage(int UnTonnage);
};



#endif // CAMION_H_INCLUDED
