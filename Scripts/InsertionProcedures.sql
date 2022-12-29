-- Address
CREATE OR REPLACE PROCEDURE insertAddress (pIdDistrict IN NUMBER, pDescriptionAddress IN VARCHAR2) AS
BEGIN
    INSERT INTO Address (idAddress, idDistrict, descriptionAddress, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_address.nextval, pIdDistrict, pDescriptionAddress, NULL, NULL, NULL, NULL);
    COMMIT;
END insertAddress;

-- CountryTeam
CREATE OR REPLACE PROCEDURE insertCountryTeam (pIdContinent IN NUMBER, pNameCountryTeam IN VARCHAR2) AS
BEGIN
    INSERT INTO CountryTeam (idCountryTeam, idContinent, nameCountryTeam, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_countryTeam.nextval, pIdContinent, pNameCountryTeam, NULL, NULL, NULL, NULL);
    COMMIT;
END insertCountryTeam;

-- Event
CREATE OR REPLACE PROCEDURE insertEvent (pTypeEvent IN VARCHAR2) AS
BEGIN
    INSERT INTO Event (idEvent, typeEvent, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_event.nextval, pTypeEvent, NULL, NULL, NULL, NULL);
    COMMIT;
END insertEvent;

-- EventWorker
CREATE OR REPLACE PROCEDURE insertEventWorker (pIdentification IN NUMBER, pFirstName IN VARCHAR2, pSecondName IN VARCHAR2, pFirstLastName IN VARCHAR2, pSecondLastName IN VARCHAR2,
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
END insertEventWorker;

--FavoriteNews
CREATE OR REPLACE PROCEDURE insertFavoriteNews (pUsername IN VARCHAR2, pIdNews IN NUMBER) AS
BEGIN
    INSERT INTO FavoriteNews (idFavoriteNews, username, idNews, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_favoriteNews.nextval, pUsername, pIdNews, NULL, NULL, NULL, NULL);
    COMMIT;
END insertFavoriteNews;

--UserXNews
CREATE OR REPLACE PROCEDURE insertUserXNews(pUsername IN VARCHAR2, pIdNews IN NUMBER) AS
BEGIN
    INSERT INTO UserXNews (idUserXNews, username, idNews, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_userxnews.nextval, pUsername, pIdNews, NULL, NULL, NULL, NULL);
    COMMIT;
END insertUserXNews;

-- GroupEvent
CREATE OR REPLACE PROCEDURE insertGroupEvent (pIdEvent IN NUMBER, pDescription IN VARCHAR2) AS
BEGIN
    INSERT INTO GroupEvent (idGroupEvent, idEvent, descriptionGroupEvent, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_groupEvent.nextval, pIdEvent, pDescription, NULL, NULL, NULL, NULL);
    COMMIT;
END insertGroupEvent;

-- GroupStats
CREATE OR REPLACE PROCEDURE insertGroupStats (pIdTeam IN NUMBER, pWonMatches IN NUMBER, pTiedMatches IN NUMBER, pLostMatches IN NUMBER, pGoalsScored IN NUMBER, pGoalsReceived IN NUMBER, pFairPlayPoints IN NUMBER) AS
BEGIN
    INSERT INTO GroupStats (idStats, idTeam, wonMatches, tiedMatches, lostMatches, goalsScored, goalsReceived, fairPlayPoints, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_groupstats.nextval, pIdTeam, pWonMatches, pTiedMatches, pLostMatches, pGoalsScored, pGoalsReceived, pFairPlayPoints, NULL, NULL, NULL, NULL);
    COMMIT;
END insertGroupStats;

-- Mail
CREATE OR REPLACE PROCEDURE insertMail (pIdPerson IN NUMBER, pDescription IN VARCHAR2) AS
BEGIN
    INSERT INTO Mail (idMail, idPerson, descriptionMail, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_mail.nextval, pidPerson, pDescription, NULL, NULL, NULL, NULL);
    COMMIT;
END insertMail;

-- News
CREATE OR REPLACE PROCEDURE insertNews (pIdNewsStatus IN NUMBER, pIdNewsType IN NUMBER, pTitle IN VARCHAR2, pPublicationDate IN DATE, pViewsNews IN NUMBER, pLinkNews IN VARCHAR2, pPhoto IN VARCHAR2, pTextNews IN VARCHAR2) AS
BEGIN
    INSERT INTO News (idNews, idNewsStatus, idNewsType, title, publicationDate, viewsNews, linkNews, photo, textNews, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_news.nextval, pIdNewsStatus, pIdNewsType, pTitle, pPublicationDate, pViewsNews, pLinkNews, pPhoto, pTextNews, NULL, NULL, NULL, NULL);
    COMMIT;
END insertNews;

-- NewsChange
CREATE OR REPLACE PROCEDURE insertNewsChange (pIdNews IN NUMBER, pIdBlog IN NUMBER, pUsername IN VARCHAR2, pCurrentText IN VARCHAR2, pPreviousText IN VARCHAR2, pDescriptionNewsChange IN VARCHAR2, pDateHour IN DATE) AS
BEGIN
    INSERT INTO NewsChange (idNewsChange, idNews, idBlog, username, currentText, previousText, descriptionNewsChange, dateHour, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newschange.nextval, pIdNews, pIdBlog, pUsername, pCurrentText, pPreviousText, pDescriptionNewsChange, pDateHour, NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsChange;

-- EventWorkerXMatch
CREATE OR REPLACE PROCEDURE insertEventWorkerXMatch (pIdPerson IN NUMBER, pIdSoccerMatch IN NUMBER) AS
BEGIN
    INSERT INTO NewsChange (idEventWorkerXSoccerMatch, idPerson, idSoccerMatch, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_eventworkerxsoccermatch.nextval, pIdPerson, pIdSoccerMatch, NULL, NULL, NULL, NULL);
    COMMIT;
END insertEventWorkerXMatch;

-- NewsComment
CREATE OR REPLACE PROCEDURE insertNewsComment (pIdNews IN NUMBER, pUsername IN VARCHAR2, ptextNewsComment IN VARCHAR2)
AS
BEGIN
    INSERT INTO NewsComment(idNewsComment, username, idNews, textNewsComment, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsComment.nextval, pUsername, pIdNews, ptextNewsComment, NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsComment;

-- ParameterTable
CREATE OR REPLACE PROCEDURE insertParameterTable (pNameParameter IN VARCHAR2, pValueParameter IN NUMBER) AS
BEGIN
    INSERT INTO ParameterTable (idParameterTable, nameParameter, valueParameter, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_parameter.nextval, pNameParameter, pValueParameter, NULL, NULL, NULL, NULL);
    COMMIT;
END insertParameterTable;

-- Phone
CREATE OR REPLACE PROCEDURE insertPhone (pPhoneNumber IN NUMBER) AS
BEGIN
    INSERT INTO Phone (idPhone, phoneNumber, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_phone.nextval, pPhoneNumber, NULL, NULL, NULL, NULL);
    COMMIT;
END insertPhone;

-- Person
CREATE OR REPLACE PROCEDURE insertPerson (pIdPerson IN NUMBER, pIdentification IN NUMBER, pFirstName IN VARCHAR2, 
            pSecondName IN VARCHAR2, pFirstLastName IN VARCHAR2, pSecondLastName IN VARCHAR2, 
            pPhoto IN VARCHAR2, pIdPersonPosition IN NUMBER, pIdCountry IN NUMBER, 
            pIdTypeIdentification IN NUMBER, pIdGender IN NUMBER)
AS
BEGIN
    INSERT INTO Person(idPerson, identification, firstName, secondName, 
                firstLastName, secondLastName, photo, idPersonPosition, idCountry, 
                idTypeIdentification, idGender, userCreation, lastUser, lastDate, dateCreation)
    VALUES (pIdPerson, pIdentification, pFirstName, pSecondName, pFirstLastName, pSecondLastName, 
            pPhoto, pIdPersonPosition, pIdCountry, pIdTypeIdentification, pIdGender, NULL, NULL, NULL, NULL);
    
    COMMIT;
END insertPerson;

-- Player
CREATE OR REPLACE PROCEDURE insertPlayer (pIdentification IN NUMBER, pFirstName IN VARCHAR2, 
            pSecondName IN VARCHAR2, pFirstLastName IN VARCHAR2, pSecondLastName IN VARCHAR2, 
            pPhoto IN VARCHAR2, pIdPersonPosition IN NUMBER, pIdCountry IN NUMBER, 
            pIdTypeIdentification IN NUMBER, pIdGender IN NUMBER, pIdTeam IN NUMBER, pBirthdate DATE, 
            pTShirtNum NUMBER, pPhoneNumber IN NUMBER)
AS
BEGIN
    BEGIN
        DECLARE idPersonInsertion NUMBER :=s_person.nextval;
        
        EXEC insertPerson (idPersonInsertion, pIdentification, pFirstName, pSecondName, pFirstLastName, 
                    pSecondLastName, pPhoto, pIdPersonPosition, pIdCountry, pIdTypeIdentification, pIdGender);
     
        BEGIN
            INSERT INTO Player(idPerson, idTeam, birthdate, tShirtNum, userCreation, lastUser, lastDate, dateCreation)
            VALUES (idPersonInsertion, pIdTeam, pBirthdate, pTShirtNum, NULL, NULL, NULL, NULL); 
        END;
    END;
    
    BEGIN
        IF (pPhoneNumber IS NOT NULL) THEN
            DECLARE idPhoneInsertion NUMBER :=s_phone.nextval;
            
            EXEC insertPhone (pPhoneNumber);
            EXEC insertPersonXPhone (idPersonInsertion,idPhoneInsertion);
            
            BEGIN
                COMMIT;
            END;
        ELSE 
             COMMIT;
        END IF; 
        
    END;
END insertPlayer;

-- PersonXPhone
CREATE OR REPLACE PROCEDURE insertPersonXPhone (pIdPerson IN NUMBER,pIdPhone IN NUMBER)
AS
BEGIN
    INSERT INTO Person(idPerson ,idPhone, userCreation, lastUser, lastDate, dateCreation)
    VALUES (pIdPerson, pIdPhone, NULL, NULL, NULL, NULL);
    COMMIT;
END insertPersonXPhone;

-- Rating
CREATE OR REPLACE PROCEDURE insertRating(pUsername IN NUMBER, pIdNews IN NUMBER, pRating IN NUMBER)
AS
BEGIN
    INSERT INTO Rating(idRating, username, idNews, rating, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_rating.NEXTVAL, pUsername, pIdNews, pRating, NULL, NULL, NULL, NULL);
    COMMIT;
END insertRating;

-- SoccerMatch
CREATE OR REPLACE PROCEDURE insertSoccerMatch(pDateHour IN DATE)
AS
BEGIN
    INSERT INTO SoccerMatch(idSoccerMatch, dateHour, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_soccerMatch.NEXTVAL, pDateHour, NULL, NULL, NULL, NULL);
    COMMIT;
END insertSoccerMatch;

-- Team
CREATE OR REPLACE PROCEDURE insertTeam(pIdCountryTeam IN NUMBER, pIdGroupEvent IN NUMBER, pNameTeam IN VARCHAR2)
AS
BEGIN
    INSERT INTO Team(idTeam, idCountryTeam, idGroupEvent, nameTeam, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_team.NEXTVAL, pIdCountryTeam, pIdGroupEvent, pNameTeam, NULL, NULL, NULL, NULL);
    COMMIT;
END insertTeam;

-- TeamWorker
CREATE OR REPLACE PROCEDURE insertTeamWorker(pIdentification IN NUMBER, pFirstName IN VARCHAR2, pSecondName IN VARCHAR2, pFirstLastName IN VARCHAR2, pSecondLastName IN VARCHAR2,
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
END insertTeamWorker;

-- UserPerson
CREATE OR REPLACE PROCEDURE insertUserPerson(pUsername IN VARCHAR2, pIdUserType IN NUMBER, pIdPerson IN NUMBER, pPassword IN VARCHAR2)
AS 
BEGIN
    INSERT INTO UserPerson(username, idUserType, idPerson, passwordUser, userCreation, lastUser, lastDate, dateCreation)
    VALUES(pUsername, pIdUserType, pIdPerson, pPassword, NULL, NULL, NULL, NULL);
    COMMIT;
END insertUserPerson;

-- Insertion PlayerXSoccerMatchXTeam
CREATE OR REPLACE PROCEDURE insertPlayerXMatchXTeam(pIdMatch IN NUMBER, pIdTeam1 IN NUMBER, pIdTeam2 IN NUMBER)
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
    COMMIT;

END insertPlayerXMatchXTeam;