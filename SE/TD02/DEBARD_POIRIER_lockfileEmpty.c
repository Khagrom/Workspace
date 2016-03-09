// lockfileEmpty.c
// Auteurs : Jean DEBARD et Vincent POIRIER

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>
#include<unistd.h>
#include<errno.h>
#include<sys/stat.h>
#include<sys/types.h>

#define BUFF_SIZE 30
#define VARIANT_LOCK 1 // 0 : pas de verrouillage, 1 : verrouillage bloquant, 2 : tentative de verrouillage (non bloquant)

typedef struct contact
{
    char name[BUFF_SIZE];
    char firstName[BUFF_SIZE];
    int id;
} contact;

contact litUneEntree(int fd);
void scanContact(contact* unContact);
void affichage(char* fileName);
void ajout(char* fileName);
void affichageEntree(char* fileName);
void modificationEntree(char* fileName);
int verrouillage(int fd, int offset, int variant);
void deverrouillage(int fd, int offset);

// procedure qui affiche l'usage de la commande sur la sortie standard pour les erreurs et qui quitte le programme avec un statut non nul
void usage(char* chaine)
{
    fprintf(stderr,"Usage: %s nom_fichier\n",chaine);
    exit(1);
}

int main(int argn, char** argv)
{
    int choix;

    if(argn<2)
        usage(argv[0]);

    do
    {
        printf("\n0) Quitter\n1) Affichage de l'ensemble des personnes\n2) Affichage d'une personne\n"
               "3) Ajout d'une personne\n4) Modification d'une personne\n");
        printf("Choix : ");
        scanf("%d", &choix);

        printf("\n");

        switch(choix)
        {
        case 0:
            printf("Fin du programme.\n");
            break;
        case 1:
            affichage(argv[1]);
            break;
        case 2:
            affichageEntree(argv[1]);
            break;
        case 3:
            ajout(argv[1]);
            break;
        case 4:
            modificationEntree(argv[1]);
            break;

        default:
            fprintf(stderr,"Choix incorrect !\n");
        }
    }
    while(choix != 0);

    return 0;
} // fin du main

// lit une entree struct contact dans le fichier pointe par le descripteur fd
contact litUneEntree(int fd)
{
    contact personne;
    int nb_car_lu = read(fd, &personne, sizeof(contact));
    if (nb_car_lu == 0)
    {
        personne.id = -1;
    }
    else
    {
        if (nb_car_lu != sizeof(contact))
        {
            perror("Erreur de lecture du fichier");
            exit(1);
        }
    }

    return personne;
}

// met a jour un contact saisit au clavier
void scanContact(contact* personne)
{
    do
    {
        printf("Identifiant : ");
        scanf("%d",&personne->id);
    }
    while(personne->id<1);
    printf("Nom de famille (%d caracteres au maximum) : ", BUFF_SIZE);
    scanf("%s",personne->name);
    printf("Prenom (%d caracteres au maximum) : ", BUFF_SIZE);
    scanf("%s",personne->firstName);
}

// affiche la totalite du fichier
void affichage(char* filename)
{
    int fd = open(filename, O_CREAT | O_RDONLY, 00644);
    int i = 1;
    contact personne = litUneEntree(fd);
    while (personne.id != -1)
    {
        printf("Personne n° %d\n", i);
        printf("\tIdentifiant : %d\n", personne.id);
        printf("\tNom de famille : %s\n", personne.name);
        printf("\tPrenom : %s\n", personne.firstName);
        personne = litUneEntree(fd);
        i++;
    }

    if (i == 1)
    {
        printf("Il n'y a personne ici !\n");
    }

    close(fd);
}

// demande a l'utilisateur le numero de l'entree (ieme entree dans le fichier) a afficher puis l'affiche
void affichageEntree(char* filename)
{
    contact personne;
    int fd = open(filename, O_CREAT | O_RDONLY, 00644);
    int no = -1;
    int i = 0;

    printf("Quel numero de personne ?\n> ");
    scanf("%d", &no);

    for (i = 0; i < no && personne.id != -1; i++)
    {
        personne = litUneEntree(fd);
    }

    if (personne.id != -1)
    {
        printf("Personne n° %d\n", no);
        printf("\tIdentifiant : %d\n", personne.id);
        printf("\tNom de famille : %s\n", personne.name);
        printf("\tPrenom : %s\n", personne.firstName);
    }
    else
    {
        printf("Il n'y a personne ici !\n");
    }

    close(fd);
}

// ajoute une entree en fin de fichier
void ajout(char* filename)
{
    contact personne;
    int nb_car_ecrit = 0;
    int fd = open(filename, O_CREAT | O_RDWR | O_APPEND, 00644);
    if (fd > 0)
    {
        if(verrouillage(fd, sizeof(contact), VARIANT_LOCK) != 1) {
			scanContact(&personne);

			nb_car_ecrit = write(fd, &personne, sizeof(contact));

			if (nb_car_ecrit != sizeof(contact))
				perror("Erreur lors de l'ajout d'une personne.");
		}
		
		deverrouillage(fd, sizeof(contact));
        close(fd);
    }
}

// modifie une entree donnee
void modificationEntree(char* filename)
{
    contact personne;
    int fd = open(filename, O_CREAT | O_RDWR, 00644);
    int no = -1;
    int i = 0;

    printf("Quel numero de personne ?\n> ");
    scanf("%d", &no);

    for (i = 0; i < no - 1; i++)
    {
        personne = litUneEntree(fd);
    }

    if (personne.id != -1)
    {
        if(verrouillage(fd, sizeof(contact), VARIANT_LOCK) != 1) {
			scanContact(&personne);
			write(fd, &personne, sizeof(contact));
		}
		deverrouillage(fd, sizeof(contact));
    }
    else
    {
        printf("Il n'y a personne ici !");
    }

    close(fd);
}

// variante 0: pas de lock
// variante 1: lock bloquant
// variante 2: lock non-bloquant
int verrouillage(int fd, int offset, int variante) {
    switch (variante) {
		// Le verrouillage fonctionne-t-il pour des accès en lecture ? 
		// Il existe des verrous exclusifs qui permettent le verrou
		// à la fois en écriture et aussi en lecture.
		//
        // Quelle est la différence entre F_TLOCK et F_TEST ?
        // F_TEST vérifie si la section a un verrou ou non.
        // Elle renvoie 0 s'il n'y a pas de verrou, une autre valeur sinon.
        // F_TLOCK teste et pose le verrou si cela est possible.
        // On préfère utiliser F_TLOCK plutôt que F_TEST puis F_LOCK
        // pour éviter le cas où le verrou soit appliqué par un autre
        // processus entre les commandes F_TEST et F_LOCK.
        case 1:
            if (lockf(fd, F_TEST, offset) == 0)
                lockf(fd, F_TLOCK, offset);
            else {
               printf("\nFichier utilise par un autre processus !\n");
               printf("Retour au menu principal.\n");
			   return(1);
            }
            break;
        case 2:
            if (lockf(fd, F_TEST, offset) == 0)
                lockf(fd, F_TLOCK, offset);
            else {
               printf("\nFichier utilise par un autre processus !\n");
               printf("Retour a vos modifications.\n\n");
               return(0);
            }
            break;
    }
    return(0);
}

// deverouille -> Attention a l'offset: un offset invalide peut creer des petits bouts de fichier verrouille.
void deverrouillage(int fd, int offset) {
    lockf(fd, F_ULOCK, -offset);
}
