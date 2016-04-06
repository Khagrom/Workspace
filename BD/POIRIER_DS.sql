-- Examen
-- Auteur :
-- POIRIER Vincent

-- A faire une fois par session
SET serveroutput ON;

-- Tables
-- Précision : on renomme les tables en 'Joueurs' et 'Matches' pour éviter de
-- remplacer nos précédentes tables.
DROP
  TABLE matches;
DROP
  TABLE joueurs;
CREATE
  TABLE joueurs
  (
    nojoueur                       NUMBER(6),
    prenom                         VARCHAR2(30) NOT NULL,
    nom                            VARCHAR2(30) NOT NULL,
    nationalite                    VARCHAR2(20) NOT NULL,
    classement_en_simple           NUMBER(4)NOT NULL,
    date_de_naissance              DATE NOT NULL,
    taille                         NUMBER(3,2),
    poids                          NUMBER(4,2),
    joue_de_la_main                VARCHAR2(6) NOT NULL,
    total_des_victoires_de_l_annee NUMBER(2)DEFAULT 0,
    total_des_defaites_de_l_annee  NUMBER(2)DEFAULT 0,
    total_gains_simple_de_l_annee  NUMBER(7)DEFAULT 0,
    CONSTRAINT joueurs_pk PRIMARY KEY (nojoueur)
  );
CREATE
  TABLE matches
  (
    nomatch    NUMBER(3),
    date_match DATE NOT NULL,
    tour_match VARCHAR2(15) NOT NULL,
    nojoueur1  NUMBER(6) NOT NULL ,
    nojoueur2  NUMBER(6)NOT NULL,
    vainqueur  NUMBER(6),
    duree      NUMBER(3),
    CONSTRAINT matches_pk PRIMARY KEY (nomatch)
  );
ALTER TABLE matches ADD CONSTRAINT matches_nojoueur1_fk FOREIGN KEY (nojoueur1)
REFERENCES joueurs;
ALTER TABLE matches ADD CONSTRAINT matches_nojoueur2_fk FOREIGN KEY (nojoueur2)
REFERENCES joueurs;
ALTER TABLE matches ADD CONSTRAINT matches_vainqueur_fk FOREIGN KEY (vainqueur)
REFERENCES joueurs;
INSERT
INTO
  joueurs VALUES
  (
    1,
    'Raphael',
    'Nadal',
    'ESP',
    1,
    '3/06/1986',
    1.85,
    85.5,
    'Gauche',
    34,6,3602662
  );
INSERT
INTO
  joueurs VALUES
  (
    2,
    'Novak',
    'Djokovic',
    'SRB',
    2,
    '22/05/1987',
    1.88,
    80,
    'Droite',
    24,3,3072637
  );
INSERT
INTO
  joueurs VALUES
  (
    3,
    'Andy',
    'Murray',
    'GBR',
    8,
    '15/05/1987',
    1.91,
    84.1,
    'Droite',
    21,9,682956
  );
INSERT
INTO
  joueurs VALUES
  (
    4,
    'Ernest',
    'Gulbis',
    'LAT',
    19,
    '30/08/1988',
    1.91,
    85,
    'Droite',
    27,10,874319
  );
INSERT
INTO
  joueurs VALUES
  (
    5,
    'David',
    'Ferrer',
    'ESP',
    5,
    '2/04/1982',
    1.75,
    72.7,
    'Droite',
    27,10,1057681
  );
INSERT
INTO
  joueurs VALUES
  (
    6,
    'Gael',
    'Monfils',
    'FRA',
    24,
    '1/09/1986',
    1.93,
    80.5,
    'Droite',
    17,7,383613
  );
INSERT
INTO
  joueurs VALUES
  (
    7,
    'Tomas',
    'Berdych',
    'CZE',
    6,
    '17/09/1985',
    1.96,
    90.9,
    'Droite',
    27,8,1642539
  );
INSERT
INTO
  joueurs VALUES
  (
    8,
    'Milos',
    'Raonic',
    'CAN',
    9,
    '27/12/1990',
    1.96,
    88.6,
    'Droite',
    15,7,632120
  );
COMMIT;
INSERT
INTO
  matches VALUES
  (
    1,
    '3/06/2014',
    '1/4 finale',
    1,5,1,120
  );
INSERT
INTO
  matches VALUES
  (
    2,
    '3/06/2014',
    '1/4 finale',
    6,3,3,160
  );
INSERT
INTO
  matches VALUES
  (
    3,
    '4/06/2014',
    '1/4 finale',
    7,4,4,180
  );
INSERT
INTO
  matches VALUES
  (
    4,
    '4/06/2014',
    '1/4 finale',
    8,2,2,120
  );
INSERT
INTO
  matches VALUES
  (
    5,
    '6/06/2014',
    '1/2 finale',
    1,3,1,110
  );
INSERT
INTO
  matches VALUES
  (
    6,
    '6/06/2014',
    '1/2 finale',
    4,2,2,190
  );
INSERT
INTO
  matches VALUES
  (
    7,
    '8/06/2014',
    'finale',
    1,2,1,185
  );
COMMIT;

-- Questions
clear screen;

