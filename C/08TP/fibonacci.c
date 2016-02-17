/* fibonacci.c pour calculer les nombres de Fibonacci
 * jusqu'à une limite définie
 */
#include<stdio.h>
#include<stdlib.h>
void calculFibo(int n);
char tryAgain();

int main()
{

    int n, ok;                  /* Saisie et vérification de saisie */
    char again = 'n';           /* Vérification pour recommencer */

    do
    {
        system("cls");
        do
        {
            printf("Saississez le nombre de termes de Fibonacci a calculer : ");
            ok = scanf("%d",&n);
            while(getchar() != '\n');
        }
        while (!ok || n < 0);

        printf("\n");
        calculFibo(n);          /* Appel de la procédure */
        again = tryAgain();     /* Appel de la fonction pour recommencer */
    }
    while (again == 'o');
    return 0;
}

/* Procédure principale */
void calculFibo(int n)
{
    double first = 0, second = 1, next;
    int i;

    for (i = 0 ; i <= n ; i++)
    {
        if (i <= 1)
            next = i;
        else
        {
            next = first + second;
            first = second;
            second = next;
        }
        printf("F(%d) \t= %lg\n",i,next);
    }
}

/* Recommencer ? */
char tryAgain()
{
    int ok = 0;
    char n = 0;
    do
    {
        printf("\nVoulez-vous recommencer (o/n) ? ");
        ok = scanf("%c", &n);
        while(getchar() != '\n');
        n = (char) tolower(n);
    }
    while (!ok || (n != 'o' && n != 'n'));

    return n;
}
