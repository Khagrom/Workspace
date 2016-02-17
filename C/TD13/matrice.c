#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define CMAX 4
#define VALMAX 10
void lireMat(int v[][CMAX], const int n);
void initMat(int v[][CMAX], const int n);
int getElMat(const int i, const int j);
int getTailleMat(const char nom);
void printMat(int v[][CMAX], const int n);
void symMat(int v1[][CMAX], int v2[][CMAX], const int n);
void addMat(int v1[][CMAX], int v2[][CMAX], int v3[][CMAX], const int n);
void multMat(int v1[][CMAX], int v2[][CMAX], int v3[][CMAX], const int n);
void viderBuffer();
void pause();

int main ()
{
    srand(time(NULL));
    int ok = 0;
    int choix = 0;
    int n = 0;
    int v1[CMAX][CMAX];
    int v2[CMAX][CMAX];
    int v3[CMAX][CMAX];

    do
    {
        do
        {
            system("cls");
            printf("\n\tManipulation de matrices\n\n");
            printf("1...Lecture des matrices a et b\n");
            printf("2...Symetrie des matrices a et b\n");
            printf("3...Addition des matrices a et b\n");
            printf("4...Multiplication de la matrice a par la matrice b\n");
            printf("5...Multiplication de la matrice b par la matrice a\n");
            printf("6...Sortie\n\n");
            printf("Quel est votre choix ? ");
            ok = scanf("%d", &choix);
            viderBuffer();
        }
        while (!ok || choix > 6 || choix < 1);

        switch (choix)
        {
        case 1:
            n = getTailleMat('n');
            printf("Saisie des valeurs pour la matrice a...\n");
            lireMat(v1, n);
            printf("Saisie des valeurs pour la matrice b...\n");
            lireMat(v2, n);
            printf("Matrice a :");
            printMat(v1, n);
            printf("Matrice b :");
            printMat(v2, n);
            pause();
            break;
        case 2:
            printf("Matrice a :");
            printMat(v1, n);
            printf("Matrice b :");
            printMat(v2, n);
            symMat(v1, v3, n);
            printf("Symetrie de la matrice a :");
            printMat(v3, n);
            symMat(v2, v3, n);
            printf("Symetrie de la matrice b :");
            printMat(v3, n);
            pause();
            break;
        case 3:
            printf("Matrice a :");
            printMat(v1, n);
            printf("Matrice b :");
            printMat(v2, n);
            addMat(v1, v2, v3, n);
            printf("Resultat de l'operation :");
            printMat(v3, n);
            pause();
            break;
        case 4:
            printf("Matrice a :");
            printMat(v1, n);
            printf("Matrice b :");
            printMat(v2, n);
            multMat(v1, v2, v3, n);
            printf("Resultat de l'operation a * b :");
            printMat(v3, n);
            pause();
            break;
        case 5:
            printf("Matrice a :");
            printMat(v1, n);
            printf("Matrice b :");
            printMat(v2, n);
            multMat(v2, v1, v3, n);
            printf("Resultat de l'operation b * a :");
            printMat(v3, n);
            pause();
            break;
        case 6:
            return 0;
        }
    }
    while (choix != 6);

    return 0;

}

void lireMat(int v[][CMAX], const int n)
{
    int i, j;
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            v[i][j] = getElMat(i, j);
        }
    }
}

void initMat(int v[][CMAX], const int n)
{
    int i, j;
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            v[i][j] = (rand() - rand()) % VALMAX;
        }
    }
}

int getElMat(const int i, const int j)
{
    int ok = 0;
    int n = 0;
    do
    {
        printf("Saisissez v[%d][%d] : ", i, j);
        ok = scanf("%d", &n);
        viderBuffer();
    }
    while(!ok);

    return n;
}

int getTailleMat(const char nom)
{
    int ok = 0;
    int n = 0;
    do
    {
        printf("Entrez une taille %c <= %d : ", nom, CMAX);
        ok = scanf("%d", &n);
        viderBuffer();
    }
    while (!ok || n > CMAX || n < 0);

    return n;
}

void printMat(int v[][CMAX], const int n)
{
    printf("\n");
    int i, j;
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            printf("%7d ", v[i][j]);
        }
        printf("\n");
    }
    printf("\n");
}

void symMat(int v1[][CMAX], int v2[][CMAX], const int n)
{
    int i, j;
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            v2[i][j] = v1[j][i];
        }
    }
}

void addMat(int v1[][CMAX], int v2[][CMAX], int v3[][CMAX], const int n)
{
    int i, j;
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            v3[i][j] = v1[i][j] + v2[i][j];
        }
    }
}


void multMat(int v1[][CMAX], int v2[][CMAX], int v3[][CMAX], const int n)
{
    int i, j, k;
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            v3[i][j] = 0;
            for (k = 0; k < n; k++)
            {
                v3[i][j] += v1[i][k] * v2[k][j];
            }
        }
    }
}

void viderBuffer()
{
    while (getchar() != '\n') ;
}

void pause()
{
    printf("Appuyez sur Entree pour continuer...\n");
    viderBuffer();
}
