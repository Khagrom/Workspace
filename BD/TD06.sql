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
drop table jjobs;
create table jjobs as select * from hr.jobs;
clear screen;

-- Question 1
declare
  id varchar2(10);
  title varchar2(35);
procedure ajout_job(nId in varchar2, nTitle in varchar2) is
begin
  insert into jjobs
  values(nId, nTitle, 0, 0);
  commit;
end;
begin
  id := 'PR_RG';
  title := 'Public Relations Random Guy';
  ajout_job(id, title);
end;
/

-- Question 2
create or replace procedure modif_job (idPoste varchar2, newTitle varchar2) is
  v_cpt jjobs.job_id%type;
begin
  select job_id into v_cpt from jjobs where job_id = idPoste ;
  update jjobs set job_title = newTitle where job_id = idPoste;
  commit;
  exception
  when no_data_found then dbms_output.put_line ('NON');
end;
/
exec modif_job('thrhs', 'bla');

-- Question 3
create or replace procedure aff_nom () is
cursor c_emp is
  select * from employees;
cursor c_mgr (
begin

end;
/