/* calculette.c qui permet de faire des
 * op�rations de base sur deux entiers a et b
 * Auteur : V. POIRIER le 28/09/2015 */
#include <stdio.h>
#include <ctype.h>

/* calculette(int a, int b, char operation) qui g�re le calcul
 * Entr�e : deux r�els a et b, et un caract�re operation
 * R�sultat : le r�sultat de l'op�ration
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
    double a,b;     /* R�els sur lesquels faire l'op�ration */
    char operation; /* Caract�re op�ration */
    int ok;         /* V�rification de saisie */
    char c ;        /* Recommencer � la fin du programme */

    printf("Programme de calculatrice.\n\n");

    do
    {
        /* Saisie et v�rification du caract�re op�ration */
        do
        {
            printf("Entrer un operateur parmi ('+','-','*','/') : ");
            scanf("%c",&operation);
            while(getchar() != '\n');
        }
        while (operation != '+' && operation != '-' && operation != '/' && operation != '*');

        /* Saisie et v�rification de l'entier a */
        do
        {
            printf("Entrer un reel a : ");
            ok = scanf("%lg",&a);
            while(getchar() != '\n');
        }
        while (!ok);

        /* Saisie et v�rification de l'entier b
         * Attention, b doit �tre diff�rent de 0 si on a choisi la division */
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
