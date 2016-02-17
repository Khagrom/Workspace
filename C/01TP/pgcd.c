/* pgcd.c  qui calcule le plus grand diviseur commun
 * de deux entiers strictement positifs
 * Auteur : V. POIRIER le 21/09/2015 */
#include <stdio.h>
#include <ctype.h>

/* pgcd(a,b) par opérations successives
 * Entrée : entier a, entier b
 * Pré-condition : a > 0 et b > 0
 * Résultat : le PGCD de a et b
 */
int pgcd(int a, int b)
{
    int p;  /* Pour ranger le plus petit entre a et b */
    int d;  /* Pour ranger le plus grand entre a et b */
    int s;  /* Variable de travail */

    printf("Calcul du plus grand diviseur commun en cours...\n");

    /* Algorithme */
    if(a >= b)
    {
        d = a;
        p = b;
    }
    else
    {
        d = b;
        p = a;
    }
    s = d - p;
    while(s > 0)
    {
        if(s >= p)
        {
            d = s;
        }
        else
        {
            d = p;
            p = s;
        }
        s = d - p;
    }
    return p;
}

int main ()
{
    int a;  /* Premier entier */
    int b;  /* Second entier */
    int ok; /* Vérification de saisie */
    char c; /* Recommencer à la fin du programme */

    printf("Programme de calcul du PGCD de deux entiers strictement positifs.\n\n");

    do
    {

        /* Saisie et vérification
         * des deux entiers non nuls a et b */
        do
        {
            printf("Entrer un entier a > 0 : ");
            ok = scanf("%d",&a);
            while(getchar() != '\n');
        }
        while (!ok || a <= 0);
        do
        {
            printf("Entrer un entier b > 0 : ");
            ok = scanf("%d",&b);
            while(getchar() != '\n');
        }
        while (!ok || b <= 0);

        /* Appel de la fonction pgcd */
        printf("PGCD(%d,%d) = %d\n\n",a,b,pgcd(a,b));

        /* Recommencer */
        printf("Voulez-vous recommencer (o/n) ? ");
        scanf("%c",&c);
        while(getchar() != '\n');
        printf("\n");
    }
    while(tolower(c) != 'n');
    return 0;
}
