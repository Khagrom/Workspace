/*******       javanais.c        ******/
/* AUTEUR : M.RAMBURRUN le 15/12/2015 */
#include <stdio.h>
/*#include <ctype.h> */  /* pour pouvoir utiliser isalpha(c) */

typedef char  bool;
#define false 0
#define true  1

	   /******* fonction voyelle ******/
bool voyelle( char c )
{
 c = tolower(c);
 if ( c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c== 'y')
	   return true;
  else return false;
}

/****** fonction isalpha *****

bool isalpha( char c ) // Pour savoir si c est dans l'alphabet latin majuscule ou minuscule
{
 c = tolower(c);
 if ( c >= 'a' && c <= 'z' ) return true;
  else return false;
}

*/
	  /******* procédure traduction ******/
void traduction( char *phf, char *phja )
{
 char c;

 while ( ( c = *phf++ )  != '.' && c != '\0' )
  {
   if ( isalpha(c) && !voyelle(c) && voyelle(*phf) )
     {
      *phja++ = c;
      if( isupper(c) && isupper(*phf))
      {
       *phja++ = 'A';
       *phja++ = 'V';
      }
      else
      {
       *phja++ = 'a';
       *phja++ = 'v';
      }
      *phja++ = *phf++;
     }
    else
     *phja++ = c;
  }
 *phja++ = '.';
 *phja   = '\0';
}

       /****** fonction main ******/
int main()
{
 char phf[255+1], phja[512+1], rep;

 do
  {
   printf("Entrer une phrase se terminant par un '.' :\n");
   gets(phf);
   traduction( phf, phja );
   printf("\nVoici sa traduction en javanais :\n%s\n\n", phja );
   printf("Recommencer (o/n) ? ");
   rep = getchar();;
   while( getchar() != '\n');
  }while ( tolower( rep ) != 'n' );
 return 0;
}
