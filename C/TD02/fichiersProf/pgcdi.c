/* pgcdi.c pour calculer le pgcd des 2 entiers a et b
 * Auteur : M.RAMBURRUN
 */
#include <stdio.h>
#include <ctype.h>

/* fonction pgcdi pour calculer le pgcd des 2 entiers a et b de manière itérative
 * entrée : nombre entier a
            nombre entier b
            pour lequels on veut le pgcd
 * pré-condition : a et b sont des entiers
 * résultat : le pgcd des 2 entiers a et b;
 */
int pgcdi( int a, int b )
{
 int r; /* pour calculer le reste de la division entière de a par b */

 while ( b != 0 )
 {
  r = a % b;
  a = b;
  b = r;
 }
 return a;
}

/* fonction pgcdr pour calculer le pgcd des 2 entiers a et b de manière récursive
 * entrée : nombre entier a
            nombre entier b
            pour lequels on veut le pgcd
 * pré-condition : a et b sont des entiers
 * résultat : le pgcd des 2 entiers a et b;
 */
int pgcdr( int a, int b )
{
   if ( b == 0 ) return a;
   else return ( pgcdr( b, a % b ) );
}

int main()
{
  int  a,b;   /* les nombres pour lequels on veut calculer le pgcd  */
  char rep; /* reponse o/n de l'utilisateur                         */
  int  ok;  /* pour la validation de saisie                         */

 do
 {
    printf("Calcul du pgcd des 2 entiers a et b\n");
    do
	{
	  printf( "Entrer le nombre entier a : " );
      ok = scanf( "%d" , &a );
	  while( getchar( ) != '\n' );
	}while ( !ok );

    do
	{
	  printf( "Entrer le nombre entier b : " );
      ok = scanf( "%d" , &b );
	  while( getchar( ) != '\n' );
	}while ( !ok );

   printf(" pgcdi(%d,%d) = %d par une methode iterative\n", a, b, pgcdi(a,b));
   printf(" pgcdr(%d,%d) = %d par une methode recursive\n", a, b, pgcdr(a,b));

   printf( "Recommencer (o/n) ? " );
   scanf( "%c" , &rep );
   while( getchar( ) != '\n' );

 }while (tolower(rep) != 'n');
 return 0;
}
