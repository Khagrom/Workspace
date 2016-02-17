#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <time.h>

void denombrement(int *tab, const int a, const int b);
void genererTableau(int* tab, const int n);
void printTab(const int* tab, const int n);
char tryAgain();
void pause();
void viderBuffer();

#define NBCHIFFRES 6
#define MAXLOTO 49

int main(int argc, const char *argv[])
{
    srand(time(NULL));
    int* tab;
    char again;

    do {
        system("cls");
        printf("LE\n");
        printf("\n*      *****  *****  *****\n*      *   *    *    *   *\n*      *   *    *    *   *\n*****  *****    *    *****\n");
        printf("\nC'est facile...");
        printf("\nC'est pas cher...");
        printf("\nEt ca peut rapporter gros !!!\n");

        tab = (int *) malloc(NBCHIFFRES * sizeof(int));
        if (tab == NULL) {
             fprintf(stderr,"\nAllocation impossible.\n");
             exit(EXIT_FAILURE);
        }

        printf("\nTirage aleatoire de %d chiffres :\n\n", NBCHIFFRES);
        genererTableau(tab, NBCHIFFRES);
        printTab(tab, NBCHIFFRES);
        printf("\n\n");

        printf("Voici ces %d chiffres dans l'ordre :\n\n", NBCHIFFRES);
        denombrement(tab, MAXLOTO, NBCHIFFRES);
        printTab(tab, NBCHIFFRES);
        printf("\n\n");

        again = tryAgain();
    }
    while (again == 'o');

    free(tab);
    return 0;
}

void denombrement(int *tab, const int a, const int b)
{
  int i, j, k;
  int *count = malloc((a + 1) * sizeof(*tab));

  for(i = 0; i <= a; i++) count[i] = 0;
  for(i = 0; i < b; i++) count[ tab[i] ]++;

  for(i = 0, k = 0; i <= a; i++)
    for(j = 0; j < count[i]; j++)
      tab[k++] = i;
  free(count);
}

void genererTableau(int* tab, const int n)
{
    int i;
    for (i = 0; i < n; i++)
        tab[i] = (rand() % MAXLOTO) + 1;
}

void printTab(const int* tab, const int n)
{
    int i;
    const int *p, *pfin = tab + n;

    for (p = tab, i = 0; p < pfin; p++, i++)
    {
        printf("%7d ", *p);

        if ((i+1) % 10 == 0 && i != n-1)
            printf("\n");

        if ((i+1) % 50 == 0 && i != n-1)
            pause();
    }
}

char tryAgain() {
    int ok = 0;
    char n = 0;
    do {
        printf("Recommencer ? (o/n) ");
        ok = scanf("%c", &n);
        viderBuffer();
        n = (char) tolower(n);
    } while (!ok || (n != 'o' && n != 'n'));

    return n;
}

void pause()
{
    printf("Appuyez sur Entree pour continuer...\n");
    viderBuffer();
}

void viderBuffer()
{
    while (getchar() != '\n') ;
}
