/* signe.c pour déterminer si le nombre lu
au clavier est positif, négatif ou nul */

#include <stdio.h>

int main()
{
    double x;
    printf("entrer un nombre : ");
    scanf("%lg%*c", &x);

    if( x > 0 )           printf("%.1f est positif\n", x);
     else if ( x < 0 )  printf("%.1f est negatif\n", x);
            else            printf("%.1f est nul\n", x);

    return 0;

}
