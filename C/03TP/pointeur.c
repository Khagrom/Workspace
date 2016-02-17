/* pointeur.c
 * Auteur : V. POIRIER le 28/09/2015 */
#include <stdio.h>
#include <ctype.h>

int main()
{
    char c ;    /* Recommencer à la fin du programme */
    int i = 1;
    int *pi = &i;

    printf("Test sur pointeur.\n\n");

    do
    {
        printf("pi = %p; *pi = %d; i = %d\n\n",pi,*pi,i);

        /* Recommencer */
        printf("Voulez-vous recommencer (o/n) ? ");
        scanf("%c",&c);
        while(getchar() != '\n');
        printf("\n");
    }
    while(tolower(c) != 'n');
    return 0;
}
