-- TD01
-- Auteur :
-- POIRIER Vincent

-- Préparation
clear screen;
-- Si les tables n'appartiennent pas à l'utilisateur :
-- create table emp as select * from scott.emp;
-- create table dept as select * from scott.dept;
-- create table salgrade as select * from scott.salgrade;

-- Question 1
select distinct job
from emp;

-- Question 2
select ename, job, sal 
from emp 
where deptno = 20 
  and sal >= 2000;

-- Question 3
select ename
from emp
where job='MANAGER' or job='PRESIDENT';

-- Question 4
select ename
from emp
where sal >= 1200 and sal <= 1400;

-- Question 5
select ename, job
from emp
where job = 'CLERK' or job = 'ANALYST' or job = 'SALESMAN';
  
-- Question 6
select ename
from emp
where ename like 'M%' or ename like 'm%';

-- Question 7
select ename
from emp
where ename like '____N';

-- Question 8
select ename
from emp
where ename not like '_____';

-- Question 9
select ename
from emp
where comm is null;

-- Question 10
select ename
from emp
where deptno = 30
order by sal asc;
select ename
from emp
where deptno = 30
order by sal desc;

-- Question 11
select ename
from emp
where deptno = 30
order by job asc, sal desc;

-- Question 12
select ename
from emp
order by nvl(comm, 0) asc;

-- Question 13
select ename
from emp
order by nvl(comm, 0) desc;

-- Question 14
select dname
from emp, dept
where emp.deptno = dept.deptno 
  and ename='ALLEN';
  
-- Questions 15 et 16 ignorées

-- Question 17
select dname
from dept
where deptno not in (select distinct deptno from emp);

-- Question 18
select emp.*, dname
from emp, dept
where emp.deptno = dept.deptno
  and loc = 'CHICAGO';
  
-- Question 19
select empA.ename, empA.sal, empB.ename, empB.sal
from emp empA, emp empB
where empA.mgr = empB.empno 
  and empA.sal > empB.sal;
  
-- Question 20
select ename
from emp
where sal > (select sal from emp where ename = 'JONES');

-- Question 21
select ename, grade
from emp, salgrade
where sal >= losal and sal <= hisal;

-- Question 22
select ename, job
from emp
where ename != 'JONES'
  and job = (select job from emp where ename = 'JONES');
  
-- Question 23
select ename
from emp
where sal > any (select sal from emp where deptno = 30);
  
-- Question 24
select ename
from emp
where sal > all (select sal from emp where deptno = 30);
  
-- Question 25
select ename
from emp
where deptno = 10
  and job in (select job from emp where deptno = 30);
    
-- Question 26
select ename, job, sal
from emp
where ename != 'FORD'
  and job = (select job from emp where ename = 'FORD');

-- Question 27
select ename, job, dname
from emp, dept
where emp.deptno = dept.deptno
  and ((ename != 'JONES' and job = (select job from emp where ename = 'JONES'))
  or  (ename != 'FORD' and sal >= (select sal from emp where ename ='FORD')))
order by job asc, sal desc;
  
-- Question 28
select ename
from emp
where emp.deptno = 10
  and job in (select distinct job from emp, dept
              where emp.deptno = dept.deptno and dname = 'SALES');

-- Question 29
select ename
from emp, dept
where loc = 'CHICAGO'
  and ename != 'ALLEN'
  and job = (select job from emp where ename = 'ALLEN')
order by ename;

-- Question 30
select ename
from emp, (select deptno, avg(sal) as salmoyen
          from emp
          group by deptno) moy
where emp.deptno = moy.deptno and sal > salmoyen;
