-- TD02
-- Auteur :
-- POIRIER Vincent

-- Préparation
clear screen;
-- Si les tables n'appartiennent pas à l'utilisateur :
-- create table emp as select * from scott.emp;
-- create table dept as select * from scott.dept;
-- create table salgrade as select * from scott.salgrade;

-- Question 1
select ename, job, sal, nvl(comm, 0) as comm, sal+nvl(comm, 0) as "TOTAL COMPENSATION"
from emp
where deptno = 30;

-- Question 2
select power(deptno, 2) as carre, power(deptno, 3) as cube
from dept;

select sal/22 as saljour, round(sal/22) as saljourdol, round(sal/22, 2) as saljourpen
from emp
where deptno = 30;

-- Question 3
select round(sal/22, 2) as saljour, round(sal/22/8, 2) as salhor
from emp
where deptno = 30;

-- Question 4
select dname || ' - ' || loc as dnameloc
from dept;

-- Question 5
select ename, decode(job, 'CLERK', 1, 'MANAGER', 3, 'PRESIDENT', 5, 2) as jobno
from emp;

-- Question 6
select decode(deptno, 10, job, ename) as "Nom / Job si 'deptno' = 10"
from emp;

-- Question 7
select substr(dname, 0, 5) as "'dname' sur 5 caractères"
from dept;

-- Question 8
select upper(ename) as majuscules, lower(ename) as minuscules
from emp;

-- Question 9
select ename, instr(ename, 'R') as "Position du 'R'"
from emp;

-- Question 10
select dname, length(dname) as "Longueur de 'dname'"
from dept;

-- Question 11
select ename, sal, lpad('$', sal/100, '$') as histogramme
from emp
order by sal;

-- Question 12
select ename
from emp
where deptno = &NumDepartement;

-- Question 13
select ename, job, to_char(hiredate, 'day dd month yyyy') as "Date française"
from emp
where deptno = 20;

-- Question 14
select ename, hiredate
from emp
where hiredate >= '04/01/81' and hiredate <= '15/04/81'
order by hiredate;

-- Question 15
select max(sal) as salmax, min(sal) as salmin, max(sal)-min(sal) as difference
from emp;

-- Question 16
select max(length(dname)) as "Longueur du plus grand 'dname'"
from dept;