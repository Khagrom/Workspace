-- DS2 POIRIER
-- Préparation
clear screen;

-- ======= Suppression des tables ======= --
drop table PParticipation;
drop table NNumero;
drop table CCostume;
drop table AAccessoire;
drop table CCPersonne;

-- ======= Importation des tables ======= --
create table CCPersonne as select * from benslimane.cpersonne;
create table AAccessoire as select * from benslimane.accessoire;
create table CCostume as select * from benslimane.costume;
create table NNumero as select * from benslimane.numero;
create table PParticipation as select * from benslimane.participation;

-- ======= Création des tables ======= --
/*create table CPersonne(
  nomPersonne varchar2(20) constraint pk_cpersonne primary key,
  role varchar2(20) not null);
  
create table Accessoire(
  nomAccessoire varchar2(20) constraint pk_accessoire primary key,
  couleur varchar2(20) not null,
  volume number not null,
  camion number not null);

create table Costume(
  nomCostume varchar2(20) constraint pk_costume primary key,
  couleur varchar2(20) not null,
  volume number not null,
  camion number not null);
  
create table Numero(
  nomNumero varchar2(20) constraint pk_numero primary key,
  nature varchar2(20) not null,
  responsable varchar2(20) constraint fk_numero_cpersonne references CPersonne(nomPersonne));
  
create table Participation(
  nomNumero varchar2(20) constraint fk_participation_numero references Numero(nomNumero),
  nomPersonne varchar2(20) constraint fk_participation_cpersonne references CPersonne(nomPersonne),
  nomAccessoire varchar2(20) constraint fk_participation_accessoire references Accessoire(nomAccessoire),
  constraint pk_participation primary key (nomNumero, nomPersonne, nomAccessoire));*/
  
-- ======= Requêtes ======= --
-- Question 3
update AAccessoire
set couleur = upper(couleur);
commit;

-- Question 4
select nomPersonne
from CCPersonne
where role = 'Equilibriste' or role = 'Jongleur';

-- Question 5
select distinct nomPersonne
from PParticipation
where nomAccessoire not in (select nomAccessoire 
                              from AAccessoire
                              where couleur = 'ROUGE');

-- Question 6
drop view nbCamions;
create view nbCamions as ((select camion, count(camion) compteCamion
                           from CCostume
                           group by camion)
                           union
                          (select camion, count(camion) compteCamion
                           from AAccessoire
                           group by camion));
                           
select camion from (select camion, sum(compteCamion) somme
                    from nbCamions 
                    group by camion)
where somme >= all (select sum(compteCamion) somme
                    from nbCamions 
                    group by camion);
                    
-- Question 7
select distinct AAccessoire.nomAccessoire, camion
from AAccessoire, PParticipation
where AAccessoire.nomAccessoire = PParticipation.nomAccessoire
and nomNumero like 'Les Z%';

-- Question 8
select responsable from (select responsable, count(responsable) nbNumeros
                         from NNumero
                         group by responsable)
where nbNumeros >= all (select count(responsable) nbNumeros
                        from NNumero
                        group by responsable);
                        
-- Question 9
select camion, sum(volume) volumeTotalAccessoire
from AAccessoire
group by camion
order by camion;

-- Question 10
select nomAccessoire
from (select nomAccessoire, count(nomAccessoire) apparitionAccessoire 
      from (select nomNumero, nomAccessoire
            from PParticipation
            group by nomAccessoire, nomNumero)
      group by nomAccessoire)
where apparitionAccessoire = (select count(nomNumero)
                              from NNumero);

-- Question 11
select count(distinct nomPersonne)
from PParticipation, NNumero
where PParticipation.nomNumero = NNumero.nomNumero
  and nature = 'Jonglerie';