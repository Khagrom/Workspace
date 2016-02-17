#include "vehicule.h"
#include "voiture.h"
#include "camion.h"
#include "camionette.h"
#include <stdio.h>
#include <string>
#include <iostream>
#include <windows.h>

using namespace std;

vehicule::vehicule()
{
    strcpy(matricule,"135QBE69");
    annee = 2016;
    km = 0;
    puissance = 7;
}

vehicule::vehicule(char UnMatricule[12], int UneAnnee, int UnKm, int UnePuissance)
{
    strcpy(matricule,UnMatricule);
    annee=UneAnnee;
    km=UnKm;
    puissance=UnePuissance;
}

vehicule::~vehicule()
{

}

void vehicule::affichage()
{
    cout<<"MATRICULE : "<<matricule<<endl;
    cout<<"ANNEE : "<<annee<<endl;
    cout<<"KM : "<<km<<endl;
    cout<<"PUISSANCE : "<<puissance<<endl;
}

void vehicule::saisir()
{
    cout<<"Saisissez un matricule : "<<endl;
    scanf("%s",matricule);
    while( getchar( ) != '\n' );
    set_UnMatricule(matricule);
    cout<<"Saisissez une annee : "<<endl;
    scanf("%d",&annee);
    while( getchar( ) != '\n' );
    set_UneAnnee(annee);
    cout<<"Saisisez un kilometrage : "<<endl;
    scanf("%d",&km);
    while( getchar( ) != '\n' );
    set_UnKm(km);
    cout<<"Saisissez une puissance : "<<endl;
    scanf("%d",&puissance);
    while( getchar( ) != '\n' );
    set_UnePuissance(puissance);
}

char* vehicule::get_UnMatricule()
{
    return matricule;
}

int vehicule::get_UneAnnee()
{
    return annee;
}

int vehicule::get_UnKm()
{
    return km;
}

int vehicule::get_UnePuissance()
{
    return puissance;
}

char* vehicule::get_Type()
{
    char *type;

    type=(char*)malloc((strlen("vehicule")+1)*sizeof(char));
    strcpy(type,"vehicule");

    return type;
}

void vehicule::set_UnMatricule(char UnMatricule[])
{
    strcpy(matricule,UnMatricule);
}

void vehicule::set_UneAnnee(int UneAnnee)
{
    annee = UneAnnee;
}

void vehicule::set_UnKm(int UnKm)
{
    km = UnKm;
}

void vehicule::set_UnePuissance(int UnePuissance)
{
    puissance = UnePuissance;
}
