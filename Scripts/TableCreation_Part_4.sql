/* File Name: TableCreation_Part_4
Description: This file contains the creation of the tables, sequences and foreing keys
Authors:
Isaac Araya Solano - 2018151703
Alexia Cerdas Aguilar - 2019026961
Nahomi Bolaños Valverde - 2022089165
Mariana Fernández Martínez - 2021104026
*/

--Person
-- Table Comment
COMMENT ON TABLE Person
IS 'Repository for storing the information of Person.';
-- Comment on attributes
COMMENT ON COLUMN Person.idPerson
IS 'Unique identifier of the Person Table.';

COMMENT ON COLUMN Person.identification
IS 'Unique identifier of the Person Table.';

COMMENT ON COLUMN Person.firstName
IS 'First name of the person.';

COMMENT ON COLUMN Person.secondName
IS 'Second name of the person.';

COMMENT ON COLUMN Person.firstLastName
IS 'First last name of the person.';

COMMENT ON COLUMN Person.secondLastName
IS 'Second last name of the person.';

COMMENT ON COLUMN Person.photo
IS 'Link to the photo of the person.';

COMMENT ON COLUMN Person.idPosition
IS 'Reference to the PersonPosition Table.';

COMMENT ON COLUMN Person.idCountry
IS 'Reference to the Country Table.';

COMMENT ON COLUMN Person.idTypeIdentification
IS 'Reference to the TypeIdentification Table.';

COMMENT ON COLUMN Person.idGender
IS 'Reference to the Gender Table.';

--Audit Fields
COMMENT ON COLUMN Person.userCreation
IS 'User who creates the Person Table record.';

COMMENT ON COLUMN Person.lastUser
IS 'Last user to modify a record in the Person Table.';

COMMENT ON COLUMN Person.lastDate
IS 'Last modification date of the record in the Person Table.';

COMMENT ON COLUMN Person.dateCreation
IS 'Date of creation of the Person Table record.';

CREATE TABLE Person (
   idPerson NUMBER(11) PRIMARY KEY,
   identification NUMBER(9)CONSTRAINT person_identification_nn NOT NULL,
   firstName VARCHAR2(45) CONSTRAINT person_firstname_nn NOT NULL,
   secondName VARCHAR2(45) CONSTRAINT person_secondname_nn NOT NULL,
   firstLastName VARCHAR2(45) CONSTRAINT person_fstlastname_nn NOT NULL,
   secondLastName VARCHAR2(45) CONSTRAINT person_sndlastname_nn NOT NULL,
   photo VARCHAR2(45) CONSTRAINT person_photo_nn NOT NULL,
   idPosition NUMBER(11) CONSTRAINT person_idrole_nn NOT NULL,
   idCountry NUMBER(11) CONSTRAINT person_idcountry_nn NOT NULL,
   idTypeIdentification NUMBER(11) CONSTRAINT person_idtypeident_nn NOT NULL,
   idGender NUMBER(11) CONSTRAINT person_idgender_nn NOT NULL,
   userCreation VARCHAR2(45),
   lastUser VARCHAR2(45),
   lastDate DATE,
   dateCreation DATE
);

CREATE SEQUENCE s_person
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------    
-- Player
-- Table Comment
COMMENT ON TABLE Player
IS 'Repository for storing the information of a Player that extends the table Person.';
-- Comment on attributes
COMMENT ON COLUMN Player.idPerson
IS 'Unique identifier of the Player Table that also references the Person Table.';

COMMENT ON COLUMN Player.idTeam
IS 'Reference to the Team table.';

COMMENT ON COLUMN Player.birthdate
IS 'Birthdate of the player.';

COMMENT ON COLUMN Player.tShirtNum
IS 'The number in the T Shirt of the player.';

--Audit Fields
COMMENT ON COLUMN Player.userCreation
IS 'User who creates the Player Table record.';

COMMENT ON COLUMN Player.lastUser
IS 'Last user to modify a record in the Player Table.';

COMMENT ON COLUMN Player.lastDate
IS 'Last modification date of the record in the Player Table.';

COMMENT ON COLUMN Player.dateCreation
IS 'Date of creation of the Player Table record.';


CREATE TABLE Player (
   idPerson NUMBER(11) PRIMARY KEY,
   idTeam NUMBER(11) CONSTRAINT player_team_nn NOT NULL, 
   birthdate DATE CONSTRAINT player_birthdate_nn NOT NULL,
   tShirtNum NUMBER(3) CONSTRAINT player_tshirtnum_nn NOT NULL,
   userCreation VARCHAR2(45),
   lastUser VARCHAR2(45),
   lastDate DATE,
   dateCreation DATE
);


---------------------------------------------------------------------    
-- TeamWorker
COMMENT ON TABLE TeamWorker
IS 'Repository for storing the information of a TeamWorker that extends the table Person.';
-- Comment on attributes
COMMENT ON COLUMN TeamWorker.idPerson
IS 'Unique identifier of the TeamWorker Table that also references the Person Table.';

