/* pair_impair.c
 * Auteur : V. POIRIER le 08/10/2015 */
#include <stdio.h>
#include <ctype.h>

/* Par calcul d'une seule somme */
void pair_impair1(int n, double *sp, double *simp)
{
    *sp = 0;
    *simp = 0;
    double s = n*((double)n+1)/2;
    int i = 0;
    while(i <= n)
    {
        *sp = *sp + i;
        i = i + 2;
    }
    *simp = s - *sp;
}

/* Par condition */
void pair_impair2(int n, double *sp, double *simp)
{
    *sp = 0;
    *simp = 0;
    int i = 0;
    while (i <= n)
    {
        if (i%2 == 0)
        {
            *sp = *sp + i;
        }
        else
        {
            *simp = *simp + i;
        }
        i = i + 1;
    }
}

/* Par booléen */
void pair_impair3(int n, double *sp, double *simp)
{
    int i;
    int i_est_pair = 0;

    *sp = 0;
    *simp = 0;
    for(i = 1; i <= n; i++)
    {
        if (i_est_pair == 1) *sp += i;
        else *simp += i;
        i_est_pair =! i_est_pair;
    }
}

/* Par formule directe */
void pair_impair4(int n, double *sp, double *simp)
{
    *sp = (n/2)*((n/2)+1.0);
    *simp = n*(n+1.0)/2 - *sp;
}

int main()
{
    /* n : valeur saisie
     * sp : somme des pairs
     * simp : somme des impairs */
    int n;
    double sp,simp;

    /* Validation de saisie */
    int ok;

    /* Gérer la réponse de l'utilisateur */
    char c;

    do
    {
        /* Saisie et vérification de l'entier n */
        do
        {
            printf("Entrer un entier n : ");
            ok = scanf("%d",&n);
            while(getchar() != '\n');
        }
        while (!ok);

        /* Appel des procédures */
        pair_impair1(n,&sp,&simp);
        printf("Sol. 1 : n = %d ; sp = %.0f ; simp = %.0f\n",n,sp,simp);
        pair_impair2(n,&sp,&simp);
        printf("Sol. 2 : n = %d ; sp = %.0f ; simp = %.0f\n",n,sp,simp);
        pair_impair3(n,&sp,&simp);
        printf("Sol. 3 : n = %d ; sp = %.0f ; simp = %.0f\n",n,sp,simp);
        pair_impair4(n,&sp,&simp);
        printf("Sol. 4 : n = %d ; sp = %.0f ; simp = %.0f\n\n",n,sp,simp);

        /* Recommencer */
        printf("Recommencer (o/n) ? ");
        scanf("%c",&c);
        while(getchar() != '\n');
        printf("\n");
    }
    while(tolower(c) != 'n');

    return 0;
}
