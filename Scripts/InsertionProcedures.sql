-- Event
CREATE OR REPLACE PROCEDURE insertEvent (pTypeEvent IN VARCHAR2) AS
BEGIN
    INSERT INTO Event (idEvent, typeEvent, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_event.nextval, pTypeEvent, NULL, NULL, NULL, NULL);
    COMMIT;
END insertEvent;

-- GroupEvent
CREATE OR REPLACE PROCEDURE insertGroupEvent (pIdEvent IN NUMBER, pDescription IN VARCHAR2) AS
BEGIN
    INSERT INTO GroupEvent (idGroupEvent, idEvent, descriptionGroupEvent, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_groupEvent.nextval, pIdEvent, pDescription, NULL, NULL, NULL, NULL);
    COMMIT;
END insertGroupEvent;

-- CountryTeam
CREATE OR REPLACE PROCEDURE insertCountryTeam (pIdContinent IN NUMBER, pNameCountryTeam IN VARCHAR2, pFlag IN VARCHAR2) AS
BEGIN
    INSERT INTO CountryTeam (idCountryTeam, idContinent, nameCountryTeam, flag, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_countryTeam.nextval, pIdContinent, pNameCountryTeam, pFlag, NULL, NULL, NULL, NULL);
    COMMIT;
END insertCountryTeam;

-- Team
CREATE OR REPLACE PROCEDURE insertTeam(pIdCountryTeam IN NUMBER, pIdGroupEvent IN NUMBER, pNameTeam IN VARCHAR2)
AS
BEGIN
    INSERT INTO Team(idTeam, idCountryTeam, idGroupEvent, nameTeam, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_team.NEXTVAL, pIdCountryTeam, pIdGroupEvent, pNameTeam, NULL, NULL, NULL, NULL);
    COMMIT;
END insertTeam;

-- GroupStats
CREATE OR REPLACE PROCEDURE insertGroupStats (pIdTeam IN NUMBER, pWonMatches IN NUMBER, pTiedMatches IN NUMBER, pLostMatches IN NUMBER, pGoalsScored IN NUMBER, pGoalsReceived IN NUMBER, pFairPlayPoints IN NUMBER) AS
BEGIN
    INSERT INTO GroupStats (idStats, idTeam, wonMatches, tiedMatches, lostMatches, goalsScored, goalsReceived, fairPlayPoints, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_groupstats.nextval, pIdTeam, pWonMatches, pTiedMatches, pLostMatches, pGoalsScored, pGoalsReceived, pFairPlayPoints, NULL, NULL, NULL, NULL);
    COMMIT;
END insertGroupStats;

---------------------------------------------------------------------------------------------------
-- PersonXPhone
CREATE OR REPLACE PROCEDURE insertPersonXPhone(pIdPerson IN NUMBER,pIdPhone IN NUMBER)
AS
BEGIN
    INSERT INTO PersonXPhone(idPersonXPhone, idPerson ,idPhone, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_personxphone.NEXTVAL, pIdPerson, pIdPhone, NULL, NULL, NULL, NULL);
END insertPersonXPhone;

-- Phone
CREATE OR REPLACE PROCEDURE insertPhone (pPhoneNumber IN NUMBER) AS
BEGIN
    BEGIN
        INSERT INTO Phone (idPhone, phoneNumber, userCreation, lastUser, lastDate, dateCreation)
        VALUES (s_phone.nextval, pPhoneNumber, NULL, NULL, NULL, NULL);
    END;
END insertPhone;

-- Mail
CREATE OR REPLACE PROCEDURE insertMail (pIdPerson IN NUMBER, pDescription IN VARCHAR2) AS
BEGIN
    INSERT INTO Mail (idMail, idPerson, descriptionMail, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_mail.nextval, pidPerson, pDescription, NULL, NULL, NULL, NULL);
END insertMail;

