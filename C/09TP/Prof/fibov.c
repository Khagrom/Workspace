/* fibov.cpp pour g�n�rer une s�quence de FIBONACCI de taille n+1; (n < 1476)*/
/* MAIS en ne g�n�rant les nombres qu'une SEULE fois dans un vecteur         */
#include <stdio.h>
#include <ctype.h>   /* n�cessaire pour tolower */

#define NMAX     1476
#define VALDEBUT 1

/* fonction de remplissage du vecteur m�morisant les 1476 nombres de fibo */

void gen_fibo( double f[], int n )
{
 int i;		   /* pour la boucle de calcul */

 f[0] = VALDEBUT;
 f[1] = VALDEBUT;
 for( i = 2; i < n; i++ ) f[i] = f[i-1] + f[i-2];
}

 //***** fonction principale *****


int main()
{
 int i,n;
 char rep;
 int ok;
 double f[NMAX];

 gen_fibo( f, NMAX );
 do
 {
   do
   {
     printf( "entrer la borne sup dans la seq. de FIBONACCI( 0 <= n < %d ) : ", NMAX );
     ok = scanf( "%d", &n );
	 while( getchar( ) != '\n' );
  }while( !ok || n<0 || n >= NMAX );

   for( i = 0; i <= n; i++ ) printf( "fibo(%4d) = %.0f\n", i, f[i] );
   printf( "\nRecommencer (o/n) ? " );
   scanf( "%c", &rep );
   while( getchar( ) != '\n' );
  }while(tolower(rep) !='n');
  return 0;
}
