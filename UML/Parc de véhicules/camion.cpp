#include "camion.h"
#include <stdio.h>
#include <string>
#include <iostream>
#include <windows.h>

using namespace std;

camion::camion():vehicule()
{
    hauteur = 2;
    longueur = 4;
    tonnage = 5;
}

camion::camion(int UneHauteur, int UneLongueur, int UnTonnage, char UnMatricule[], int UneAnnee, int UnKm, int UnePuissance):vehicule(UnMatricule, UneAnnee, UnKm, UnePuissance)
{
    hauteur = UneHauteur;
    longueur = UneLongueur;
    tonnage = UnTonnage;
}

camion::~camion()
{

}

void camion::affichage()
{
    vehicule::affichage();
    cout<<"HAUTEUR : "<<hauteur<<endl;
    cout<<"LONGUEUR : "<<longueur<<endl;
    cout<<"TONNAGE : "<<tonnage<<endl;
}

void camion::saisir()
{
    vehicule::saisir();
    cout<<"Saisissez une hauteur : "<<endl;
    scanf("%d",&hauteur);
    while( getchar( ) != '\n' );
    set_UneHauteur(hauteur);
    cout<<"Saisissez une longueur : "<<endl;
    scanf("%d",&longueur);
    while( getchar( ) != '\n' );
    set_UneLongueur(longueur);
    cout<<"Saisisez un tonnage : "<<endl;
    scanf("%d",&tonnage);
    while( getchar( ) != '\n' );
    set_UnTonnage(tonnage);
}

int camion::get_UneHauteur()
{
    return hauteur;
}

int camion::get_UneLongueur()
{
    return longueur;
}

int camion::get_UnTonnage()
{
    return tonnage;
}

char* camion::get_Type()
{
    char *type;

    type=(char*)malloc((strlen("camion")+1)*sizeof(char));
    strcpy(type,"camion");

    return type;
}


void camion::set_UneHauteur(int UneHauteur)
{
    hauteur=UneHauteur;
}

void camion::set_UneLongueur(int UneLongueur)
{
    longueur=UneLongueur;
}

void camion::set_UnTonnage(int UnTonnage)
{
    tonnage=UnTonnage;
}
