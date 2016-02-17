-- Révision DS Final POIRIER
-- Préparation
clear screen;

-- ======= Suppression des tables ======= --
drop table rencontre;
drop table gains_tournoi;
drop table joueur;

-- Question 1
-- ======= Création des tables ======= --
create table joueur(
  numj number(4) constraint pk_joueur primary key,
  nom varchar2(20) not null,
  prenom varchar(20) not null,
  age number(3) not null,
  nationalite varchar2(40) not null,
  sexe varchar2(1),
  constraint ck_age_joueur check (age >= 16),
  constraint ck_sexe_joueur check (sexe in ('F', 'M')));

create table gains_tournoi(
  numj number(4) constraint fk_gains_joueur references joueur(numj),
  lieutournoi varchar2(40),
  annee number(4),
  primecumulee number(7) not null,
  nomsponsor varchar2(40) not null,
  constraint pk_gains primary key (numj, lieutournoi, annee),
  constraint ck_prime_gains check (primecumulee <= 1500000 and primecumulee >= 1000));
  
create table rencontre(
  numr number(3) constraint pk_rencontre primary key,
  numgagnant number(4) constraint fk_rencontre_gagnant references joueur(numj),
  numperdant number(4) constraint fk_rencontre_perdant references joueur(numj),
  lieutournoi varchar2(40) not null,
  annee number(4) not null,
  score varchar2(20) not null);

delete from joueur;

insert into joueur 
values (1, 'Aihasset', 'Jean', 22, 'Française', 'M');
insert into joueur 
values (2, 'Nard', 'Jessica', 21, 'Belge', 'F');
insert into joueur 
values (3, 'Aire', 'Axel', 28, 'Suisse', 'M');
insert into joueur 
values (4, 'Tare', 'Maguy', 22, 'Américaine', 'F');
insert into joueur 
values (5, 'Berter', 'Laly', 25, 'Française', 'F');
insert into joueur 
values (6, 'Ate', 'Tom', 25, 'Espagnole', 'M');
insert into joueur 
values (7, 'Onnout', 'Mary', 30, 'Australienne', 'F');

commit;

delete from rencontre;

insert into rencontre 
values (1, 1, 2, 'Roland Garros', 1985, '3-2');
insert into rencontre 
values (2, 1, 3, 'Roland Garros', 1985, '3-2');
insert into rencontre 
values (3, 2, 3, 'Roland Garros', 1985, '3-1');
insert into rencontre 
values (4, 1, 4, 'Wimbledon', 1986, '3-1');
insert into rencontre 
values (5, 1, 5, 'Wimbledon', 1986, '3-2');
insert into rencontre 
values (6, 4, 5, 'Wimbledon', 1986, '3-1');
insert into rencontre 
values (7, 5, 6, 'US Open', 1968, '3-1');
insert into rencontre 
values (8, 4, 1, 'US Open', 1968, '3-1');

commit;

delete from gains_tournoi;

insert into gains_tournoi
values (1, 'Roland Garros', 1985, 900000, 'Afflelou');
insert into gains_tournoi
values (2, 'Roland Garros', 1985, 200000, 'Peugeot');
insert into gains_tournoi
values (3, 'Roland Garros', 1985, 200000, 'Afflelou');
insert into gains_tournoi
values (1, 'Wimbledon', 1986, 500000, 'Adidas');
insert into gains_tournoi
values (4, 'Wimbledon', 1986, 900000, 'BNP Paribas');
insert into gains_tournoi
values (5, 'Wimbledon', 1986, 700000, 'Afflelou');
insert into gains_tournoi
values (6, 'US Open', 1968, 100000, 'Peugeot');

commit;

-- ======= Réponse aux requêtes ======= --
-- Question 2
insert into joueur
values (102, 'Larsen', 'Jane', 21, 'Danoise', 'F');
commit;

-- Question 3
update joueur
set age = age + 1;
commit;

-- Question 4
select nom, prenom, primecumulee
from joueur, gains_tournoi
where joueur.numj = gains_tournoi.numj
  and annee >= 2004
  and annee <= 2012
  and gains_tournoi.numj in (select numj
                             from gains_tournoi
                             where nomsponsor = 'Peugeot')
order by primecumulee desc;

-- Question 5
select distinct nom, prenom, age
from joueur, rencontre
where (numj = numgagnant 
  or numj = numperdant)
  and lieutournoi = 'Roland Garros'
  and annee = 2012
order by nom;

-- Question 6
select distinct nom, prenom, age
from joueur, rencontre
where (numj = numgagnant 
  or numj = numperdant)
  and (numj in (select numgagnant
                      from rencontre
                      where lieutournoi = 'Roland Garros')
       or numj in (select numperdant
                      from rencontre
                      where lieutournoi = 'Roland Garros'))
  and (numj in (select numgagnant
                      from rencontre
                      where lieutournoi = 'Wimbledon')
       or numj in (select numperdant
                      from rencontre
                      where lieutournoi = 'Wimbledon'))
  and annee = 2012
order by nom;

-- Question 7
-- J'avoue c'est plutôt moche mais bon
select distinct nom, prenom
from joueur, gains_tournoi
where joueur.numj = gains_tournoi.numj
  and joueur.numj in (select numj
                      from gains_tournoi
                      where lieutournoi = 'Roland Garros'
                        and primecumulee >= 500000)
  and joueur.numj not in (select numj
                      from gains_tournoi
                      where lieutournoi = 'Roland Garros'
                        and primecumulee < 500000);
                        
-- Question 8
select distinct nom, prenom
from joueur, rencontre
where (numj = numgagnant 
   or numj = numperdant)
  and numj in (select numgagnant
                 from rencontre
                where lieutournoi = 'Roland Garros')
  and numj in (select numperdant
                 from rencontre
                where lieutournoi = 'Wimbledon');
                
-- Question 9
select A.numj as "A toujours gagné contre >", B.numj as "A toujours perdu contre <"
from joueur A, joueur B;

-- Question 10
select annee, round(avg(primecumulee),2) as "Moyenne des primes par année"
from gains_tournoi
group by annee
order by annee;
