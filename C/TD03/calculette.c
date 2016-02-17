/* calculette.c qui permet de faire des
 * opérations de base sur deux entiers a et b
 * Auteur : V. POIRIER le 28/09/2015 */
#include <stdio.h>
#include <ctype.h>

/* calculette(int a, int b, char operation) qui gère le calcul
 * Entrée : deux réels a et b, et un caractère operation
 * Résultat : le résultat de l'opération
 */
double calculette(double a, double b, char operation)
{
    switch(operation)
    {
    case '+' :
        return a+b;
        break;
    case '-' :
        return a-b;
        break;
    case '*' :
        return a*b;
        break;
    case '/' :
        return a/b;
        break;
    /* A priori, on n'entre jamais dans la case default */
    default :
        printf("Erreur.\n" );
    }
}

int main ()
{
    double a,b;     /* Réels sur lesquels faire l'opération */
    char operation; /* Caractère opération */
    int ok;         /* Vérification de saisie */
    char c ;        /* Recommencer à la fin du programme */

    printf("Programme de calculatrice.\n\n");

    do
    {
        /* Saisie et vérification du caractère opération */
        do
        {
            printf("Entrer un operateur parmi ('+','-','*','/') : ");
            scanf("%c",&operation);
            while(getchar() != '\n');
        }
        while (operation != '+' && operation != '-' && operation != '/' && operation != '*');

        /* Saisie et vérification de l'entier a */
        do
        {
            printf("Entrer un reel a : ");
            ok = scanf("%lg",&a);
            while(getchar() != '\n');
        }
        while (!ok);

        /* Saisie et vérification de l'entier b
         * Attention, b doit être différent de 0 si on a choisi la division */
        do
        {
            printf("Entrer un reel b (non nul si division) : ");
            ok = scanf("%lg",&b);
            while(getchar() != '\n');
        }
        while (!ok || b == 0 && operation == '/');


        /* Appel de la calculatrice */
        printf("%lg %c %lg = %lg\n\n",a,operation,b,calculette(a,b,operation));

        /* Recommencer */
        printf("Voulez-vous recommencer (o/n) ? ");
        scanf("%c",&c);
        while(getchar() != '\n');
        printf("\n");
    }
    while(tolower(c) != 'n');
    return 0;
}
