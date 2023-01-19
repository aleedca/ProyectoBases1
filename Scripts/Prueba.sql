CREATE OR REPLACE PROCEDURE getContinent(curContinent OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curContinent FOR
    SELECT  idContinent, nameContinent
    FROM Continent;
END getContinent;