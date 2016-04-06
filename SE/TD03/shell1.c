#include "ligne_commande.h"

#include <stdlib.h>
#include <string.h>
#include <unistd.h> // fork(2),getpid(2)
#include <stdio.h> // perror(3),printf(3)
#include <sys/types.h> // getpid(2),wait(2)
#include <sys/wait.h> // wait(2)

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