-- 1
-- La table 'Rencontre' existe, on nomme donc la procédure 'Rencontres'.
-- On utilise NVL(taille,0) et NVL(poids,0) pour remplacer null par 0.
CREATE OR REPLACE PROCEDURE rencontres
  (
    p_nom    VARCHAR2,
    p_prenom VARCHAR2
  )
IS
  v_nom joueurs.nom%type;
  v_prenom joueurs.prenom%type;
  v_loopcounter NUMBER := 0;
  CURSOR cr_rencontre
  IS
    SELECT DISTINCT
      nom,
      prenom,
      NVL(taille,0) AS taille,
      NVL(poids,0)  AS poids,
      tour_match
    FROM
      joueurs,
      matches
    WHERE
      (
        joueurs.nojoueur  = matches.nojoueur1
      OR joueurs.nojoueur = matches.nojoueur2
      )
    AND
      (
        matches.nojoueur1 =
        (
          SELECT DISTINCT
            nojoueur
          FROM
            joueurs
          WHERE
            nom      = p_nom
          AND prenom = p_prenom
        )
    OR matches.nojoueur2 =
      (
        SELECT DISTINCT
          nojoueur
        FROM
          joueurs
        WHERE
          nom      = p_nom
        AND prenom = p_prenom
      )
      )
    AND nom    != p_nom
    AND prenom != p_prenom;
  e_aucunerencontre EXCEPTION;
BEGIN
  SELECT
    nom,
    prenom
  INTO
    v_nom,
    v_prenom
  FROM
    joueurs
  WHERE
    nom      = p_nom
  AND prenom = p_prenom;
  FOR v_rencontre IN cr_rencontre
  LOOP
    v_loopcounter := v_loopcounter + 1;
  END LOOP;
  IF v_loopcounter = 0 THEN
    raise e_aucunerencontre;
  END IF;
  dbms_output.put_line('Joueurs rencontrés par ' || v_prenom || ' ' || v_nom || ' :');
  dbms_output.put_line('Nom - Prenom - Taille - Poids - Tour');
  FOR v_rencontre IN cr_rencontre
  LOOP
    dbms_output.put_line(v_rencontre.nom || ' - ' || v_rencontre.prenom ||
    ' - ' || v_rencontre.taille || ' - ' || v_rencontre.poids || ' - ' ||
    v_rencontre.tour_match);
  END LOOP;
EXCEPTION
WHEN no_data_found THEN
  DBMS_OUTPUT.PUT_LINE('Erreur : le joueur de nom ' || p_nom ||
  ' et de prénom ' || p_prenom || ' n''existe pas !');
WHEN e_aucunerencontre THEN
  DBMS_OUTPUT.PUT_LINE('Erreur : le joueur de nom ' || p_nom ||
  ' et de prénom ' || p_prenom || ' n''affronte personne dans le tournoi !');
WHEN OTHERS THEN
  Raise_application_error(-20001, 'Erreur : ' || sqlerrm);
END;
/

-- Tests sans erreurs
EXEC rencontres('Nadal', 'Raphael');
EXEC rencontres('Monfils', 'Gael'); 
-- Tests avec erreurs
EXEC rencontres('Monfils', 'Raphael');
INSERT
INTO
  joueurs VALUES
  (
    9,
    'Roger',
    'Federer',
    'CHE',
    3,
    '8/08/1981',
    1.85,
    85,
    'Droite',
    0,0,0
  );
COMMIT;
EXEC rencontres('Federer', 'Roger');
DELETE
FROM
  joueurs
WHERE
  nom = 'Federer';
COMMIT;

-- 2
-- On considère que la main droite domine s'il y a autant de joueurs droitiers
-- que de joueurs gauchers.
CREATE OR REPLACE FUNCTION main(
    p_n NUMBER)
  RETURN VARCHAR2
IS
  v_compteMainGauche NUMBER := 0;
  v_compteMainDroite NUMBER := 0;
  CURSOR cr_classement
  IS
    SELECT
      joue_de_la_main
    FROM
      joueurs
    WHERE
      classement_en_simple <= p_n
    ORDER BY
      classement_en_simple;
BEGIN
  FOR v_classement IN cr_classement
  LOOP
    IF v_classement.joue_de_la_main = 'Droite' THEN
      v_compteMainDroite           := v_compteMainDroite + 1;
    ELSE
      v_compteMainGauche := v_compteMainGauche + 1;
    END IF;
  END LOOP;
IF v_compteMainGauche > v_compteMainDroite THEN
  RETURN 'gauche';
ELSE
  RETURN 'droite';
END IF;
EXCEPTION
WHEN OTHERS THEN
  Raise_application_error(-20002, 'Erreur : ' || sqlerrm);
END;
/

DECLARE
  meilleur NUMBER := 1;
BEGIN
  LOOP
    dbms_output.put_line('Quelle main dominante chez les ' || meilleur ||
    ' meilleur(s) joueur(s) ?');
    dbms_output.put_line('La main ' || main(meilleur) || ' domine !');
    meilleur := meilleur + 1;
    EXIT WHEN meilleur > 3;
  END LOOP;
END;
/