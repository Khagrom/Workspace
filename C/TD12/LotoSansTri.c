/*** LotoSansTri.c   pour générer 6 chiffres différents pour jouer  ***/
/*** au LOTO avec aff. des nombres dans l'ordre sans utiliser       ***/
/*** une méthode de tri  Auteur : M.RAMBURRUN                       ***/

#include <stdio.h>
#include <stdlib.h>  /* nécessaire pour srand(n) et rand() */
#include <time.h>    /* nécessaire pour time(NULL) */
#include <ctype.h>   /* nécessaire pour tolower */
#define NMAX 6
#define BSUP 49
typedef char bool;
#define false 0
#define true  1

void gen_loto( int v[],bool vDejaTire[] )
{
   int n;
   int i;

   for( i = 0; i < BSUP; i++) vDejaTire[i] = false;
   for( i = 0; i < NMAX; i++)
   {
	  do
	  {
	    n = rand() % ( BSUP - 1 ) + 1; /* n varie de 1 à BSUP */
	  }while ( vDejaTire[n-1] == true );

      vDejaTire[n-1] = true;
      v[i] = n;
   }
} /* genloto */

void aff_vect( int v[], int n )
{
   int i;
   for( i=0; i < n; i++ )
     printf("%7d ", v[i]);
   printf("\n");
} // fin aff_vect

int main()
{
   bool vDejaTire[BSUP];
   int v[NMAX];
   int i;

   char rep;

   srand( time( NULL ) );
   do
   {
     gen_loto( v, vDejaTire );
     printf("Tirage aleatoire de 6 chiffres :\n");
     aff_vect( v, NMAX );

     printf("\nVoici ces chiffres dans l'ordre :\n");
     for( i = 0; i < BSUP; i++ )
        if ( vDejaTire[i] ) printf("%7d ",i+1);
     printf("\n");
	 printf("Recommencer (o/n) ? ");
     rep = getchar();;
     while( getchar() != '\n' ); // pour vider le buffer d'entrée
   }while ( tolower(rep) != 'n' );
   return 0;
} // fin main
