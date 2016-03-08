-- TD06
-- Auteurs :
-- POIRIER Vincent
-- ROTTEE Fanny

-- A faire une fois par session
set serveroutput on;

-- Tables
drop table employees;
create table employees as select * from hr.employees;
drop table departments;
create table departments as select * from hr.departments;
drop table jobs;
create table jobs as select * from hr.jobs;
clear screen;

-- Question 1
create or replace procedure ajout_job (p_id Varchar2, p_title Varchar2) is
begin
  insert into jobs (job_id, job_title)
  values (p_id, p_title);
  commit;
end;
/

exec ajout_job('PR', 'Professeur');

-- Question 2
create or replace procedure modif_job (p_id varchar2, p_newtitle varchar2) is
    e_nojob exception;
begin
    update jobs
    set job_title = p_newtitle
    where job_id = p_id;

    if (sql%rowcount = 0) then
        raise e_nojob;
    end if;

    commit;

    exception
        when e_nojob then
            raise_application_error(-20002, 'Le job ' || p_id || ' est inexistant.');
end;
/

exec modif_job('PR', 'Professionnel');
exec modif_job('TEST', 'Exception');


-- Question 3
create or replace procedure liste_emp_mgr is
  cursor cr_emp is 
    select e1.first_name as emp_fn, e1.last_name as emp_ln, e2.first_name as mgr_fn, e2.last_name as mgr_ln
    from employees e1, employees e2
    where e2.employee_id = e1.manager_id;
  v_emp cr_emp%rowtype;
begin
  dbms_output.put_line('Employé     -     Manager');
  dbms_output.put_line('-------------------------');
  
  open cr_emp;
  
  loop
    fetch cr_emp into v_emp;
    exit when cr_emp%notfound;
  
    dbms_output.put_line(v_emp.emp_fn || ' ' || v_emp.emp_ln || ' - ' || v_emp.mgr_fn || ' ' || v_emp.mgr_ln);
  end loop;
  dbms_output.put_line(' ');
  close cr_emp;
end;
/

exec liste_emp_mgr;

-- Question 4
create or replace procedure liste_emp_make_more_than (p_name varchar2) is
  cursor cr_emp (p_name varchar2) is
    select last_name
    from employees
    where salary + decode(commission_pct, null, 0, commission_pct * salary) > (
      select salary + decode(commission_pct, null, 0, commission_pct * salary)
      from employees
      where last_name = p_name);
  v_emp cr_emp%rowtype;
begin
  dbms_output.put_line('Nom');
  dbms_output.put_line('----------');
  
  open cr_emp(p_name);
  
  loop
    fetch cr_emp into v_emp;
    exit when cr_emp%notfound;
  
    dbms_output.put_line(v_emp.last_name);
  end loop;
  dbms_output.put_line(' ');
  close cr_emp;
end;
/

exec liste_emp_make_more_than('Russell');


-- Question 5
create or replace procedure liste_same_job_make_more_than (p_name1 varchar2, p_name2 varchar2) is
  cursor cr_emp (p_name2 varchar2) is
    select last_name
    from employees
    where job_id in (
      select job_id
      from employees
      where last_name = p_name1)
    and salary > (
      select salary
      from employees
      where last_name = p_name2);
  v_emp cr_emp%rowtype;
begin
  dbms_output.put_line('Nom');
  dbms_output.put_line('----------');
  
  open cr_emp(p_name2);
  
  loop
    fetch cr_emp into v_emp;
    exit when cr_emp%notfound;
  
    dbms_output.put_line(v_emp.last_name);
  end loop;
  dbms_output.put_line(' ');
  close cr_emp;
end;
/

exec liste_same_job_make_more_than('Kochhar', 'Fox');


-- Question 6
create or replace procedure liste_emp_bigger_sal (p_n number) is
  cursor cr_emp(p_n number) is
    select * from (
      select last_name
      from employees
      order by salary desc)
    where rownum <= p_n;
  v_emp cr_emp%rowtype;
begin
  dbms_output.put_line('Nom');
  dbms_output.put_line('----------');
  
  open cr_emp(p_n);
  
  loop
    fetch cr_emp into v_emp;
    exit when cr_emp%notfound;
  
    dbms_output.put_line(v_emp.last_name);
  end loop;
  dbms_output.put_line(' ');
  close cr_emp;
end;
/

exec liste_emp_bigger_sal(5);


-- Question 7
create or replace procedure depts_without_emp is
  cursor cr_dept is
    select department_name as dname
    from departments
    where department_id not in (
      select distinct decode(department_id, null, 0, department_id)
      from employees)
    order by department_name desc;
  v_dept cr_dept%rowtype;
begin
  dbms_output.put_line('Département');
  dbms_output.put_line('----------');
  
  open cr_dept;
  
  loop
    fetch cr_dept into v_dept;
    exit when cr_dept%notfound;
  
    dbms_output.put_line(v_dept.dname);
  end loop;
  dbms_output.put_line(' ');
  close cr_dept;
end;
/

exec depts_without_emp;


-- Question 8


-- Question 9


-- Question 10


-- Question 11 - Apparemment faut le faire avec CASE.
create or replace function check_sal(p_empno employees.employee_id%type)
return Boolean is
  v_dept_id employees.department_id%type;
  v_sal employees.salary%type;
  v_avg_sal employees.salary%type;
begin
  select salary, department_id into v_sal, v_dept_id from employees
  where employee_id = p_empno;
  select avg(salary) into v_avg_sal from employees
  where department_id = v_dept_id;
  if v_sal > v_avg_sal then
    return true;
  else
    return false;
  end if;
exception
  when no_data_found then
    return null;
end;
/

begin
dbms_output.put_line('Vérification pour l''employé avec l''ID 205.');
  if (check_sal(205) is null) then
    dbms_output.put_line('La fonction a renvoyé NULL à cause d''une exception.');
  elsif (check_sal(205)) then
    dbms_output.put_line('Salaire > moyenne des salaires');
  else
    dbms_output.put_line('Salaire < moyenne des salaires');
  end if;
end;
/

