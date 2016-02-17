/* bits.c						AUTEUR : M.RAMBURRUN */
#include <stdio.h>
#include <limits.h>  /* pour INT_MIN sur certains compilateurs C */
#include <ctype.h>

#define TAILLEINT 8*sizeof(int)

/* ici unsigned = unsigned int */
void affbits( int n )                 /* affiche n en binaire */
{
    unsigned masque = INT_MIN; // par ex. masque = 0x80000000 pour 32 bits
    int i;

    for( i = 1; i <= TAILLEINT; i++ )
    {
        if ( (n & masque) == 0  )  printf("0 "); /* ATTENTION! ( n & masque) pour introduire une priorité */
        else                                 printf("1 ");
        masque >>= 1;
    }
    printf("\n");
}

int inverse( unsigned x, unsigned p, unsigned n )
/* complémente n bits de x à partir du pème */
/* et laisse les autres inchangés           */
{
    if(n == TAILLEINT) return( ~x );
    else  return( x ^ ( ~ ( -1 << n ) << (p - n) ) );
}

int rot_droite( unsigned n, unsigned b )
/* effectue une permutation circulaire de  */
/* b bits vers la droite dans un entier n  */
{
    unsigned r,s;    /* variables auxiliaires définies dans le texte */
    int x,y;

    x = (int)b;
    y = TAILLEINT;
    b = (unsigned)(x % y);
    if( b > 0 )
    {
        s = n >> b;
        r = n << ( TAILLEINT - b );
        return( s | r );
    }
    else
        return( n );
}

int main()                     /* fonction principale */
{
    int nombre;        /* nombre manipulé par les fonctions   */
    int position;       /* second    argument pour inverse        */
    int quantite_1;   /* troisième argument pour inverse       */
    int quantite_2;   /* second argument pour rot_droite      */
    char rep;            /* reponse(o/n) de l'utilisateur              */
    int i;                   /* indice de boucle                               */
    int ok;                /* variable pour la validation de saisie  */

    do
    {
        printf("\n\n\t\tM A N I P U L A T I O N    D E    B I T S\n");
        printf("\t\t-----------------------------------------\n\n");
        do
        {
            printf("Donnez un entier quelconque : ");
            ok = scanf("%d", &nombre);
            while( getchar( ) != '\n' );  /* ou fgets(vb,80,stdin)  avec  char vb[81];  */
        }
        while ( ! ok );
        printf("Voici sa representation en binaire :\n");
        affbits(nombre);
        printf("\n\nOn va inverser n bits de ce nombre a compter du p eme\n");
        do
        {
            printf("Donner p ( > 0 et <= %2d ) : ", TAILLEINT);
            ok = scanf("%d", &position);
            while( getchar( ) != '\n' );  /* ou fgets(vb,80,stdin)  avec  char vb[81];  */
        }
        while ( ! ok || position <= 0 || ( position > TAILLEINT )  );
        do
        {
            printf("Donner n ( > 0 et <= %2d ) : ", position);
            ok = scanf("%d",&quantite_1);
            while( getchar( ) != '\n' );  /* ou fgets(vb,80,stdin)  avec  char vb[81];  */
        }
        while( ! ok ||  quantite_1 <= 0 || ( quantite_1 > position ) );
        affbits( inverse( nombre, position, quantite_1 ) );
        quantite_2 = TAILLEINT;
        for( i = 1; i <= 2 * ( quantite_2 - position ); i++ ) printf(" ") ;
        printf("-");
        for( i = 1; i <= 2 * quantite_1 - 2; i++ ) printf("-");
        printf("\n\nSur le nombre \"%d\" de representation binaire\n", nombre);
        affbits(nombre);
        printf("\nOn va effectuer une permutation circulaire vers la DROITE de b bits.\n");
        do
        {
            printf("Donner b ( >0 ) : ");
            ok = scanf("%d",&quantite_2 );
            while( getchar( ) != '\n' );  /* ou fgets(vb,80,stdin)  avec  char vb[81];  */
        }
        while ( ! ok || quantite_2 <= 0 );
        affbits( rot_droite ( nombre, quantite_2 ) );
        printf("Recommencer (o/n) ? : ");
        scanf("%c",&rep);
        while( getchar( ) != '\n' );  /* ou fgets(vb,80,stdin)  avec  char vb[81];  */
    }
    while(tolower(rep) != 'n');
    return 0;
}
