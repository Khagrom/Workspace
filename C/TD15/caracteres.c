#include <stdio.h>
#include <stdlib.h>
#define MIN 32
#define MAX 255
void ascii(int debut, int fin);
void codeAscii();
void compterUnCaracterePhrase();
void compterTousCaracterePhrase();
void afficheCompte(const int *tab);
char tryAgain();
void viderBuffer();

int main()
{
    char again = 0;
    do
    {
        codeAscii();
        printf("\n");
        compterUnCaracterePhrase();
        compterTousCaracterePhrase();
        again = tryAgain();
    }
    while (again == 'o');

    return 0;
}

void ascii(int debut, int fin)
{
    int i;
    int cpt = 0;
    for(i = debut; i < fin + 1; i++)
    {
        printf("     %c       %d\n", (char)i, i);
        cpt++;
        if(cpt % 10 == 0)
        {
            printf("\nAppuyez sur Entree pour continuer...");
            viderBuffer();
            printf("\n");
        }
    }
}

void codeAscii()
{
    char again = 0;
    int ok;
    int numdebut = 0;
    int numfin = 0;
    printf("\nAFFICHAGE DU SYSTEME DE CODAGE ASCII PAR PORTION\n\n");
    do
    {
        printf("Entrez le numero de debut (entre %d et %d) : ", MIN, MAX);
        ok = scanf("%d", &numdebut);
        viderBuffer();
    }
    while (!ok || numdebut > MAX || numdebut < MIN);
    do
    {
        printf("Entrez le numero de fin (entre %d et %d) : ", numdebut, MAX);
        ok = scanf("%d", &numfin);
        viderBuffer();
    }
    while (!ok || numfin > MAX || numfin < numdebut);
    printf("\n   ASCII   Numero\n");
    ascii(numdebut, numfin);
}

void compterUnCaracterePhrase()
{
    char c = 0;
    char courant = 0;
    int compteur = 0;

    printf("Quel caractere voulez-vous compter ? ");
    scanf("%c", &c);
    viderBuffer();
    printf("\nEntrez votre phrase :\n");
    courant = getchar();
    while (courant != '\n')
    {
        if (courant == c) compteur++;
        courant = getchar();
    }
    printf("\nLe nombre d'occurrence(s) du caractere '%c' est %d.\n\n", c, compteur);
}

void compterTousCaracterePhrase()
{
    int compte[MAX];
    char courant = 0;
    int i;
    for(i = 0; i < MAX; i++) compte[i] = 0;
    printf("Entrez votre phrase :\n");
    courant = getchar();
    while (courant != '\n')
    {
        compte[(int)courant]++;
        courant = getchar();
    }
    afficheCompte(compte);
    printf("\n");
}

void afficheCompte(const int *tab)
{
    int i;
    int cpt = 0;
    printf("\nCompte des caracteres :\n");
    printf("Caractere   Compte\n");
    for(i = 32; i < MAX; i++)
    {
        if(tab[i] != 0)
        {
            cpt++;
            printf("    %c          %d\n", (char)i, tab[i]);
            if(cpt % 10 == 0)
            {
                printf("\n%d %d Appuyez sur Entree pour continuer...",i, MAX);
                viderBuffer();
                printf("\n");
            }
        }
    }
}

char tryAgain()
{
    int ok = 0;
    char n = 0;
    do
    {
        printf("Recommencer ? (o/n) ");
        ok = scanf("%c", &n);
        viderBuffer();
        n = (char) tolower(n);
    }
    while (!ok || (n != 'o' && n != 'n'));

    return n;
}

void viderBuffer()
{
    while (getchar() != '\n');
}