-- Address
CREATE OR REPLACE PROCEDURE insertAddress (pIdDistrict IN NUMBER, pDescriptionAddress IN VARCHAR2) AS
BEGIN
    INSERT INTO Address (idAddress, idDistrict, descriptionAddress, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_address.nextval, pIdDistrict, pDescriptionAddress, NULL, NULL, NULL, NULL);
END insertAddress;

-- Person
CREATE OR REPLACE PROCEDURE insertPerson (pIdentification IN NUMBER, pFirstName IN VARCHAR2, 
            pSecondName IN VARCHAR2, pFirstLastName IN VARCHAR2, pSecondLastName IN VARCHAR2, 
            pPhoto IN VARCHAR2, pIdPersonPosition IN NUMBER, pIdAddress IN NUMBER, 
            pIdTypeIdentification IN NUMBER, pIdGender IN NUMBER)
AS
BEGIN
    INSERT INTO Person(idPerson, identification, firstName, secondName, 
                firstLastName, secondLastName, photo, idPersonPosition, idAddress, 
                idTypeIdentification, idGender, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_person.nextval, pIdentification, pFirstName, pSecondName, pFirstLastName, pSecondLastName, 
            pPhoto, pIdPersonPosition, pIdAddress, pIdTypeIdentification, pIdGender, NULL, NULL, NULL, NULL);
END insertPerson;

----------------------------------------------------------------------------------------------------------
-- Player
CREATE OR REPLACE PROCEDURE insertPlayer (pIdentification IN NUMBER, pFirstName IN VARCHAR2, 
            pSecondName IN VARCHAR2, pFirstLastName IN VARCHAR2, pSecondLastName IN VARCHAR2, 
            pPhoto IN VARCHAR2, pIdPersonPosition IN NUMBER, pIdTypeIdentification IN NUMBER, 
            pIdGender IN NUMBER, pIdTeam IN NUMBER, pBirthdate VARCHAR2, 
            pTShirtNum NUMBER, pPhoneNumber IN NUMBER,pMail IN VARCHAR2, pIdDistrict IN NUMBER,
            pDescriptionAddress IN VARCHAR2, codResult OUT NUMBER)
AS
BEGIN
    BEGIN
        insertAddress (pIdDistrict, pDescriptionAddress);  
        insertPerson (pIdentification, pFirstName, pSecondName, pFirstLastName, 
                      pSecondLastName, pPhoto, pIdPersonPosition, s_address.currval, 
                      pIdTypeIdentification, pIdGender);
            
        INSERT INTO Player(idPerson, idTeam, birthdate, tShirtNum, userCreation, lastUser, lastDate, dateCreation)
        VALUES (s_person.currval, pIdTeam, TO_DATE(pBirthdate), pTShirtNum, NULL, NULL, NULL, NULL); 
            
        insertMail (s_person.currval, pMail);
        insertPhone (pPhoneNumber);
        insertPersonXPhone (s_person.currval, s_phone.currval);
        
        codResult:= 0;
        COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
    END;
END insertPlayer;

-- TeamWorker
CREATE OR REPLACE PROCEDURE insertTeamWorker(pIdentification IN NUMBER, pIdTeam IN NUMBER, pFirstName IN VARCHAR2, 
                pSecondName IN VARCHAR2, pFirstLastName IN VARCHAR2, pSecondLastName IN VARCHAR2,
                pPhoto IN VARCHAR2, pIdPersonPosition IN NUMBER, pIdTypeIdentification IN NUMBER, 
                pIdGender IN NUMBER, pPhoneNumber IN NUMBER, pIdDistrict IN NUMBER, 
                pMail IN VARCHAR2, pDescriptionAddress IN VARCHAR2, codResult OUT NUMBER)
AS
BEGIN
    BEGIN
        insertAddress (pIdDistrict, pDescriptionAddress); 
        
        insertPerson (pIdentification, pFirstName, pSecondName, pFirstLastName, 
                      pSecondLastName, pPhoto, pIdPersonPosition, s_address.currval, 
                      pIdTypeIdentification, pIdGender);

        INSERT INTO TeamWorker(idPerson, idTeam, userCreation, lastUser, lastDate, dateCreation)
        VALUES (s_person.currval, pIdTeam, NULL, NULL, NULL, NULL);
        
        insertMail (s_person.currval, pMail);
        insertPhone (pPhoneNumber);
        insertPersonXPhone (s_person.currval, s_phone.currval);
        
        codResult:= 0;   
        COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
    END;
