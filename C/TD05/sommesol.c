/* sommesol.c qui se sert d'une procédure
 * et d'un pointeur pour faire une somme simple
 * Auteur : V. POIRIER le 08/10/2015 */
#include <stdio.h>

void somme(float x,float y,float *z); /* Déclaration(prototypage) de la procédure somme */

int main()
{
    float x, y, z;
    x = 2;
    y = 3;

    somme(x,y,&z);
    printf("%7.1f + %7.1f = %9.1f\n",x,y,z);

    return 0;
}

void somme(float x,float y,float *z) /* x et y passés par valeur, z passé par adresse */
{
    *z = x + y;
}

/*
Lorsqu'un programme est chargé en mémoire, il comporte 3 parties : code, data et stack (pile)

Partie code : pour la partie instructions présentée en langage d'assemblage
 cs : code segment ;    eip : extended instruction pointer
 cs : eip combinés constituent le compteur ordinal (adr. de la proch. instr. à exécuter)

Partie data : pour les données globales, initialisées, statiques et dynamiques (HEAP)
 ds : data segment;     esi : extended source index
 ds : esi combinés permettent de pointer vers une donnée de la partie data

Partie stack(pile) : pour les données locales, les arguments passés et les adresses de retour
 ss : stack segment;    esp : extended stack pointer
 ss : esp combinés permettent de pointer vers une donnée de la partie stack (au départ fond du puits)

edx : eax combinés servent à renvoyer le résultat lors d'un return valeur;
*/
