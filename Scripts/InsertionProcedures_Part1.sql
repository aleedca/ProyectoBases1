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





