/* validsaisie.c */
#include <stdio.h>
#include <ctype.h>

int main()
{
    double x;  /* pour la lecture du nombre réel */
    int ok;      /* pour la validation de saisie de x */
    char rep;  /* pour pouvoir recommençer */

    do
    {
        do
        {
            printf( "Entrer un nombre  : " );
            ok = scanf( "%lg", &x );
            while( getchar( ) != '\n' );/* vidage du buffer d'ent. stdin associé au clavier */
        }
        while ( ! ok );
        printf( "Le nombre lu vaut %lg.\n",x );
        printf( "Recommencer ( o/n ) : " );
        scanf( "%c", &rep );
        while( getchar( ) != '\n' );/* vidage du buffer d'ent. stdin associé au clavier */
    }
    while ( tolower(rep) != 'n' );

    return 0;
}
