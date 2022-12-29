-- NewsComment
CREATE OR REPLACE PROCEDURE insertNewsComment (pIdNews IN NUMBER, pUsername IN VARCHAR2, ptextNewsComment IN VARCHAR2)
AS
BEGIN
    INSERT INTO NewsComment(idNewsComment, username, idNews, textNewsComment,
                            userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsComment.nextval, pUsername, pIdNews, ptextNewsComment, 
            NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsComment;


-- ParameterTable
CREATE OR REPLACE PROCEDURE insertParameterTable (pNameParameter IN VARCHAR2, pValueParameter IN NUMBER) AS
BEGIN
    INSERT INTO ParameterTable (idParameterTable, nameParameter, valueParameter, 
                                userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_parameter.nextval, pNameParameter, pValueParameter, NULL, NULL, NULL, NULL);
    COMMIT;
END insertParameterTable;


CREATE TABLE Phone(
    idPhone NUMBER(10) PRIMARY KEY,
    phoneNumber NUMBER(8) CONSTRAINT phone_phoneNumber_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Phone
CREATE OR REPLACE PROCEDURE insertPhone (pPhoneNumber IN NUMBER) AS
BEGIN
    INSERT INTO Phone (idPhone, phoneNumber, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_favoriteNews.nextval, pPhoneNumber, NULL, NULL, NULL, NULL);
    COMMIT;
END insertPhone;

CREATE TABLE Person (
   idPerson NUMBER(10) PRIMARY KEY,
   identification NUMBER(9)CONSTRAINT person_identification_nn NOT NULL,
   firstName VARCHAR2(32) CONSTRAINT person_firstname_nn NOT NULL,
   secondName VARCHAR2(32),
   firstLastName VARCHAR2(32) CONSTRAINT person_fstlastname_nn NOT NULL,
   secondLastName VARCHAR2(32) CONSTRAINT person_sndlastname_nn NOT NULL,
   photo VARCHAR2(128) CONSTRAINT person_photo_nn NOT NULL,
   idPersonPosition NUMBER(10) CONSTRAINT person_idpersonposition_nn NOT NULL,
   idCountry NUMBER(10) CONSTRAINT person_idcountry_nn NOT NULL,
   idTypeIdentification NUMBER(10) CONSTRAINT person_idtypeident_nn NOT NULL,
   idGender NUMBER(10) CONSTRAINT person_idgender_nn NOT NULL,
   userCreation VARCHAR2(16),
   lastUser VARCHAR2(16),
   lastDate DATE,
   dateCreation DATE
);

-- Person
CREATE OR REPLACE PROCEDURE insertPerson (pIdentification IN NUMBER, pFirstName IN VARCHAR2, 
            pSecondName IN VARCHAR2, pFirstLastName IN VARCHAR2, pSecondLastName IN VARCHAR2, 
            pPhoto IN VARCHAR2, pIdPersonPosition IN NUMBER, pIdCountry IN NUMBER, 
            pIdTypeIdentification IN NUMBER, pIdGender IN NUMBER)
AS
BEGIN
    INSERT INTO Person(idPerson, identification, firstName, secondName, 
                firstLastName, secondLastName, photo, idPersonPosition, idCountry, 
                idTypeIdentification, idGender, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_person.nextval, pIdentification, pFirstName, pSecondName, pFirstLastName, pSecondLastName, 
            pPhoto, pIdPersonPosition, pIdCountry, pIdTypeIdentification, pIdGender, NULL, NULL, NULL, NULL);
    
    COMMIT;
END insertPerson;

CREATE TABLE Player (
   idPerson NUMBER(10) PRIMARY KEY,
   idTeam NUMBER(10) CONSTRAINT player_idTeam_nn NOT NULL, 
   birthdate DATE CONSTRAINT player_birthdate_nn NOT NULL,
   tShirtNum NUMBER(3) CONSTRAINT player_tshirtnum_nn NOT NULL,
   userCreation VARCHAR2(16),
   lastUser VARCHAR2(16),
   lastDate DATE,
   dateCreation DATE
);


-- Player
CREATE OR REPLACE PROCEDURE insertPlayer (pIdentification IN NUMBER, pFirstName IN VARCHAR2, 
                pSecondName IN VARCHAR2, pFirstLastName IN VARCHAR2, pSecondLastName IN VARCHAR2, 
                pPhoto IN VARCHAR2, pIdPersonPosition IN NUMBER, pIdCountry IN NUMBER, pIdTypeIdentification IN NUMBER, 
                pIdGender IN NUMBER, pIdTeam IN NUMBER, pBirthdate DATE, pTShirtNum NUMBER)
AS
BEGIN
    DECLARE idPersonInsertion NUMBER :=s_person.nextval;
    BEGIN
        INSERT INTO Person(idPerson, identification, firstName, secondName, firstLastName, 
                        secondLastName, photo, idPersonPosition, idCountry, idTypeIdentification, idGender, 
                        userCreation, lastUser, lastDate, dateCreation)
        VALUES (idPersonInsertion, pIdentification, pFirstName, pSecondName, pFirstLastName, pSecondLastName, 
                pPhoto, pIdPersonPosition, pIdCountry, pIdTypeIdentification, pIdGender, NULL, NULL, NULL, NULL);

        INSERT INTO Player(idPerson, idTeam, birthdate, tShirtNum, userCreation, lastUser, lastDate, dateCreation)
        VALUES (idPersonInsertion, pIdTeam, pBirthdate, pTShirtNum, NULL, NULL, NULL, NULL); 

        COMMIT;
    END;
END insertPlayer;

