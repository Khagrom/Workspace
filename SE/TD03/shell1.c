#include "ligne_commande.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char** argv) {
	
	pid_t pid;
	int etat;
	
	while(1) {
		printf("> ");
		fflush(stdout);
		char** commande = lis_ligne();
		
		if(fin_de_fichier(commande)) {
			printf("Fin du programme...\n");
			return 0;
		} else {
			if(!ligne_vide(commande)) {
				if(!strcmp(commande[0], "exit")) {
					printf("Fin du programme...\n");
					return 0;
				}
				
				pid = fork();
				if(pid == 0) {
					if(execvp(commande[0], commande) == -1) {
						printf("Erreur, commande incorrecte.\n");
					}
					exit(0);
				} else {
					wait(&etat);
				}
			}
		}
	}
}
