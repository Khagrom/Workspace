#ifndef PARC_H_INCLUDED
#define PARC_H_INCLUDED
#include "vehicule.h"
#include "voiture.h"
#include "camion.h"
#include "camionette.h"

class parc
{
protected :
    int nbPlaces;
    vehicule **parcVehicule;
public :
    parc();
    parc(int uneTaille);
    ~ parc();
    void affichage();
    void casser(int num);
    void ajouter(vehicule* v);
    void louer(int num);
    void rendre(int num);
    int get_UnNbPlaces();
    int get_PlacesDisponibles();
};

#endif // PARC_H_INCLUDED
