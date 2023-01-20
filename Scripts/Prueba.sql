CREATE OR REPLACE PROCEDURE getContinent(curContinent OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curContinent FOR
    SELECT  idContinent, nameContinent
    FROM Continent;
END getContinent;




--- curContinent OUT SYS_REFCURSOR
CREATE OR REPLACE PROCEDURE generateGroup IS
vnIdMax NUMBER(2);
vnIdMin NUMBER(1);
vnNumber NUMBER(2);
BEGIN
    SELECT MIN(idTeam) 
    INTO vnIdMin
    FROM Team;
    
    SELECT MAX(idTeam)
    INTO vnIdMax
    FROM Team;

    FOR i IN vnIdMin..vnIdMax
    LOOP
        SELECT
        ROUND(DBMS_RANDOM.VALUE(1,16)) 
        INTO vnNumber
        FROM dual;
        DBMS_OUTPUT.PUT_LINE(vnNumber);
    END LOOP;
END generateGroup;

EXEC generateGroup;