-- TD03
-- Auteurs :
-- POIRIER Vincent
-- ROTTEE Fanny
SET SERVEROUTPUT ON;

-- Exercice 1
DECLARE
  v_num NUMBER := &NumEmp;
  v_moy_sal NUMBER(6,2);
  v_emp EMP%ROWTYPE;
  v_newsal NUMBER(6,2);
BEGIN
  SELECT AVG(SAL) INTO v_moy_sal
  FROM EMP
  WHERE JOB IN (
    SELECT JOB
    FROM EMP
    WHERE EMPNO = v_num
  );
  DBMS_OUTPUT.PUT_LINE(CONCAT('Salaire moyen : ', v_moy_sal));
  
  SELECT * INTO v_emp
  FROM EMP
  WHERE EMPNO = v_num;
  
  DBMS_OUTPUT.PUT_LINE(CONCAT('Mon ancien salaire : ', v_emp.SAL));
  
  IF v_emp.SAL < v_moy_sal 
    THEN v_newsal := v_moy_sal;
    ELSE v_newsal := v_emp.SAL*1.1;
  END IF;
  
  UPDATE EMP SET SAL = v_newsal WHERE EMPNO = v_num;
  COMMIT;
  
  DBMS_OUTPUT.PUT_LINE(CONCAT('Mon nouveau salaire : ', v_newsal));
END;

-- Exercice 2
DECLARE
  v_num NUMBER := &Num;
  v_facto Number := 1;
  v_cpt Number := 1;
BEGIN
  WHILE v_cpt <= v_num LOOP
    v_facto := v_facto * v_cpt;
    v_cpt := v_cpt + 1;
  END LOOP;
  
  DBMS_OUTPUT.PUT_LINE('La factorielle de ' || v_num || ' vaut : ' || v_facto);
END;

-- Exercice 3a
ALTER TABLE DEPT
ADD BUDGET NUMBER(10,2);
COMMIT;

DECLARE
  CURSOR c_sumsal IS 
    SELECT DEPTNO, SUM(SAL) as SOMME
    FROM emp 
    GROUP BY deptno;
  v_sumsal c_sumsal%ROWTYPE;
BEGIN
  OPEN c_sumsal;
  LOOP
    FETCH c_sumsal INTO v_sumsal;
    EXIT WHEN c_sumsal%NOTFOUND;
    UPDATE DEPT SET BUDGET = v_sumsal.SOMME WHERE DEPTNO = v_sumsal.DEPTNO;
  END LOOP;
  CLOSE c_sumsal;
  UPDATE DEPT SET BUDGET = nvl(BUDGET, 0) WHERE BUDGET IS NULL;
END;

-- Exercice 3b
DECLARE
  CURSOR c_salville IS 
    SELECT ENAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO
      AND (LOC = 'DALLAS' OR LOC = 'NEW YORK');
  v_salville c_salville%ROWTYPE;
BEGIN
  OPEN c_salville;
  LOOP
    FETCH c_salville INTO v_salville;
    EXIT WHEN c_salville%NOTFOUND;
    UPDATE EMP SET SAL = 1.1 * SAL WHERE ENAME = v_salville.ENAME;
  END LOOP;
  CLOSE c_salville;
END;

-- Exercice 3c
DECLARE
  v_n NUMBER := &N;
  CURSOR c_salaires IS
    SELECT ENAME, SAL
    FROM EMP
    ORDER BY SAL DESC;
  v_salaires c_salaires%ROWTYPE;
  v_cpt NUMBER := 0;
BEGIN
  OPEN c_salaires;
  LOOP
    FETCH c_salaires INTO v_salaires;
    EXIT WHEN v_cpt = v_n;
    DBMS_OUTPUT.PUT_LINE('Salaire de ' || v_salaires.ENAME || ' : ' || v_salaires.SAL);
    v_cpt := v_cpt + 1;
  END LOOP;
  CLOSE c_salaires;
END;

-- Exercice 4
drop table personnel;

create table personnel(
  nom varchar2(20) constraint pk_personnel primary key,
  role varchar2(20) not null);
  
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

DECLARE
  e_tabPersoVide EXCEPTION;
  v_n number;
  v_jgl number;
  v_prct number;
BEGIN
  SELECT COUNT(NOM) INTO v_n
  FROM PERSONNEL;
  DBMS_OUTPUT.PUT_LINE('Nombre d''employés : ' || v_n);
  
  IF (v_n = 0) THEN
    RAISE e_tabPersoVide;
  END IF;
  
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

