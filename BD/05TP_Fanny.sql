-- Auteurs :
-- ROTTEE Fanny

-- A faire une fois par session
SET SERVEROUTPUT ON;

-- Exercice 1
CLEAR SCREEN;
DECLARE
  CURSOR c_emp is
    SELECT ename, comm FROM emp ;
  
BEGIN
  FOR v_emp IN c_emp LOOP
    IF (v_emp.comm is NULL or v_emp.comm = 0) THEN
      DBMS_OUTPUT.PUT_LINE('L''employé ' || v_emp.ename || ' n''a pas de commission');
    ELSE
      DBMS_OUTPUT.PUT_LINE('L''employé ' || v_emp.ename || ' a une commission de ' || v_emp.comm || ' dollars');
    END IF ;
  END LOOP ;
END;
/

-- Exercice 2
-- CREATE TABLE EEMPLOYEES AS SELECT * FROM HR.EMPLOYEES;
-- ALTER TABLE eemployees ADD Etoiles VARCHAR2(50);
DECLARE
  CURSOR c_eemployees is
    SELECT salary FROM eemployees FOR UPDATE OF etoiles;
BEGIN
  FOR v_eemployees IN c_eemployees LOOP
    UPDATE eemployees SET eemployees.etoiles = LPAD('*', round(eemployees.salary/1000),'*') WHERE CURRENT OF c_eemployees;
  END LOOP;

END;
/

-- Exercice 3
-- CREATE TABLE DDEPARTMENTS AS SELECT * FROM HR.DEPARTMENTS;
DECLARE
  CURSOR c_dept is
    SELECT department_id, department_name FROM ddepartment 
    WHERE department_id < 100 order by department_id;
  CURSOR c_emp (p_deptno ddepartments.department_id%TYPE) is
    SELECT last_name, job_id, hire_date, salary FROM ddepartment, eemployees
    WHERE employee_id < 120 AND eemployees.department_id = p_deptno;
    
BEGIN
  FOR v_emp IN c_emp (
  
END;
