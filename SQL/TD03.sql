-- TD03
-- Auteur :
-- POIRIER Vincent

-- Préparation
clear screen;
-- Si les tables n'appartiennent pas à l'utilisateur :
-- create table emp as select * from scott.emp;
-- create table dept as select * from scott.dept;
-- create table salgrade as select * from scott.salgrade;

-- Question 1
select ename, deptno
from emp
where deptno in (select deptno from emp
                 where job = 'CLERK'
                 group by deptno);

-- Question 2
select ename
from emp
where emp.deptno = 10
  and job in (select distinct job from emp, dept
              where emp.deptno = dept.deptno and dname = 'SALES');
              
-- Question 3
select ename, nvl(comm, 0) as comm, sal, nvl(comm, 0)/sal as ratio
from emp
where job = 'SALESMAN'
order by nvl(comm, 0)/sal;

-- Question 4
select deptno, job, round(avg(sal),2) as salmoy
from emp
group by deptno, job
order by salmoy;

-- Question 5
select job, round(avg(sal),2) as salmoy
from emp
group by job
having count(*) > 2
order by avg(sal);

-- Question 6
select dept.deptno, dname
from dept, (select emp.deptno
            from emp, dept
            where emp.deptno = dept.deptno
            group by emp.deptno
            having count(*) >= all (select count(*)
                                    from emp
                                    group by deptno)) res
where dept.deptno = res.deptno;


-- Question 7
-- On rajoute un employé dans le département 30 pour tester la requête.
-- insert into emp
-- values (7000, 'GOD', 'CREATOR', null, null, 9999, null, 30);
-- Et on spécifie que ce nouvel employé est manager du président.
-- update emp
-- set mgr = 7000
-- where job = 'PRESIDENT';
select deptno, dname
from dept
where deptno in(select deptno
                from (select emp.*, grade
                      from emp, salgrade
                      where sal >= losal and sal <= hisal) empg
                group by deptno
                having count(distinct grade) = (select count(*) from salgrade));

-- Question 8
-- On met à jour la table pour avoir un résultat
-- update emp
-- set sal = 700
-- where deptno = 20;
select distinct emp.deptno, dname
from salgrade, emp, dept
where sal >= losal and sal <= hisal and grade = 1 
  and dept.deptno = emp.deptno 
  and emp.deptno not in (select distinct deptno
                         from salgrade, emp
                         where sal >= losal and sal <= hisal and grade != 1)
order by dname;

-- Question 9
select distinct job, sal
from emp
where sal = (select max(sal)
             from emp
             where job != 'PRESIDENT')
   or sal = (select min(sal)
             from emp)
order by sal desc;

-- Question 10
(select distinct dept.deptno, dname, job
from dept, emp)
minus 
(select distinct emp.deptno, dname, job
from dept, emp)
order by deptno;

-- Question 11
select dname
from dept
where deptno not in (select deptno
                     from emp
                     where job = 'MANAGER');
                     
-- Question 12
select deptno, dname
from dept
where deptno in (select deptno
                 from emp
                 group by deptno
                 having count(distinct job) >= all (select count(*)
                                                    from emp
                                                    group by job));

-- Question 13
select deptno, job, round(avg(sal),2) as salmoy
from emp
where sal >= 1000
group by deptno, job
order by salmoy;

-- Question 14
select distinct A.ename as "Manager", count(A.ename) as "Nombre d'employés"
from emp A, emp B
where A.empno = B.mgr
  and A.job = 'MANAGER'
group by A.ename
order by "Nombre d'employés" desc;

-- Question 15
select distinct A.ename as "Manager", B.ename as "Employé"
from emp A, emp B
where A.empno = B.mgr
  and A.job = 'MANAGER'
order by "Manager";

-- Question 16
select distinct ename, sal
from emp
where sal = (select max(sal)
             from emp);

-- Question 17
select distinct NU 
from U 
where U.NU in (select NU from PUF)
  and not exists (select NU 
                  from PUF 
                  where PUF.NU = U.NU
                    and NF != 3)
order by NU;
  
-- Question 18
select distinct NU
from PUF
where NF = 1
group by NU
having count(distinct NP) = (select count(distinct NP)
                            from PUF where NF = 1);