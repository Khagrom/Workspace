/* boucle_while.c pour illustrer l'utilisation d'une boucle while(avec test haut de boucle)
AUTEUR : M.RAMBURRUN le 24/09/2014 */

#include <stdio.h>
int main()
{
    int i; /* i indice de boucle */
    int n; /* n est borne pour la boucle while */

    printf("Entrer la borne n de la boucle : ");
    scanf("%d%*c",&n);

    i = 1;
    while ( i <= n )
    {
        printf("i = %d\n",i);
        i = i + 1;
    }
    printf("Valeur de i en sortie de boucle = %d\n", i);
    return 0;
}
