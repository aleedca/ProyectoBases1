/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Insertion Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

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
CREATE OR REPLACE PROCEDURE insertCountryTeam (pIdContinent IN NUMBER, pNameCountryTeam IN VARCHAR2) AS
BEGIN
    INSERT INTO CountryTeam (idCountryTeam, idContinent, nameCountryTeam, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_countryTeam.nextval, pIdContinent, pNameCountryTeam, NULL, NULL, NULL, NULL);
    COMMIT;
END insertCountryTeam;

-- Team
CREATE OR REPLACE PROCEDURE insertTeam(pIdCountryTeam IN NUMBER, pNameTeam IN VARCHAR2, pFlag IN VARCHAR2)
AS
BEGIN
    INSERT INTO Team(idTeam, idCountryTeam, nameTeam, flag, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_team.NEXTVAL, pIdCountryTeam, pNameTeam, pFlag, NULL, NULL, NULL, NULL);
    COMMIT;
END insertTeam;

-- GroupStats
CREATE OR REPLACE PROCEDURE insertGroupStats (pIdTeam IN NUMBER, pWonMatches IN NUMBER, pTiedMatches IN NUMBER, pLostMatches IN NUMBER, pGoalsScored IN NUMBER, pGoalsReceived IN NUMBER, pFairPlayPoints IN NUMBER) AS
BEGIN
    INSERT INTO GroupStats (idStats, idTeam, wonMatches, tiedMatches, lostMatches, goalsScored, goalsReceived, fairPlayPoints, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_groupstats.nextval, pIdTeam, pWonMatches, pTiedMatches, pLostMatches, pGoalsScored, pGoalsReceived, pFairPlayPoints, NULL, NULL, NULL, NULL);
    COMMIT;
END insertGroupStats;

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

-- SoccerMatch
CREATE OR REPLACE PROCEDURE insertSoccerMatch(pIdStadium IN NUMBER, pDateHour IN VARCHAR2, codResult OUT NUMBER)
AS
BEGIN
    INSERT INTO SoccerMatch(idSoccerMatch, idStadium, dateHour, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_soccerMatch.NEXTVAL, pIdStadium, TO_DATE(pDateHour, 'DD-MM-YYYY HH24:MI'), NULL, NULL, NULL, NULL);
    
    codResult:=0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END insertSoccerMatch;

--Insertion PlayerXSoccerMatchXTeam ---------------------
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

----------------------------------------------------------------------------------------------------------------
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

/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Update Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

--- FIRSTNAME
CREATE OR REPLACE PROCEDURE updateFirstName (pidPerson IN NUMBER, pFirstName IN VARCHAR2, codResult OUT NUMBER) AS
BEGIN
    UPDATE Person
    SET firstName = pFirstName
    WHERE idPerson = pidPerson;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updateFirstName;

--- SECONDNAME
CREATE OR REPLACE PROCEDURE updateSecondName (pidPerson IN NUMBER, pSecondName IN VARCHAR2, codResult OUT NUMBER) AS
BEGIN
    UPDATE Person
    SET secondName = pSecondName
    WHERE idPerson = pidPerson;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateSecondName;

--- FIRSTLASTNAME
CREATE OR REPLACE PROCEDURE updateFirstLastName (pidPerson IN NUMBER, pFirstLastName IN VARCHAR2, codResult OUT NUMBER) AS
BEGIN
    UPDATE Person
    SET firstLastName = pFirstLastName
    WHERE idPerson = pidPerson;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateFirstLastName;

--- SECONDLASTNAME
CREATE OR REPLACE PROCEDURE updateSecondLastName (pidPerson IN NUMBER, pSecondLastName IN VARCHAR2, codResult OUT NUMBER) AS
BEGIN
    UPDATE Person
    SET secondLastName = pSecondLastName
    WHERE idPerson = pidPerson;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateSecondLastName;

