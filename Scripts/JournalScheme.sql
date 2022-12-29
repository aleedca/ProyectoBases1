-- Scheme
CREATE TABLESPACE journal_Data
   DATAFILE 'D:\app\Isaac\oradata\DBPRUEBA\journaldata01.dbf'
   SIZE 10M
   REUSE
   AUTOEXTEND ON
   NEXT 512k
   MAXSIZE 200M;
   
CREATE TABLESPACE journal_Ind
   DATAFILE 'D:\app\Isaac\oradata\DBPRUEBA\journalind01.dbf'
   SIZE 10M
   REUSE
   AUTOEXTEND ON
   NEXT 512k
   MAXSIZE 200M;
   
CREATE USER Journal
    IDENTIFIED BY Journal 
    DEFAULT TABLESPACE journal_data 
    QUOTA 10M ON journal_data 
    TEMPORARY TABLESPACE temp
    QUOTA 5M ON system ;
    --PROFILE app_user 
    --PASSWORD EXPIRE;
    
GRANT connect TO Journal
--------------------------------------------------
GRANT create session to Journal;
--------------------------------------------------
GRANT create table to Journal;
--------------------------------------------------
GRANT create view to Journal;
--------------------------------------------------
GRANT create sequence to Journal;
--------------------------------------------------
GRANT create procedure to Journal;
