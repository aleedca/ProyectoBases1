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
