-- TD02
-- Auteurs :
-- POIRIER Vincent
-- ROTTEE Fanny
-- Préparation
clear screen;

-- ======= Suppression des tables ======= --
drop table nomenclature;
drop table ordre;
drop table service;
drop table piece;

-- ======= Création des tables ======= --
create table piece(
  nop number(3) constraint pk_piece primary key,
  designation varchar2(20) not null,
  couleur varchar2(15) not null,
  poids decimal(5,2) not null);
  
create table service(
  nos number(3) constraint pk_service primary key,
  intitule varchar2(20) not null,
  localisation varchar2(30) not null);
  
create table ordre(
  nop number(3) constraint fk_ordre_piece references piece(nop),
  nos number(3) constraint fk_ordre_service references service(nos),
  quantite number(3),
  constraint pk_ordre primary key (nop, nos));
  
create table nomenclature(
  nopa number(3) constraint fk_nomenclature_piece_a references piece(nop),
  nopc number(3) constraint fk_nomenclature_piece_c references piece(nop),
  quantite number(3),
  constraint pk_nomenclature primary key (nopa, nopc));

-- ======= Insertion des valeurs ======= --
delete from piece;

insert into piece
values (1, 'piece1', 'bleu', 852.12);
insert into piece
values (2, 'piece2', 'rouge', 721.14);
insert into piece
values (3, 'piece3', 'jaune', 126.87);
insert into piece
values (4, 'piece4', 'bleu', 100.00);
insert into piece
values (5, 'piece5', 'rouge', 250.25);
insert into piece
values (6, 'piece6', 'jaune', 488.61);

commit;

delete from service;

insert into service
values(1, 'lavage', 'lyon');
insert into service
values(2, 'repassage', 'lyon');
insert into service
values(3, 'restauration', 'paris');
insert into service
values(4, 'reparation', 'paris');
insert into service
values(5, 'maintenance', 'marseille');
insert into service
values(6, 'marketing', 'marseille');

commit; 

delete from ordre;

insert into ordre
values(1, 1, 1);
insert into ordre
values(1, 2, 2);
insert into ordre
values(1, 3, 1);
insert into ordre
values(2, 6, 3);
insert into ordre
values(3, 5, 5);
insert into ordre
values(4, 4, 1);
insert into ordre
values(4, 5, 3);
insert into ordre
values(5, 1, 3);
insert into ordre
values(5, 2, 1);
insert into ordre
values(6, 3, 1);

commit;

delete from nomenclature;

insert into nomenclature
values(1, 1, 1);
insert into nomenclature
values(1, 2, 2);
insert into nomenclature
values(1, 3, 1);
insert into nomenclature
values(2, 6, 3);
insert into nomenclature
values(3, 5, 5);
insert into nomenclature
values(4, 4, 1);
insert into nomenclature
values(4, 5, 3);
insert into nomenclature
values(5, 1, 3);
insert into nomenclature
values(5, 2, 1);
insert into nomenclature
values(6, 3, 1);

commit;