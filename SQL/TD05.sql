-- TD05
-- Auteurs :
-- LADEVIE Léo
-- POIRIER Vincent

-- Préparation
clear screen;

-- ======= Suppression des tables ======= --
drop table composition;
drop table bouquet;
drop table achat;
drop table fleur;
drop table dates;
drop table facture;
drop table commande;
drop table ville;
drop table client;

-- ======= Création des tables ======= --
create table client(
  numeroClient number constraint pk_client primary key,
  nomClient varchar2(20) not null,
  adresseClient varchar2(40) not null,
  codePostalClient varchar2(5) not null,
  villeClient varchar2(20) not null,
  tel varchar2(10) not null,
  constraint ck_client_codePostal check (length(codePostalClient) = 5),
  constraint ck_client_tel check (length(tel) = 10));
  
create table ville(
  codePostal varchar2(5) constraint pk_ville primary key,
  ville varchar2(20) not null,
  tarifLivraison number not null);

create table commande(
  numCommande number constraint pk_commande primary key,
  numeroClient number constraint fk_commande_client references client(numeroClient),
  codePostal varchar2(5) constraint fk_commande_ville references ville(codePostal),
  dateCommande date not null,
  nomLivraison varchar2(20) not null,
  dateLivraisonPrevue date not null,
  dateAcceptation date not null,
  dateLivraisonEffective date not null,
  datePaiement date not null);

create table facture(
  numFacture number constraint pk_facture primary key,
  numCommande number constraint fk_facture_commande references commande(numCommande),
  dateFacture date not null);

create table dates(
  dateAchat date constraint pk_tableDate primary key);

create table fleur(
  nomFleur varchar2(20) constraint pk_fleur primary key,
  tarifFleur number not null);
  
create table achat(
  dateAchat date constraint fk_achat_dates references dates(dateAchat),
  nomFleur varchar2(20) constraint fk_achat_fleur references fleur(nomFleur),
  prixAchat number not null,
  constraint pk_achat primary key (dateAchat,nomFleur));

create table bouquet(
  numeroBouquet number constraint pk_bouquet primary key,
  numCommande number constraint fk_bouquet_commande references commande(numCommande),
  nbrBouquet number not null);
  
create table composition(
  nomFleur varchar2(20) constraint fk_compo_fleur references fleur(nomFleur),
  numeroBouquet number constraint fk_compo_bouquet references bouquet(numeroBouquet),
  nbrFleurs number not null,
  constraint pk_compo primary key (nomFleur, numeroBouquet));

-- ======= Insertion des valeurs ======= --
delete from client;
insert into client
values (1, 'Cécile', '74, rue Pierre De Coubertin', '31300', 'Toulouse', '0541082991');
insert into client
values (2, 'Mathieu', '23, route de Lyon', '94200', 'Ivry-sur-Seine', '0166838024');
insert into client
values (3, 'Amélie', '1, rue des Nations Unies', '22000', 'Saint-Brieuc', '0214855780');
insert into client
values (4, 'Patrick', '51, rue de Penthièvre', '95000', 'Pontoise', '0335897357');
insert into client
values (5, 'Solaine', '49, rue Marguerite', '94350', 'Villiers-sur-Marne', '0104256828');

commit;

delete from ville;

insert into ville
values ('31300', 'Toulouse', 5);
insert into ville
values ('94200', 'Ivry-sur-Seine', 10);
insert into ville
values ('22000', 'Saint-Brieuc', 7.5);
insert into ville
values ('95000', 'Pontoise', 5);
insert into ville
values ('94350', 'Villiers-sur-Marne', 10);

commit;

delete from commande;

insert into commande
values (1, 1, '31300', '20/12/2014', 'Colombe', '30/12/2014', '30/12/2014', '30/12/2014', '30/12/2014');
insert into commande
values (2, 1, '31300', '21/12/2014', 'Basile', '31/12/2014', '31/12/2014', '31/12/2014', '31/12/2014');
insert into commande
values (3, 1, '31300', '20/02/2015', 'Samuel', '28/02/2015', '28/02/2015', '28/02/2015', '28/02/2015');
insert into commande
values (4, 1, '31300', '01/03/2015', 'Jonathan', '11/03/2015', '11/03/2015', '11/03/2015', '11/03/2015');
insert into commande
values (5, 2, '94200', '25/04/2015', 'Mylène', '05/05/2015', '05/05/2015', '05/05/2015', '05/05/2015');
insert into commande
values (6, 2, '94200', '10/05/2015', 'Régis', '20/05/2015', '20/05/2015', '20/05/2015', '20/05/2015');
insert into commande
values (7, 3, '22000', '11/05/2015', 'Roxane', '21/05/2015', '21/05/2015', '21/05/2015', '21/05/2015');
insert into commande
values (8, 4, '95000', '07/07/2015', 'Valérian', '17/07/2015', '17/07/2015', '17/07/2015', '17/07/2015');
insert into commande
values (9, 5, '94350', '05/09/2015', 'Jessica', '15/09/2015', '15/09/2015', '15/09/2015', '15/09/2015');
insert into commande
values (10, 5, '94350', '02/10/2015', 'Léo', '12/10/2015', '12/10/2015', '12/10/2015', '12/10/2015');

commit;

delete from facture;

insert into facture
values (1, 1, '12/01/2015');
insert into facture
values (2, 2, '22/02/2015');
insert into facture
values (3, 3, '28/02/2015');
insert into facture
values (4, 4, '11/03/2015');
insert into facture
values (5, 5, '05/05/2015');
insert into facture
values (6, 6, '20/05/2015');
insert into facture
values (7, 7, '21/05/2015');
insert into facture
values (8, 8, '17/07/2015');
insert into facture
values (9, 9, '15/09/2015');
insert into facture
values (10, 10, '12/10/2015');

