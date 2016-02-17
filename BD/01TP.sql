-- Tables
drop table bonus;
drop table salgrade;
drop table dept;
drop table emp;

create table emp as select * from scott.emp;
create table dept as select * from scott.dept;
create table salgrade as select * from scott.salgrade;
create table bonus as select * from scott.bonus;

-- Requêtes SQL
-- Question 1
update emp
set sal = 0
where job = 'SALESMAN';

-- Question 2
select ename, sal 
from emp
where job = 'SALESMAN';

-- Question 3
rollback;

-- Question 4
update emp
set sal = sal + (5/100) * (select sal from emp where ename = 'KING')
where job = 'MANAGER';

-- Question 5
select ename, sal
from emp
where job = 'MANAGER';

-- Question 6
rollback;

-- Question 7
insert into salgrade 
select distinct deptno, min(sal), max(sal) 
from emp 
group by deptno;

-- Question 8
select * from salgrade;

-- Question 9
rollback;

-- Question 10
delete from emp
where ename in (select ename
                from emp, (select deptno, avg(sal) as avgsal from emp  group by deptno) salmoy
                where emp.deptno = salmoy.deptno
                and sal <= avgsal);

-- Question 11
create view mgr as (select * from emp where job = 'MANAGER');

-- Question 12
update mgr
set sal = 1.1 * sal;

-- Question 13
select ename, job, sal from emp;

-- Question 14
rollback;
select ename, job, sal from emp;

-- Question 15
drop view mgr;