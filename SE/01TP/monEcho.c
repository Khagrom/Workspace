#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
    int i;
    if (argc > 1) {
        for (i = 1; i < argc - 1; ++i) {
            if (printf("%s ", argv[i]) <= 0) {
                perror("Erreur écriture");
                exit(1);
            }
        }
        if (printf("%s", argv[i]) <= 0) {
            perror("Erreur écriture");
            exit(1);
        }
    }
    if (printf("\n") <= 0) {
        perror("Erreur écriture");
        exit(1);
    }
    return 0;
}