/******          sapin.c         ******/
/* AUTEUR : M.RAMBURRUN le 15/12/2015 */
#include <stdio.h>
#define NBR_IMPAIR_MIN 11
#define NBR_IMPAIR_MAX 79

int main()
{
    int nbrImpair; /* nombre impair lu */
    int nbrLignes; /* nombre de lignes à affichir pour le sapin */
    int i; /* indice pour les lignes du sapin */
    int j; /* indice pour l'affichage des caractères par ligne */
    int ok; /* pour la validation de saisie */

    do
    {
     printf("Entrer un nombre impair de %d a %d : ",NBR_IMPAIR_MIN,NBR_IMPAIR_MAX);
     ok = scanf("%d",&nbrImpair);
     while ( getchar() != '\n' );
    }while( !ok || (nbrImpair % 2 != 1) || nbrImpair < NBR_IMPAIR_MIN ||
            nbrImpair > NBR_IMPAIR_MAX );

    nbrLignes = nbrImpair / 2 + 1;
    printf("Voici le sapin :\n");
    for( i = 1; i <= nbrLignes; i++ )
    {
     for( j = 1; j <= nbrLignes - i; j++ ) printf(" ");
     for( j = 1; j <= 2 * i - 1; j++ )     printf("*");
     printf("\n");
    }
    for( i = 1; i <= nbrLignes /2; i++ )
    {
     for( j = 1; j <= nbrLignes-1; j++ )
     {
       printf(" ");
     }
     printf("*\n");
    }
    return 0;
}
