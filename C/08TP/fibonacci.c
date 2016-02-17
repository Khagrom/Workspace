/* fibonacci.c pour calculer les nombres de Fibonacci
 * jusqu'� une limite d�finie
 */
#include<stdio.h>
#include<stdlib.h>
void calculFibo(int n);
char tryAgain();

int main()
{

    int n, ok;                  /* Saisie et v�rification de saisie */
    char again = 'n';           /* V�rification pour recommencer */

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
        calculFibo(n);          /* Appel de la proc�dure */
        again = tryAgain();     /* Appel de la fonction pour recommencer */
    }
    while (again == 'o');
    return 0;
}

/* Proc�dure principale */
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
