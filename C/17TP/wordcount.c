#include <stdio.h>
#include <stdlib.h>
int estSeparateur(const char c, const char* listeSep);
int count(int* c_Mot, int* c_Ligne, int* c_Caractere, const char* path, const char* listeSep);
#define NBSEPARATEURS 35

int main(int argc, const char *argv[])
{
    int cptMot = 0;
    int cptLigne = 0;
    int cptCaractere = 0;

    char listeSeparateurs[NBSEPARATEURS] = {' ', '"', '=', '+', '-', '*', '/', '\'', '\\',
                                            ',', '.', ';', ':', '[', ']', '{', '}', '|',
                                            '(', ')', '<', '>', '&', '%', '@', '`', '_',
                                            '#', '^', '!', '?', '~', '\t', '\n', EOF
                                           };

    if (argc == 1)
    {
        printf("Il manque un argument (fichier de donnees).\n");
        exit(1);
    }
    else if (argc == 2)
    {
        if(count(&cptMot, &cptLigne, &cptCaractere, argv[1], listeSeparateurs))
        {
            printf("Erreur !\n");
            exit(2);
        }
        printf("%d mots, %d lignes, %d caracteres.\n", cptMot, cptLigne, cptCaractere);
    }
    else
    {
        printf("Il y a trop d'arguments.\n");
        exit(1);
    }

    return 0;
}

int estSeparateur(const char c, const char* listeSep)
{
    int i;
    for (i = 0; i < NBSEPARATEURS; i++)
    {
        if (listeSep[i] == c)
            return 1;
    }
    return 0;
}

int count(int* c_Mot, int* c_Ligne, int* c_Caractere, const char* path, const char* listeSep)
{
    FILE *file = NULL;
    file = fopen(path, "r");

    if (file == NULL)
    {
        printf("Le fichier %s ne s'est pas ouvert correctement ou n'existe pas.\n", path);
        return 1;
    }

    int cpt_Mot = 0;
    int cpt_Ligne = 0;
    int cpt_Caractere = 0;
    char est_separateur_precedent = 0;
    char est_separateur_courant = 0;
    char curChar = 0;

    while (curChar != EOF)
    {
        curChar = fgetc(file);
        est_separateur_courant = estSeparateur(curChar, listeSep);
        if(curChar == EOF)
            est_separateur_courant = 1;
        if(est_separateur_courant && !est_separateur_precedent && cpt_Caractere != 0)
            cpt_Mot++;
        if(curChar == '\n' || curChar == EOF)
            cpt_Ligne++;

        cpt_Caractere++;
        est_separateur_precedent = est_separateur_courant;
        est_separateur_courant = 0;
    }
    cpt_Caractere--;

    *c_Mot = cpt_Mot;
    *c_Ligne = cpt_Ligne;
    *c_Caractere = cpt_Caractere;
    return 0;
}
