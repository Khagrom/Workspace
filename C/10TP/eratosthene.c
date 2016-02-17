#include <stdio.h>
#include <stdlib.h>
#include <math.h>
void removeMultiples(int tab[], int nbDepart, int nbFin, int *cptBoucle);
void initTab(int tab[], int nbFin);
void afficheTab(int tab[], int n);
int plusGrandRestant(int tab[], int n);
void getNombre(int* a, char nom);
void viderBuffer();
#define NMAX 518954

int main() {
	int tab[NMAX];
    int n, cptBoucle;
    char again;

    do {
        system("cls");

        cptBoucle = 0;
        getNombre(&n, 'n');

        initTab(tab, n);
        int i;
        int grand = plusGrandRestant(tab, n);

        /* On considère qu'on commence à l'indice 2 (0 et 1 ne sont pas des nombres premiers).
            On s'arrête quand le carré du nombre actuel est plus grand que le plus grand entier restant.
         */
        for (i = 2; i * i <= grand; i++) {
            if (tab[i] != -1)
                removeMultiples(tab, i, n, &cptBoucle);
            grand = plusGrandRestant(tab, grand);
        }

        afficheTab(tab, n);
        printf("On est passe %d fois dans la boucle.\n", cptBoucle);
        printf("Recommencer ? (o/n) ");
        scanf("%c", &again);
    } while (tolower(again) == 'o');

	return 0;
}

void removeMultiples(int tab[], int nbDepart, int nbFin, int *cptBoucle) {
	int i;
    /* Le nombre de départ ne doit pas être rayé, on commence donc juste après, et on raye ceux qui sont
        multiples de notre nombre de départ (on met -1 dans la case).
     */
    for (i = nbDepart * nbDepart; i <= nbFin; i += nbDepart) {
        if (tab[i] % nbDepart == 0)
            tab[i] = -1;
        (*cptBoucle)++; /* On compte le nombre de passages dans la boucle */
    }
}

void initTab(int tab[], int nbFin) {
    int i;
    tab[0] = -1;
    tab[1] = -1;
    /* On initialise un tableau simple tel que chaque case contiendra en valeur son indice.
        En revanche on sait déjà que 0 et 1 ne sont pas des nombres premiers, on l'indique donc en les "rayant"
        (on met -1 dans la case et on se servira de ce test pour savoir si un nombre est "rayé").
     */
    for (i = 2; i <= nbFin; i++) {
        tab[i] = i;
    }
}

void afficheTab(int tab[], int n) {
    int i, cpt = 0, printed = 0;
    for (i = 0; i <= n; i++) {
        if (tab[i] != -1) {
            printf("%7d ", tab[i]); /* Idée pour récupérer longueur : division par puissances de dix successives
                                        tant que quotient > 0, on incrémente un compteur et la puissance de dix. */
            cpt++;
            printed = 0;
            /* On affiche un nombre sur trois caractères, on compte le nombre de nombres affichés et on
                indique que la dernière expression affichée n'est pas un retour chariot.
             */
        }
        if (cpt % 10 == 0 && !printed) {
            /* On affiche un retour chariot uniquement si on en a pas déjà affiché un et qu'on a déjà affiché
                dix nombres sur la ligne. On indique alors que le dernier caractère affiché est un retour chariot.
             */
            printf("\n");
            printed = 1;
        }

    }
    printf("\nOn a trouve %d nombres premiers.\n", cpt);
}

int plusGrandRestant(int tab[], int n) {
    /* On cherche le plus grand entier restant. Si la case actuelle contient -1, alors on a déjà rayé ce nombre.
        Il faut donc remonter dans le tableau d'une case, et ainsi de suite.
     */
    if (tab[n] != -1)
        return n;
    else
        return plusGrandRestant(tab, n-1);
}

void getNombre(int* a, char nom) {
    int ok = 0;
    int n = 0;
    do {
        printf("Saisissez %c < %d : ", nom, NMAX);
        ok = scanf("%d", &n);
        viderBuffer();
    } while (!ok || n >= NMAX || n < 0);

    *a = n;
}

void viderBuffer() {
    while (getchar() != '\n') ;
}
