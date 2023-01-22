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
Insertion Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

--- MATCHES
CREATE OR REPLACE PROCEDURE insertEvent (pTypeEvent IN VARCHAR2) AS
BEGIN
    INSERT INTO Event (idEvent, typeEvent, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_event.nextval, pTypeEvent, NULL, NULL, NULL, NULL);
    COMMIT;
END insertEvent;

CREATE OR REPLACE PROCEDURE insertStadium(pIdCountry IN NUMBER, pNameStadium IN VARCHAR2) AS
BEGIN
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.nextval, pIdCountry, pNameStadium, NULL, NULL, NULL, NULL);
    COMMIT;
END insertStadium;

CREATE OR REPLACE PROCEDURE insertTeam(pIdCountryTeam IN NUMBER, pNameTeam IN VARCHAR2, pFlag IN VARCHAR2)
AS
BEGIN
    INSERT INTO Team(idTeam, idCountryTeam, nameTeam, flag, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_team.NEXTVAL, pIdCountryTeam, pNameTeam, pFlag, NULL, NULL, NULL, NULL);
    COMMIT;
END insertTeam;

CREATE OR REPLACE PROCEDURE insertGroupEvent (pIdEvent IN NUMBER, pDescription IN VARCHAR2) AS
BEGIN
    INSERT INTO GroupEvent (idGroupEvent, idEvent, descriptionGroupEvent, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_groupEvent.nextval, pIdEvent, pDescription, NULL, NULL, NULL, NULL);
    COMMIT;
END insertGroupEvent;

CREATE OR REPLACE PROCEDURE insertTeamXGroup (pidTeam IN NUMBER, pidGroupEvent IN NUMBER) AS
BEGIN
    INSERT INTO TeamXGroup (idTeamXGroup, idTeam, idGroupEvent, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_teamxgroup.nextval, pidTeam, pidGroupEvent,NULL, NULL, NULL, NULL);
    COMMIT;
END insertTeamXGroup;

CREATE OR REPLACE PROCEDURE insertSoccerMatch(pIdStadium IN NUMBER, pDateHour IN VARCHAR2, outIdSoccerMatch OUT NUMBER)
AS
BEGIN
    INSERT INTO SoccerMatch(idSoccerMatch, idStadium, dateHour, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_soccerMatch.NEXTVAL, pIdStadium, TO_DATE(pDateHour, 'DD-MM-YYYY HH24:MI'), NULL, NULL, NULL, NULL);
    
    outIdSoccerMatch:= s_soccerMatch.currval;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        outIdSoccerMatch := -1; 
END insertSoccerMatch;

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

CREATE OR REPLACE PROCEDURE insertGroupStats (pIdTeam IN NUMBER, pWonMatches IN NUMBER, pTiedMatches IN NUMBER, pLostMatches IN NUMBER, pGoalsScored IN NUMBER, pGoalsReceived IN NUMBER, pFairPlayPoints IN NUMBER) AS
BEGIN
    INSERT INTO GroupStats (idStats, idTeam, wonMatches, tiedMatches, lostMatches, goalsScored, goalsReceived, fairPlayPoints, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_groupstats.nextval, pIdTeam, pWonMatches, pTiedMatches, pLostMatches, pGoalsScored, pGoalsReceived, pFairPlayPoints, NULL, NULL, NULL, NULL);
    COMMIT;
END insertGroupStats;

--- CATALOGS
CREATE OR REPLACE PROCEDURE insertCountryTeam(pIdContinent IN NUMBER, pNameCountryTeam IN VARCHAR2) AS
BEGIN
    INSERT INTO CountryTeam(idCountryTeam, idContinent, nameCountryTeam, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_countryteam.nextval, pIdContinent, pNameCountryTeam, NULL, NULL, NULL, NULL);
    COMMIT;
END insertCountryTeam;

CREATE OR REPLACE PROCEDURE insertGender(pDescriptionGender IN VARCHAR2) AS
BEGIN
    INSERT INTO Gender(idGender, descriptionGender, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_gender.nextval, pDescriptionGender, NULL, NULL, NULL, NULL);
    COMMIT;
END insertGender;

