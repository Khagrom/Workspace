/*  Test de break  : break1.c */
#include <stdio.h>
#include <ctype.h>

int main()
{
	int j; char rep;
	int ok;
	do
	{

	 do
	 {
		printf( "Entrer un numero de jour : " );
        ok = scanf( "%d", &j );
        while( getchar( ) != '\n' );
	 }while ( ! ok );

	 switch(j)
	 {
		 case 1 : printf(  "lundi\n" );
			      break;
         case 2 : printf(  "Mardi\n" );
			      break;
         case 3 : printf(  "Mercredi\n" );
			      break;
         case 4 : printf(  "Jeudi\n" );
			      break;
         case 5 : printf(  "Vendredi\n" );
			      break;
         case 6 :
		 case 7 : printf(  "Week End\n" );
			      break;
         default : printf(  "Erreur\n" );
	 }
	 printf( "recommencer (o/n) ? " );
     scanf( "%c", &rep );
     while( getchar( ) != '\n' );
	}while( tolower(rep) != 'n' );
	return 0;
}
