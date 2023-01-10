CREATE OR REPLACE PROCEDURE getPlayer (curPlayer OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curPlayer FOR
    SELECT pl.idPerson, p.firstName, p.secondName, p.firstLastName, p.secondLastName
    FROM Person P, Player PL
    WHERE p.idPerson = pl.idPerson;
END getPlayer;

CREATE OR REPLACE PROCEDURE getTeamWorker (curTeamWorker OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curTeamWorker FOR
    SELECT tw.idPerson, p.firstName, p.secondName, p.firstLastName, p.secondLastName
    FROM Person P, TeamWorker TW
    WHERE p.idPerson = tw.idPerson;
END getTeamWorker;