/* perm_circ.c */
#include <stdio.h>
#include <ctype.h>
#include <stdlib.h> /* pour malloc, exit */
#define NBRMOTS 40 /*on suppose qu'il y a au plus 40 mots dans la cha�ne*/
#define TAILLEMOT 31 /* on suppose qu'un mot est de taille <= 30 */
#define false 0
#define true  1

typedef char bool;

/* estUnSeparateur(c) permet de savoir si le caract�re c */
/* est un s�parateur ou non */
/* en entr�e : le caract�re c */
/* en sortie : un bool�en  pour renseigner si c est un s�parateur ou non*/
bool estUnSeparateur( char c )
{
   if ( c == ' '  || c == ',' || c == ';'  || c == ':' ||
        c == '('  || c == ')' || c == '"'  || c == '!' ||
        c == '?'  || c == '{' || c == '}'  || c == '[' ||
        c == ']'  || c == '/' || c == '\\' || c == '%' ||
        c == '<'  || c == '>' ||  c == '\t' )
   return true;
   else return false;
}

/* la fonction int extractionMots(p,vMots) permet d'extraire   */
/* un mot � partir de la chaine pour le ranger                 */
/* dans le vecteur vMots[NBRMOTS][TAILLEMOT]                   */
/* en entr�e : p est l'adresse de d�but de la cha�ne � traiter */
/* en E/S : le vecteur vMots[NBRMOTS][TAILLEMOT]               */
/* en retour : la fonction renvoie le nbre courant de mots extr*/
int extractionMots( char *p, char vMots[][TAILLEMOT] )
{
 int nb = 0; /* indice du mot courant dans le vecteur vMots[i][j] */
 int j; /* indice pour ranger chaque carac du mot courant dans vMots[i][j] */

 while ( *p != '.' && *p != '\0' )
 {
   j = 0;
   if ( *p == '.' || *p == '\0' )
   {
    vMots[nb][j]= '\0'; /* on range '\0' en fin du mot courant */
    return nb;
   }
   while ( estUnSeparateur(*p) ) p++; /* saut de tous les s�parateurs */
   while ( *p != '\0' && *p != '.' && !estUnSeparateur(*p) )
   {
     vMots[nb][j] = *p++;
     j++;
   }
   vMots[nb][j]='\0'; /* on range '\0' en fin du mot courant */
   nb++; /* on vient de m�moriser un mot de plus dans la vecteur vMots */
  }
  return nb;
}

void permutationCirculaire( char vMots[][TAILLEMOT], int nb )
{
 int i,j,k;
 for( i = 0; i < nb; i++)
 {
     for( j = i, k = 0; k < nb; j = (j + 1) % nb , k++ )
     {
      printf("%s ",vMots[j]);
     }
     printf("\n");
 }
}

void main()
{
 char vMots[NBRMOTS][TAILLEMOT]; /* un vecteur de NBRMOTS avec  */
                   /* chaque mot de taille au plus = TAILLEMOT  */
 int nb;           /* nombre de mots extraits */
 char chaine[256]; /* chaine est un vecteur pour m�moriser la cha�ne lue */
 int i;            /* indice de travail     */
 char rep;         /* r�ponse � Recommencer (o/n) ? */

 do
  {
   printf("Entrer une phrase se terminant par un point : \n");
   gets(chaine);
   nb = extractionMots( chaine, vMots );

   /* Si on veut visualiser les mots extraits */
   /*
   printf("Voici les mots extraits : \n");
   for ( i = 0; i < nb; i++ )
   {
     printf("%s \n",vMots[i]);
   }
   */

   printf("\nVoici les diff. perm. dans le sens contraire des aiguilles d'une montre :\n\n");
   permutationCirculaire(vMots,nb);
   printf("\nRecommencer (o/n) ? ");
   rep = getchar();
   while( getchar() != '\n' );
  }while( tolower(rep) != 'n' );
}
