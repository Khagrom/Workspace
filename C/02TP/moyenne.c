/* moyenne.c qui calcule par 3 m�thodes
 * la moyenne de l'ensemble {1,2,3,...,n}
 * Auteur : V. POIRIER le 22/09/2015 */
#include <stdio.h>
#include <ctype.h>

/* moyenne1(int n) utilisant un while
 * Entr�e : entier n
 * Pr�-condition : n > 0
 * R�sultat : la moyenne de la somme des entiers de 1 � n
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
 * Entr�e : entier n
 * Pr�-condition : n > 0
 * R�sultat : la moyenne de la somme des entiers de 1 � n
 */
double moyenne2(int n)
{
    double s = 0;
    int i;
    for(i = 1; i <= n; i++) s += i;
    return s/n;
}

/* moyenne3(int n) utilisant une formule
 * Entr�e : entier n
 * Pr�-condition : n > 0
 * R�sultat : la moyenne de la somme des entiers de 1 � n
 */
double moyenne3(int n) { return (n+1)/2.0; }

int main()
{
    int n;  /* Entier borne de l'ensemble */
    int ok; /* V�rification de saisie */
    char c; /* Recommencer � la fin du programme */

    printf("Programme de calcul de la moyenne de l'ensemble {1,2,3,...,n}.\n\n");

    do
    {

        /* Saisie et v�rification
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
