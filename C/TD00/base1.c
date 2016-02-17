/* base1.c */
#include <stdio.h>
#include <math.h>

/* déclaration de la fonction calcul */
 double calcul(double x);

int main()
{
    double x;

    printf("Entrer une valeur pour le reel x : ");
    scanf("%lg%*c", &x);   /*   &x signifie adresse de x */

    printf("calcul( %.1f ) = %.1f\n", x, calcul(x)); /* utilisation de la fonction calcul(x)*/
    return 0;
}

/* définition de la fonction calcul
   en entrée : x de type double
   résultat  : double
*/
double calcul( double x )
{
  return x * x * x + pow(x,1.0/3) + sqrt(x) + 50.0;
}
