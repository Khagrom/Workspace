#include "ligne_commande.h"

#include <stdlib.h>
#include <string.h>
#include <unistd.h> // fork(2),getpid(2)
#include <stdio.h> // perror(3),printf(3)
#include <sys/types.h> // getpid(2),wait(2)
#include <sys/wait.h> // wait(2)

int commandes_internes(char** cmd);

int main(int argc, char** argv) {
	
	setenv("INVITE", "> ", 1);
	pid_t pid;
	int state;
	
	while (1) {
		printf("%s", getenv("INVITE"));
		fflush(stdout);
		char** commande = lis_ligne();

		if (fin_de_fichier(commande)) {
			printf("Fin du programme...\n");
			return 0;
		} else {
			if (!ligne_vide(commande)) {
				if (!commandes_internes(commande)) {
					pid = fork();
					if (pid == 0) {
						if (execvp(commande[0], commande) == -1) {
							perror("Erreur, commande incorrecte.\n");
							exit(0);
						}
					} else {
						wait(&state);
					}
				}
			}
		}
	}
}

int commandes_internes(char** cmd) {
	
	if (!strcmp(cmd[0], "exit")) {
		printf("Fin du programme...\n");
		exit(0);
	}

	if (!strcmp(cmd[0], "cd")) {
		if (cmd[1]) {
			if (chdir(cmd[1]) == -1) {
				perror("Error");
			}
		} else {
				perror("Vous n'avez pas saisi d'arguments.\n");
		}
		
		return 1;
	}

	if (!strcmp(cmd[0], "export")) {
		if (cmd[1]) {
			char* value = separe_egal(cmd[1]);
			if (setenv(cmd[1], value, 1) == -1) {
				perror("Error");
			}
		}
		
		return 1;
	}
	
	return 0;
}
