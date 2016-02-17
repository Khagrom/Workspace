-- DS01
-- Auteur :
-- POIRIER Vincent

create table pilote as select * from benslimane.pilote;
create table avion as select * from benslimane.avion;
create table vol as select * from benslimane.vol;

-- Question 1
select distinct nompil
from pilote, vol
where vol.villedep = 'Lyon'
order by nompil;

-- Question 2
select nompil
from pilote
where adresse = 'Lyon'
  and salaire > 16000
order by nompil;

-- Question 3
select nompil
from pilote
where nompil not like '_____'
order by nompil;

-- Question 4
select count(nompil) as "Nombre de pilotes"
from pilote, vol
where pilote.numpil = vol.numpil
  and AnneeVol != 2015;

-- Question 5
select distinct numpil
from avion, vol
where avion.numav = vol.numav
  and capacite <= 200
order by numpil;

-- Question 6
select distinct capacite
from avion, vol
where avion.numav = vol.numav
  and AnneeVol > 2005
order by capacite;

-- Question 7
select nomav
from avion
where numav not in (select numav from vol)
order by nomav;

-- Question 8
select count(numvol)/count(distinct numav) as "Nb de vols par avion en 2014"
from vol
where AnneeVol = 2014;

-- Question 9
select localisation
from avion
where capacite > 150
group by localisation
having count(localisation) > 1
order by localisation;

-- Question 10 -- A refaire
select villedep
from vol
having count(*) = (select max(count(*))
                    from vol
                    group by villedep) 
group by villedep;

-- Question 11
select nompil
from pilote, avion, vol
where pilote.numpil = vol.numpil
  and avion.numav = vol.numav
group by nompil
having count(nompil) = 1
order by nompil;