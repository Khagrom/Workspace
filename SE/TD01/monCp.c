#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#define BUF_SIZE 10000
#define NUM_ARGS 3

int main(int argc, char** argv) {
    int f_dest = 0, f_source = 0;
    int nb_car_lu = 0, nb_car_ecrit = 0;
    char* buffer = malloc(BUF_SIZE * sizeof(char));

    if (argc != NUM_ARGS) {
        fprintf(stderr, "Incorrect number of arguments.\n");
        fprintf(stderr, "Expected %d\n", NUM_ARGS);
        fprintf(stderr, "Found %d\n", argc);
        return NUM_ARGS;
    }

    f_source = open(argv[1], O_RDONLY);
    if (f_source == -1) {
        fprintf(stderr, "Error while opening %s.\n", argv[1]);
        return 1;
    }

    f_dest = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC, 00664);
    if (f_dest == -1) {
        fprintf(stderr, "Error while opening %s.\n", argv[2]);
        return 1;
    }


    do {
        nb_car_lu = read(f_source, buffer, BUF_SIZE);

        if (nb_car_lu < 0) {
            fprintf(stderr, "Error when reading source file.\n");
            return 20;
        }

        nb_car_ecrit = write(f_dest, buffer, nb_car_lu);
        if (nb_car_ecrit != nb_car_lu) {
            fprintf(stderr, "Error when writing destination file.\n");
            return 21;
        }
    } while (nb_car_lu > 0);

    close(f_dest);
    close(f_source);
    return 0;
}