END insertTeamWorker;

-- UserPerson
CREATE OR REPLACE PROCEDURE insertUserPerson(pUsername IN VARCHAR2, pUserType IN VARCHAR2, pPassword IN VARCHAR2, 
            pIdentification IN NUMBER, pFirstName IN VARCHAR2, 
            pSecondName IN VARCHAR2, pFirstLastName IN VARCHAR2, pSecondLastName IN VARCHAR2, 
            pPhoto IN VARCHAR2, pIdPersonPosition IN NUMBER,
            pIdTypeIdentification IN NUMBER, pIdGender IN NUMBER, pMail IN VARCHAR2, pPhoneNumber IN NUMBER,
            pIdDistrict IN NUMBER, pDescriptionAddress IN VARCHAR2)
AS 
vnIdUserType NUMBER(10);
vnPassword VARCHAR2(200);
BEGIN
    BEGIN
        SELECT ut.idUserType
        INTO vnIdUserType
        FROM UserType UT
        WHERE ut.descriptionUserType = pUserType;
    END;

    BEGIN 
        insertAddress (pIdDistrict, pDescriptionAddress); 
        
        insertPerson (pIdentification, pFirstName, pSecondName, pFirstLastName, 
                      pSecondLastName, pPhoto, pIdPersonPosition, s_address.currval, 
                      pIdTypeIdentification, pIdGender);
                      
        encryptionPassword (pPassword,  vnPassword);

        INSERT INTO UserPerson(username, idUserType, idPerson, passwordUser, 
                               userCreation, lastUser, lastDate, dateCreation)
        VALUES(pUsername, vnIdUserType,s_person.currval, vnPassword, NULL, NULL, NULL, NULL);
            
        insertMail (s_person.currval, pMail);
        insertPhone (pPhoneNumber);
        insertPersonXPhone (s_person.currval, s_phone.currval);
        
        COMMIT;
    END;
END insertUserPerson;

----------------------------------------------------------------------------------------------------------------
-- SoccerMatch
CREATE OR REPLACE PROCEDURE insertSoccerMatch(pIdStadium IN NUMBER, pDateHour IN DATE)
AS
BEGIN
    INSERT INTO SoccerMatch(idSoccerMatch, idStadium, dateHour, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_soccerMatch.NEXTVAL, pIdStadium, pDateHour, NULL, NULL, NULL, NULL);
    COMMIT;
END insertSoccerMatch;

------------------------Insertion PlayerXSoccerMatchXTeam ---------------------
CREATE OR REPLACE PROCEDURE insertTeam1(pIdMatch IN NUMBER, pIdTeam1 IN NUMBER) AS
vnIdPlayer NUMBER;
    CURSOR playersTeam1 IS
    SELECT Player.idPerson
    FROM Player
    WHERE Player.idTeam = pIdTeam1;
    
BEGIN
    OPEN playersTeam1;
    LOOP
        FETCH playersTeam1 INTO vnIdPlayer;
        EXIT WHEN playersTeam1%NOTFOUND;     
        INSERT INTO PlayerXSoccerMatchXTeam(idPlayerXMatchXTeam, idPerson, idSoccerMatch, idTeam, yellowCards, redCards, offsides, corners, goals, saves, userCreation, lastUser, lastDate, dateCreation)
        VALUES(s_player_soccerMatch_team.NEXTVAL, vnIdPlayer, pIdMatch, pIdTeam1, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL);
        COMMIT;
    END LOOP;
    CLOSE playersTeam1;
END insertTeam1;

CREATE OR REPLACE PROCEDURE insertTeam2(pIdMatch IN NUMBER, pIdTeam2 IN NUMBER) 
AS
vnIdPlayer NUMBER;
    CURSOR playersTeam2 IS
    SELECT Player.idPerson
    FROM Player
    WHERE Player.idTeam = pIdTeam2;

