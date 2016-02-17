/* moyenne.c qui calcule par 3 méthodes
 * la moyenne de l'ensemble {1,2,3,...,n}
 * Auteur : V. POIRIER le 22/09/2015 */
#include <stdio.h>
#include <ctype.h>

/* moyenne1(int n) utilisant un while
 * Entrée : entier n
 * Pré-condition : n > 0
 * Résultat : la moyenne de la somme des entiers de 1 à n
 */
double moyenne1(int n)
{
    double s = 0;
    int i = 1;
    while(i <= n)
    {
        s += i;
        i++;
    }
    return s/n;
}

/* moyenne2(int n) utilisant un for
 * Entrée : entier n
 * Pré-condition : n > 0
 * Résultat : la moyenne de la somme des entiers de 1 à n
 */
double moyenne2(int n)
{
    double s = 0;
    int i;
    for(i = 1; i <= n; i++) s += i;
    return s/n;
}

/* moyenne3(int n) utilisant une formule
 * Entrée : entier n
 * Pré-condition : n > 0
 * Résultat : la moyenne de la somme des entiers de 1 à n
 */
double moyenne3(int n) { return (n+1)/2.0; }

int main()
{
    int n;  /* Entier borne de l'ensemble */
    int ok; /* Vérification de saisie */
    char c; /* Recommencer à la fin du programme */

    printf("Programme de calcul de la moyenne de l'ensemble {1,2,3,...,n}.\n\n");

    do
    {

        /* Saisie et vérification
         * de l'entier non nul n */
        do
        {
            printf("Entrer un entier n > 0 borne de l'ensemble : ");
            ok = scanf("%d",&n);
            while(getchar() != '\n');
        }
        while (!ok || n <= 0);

        printf("\nMethode 1 : la moyenne de {1,...,%d} est %.1f\n",n,moyenne1(n));
        printf("Methode 2 : la moyenne de {1,...,%d} est %.1f\n",n,moyenne2(n));
        printf("Methode 3 : la moyenne de {1,...,%d} est %.1f\n\n",n,moyenne3(n));


        /* Recommencer */
        printf("Voulez-vous recommencer (o/n) ? ");
        scanf("%c",&c);
        while(getchar() != '\n');
        printf("\n");
    }
    while(tolower(c) != 'n');
    return 0;
}
