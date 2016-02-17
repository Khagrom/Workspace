-- Introduction
-- Préparation
clear screen;
create table cours as select * from benslimane.cours;
create table enseignant as select * from benslimane.enseignant;
create table etudiant as select * from benslimane.etudiant;
create table inscrit as select * from benslimane.inscrit;
create table obtenu as select * from benslimane.obtenu;
create table personne as select * from benslimane.personne;
create table prerequis as select * from benslimane.prerequis;

-- Trucs cools
select * from cours;
select nomC, cycle, Nens from cours;
select nom, adr from personne;
select NE, nomC, note*1.2, annee from Obtenu;
select NE as numetudiant, nomC, note*2 as noteFinale, annee from Obtenu;
select * from personne order by adr asc;
select * from personne order by adr asc, nom desc;
select distinct NE from obtenu;
select * from cours where cycle = 2 and nomC='BD';
select * from cours where cycle = 1 and nomC like 'a%';
select * from cours where cycle = 1 and nomC not like 'a%';
select * from personne, enseignant;
select * from personne, enseignant where personne.NP = enseignant.NP;
select Personne.NP, nom from personne, enseignant where personne.NP = enseignant.NP;
select Personne.NP, nom from personne, enseignant where personne.NP = enseignant.NP and enseignant.NP=3333;
select distinct R1.NE from obtenu R1, obtenu R2 where R1.NE = R2.NE and R1.nomc != R2.nomC;
select NP from personne intersect select NP from etudiant;

-- D'autres trucs cools
select count(NP) from etudiant;
select count(*) from etudiant;
select count(distinct NE)as nombreEtudiants from obtenu;
select count(NE) from obtenu;
select count(NP) as nombre_total from etudiant;
select max(note) as maxalgo, min(note) as minalgo from obtenu where nomC='algo';
select max(note) as maxalgo, NE from obtenu where nomC='algo' group by NE;
select NE, count(*) as nbre_cours_obtenus from obtenu group by NE;
select NE, count(*) as nbre_cours_obtenus from obtenu where nomC!='algo' group by NE;
select adr from personne group by adr having count(*)>1;
select * from obtenu, (select * from cours where nomc!='système') C where obtenu.nomC=C.nomC;
select NE from obtenu where note >= all (select note from obtenu);
select NE from obtenu where note in (select distinct max(note) from obtenu);