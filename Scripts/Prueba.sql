---CATALOGS RESTANTES----------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE insertGender(pDescriptionGender IN VARCHAR) AS
BEGIN
    INSERT INTO Gender(idGender, descriptionGender, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_gender.nextval, pDescriptionGender, NULL, NULL, NULL, NULL);
    COMMIT;
END insertGender;

CREATE OR REPLACE PROCEDURE insertTypeIdentification(pNameTypeIdentification IN VARCHAR, pTypeMask IN VARCHAR) AS
BEGIN
    INSERT INTO TypeIdentification(idTypeIdentification, nameTypeIdentification, typeMask, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_typeIdentification.nextval, pNameTypeIdentification, pTypeMask, NULL, NULL, NULL, NULL);
    COMMIT;
END insertTypeIdentification;

CREATE OR REPLACE PROCEDURE insertPosition(pDescriptionPosition IN VARCHAR) AS
BEGIN
    INSERT INTO PersonPosition(idPersonPosition, descriptionPosition, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_personposition.nextval, pDescriptionPosition, NULL, NULL, NULL, NULL);
    COMMIT;
END insertPosition;

CREATE OR REPLACE PROCEDURE insertContinent(pNameContinent IN VARCHAR2) AS
BEGIN
    INSERT INTO Continent (idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_continent.nextval, pNameContinent, NULL, NULL, NULL, NULL);
    COMMIT;
END insertContinent;

CREATE OR REPLACE PROCEDURE insertCountry(pNameCountry IN VARCHAR) AS
BEGIN
    INSERT INTO Country(idCountry, nameCountry, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_country.nextval, pNameCountry, NULL, NULL, NULL, NULL);
    COMMIT;
END insertCountry;

CREATE OR REPLACE PROCEDURE insertCountryTeam(pIdContinent IN NUMBER, pNameContinent IN VARCHAR) AS
BEGIN
    INSERT INTO CountryTeam(idCountryTeam, idContinent, nameCountryTeam, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_countryteam.nextval, pIdContinent, pNameCountryTeam, NULL, NULL, NULL, NULL);
    COMMIT;
END insertCountryTeam;

CREATE OR REPLACE PROCEDURE insertProvince(pIdCountry IN NUMBER, pNameProvince IN VARCHAR2) AS
BEGIN
    INSERT INTO Province (idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, pIdCountry, pNameProvince,NULL, NULL, NULL, NULL);
    COMMIT;
END insertProvince;

CREATE OR REPLACE PROCEDURE insertCanton(pIdProvince IN NUMBER, pNameCanton IN VARCHAR2) AS
BEGIN
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, pIdProvince, pNameCanton,NULL, NULL, NULL, NULL);
    COMMIT;
END insertCanton;

CREATE OR REPLACE PROCEDURE insertDistrict(pIdCanton IN NUMBER, pNameDistrict IN VARCHAR2) AS
BEGIN
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval, pIdCanton, pNameDistrict,NULL, NULL, NULL, NULL);
    COMMIT;
END insertDistrict;

CREATE OR REPLACE PROCEDURE updateGender(pIdGender IN NUMBER, pDescriptionGender IN VARCHAR) AS
BEGIN
    UPDATE Gender
    SET decriptionGender = pDescriptionGender
    WHERE idGender = pIdGender;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateGender;

CREATE OR REPLACE PROCEDURE updateTypeIdentification(pIdTypeIdentification IN NUMBER, pNameTypeIdentification IN VARCHAR) AS
BEGIN
    UPDATE TypeIdentification
    SET nameTypeIdentification = pNameTypeIdentification
    WHERE idTypeIdentification = pIdTypeIdentification;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateTypeIdentification;

CREATE OR REPLACE PROCEDURE updateCountry(pIdCountry IN NUMBER, pNameCountry IN VARCHAR) AS
BEGIN
    UPDATE Country
    SET nameCountry = pNameCountry
    WHERE idCountry = pIdCountry;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateCountry;

CREATE OR REPLACE PROCEDURE updateProvince(pIdProvince IN NUMBER, pIdCountry IN NUMBER, pNameProvince IN VARCHAR) AS
BEGIN
    UPDATE Province
    SET idCountry = pIdCountry
    WHERE idProvince = pIdProvince;

    UPDATE Province
    SET nameProvince = pNameProvince
    WHERE idProvince = pIdProvince;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateProvince;

CREATE OR REPLACE PROCEDURE updateCanton(pIdCanton IN NUMBER, pIdProvince IN NUMBER, pNameCanton IN VARCHAR) AS
BEGIN
    UPDATE Canton
    SET idProvince = pIdProvince
    WHERE idCanton = pIdCanton;

    UPDATE Canton
    SET nameCanton = pNameCanton
    WHERE idCanton = pIdCanton;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateCanton;

CREATE OR REPLACE PROCEDURE updateDistrict(pIdDistrict IN NUMBER, pIdCanton IN NUMBER, pNameDistrict IN VARCHAR) AS
BEGIN
    UPDATE District
    SET idCanton = pIdCanton
    WHERE idDistrict = pIdDistrict;

    UPDATE District
    SET nameDistrict = pNameDistrict
    WHERE idDistrict = pIdDistrict;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateDistrict;

CREATE OR REPLACE PROCEDURE updatePosition(pIdPosition IN NUMBER, pDescriptionPosition IN VARCHAR) AS
BEGIN
    UPDATE PersonPosition
    SET descriptionPersonPosition = pDescriptionPosition
    WHERE idPersonPosition = pIdPosition;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updatePosition;

