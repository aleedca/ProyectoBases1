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
    SELECT p.idPerson
    INTO vnIdPlayer
    FROM Person P, Player PL
    WHERE pl.idPerson = pidPerson;
    
    IF(vnIdPlayer != NULL)
    THEN
        OPEN curPersonInformation FOR
        SELECT Person.firstName, Person.secondName, Person.firstLastName, Person.secondLastName, 
        Person.identification, Person.idTypeIdentification, Person.idPersonPosition, Person.photo,
        Person.idGender, Province.idCountry ,Canton.idProvince ,District.idCanton , Address.idDistrict ,Person.idAddress, 
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
        Person.idGender, Province.idCountry ,Canton.idProvince ,District.idCanton ,Address.idDistrict ,Person.idAddress, 
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