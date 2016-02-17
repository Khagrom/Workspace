-- TP4 POIRIER
-- Préparation
clear screen;

-- ======= Suppression des tables ======= --
drop table achats;
drop table acheteurs;
drop table recolte;
drop table producteurs;
drop table vins;

-- Question 1
-- ======= Création des tables ======= --
create table vins(
  nvin number constraint pk_vins primary key,
  nomcru varchar2(20) not null,
  annee number not null,
  degres number,
  prix number,
  constraint ck_vins_annee check (annee > 1980));
  
create table producteurs(
  refprod number constraint pk_prod primary key,
  nomprod varchar2(20) not null,
  region varchar2(20) not null);
  
create table recolte(
  nvrec number constraint fk_rec_vins references vins(nvin),
  refprod number constraint fk_rec_prod references producteurs(refprod),
  daterec date,
  qtrec number not null,
  constraint pk_rec primary key (nvrec, refprod, daterec));
  
create table acheteurs(
  numach number constraint pk_achet primary key,
  nomach varchar2(20) not null,
  typbuv varchar2(20) not null,
  constraint ck_typbuv_achet check (typbuv in ('PETIT', 'MOYEN', 'GROS')));
  
create table achats(
  numachat number constraint pk_achats primary key,
  nvin number constraint fk_achat_vin references vins(nvin),
  nachet number constraint fk_achat_achet references acheteurs(numach),
  qte number not null constraint ck_achat_qte check (qte > 0));


-- Question 2  
delete from vins;

insert into vins 
values (1, 'St Amour', 1983, 11.5, 31);
insert into vins
values (2, 'Pomerol', 1982, 11.6, 29);
insert into vins
values (3, 'Chenas', 1986, 11.3, 32.5);
insert into vins
values (4, 'Gamay', 1985, 11.4, 26);
insert into vins
values (5, 'Riesling', 1983, 11.9, 23.5);
insert into vins
values (6, 'Meursault', 1986, 11.2, 44);
insert into vins
values (7, 'Sauternes', 1984, 12.1, 51);
insert into vins
values (8, 'Brouilly', 1987, 12.3, 38);
insert into vins
values (9, 'Bergerac', 1981, 12.5, 32);
insert into vins
values (10, 'Apremont', 1985, 13.2, 22);
insert into vins
values (11, 'Muscadet', 1988, 0, 22.5);
insert into vins
values (12, 'Fleurie', 1982, 11.3, 37);
insert into vins
values (13, 'Sylvaner', 1985, 11.9, 26);
insert into vins
values (14, 'Cahors', 1988, 13.2, 19.70);

commit;

delete from producteurs;

insert into producteurs
values (1, 'Knock', 'BEAUJOLAIS');
insert into producteurs
values (2, 'Marchand', 'LOIRE');
insert into producteurs
values (3, 'Bouteiller', 'BORDEAUX');
insert into producteurs
values (4, 'Smith', 'SUD-OUEST');
insert into producteurs
values (5, 'Delors', 'ALSACE');
insert into producteurs
values (6, 'Wagner', 'BEAUJOLAIS');
insert into producteurs
values (7, 'Lepatre', 'SAVOIE');
insert into producteurs
values (8, 'Martin', 'BORDEAUX');
insert into producteurs
values (9, 'Duchemin', 'BOURGOGNE');
insert into producteurs
values (10, 'Chevalier', 'BOURGOGNE');
insert into producteurs
values (11, 'Bresson', 'BEAUJOLAIS');
insert into producteurs
values (12, 'Ravel', 'SUD-OUEST');
insert into producteurs
values (13, 'Muguet', 'ALSACE');

commit;

delete from acheteurs;

insert into acheteurs
values (1, 'Hardy', 'GROS');
insert into acheteurs
values (2, 'Duchene', 'MOYEN');
insert into acheteurs
values (3, 'Benardin', 'PETIT');
insert into acheteurs
values (4, 'Dreyfus', 'PETIT');
insert into acheteurs
values (5, 'Letilleul', 'MOYEN');
insert into acheteurs
values (6, 'Marinio', 'GROS');
insert into acheteurs
values (7, 'Dubois', 'GROS');
insert into acheteurs
values (8, 'Bussy', 'MOYEN');
insert into acheteurs
values (9, 'Williams', 'PETIT');
insert into acheteurs
values (10, 'Duhameau', 'GROS');
insert into acheteurs
values (11, 'Wolf', 'PETIT');
insert into acheteurs
values (12, 'Henriot', 'MOYEN');
insert into acheteurs
values (13, 'Richard', 'MOYEN');
insert into acheteurs
values (14, 'Thomas', 'PETIT');
insert into acheteurs
values (15, 'Larue', 'GROS');

commit;

delete from recolte;

insert into recolte
values (1, 1, '15/09/83', 62);
insert into recolte
values (1, 6, '17/09/83', 158);
insert into recolte
values (2, 3, '29/08/82', 25);
insert into recolte
values (3, 11, '05/10/86', 130);
insert into recolte
values (3, 1, '10/10/86', 45);
insert into recolte
values (3, 5, '07/10/86', 94);
insert into recolte
values (4, 9, '26/10/85', 148);
insert into recolte
values (4, 10, '22/10/85', 45);
insert into recolte
values (5, 5, '21/08/83', 50);
insert into recolte
values (5, 13, '21/08/83', 110);
insert into recolte
values (6, 9, '30/08/86', 30);
insert into recolte
values (6, 10, '16/08/86', 135);
insert into recolte
values (7, 3, '05/09/84', 120);
insert into recolte
values (7, 8, '11/09/84', 30);
insert into recolte
values (8, 11, '20/09/87', 100);
insert into recolte
values (8, 11, '23/09/87', 62);
insert into recolte
values (9, 4, '23/09/81', 90);
insert into recolte
values (9, 12, '23/09/81', 75);
insert into recolte
values (10, 7, '02/09/85', 11);
insert into recolte
values (11, 2, '02/09/85', 0);
insert into recolte
values (12, 6, '02/10/82', 45);
insert into recolte
values (13, 5, '19/10/85', 93);

