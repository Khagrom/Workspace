#ifndef CAMIONETTE_H_INCLUDED
#define CAMIONETTE_H_INCLUDED
#include "camion.h"
#include "voiture.h"

class camionette : public camion, public voiture
{
private :
    int volume;
public :
    camionette();
    camionette(int UnVolume, int UneHauteur, int UneLongueur, int UnTonnage, int DesPlaces, int DesPortes, char UneCouleur[], bool Location, char UnMatricule[], int UneAnnee, int UnKm, int UnePuissance);
    ~ camionette();
    void affichage();
    void saisir();
    int get_UnVolume();
    char* get_Type();
    void set_UnVolume(int UnVolume);
};

#endif // CAMIONETTE_H_INCLUDED