--- TYPEIDENTIFICATION
CREATE OR REPLACE PROCEDURE updateTypeIdentification(pidPerson IN NUMBER, pTypeIdentification IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE Person
    SET idTypeIdentification = pTypeIdentification
    WHERE idPerson = pidPerson;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateTypeIdentification;

--- IDENTIFICATION
CREATE OR REPLACE PROCEDURE updateIdentification(pidPerson IN NUMBER, pIdentification IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE Person
    SET identification = pIdentification
    WHERE idPerson = pidPerson;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateIdentification;

--- MAIL
CREATE OR REPLACE PROCEDURE updateMail(pidPerson IN NUMBER, pMail IN VARCHAR2, codResult OUT NUMBER) AS
BEGIN
    UPDATE Mail
    SET descriptionMail = pMail
    WHERE mail.idPerson = pidPerson;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateMail;

--- TEAM
CREATE OR REPLACE PROCEDURE updateTeam(pidPerson IN NUMBER, pidTeam IN NUMBER, codResult OUT NUMBER) AS
vnIdPerson NUMBER(10);
BEGIN
    BEGIN
        SELECT idPerson
        INTO vnIdPerson
        FROM Player 
        WHERE idPerson = pidPerson;
    EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        vnIdPerson:=-1; 
    END;

    IF(vnIdPerson != -1)
    THEN
        UPDATE Player
        SET idTeam = pidTeam
        WHERE idPerson = vnIdPerson;
    ELSE
        UPDATE TeamWorker
        SET idTeam = pidTeam
        WHERE idPerson = pidPerson;
    END IF;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateTeam;

--- PERSONPOSITION
CREATE OR REPLACE PROCEDURE updatePersonPosition(pidPerson IN NUMBER, pPosition IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE Person
    SET idPersonPosition = pPosition
    WHERE idPerson = pidPerson;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updatePersonPosition;

--- PHONE
CREATE OR REPLACE PROCEDURE updatePhone(pidPerson IN NUMBER, pPhoneNumber IN NUMBER, codResult OUT NUMBER) AS
vnIdPhone NUMBER(10);
BEGIN
    BEGIN
        SELECT idPhone
        INTO vnIdPhone
        FROM PersonXPhone
        WHERE idPerson = pidPerson;
    EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        vnIdPhone:=-1; 
    END;

    IF(vnIdPhone != -1)
    THEN
        UPDATE Phone
        SET phoneNumber = pPhoneNumber
        WHERE idPhone = vnIdPhone;
    END IF;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updatePhone;

--- GENDER
CREATE OR REPLACE PROCEDURE updateGender(pidPerson IN NUMBER, pidGender IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE Person
    SET idGender= pidGender
    WHERE idPerson = pidPerson;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateGender;


--- ADDRESS
CREATE OR REPLACE PROCEDURE updateAddress(pidAddress IN NUMBER, pDescriptionAddress IN VARCHAR2, codResult OUT NUMBER) AS
BEGIN
    UPDATE Address
    SET descriptionAddress = pDescriptionAddress
    WHERE idAddress = pidAddress;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateAddress;

--- DISTRICT
CREATE OR REPLACE PROCEDURE updateDistrict(pidPerson IN NUMBER, pidDistrict IN NUMBER, codResult OUT NUMBER) AS
vnIdAddress NUMBER(10);
BEGIN
    SELECT idAddress
    INTO vnIdAddress
    FROM Person
    WHERE idPerson = pidPerson;

    UPDATE Address
    SET idDistrict = pidDistrict
    WHERE idAddress = vnIdAddress;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateDistrict;

--- CANTON
CREATE OR REPLACE PROCEDURE updateCanton(pidPerson IN NUMBER, pidCanton IN NUMBER, codResult OUT NUMBER) AS
vnIdDistrict NUMBER(10);
BEGIN
    SELECT d.idDistrict
    INTO vnIdDistrict
    FROM Person P
    INNER JOIN Address A ON p.idAddress = a.idAddress
    INNER JOIN District D ON a.idDistrict = d.idDistrict
    WHERE p.idPerson = pidPerson;

    UPDATE District
    SET idCanton = pidCanton
    WHERE idDistrict = vnIdDistrict;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateCanton;

--- PROVINCE
CREATE OR REPLACE PROCEDURE updateProvince(pidPerson IN NUMBER, pidProvince IN NUMBER, codResult OUT NUMBER) AS
vnIdCanton NUMBER(10);
BEGIN
    SELECT c.idCanton
    INTO vnIdCanton
    FROM Person P
    INNER JOIN Address A ON p.idAddress = a.idAddress
    INNER JOIN District D ON a.idDistrict = d.idDistrict
    INNER JOIN Canton C ON d.idCanton = c.idCanton
    WHERE p.idPerson = pidPerson;

    UPDATE Canton
    SET idProvince = pidProvince
    WHERE idCanton = vnIdCanton;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateProvince;


--- COUNTRY
CREATE OR REPLACE PROCEDURE updateCountry(pidPerson IN NUMBER, pidCountry IN NUMBER, codResult OUT NUMBER) AS
vnIdProvince NUMBER(10);
BEGIN
    SELECT pv.idProvince
    INTO vnIdProvince
    FROM Person P
    INNER JOIN Address A ON p.idAddress = a.idAddress
    INNER JOIN District D ON a.idDistrict = d.idDistrict
    INNER JOIN Canton C ON d.idCanton = c.idCanton
    INNER JOIN Province PV ON c.idProvince = pv.idProvince
    WHERE p.idPerson = pidPerson;
    
    UPDATE Province
    SET idCountry = pidCountry
    WHERE idProvince = vnIdProvince;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateCountry;

--- PHOTO
CREATE OR REPLACE PROCEDURE updatePhoto(pidPerson IN NUMBER, pPhoto IN VARCHAR2, codResult OUT NUMBER) AS
BEGIN
    UPDATE Person
    SET photo = pPhoto
    WHERE idPerson = pidPerson;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updatePhoto;

--- BIRTHDATE
CREATE OR REPLACE PROCEDURE updateBirthDate(pidPerson IN NUMBER, pBirthDate IN VARCHAR2, codResult OUT NUMBER) AS
BEGIN
    UPDATE Player
    SET birthdate = TO_DATE (pBirthDate)
    WHERE idPerson = pidPerson;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateBirthDate;

--- NUMBER OF T-SHIRT
CREATE OR REPLACE PROCEDURE updateTShirtNum(pidPerson IN NUMBER, pTShirtNum IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE Player
    SET tShirtNum = pTShirtNum
    WHERE idPerson = pidPerson;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateTShirtNum;

-------------- NEWS -----------------
-- Status
CREATE OR REPLACE PROCEDURE updateStatus(pIdNews IN NUMBER, pIdNewsStatus IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE News
    SET idNewsStatus = pIdNewsStatus
    WHERE idNews = pIdNews;
    
    codResult:= 0;
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updateStatus ;

-- Type
CREATE OR REPLACE PROCEDURE updateType(pIdNews IN NUMBER, pIdNewsType IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE News
    SET idNewsType = pIdNewsType
    WHERE idNews = pIdNews;
    
    codResult:= 0;
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updateType;

-- Title
CREATE OR REPLACE PROCEDURE updateTitle(pIdNews IN NUMBER, pTitle IN VARCHAR2, codResult OUT NUMBER) AS
BEGIN
    UPDATE News
    SET title = pTitle
    WHERE idNews = pIdNews;
    
    codResult:= 0;
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updateTitle;

-- Text
CREATE OR REPLACE PROCEDURE updateText(pIdNews IN NUMBER, pText IN VARCHAR2, codResult OUT NUMBER) AS
BEGIN
    UPDATE News
    SET textNews = pText
    WHERE idNews = pIdNews;
    
    codResult:= 0;
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updateText;

-- Photo
CREATE OR REPLACE PROCEDURE updatePhoto(pIdNews IN NUMBER, pPhoto IN VARCHAR2, codResult OUT NUMBER) AS
BEGIN
    UPDATE News
    SET photo = pPhoto
    WHERE idNews = pIdNews;
    
    codResult:= 0;
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updatePhoto;


-- Edit Account
CREATE OR REPLACE PROCEDURE updateProfile(pUsername IN VARCHAR2, pPassword IN VARCHAR2, pFirstName IN VARCHAR2,
                                        pSndName IN VARCHAR2, pFirstLastName IN VARCHAR2, pSndLastName IN VARCHAR2,
                                        pGender IN NUMBER, pEmail IN VARCHAR2, pPhone IN NUMBER, pPhoto IN VARCHAR2)
AS
tmpIdPerson NUMBER;
tmpIdPhone NUMBER;
encryptedPassword VARCHAR2(200);
BEGIN
    SELECT idPerson INTO tmpIdPerson FROM UserPerson WHERE username = pUsername;
    SELECT idPhone INTO tmpIdPhone FROM PersonXPhone WHERE idPerson = tmpIdPerson;
    
    encryptionPassword(pPassword, encryptedPassword);
    
    UPDATE UserPerson
    SET passwordUser = encryptedPassword
    WHERE username = pUsername;
    
    UPDATE Person
    SET firstName = pFirstName,
        secondName = pSndName,
        firstlastname = pFirstLastName,
        secondlastname = pSndLastName,
        idgender = pGender, 
        photo = pPhoto
    WHERE idPerson = tmpIdPerson;
    
    UPDATE Mail
    SET descriptionMail = pEmail
    WHERE idPerson = tmpIdPerson;
    
    UPDATE Phone
    SET phonenumber = pPhone
    WHERE idPhone = tmpIdPhone;
    
    COMMIT;
END updateProfile;

/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Encryption and Decryption Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

CREATE OR REPLACE PROCEDURE encryptionPassword (text IN VARCHAR2, encrypted_text OUT VARCHAR2) AS  
raw_set RAW(100);  
raw_password RAW(100);  
encryption_result RAW(100);  
encryption_password VARCHAR2(100) := 'Q?Tx.H9h@%5,:QxV';  
operation_mode NUMBER; 
BEGIN    
    raw_set:=utl_i18n.string_to_raw(text,'AL32UTF8');    
    raw_password := utl_i18n.string_to_raw(encryption_password,'AL32UTF8');        
    operation_mode:=DBMS_CRYPTO.ENCRYPT_DES + DBMS_CRYPTO.PAD_ZERO + DBMS_CRYPTO.CHAIN_ECB;        
    encryption_result:=DBMS_CRYPTO.ENCRYPT(raw_set,operation_mode,raw_password);           
    dbms_output.put_line(encryption_result);    
    encrypted_text := RAWTOHEX (encryption_result);  
END encryptionPassword; 


CREATE OR REPLACE PROCEDURE decryptionPassword (encrypted_text IN VARCHAR2, decrypted_text OUT VARCHAR2) AS   
raw_set RAW(100);   
raw_password RAW(100);   
decryption_result RAW(100);   
decryption_password VARCHAR2(100) := 'Q?Tx.H9h@%5,:QxV';   
operation_mode NUMBER; 
BEGIN   
    raw_set:=HEXTORAW(encrypted_text);   
    raw_password :=utl_i18n.string_to_raw(decryption_password,'AL32UTF8');   
    operation_mode:=DBMS_CRYPTO.ENCRYPT_DES + DBMS_CRYPTO.PAD_ZERO + DBMS_CRYPTO.CHAIN_ECB;      
    decryption_result:=DBMS_CRYPTO.DECRYPT(raw_set,operation_mode,raw_password);   
    dbms_output.put_line(decryption_result);   
    decrypted_text := utl_i18n.raw_to_char (decryption_result,'AL32UTF8'); 
END decryptionPassword;  

/*VARIABLE encryptedPassword VARCHAR2(200);
BEGIN
encryptionPassword('Admin001', :encryptedPassword);
END;*/

/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Get Information Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/
-------------- PEOPLE --------------------
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

CREATE OR REPLACE PROCEDURE getPersonInformation(pidPerson IN NUMBER, curPersonInformation  OUT SYS_REFCURSOR, codResult OUT NUMBER)
AS
vnIdPlayer NUMBER(10);
BEGIN 
    BEGIN
        SELECT pl.idPerson
        INTO vnIdPlayer 
        FROM Player Pl
        WHERE pl.idPerson = pidPerson;
    EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        vnIdPlayer:=-1; 
    END;

    IF(vnIdPlayer != -1)
    THEN
        OPEN curPersonInformation FOR
        SELECT Person.firstName, Person.secondName, Person.firstLastName, Person.secondLastName, 
        Person.identification, Person.idTypeIdentification, Person.idPersonPosition, Person.photo,
        Person.idGender, Province.idCountry ,Canton.idProvince ,District.idCanton , Address.idDistrict , Address.descriptionAddress, 
        Mail.descriptionMail, Phone.phoneNumber, Player.idTeam, Player.birthdate, Player.TshirtNum
        FROM Person
        INNER JOIN PersonXPhone ON PersonXPhone.idPerson = Person.idPerson
        INNER JOIN Phone ON Phone.idPhone = PersonXPhone.idPhone
        INNER JOIN Mail ON Mail.idPerson = Person.idPerson
        INNER JOIN Player ON Player.idPerson = Person.idPerson
        INNER JOIN Address ON Address.idAddress = Person.idAddress
        INNER JOIN District ON District.idDistrict = Address.idDistrict
        INNER JOIN Canton ON Canton.idCanton = District.idCanton
        INNER JOIN Province ON Province.idProvince = Canton.idProvince
        WHERE Player.idPerson = vnIdPlayer;
        
        codResult:=0; 
    ELSE
        OPEN curPersonInformation FOR
        SELECT Person.firstName, Person.secondName, Person.firstLastName, Person.secondLastName, 
        Person.identification, Person.idTypeIdentification, Person.idPersonPosition, Person.photo,
        Person.idGender, Province.idCountry ,Canton.idProvince ,District.idCanton ,Address.idDistrict ,Address.descriptionAddress, 
        Mail.descriptionMail, Phone.phoneNumber, TeamWorker.idTeam
        FROM Person
        INNER JOIN PersonXPhone ON PersonXPhone.idPerson = Person.idPerson
        INNER JOIN Phone ON Phone.idPhone = PersonXPhone.idPhone
        INNER JOIN Mail ON Mail.idPerson = Person.idPerson
        INNER JOIN TeamWorker ON TeamWorker.idPerson = Person.idPerson
        INNER JOIN Address ON Address.idAddress = Person.idAddress
        INNER JOIN District ON District.idDistrict = Address.idDistrict
        INNER JOIN Canton ON Canton.idCanton = District.idCanton
        INNER JOIN Province ON Province.idProvince = Canton.idProvince
        WHERE TeamWorker.idPerson = pidPerson;
        
        codResult:=1; 
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END getPersonInformation;

-------------- CATALOGS ------------------------------

CREATE OR REPLACE PROCEDURE getEvent (curEvent OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curEvent FOR
    SELECT idEvent, typeEvent
    FROM Event;
END getEvent;

CREATE OR REPLACE PROCEDURE getGroupEvent (curGroupEvent OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curGroupEvent FOR
    SELECT idGroupEvent, descriptionGroupEvent
    FROM GroupEvent;
END getGroupEvent;

CREATE OR REPLACE PROCEDURE getGender(curGender OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curGender FOR
    SELECT idGender, descriptionGender
    FROM Gender;
END getGender;

CREATE OR REPLACE PROCEDURE getPosition (curPosition OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curPosition FOR
    SELECT idPersonPosition, descriptionPersonPosition
    FROM PersonPosition;
END getPosition;

CREATE OR REPLACE PROCEDURE getTypeIdentification(curTypeIdentification OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curTypeIdentification FOR
    SELECT idTypeIdentification, nameTypeIdentification
    FROM TypeIdentification;
END getTypeIdentification;


CREATE OR REPLACE PROCEDURE getCountry(curCountry OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curCountry FOR
    SELECT idCountry, nameCountry
    FROM Country;
END getCountry;


CREATE OR REPLACE PROCEDURE getProvince(curProvince OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curProvince FOR
    SELECT idCountry, idProvince, nameProvince
    FROM Province;
END getProvince;


CREATE OR REPLACE PROCEDURE getCanton(curCanton OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curCanton FOR
    SELECT idProvince, idCanton, nameCanton
    FROM Canton;
END getCanton;


CREATE OR REPLACE PROCEDURE getDistrict(curDistrict OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curDistrict FOR
    SELECT idCanton, idDistrict, nameDistrict
    FROM District;
END getDistrict;

CREATE OR REPLACE PROCEDURE getNews(curNews OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNews FOR
    SELECT idNews, NewsType.descriptionNewsType, NewsStatus.descriptionNewsStatus, title, publicationDate, linkNews, photo, textNews, viewsNews
    FROM News 
    INNER JOIN NewsStatus ON News.idNewsStatus = NewsStatus.idNewsStatus
    INNER JOIN NewsType ON News.idNewsType = NewsType.idNewsType;
END getNews;

CREATE OR REPLACE PROCEDURE getInfoNews(pIdNews IN NUMBER, curNews OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNews FOR
    SELECT idNews, NewsType.idNewsType, NewsStatus.idNewsStatus, title, photo, textNews
    FROM News 
    INNER JOIN NewsStatus ON News.idNewsStatus = NewsStatus.idNewsStatus
    INNER JOIN NewsType ON News.idNewsType = NewsType.idNewsType
    WHERE News.idNews = pIdNews;
END getInfoNews;

CREATE OR REPLACE PROCEDURE getNewsStatus(curNewsStatus OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNewsStatus FOR
    SELECT idNewsStatus, descriptionNewsStatus
    FROM NewsStatus;
END getNewsStatus;

CREATE OR REPLACE PROCEDURE getNewsType(curNewsType OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNewsType FOR
    SELECT idNewsType, descriptionNewsType
    FROM NewsType;
END getNewsType;

CREATE OR REPLACE PROCEDURE getTeam(curTeam OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curTeam FOR
    SELECT idTeam, nameTeam
    FROM Team;
END getTeam;

CREATE OR REPLACE PROCEDURE getCountryTeam(curCountryTeam OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curCountryTeam FOR
    SELECT  idCountryTeam, idContinent, nameCountryTeam
    FROM CountryTeam;
END getCountryTeam;


CREATE OR REPLACE PROCEDURE getMostViewedNews(curMostViewedNews OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curMostViewedNews FOR
    SELECT title, viewsNews
    FROM News
    ORDER BY viewsNews DESC;
END getMostViewedNews;


CREATE OR REPLACE PROCEDURE getLastNews(curLastNews OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curLastNews FOR
    SELECT title, publicationDate
    FROM News
    ORDER BY publicationDate DESC;
END getLastNews;

CREATE OR REPLACE PROCEDURE getStadium(curStadium OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curStadium FOR
    SELECT  idStadium, idCountry, nameStadium
    FROM Stadium;
END getStadium;


CREATE OR REPLACE PROCEDURE getTeamXGroup (curTeamXGroup OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curTeamXGroup FOR
    SELECT idTeamXGroup, idTeam,idGroupEvent
    FROM TeamXGroup;
END getTeamXGroup;


-- My Account Information
CREATE OR REPLACE PROCEDURE getAccountInformation(pUsername IN VARCHAR2, outAccountCursor OUT SYS_REFCURSOR)
AS
encryptedPassword VARCHAR(200);
normalPassword VARCHAR2(200);
BEGIN
    
    SELECT passwordUser INTO encryptedPassword FROM UserPerson WHERE username = pUsername;
    decryptionPassword(encryptedPassword, normalPassword);

    OPEN outAccountCursor FOR
    SELECT UserPerson.username, normalPassword passwordUser, Person.firstName, Person.secondName,
    Person.firstLastName, Person.secondLastName, Person.identification, Gender.descriptionGender,
    Mail.descriptionMail, Phone.phoneNumber, Person.photo
    FROM UserPerson
    INNER JOIN Person ON Person.idPerson = UserPerson.idPerson
    INNER JOIN Gender ON Person.idGender = Gender.idGender
    INNER JOIN Mail ON Mail.idPerson = Person.idPerson
    INNER JOIN PersonXPhone ON PersonXPhone.idPerson = Person.idPerson
    INNER JOIN Phone ON Phone.idPhone = PersonXPhone.idPhone
    WHERE UserPerson.username = pUsername;
END;


/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Requests Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

CREATE OR REPLACE PROCEDURE getGroupList(pGroupList OUT SYS_REFCURSOR, pTeamName IN VARCHAR2, pMatchDate IN VARCHAR2, pStadium IN VARCHAR2, pTeamFlag IN VARCHAR2)
IS 
BEGIN
    OPEN pGroupList FOR 
    SELECT Team.nameTeam, SoccerMatch.dateHour, Stadium.nameStadium, Team.flag
    FROM Stadium 
    INNER JOIN SoccerMatch ON SoccerMatch.idStadium = Stadium.idStadium
    INNER JOIN PlayerXSoccerMatchXTeam ON SoccerMatch.idSoccerMatch = PlayerXSoccerMatchXTeam.idSoccerMatch
    INNER JOIN Team ON PlayerXSoccerMatchXTeam.idTeam = Team.idTeam
    INNER JOIN CountryTeam ON Team.idCountryTeam = CountryTeam.idCountryTeam 
    WHERE Team.nameTeam = NVL (pTeamName, Team.nameTeam) AND SoccerMatch.dateHour = NVL (TO_DATE(pMatchDate, 'DD-MM-YYYY HH24:MI'), SoccerMatch.dateHour) 
    AND Stadium.nameStadium = NVL (pStadium, Stadium.nameStadium) AND Team.flag = NVL (pTeamFlag, Team.flag);
END getGroupList;


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

NOT WORKING
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

/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Statistics Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

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

/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Validation Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

CREATE OR REPLACE PROCEDURE validateUser(pUsername IN VARCHAR2, pPassword IN VARCHAR2, codResult OUT NUMBER) 
IS
vnUserType NUMBER(3);
vnCurrentPassword VARCHAR2(200);
vnDecryptedText VARCHAR2(200);
BEGIN
    SELECT passwordUser
    INTO vnCurrentPassword
    FROM UserPerson
    WHERE username = pUsername;
    
    decryptionPassword (vnCurrentPassword, vnDecryptedText);

    SELECT idUserType
    INTO vnUserType
    FROM UserPerson 
    WHERE (username = pUsername) AND (vnDecryptedText = pPassword);
    
    IF(vnUserType = 1) THEN
        codResult := 0;
    ELSE
        IF(vnUserType = 2) THEN
            codResult := 1;
        END IF;
    END IF;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;        
END validateUser;


CREATE OR REPLACE PROCEDURE validateUserAlreadyExists(pUsername IN VARCHAR2,codResult OUT NUMBER) 
IS
vnIdPerson NUMBER(10);
BEGIN
    BEGIN
        SELECT userPerson.idPerson
        INTO vnIdPerson
        FROM UserPerson
        WHERE userPerson.username = pUsername;
    EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        vnIdPerson:=-1; 
    END;

    IF(vnIdPerson != -1) 
    THEN
        codResult := 0;
    ELSE
         codResult := 1;
    END IF; 
END validateUserAlreadyExists;


CREATE OR REPLACE PROCEDURE validateIdentAlreadyExists(pidentification IN NUMBER,codResult OUT NUMBER) 
IS
vnIdPerson NUMBER(10);
BEGIN
    BEGIN
        SELECT Person.idPerson 
        INTO vnIdPerson
        FROM Person
        WHERE Person.identification = identification;
    EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        vnIdPerson:=-1; 
    END;

    IF(vnIdPerson != -1) 
    THEN
        codResult := 0;
    ELSE
         codResult := 1;
    END IF; 
END validateIdentAlreadyExists;


CREATE OR REPLACE PROCEDURE validateGroupExist(codResult OUT NUMBER) IS
vnTotalGroup NUMBER(10);
BEGIN
    SELECT COUNT(*)
    INTO vnTotalGroup
    FROM GroupEvent;
    
    IF(vnTotalGroup > 0)
    THEN
        codResult := 0;
    ELSE
        codResult := 1;
    END IF;
END validateGroupExist;

CREATE OR REPLACE PROCEDURE validateTeamExist(codResult OUT NUMBER) IS
vnTotalTeam NUMBER(10);
BEGIN
    SELECT COUNT(*)
    INTO vnTotalTeam
    FROM Team;
    
    IF(vnTotalTeam > 0)
    THEN
        codResult := 0;
    ELSE
        codResult := 1;
    END IF;
END validateTeamExist;

CREATE OR REPLACE PROCEDURE validateSoccerMatchExist(codResult OUT NUMBER) IS
vnTotalMatch NUMBER(10);
BEGIN
    SELECT COUNT(*)
    INTO vnTotalMatch
    FROM soccermatch;
    
    IF(vnTotalMatch > 0)
    THEN
        codResult := 0;
    ELSE
        codResult := 1;
    END IF;
END validateSoccerMatchExist;

/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Deletion Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

-- NOT WORKING
CREATE PROCEDURE removeAll (pidEvent IN NUMBER) AS
---vnIdGroupEvent NUMBER(10);
BEGIN

    DELETE FROM News
    WHERE EXISTS
    (SELECT e.idEvent FROM News N
    INNER JOIN SoccerMatch SM ON sm.idSoccerMatch = ewm.idSoccerMatch
    INNER JOIN Pla GE ON ge.idGroupEvent = t.idGroupEvent
    INNER JOIN Event E ON e.idEvent = ge.idEvent
    WHERE e.idEvent = pidEvent);
   
    DELETE FROM PlayerXSoccerMatchXTeam 
    WHERE EXISTS
    (SELECT e.idEvent FROM PlayerXSoccerMatchXTeam PMT 
    INNER JOIN Team T ON t.idTeam = pmt.idTeam
    INNER JOIN GroupEvent GE ON ge.idGroupEvent = t.idGroupEvent
    INNER JOIN Event E ON e.idEvent = ge.idEvent
    WHERE e.idEvent = pidEvent);

    DELETE FROM Event 
    WHERE EXISTS
    (SELECT idEvent 
    FROM Event E 
    INNER JOIN GroupEvent GE ON e.idEvent = ge.idEvent
    INNER JOIN Team T ON t.idGroupEvent = ge.idGroupEvent
    WHERE e.idEvent = pidEvent);
    
    COMMIT;
END removeAll;

