CREATE OR REPLACE PROCEDURE validateUser(pUsername IN VARCHAR2, pPassword IN VARCHAR2, codResult OUT NUMBER) 
IS
vnUserType NUMBER(3);
BEGIN
    SELECT idUserType
    INTO vnUserType
    FROM UserPerson 
    WHERE (username = pUsername) AND (passwordUser = pPassword);
    
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
vnUsername VARCHAR(32);
BEGIN
    SELECT   username
    INTO vnUsername
    FROM UserPerson 
    WHERE username = pUsername;
    
    IF(vnUsername != NULL) THEN
        codResult := 0;
    END IF;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;        
END validateUserAlreadyExists;

            