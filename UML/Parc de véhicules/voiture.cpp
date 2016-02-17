#include "voiture.h"
#include <stdio.h>
#include <string>
#include <iostream>
#include <windows.h>

using namespace std;

voiture::voiture():vehicule()
{
    places=2;
    portes=3;
    strcpy(couleur,"Rouge");
    loue=false;
}

voiture::voiture(int DesPlaces, int DesPortes, char UneCouleur[], bool Location, char UnMatricule[], int UneAnnee, int UnKm, int UnePuissance):vehicule(UnMatricule, UneAnnee, UnKm, UnePuissance)
{
    places=DesPlaces;
    portes=DesPortes;
    strcpy(couleur,UneCouleur);
    loue=Location;
}

voiture::~voiture()
{

}

void voiture::affichage()
{
    vehicule::affichage();
    cout<<"PLACES : "<<places<<endl;
    cout<<"PORTES : "<<portes<<endl;
    cout<<"COULEUR : "<<couleur<<endl;
    if(loue) cout<<"VEHICULE LOUE"<<endl;
    else cout<<"VEHICULE LIBRE"<<endl;

}

void voiture::saisir()
{
    vehicule::saisir();
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
}
int voiture::get_DesPlaces()
{
    return places;
}

int voiture::get_DesPortes()
{
    return portes;
}

char* voiture::get_UneCouleur()
{
    return couleur;
}

bool voiture::get_Location()
{
    return loue;
}

char* voiture::get_Type()
{
    char *type;

    type=(char*)malloc((strlen("voiture")+1)*sizeof(char));
    strcpy(type,"voiture");

    return type;
}

void voiture::set_DesPortes(int DesPortes)
{
    portes = DesPortes;
}

void voiture::set_DesPlaces(int DesPlaces)
{
    places = DesPlaces;
}

void voiture::set_UneCouleur(char UneCouleur[])
{
    strcpy(couleur,UneCouleur);
}

void voiture::set_Location(bool Location)
{
    loue = Location;
}
