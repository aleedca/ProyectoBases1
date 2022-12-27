/* File Name: TableCreation_Part_2
Description: This file contains the code to create tables, their sequences and associations.
Authors:
Isaac Araya Solano - 2018151703
Alexia Cerdas Aguilar - 2019026961
Nahomi Bolaños Valverde - 2022089165
Mariana Fernández Martínez - 2021104026
*/

-- ////////////////////////////////////// TABLE CREATION ////////////////////////////////////
-- Country
CREATE TABLE Country(
    idCountry NUMBER(10) PRIMARY KEY,
    nameCountry VARCHAR(32) CONSTRAINT country_name_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Country
IS 'Repository to store the information of the countries participating in the event.';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Country.idCountry
IS 'Unique identifier of the Country table.';

COMMENT ON COLUMN Country.nameCountry
IS 'Name of Country.';

-- Audit Fields
COMMENT ON COLUMN Country.userCreation
IS 'User who creates the Country Table record.';

COMMENT ON COLUMN Country.dateCreation
IS 'Date of creation of the Country Table record';

COMMENT ON COLUMN Country.lastUser
IS 'Last user to modify a Country Table record';

COMMENT ON COLUMN Country.lastDate
IS 'Last modification date of the record in the Country Table';


-- Stadium
CREATE TABLE Stadium(
    idStadium NUMBER(10) PRIMARY KEY,
    idCountry NUMBER(10) CONSTRAINT stadium_idCountry_nn NOT NULL, 
    nameStadium VARCHAR(32) CONSTRAINT stadium_name_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Stadium
IS 'Repository to store the information of the stadiums of the event.';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Stadium.idStadium
IS 'Unique identifier of the Stadium Table.';

COMMENT ON COLUMN Stadium.idCountry
IS 'Reference to Country Table';

COMMENT ON COLUMN Stadium.nameStadium
IS 'Name of the stadium.';

-- Audit Fields 
COMMENT ON COLUMN Stadium.userCreation
IS 'User who creates the Stadium Table record.';

COMMENT ON COLUMN Stadium.dateCreation
IS 'Date of creation of the Stadium Table record';

COMMENT ON COLUMN Stadium.lastUser
IS 'Last user to modify a Stadium Table record';

COMMENT ON COLUMN Stadium.lastDate
IS 'Last modification date of the record in the Stadium Table';


-- Province
CREATE TABLE Province(
    idProvince NUMBER(10) PRIMARY KEY,
    idCountry NUMBER(10) CONSTRAINT province_idCountry_nn NOT NULL, 
    nameProvince VARCHAR(32) CONSTRAINT province_name_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Province
IS 'Repository to store the information of the provinces of the event.';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Province.idProvince
IS 'Unique identifier of the Province Table.';

COMMENT ON COLUMN Province.idCountry
IS 'Reference to Country Table';

COMMENT ON COLUMN Province.nameProvince
IS 'Name of the province.';

-- Audit Fields 
COMMENT ON COLUMN Province.userCreation
IS 'User who creates the Province Table record.';

COMMENT ON COLUMN Province.dateCreation
IS 'Date of creation of the Province Table record';

COMMENT ON COLUMN Province.lastUser
IS 'Last user to modify a Province Table record';

COMMENT ON COLUMN Province.lastDate
IS 'Last modification date of the record in the Province Table';


-- Canton
CREATE TABLE Canton(
    idCanton NUMBER(10) PRIMARY KEY,
    idProvince NUMBER(10) CONSTRAINT canton_idProvince_nn NOT NULL,
    nameCanton VARCHAR(32) CONSTRAINT canton_name_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Canton
IS 'Repository to store canton information';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Canton.idCanton
IS 'Unique identifier of the Canton Table.';

COMMENT ON COLUMN Canton.idProvince
IS 'Reference to Province Table';

COMMENT ON COLUMN Canton.nameCanton
IS 'Name of the canton.';

-- Audit Fields 
COMMENT ON COLUMN Canton.userCreation
IS 'User who creates the Canton Table record.';

COMMENT ON COLUMN Canton.dateCreation
IS 'Date of creation of the Canton Table record';

COMMENT ON COLUMN Canton.lastUser
IS 'Last user to modify a Canton Table record';

COMMENT ON COLUMN Canton.lastDate
IS 'Last modification date of the record in the Canton Table';

-- District
CREATE TABLE District(
    idDistrict NUMBER(10) PRIMARY KEY,
    idCanton NUMBER(10) CONSTRAINT district_idCanton_nn NOT NULL,
    nameDistrict VARCHAR(32) CONSTRAINT district_name_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE District
IS 'Repository to store district information';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN District.idDistrict
IS 'Unique identifier of the District Table.';

COMMENT ON COLUMN District.idCanton
IS 'Reference to Canton Table.';

COMMENT ON COLUMN District.nameDistrict
IS 'Name of the district.';

-- Audit Fields 
COMMENT ON COLUMN District.userCreation
IS 'User who creates the District Table record.';

COMMENT ON COLUMN District.dateCreation
IS 'Date of creation of the District Table record.';

COMMENT ON COLUMN District.lastUser
IS 'Last user to modify a District Table record.';

COMMENT ON COLUMN District.lastDate
IS 'Last modification date of the record in the District Table.';


-- Address
CREATE TABLE Address(
    idAddress NUMBER(10) PRIMARY KEY,
    idDistrict NUMBER(10) CONSTRAINT address_idDistrict_nn NOT NULL, 
    descriptionAddress VARCHAR(32) CONSTRAINT address_description_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Address
IS 'Repository for storing address information';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Address.idAddress
IS 'Unique identifier of the Address Table.';

COMMENT ON COLUMN Address.idDistrict
IS 'Reference to District Table.';

COMMENT ON COLUMN Address.descriptionAddress
IS 'Description of the address.';

-- Audit Fields 
COMMENT ON COLUMN Address.userCreation
IS 'User who creates the Address Table record.';

COMMENT ON COLUMN Address.dateCreation
IS 'Date of creation of the Address Table record.';

COMMENT ON COLUMN Address.lastUser
IS 'Last user to modify an Address Table record.';

COMMENT ON COLUMN District.lastDate
IS 'Last modification date of the record in the Address Table.';

----------------------------------------------------------------------------------------------------
-- Mail
CREATE TABLE Mail(
    idMail NUMBER(10) PRIMARY KEY,
    idPerson NUMBER(10) CONSTRAINT mail_idPerson_nn NOT NULL,
    descriptionMail VARCHAR(32) CONSTRAINT mail_description_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Mail
IS 'Repository for storing information on e-mails';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Mail.idMail
IS 'Unique identifier of the Mail Table.';

COMMENT ON COLUMN Mail.idPerson
IS 'Reference to Person Table.';

COMMENT ON COLUMN Mail.descriptionMail
IS 'Description of the mail.';

-- Audit Fields 
COMMENT ON COLUMN Mail.userCreation
IS 'User who creates the Mail Table record.';

COMMENT ON COLUMN Mail.dateCreation
IS 'Date of creation of the Mail Table record.';

COMMENT ON COLUMN Mail.lastUser
IS 'Last user to modify a record in the Mail Table.';

COMMENT ON COLUMN Mail.lastDate
IS 'Last modification date of the record in the Mail Table.';


-- Phone
CREATE TABLE Phone(
    idPhone NUMBER(10) PRIMARY KEY,
    phoneNumber NUMBER(8) CONSTRAINT phone_phoneNumber_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Phone
IS 'Repository for storing information about phone numbers';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Phone.idPhone
IS 'Unique identifier of the Phone Table.';

COMMENT ON COLUMN Phone.phoneNumber
IS 'Phone number of a person';

-- Audit Fields 
COMMENT ON COLUMN Phone.userCreation
IS 'User who creates the Phone Table record.';

COMMENT ON COLUMN Phone.dateCreation
IS 'Date of creation of the Phone Table record.';

COMMENT ON COLUMN Phone.lastUser
IS 'Last user to modify a record in the Phone Table.';

COMMENT ON COLUMN Phone.lastDate
IS 'Last modification date of the record in the Phone Table.';


-- PersonXPhone
CREATE TABLE PersonXPhone(
    idPersonXPhone NUMBER(10) PRIMARY KEY,
    idPerson NUMBER(10) CONSTRAINT phone_idPerson_nn NOT NULL,
    idPhone NUMBER(10) CONSTRAINT phone_idPhone_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE PersonXPhone
IS 'Repository for storing information about the relationship between people and telephones';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN PersonXPhone.idPersonXPhone
IS 'Unique identifier of the PersonXPhone Table.';

COMMENT ON COLUMN PersonXPhone.idPerson
IS 'Reference to Person Table.';

COMMENT ON COLUMN PersonXPhone.idPhone
IS 'Reference to Phone Table.';

-- Audit Fields 
COMMENT ON COLUMN PersonXPhone.userCreation
IS 'User who creates the PersonXPhone Table record.';

COMMENT ON COLUMN PersonXPhone.dateCreation
IS 'Date of creation of the PersonXPhone Table record.';

COMMENT ON COLUMN PersonXPhone.lastUser
IS 'Last user to modify a record in the PersonXPhone Table.';

COMMENT ON COLUMN PersonXPhone.lastDate
IS 'Last modification date of the record in the PersonXPhone Table.';

-------------------------------------------------------------------------------------------
-- PlayerXSoccerMatchXTeam
CREATE TABLE PlayerXSoccerMatchXTeam(
    idPlayerXMatchXTeam NUMBER(10) PRIMARY KEY,
    idPerson NUMBER(10) CONSTRAINT playerxsoccermatchxteam_idPerson_nn NOT NULL, 
    idSoccerMatch NUMBER(10) CONSTRAINT playerxsoccermatchxteam_idSoccerMatch_nn NOT NULL, 
    idTeam NUMBER(10) CONSTRAINT playerxsoccermatchxteam_idTeam_nn NOT NULL, 
    yellowCards NUMBER(1) CONSTRAINT playerxsoccermatchxteam_yellowCards_nn NOT NULL,
    redCards NUMBER(1) CONSTRAINT playerxsoccermatchxteam_redCards_nn NOT NULL,
    offsides NUMBER(2) CONSTRAINT playerxsoccermatchxteam_offsides_nn NOT NULL,
    corners NUMBER(2) CONSTRAINT playerxsoccermatchxteam_corners_nn NOT NULL,
    goals NUMBER(2) CONSTRAINT playerxsoccermatchxteam_goals_nn NOT NULL,
    saves NUMBER(2) CONSTRAINT playerxsoccermatchxteam_saves_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE PlayerXSoccerMatchXTeam
IS 'Repository to store information about the relationship between players, soccer match and team.';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN PlayerXSoccerMatchXTeam.idPlayerXMatchXTeam
IS 'Unique identifier of the PlayerXSoccerMatchXTeam Table.';

COMMENT ON COLUMN PlayerXSoccerMatchXTeam.idPerson
IS 'Reference to Player Table.';

COMMENT ON COLUMN PlayerXSoccerMatchXTeam.idSoccerMatch
IS 'Reference to SoccerMatch Table.';

COMMENT ON COLUMN PlayerXSoccerMatchXTeam.idTeam
IS 'Reference to Team Table.';

COMMENT ON COLUMN PlayerXSoccerMatchXTeam.yellowCards
IS 'Counting of yellow cards in the game.';

COMMENT ON COLUMN PlayerXSoccerMatchXTeam.redCards
IS 'Counting of red cards in the game.';

COMMENT ON COLUMN PlayerXSoccerMatchXTeam.offsides
IS 'Offside count.';

COMMENT ON COLUMN PlayerXSoccerMatchXTeam.corners
IS 'Count of corner kicks in the match.';

COMMENT ON COLUMN PlayerXSoccerMatchXTeam.goals
IS 'Goal count in a match.';

COMMENT ON COLUMN PlayerXSoccerMatchXTeam.saves
IS 'Saves count in a match.';

-- Audit Fields 
COMMENT ON COLUMN PlayerXSoccerMatchXTeam.userCreation
IS 'User who creates the PlayerXSoccerMatchXTeam Table record.';

COMMENT ON COLUMN PlayerXSoccerMatchXTeam.dateCreation
IS 'Date of creation of the PlayerXSoccerMatchXTeam Table record.';

COMMENT ON COLUMN PlayerXSoccerMatchXTeam.lastUser
IS 'Last user to modify a record in the PlayerXSoccerMatchXTeam Table.';

COMMENT ON COLUMN PlayerXSoccerMatchXTeam.lastDate
IS 'Last modification date of the record in the PlayerXSoccerMatchXTeam Table.';

------------------------------------------------------------------------------------------------

-- ////////////////////////////////////// FOREING KEYS PART 2////////////////////////////////////
-- FK Stadium-Country
ALTER TABLE Stadium
    ADD CONSTRAINT fk_stadium_country FOREIGN KEY (idCountry) REFERENCES Country(idCountry);

-- FK Province-Country
ALTER TABLE Province
    ADD CONSTRAINT fk_province_country FOREIGN KEY (idCountry) REFERENCES Country(idCountry);

-- FK Canton-Province
ALTER TABLE Canton
    ADD CONSTRAINT fk_canton_province FOREIGN KEY (idProvince) REFERENCES Province(idProvince);

-- FK District-Canton
ALTER TABLE District
    ADD CONSTRAINT fk_district_canton FOREIGN KEY (idCanton) REFERENCES Canton(idCanton);

-- FK Address-District
ALTER TABLE Address
    ADD CONSTRAINT fk_address_district FOREIGN KEY (idDistrict) REFERENCES District(idDistrict);

----------------------------------------------------------------------------------------------------------------
-- FK Mail-Person
ALTER TABLE Mail
    ADD CONSTRAINT fk_mail_person FOREIGN KEY (idPerson) REFERENCES Person(idPerson);

-- FK PersonXPhone-Person
ALTER TABLE PersonXPhone
    ADD CONSTRAINT fk_personxphone_person FOREIGN KEY (idPerson) REFERENCES Person(idPerson);

-- FK PersonXPhone-Phone
ALTER TABLE PersonXPhone
    ADD CONSTRAINT fk_personxphone_phone FOREIGN KEY (idPhone) REFERENCES Phone(idPhone);
    
-----------------------------------------------------------------------------------------------------------------
-- FK PlayerXSoccerMatchXTeam-Player
ALTER TABLE PlayerXSoccerMatchXTeam
    ADD CONSTRAINT fk_playerxsoccermatchxteam_player FOREIGN KEY (idPerson) REFERENCES Player(idPerson);

-- FK PlayerXSoccerMatchXTeam-SoccerMatch
ALTER TABLE PlayerXSoccerMatchXTeam
    ADD CONSTRAINT fk_playerxsoccermatchxteam_soccermatch FOREIGN KEY (idSoccerMatch) REFERENCES SoccerMatch(idSoccerMatch);

-- FK PlayerXSoccerMatchXTeam-Team
ALTER TABLE PlayerXSoccerMatchXTeam
    ADD CONSTRAINT fk_playerxsoccermatchxteam_team FOREIGN KEY (idTeam) REFERENCES Team(idTeam);

-- ////////////////////////////////////// SEQUENCES ////////////////////////////////////    

-- Country
CREATE SEQUENCE s_country
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Stadium
CREATE SEQUENCE s_stadium
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Province
CREATE SEQUENCE s_province
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Canton
CREATE SEQUENCE s_canton
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- District
CREATE SEQUENCE s_district
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Address
CREATE SEQUENCE s_address
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Mail
CREATE SEQUENCE s_mail
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Phone
CREATE SEQUENCE s_phone
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- PersonXPhone
CREATE SEQUENCE s_person_phone
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;
  
-- PlayerXSoccerMatchXTeam
CREATE SEQUENCE s_player_soccerMatch_team
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;


