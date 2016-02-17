	/***** parfait.c  	auteur : M.RAMBURRUN ******/
#include <stdio.h>
#include <ctype.h>
typedef  char  bool;
#define false 0
#define true 1

#define  BORNEINF 1

#define  BORNESUP 200000

int main()
{ int i,j,n;/*i : élément candidat; j : pour rech. de diviseurs propres; n:borne lue*/
  int somme;
  bool il_y_en_a;
  char rep;
  int ok;    /* pour la validation de saisie */


 do
  {
   il_y_en_a = false;

   do
    {

	 printf( "Entrer un nb de %d a %d : ", BORNEINF, BORNESUP );

     ok = scanf( "%d" , &n );

     while( getchar( ) != '\n' );

	}while ( !ok || n < BORNEINF || n > BORNESUP );

   for( i = BORNEINF; i <= n; i++ )
   {

     somme = i % 10;

	 if ( somme == 6 || somme == 8 ) /* optimisation */

	 {

		 somme = 3; /*3=1 + 2;car 1 et 2 sont systématiquement diviseurs*/

	     for( j = 3; j <= i/2; j++ ) if( i%j == 0 ) somme = somme + j;

         if( somme == i )
		 {
	       printf( "%7d est un nb parfait\n", i );

           il_y_en_a = true;

		 }

     }

   }

if(!il_y_en_a)printf("Il n'y a pas de nombre parfait dans {%d,..,%d}\n",BORNEINF,n);

   printf( "Voulez-vous recommencer (o/n) ? " );

   scanf( "%c" , &rep );

   while( getchar( ) != '\n' );
  }while( tolower(rep) != 'n');

  return 0;

}
