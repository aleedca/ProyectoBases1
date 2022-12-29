--
CREATE OR REPLACE PROCEDURE getGroupList(pGroupList OUT SYS_REFCURSOR, pTeamName IN VARCHAR2, pMatchDate IN DATE, pStadium IN VARCHAR2, pTeamFlag IN VARCHAR2)
IS 
BEGIN
    OPEN pGroupList FOR 
    SELECT Team.nameTeam, SoccerMatch.dateHour, Stadium.nameStadium, CountryTeam.flag
    FROM Stadium 
    INNER JOIN SoccerMatch ON SoccerMatch.idStadium = Stadium.idStadium
    INNER JOIN PlayerXSoccerMatchXTeam ON SoccerMatch.idSoccerMatch = PlayerXSoccerMatchXTeam.idSoccerMatch
    INNER JOIN Team ON PlayerXSoccerMatchXTeam.idTeam = Team.idTeam
    INNER JOIN CountryTeam ON Team.idCountryTeam = CountryTeam.idCountryTeam 
    WHERE Team.nameTeam = NVL (pTeamName, Team.nameTeam) AND SoccerMatch.dateHour = NVL (pMatchDate, SoccerMatch.dateHour) 
    AND Stadium.nameStadium = NVL (pStadium, Stadium.nameStadium) AND CountryTeam.flag = NVL (pTeamFlag, CountryTeam.flag);
END getGroupList;

--
CREATE OR REPLACE PROCEDURE getTeamList(pTeamList OUT SYS_REFCURSOR, pTeamName IN VARCHAR2, pPlayerName IN VARCHAR2, pPosition IN VARCHAR2 )
IS 
BEGIN
    OPEN pTeamList FOR 
    SELECT Person.firstName, Person.secondName, Person.firstLastname, Person.secondLastname, Person.photo, PersonPosition.descriptionPersonPosition 
    FROM Team
    INNER JOIN Player ON Player.idTeam = Team.idTeam
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    INNER JOIN PersonPosition ON PersonPosition.idPersonPosition = Person.idPersonPosition 
    WHERE Team.nameTeam = NVL (pTeamName, Team.nameTeam) AND Person.firstName = NVL (pPlayerName, Person.firstName) 
    AND PersonPosition.descriptionPersonPosition= NVL (pPosition, PersonPosition.descriptionPersonPosition);
END getTeamList;



--Listado de los equipos:
--Muestran el nombres completos, foto y su posición (portero, delantero, capitán, director técnico, entre otros).
--Filtros nombre del equipo, nombre completo de los jugadores, posición.