BEGIN
    OPEN playersTeam2;
    LOOP
    FETCH playersTeam2 INTO vnIdPlayer;
    EXIT WHEN playersTeam2%NOTFOUND;
        INSERT INTO PlayerXSoccerMatchXTeam(idPlayerXMatchXTeam, idPerson, idSoccerMatch, idTeam, yellowCards, redCards, offsides, corners, goals, saves, userCreation, lastUser, lastDate, dateCreation)
        VALUES(s_player_soccerMatch_team.NEXTVAL, vnIdPlayer, pIdMatch, pIdTeam2, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL);
        COMMIT;
    END LOOP;
    CLOSE playersTeam2;
END insertTeam2;


CREATE OR REPLACE PROCEDURE insertPlayerXMatchXTeam(pIdMatch IN NUMBER, pIdTeam1 IN NUMBER, pIdTeam2 IN NUMBER)
AS
BEGIN
    insertTeam1(pIdMatch, pIdTeam1);
    insertTeam2(pIdMatch, pIdTeam2); 
END insertPlayerXMatchXTeam;

--------------------------------------------------------------------------------------------------
-- News
CREATE OR REPLACE PROCEDURE insertNews (pIdNewsStatus IN NUMBER, pIdNewsType IN NUMBER, pTitle IN VARCHAR2, pPublicationDate IN DATE, pLinkNews IN VARCHAR2, pPhoto IN VARCHAR2, pTextNews IN VARCHAR2, idNews OUT NUMBER) AS
BEGIN
    INSERT INTO News (idNews, idNewsStatus, idNewsType, title, publicationDate, viewsNews, linkNews, photo, textNews, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_news.nextval, pIdNewsStatus, pIdNewsType, pTitle, pPublicationDate, 0, pLinkNews, pPhoto, pTextNews, NULL, NULL, NULL, NULL);

    idNews:= s_news.currval;
    COMMIT;
    
END insertNews;

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

-- NewsComment
CREATE OR REPLACE PROCEDURE insertNewsComment (pIdNews IN NUMBER, pUsername IN VARCHAR2, ptextNewsComment IN VARCHAR2)
AS
BEGIN
    INSERT INTO NewsComment(idNewsComment, username, idNews, textNewsComment, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsComment.nextval, pUsername, pIdNews, ptextNewsComment, NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsComment;

-- Rating
CREATE OR REPLACE PROCEDURE insertRating(pUsername IN VARCHAR2, pIdNews IN NUMBER, pRating IN NUMBER)
AS
BEGIN
    INSERT INTO Rating(idRating, username, idNews, rating, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_rating.NEXTVAL, pUsername, pIdNews, pRating, NULL, NULL, NULL, NULL);
    COMMIT;
END insertRating;

----------------------------------------------------------------------------------------------------

-- NewsChange
CREATE OR REPLACE PROCEDURE insertNewsChange (pIdNews IN NUMBER, pIdBlog IN NUMBER, pUsername IN VARCHAR2, pCurrentText IN VARCHAR2, pPreviousText IN VARCHAR2, pDescriptionNewsChange IN VARCHAR2, pDateHour IN DATE) AS
BEGIN
    INSERT INTO NewsChange (idNewsChange, idNews, idBlog, username, currentText, previousText, descriptionNewsChange, dateHour, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newschange.nextval, pIdNews, pIdBlog, pUsername, pCurrentText, pPreviousText, pDescriptionNewsChange, pDateHour, NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsChange;

-- ParameterTable
CREATE OR REPLACE PROCEDURE insertParameterTable (pNameParameter IN VARCHAR2, pValueParameter IN NUMBER) AS
BEGIN
    INSERT INTO ParameterTable (idParameterTable, nameParameter, valueParameter, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_parameter.nextval, pNameParameter, pValueParameter, NULL, NULL, NULL, NULL);
    COMMIT;
END insertParameterTable;



















