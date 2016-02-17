#include <iostream>
#include <stdio.h>
#include <windows.h>
#include "parc.h"
#include "vehicule.h"
#include "voiture.h"
#include "camion.h"
#include "camionette.h"

using namespace std;

void affmenu()
{
    cout<<"\n\t\t\tPARC DE VEHICULES\n"<<endl;
    cout<<"\t\t1...Afficher le parc"<<endl;
    cout<<"\t\t2...Creer un vehicule"<<endl;
    cout<<"\t\t3...Supprimer un vehicule"<<endl;
    cout<<"\t\t4...Louer une voiture"<<endl;
    cout<<"\t\t5...Rendre une voiture"<<endl;
    cout<<"\t\t6...Sortie\n"<<endl;
    cout<<"\t\t\tVotre choix : "<<endl;
}

int main()
{
    int choix,ok,choixVehi,num;
    parc parcVehicule;
    do
    {
        affmenu();
        scanf("%d",&choix);
        while(getchar()!='\n');
        if(choix==1)
        {
            system("cls");
            parcVehicule.affichage();
        }
        else if (choix==2)
        {
            do
            {
                system("cls");
                cout<<"Quel vehicule voulez-vous ajouter ?"<<endl;
                cout<<"\n\t\t1...Un vehicule simple"<<endl;
                cout<<"\t\t2...Une voiture"<<endl;
                cout<<"\t\t3...Un camion"<<endl;;
                cout<<"\t\t4...Une camionette"<<endl;;
                cout<<"\t\t5...Sortie\n"<<endl;;
                cout<<"\t\t\tVotre choix : "<<endl;;
                ok=scanf("%d",&choixVehi);
                while(getchar()!='\n');
                switch(choixVehi)
                {
                case 1 :
                {
                    vehicule *vehi3 = new vehicule;
                    vehi3->saisir();
                    parcVehicule.ajouter(vehi3);
                    parcVehicule.affichage();
                    break;
                }
                case 2 :
                {
                    voiture *voit3 = new voiture;
                    (*voit3).saisir();
                    parcVehicule.ajouter(voit3);
                    parcVehicule.affichage();
                    break;
                }
                case 3 :
                {
                    camion *cami3 = new camion;
                    (*cami3).saisir();
                    parcVehicule.ajouter(cami3);
                    parcVehicule.affichage();
                    break;
                }
                case 4 :
                {
                    camionette *nette3 = new camionette;
                    (*nette3).saisir();
                    parcVehicule.ajouter(nette3);
                    parcVehicule.affichage();
                    break;
                }
                case 5 :
                    system("cls");
                    break;

                default :
                    system("cls");
                }
            }
            while (choixVehi!=5);


        }
        else if(choix==3)
        {
            system("cls");
            cout<<"Entrer le numero de la place du vehicule a supprimer"<<endl;
            scanf("%d",&num);
            while(getchar()!='\n');
            parcVehicule.casser(num);
            parcVehicule.affichage();
        }

        else if(choix==4)
        {
            system("cls");
            cout<<"Entrer le numero de la place du vehicule a louer"<<endl;
            scanf("%d",&num);
            while(getchar()!='\n');
            parcVehicule.louer(num);
            parcVehicule.affichage();

        }
        else if (choix==5)
        {
            system("cls");
            cout<<"Entrer le numero de la place du vehicule a rendre"<<endl;
            scanf("%d",&num);
            while(getchar()!='\n');
            parcVehicule.rendre(num);
            parcVehicule.affichage();
        }
        else if (choix != 6)
        {
            system("cls");
        }
    }
    while (choix!=6);
    return 0;
}