commit;

delete from dates;

insert into dates
values('01/12/2014');

commit;

delete from fleur;

insert into fleur
values('Tulipe', 5);
insert into fleur
values('Rose', 10);
insert into fleur
values('Lys', 7);
insert into fleur
values('Lila', 10);
insert into fleur
values('Dahlia', 15);
insert into fleur
values('Coquelicot', 3);
insert into fleur
values('Pissenlit', 1);
insert into fleur
values('Paquerette', 2);

commit;

delete from achat;

insert into achat
values('01/12/2014', 'Tulipe', 100);
insert into achat
values('01/12/2014', 'Rose', 100);
insert into achat
values('01/12/2014', 'Lys', 100);
insert into achat
values('01/12/2014', 'Lila', 100);
insert into achat
values('01/12/2014', 'Dahlia', 100);
insert into achat
values('01/12/2014', 'Coquelicot', 100);
insert into achat
values('01/12/2014', 'Pissenlit', 100);
insert into achat
values('01/12/2014', 'Paquerette', 100);

commit;

delete from bouquet;

insert into bouquet
values(1, 1, 2);
insert into bouquet
values(2, 2, 1);
insert into bouquet
values(3, 3, 1);
insert into bouquet
values(4, 4, 2);
insert into bouquet
values(5, 5, 1);
insert into bouquet
values(6, 6, 2);
insert into bouquet
values(7, 7, 2);
insert into bouquet
values(8, 8, 1);
insert into bouquet
values(9, 9, 1);
insert into bouquet
values(10, 10, 1);
insert into bouquet
values(11, 10, 2);

commit;

delete from composition;

insert into composition
values('Tulipe', 1, 15);
insert into composition
values('Rose', 1, 5);
insert into composition
values('Rose', 2, 10);
insert into composition
values('Lila', 3, 1);
insert into composition
values('Dahlia', 4, 5);
insert into composition
values('Paquerette', 5, 6);
insert into composition
values('Tulipe', 6, 2);
insert into composition
values('Rose', 7, 10);
insert into composition
values('Lila', 8, 1);
insert into composition
values('Tulipe', 8, 1);
insert into composition
values('Rose', 8, 1);
insert into composition
values('Dahlia', 9, 1);
insert into composition
values('Dahlia', 10, 2);
insert into composition
values('Paquerette', 11, 5);

commit;

-- ======= Requêtes ======= --
-- R1
select count(*) as "Commandes payées en 2015"
from commande
where to_char(datePaiement, 'YYYY') = 2015;

-- R2
select * 
from (select codePostal
      from commande
      group by codePostal
      order by count(codePostal) desc)
where rownum <= 3;

-- R3
-- Si plusieurs fleurs ont été les plus utilisées, elles sont toutes affichées.
drop view utilisationFleur2014;
create view utilisationFleur2014 as (select nomFleur, sum(nbrFleurs) as utilisation
                                 from composition, bouquet, commande
                                 where bouquet.numeroBouquet = composition.numeroBouquet
                                   and bouquet.numCommande = commande.numCommande
                                   and to_char(dateAcceptation, 'YYYY') = 2014
                                 group by nomFleur);

select nomFleur
from utilisationFleur2014
where utilisation >= all (select utilisation
                          from utilisationFleur2014);

-- R4
select avg(count(numerobouquet)) as "Moyenne bouquets/client"
from client, commande, bouquet
where bouquet.numcommande = commande.numcommande
  and commande.numeroclient = client.numeroclient
group by nomclient;

-- R5
select nomFleur
from fleur
where nomFleur not in (select nomFleur from composition);

-- R6
-- Si un client a acheté autant de fois plusieurs fleurs, chaque fleur apparaitra
drop view compteFleurs;
create view compteFleurs as (select nomClient, nomFleur, sum(nbrFleurs * nbrBouquet) as nbrUtilisees
                             from client, commande, bouquet, composition
                             where client.numeroClient = commande.numeroClient
                               and bouquet.numCommande = commande.numCommande
                               and composition.numeroBouquet = bouquet.numeroBouquet
                             group by nomClient, nomFleur);
  
select x.nomClient, x.nomFleur
from compteFleurs x
join (select p.nomClient,
      max(nbrUtilisees) as max_somme
      from compteFleurs p
      group by p.nomClient) y on y.nomClient = x.nomClient
                              and y.max_somme = x.nbrUtilisees
group by x.nomClient, x.nomFleur
order by x.nomClient;

-- R7
-- Créez une vue vcom qui affiche le numéro de la commande, la date de la commande et le montant de la commande 
drop view vcom;
create view vcom as (select commande.numCommande, nomClient, datePaiement, sum(nbrBouquet * nbrFleurs * tarifFleur) as montantCommande
                     from client, commande, bouquet, composition, fleur
                     where client.numeroClient = commande.numeroClient 
                       and commande.numCommande = bouquet.numCommande
                       and bouquet.numeroBouquet = composition.numeroBouquet
                       and composition.nomFleur = fleur.nomFleur
                     group by commande.numCommande, nomClient, datePaiement);

-- R8
-- Affichez le nom du client qui a passé la commande la plus chère
-- Si plusieurs clients ont dépensé la somme maximale, ils sont tous affichés
select nomClient
from vcom
where montantCommande >= all (select montantCommande
                               from client, commande, vcom
                               where client.numeroClient = commande.numeroClient
                                 and commande.numCommande = vcom.numCommande);