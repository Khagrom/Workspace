/*  Test de continue  : continue.c */
#include <stdio.h>
#include <ctype.h>

int main()
{
	int i,n;
	char rep;
	int ok;

	do
	{
	  do
	  {
		printf( "Entrer un entier de 1 a 20 : " );
        ok = scanf( "%d", &n );
        while( getchar( ) != '\n' );
	  }while ( ! ok || n <= 0 || n > 20);

	 printf( "Affichage de 1 a 20 sauf en cas d'interruption :\n" );
     for(i = 1;i <= 20; i = i + 1)
	 {
            if ( i == n ) continue;
			printf( " i = %d\n", i );
	 }
	 printf( "recommencer (o/n) ? " );
     scanf( "%c", &rep );
     while( getchar( ) != '\n' );
	}while(tolower(rep) != 'n');
	return 0;
}
