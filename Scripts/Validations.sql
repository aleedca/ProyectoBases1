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

            