CREATE OR REPLACE PROCEDURE insertTypeIdentification(pNameTypeIdentification IN VARCHAR2, pTypeMask IN VARCHAR2) AS
BEGIN
    INSERT INTO TypeIdentification(idTypeIdentification, nameTypeIdentification, typeMask, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_typeIdentification.nextval, pNameTypeIdentification, pTypeMask, NULL, NULL, NULL, NULL);
    COMMIT;
END insertTypeIdentification;

CREATE OR REPLACE PROCEDURE insertPosition(pDescriptionPosition IN VARCHAR2) AS
BEGIN
    INSERT INTO PersonPosition(idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_personposition.nextval, pDescriptionPosition, NULL, NULL, NULL, NULL);
    COMMIT;
END insertPosition;

CREATE OR REPLACE PROCEDURE insertContinent(pNameContinent IN VARCHAR2) AS
BEGIN
    INSERT INTO Continent (idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_continent.nextval, pNameContinent, NULL, NULL, NULL, NULL);
    COMMIT;
END insertContinent;

CREATE OR REPLACE PROCEDURE insertCountry(pNameCountry IN VARCHAR2) AS
BEGIN
    INSERT INTO Country(idCountry, nameCountry, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_country.nextval, pNameCountry, NULL, NULL, NULL, NULL);
    COMMIT;
END insertCountry;

CREATE OR REPLACE PROCEDURE insertProvince(pIdCountry IN NUMBER, pNameProvince IN VARCHAR2) AS
BEGIN
    INSERT INTO Province (idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, pIdCountry, pNameProvince,NULL, NULL, NULL, NULL);
    COMMIT;
END insertProvince;

CREATE OR REPLACE PROCEDURE insertCanton(pIdProvince IN NUMBER, pNameCanton IN VARCHAR2) AS
BEGIN
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, pIdProvince, pNameCanton,NULL, NULL, NULL, NULL);
    COMMIT;
END insertCanton;

CREATE OR REPLACE PROCEDURE insertDistrict(pIdCanton IN NUMBER, pNameDistrict IN VARCHAR2) AS
BEGIN
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval, pIdCanton, pNameDistrict,NULL, NULL, NULL, NULL);
    COMMIT;
END insertDistrict;

--- INFO PERSON
CREATE OR REPLACE PROCEDURE insertPersonXPhone(pIdPerson IN NUMBER,pIdPhone IN NUMBER)
AS
BEGIN
    INSERT INTO PersonXPhone(idPersonXPhone, idPerson ,idPhone, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_personxphone.NEXTVAL, pIdPerson, pIdPhone, NULL, NULL, NULL, NULL);
END insertPersonXPhone;

CREATE OR REPLACE PROCEDURE insertPhone (pPhoneNumber IN NUMBER) AS
BEGIN
    BEGIN
        INSERT INTO Phone (idPhone, phoneNumber, userCreation, lastUser, lastDate, dateCreation)
        VALUES (s_phone.nextval, pPhoneNumber, NULL, NULL, NULL, NULL);
    END;
END insertPhone;

CREATE OR REPLACE PROCEDURE insertMail (pIdPerson IN NUMBER, pDescription IN VARCHAR2) AS
BEGIN
    INSERT INTO Mail (idMail, idPerson, descriptionMail, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_mail.nextval, pidPerson, pDescription, NULL, NULL, NULL, NULL);
END insertMail;

CREATE OR REPLACE PROCEDURE insertAddress (pIdDistrict IN NUMBER, pDescriptionAddress IN VARCHAR2) AS
BEGIN
    INSERT INTO Address (idAddress, idDistrict, descriptionAddress, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_address.nextval, pIdDistrict, pDescriptionAddress, NULL, NULL, NULL, NULL);
END insertAddress;

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

--- NEWS
CREATE OR REPLACE PROCEDURE insertNews (pIdNewsStatus IN NUMBER, pIdNewsType IN NUMBER, pTitle IN VARCHAR2, pPublicationDate IN DATE, pLinkNews IN VARCHAR2, pPhoto IN VARCHAR2, pTextNews IN VARCHAR2, idNews OUT NUMBER) AS
BEGIN
    INSERT INTO News (idNews, idNewsStatus, idNewsType, title, publicationDate, viewsNews, linkNews, photo, textNews, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_news.nextval, pIdNewsStatus, pIdNewsType, pTitle, pPublicationDate, 0, pLinkNews, pPhoto, pTextNews, NULL, NULL, NULL, NULL);

    idNews:= s_news.currval;
    COMMIT;
    
