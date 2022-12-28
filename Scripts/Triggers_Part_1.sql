/* File Name: Triggers_Part_1
Description: This file contains the triggers for each table created in part 1.
Authors:
Isaac Araya Solano - 2018151703
Alexia Cerdas Aguilar - 2019026961
Nahomi Bolaños Valverde - 2022089165
Mariana Fernández Martínez - 2021104026
*/

-- Gender
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertGender
BEFORE INSERT
ON proyectoBD.Gender
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertGender;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateGender
BEFORE UPDATE
ON proyectoBD.Gender
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateGender;

-- TypeIdentification
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertTypeIdentification
BEFORE INSERT
ON proyectoBD.TypeIdentification
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertTypeIdentification;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateTypeIdentification
BEFORE UPDATE
ON proyectoBD.TypeIdentification
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateTypeIdentification;

-- Calendar
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertCalendar
BEFORE INSERT
ON proyectoBD.Calendar
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertCalendar;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateCalendar
BEFORE UPDATE
ON proyectoBD.Calendar
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateCalendar;

-- Continent
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertContinent
BEFORE INSERT
ON proyectoBD.Continent
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertContinent;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateContinent
BEFORE UPDATE
ON proyectoBD.Continent
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateContinent;

-- Event
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertEvent
BEFORE INSERT
ON proyectoBD.Event
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertEvent;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateEvent
BEFORE UPDATE
ON proyectoBD.Event
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateEvent;

-- GroupEvent
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertGroupEvent
BEFORE INSERT
ON proyectoBD.GroupEvent
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertGroupEvent;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateGroupEvent
BEFORE UPDATE
ON proyectoBD.GroupEvent
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateGroupEvent;

-- CountryTeam
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertCountryTeam
BEFORE INSERT
ON proyectoBD.CountryTeam
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertCountryTeam;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateCountryTeam
BEFORE UPDATE
ON proyectoBD.CountryTeam
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateCountryTeam;

-- Team
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertTeam
BEFORE INSERT
ON proyectoBD.Team
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertTeam;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateTeam
BEFORE UPDATE
ON proyectoBD.Team
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateTeam;

-- GroupStats
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertGroupStats
BEFORE INSERT
ON proyectoBD.GroupStats
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertGroupStats;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateGroupStats
BEFORE UPDATE
ON proyectoBD.GroupStats
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateGroupStats;

-- SoccerMatchXStadium
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertSoccerMatchXStadium
BEFORE INSERT
ON proyectoBD.SoccerMatchXStadium
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertSoccerMatchXStadium;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateSoccerMatchXStadium
BEFORE UPDATE
ON proyectoBD.SoccerMatchXStadium
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateSoccerMatchXStadium;