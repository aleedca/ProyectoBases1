/* File Name: Triggers_Part_2
Description: This file contains the triggers for each table created in part 2.
Authors:
Isaac Araya Solano - 2018151703
Alexia Cerdas Aguilar - 2019026961
Nahomi Bolaños Valverde - 2022089165
Mariana Fernández Martínez - 2021104026
*/

-- Country
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertCountry
BEFORE INSERT
ON proyectoBD.Country
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertCountry;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateCountry
BEFORE UPDATE
ON proyectoBD.Country
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateCountry;

-- Stadium
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertStadium
BEFORE INSERT
ON proyectoBD.Stadium
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertStadium;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateStadium
BEFORE UPDATE
ON proyectoBD.Stadium
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateStadium;

-- Province
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertProvince
BEFORE INSERT
ON proyectoBD.Province
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertProvince;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateProvince
BEFORE UPDATE
ON proyectoBD.Province
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateProvince;

-- Canton
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertCanton
BEFORE INSERT
ON proyectoBD.Canton
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertCanton;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateCanton
BEFORE UPDATE
ON proyectoBD.Canton
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateCanton;

-- District
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertDistrict
BEFORE INSERT
ON proyectoBD.District
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertDistrict;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateDistrict
BEFORE UPDATE
ON proyectoBD.District
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateDistrict;

-- Address
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertAddress
BEFORE INSERT
ON proyectoBD.Address
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertAddress;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateAddress
BEFORE UPDATE
ON proyectoBD.Address
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateAddress;

----------------------------------------------------------------------------------------
-- Mail
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertMail
BEFORE INSERT
ON proyectoBD.Mail
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertMail;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateMail
BEFORE UPDATE
ON proyectoBD.Mail
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateMail;

-- Phone
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertPhone
BEFORE INSERT
ON proyectoBD.Phone
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertPhone;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdatePhone
BEFORE UPDATE
ON proyectoBD.Phone
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdatePhone;

-- PersonXPhone
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertPersonXPhone
BEFORE INSERT
ON proyectoBD.PersonXPhone
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertPersonXPhone;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdatePersonXPhone
BEFORE UPDATE
ON proyectoBD.PersonXPhone
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdatePersonXPhone;

-------------------------------------------------------------------------------------------
-- PlayerXSoccerMatchXTeam
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertPlayerXSoccerMatchXTeam
BEFORE INSERT
ON proyectoBD.PlayerXSoccerMatchXTeam
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertPlayerXSoccerMatchXTeam;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdatePlayerXSoccerMatchXTeam
BEFORE UPDATE
ON proyectoBD.PlayerXSoccerMatchXTeam
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdatePlayerXSoccerMatchXTeam;

