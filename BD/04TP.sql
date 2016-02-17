-- Auteurs :
-- POIRIER Vincent
-- ROTTEE Fanny

-- A faire une fois par session
SET SERVEROUTPUT ON;

-- Quel cirque !
-- Insertion des valeurs
delete from personnel;
insert into personnel
values ('Leo', 'Jongleur');
insert into personnel
values ('Guillaume', 'Clown');
insert into personnel
values ('Fanny', 'Dresseuse');
insert into personnel
values ('Jean', 'Magicien');
insert into personnel
values ('Vincent', 'Jongleur');
insert into personnel
values ('Antoine', 'Clown');
insert into personnel
values ('Nathan', 'Magicien');
insert into personnel
values ('Marion', 'Dresseuse');
insert into personnel
values ('Yoann', 'Jongleur');
commit;

-- Bloc PL/SQL
DECLARE
  e_tabPersoVide EXCEPTION;
  v_n number;
  v_jgl number;
  v_prct number;
BEGIN
  SELECT COUNT(NOM) INTO v_n
  FROM PERSONNEL;
  IF (v_n = 0) THEN
    RAISE e_tabPersoVide;
  END IF;
  DBMS_OUTPUT.PUT_LINE('Nombre d''employés : ' || v_n);
  
  SELECT COUNT(NOM) INTO v_jgl
  FROM PERSONNEL
  WHERE ROLE = 'Jongleur';
  DBMS_OUTPUT.PUT_LINE('Nombre de jongleurs : ' || v_jgl);
  
  v_prct := round(v_jgl * 100 / v_n, 2);
  DBMS_OUTPUT.PUT_LINE('Proportion de jongleurs : ' || v_prct || '%');
  
  EXCEPTION
    WHEN e_tabPersoVide THEN
      RAISE_APPLICATION_ERROR (-20001, 'ERREUR FATALE');
      RETURN;
    WHEN OTHERS THEN 
      DBMS_OUTPUT.PUT_LINE (SQLERRM);
END;
/

-- Catalogue
-- On vide la corbeille, pour que les éventuelles traces ne soient pas listées
PURGE RECYCLEBIN;

-- Bloc PL/SQL
DECLARE 
  CURSOR c_data IS
    SELECT * FROM TAB;
  v_data c_data%ROWTYPE;
  v_cpt NUMBER := 0;
  v_max NUMBER;
BEGIN
  SELECT count(TNAME) INTO v_max
  FROM TAB;
  
  OPEN c_data;
  LOOP
    FETCH c_data INTO v_data;
    EXIT WHEN v_cpt = v_max;
    DBMS_OUTPUT.PUT_LINE('L''objet ' || v_data.TNAME || ' est de type ' || v_data.TABTYPE || '.');
    v_cpt := v_cpt + 1;
  END LOOP;
  CLOSE c_data;
END;
/

-- Les gros navions
-- Le choix a été fait d'utiliser des NUMBER pour les horaires, avec des centièmes d'heures donc.
-- Le programme vérifie bien que l'heure est située entre 0 inclus et 24 non inclus
-- Insertion des valeurs
delete from avion;
insert into avion
values (1, 'Alouette III', 100, 'Lyon');
insert into avion
values (2, 'Alpha Jet', 300, 'Lyon');
insert into avion
values (3, 'Meteor NF', 250, 'Paris');
insert into avion
values (4, 'Vultur', 275, 'Lyon');
insert into avion
values (5, 'Super Puma', 350, 'Paris');
insert into avion
values (6, 'Tweet', 300, 'Paris');
insert into avion
values (7, 'Typhoon', 400, 'Marseille');
insert into avion
values (8, 'Valkyrie', 275, 'Lyon');
commit;

delete from pilote;
insert into pilote
values (1, 'Quiniou', 'Perpignan', 30000);
insert into pilote
values (2, 'Ladevie', 'Moulins', 25000);
insert into pilote
values (3, 'Le Sommer', 'Pays des Schtroumpfs', 10000);
insert into pilote
values (4, 'Rottee', 'Chambery', 35000);
insert into pilote
values (5, 'Debard', 'Le Havre', 5000);
insert into pilote
values (6, 'Daigremont', 'Paris', 10000);
insert into pilote
values (7, 'Guillot', 'Chartres', 10000);
insert into pilote
values (8, 'Roux', 'Rouen', 15000);
insert into pilote
values (9, 'Craipeau', 'Trouville', 1000);
commit;

delete from vol;
insert into vol
values (1111, 1, 1, 'Lyon', 'Cayenne', 13, 1);
insert into vol
values (2222, 2, 2, 'Lyon', 'Paris', 10, 12);
insert into vol
values (4444, 3, 4, 'Lyon', 'Londres', 15, 20);
insert into vol
values (8888, 4, 8, 'Lyon', 'Leipzig', 9, 11);
insert into vol
values (1666, 5, 1, 'Cayenne', 'Lyon', 19, 7);
insert into vol
values (2666, 6, 2, 'Paris', 'Lyon', 6, 8);
insert into vol
values (4666, 7, 4, 'Londres', 'Lyon', 15, 20);
insert into vol
values (8666, 8, 8, 'Leipzig', 'Lyon', 20, 22);
commit;

-- Bloc PL/SQL
DECLARE
  CURSOR c_vol IS
    SELECT VOLNUM, AVNUM, HEUREDEP, HEUREARR FROM VOL
    WHERE AVNUM = 1 OR AVNUM = 2 OR AVNUM = 4 OR AVNUM = 8;
  v_vol c_vol%ROWTYPE;
  v_cpt NUMBER := 0;
  v_nvarr NUMBER;
  v_max NUMBER;
BEGIN

  SELECT count(VOLNUM) INTO v_max
  FROM VOL WHERE AVNUM = 1 OR AVNUM = 2 OR AVNUM = 4 OR AVNUM = 8;
  
  OPEN c_vol;
  LOOP
    FETCH c_vol INTO v_vol;
    EXIT WHEN v_cpt = v_max;
    IF(v_vol.AVNUM = 1 or v_vol.AVNUM = 4) THEN
      IF (v_vol.HEUREARR > v_vol.HEUREDEP) THEN
        v_nvarr := v_vol.HEUREDEP + 0.9 * (v_vol.HEUREARR - v_vol.HEUREDEP);
      ELSE
        v_nvarr := v_vol.HEUREDEP + 0.9 * (v_vol.HEUREARR - v_vol.HEUREDEP + 24) - 24;
        IF(v_nvarr < 0) THEN
          v_nvarr := v_nvarr + 24;
        END IF;
      END IF;
    ELSE
      IF (v_vol.HEUREARR > v_vol.HEUREDEP) THEN
        v_nvarr := v_vol.HEUREDEP + 0.85 * (v_vol.HEUREARR - v_vol.HEUREDEP);
      ELSE
        v_nvarr := v_vol.HEUREDEP + 0.85 * (v_vol.HEUREARR - v_vol.HEUREDEP + 24) - 24;
        IF(v_nvarr < 0) THEN
          v_nvarr := v_nvarr + 24;
        END IF;
      END IF;
    END IF;
    UPDATE VOL
    SET HEUREARR = v_nvarr
    WHERE  VOLNUM = v_vol.VOLNUM;
    COMMIT;
    v_cpt := v_cpt + 1;
  END LOOP;
  CLOSE c_vol;
END;
/
