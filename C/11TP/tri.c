#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <time.h>
#include <limits.h>

void getPostes(int* a);
void gen_jd1(int* tab, const int n);
void gen_jd3(int* tab, const int n);
void gen_jd2(int* tab, const int n);
void printTab(const int* tab, const int n);
void premierChoix(int* choix);
void secondChoix(char* choix);
void viderBuffer();
void triSelection(int* tab, const int n);
void triBulle(int* tab, const int n);
void swapVar(int* a, int* b);
int compare(const void *a, const void *b);
void pause();

#define VALMAX 32767

int main(int argc, const char *argv[])
{
    srand(time(NULL));
    int n;
    int choix1;
    char choix2;
    int* tab;
    char retry = 0;

    do
    {
        system("cls");
        n = 0;

        do
        {
            getPostes(&n);
            tab = (int *) malloc(n * sizeof(int));
            if (tab == NULL)
                printf("Pas assez de memoire disponible :)\n");
        }
        while (tab == NULL);

        printf("\n");
        premierChoix(&choix1);
        printf("\n");
        secondChoix(&choix2);

        switch (choix1)
        {
        case 1:
            gen_jd1(tab, n);
            break;
        case 2:
            gen_jd2(tab, n);
            break;
        default:
            gen_jd3(tab, n);
            break;
        }

        printf("\nTableau non trie :\n\n");
        printTab(tab, n);
        printf("\n");

        switch (choix2)
        {
        case 'b':
            triBulle(tab, n);
            break;
        case 's':
            triSelection(tab, n);
            break;
        case 'q':
            qsort(tab, n, sizeof(int), compare);
            break;
        default:
            break;
        }

        printf("\nTableau trie :\n\n");
        printTab(tab, n);
        printf("\n");

        printf("\nRecommencer ? (o/n) ");
        scanf("%c", &retry);
        retry = tolower(retry);
    }
    while (retry == 'o');

    free(tab);
    return 0;
}


void getPostes(int* a)
{
    int ok = 0;
    int n = 0;
    do
    {
        printf("Introduire le nombre de postes du vecteur (0 a %d) : ", INT_MAX);
        ok = scanf("%d", &n);
        viderBuffer();
    }
    while (!ok || n < 0 || n > INT_MAX);

    *a = n;
}

void premierChoix(int *choix)
{
    int ok = 0, n = 0;
    do
    {
        printf("3 jeux de donnees vous sont proposes :\n");
        printf("1. Les donnees sont triees par ordre croissant\n");
        printf("2. Les donnees sont triees par ordre decroissant\n");
        printf("3. Les donnees sont aleatoires\n");
        printf("Faites votre choix (1, 2 ou 3) : ");
        ok = scanf("%d", &n);
        viderBuffer();
    }
    while (!ok || n > 3 || n < 1);

    *choix = n;
}

void secondChoix(char* choix)
{
    int ok = 0;
    char n = 0;
    do
    {
        printf("3 methodes de tri sont proposees :\n");
        printf("b. Tri a bulles\n");
        printf("s. Tri par selection\n");
        printf("q. Tri rapide universel\n");
        printf("Faites votre choix (b, s ou q) : ");
        ok = scanf("%c", &n);
        viderBuffer();
        n = tolower(n);
    }
    while (!ok || n != 'b' && n != 's' && n != 'q');

    *choix = n;
}

void gen_jd1(int* tab, const int n)
{
    int i;
    for (i = 0; i < n; i++)
        tab[i] = i;
}

void gen_jd2(int* tab, const int n)
{
    int i;
    for (i = 0; i < n; i++)
        tab[i] = n-i-1;
}

void gen_jd3(int* tab, const int n)
{
    int i;
    for (i = 0; i < n; i++)
        tab[i] = (rand() - rand()) % VALMAX;
}

void printTab(const int* tab, const int n)
{
    int i;
    const int *p, *pfin = tab + n;

    for (p = tab, i = 0; p < pfin; p++, i++)
    {
        printf("%7d ", *p);

        if ((i+1) % 10 == 0 && i != n-1)
        {
            printf("\n");
        }

        if ((i+1) % 50 == 0 && i != n-1)
            pause();
    }
}

void viderBuffer()
{
    while (getchar() != '\n') ;
}

void triSelection(int* tab, const int n)
{
    int i, ipp = 0, j = 0, buffer = 0;
    for (i = 0; i < n-1; i++)
    {
        ipp = i;
        for (j = i+1; j < n; j++)
        {
            if (tab[j] < tab[ipp])
                ipp = j;
        }
        if (ipp != i)
            swapVar(&tab[i], &tab[ipp]);
    }

}

void triBulle(int* tab, const int n)
{
    int i, borne, buffer = 0;
    for (borne = n - 1; borne >= 1; borne --)
    {
        for (i = 0; i < borne; i++)
        {
            if (tab[i] > tab[i+1])
            {
                swapVar(&tab[i+1], &tab[i]);
            }
        }
    }
}

void swapVar(int* a, int* b)
{
    int buffer = *a;
    *a = *b;
    *b = buffer;
}

int compare(const void *a, const void *b)
{
    const int *pa = a;
    const int *pb = b;
    return  *pa - *pb;
}

void pause()
{
    printf("Appuyez sur Entree pour continuer...\n");
    viderBuffer();
}
