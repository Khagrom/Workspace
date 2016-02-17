/* boucle_do_while.c pour gérer une structure répétitive de type do... while(test bas de boucle)
    AUTEUR : M.RAMBURRUN le 24/09/2014  */
#include <stdio.h>

int main()
{
    int i; /* indice de boucle */
    int n; /* n borne pour la boucle sur i */

    printf("Entrer la borne n pour la boucle : ");
    scanf("%d%*c",&n);

    i = 1;
    do
    {
       printf("i = %d\n",i);
       i = i + 1;
     }while ( i <= n);

    printf("Valeur de i en sortie de boucle : %i\n",i);

    return 0;
}
