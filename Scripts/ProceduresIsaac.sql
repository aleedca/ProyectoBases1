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

CREATE OR REPLACE PROCEDURE getAccountInformation(pUsername IN VARCHAR2, outAccountCursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN outAccountCursor FOR
    SELECT UserPerson.username, UserPerson.passwordUser, Person.firstName, Person.secondName,
    Person.firstLastName, Person.secondLastName, Person.identification, Gender.descriptionGender,
    Mail.descriptionMail, Phone.phoneNumber
    FROM UserPerson
    INNER JOIN Person ON Person.idPerson = UserPerson.idPerson
    INNER JOIN Gender ON Person.idGender = Gender.idGender
    INNER JOIN Mail ON Mail.idPerson = Person.idPerson
    INNER JOIN PersonXPhone ON PersonXPhone.idPerson = Person.idPerson
    INNER JOIN Phone ON Phone.idPhone = PersonXPhone.idPhone
    WHERE UserPerson.username = pUsername;
END;