COMMENT ON COLUMN TeamWorker.idTeam
IS 'Reference to the Team table.';

--Audit Fields
COMMENT ON COLUMN TeamWorker.userCreation
IS 'User who creates the TeamWorker Table record.';

COMMENT ON COLUMN TeamWorker.lastUser
IS 'Last user to modify a record in the TeamWorker Table.';

COMMENT ON COLUMN TeamWorker.lastDate
IS 'Last modification date of the record in the TeamWorker Table.';

COMMENT ON COLUMN TeamWorker.dateCreation
IS 'Date of creation of the TeamWorker Table record.';

CREATE TABLE TeamWorker (
   idPerson NUMBER(11) PRIMARY KEY,
   idTeam NUMBER(11) CONSTRAINT teamworker_team_nn NOT NULL,
   userCreation VARCHAR2(45),
   lastUser VARCHAR2(45),
   lastDate DATE,
   dateCreation DATE
);

---------------------------------------------------------------------    
-- EventWorker

COMMENT ON TABLE EventWorker
IS 'Repository for storing the information of a EventWorker that extends the table Person.';
-- Comment on attributes
COMMENT ON COLUMN EventWorker.idPerson
IS 'Unique identifier of the EventWorker Table that also references the Person Table.';

--Audit Fields
COMMENT ON COLUMN EventWorker.userCreation
IS 'User who creates the EventWorker Table record.';

COMMENT ON COLUMN EventWorker.lastUser
IS 'Last user to modify a record in the EventWorker Table.';

COMMENT ON COLUMN EventWorker.lastDate
IS 'Last modification date of the record in the EventWorker Table.';

COMMENT ON COLUMN EventWorker.dateCreation
IS 'Date of creation of the EventWorker Table record.';

    
CREATE TABLE EventWorker (
   idPerson NUMBER(11) PRIMARY KEY,
   userCreation VARCHAR2(45),
   lastUser VARCHAR2(45),
   lastDate DATE,
   dateCreation DATE
);

---------------------------------------------------------------------    
-- UserType

COMMENT ON TABLE UserType
IS 'Repository for storing the information of a UserType.';
-- Comment on attributes
COMMENT ON COLUMN UserType.idUserType
IS 'Unique identifier of the UserType Table.';

COMMENT ON COLUMN UserType.descriptionUserType
IS 'Description of the type of user in the UserType Table.';

--Audit Fields
COMMENT ON COLUMN UserType.userCreation
IS 'User who creates the UserType Table record.';

COMMENT ON COLUMN UserType.lastUser
IS 'Last user to modify a record in the UserType Table.';

COMMENT ON COLUMN UserType.lastDate
IS 'Last modification date of the record in the UserType Table.';

COMMENT ON COLUMN UserType.dateCreation
IS 'Date of creation of the UserType Table record.';
    
CREATE TABLE UserType (
   idUserType NUMBER(11) PRIMARY KEY,
   descriptionUserType VARCHAR2(32) CONSTRAINT usertype_description_nn NOT NULL,
   userCreation VARCHAR2(45),
   lastUser VARCHAR2(45),
   lastDate DATE,
   dateCreation DATE
);

CREATE SEQUENCE s_usertype
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------    
-- UserPerson

COMMENT ON TABLE UserPerson
IS 'Repository for storing the information of a UserType.';
-- Comment on attributes
COMMENT ON COLUMN UserPerson.username
IS 'Unique identifier of the UserType Table.';

COMMENT ON COLUMN UserPerson.idUserType
IS 'Reference to the table UserType';

COMMENT ON COLUMN UserPerson.idPerson
IS 'Reference to the table Person';

COMMENT ON COLUMN UserPerson.passwordUser
IS 'Password for the user to access his account.';

--Audit Fields
COMMENT ON COLUMN UserPerson.userCreation
IS 'User who creates the UserPerson Table record.';

COMMENT ON COLUMN UserPerson.lastUser
IS 'Last user to modify a record in the UserPerson Table.';

COMMENT ON COLUMN UserPerson.lastDate
IS 'Last modification date of the record in the UserPerson Table.';

COMMENT ON COLUMN UserPerson.dateCreation
IS 'Date of creation of the UserPerson Table record.';
    
CREATE TABLE UserPerson (
   username VARCHAR2(32) PRIMARY KEY,
   idUserType NUMBER(11) CONSTRAINT userperson_idusertype_nn NOT NULL,
   idPerson NUMBER(11) CONSTRAINT userperson_idperson_nn NOT NULL,
   passwordUser VARCHAR2(32) CONSTRAINT userperson_passworduser_nn NOT NULL,
   userCreation VARCHAR2(45),
   lastUser VARCHAR2(45),
   lastDate DATE,
   dateCreation DATE
);

---------------------------------------------------------------------    
-- UserXNews    

COMMENT ON TABLE UserXNews
IS 'Repository for storing the information of a UserType.';
-- Comment on attributes
COMMENT ON COLUMN UserXNews.idUserXNews
IS 'Unique identifier of the UserType Table.';

