/* pgcd.c qui calcule le plus grand diviseur commun
 * de deux entiers strictement positifs, avec
 * une méthode itérative et une méthode récursive
 * Auteur : V. POIRIER le 22/09/2015 */
#include <stdio.h>
#include <ctype.h>

/* pgcdi(int a, int b) utilisant la méthode itérative
 * Entrée : deux entiers a et b
 * Pré-condition : a > 0 et b > 0
 * Résultat : le PGCD de a et b
 */
int pgcdi(int a, int b)
{
    int r;
    while(b != 0)
    {
        r = a%b;    /* Reste de la division entière de a par b */
        a = b;      /* b devient le nouveau a */
        b = r;      /* r devient le nouveau b */
    }
    return a;
}

/* pgcdr(int a, int b) utilisant la méthode récursive
 * Entrée : deux entiers a et b
 * Pré-condition : a > 0 et b > 0
 * Résultat : le PGCD de a et b
 */
int pgcdr(int a, int b)
{
    if(a%b == 0) return b;      /* Si la division entière a un reste */
    else return pgcdr(b,a%b);   /* on rappelle la fonction avec les nouvelles valeurs */
}

int main ()
{
    int a;  /* Premier entier */
    int b;  /* Second entier */
    int ok; /* Vérification de saisie */
    char c; /* Recommencer à la fin du programme */

    printf("Programme de calcul du PGCD de deux entiers strictement positifs,\n");
    printf("en utilisant une methode recursive et une methode iterative.\n\n");

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

        /* Appel des fonctions pgcdi et pgcdr */
        printf("\nMethode iterative : pgcdi(%d,%d) = %d\n",a,b,pgcdi(a,b));
        printf("Methode recursive : pgcdr(%d,%d) = %d\n\n",a,b,pgcdr(a,b));

        /* Recommencer */
        printf("Voulez-vous recommencer (o/n) ? ");
        scanf("%c",&c);
        while(getchar() != '\n');
        printf("\n");
    }
    while(tolower(c) != 'n');
    return 0;
}
