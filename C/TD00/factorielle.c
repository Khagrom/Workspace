/* Calcul de la factorielle d'un nombre entier */
/* Auteur : V. POIRIER le 18/09/2015 */
#include <stdio.h>
#include <ctype.h>

double factorielle_i(int n)
{
    int i;
    double f;
    f = 1;
    for (i = 2; i <= n; i++)
        f = f * i;
    return f;
}

double factorielle_r(int n)
{
    if (n < 2) return 1;
    else return (n * factorielle_r(n - 1));
}

int main()
{
    int n;
    int ok;
    char c;

    do
    {
        do
        {
            printf("Entrez un nombre entier positif ou nul inferieur ou egal a 170 : ");
            ok = scanf("%d", &n);
            while(getchar() != '\n');
        }
        while (!ok || n < 0 || n > 170);
        printf("Calcul de la factorielle de %d...\n",n);
        printf("Le resultat vaut : %.0f par methode iterative.\n",factorielle_i(n));
        printf("Le resultat vaut : %.0f par methode recursive.\n\n",factorielle_r(n));

        printf("Voulez-vous recommencer (o/n) ? ");
        scanf("%c",&c);
        while(getchar() != '\n');
        printf("\n");
    }
    while(tolower(c) != 'n');
    return 0;
}
