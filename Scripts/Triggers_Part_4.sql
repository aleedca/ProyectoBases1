/* File Name: Triggers_Part_4
Description: This file contains the triggers for each table created in part 4.
Authors:
Isaac Araya Solano - 2018151703
Alexia Cerdas Aguilar - 2019026961
Nahomi Bolaños Valverde - 2022089165
Mariana Fernández Martínez - 2021104026
*/

--Person
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertPerson
BEFORE INSERT
ON proyectoBD.Person
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertPerson;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdatePerson
BEFORE UPDATE
ON proyectoBD.Person
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdatePerson;

--Player

CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertPlayer
BEFORE INSERT
ON proyectoBD.Player
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertPlayer;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdatePlayer
BEFORE UPDATE
ON proyectoBD.Player
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdatePlayer;

--TeamWorker

CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertTeamWorker
BEFORE INSERT
ON proyectoBD.TeamWorker
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertTeamWorker;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateTeamWorker
BEFORE UPDATE
ON proyectoBD.TeamWorker
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateTeamWorker;

--EventWorker

CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertEventWorker
BEFORE INSERT
ON proyectoBD.EventWorker
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertEventWorker;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateEventWorker
BEFORE UPDATE
ON proyectoBD.EventWorker
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateEventWorker;

--UserType

CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertUserType
BEFORE INSERT
ON proyectoBD.UserType
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertUserType;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateUserType
BEFORE UPDATE
ON proyectoBD.UserType
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateUserType;

--UserPerson

CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertUserPerson
BEFORE INSERT
ON proyectoBD.UserPerson
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertUserPerson;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateUserPerson
BEFORE UPDATE
ON proyectoBD.UserPerson
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateUserPerson;

-- UserXNews

CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertUserXNews
BEFORE INSERT
ON proyectoBD.UserXNews
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertUserXNews;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateUserXNews
BEFORE UPDATE
ON proyectoBD.UserXNews
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateUserXNews;

-- ParameterTable 

CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertParameterTable
BEFORE INSERT
ON proyectoBD.ParameterTable
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertParameterTable;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateParameterTable
BEFORE UPDATE
ON proyectoBD.ParameterTable
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateParameterTable;









