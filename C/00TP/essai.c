/* essai.c */
#include <stdio.h>
int  main( )
{
   int  i;
   double   s = 0;

  printf(  "Somme des carres des nombres de {  1 , 2, 3, ….,  100 }  :\n"  );
  for(  i = 1;  i <= 100;  i = i + 1  )  s = s + i * i;  /* ou s += i*i; */
  printf( " Somme = %lg\n\n",  s );

  i = 0;
  do
  {
      printf(  "i  vaut  %d\n" , i  );
      i = i + 1;
  }while ( i < 10 );
  return 0;
} /* fin main */
