SET SERVEROUTPUT ON;
-- Question 2.1
DROP
  TABLE tabl;
CREATE
  TABLE tabl
  (
    NO_ID NUMBER,
    CONSTRAINT PK_TABL PRIMARY KEY (NO_ID)
  );
CREATE OR REPLACE TRIGGER tr_clenum BEFORE
  INSERT
    ON tabl FOR EACH ROW DECLARE n NUMBER;
  maxcle                           NUMBER;
  BEGIN
    SELECT
      COUNT(*)
    INTO
      n
    FROM
      tabl;
    IF n>0 THEN
      SELECT
        MAX(NO_ID)
      INTO
        maxcle
      FROM
        tabl;
      :new.NO_ID := maxcle+1;
    ELSE
      :new.NO_ID :=1;
    END IF;
  END;
  /
  -- Question 2.2
  DROP
    TABLE clientTrigger;
  CREATE
    TABLE clientTrigger
    (
      NUMCL    NUMBER,
      NOM      VARCHAR2(20),
      PRENOM   VARCHAR2(20),
      ADR      VARCHAR2(50),
      CP       NUMBER(5),
      VILLE    VARCHAR(20),
      SALAIRE  NUMBER(10),
      CONJOINT VARCHAR2(20),
      CONSTRAINT PK_TABLE PRIMARY KEY (NUMCL)
    );
  DROP
    TABLE compteTrigger;
  CREATE
    TABLE compteTrigger
    (
      NUMCP    NUMBER CONSTRAINT pk_compte PRIMARY KEY,
      DATEOUVR DATE,
      SOLDE    NUMBER
    );
  DROP
    TABLE detenteurTrigger;
  CREATE
    TABLE detenteurTrigger
    (
      NUMCL NUMBER CONSTRAINT fk_detenteur_client REFERENCES clientTrigger(
      numCl),
      NUMCP NUMBER CONSTRAINT fk_detenteur_compte REFERENCES compteTrigger(
      numCp),
      CONSTRAINT pk_detenteur PRIMARY KEY (numCl, numCp)
    );
CREATE OR REPLACE TRIGGER tr_NewClient BEFORE
  INSERT
    ON CLIENTTRIGGER FOR EACH ROW DECLARE e_numdep EXCEPTION;
  e_nomconj                                        EXCEPTION;
  BEGIN
    IF TRUNC(:new.CP/1000) NOT IN (01,07,26,38,42,69,73,74) THEN
      raise e_numdep;
    END IF;
    IF :new.CONJOINT   IS NOT NULL THEN
      IF :new.conjoint != :new.nom THEN
        raise e_nomconj;
      END IF;
    END IF;
  EXCEPTION
  WHEN e_numdep THEN
    raise_application_error (-20001, 'Pas le bon département');
  WHEN e_nomconj THEN
    raise_application_error (-20002, 'Pas le bon conjoint');
  END;
  /
  INSERT
  INTO
    clientTrigger VALUES
    (
      3,
      'Poirier',
      'Vincent',
      'Loin',
      69008,
      'Lyon',
      1000,
      'Lol'
    );
  -- Question 2.3
  DROP
    TABLE Journal;
  CREATE
    TABLE Journal
    (
      TSTAMP  TIMESTAMP,
      USRNAME VARCHAR2(20),
      TABLES  VARCHAR2(20),
      ACTION  VARCHAR2(20),
      CONSTRAINT pk_Journal PRIMARY KEY (TSTAMP, USRNAME)
    );
    
create or replace trigger tr_journal
AFTER INSERT OR update or delete on DEPT
BEGIN
  if inserting then
  insert into Journal values (Current_timestamp, USER, 'DEPT', 'INSERT');
  end if;
  if updating then
    insert into Journal values (Current_timestamp, USER, 'DEPT', 'UPDATE');
  end if;
  if deleting then
    insert into Journal values (Current_timestamp, USER, 'DEPT', 'DELETE');
  end if;
END;
/

insert into dept values (80, 'bla1', 'BLU1', 6598);
insert into dept values (90, 'bla2', 'BLU2', 6599);
update dept
set dname = 'bli1' where dname = 'bla1';
delete from dept where deptno > 40;
commit;