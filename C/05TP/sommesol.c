/* sommesol.c qui se sert d'une proc�dure
 * et d'un pointeur pour faire une somme simple
 * Auteur : V. POIRIER le 08/10/2015 */
#include <stdio.h>

void somme(float x,float y,float *z); /* D�claration(prototypage) de la proc�dure somme */

int main()
{
    float x, y, z;
    x = 2;
    y = 3;

    somme(x,y,&z);
    printf("%7.1f + %7.1f = %9.1f\n",x,y,z);

    return 0;
}

void somme(float x,float y,float *z) /* x et y pass�s par valeur, z pass� par adresse */
{
    *z = x + y;
}

/*
Lorsqu'un programme est charg� en m�moire, il comporte 3 parties : code, data et stack (pile)

Partie code : pour la partie instructions pr�sent�e en langage d'assemblage
 cs : code segment ;    eip : extended instruction pointer
 cs : eip combin�s constituent le compteur ordinal (adr. de la proch. instr. � ex�cuter)

Partie data : pour les donn�es globales, initialis�es, statiques et dynamiques (HEAP)
 ds : data segment;     esi : extended source index
 ds : esi combin�s permettent de pointer vers une donn�e de la partie data

Partie stack(pile) : pour les donn�es locales, les arguments pass�s et les adresses de retour
 ss : stack segment;    esp : extended stack pointer
 ss : esp combin�s permettent de pointer vers une donn�e de la partie stack (au d�part fond du puits)

edx : eax combin�s servent � renvoyer le r�sultat lors d'un return valeur;
*/
