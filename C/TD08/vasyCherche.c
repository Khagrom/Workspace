#include <stdio.h>
#include <stdlib.h>
#include <time.h>
char tryAgain();
double recherche(double n);
#define VALMAX 1000000

int main()
{
    srand(time(NULL));
    double n, ok;
    char again = 'n';

    do
    {
        system("cls");

        do
        {
            printf("Saississez un nombre a rechercher : ");
            ok = scanf("%lg",&n);
            while(getchar() != '\n');
        }
        while (!ok || n <= 0 || n > VALMAX);

        printf("Recherche... Nombre d'iterations avant de trouver : %lg\n",recherche(n));

        again = tryAgain();
    }
    while (again == 'o');

    return 0;
}

double recherche(double n)
{
    double i = 0;
    double calcul;
    do {
        calcul = 1 + (rand() % VALMAX);
        i++;
    }
    while (calcul != n);
    return i;
}

char tryAgain()
{
    int ok = 0;
    char n = 0;
    do
    {
        printf("\nVoulez-vous recommencer (o/n) ? ");
        ok = scanf("%c", &n);
        while(getchar() != '\n');
        n = (char) tolower(n);
    }
    while (!ok || (n != 'o' && n != 'n'));

    return n;
}
