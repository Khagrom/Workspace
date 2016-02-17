#include <stdio.h>
#include <unistd.h>

int main(int argc, char** argv) {
    char* ch = "Hello world\n";
    char* err = "Erreur d'écriture\n";

    int s = write(1, ch, 12);
    if (s < 0) {
        write(2, err, 18);
        return 1;
    }
    return 0;
}