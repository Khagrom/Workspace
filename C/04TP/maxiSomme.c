/* maxiSomme.c qui permet de faire de
 * retrouver le maximum ainsi que la somme
 * d'un nombre variable de nombres r�els
 * saisis au clavier
 * Auteur : V. POIRIER le 01/10/2015 */
#include <stdio.h>
#include <ctype.h>

int main()
{
    /* n : valeur saisie
     * maximum : le maximum des valeurs saisies
     * somme : la somme des valeurs saisies */
    double n,maximum,somme;

    /* i : variable de boucle
     * ok : validation de saisie */
    int i,ok;

    /* G�rer la r�ponse de l'utilisateur */
    char c;

    printf("Trouver le maximum et la somme d'un nombre variable de reels.\n\n");

    do
    {
        somme = 0;
        i = 0;

        do
        {
            /* Saisie et v�rification du r�el n */
            do
            {
                printf("Entrer nombre (%d) : ",i+1);
                ok = scanf("%lg",&n);
                while(getchar() != '\n');
            }
            while (!ok);

            /* On actualise la valeur de la somme */
            somme += n;

            /* On assigne � maximum la premi�re valeur rentr�e
             * ou simplement la nouvelle valeur si elle est sup�rieure */
            if(n > maximum || i == 0) maximum = n;

            /* Autre saisie */
            printf("Autre nombre (o/n) ? ");
            scanf("%c",&c);
            while(getchar() != '\n');

            /* Incr�mentation */
            i++;
        }
        while(tolower(c) != 'n');

        printf("\nLe plus grand des %d nombres est : %lg\n",i,maximum);
        printf("Et la somme des %d nombres est : %lg\n\n",i,somme);

        /* Recommencer */
        printf("Recommencer (o/n) ? ");
        scanf("%c",&c);
        while(getchar() != '\n');
        printf("\n");
    }
    while(tolower(c) != 'n');

    return 0;
}
