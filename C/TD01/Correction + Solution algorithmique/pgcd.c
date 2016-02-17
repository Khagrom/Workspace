/*****   SOLUTION ALGORITHMIQUE  *****/
/*

# fonction pgcd(a,b)

def pgcd( a , b ) :
#entree :
#  val a : int    (a est un argument en entrée passé par valeur)
#  val b : int    (b est un argument en entrée passé par valeur )
#précondition :
#	 les entiers  a et b sont positifs
#sortie :
#      la fonction retourne le PGCD de a et de b à l'aide de p
#définitions :
#  d : int    (plus grand)
#  p : int    (plus petit)
#  s : int    (variable de travail)

#début
  if ( a >= b ) :
    d = a
    p = b
  else :
    d = b
    p = a
  #endif

  s = d - p

  while ( s >  0 ) :
    if ( s >= p ) :
      d = s
    else :
      d = p
      p = s
    #endif
    s = d - p
  #endwhile

  return(p)

#fin

# partie principale
def main() :

#définitions :
# a : int
# b : int
# rep : char   (pour pouvoir recommencer tout le processus)

#début
   rep = 'o'
   while rep != 'n' :
     print( "Calcul du PGCD de 2 entiers a et b" )

     a = 0
     while  int(a) <= 0 :
       a = input( "Entrer l'entier a > 0 : " )
     #endwhile

     b = 0
     while int(b) <= 0 :
       b = input( "Entrer l'entier b > 0 : " )
     #endwhile
     r = pgcd( int(a), int(b) )
     print( "pgcd(", a , "," , b , ") = ", r )
     rep = input( "recommencer (o/n) ? " )
     rep = rep.lower()
   #endwhile
#fin

*/
/*****   SOLUTION EN LANGAGE C  *****/

/******* pgcd.c *******/
#include <stdio.h>
#include <ctype.h> /* pour la déclaration(prototype) char tolower(char);  */

int pgcd(int a, int b)  /* a et b sont des arguments en entrée passés par valeur; */
     /* en sortie de la fonction on aura le PGCD de a et de b  */
{
   int d;  /* plus grand */
   int p;  /* plus petit  */
   int s;  /* variable de travail */

  if ( a >= b )
  {
     d = a;
     p = b;
  }
  else
  {
     d = b;
     p = a;
  }

  s = d - p;

  while ( s >  0 )
  {
      if ( s >= p )
         d = s;
      else
     {
         d = p;
         p = s;
     }
    s = d - p;
  }
  return p;
}

int main()
{
   int a,b;
   int ok;   /* pour la validation de saisie */
   char rep; /* pour pouvoir recommencer tout le processus */

 do
 {
   printf( "Calcul du PGCD de 2 entiers a et b\n" );
   do
   {
      printf( "Entrer l'entier a > 0 : " );
      ok = scanf( "%d", &a );
      while( getchar() != '\n' );
   }while ( ! ok || a <= 0 );

  do
  {
     printf( "Entrer l'entier b > 0 : " );
     ok = scanf( "%d", &b );
     while( getchar() != '\n' );
  }while ( !ok || b <= 0 );

   printf( "pgcd(%d,%d) = %d\n", a, b, pgcd(a,b) );

   printf("recommencer (o/n) ? ");
   scanf("%c",&rep);
   while( getchar() != '\n' );
  }while ( tolower(rep) != 'n' );
 return 0;
}
