#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <fcntl.h>

int main(int argc, char** argv) {
	
	int fd = open(argv[1], O_RDWR | O_CREAT | O_TRUNC, 00664);
	if (fd == -1) {
		fprintf(stderr, "Error while opening %s.\n", argv[1]);
		return 1;
	}
	
	int fdDup;
	if (argv[0][7] == '0') fdDup = dup2(fd, 0);
	else if (argv[0][7] == '1') fdDup = dup2(fd, 1);
	else if (argv[0][7] == '2') fdDup = dup2(fd, 2);
	else {
		fprintf(stderr, "Incorrect calling of redir (%c).\n", argv[0][7]);
		return 1;
	}
	
	if (fdDup == -1) {
		fprintf(stderr, "Error while duplicating %s.\n", argv[1]);
		return 1;
	}
	
	if (execvp(argv[2], argv+2) == -1) {
		perror("Invalid command.\n");
		exit(0);
	}
	
	close(fd);
	return 0;
	
}