END insertNews;

CREATE OR REPLACE PROCEDURE insertNewsType(pDescriptionType IN VARCHAR2) AS
BEGIN
    INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newstype.nextval, pDescriptionType, NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsType;

CREATE OR REPLACE PROCEDURE insertNewsStatus(pDescriptionStatus IN VARCHAR2) AS
BEGIN
    INSERT INTO NewsStatus(idNewsStatus, descriptionNewsStatus, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsstatuts.nextval, pDescriptionStatus, NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsStatus;

CREATE OR REPLACE PROCEDURE insertFavoriteNews (pUsername IN VARCHAR2, pIdNews IN NUMBER) AS
BEGIN
    INSERT INTO FavoriteNews (idFavoriteNews, username, idNews, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_favoriteNews.nextval, pUsername, pIdNews, NULL, NULL, NULL, NULL);
    COMMIT;
END insertFavoriteNews;

CREATE OR REPLACE PROCEDURE insertUserXNews(pUsername IN VARCHAR2, pIdNews IN NUMBER) AS
BEGIN
    INSERT INTO UserXNews (idUserXNews, username, idNews, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_userxnews.nextval, pUsername, pIdNews, NULL, NULL, NULL, NULL);
    COMMIT;
END insertUserXNews;

CREATE OR REPLACE PROCEDURE insertNewsComment (pIdNews IN NUMBER, pUsername IN VARCHAR2, ptextNewsComment IN VARCHAR2)
AS
BEGIN
    INSERT INTO NewsComment(idNewsComment, username, idNews, textNewsComment, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsComment.nextval, pUsername, pIdNews, ptextNewsComment, NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsComment;

CREATE OR REPLACE PROCEDURE insertRating(pUsername IN VARCHAR2, pIdNews IN NUMBER, pRating IN NUMBER)
AS
counter NUMBER;
BEGIN
    SELECT COUNT(1) INTO counter FROM Rating WHERE username = pUsername AND idNews = pIdNews;
    
    IF counter > 0 THEN
        UPDATE Rating
        SET rating = pRating
        WHERE username = pUsername AND idNews = pIdNews;
    ELSE
        INSERT INTO Rating(idRating, username, idNews, rating, userCreation, lastUser, lastDate, dateCreation)
        VALUES(s_rating.NEXTVAL, pUsername, pIdNews, pRating, NULL, NULL, NULL, NULL);
        COMMIT;
    END IF;
END insertRating;

--- BLOG AND PARAMETERS
CREATE OR REPLACE PROCEDURE insertNewsChange (pIdNews IN NUMBER, pIdBlog IN NUMBER, pUsername IN VARCHAR2, pCurrentText IN VARCHAR2, pPreviousText IN VARCHAR2, pDescriptionNewsChange IN VARCHAR2, pDateHour IN DATE) AS
BEGIN
    INSERT INTO NewsChange (idNewsChange, idNews, idBlog, username, currentText, previousText, descriptionNewsChange, dateHour, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newschange.nextval, pIdNews, pIdBlog, pUsername, pCurrentText, pPreviousText, pDescriptionNewsChange, pDateHour, NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsChange;

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

--- CATALOGS
CREATE OR REPLACE PROCEDURE updateGender(pIdGender IN NUMBER, pDescriptionGender IN VARCHAR2) AS
BEGIN
    UPDATE Gender
    SET descriptionGender = pDescriptionGender
    WHERE idGender = pIdGender;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateGender;

CREATE OR REPLACE PROCEDURE updateTypeIdentification(pIdTypeIdentification IN NUMBER, pNameTypeIdentification IN VARCHAR2) AS
BEGIN
    UPDATE TypeIdentification
    SET nameTypeIdentification = pNameTypeIdentification
    WHERE idTypeIdentification = pIdTypeIdentification;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateTypeIdentification;

CREATE OR REPLACE PROCEDURE updateCountry(pIdCountry IN NUMBER, pNameCountry IN VARCHAR2) AS
BEGIN
    UPDATE Country
    SET nameCountry = pNameCountry
    WHERE idCountry = pIdCountry;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateCountry;

CREATE OR REPLACE PROCEDURE updateProvince(pIdProvince IN NUMBER, pNameProvince IN VARCHAR2) AS
BEGIN
    UPDATE Province
    SET nameProvince = pNameProvince
    WHERE idProvince = pIdProvince;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateProvince;

CREATE OR REPLACE PROCEDURE updateCanton(pIdCanton IN NUMBER, pNameCanton IN VARCHAR2) AS
BEGIN
    UPDATE Canton
    SET nameCanton = pNameCanton
    WHERE idCanton = pIdCanton;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateCanton;

CREATE OR REPLACE PROCEDURE updateDistrict(pIdDistrict IN NUMBER, pNameDistrict IN VARCHAR2) AS
BEGIN
    UPDATE District
    SET nameDistrict = pNameDistrict
    WHERE idDistrict = pIdDistrict;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateDistrict;

CREATE OR REPLACE PROCEDURE updatePosition(pIdPosition IN NUMBER, pDescriptionPosition IN VARCHAR2) AS
BEGIN
    UPDATE PersonPosition
    SET descriptionPersonPosition = pDescriptionPosition
    WHERE idPersonPosition = pIdPosition;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updatePosition;

CREATE OR REPLACE PROCEDURE updateContinent(pIdContinent IN NUMBER, pNameContinent IN VARCHAR2) AS
BEGIN
    UPDATE Continent
    SET nameContinent = pNameContinent
    WHERE idContinent = pIdContinent;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateContinent;

CREATE OR REPLACE PROCEDURE updateCountryTeam(pIdCountryTeam IN NUMBER, pNameCountryTeam IN VARCHAR2) AS
BEGIN
    UPDATE CountryTeam
    SET nameCountryTeam = pNameCountryTeam
    WHERE idCountryTeam = pIdCountryTeam;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateCountryTeam;

CREATE OR REPLACE PROCEDURE updateNewsType(pIdNewsType IN NUMBER, pDescriptionType IN VARCHAR2) AS
BEGIN
    UPDATE NewsType
    SET descriptionNewsType = pDescriptionType
    WHERE idNewsType = pIdNewsType;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateNewsType;

CREATE OR REPLACE PROCEDURE updateNewsStatus(pIdNewsStatus IN NUMBER, pDescriptionStatus IN VARCHAR2) AS
BEGIN
    UPDATE NewsStatus
    SET descriptionNewsStatus = pDescriptionStatus
    WHERE idNewsStatus = pIdNewsStatus;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateNewsStatus;

--- INFO PERSON
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

--- MATCHES
CREATE OR REPLACE PROCEDURE updateSoccerMatch (pIdSoccerMatch IN NUMBER, pidPerson IN NUMBER, pYellowCards IN NUMBER, pRedCards IN NUMBER, pOffsides IN NUMBER, pCorners IN NUMBER, pSaves IN NUMBER, pGoals IN NUMBER) AS
BEGIN
    UPDATE PlayerXSoccerMatchXTeam
    SET yellowCards = pYellowCards, 
    redCards = pRedCards,
    offsides = pOffsides,
    corners = pCorners,
    saves = pSaves,
    goals = pGoals
    WHERE idPerson = pidPerson
    AND idSoccerMatch = pIdSoccerMatch;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END updateSoccerMatch;

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

--- NEWS
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

--- PARAMETERS
CREATE OR REPLACE PROCEDURE updateParameter(pIdParameter IN NUMBER, pNameParameter IN VARCHAR, pValueParameter IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE ParameterTable
    SET nameParameter = pNameParameter
    WHERE idParameterTable = pIdParameter;
    
    UPDATE ParameterTable
    SET valueParameter = pValueParameter
    WHERE idParameterTable = pIdParameter;
    
    codResult:= 0;
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updateParameter;

/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Get Information Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

--- INFO PERSON
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

--- MATCHES
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


CREATE OR REPLACE PROCEDURE getStadium(curStadium OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curStadium FOR
    SELECT  idStadium, idCountry, nameStadium
    FROM Stadium;
END getStadium;

CREATE OR REPLACE PROCEDURE getTeam(curTeam OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curTeam FOR
    SELECT idTeam, nameTeam
    FROM Team
    ORDER BY idTeam;
END getTeam;

CREATE OR REPLACE PROCEDURE getTeamXGroup (curTeamXGroup OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curTeamXGroup FOR
    SELECT idTeamXGroup, idTeam,idGroupEvent
    FROM TeamXGroup;
END getTeamXGroup;

CREATE OR REPLACE PROCEDURE getTodaySoccerMatches(curTodayMatches OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curTodayMatches FOR
    SELECT Team.nameteam, SoccerMatch.datehour
    FROM playerxsoccermatchxteam
    INNER JOIN SoccerMatch ON SoccerMatch.idSoccerMatch = playerxsoccermatchxteam.idSoccerMatch
    INNER JOIN Team ON Team.idTeam = playerxsoccermatchxteam.idTeam
    WHERE TRUNC(Soccermatch.datehour) = TRUNC(SYSDATE)
    GROUP BY Team.nameteam, SoccerMatch.datehour;
    
END getTodaySoccerMatches;

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
END getAccountInformation;

CREATE OR REPLACE PROCEDURE getSoccerMatch (pidSoccerMatch IN NUMBER, curSoccerMatch OUT SYS_REFCURSOR) 
AS
vnTeam1 VARCHAR2(32);
vnTeam2 VARCHAR2(32);
BEGIN
    SELECT idTeam
    FROM PlayerXMatchXTeam
    WHERE idSoccerMatch = pidSoccerMatch;
    
    OPEN curSoccerMatch FOR
    SELECT descriptionGroupEvent, vnTeam1, nameStadium
    FROM TeamXGroup;
END getSoccerMatch;

--- CATALOGS
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

CREATE OR REPLACE PROCEDURE getContinent(curContinent OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curContinent FOR
    SELECT  idContinent, nameContinent
    FROM Continent;
END getContinent;

CREATE OR REPLACE PROCEDURE getCountry(curCountry OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curCountry FOR
    SELECT idCountry, nameCountry
    FROM Country;
END getCountry;

CREATE OR REPLACE PROCEDURE getCountryTeam(curCountryTeam OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curCountryTeam FOR
    SELECT  idCountryTeam, idContinent, nameCountryTeam
    FROM CountryTeam;
END getCountryTeam;

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

--- NEWS
CREATE OR REPLACE PROCEDURE getNews(curNews OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNews FOR
    SELECT idNews, NewsType.descriptionNewsType, NewsStatus.descriptionNewsStatus, title, publicationDate, linkNews, photo, textNews, viewsNews
    FROM News 
    INNER JOIN NewsStatus ON News.idNewsStatus = NewsStatus.idNewsStatus
    INNER JOIN NewsType ON News.idNewsType = NewsType.idNewsType;
END getNews;

CREATE OR REPLACE PROCEDURE getNewsComments(pIdNews IN NUMBER, curNews OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNews FOR
    SELECT NewsComment.username, NewsComment.textnewscomment
    FROM NewsComment
    WHERE idNews = pIdNews
    ORDER BY idNewsComment ASC;
END getNewsComments;

CREATE OR REPLACE PROCEDURE getSpecificNews(pIdNews IN NUMBER, cursorNews OUT SYS_REFCURSOR) IS
tmpNewsViews NUMBER;
BEGIN
    OPEN cursorNews FOR
    SELECT News.idNews, NewsType.descriptionNewsType, NewsStatus.descriptionNewsStatus, News.title, UserPerson.username, News.publicationDate, News.photo, News.textNews
    FROM News 
    INNER JOIN NewsStatus ON NewsStatus.idNewsStatus = News.idNewsStatus
    INNER JOIN NewsType ON NewsType.idNewsType = News.idNewsType
    INNER JOIN UserXNews ON UserXNews.idNews = News.idNews
    INNER JOIN UserPerson ON UserPerson.username = UserXNews.username
    WHERE News.idNews = pIdNews;
    
    SELECT viewsnews INTO tmpNewsViews FROM News WHERE idNews = pIdNews;
    
    
    UPDATE News
    SET viewsNews = tmpNewsViews+1
    WHERE idNews = pIdNews;
END getSpecificNews;

CREATE OR REPLACE PROCEDURE getAverageNewsRating(pIdNews IN NUMBER, averageRating OUT NUMBER) IS
tmpAverage NUMBER(1,0);
BEGIN
    BEGIN
    SELECT AVG(rating) INTO tmpAverage FROM Rating WHERE Rating.idNews = pIdNews;
    EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        tmpAverage:=0;
    END;
    IF tmpAverage = 0 THEN
        averageRating := 0;
    ELSE
        averageRating := tmpAverage;
    END IF;
END getAverageNewsRating;

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

CREATE OR REPLACE PROCEDURE getMostViewedNews(curMostViewedNews OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curMostViewedNews FOR
    SELECT idNews, title, viewsNews
    FROM News
    WHERE News.idnewsstatus = 1
    ORDER BY viewsNews DESC;
END getMostViewedNews;

CREATE OR REPLACE PROCEDURE getLastNews(curLastNews OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curLastNews FOR
    SELECT idNews, title, publicationDate
    FROM News
    WHERE News.idnewsstatus = 1
    ORDER BY publicationDate DESC;
END getLastNews;

--- STATISTICS
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

CREATE OR REPLACE PROCEDURE getAverageReviewsAuthor(cursorAverage OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cursorAverage FOR
    SELECT AVG(Rating.rating) average, UserXNews.username
    FROM Rating 
    INNER JOIN UserXNews ON UserXNews.idNews = Rating.idNews 
    GROUP BY UserXNews.username
    ORDER BY AVG(Rating.rating) DESC;
    
END getAverageReviewsAuthor;

CREATE OR REPLACE PROCEDURE getTotalPlayersXAge(pIdGender IN NUMBER, pIdTeam IN NUMBER, cursorPlayers OUT SYS_REFCURSOR)
AS
BEGIN

    OPEN cursorPlayers FOR
    SELECT COUNT(1) quantity
    FROM Player
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    WHERE Player.birthdate IS NOT NULL
    AND Person.idGender = NVL(pIdGender, Person.idGender)
    AND Player.idTeam = NVL(pIdTeam, Player.idTeam)
    AND TRUNC((SYSDATE- Player.birthdate)/365) BETWEEN 0 AND 18
    UNION
    SELECT COUNT(1) quantity
    FROM Player
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    WHERE Player.birthdate IS NOT NULL
    AND Person.idGender = NVL(pIdGender, Person.idGender)
    AND Player.idTeam = NVL(pIdTeam, Player.idTeam)
    AND TRUNC((SYSDATE- Player.birthdate)/365) BETWEEN 19 AND 30
    UNION
    SELECT COUNT(1) quantity
    FROM Player
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    WHERE Player.birthdate IS NOT NULL
    AND Person.idGender = NVL(pIdGender, Person.idGender)
    AND Player.idTeam = NVL(pIdTeam, Player.idTeam)
    AND TRUNC((SYSDATE- Player.birthdate)/365) BETWEEN 31 AND 45
    UNION
    SELECT COUNT(1) quantity
    FROM Player
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    WHERE Player.birthdate IS NOT NULL
    AND Person.idGender = NVL(pIdGender, Person.idGender)
    AND Player.idTeam = NVL(pIdTeam, Player.idTeam)
    AND TRUNC((SYSDATE- Player.birthdate)/365) BETWEEN 46 AND 60
    UNION
    SELECT COUNT(1) quantity
    FROM Player
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    WHERE Player.birthdate IS NOT NULL
    AND Person.idGender = NVL(pIdGender, Person.idGender)
    AND Player.idTeam = NVL(pIdTeam, Player.idTeam)
    AND TRUNC((SYSDATE- Player.birthdate)/365) BETWEEN 61 AND 75
    UNION
    SELECT COUNT(1) quantity
    FROM Player
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    WHERE Player.birthdate IS NOT NULL
    AND Person.idGender = NVL(pIdGender, Person.idGender)
    AND Player.idTeam = NVL(pIdTeam, Player.idTeam)
    AND TRUNC((SYSDATE- Player.birthdate)/365) > 75;
    
END getTotalPlayersXAge;

CREATE OR REPLACE PROCEDURE getTopNGoalScorer(topQuantity OUT NUMBER, outGoalScorerCursor OUT SYS_REFCURSOR)
AS
topN NUMBER;
BEGIN
    SELECT valueParameter INTO topN FROM
    ParameterTable WHERE parametertable.nameparameter = 'TopNGoalScorer';
    
    topQuantity:= topN;
    
    OPEN outGoalScorerCursor FOR
    SELECT Person.firstname ||' '||Person.firstLastName fullName, SUM(PlayerXSoccerMatchXTeam.goals) totalGoals
    FROM Player
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    INNER JOIN PlayerXSoccerMatchXTeam ON PlayerXSoccerMatchXTeam.idPerson = Person.idPerson
    GROUP BY Person.firstname ||' '||Person.firstLastName
    ORDER BY SUM(PlayerXSoccerMatchXTeam.goals) DESC;
END getTopNGoalScorer;

CREATE OR REPLACE PROCEDURE getTopNGoalKeepers(topQuantity OUT NUMBER, outGoalKeepersCursor OUT SYS_REFCURSOR)
AS
topN NUMBER;
BEGIN
    SELECT valueParameter INTO topN FROM
    ParameterTable WHERE parametertable.nameparameter = 'TopNGoalKeepers';
    
    topQuantity:= topN;
    
    OPEN outGoalKeepersCursor FOR
    SELECT Person.firstname ||' '||Person.firstLastName fullName, SUM(PlayerXSoccerMatchXTeam.saves) totalSaves
    FROM Player
    INNER JOIN Person ON Person.idPerson = Player.idPerson
    INNER JOIN PlayerXSoccerMatchXTeam ON PlayerXSoccerMatchXTeam.idPerson = Person.idPerson
    WHERE Person.idPersonPosition = 1
    GROUP BY Person.firstname ||' '||Person.firstLastName
    ORDER BY SUM(PlayerXSoccerMatchXTeam.goals) DESC;
END getTopNGoalKeepers;

CREATE OR REPLACE PROCEDURE getPlayedMatches(playedMatches OUT NUMBER, totalMatches OUT NUMBER)
AS
vnTotalMatches NUMBER;
vnPlayedMatches NUMBER;
BEGIN
    SELECT COUNT(1) INTO vnTotalMatches FROM SoccerMatch;
    SELECT COUNT(1) INTO vnPlayedMatches FROM SoccerMatch WHERE SoccerMatch.datehour < SYSDATE;
    
    playedMatches := vnPlayedMatches;
    totalMatches := vnTotalMatches;
    
END getPlayedMatches;

--- PARAMETERS
CREATE OR REPLACE PROCEDURE getParameters (curParameter OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curParameter FOR
    SELECT idParameterTable, nameParameter, valueParameter
    FROM ParameterTable;
END getParameters;

CREATE OR REPLACE PROCEDURE getInfoParameter(pIdParameter IN NUMBER, curParameter OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curParameter FOR
    SELECT idParameterTable, nameParameter, valueParameter
    FROM ParameterTable
    WHERE idParameterTable = pIdParameter;
END getInfoParameter;

--- REQUESTS
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

CREATE OR REPLACE PROCEDURE getNewsList(pNewsList OUT SYS_REFCURSOR, pAuthorName IN VARCHAR2, pAuthorLastName IN VARCHAR2, pDate IN DATE, pEvent IN VARCHAR2)
/*
Se deben mostrar todas las noticias (autor, título, fecha de publicación, tipo de artículo)
ordenados por antigüedad del más reciente al más antiguo. Filtros: autor, fecha, mundial.

NOT WORKING
*/
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
        WHERE Person.identification = pidentification;
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

CREATE OR REPLACE PROCEDURE validateEnoughPlayers(pIdTeam IN NUMBER, codResult OUT NUMBER) IS
vnTotalPlayers NUMBER(10);
BEGIN
    SELECT COUNT(*)
    INTO vnTotalPlayers
    FROM Player
    WHERE Player.idTeam = pIdTeam;
    
    IF(vnTotalPlayers >= 5)
    THEN
        codResult := 0;
    ELSE
        codResult := 1;
    END IF;
END validateEnoughPlayers;

CREATE OR REPLACE PROCEDURE validateNumberOfUnits(codResult OUT NUMBER) IS
vnTotalTeam NUMBER(10);
BEGIN
    SELECT COUNT(*)
    INTO vnTotalTeam
    FROM Team;
    codResult := vnTotalTeam;
END validateNumberOfUnits;

--CREAR procedimiento que valide si el nombre del parametro ya existe
/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Deletion Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

CREATE PROCEDURE removeAll (pidEvent IN NUMBER) AS
-- NOT WORKING
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

CREATE OR REPLACE PROCEDURE deleteGender(pIdGender IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM Gender
    WHERE idGender = pIdGender;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteGender;

CREATE OR REPLACE PROCEDURE deleteTypeIdentification(pIdTypeIdentification IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM TypeIdentification
    WHERE idTypeIdentification = pIdTypeIdentification;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteTypeIdentification;

CREATE OR REPLACE PROCEDURE deleteCountry(pIdCountry IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM Country
    WHERE idCountry = pIdCountry;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteCountry;

CREATE OR REPLACE PROCEDURE deleteProvince(pIdProvince IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM Province
    WHERE idProvince = pIdProvince;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteProvince;

CREATE OR REPLACE PROCEDURE deleteCanton(pIdCanton IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM Canton
    WHERE idCanton = pIdCanton;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteCanton;

CREATE OR REPLACE PROCEDURE deleteDistrict (pidDistrict IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM District
    WHERE idDistrict = pidDistrict;

    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteDistrict;

CREATE OR REPLACE PROCEDURE deletePosition (pidPersonPosition IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM PersonPosition
    WHERE idPersonPosition = pidPersonPosition;

    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deletePosition;

CREATE OR REPLACE PROCEDURE deleteContinent (pidContinent IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM Continent
    WHERE idContinent = pidContinent;

    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteContinent;

CREATE OR REPLACE PROCEDURE deleteCountryTeam (pidCountryTeam IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM CountryTeam
    WHERE idCountryTeam = pidCountryTeam;

    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteCountryTeam;

CREATE OR REPLACE PROCEDURE deleteNewsType(pIdNewsType IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM NewsType
    WHERE idNewsType = pIdNewsType;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteNewsType;

CREATE OR REPLACE PROCEDURE deleteNewsStatus(pIdNewsStatus IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    DELETE FROM NewsStatus
    WHERE idNewsStatus = pIdNewsStatus;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;
END deleteNewsStatus;

/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Other Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/
CREATE OR REPLACE PROCEDURE generateRaffle(pTotalGroup IN NUMBER, pIdEvent IN NUMBER) IS
vnIdMax NUMBER(10);
vnIdMin NUMBER(10);
vnQuantity NUMBER(1);
vnCount NUMBER(1):=0;
vnNumber NUMBER(2);
vnCHAR NUMBER(2):=65;
vnDescription VARCHAR2(32);
vnFlag BOOLEAN:=TRUE;
BEGIN
    SELECT MIN(idTeam) 
    INTO vnIdMin
    FROM Team;
    
    SELECT MAX(idTeam)
    INTO vnIdMax
    FROM Team;
    
    FOR i IN 1..pTotalGroup
    LOOP
        SELECT CHR(vnCHAR)
        INTO vnDescription
        FROM dual;
        
        insertGroupEvent (pIdEvent, 'Grupo ' || vnDescription);
        
        WHILE(vnFlag = TRUE)
        LOOP
            SELECT
            ROUND(DBMS_RANDOM.VALUE(vnIdMin,vnIdMax)) 
            INTO vnNumber
            FROM dual;

            SELECT COUNT(*) 
            INTO vnQuantity
            FROM TeamXGroup WHERE idTeam = vnNumber;

            IF (vnQuantity = 0)
            THEN
                insertTeamXGroup (vnNumber, s_groupevent.currval);
                vnCount:=vnCount+1;
            END IF;
            
            IF(vnCount = 4)
            THEN
                vnFlag:=FALSE;
            END IF;
        END LOOP;
        
        vnCHAR:=vnCHAR+1;
        vnCount:=0;
        vnFlag:=TRUE;
    END LOOP;
END generateRaffle;