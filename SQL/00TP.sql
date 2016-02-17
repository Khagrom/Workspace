-- TP0 POIRIER

-- Initialisation des tables
clear screen;
-- create table U as select * from benslimane.U;
-- create table P as select * from benslimane.P;
-- create table F as select * from benslimane.F;
-- create table PUF as select * from benslimane.PUF;

-- Question 1
select *
from U;

-- Question 2
select * 
from U 
where VILLE = 'londres';

-- Question 3
select NF 
from PUF 
where NU = 1 
  and NP = 1;

-- Question 4
select distinct NOMP, COULEUR
from PUF, P
where PUF.NP = P.NP 
  and NF = 1;

-- Question 5
select distinct NF 
from PUF, P
where COULEUR = 'rouge' 
  and PUF.NP = P.NP 
  and NU = 1;

-- Question 6
select NF
from PUF, P, U
where COULEUR = 'rouge'
  and PUF.NP = P.NP
  and PUF.NU = U.NU
  and (U.VILLE = 'londres' or U.VILLE = 'paris');

-- Question 7
select distinct NP
from PUF, F, U
where PUF.NF = F.NF
  and PUF.NU = U.NU
  and U.VILLE = F.VILLE;
  
-- Question 8
select distinct NP
from PUF, F, U
where PUF.NF = F.NF
  and PUF.NU = U.NU
  and U.VILLE = F.VILLE
  and U.VILLE = 'londres';
  
-- Question 9
select distinct PUF.NU 
from PUF, F, U
where PUF.NF = F.NF
  and PUF.NU = U.NU
  and U.VILLE != F.VILLE;
  
-- Question 10 / intersects
(select NF 
from PUF 
where NU = 1)
  intersect
(select NF 
from PUF 
where NU = 2);

-- Question 10 / Auto-jointure
select distinct PUFa.NF
from PUF PUFa, PUF PUFb
where PUFa.NU = 1
  and PUFb.NU = 2
  and PUFa.NF = PUFb.NF;

-- Question 10'
select distinct NP 
from PUF, U a 
where a.NU = PUF.NU 
  and a.VILLE = 'londres' 
  and not exists 
    (select * 
    from U b 
    where b.NU = PUF.NU 
      and a.VILLE != b.VILLE);
      
-- Question 11
select distinct NU
from PUF
where NP in
  (select NP
  from PUF
  where NF = 3);
  
-- Question 12
select NP
from P
where POIDS in 
  (select min(poids) from P);
  
-- Question 13
select NU 
from U
where NU not in 
  (select NU
  from PUF,P
  where PUF.NP = P.NP
    and COULEUR = 'rouge');
  
-- Question 14
select distinct PUF.NF
from PUF, PUF a, PUF b, P
where COULEUR = 'rouge'
  and PUF.NP = b.NP
  and a.NF = b.NF
  and a.NP = puf.NP;
  
-- Question 15
select distinct F.VILLE a, NP, U.VILLE b
from PUF, U, F
where PUF.NF = F.NF
  and PUF.NU = U.NU;
  
-- Question 16
select distinct F.VILLE a, NP, U.VILLE b
from PUF, U, F
where F.VILLE != U.VILLE
  and PUF.NF = F.NF
  and PUF.NU = U.NU;
  
-- Question 17 > voir Question 10'

-- Question 18
select distinct NF
from F
where exists
  (select NP
  from P
  where not exists
    (select NU
    from U
    where not exists
      (select *
      from PUF
      where PUF.NF = F.NF
        and PUF.NU = U.NU
        and PUF.NP = P.NP)));

-- Question 19
select distinct NU
from PUF a
where not exists
  (select *
  from PUF b
  where b.NF = 4
    and not exists
      (select *
      from PUF c
      where a.NU = c.NU
        and a.NP = b.NP
        and c.NF = 4))
order by NU;
        
-- Question 20
select NU
from U
where NU in
  (select NU
  from PUF
  where NF = 3);