/* hello.c pour illustrer des notions de base
 AUTEUR: M.RAMBURRUN le 14/09/2015*/

 #include <stdio.h>
 int main()
 {
     int i = 2500;
     char c ='A'; /* ou c = 65; (base 10) ou c = 0x41 (base 16) ou c = 0101 (base 8) */
     c = c + 1;
     printf("i = %3d; c = %c; c = %d\n",i,c,c);
     printf("taille de i en nb d'octets = %d\n", sizeof(i));
     return 0;
 }
