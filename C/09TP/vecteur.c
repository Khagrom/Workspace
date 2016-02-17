#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <ctype.h>
void calculModules(double v[], int n, double *mod1, double *mod2, double *modinf);
void genAleat(double tab[], int n);
void afficheTab(double tab[], int n);
void getNombre(int* a, char nom);
void viderBuffer();
#define NB_MAX 50
#define VALMAX 32767

int main() {
	srand(time(NULL));

    double v[NB_MAX];
    int n = 0;
    const char nom = 'n';
    double mod1, mod2, modinf;
    char tryAgain;

    do {
        system("cls");

        mod1 = 0;
        mod2 = 0;
        modinf = 0;

        do {
            getNombre(&n, nom);
        } while (n > NB_MAX || n <= 0);
        genAleat(v, n);
        afficheTab(v, n);
        calculModules(v, n, &mod1, &mod2, &modinf);
        printf("\n\nCalcul des modules :");
        printf("\nmodule1 = %7.0f;\tmodule2 = %7.0f;\tmoduleInf = %7.0f\n", mod1, mod2, modinf);
        printf("\nVoulez-vous recommencer ? (o/n) ");
        scanf("%c", &tryAgain);
        viderBuffer();
        tryAgain = tolower(tryAgain);
    } while (tryAgain == 'o');
	return 0;
}

void calculModules(double v[], int n, double *mod1, double *mod2, double *modinf) {
    int i;
    double x;
    for (i = 0; i < n; i++) {
        x = fabs(v[i]);
        *mod1 += x;
        *mod2 += pow(x, 2);
        if (x > *modinf)
            *modinf = x;
    }
    *mod2 = sqrt(*mod2);
}

void genAleat(double tab[], int n) {
    int i;
    for (i = 0; i < n; i++) {
        tab[i] = (rand() - rand()) % VALMAX;
    }
}

void afficheTab(double tab[], int n) {
    int i;
    printf("\n[");
    for (i = 0; i < n; i++) {
        printf("%7.0f ", tab[i]);
        if ((i+1) % 10 == 0)
            printf("\n");
    }
    printf("]");
}

void getNombre(int* a, char nom) {
    int ok = 0;
    int n = 0;
    do {
        printf("Saisir le nombre d'elements %c du tableau (%c <= 50) : ", nom, nom);
        ok = scanf("%d", &n);
        viderBuffer();
    } while (!ok);

    *a = n;
}

void viderBuffer() {
    while (getchar() != '\n') ;
}
