
		/****** puissance.c     pour calculer x à la puissance n ******/

#include <stdio.h>
#include <ctype.h>
#include <math.h>


/* cette fonction ne marche pas pour x=0 et n<=0 (puiss. non definie) */

double puissance( double x, int n )
{int i;
 double p;

 if( x == 0 )
	if ( n <= 0 ) printf( "Puissance non definie\n" );
    else p = 0;
  else if( x == 1 ) p = 1;
  	else if( n == 0 ) p = 1;
  	      else if ( n == 1 ) p = x;
		     else if( n < 0 ) p = ( 1 / puissance( x, -n ) );
				else
				 {
				  /* calcul explicite pour les expo > 0 */
				  p = x;
				  for( i = 2 ; i <= n ; i++ ) p *= x;
				 }
 return(p);
}


/****************** main() ********************/
int main()
{
 int n;
 double x;
 char rep;
 int ok;

do
 {
   do
   {
    printf( "Pour calculer x puissance n ,entrer x puis n :\n" );
    do
	{
     printf( "Entrer x : ");
  	 ok = scanf( "%lg", &x );
	 while( getchar( ) != '\n' );
    }while( !ok );

    do
	{
     printf( "Entrer n : ");
  	 ok = scanf( "%d", &n );
	 while( getchar( ) != '\n' );
    }while( !ok );

   }while( x == 0 && n <= 0 );

   printf( "On a %7.1f puis %d \t= %.5f\n", x , n , puissance( x, n ) );
   printf( "On a pow(%.1f,%d) \t= %.5f\n", x , n , pow( x , n ) );
   printf( "Recommencer (o/n) ? " );
   scanf( "%c" , &rep );
   while( getchar( ) != '\n' );
  }while ( tolower(rep) != 'n' );
 return 0;
}