COMMENT ON COLUMN UserXNews.username
IS 'Reference to the table UserPerson';

COMMENT ON COLUMN UserXNews.idNews
IS 'Reference to the table News';

--Audit Fields
COMMENT ON COLUMN UserXNews.userCreation
IS 'User who creates the UserXNews Table record.';

COMMENT ON COLUMN UserXNews.lastUser
IS 'Last user to modify a record in the UserXNews Table.';

COMMENT ON COLUMN UserXNews.lastDate
IS 'Last modification date of the record in the UserXNews Table.';

COMMENT ON COLUMN UserXNews.dateCreation
IS 'Date of creation of the UserXNews Table record.';

    
CREATE TABLE UserXNews (
   idUserXNews NUMBER(11) PRIMARY KEY,
   username VARCHAR2(32) CONSTRAINT userxnews_username_nn NOT NULL,
   idNews NUMBER(11) CONSTRAINT userxnews_idnews_nn NOT NULL,
   userCreation VARCHAR2(45),
   lastUser VARCHAR2(45),
   lastDate DATE,
   dateCreation DATE
);

CREATE SEQUENCE s_userxnews
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------    
-- ParameterTable    

COMMENT ON TABLE ParameterTable
IS 'Repository for storing the information of a UserType.';
-- Comment on attributes
COMMENT ON COLUMN ParameterTable.idParameterTable
IS 'Unique identifier of the ParameterTable Table.';

COMMENT ON COLUMN ParameterTable.nameParameter
IS 'Name of the parameter that is being stored';

COMMENT ON COLUMN ParameterTable.valueParameter
IS 'Value of the parameter that is being stored';

--Audit Fields
COMMENT ON COLUMN ParameterTable.userCreation
IS 'User who creates the ParameterTable Table record.';

COMMENT ON COLUMN ParameterTable.lastUser
IS 'Last user to modify a record in the ParameterTable Table.';

COMMENT ON COLUMN ParameterTable.lastDate
IS 'Last modification date of the record in the ParameterTable Table.';

COMMENT ON COLUMN ParameterTable.dateCreation
IS 'Date of creation of the ParameterTable Table record.';    
    
    
CREATE TABLE ParameterTable (
   idParameterTable NUMBER(11) PRIMARY KEY,
   nameParameter VARCHAR2(32) CONSTRAINT parameter_name_nn NOT NULL,
   valueParameter NUMBER(11) CONSTRAINT parameter_value_nn NOT NULL,
   userCreation VARCHAR2(45),
   lastUser VARCHAR2(45),
   lastDate DATE,
   dateCreation DATE
);

CREATE SEQUENCE s_parameter
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;


--FOREING KEYS-------------------------------------------------------
--Person foreing keys
ALTER TABLE Person
    ADD CONSTRAINT fk_person_personposition FOREIGN KEY (idPosition) REFERENCES PersonPosition(idPosition);
    
ALTER TABLE Person
    ADD CONSTRAINT fk_person_country FOREIGN KEY (idCountry) REFERENCES Country(idCountry);

ALTER TABLE Person
    ADD CONSTRAINT fk_person_typeid FOREIGN KEY (idTypeIdentification) REFERENCES TypeIdentification(idTypeIdentification);

ALTER TABLE Person
    ADD CONSTRAINT fk_person_gender FOREIGN KEY (idGender) REFERENCES Gender(idGender);

--Player foreing keys
ALTER TABLE Player
    ADD CONSTRAINT fk_player_person FOREIGN KEY (idPerson) REFERENCES Person(idPerson);
    
ALTER TABLE Player
    ADD CONSTRAINT fk_player_team FOREIGN KEY (idTeam) REFERENCES Team(idTeam);

--Teamworker foreing keys
ALTER TABLE TeamWorker
    ADD CONSTRAINT fk_teamworker_person FOREIGN KEY (idPerson) REFERENCES Person(idPerson);
    
ALTER TABLE TeamWorker
    ADD CONSTRAINT fk_teamworker_team FOREIGN KEY (idTeam) REFERENCES Team(idTeam);

--EventWorker foreing keys
ALTER TABLE EventWorker
    ADD CONSTRAINT fk_eventworker_person FOREIGN KEY (idPerson) REFERENCES Person(idPerson);    

--UserPerson foreing keys
ALTER TABLE UserPerson
    ADD CONSTRAINT fk_userperson_person FOREIGN KEY (idPerson) REFERENCES Person(idPerson); 
    
ALTER TABLE UserPerson
    ADD CONSTRAINT fk_userperson_usertype FOREIGN KEY (idUserType) REFERENCES UserType(idUserType);  
    
--UserXNews foreing keys
ALTER TABLE UserXNews
    ADD CONSTRAINT fk_userxnews_user FOREIGN KEY (username) REFERENCES UserPerson(username); 
    
ALTER TABLE UserXNews
    ADD CONSTRAINT fk_userxnews_news FOREIGN KEY (idNews) REFERENCES News(idNews);  
    
    