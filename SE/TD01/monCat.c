#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#define BUF_SIZE 1

int main(int argc, char** argv) {
    int nb_car_lu = 0, nb_car_ecrit = 0;
    char* buffer = malloc(BUF_SIZE * sizeof(char));

    do {
        nb_car_lu = read(0, buffer, BUF_SIZE);

        if (nb_car_lu == 0) {
            printf("\n");
            return 0;
        }

        nb_car_ecrit = write(1, buffer, nb_car_lu);
        if (nb_car_ecrit != nb_car_lu) {
            fprintf(stderr, "Error while calling write(2).\n");
            return 1;
        }
    } while (buffer[0] != '\n');

    free(buffer);
    return 0;
}