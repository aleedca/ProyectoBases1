CREATE OR REPLACE PROCEDURE getContinent(curContinent OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curContinent FOR
    SELECT  idContinent, nameContinent
    FROM Continent;
END getContinent;

CREATE OR REPLACE PROCEDURE insertTeamXGroup (pidTeam IN NUMBER, pidGroupEvent IN NUMBER) AS
BEGIN
    INSERT INTO TeamXGroup (idTeamXGroup, idTeam, idGroupEvent,userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_teamxgroup.nextval, pidTeam, pidGroupEvent,NULL, NULL, NULL, NULL);
    COMMIT;
END insertTeamXGroup;


CREATE OR REPLACE PROCEDURE validateNumberOfUnits(codResult OUT NUMBER) IS
vnTotalTeam NUMBER(10);
BEGIN
    SELECT COUNT(*)
    INTO vnTotalTeam
    FROM Team;
    codResult := vnTotalTeam;
END validateNumberOfUnits;


CREATE OR REPLACE PROCEDURE generateGroup(pTotalGroup IN NUMBER, pIdEvent IN NUMBER) IS
vnIdMax NUMBER(10);
vnIdMin NUMBER(10);
vnQuantity NUMBER(1);
vnNumber NUMBER(2);
vnDescription VARCHAR2;
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
        insertGroupEvent (pIdEvent, vnDescription);
        
        SELECT
        ROUND(DBMS_RANDOM.VALUE(vnIdMin,vnIdMax)) 
        INTO vnNumber
        FROM dual;
        DBMS_OUTPUT.PUT_LINE(vnNumber);
        
        SELECT COUNT(*) INTO vnCantidad
        FROM TeamXGroup WHERE idTeam = vnNumber;
        /*
        IF vnCantidad = 0
        THEN
            insertTeamXGroup (vnNumber, pidGroupEvent IN NUMBER)
        END IF;*/
           
    END LOOP;
END generateGroup;

EXEC generateGroup;