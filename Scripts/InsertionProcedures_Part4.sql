-- Insertion Rating
CREATE OR REPLACE PROCEDURE ratingInsertion(pUsername IN NUMBER, pIdNews IN NUMBER, pRating IN NUMBER)
AS
BEGIN
    INSERT INTO Rating(idRating, username, idNews, rating, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_rating.NEXTVAL, pUsername, pIdNews, pRating, NULL, NULL, NULL, NULL);
    COMMIT;
END ratingInsertion;

-- Insertion SoccerMatch
CREATE OR REPLACE PROCEDURE soccerMatchInsertion(pDateHour IN DATE)
AS
BEGIN
    INSERT INTO SoccerMatch(idSoccerMatch, dateHour, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_soccerMatch.NEXTVAL, pDateHour, NULL, NULL, NULL, NULL);
    COMMIT;
END soccerMatchInsertion;

-- Insertion Team
CREATE OR REPLACE PROCEDURE teamInsertion(pIdCountryTeam IN NUMBER, pIdGroupEvent IN NUMBER, pNameTeam IN VARCHAR2)
AS
BEGIN
    INSERT INTO Team(idTeam, idCountryTeam, idGroupEvent, nameTeam, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_team.NEXTVAL, pIdCountryTeam, pIdGroupEvent, pNameTeam, NULL, NULL, NULL, NULL);
    COMMIT;
END teamInsertion;

-- Insertion TeamWorker
CREATE OR REPLACE PROCEDURE teamWorkerInsertion(pIdentification IN NUMBER, pFirstName IN VARCHAR2, pSecondName IN VARCHAR2, pFirstLastName IN VARCHAR2, pSecondLastName IN VARCHAR2,
pPhoto IN VARCHAR2, pIdPersonPosition IN NUMBER, pIdCountry IN NUMBER, pIdTypeIdentification IN NUMBER, pIdGender IN NUMBER)
AS
BEGIN
    DECLARE idPersonInsertion NUMBER :=s_person.nextval;
    BEGIN
        INSERT INTO Person(idPerson, identification, firstName, secondName, firstLastName, secondLastName, photo, idPersonPosition, idCountry, idTypeIdentification, idGender, userCreation, lastUser, lastDate, dateCreation)
        VALUES (idPersonInsertion, pIdentification, pFirstName, pSecondName, pFirstLastName, pSecondLastName, pPhoto, pIdPersonPosition, pIdCountry, pIdTypeIdentification, pIdGender, NULL, NULL, NULL, NULL);

        INSERT INTO EventWorker(idPerson, userCreation, lastUser, lastDate, dateCreation)
        VALUES (idPersonInsertion, NULL, NULL, NULL, NULL); 

        COMMIT;
    END;
END teamWorkerInsertion;

-- Insertion UserPerson
CREATE OR REPLACE PROCEDURE userPersonInsertion(pUsername IN VARCHAR2, pIdUserType IN NUMBER, pIdPerson IN NUMBER, pPassword IN VARCHAR2)
AS 
BEGIN
    INSERT INTO UserPerson(username, idUserType, idPerson, passwordUser, userCreation, lastUser, lastDate, dateCreation)
    VALUES(pUsername, pIdUserType, pIdPerson, pPassword, NULL, NULL, NULL, NULL);
    COMMIT;
END userPersonInsertion;

-- Insertion PlayerXSoccerMatchXTeam
CREATE OR REPLACE PROCEDURE PlayerMatchTeamInsertion(pIdMatch IN NUMBER, pIdTeam1 IN NUMBER, pIdTeam2 IN NUMBER)
AS
BEGIN
    CURSOR playersTeam1 IS

    SELECT Player.idPerson
    FROM Player
    WHERE Player.idTeam = pIdTeam1;

    BEGIN
        FOR playerIndex IN playersTeam1
        LOOP
            INSERT INTO PlayerXSoccerMatchXTeam(idPlayerXSoccerMatchXTeam, idPerson, idSoccerMatch, idTeam, yellowCards, redCards, offsides, corners, goals, saves, userCreation, lastUser, lastDate, dateCreation)
            VALUES(s_player_soccerMatch_team.NEXTVAL, playerIndex, pIdMatch, pIdTeam1, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL);
    END 

    CURSOR playersTeam2 IS

    SELECT Player.idPerson
    FROM Player
    WHERE Player.idTeam = pIdTeam2;

    BEGIN
        FOR playerIndex IN playersTeam2
        LOOP
            INSERT INTO PlayerXSoccerMatchXTeam(idPlayerXSoccerMatchXTeam, idPerson, idSoccerMatch, idTeam, yellowCards, redCards, offsides, corners, goals, saves, userCreation, lastUser, lastDate, dateCreation)
            VALUES(s_player_soccerMatch_team.NEXTVAL, playerIndex, pIdMatch, pIdTeam2, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL);
    END 

END PlayerMatchTeamInsertion;