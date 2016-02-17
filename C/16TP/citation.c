#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
int getCitation(char *citation);
#define MAX_LENGTH 500

int main()
{
    int i;

    /* Une citation au hasard */
    srand(time(NULL));
    printf("Une citation au hasard :\n\n");
    char citation[MAX_LENGTH] = {0};
    getCitation(citation);
    printf("\t%s\n", citation);

    return 0;
}

int getCitation(char *citation)
{
    FILE *fichier_citations = NULL;
    fichier_citations = fopen("citations.txt", "r");

    int nbLignes = 0;
    char buffer[MAX_LENGTH] = {0};

    if(fichier_citations == NULL)
    {
        printf("Le fichier ne s'est pas ouvert correctement !");
        return 1;
    }

    while(fgets(buffer, MAX_LENGTH, fichier_citations) != NULL)
    {
        nbLignes++;
    }

    const int MIN = 1;
    const int MAX = nbLignes;
    int tirage = (rand() % MAX) + MIN;

    rewind(fichier_citations);

    while(tirage > MIN)
    {
        fgets(buffer, MAX_LENGTH, fichier_citations);
        tirage--;
    }

    fgets(citation, MAX_LENGTH, fichier_citations);
    citation[strlen(citation) - 1] = '\0';

    fclose(fichier_citations);
    return 0;
}