CREATE OR REPLACE PROCEDURE updateContinent(pIdContinent IN NUMBER, pNameContinent IN VARCHAR) AS
BEGIN
    UPDATE Continent
    SET nameContinent = pNameContinent
    WHERE idContinent = pIdContinent;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateContinent;

CREATE OR REPLACE PROCEDURE updateCountryTeam(pIdCountryTeam IN NUMBER, pIdContinent IN NUMBER, pNameCountryTeam IN VARCHAR) AS
BEGIN
    UPDATE CountryTeam
    SET idContinent = pIdContinent
    WHERE idCountryTeam = pIdCountryTeam;
    
    UPDATE CountryTeam
    SET nameCountryTeam = pNameCountryTeam
    WHERE idCountryTeam = pIdCountryTeam;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateCountryTeam;

CREATE OR REPLACE PROCEDURE deleteGender(pIdGender IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM Gender
    WHERE idGender = pIdGender;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteGender;

CREATE OR REPLACE PROCEDURE deleteTypeIdentification(pIdTypeIdentification IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM TypeIdentification
    WHERE idTypeIdentification = pIdTypeIdentification;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteTypeIdentification;

CREATE OR REPLACE PROCEDURE deleteCountry(pIdCountry IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM Country
    WHERE idCountry = pIdCountry;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteCountry;

CREATE OR REPLACE PROCEDURE deleteProvince(pIdProvince IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM Province
    WHERE idProvince = pIdProvince;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteProvince;

CREATE OR REPLACE PROCEDURE deleteCanton(pIdCanton IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM Canton
    WHERE idCanton = pIdCanton;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteCanton;

CREATE OR REPLACE PROCEDURE deleteDistrict (pidDistrict IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM District
    WHERE idDistrict = pidDistrict;

    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteDistrict;

CREATE OR REPLACE PROCEDURE deletePosition (pidPersonPosition IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM PersonPosition
    WHERE idPersonPosition = pidPersonPosition;

    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deletePosition;

CREATE OR REPLACE PROCEDURE deleteContinent (pidContinent IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM Continent
    WHERE idContinent = pidContinent;

    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteContinent;

CREATE OR REPLACE PROCEDURE deleteCountryTeam (pidCountryTeam IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM CountryTeam
    WHERE idCountryTeam = pidCountryTeam;

    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteCountryTeam;
---------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE getContinent(curContinent OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curContinent FOR
    SELECT  idContinent, nameContinent
    FROM Continent;
END getContinent;

CREATE OR REPLACE PROCEDURE insertTeamXGroup (pidTeam IN NUMBER, pidGroupEvent IN NUMBER) AS
BEGIN
    INSERT INTO TeamXGroup (idTeamXGroup, idTeam, idGroupEvent, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_teamxgroup.nextval, pidTeam, pidGroupEvent,NULL, NULL, NULL, NULL);
    COMMIT;
END insertTeamXGroup;

--- SoccerMatch
CREATE OR REPLACE PROCEDURE getSoccerMatch (pidSoccerMatch IN NUMBER, curSoccerMatch OUT SYS_REFCURSOR) 
AS
vnTeam1 VARCHAR2(32);
vnTeam2 VARCHAR2(32);
BEGIN
    SELECT idTeam
    FROM PlayerXMatchXTeam
    WHERE idSoccerMatch = pidSoccerMatch;
    
    OPEN curSoccerMatch FOR
    SELECT descriptionGroupEvent, vnTeam1, nameStadium
    FROM TeamXGroup;
END getSoccerMatch;



CREATE OR REPLACE PROCEDURE validateNumberOfUnits(codResult OUT NUMBER) IS
vnTotalTeam NUMBER(10);
BEGIN
    SELECT COUNT(*)
    INTO vnTotalTeam
    FROM Team;
    codResult := vnTotalTeam;
END validateNumberOfUnits;


CREATE OR REPLACE PROCEDURE generateRaffle(pTotalGroup IN NUMBER, pIdEvent IN NUMBER) IS
vnIdMax NUMBER(10);
vnIdMin NUMBER(10);
vnQuantity NUMBER(1);
vnCount NUMBER(1):=0;
vnNumber NUMBER(2);
vnCHAR NUMBER(2):=65;
vnDescription VARCHAR2(32);
vnFlag BOOLEAN:=TRUE;
BEGIN
    SELECT MIN(idTeam) 
    INTO vnIdMin
    FROM Team;
    
    SELECT MAX(idTeam)
    INTO vnIdMax
    FROM Team;
    
    FOR i IN 1..pTotalGroup
    LOOP
        SELECT CHR(vnCHAR)
        INTO vnDescription
        FROM dual;
        
        insertGroupEvent (pIdEvent, 'Grupo ' || vnDescription);
        
        WHILE(vnFlag = TRUE)
        LOOP
            SELECT
            ROUND(DBMS_RANDOM.VALUE(vnIdMin,vnIdMax)) 
            INTO vnNumber
            FROM dual;

            SELECT COUNT(*) 
            INTO vnQuantity
            FROM TeamXGroup WHERE idTeam = vnNumber;

            IF (vnQuantity = 0)
            THEN
                insertTeamXGroup (vnNumber, s_groupevent.currval);
                vnCount:=vnCount+1;
            END IF;
            
            IF(vnCount = 4)
            THEN
                vnFlag:=FALSE;
            END IF;
        END LOOP;
        
        vnCHAR:=vnCHAR+1;
        vnCount:=0;
        vnFlag:=TRUE;
    END LOOP;
END generateRaffle;
