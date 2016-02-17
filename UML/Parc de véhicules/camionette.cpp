#include "camionette.h"
#include <stdio.h>
#include <string>
#include <iostream>
#include <windows.h>

using namespace std;

camionette::camionette():camion(),voiture()
{
    volume = 4;
}

camionette::camionette(int UnVolume, int UneHauteur, int UneLongueur, int UnTonnage, int DesPlaces, int DesPortes, char UneCouleur[], bool Location, char UnMatricule[], int UneAnnee, int UnKm, int UnePuissance):camion(UneHauteur, UneLongueur, UnTonnage, UnMatricule, UneAnnee, UnKm, UnePuissance), voiture(DesPlaces, DesPortes, UneCouleur, Location, UnMatricule, UneAnnee, UnKm, UnePuissance)
{
    volume = UnVolume;
}

camionette::~camionette()
{

}

void camionette::affichage()
{
    camion::affichage();
    cout<<"PLACES : "<<places<<endl;
    cout<<"PORTES : "<<portes<<endl;
    cout<<"COULEUR : "<<couleur<<endl;
    cout<<"VOLUME : "<<volume<<endl;
    if(loue) cout<<"VEHICULE LOUE"<<endl;
    else cout<<"VEHICULE LIBRE"<<endl;

}

void camionette::saisir()
{
    camion::saisir();
    cout<<"Saisissez le nombre de places : "<<endl;
    scanf("%d",&places);
    while( getchar( ) != '\n' );
    set_DesPlaces(places);
    cout<<"Saisissez le nombre de portes : "<<endl;
    scanf("%d",&portes);
    while( getchar( ) != '\n' );
    set_DesPortes(portes);
    cout<<"Saisisez une couleur : "<<endl;
    scanf("%s",couleur);
    while( getchar( ) != '\n' );
    set_UneCouleur(couleur);
    set_Location(false);
    cout<<"Saisissez le volume : "<<endl;
    scanf("%d",&volume);
    while( getchar( ) != '\n' );
    set_UnVolume(volume);
}
int camionette::get_UnVolume()
{
    return volume;
}

char* camionette::get_Type()
{
    char *type;

    type=(char*)malloc((strlen("camionette")+1)*sizeof(char));
    strcpy(type,"camionette");

    return type;
}

void camionette::set_UnVolume(int UnVolume)
{
    volume=UnVolume;
}
