CREATE OR REPLACE PROCEDURE getGroupStats(pIdGroup IN NUMBER, outGroupStats OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN outGroupStats FOR
    SELECT Team.nameTeam, GroupStats.wonMatches, GroupStats.tiedMatches, GroupStats.lostMatches, GroupStats.goalsScored,
    GroupStats.goalsReceived, GroupStats.fairPlayPoints FROM GroupEvent
    INNER JOIN Team ON Team.idGroupEvent = GroupEvent.idGroupEvent
    INNER JOIN GroupStats ON GroupStats.idTeam = Team.idTeam
    WHERE GroupEvent.idGroupEvent = pIdGroup;
END;

CREATE OR REPLACE PROCEDURE getAccountInformation(pUsername IN VARCHAR2, outAccountCursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN outAccountCursor FOR
    SELECT UserPerson.username, UserPerson.passwordUser, Person.firstName, Person.secondName,
    Person.firstLastName, Person.secondLastName, Person.identification, Gender.descriptionGender,
    Mail.descriptionMail, Phone.phoneNumber
    FROM UserPerson
    INNER JOIN Person ON Person.idPerson = UserPerson.idPerson
    INNER JOIN Gender ON Person.idGender = Gender.idGender
    INNER JOIN Mail ON Mail.idPerson = Person.idPerson
    INNER JOIN PersonXPhone ON PersonXPhone.idPerson = Person.idPerson
    INNER JOIN Phone ON Phone.idPhone = PersonXPhone.idPhone
    WHERE UserPerson.username = pUsername;
END;

CREATE OR REPLACE PROCEDURE getTotalPublishedNews(outPublishedNews OUT NUMBER)
AS
resultTotal NUMBER;
BEGIN
    SELECT COUNT(1) INTO resultTotal FROM News
    WHERE News.idNewsStatus = 1;
    
    outPublishedNews := resultTotal;
END getTotalPublishedNews;


CREATE OR REPLACE PROCEDURE getAverageReviewsAuthor(pUsername IN VARCHAR2, outAverage OUT NUMBER)
AS
resultAverage NUMBER;
BEGIN
    SELECT AVG(Rating.rating) INTO resultAverage
    FROM Rating 
    INNER JOIN UserXNews ON UserXNews.idNews = Rating.idNews 
    WHERE UserXNews.username = pUsername;
    
    outAverage := resultAverage;
END getAverageReviewsAuthor;
-----------


CREATE OR REPLACE PROCEDURE getTotalPlayersXAge(rangeStart IN NUMBER, rangeEnd IN NUMBER, pIdGender IN NUMBER, pIdTeam IN NUMBER, outTotalPlayers OUT NUMBER)
AS
totalPlayers NUMBER;
BEGIN
    SELECT COUNT(1) INTO totalPlayers FROM Player
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    WHERE Player.birthdate IS NOT NULL
    AND Player.idTeam = NVL(pIdTeam, Player.idTeam)
    AND Person.idGender = NVL(pIdGender, Person.idGender)
    AND TRUNC((sysdate - Player.birthdate)/365) BETWEEN rangeStart AND rangeEnd;
    
    outTotalPlayers := totalPlayers;
END getTotalPlayersXAge;

CREATE OR REPLACE PROCEDURE getTopNGoalScorer(topQuantity OUT NUMBER, outGoalScorerCursor OUT SYS_REFCURSOR)
AS
topN NUMBER;
BEGIN
    SELECT valueParameter INTO topN FROM
    ParameterTable WHERE parametertable.nameparameter = 'TopNGoalScorer';
    
    topQuantity:= topN;
    
    OPEN outGoalScorerCursor FOR
    SELECT Person.idPerson, SUM(PlayerXSoccerMatchXTeam.goals)
    FROM Player
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    INNER JOIN PlayerXSoccerMatchXTeam ON PlayerXSoccerMatchXTeam.idPerson = Person.idPerson
    GROUP BY Person.idPerson
    ORDER BY SUM(PlayerXSoccerMatchXTeam.goals) DESC;
END;

/*
CREATE OR REPLACE PROCEDURE getTopNGoalScorer(topQuantity OUT NUMBER, outGoalScorerCursor OUT SYS_REFCURSOR)
AS
topN NUMBER;
BEGIN
    SELECT valueParameter INTO topN FROM
    ParameterTable WHERE parametertable.nameparameter = 'TopNGoalScorer';
    
    topQuantity:= topN;
    
    OPEN outGoalScorerCursor FOR
    SELECT idPerson, GoalsScored
    FROM (SELECT Person.idPerson, SUM(PlayerXSoccerMatchXTeam.goals) GoalsScored, RANK() OVER (ORDER BY GoalsScored DESC) top_goals
    FROM Player
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    INNER JOIN PlayerXSoccerMatchXTeam ON PlayerXSoccerMatchXTeam.idPerson = Person.idPerson
    GROUP BY Person.idPerson)
    WHERE top_goals <= topQuantity;

END;
*/

CREATE OR REPLACE PROCEDURE getTopNGoalKeepers(topQuantity OUT NUMBER, outGoalKeepersCursor OUT SYS_REFCURSOR)
AS
topN NUMBER;
BEGIN
    SELECT valueParameter INTO topN FROM
    ParameterTable WHERE parametertable.nameparameter = 'TopNGoalKeepers';
    
    topQuantity:= topN;
    
    OPEN outGoalKeepersCursor FOR
    SELECT Person.idPerson, SUM(PlayerXSoccerMatchXTeam.saves)
    FROM Player
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    INNER JOIN PlayerXSoccerMatchXTeam ON PlayerXSoccerMatchXTeam.idPerson = Person.idPerson
    GROUP BY Person.idPerson
    ORDER BY SUM(PlayerXSoccerMatchXTeam.goals) DESC;
END;












