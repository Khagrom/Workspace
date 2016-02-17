/* calculPolynome.c qui calcule
 * les racines d'un polynome du second degré
 * de la forme ax2+bx+c
 * Auteur : V. POIRIER le 09/10/2015 */
#include <stdio.h>
#include <math.h>
#include <ctype.h>

/* Déclaration des procédures et fonctions */
void racinesPolynome(double a, double b, double c, int* nbRacines, double* x1, double* x2);
void getNombre(double* a, char nom);
void viderBuffer();
char tryAgain();

/* Fonction principale */
int main(int argc, const char *argv[])
{
    double a, b, c, x1, x2;     /* Coefficients et racines */
    int nbRacines;              /* Le nombre de racines du polynome */
    char again = 'n';           /* Vérification pour recommencer */

    do
    {
        system("cls");
        printf("Entrez les coefficients a, b et c du polynome ax2+bx+c :\n");
        getNombre(&a, 'a');
        getNombre(&b, 'b');
        getNombre(&c, 'c');
        racinesPolynome(a, b, c, &nbRacines, &x1, &x2);

        switch (nbRacines)
        {
        case -1:
            printf("Le polynome est constant et n'a pas de racines.\n");
            break;
        case 0:
            printf("Le polynome n'a pas de racines dans l'espace des reels.\n");
            break;
        case 1:
            printf("Le polynome n'a qu'une racine (degre 1) : %lg\n", x1);
            break;
        default:
            if (x1 == x2) printf("Le polynome a une racine double : %lg\n", x1);
            else printf("Le polynome a deux racines : %lg et %lg\n", x1, x2);
        }
        again = tryAgain();
    }
    while (again == 'o');
    return 0;
}

/* Procédure de calcul des racines du polynôme */
void racinesPolynome(double a, double b, double c, int* nbRacines, double* x1, double* x2)
{
    /* Initialisation des pointeurs */
    *x1 = 0;
    *x2 = 0;
    *nbRacines = 0;

    /* On gère le cas du degré 1 */
    if (a == 0)
    {
        if (b == 0)
            *nbRacines = -1;
        else
        {
            *nbRacines = 1;
            if (c == 0)
            {
                *x1 = 0;
                *x2 = *x1;
            }
            else
            {
                *x1 = (-c) / b;
                *x2 = *x1;
            }
        }
    }

    /* Pour le degré 2, on se sert de delta = b^2 - 4ac */
    else
    {
        *nbRacines = 2;
        double delta = b*b - 4 * a * c;
        if (delta < 0)
            *nbRacines = 0;
        else if (delta == 0)
        {
            *x1 = (-b + sqrt(delta)) / (2 * a);
            *x2 = *x1;
        }
        else
        {
            *x1 = (-b + sqrt(delta)) / (2 * a);
            *x2 = (-b - sqrt(delta)) / (2 * a);
        }
    }
}

/* Procédure de saisie */
void getNombre(double* a, char nom)
{
    int ok = 0;
    double n = 0;
    do
    {
        printf("Saisissez %c : ", nom);
        ok = scanf("%lg", &n);
        viderBuffer();
    }
    while (!ok);

    *a = n;
}

/* Recommencer */
char tryAgain()
{
    int ok = 0;
    char n = 0;
    do
    {
        printf("\nVoulez-vous recommencer (o/n) ? ");
        ok = scanf("%c", &n);
        viderBuffer();
        n = (char) tolower(n);
    }
    while (!ok || (n != 'o' && n != 'n'));

    return n;
}

/* Vider le buffer */
void viderBuffer()
{
    while (getchar() != '\n') ;
}
