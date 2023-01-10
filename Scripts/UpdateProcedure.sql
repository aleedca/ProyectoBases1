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
    SELECT idPerson
    INTO vnIdPerson
    FROM Player 
    WHERE idPerson = pidPerson;
    
    IF(vnIdPerson != NULL)
    THEN
        UPDATE Player
        SET idTeam = pidTeam
        WHERE idPerson = vnIdPerson;
    ELSE
        UPDATE TeamWorker
        SET idTeam = pidTeam
        WHERE idPerson = vnIdPerson;
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
    SELECT idPhone
    INTO vnIdPhone
    FROM PersonXPhone
    WHERE idPerson = pidPerson;
    
    IF(vnIdPhone != NULL)
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
CREATE OR REPLACE PROCEDURE updateDistrict(pidAddres IN NUMBER, pidDistrict IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE Address
    SET idDistrict = pidDistrict
    WHERE idAddress = pidAddres;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateDistrict;

--- CANTON
CREATE OR REPLACE PROCEDURE updateCanton(pidDistrict IN NUMBER, pidCanton IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE District
    SET idCanton = pidCanton
    WHERE idDistrict = pidDistrict;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateCanton;

--- PROVINCE
CREATE OR REPLACE PROCEDURE updateProvince(pidCanton IN NUMBER, pidProvince IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE Canton
    SET idProvince = pidProvince
    WHERE idCanton = pidCanton;
    
    codResult:= 0;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE; 
END updateProvince;


--- COUNTRY
CREATE OR REPLACE PROCEDURE updateCountry(pidProvince IN NUMBER, pidCountry IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE Province
    SET idCountry = pidCountry
    WHERE idProvince = pidProvince;
    
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

