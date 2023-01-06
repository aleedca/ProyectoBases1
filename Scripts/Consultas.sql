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
CREATE OR REPLACE PROCEDURE getTeamList(pTeamName IN VARCHAR2, pPlayerFstName IN VARCHAR2, pPlayerSndName IN VARCHAR2,
                                        pPlayerFstLastName IN VARCHAR2, pPlayerSndLastName IN VARCHAR2, pPosition IN VARCHAR2,pTeamList OUT SYS_REFCURSOR)
AS  
BEGIN
    OPEN pTeamList FOR
    SELECT Person.firstName, Person.secondName, Person.firstLastname, Person.secondLastname, Person.photo, PersonPosition.descriptionPersonPosition 
    FROM Team
    INNER JOIN Player ON Player.idTeam = Team.idTeam
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    INNER JOIN PersonPosition ON PersonPosition.idPersonPosition = Person.idPersonPosition 
    WHERE Team.nameTeam = NVL (pTeamName, Team.nameTeam) AND Person.firstName = NVL(pPlayerFstName, Person.firstName)
    AND Person.secondName = NVL(pPlayerSndName, Person.secondName)
    AND Person.secondLastName = NVL(pPlayerSndLastName, Person.secondLastName) AND Person.firstLastName = NVL(pPlayerFstLastName, Person.firstLastName)
    AND PersonPosition.descriptionPersonPosition= NVL (pPosition, PersonPosition.descriptionPersonPosition);
END getTeamList;

/*
Se deben mostrar todas las noticias (autor, título, fecha de publicación, tipo de artículo)
ordenados por antigüedad del más reciente al más antiguo. Filtros: autor, fecha, mundial.

FALTA TERMINARLO PORQUE HAY QUE ARREGLAR EVENTO
*/

CREATE OR REPLACE PROCEDURE getNewsList(pNewsList OUT SYS_REFCURSOR, pAuthorName IN VARCHAR2, pAuthorLastName IN VARCHAR2, pDate IN DATE, pEvent IN VARCHAR2)
IS 
BEGIN
    OPEN pTeamList FOR 
    SELECT Person.firstName, Person.lastName, News.title, News.publicationDate, NewsType.descriptionNewsType
    FROM UserXNews
    INNER JOIN News ON News.idNews = UserXNews.idNews
    INNER JOIN UserPerson ON UserPerson.username = UserXNews.username
    INNER JOIN Person ON Person.idPerson = UserPerson.idPerson
    INNER JOIN NewsType ON News.idNewsType = NewsType.idNewsType
    WHERE Person.firstName = NVL(pAuthorName, Person.firstName) AND Person.lastName = NVL(pAuthorLastName, Person.lastName)
    AND News.publicationDate = NVL(pDate, News.publicationDate)
    ORDER BY News.publicationDate DESC;
END getNewsList;
















