#include <sys/types.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>

int main(void)
{
  pid_t pid;
  int etat, i;

  for (i=0; i<3; i++){
    pid=fork();
    if (pid==-1){
      perror("Erreur à l'appel de fork\n");
      exit(1);
    }
    else if (pid==0)
      printf("Mon PID est %d et i=%d\n",getpid(),i);
    else 
      printf("Mon PID est %d et i=%d\n",getpid(),i);
  }
  pid = wait(&etat);
  while (pid > 0){
    printf("Le processus %d a fini de s'executer\n",pid);
    pid = wait(&etat);
    }
  exit(0);
}
