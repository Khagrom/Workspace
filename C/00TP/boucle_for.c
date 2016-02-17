/* boucle_for.c pour gérer une structure répétitive de type for(pour i de 1 à n pas 1)(test haut de boucle)
    AUTEUR : M.RAMBURRUN le 24/09/2014  */
#include <stdio.h>

int main()
{
    int i; /* indice de boucle */
    int n; /* n borne pour la boucle sur i */

    printf("Entrer la borne n pour la boucle : ");
    scanf("%d%*c",&n);

    for( i = 1; i <= n; i = i + 1)
    {
        printf("i = %d\n",i);
    }   /*   {   et   }    sont  facultatifs  ici   */

    printf("Valeur de i en sortie de boucle : %i\n",i);

    return 0;
}
