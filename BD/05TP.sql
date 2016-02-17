-- Auteurs :
-- POIRIER Vincent
-- ROTTEE Fanny

-- A faire une fois par session
set serveroutput on;

-- Exercice 1
clear screen;
declare
  cursor c_emp is
    select * from emp;
begin
  for v_emp in c_emp loop
    if v_emp.comm is null or v_emp.comm = 0 then
      dbms_output.put_line('L''employé ' || v_emp.ename || ' n''a pas de commission');
    else
      dbms_output.put_line('L''employé ' || v_emp.ename || ' a une commission de ' || v_emp.comm || '$');
    end if;
  end loop;
end;
/

-- Exercice 2
clear screen;
drop table employees;
create table employees as select * from hr.employees;
alter table employees add etoiles varchar(50);
declare
  cursor c_emp is
    select * from employees
    for update of etoiles;
  v_sal number;
  v_stars employees.etoiles%type;
begin
  for v_emp in c_emp loop
    v_sal := round(v_emp.salary/1000);
    v_stars := '';
    loop
      exit when v_sal = 0;
      v_stars := concat(v_stars, '*');
      v_sal := v_sal - 1;
    end loop;
    update employees
    set etoiles = v_stars
    where current of c_emp;
  end loop;
end;
/

-- Exercice 3
clear screen;
drop table departments;
create table departments as select * from hr.departments;
declare
  cursor c_dep is
    select * from departments
    where department_id < 100;
  cursor c_emp(p_department_id employees.department_id%type) is
    select * from employees
    where department_id = p_department_id and employee_id < 120;
begin
  for v_dep in c_dep loop
    dbms_output.put_line('Numero Departement : ' || v_dep.department_id || '  Nom Departement : ' || v_dep.department_name);
      for v_emp in c_emp(v_dep.department_id) loop
        dbms_output.put_line(v_emp.last_name || '   ' || v_emp.job_id || '   ' || v_emp.hire_date || '   ' || v_emp.salary);
      end loop;
    dbms_output.put_line('----------------------------------------------------------------------------------------'); 
  end loop;
end;
/
