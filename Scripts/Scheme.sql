-- Scheme
CREATE TABLESPACE proyectoBD_Data
   DATAFILE 'C:\app\Mariana\oradata\demo\proyectoBDdata01.dbf'
   SIZE 10M
   REUSE
   AUTOEXTEND ON
   NEXT 512k
   MAXSIZE 200M;
   
CREATE TABLESPACE proyectoBD_Ind
   DATAFILE 'C:\app\Mariana\oradata\demo\proyectoBDind01.dbf'
   SIZE 10M
   REUSE
   AUTOEXTEND ON
   NEXT 512k
   MAXSIZE 200M;
   
CREATE USER proyectoBD
    IDENTIFIED BY proyectoBD 
    DEFAULT TABLESPACE proyectoBD_data 
    QUOTA 10M ON proyectoBD_data 
    TEMPORARY TABLESPACE temp
    QUOTA 5M ON system ;
    --PROFILE app_user 
    --PASSWORD EXPIRE;
    
GRANT connect TO proyectoBD;
--------------------------------------------------
GRANT create session to proyectoBD;
--------------------------------------------------
GRANT create table to proyectoBD;
--------------------------------------------------
GRANT create view to proyectoBD;
