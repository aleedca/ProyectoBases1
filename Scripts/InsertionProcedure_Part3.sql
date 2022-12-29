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
        IF (pPhoneNumber IS NOT NULL) 
        THEN
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