commit;

delete from achats;

insert into achats
values (1, 1, 9, 12);
insert into achats
values (2, 1, 4, 7);
insert into achats
values (3, 1, 1, 10);
insert into achats
values (4, 1, 5, 12);
insert into achats
values (5, 1, 6, 9);
insert into achats
values (6, 2, 8, 5);
insert into achats
values (7, 3, 9, 8);
insert into achats
values (8, 3, 3, 15);
insert into achats
values (9, 3, 10, 24);
insert into achats
values (10, 4, 1, 9);
insert into achats
values (11, 4, 6, 8);
insert into achats
values (12, 4, 6, 8);
insert into achats
values (13, 4, 4, 48);
insert into achats
values (14, 5, 11, 4);
insert into achats
values (15, 6, 15, 4);
insert into achats
values (16, 6, 6, 12);
insert into achats
values (17, 7, 9, 8);
insert into achats
values (18, 7, 4, 18);
insert into achats
values (19, 7, 11, 24);
insert into achats
values (20, 7, 15, 4);
insert into achats
values (21, 8, 1, 10);
insert into achats
values (22, 8, 1, 10);
insert into achats
values (23, 9, 10, 12);
insert into achats
values (24, 9, 6, 9);
insert into achats
values (25, 11, 3, 15);
insert into achats
values (26, 12, 2, 4);
insert into achats
values (27, 12, 4, 4);
insert into achats
values (28, 13, 9, 12);

commit;

-- ======= Réponse aux requêtes ======= --
-- Question 3.1
select *
from vins
order by nomcru;

-- Question 3.2
select distinct region
from producteurs
order by region;

-- Question 3.3
select refprod, nomprod
from producteurs
where region in ('SAVOIE', 'BEAUJOLAIS');

-- Question 3.4
select nomach as SOBRE
from acheteurs
where typbuv = 'PETIT';

-- Question 3.5
select nvin as vin, nachet
from achats
order by vin, nachet desc;

-- Question 3.6
drop table jeune;
create table jeune as
  select nomcru, degres
  from vins
  where annee >= 1985;

-- Question 4.1
select distinct nachet
from achats, vins
where prix > 30 and achats.nvin = vins.nvin
order by nachet;

-- Question 4.2
select distinct nomcru, nomprod, region
from vins, producteurs, recolte
where vins.nvin = recolte.nvrec 
  and producteurs.refprod = recolte.refprod
  and (recolte.refprod, recolte.nvrec) in (select refprod, nvrec
                                           from recolte
                                           group by refprod, nvrec
                                           having sum(qtrec) > 100)
order by nomprod;

-- Question 4.3
select distinct nomcru
from vins, producteurs, recolte
where vins.nvin = recolte.nvrec 
  and producteurs.refprod = recolte.refprod 
  and region = 'BOURGOGNE';
  
-- Question 4.4
select count(*) as "Nombre de buveurs moyens"
from acheteurs
where typbuv = 'MOYEN';

-- Question 4.5
select count(*) as compte, sum(qte) as somme
from achats
where nvin = 7;

-- Question 4.6
select sum(vins.prix*qte) as "Prix à payer"
from achats, acheteurs, vins
where nachet = numach 
  and vins.nvin = achats.nvin 
  and nomach = 'Hardy';
  
-- Question 4.7
select avg(vins.prix) as "Prix moyen"
from vins, achats
where vins.nvin = achats.nvin and achats.nachet = 9;

-- Question 4.8
select distinct nomprod
from producteurs, (select refprod
                   from recolte
                   group by refprod, nvrec
                   having sum(qtrec) = 45) refp
where producteurs.refprod = refp.refprod;

-- Question 4.9
select distinct nomach
from achats, acheteurs
where achats.nachet = acheteurs.numach
  and nachet in (select nachet
                 from achats
                 where nvin = 1)
  and nachet in (select nachet
                 from achats
                 where nvin = 7)
  and nachet in (select nachet
                 from achats
                 where nvin = 12);

-- Question 4.10
select distinct nomcru
from achats, vins
where vins.nvin not in (select distinct nvin
                        from achats);

-- Question 4.11
select distinct nomcru
from achats, vins, acheteurs
where achats.nvin = vins.nvin 
  and acheteurs.numach = achats.nachet
  and annee < 1984 and typbuv != 'PETIT';
  
-- Question 4.12
select nomach
from acheteurs
where numach in (select nachet
                 from achats
                 group by nachet
                 having sum(qte) > (select avg(s)
                                    from (select nachet, sum(qte) as s
                                          from achats
                                          group by nachet)))
order by nomach;

-- Question 4.13
select distinct nachet
from achats
where nachet not in (select nachet
                     from achats, vins
                     where achats.nvin = vins.nvin 
                       and nomcru = 'St Amour')
order by nachet;
                            
                 