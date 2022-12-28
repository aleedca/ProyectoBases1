/* File Name: TableCreation_Part_1
Description: This file contains the code to create tables, their sequences and associations.
Authors:
Isaac Araya Solano - 2018151703
Alexia Cerdas Aguilar - 2019026961
Nahomi Bolaños Valverde - 2022089165
Mariana Fernández Martínez - 2021104026
*/

-- ////////////////////////////////////// TABLE CREATION ////////////////////////////////////
-- Gender
CREATE TABLE Gender(
    idGender NUMBER(10) PRIMARY KEY,
    descriptionGender VARCHAR(32) CONSTRAINT gender_description_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Gender
IS 'Repository for storing the information of gender';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Gender.idGender
IS 'Unique identifier of the Gender Table.';

COMMENT ON COLUMN Gender.descriptionGender
IS 'Description of the gender.';

-- Audit Fields 
COMMENT ON COLUMN Gender.userCreation
IS 'User who creates the Gender Table record.';

COMMENT ON COLUMN Gender.dateCreation
IS 'Date of creation of the Gender Table record.';

COMMENT ON COLUMN Gender.lastUser
IS 'Last user to modify a record in the Gender Table.';

COMMENT ON COLUMN Gender.lastDate
IS 'Last modification date of the record in the Gender Table.';

-------------------------------------------------------------------------------------------

-- TypeIdentification
CREATE TABLE TypeIdentification(
    idTypeIdentification NUMBER(10) PRIMARY KEY,
    mask VARCHAR(16) CONSTRAINT typeIdentification_mask_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE TypeIdentification
IS 'Repository for storing the information of type identification';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN TypeIdentification.idTypeIdentification
IS 'Unique identifier of the TypeIdentification Table.';

COMMENT ON COLUMN TypeIdentification.mask
IS 'Mask of the TypeIdentification.';

-- Audit Fields 
COMMENT ON COLUMN TypeIdentification.userCreation
IS 'User who creates the TypeIdentification Table record.';

COMMENT ON COLUMN TypeIdentification.dateCreation
IS 'Date of creation of the TypeIdentification Table record.';

COMMENT ON COLUMN TypeIdentification.lastUser
IS 'Last user to modify a record in the TypeIdentification Table.';

COMMENT ON COLUMN TypeIdentification.lastDate
IS 'Last modification date of the record in the TypeIdentification Table.';

-------------------------------------------------------------------------------------------

-- Calendar
CREATE TABLE Calendar(
    idCalendar NUMBER(10) PRIMARY KEY,
    descriptionCalendar VARCHAR(32) CONSTRAINT calendar_description_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Calendar
IS 'Repository for storing the information of calendar';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Calendar.idCalendar
IS 'Unique identifier of the Calendar Table.';

COMMENT ON COLUMN Calendar.descriptionCalendar
IS 'Description of the calendar.';

-- Audit Fields 
COMMENT ON COLUMN Calendar.userCreation
IS 'User who creates the Calendar Table record.';

COMMENT ON COLUMN Calendar.dateCreation
IS 'Date of creation of the Calendar Table record.';

COMMENT ON COLUMN Calendar.lastUser
IS 'Last user to modify a record in the Calendar Table.';

COMMENT ON COLUMN Calendar.lastDate
IS 'Last modification date of the record in the Calendar Table.';

-------------------------------------------------------------------------------------------

-- Continent
CREATE TABLE Continent(
    idContinent NUMBER(10) PRIMARY KEY,
    nameContinent VARCHAR(32) CONSTRAINT continent_name_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Continent
IS 'Repository for storing the information of continent';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Continent.idContinent
IS 'Unique identifier of the Continent Table.';

COMMENT ON COLUMN Continent.nameContinent
IS 'Name of the continent.';

-- Audit Fields 
COMMENT ON COLUMN Continent.userCreation
IS 'User who creates the Continent Table record.';

COMMENT ON COLUMN Continent.dateCreation
IS 'Date of creation of the Continent Table record.';

COMMENT ON COLUMN Continent.lastUser
IS 'Last user to modify a record in the Continent Table.';

COMMENT ON COLUMN Continent.lastDate
IS 'Last modification date of the record in the Continent Table.';

-------------------------------------------------------------------------------------------

-- Event
CREATE TABLE Event(
    idEvent NUMBER(10) PRIMARY KEY,
    idCalendar NUMBER(10) CONSTRAINT event_idCalendar_nn NOT NULL,
    typeEvent VARCHAR(32) CONSTRAINT event_typeEvent_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Event
IS 'Repository for storing the information of the event';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Event.idEvent
IS 'Unique identifier of the Event Table.';

COMMENT ON COLUMN Event.idCalendar
IS 'Reference to Calendar Table.';

COMMENT ON COLUMN Event.typeEvent
IS 'Type of event.';

-- Audit Fields 
COMMENT ON COLUMN Event.userCreation
IS 'User who creates the Event Table record.';

COMMENT ON COLUMN Event.dateCreation
IS 'Date of creation of the Event Table record.';

COMMENT ON COLUMN Event.lastUser
IS 'Last user to modify a record in the Event Table.';

COMMENT ON COLUMN Event.lastDate
IS 'Last modification date of the record in the Event Table.';

-------------------------------------------------------------------------------------------

-- Group
CREATE TABLE GroupEvent(
    idGroupEvent NUMBER(10) PRIMARY KEY,
    idEvent NUMBER(10) CONSTRAINT groupEvent_idEvent_nn NOT NULL,
    descriptionGroupEvent VARCHAR(32) CONSTRAINT groupEvent_description_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE GroupEvent
IS 'Repository for storing the information of the group of each event';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN GroupEvent.idGroupEvent
IS 'Unique identifier of the GroupEvent Table.';

COMMENT ON COLUMN GroupEvent.idEvent
IS 'Reference to Event Table.';

COMMENT ON COLUMN GroupEvent.descriptionGroupEvent
IS 'Description of the group of each event.';

-- Audit Fields 
COMMENT ON COLUMN GroupEvent.userCreation
IS 'User who creates the GroupEvent Table record.';

COMMENT ON COLUMN GroupEvent.dateCreation
IS 'Date of creation of the GroupEvent Table record.';

COMMENT ON COLUMN GroupEvent.lastUser
IS 'Last user to modify a record in the GroupEvent Table.';

COMMENT ON COLUMN GroupEvent.lastDate
IS 'Last modification date of the record in the GroupEvent Table.';

-------------------------------------------------------------------------------------------

-- CountryTeam
CREATE TABLE CountryTeam(
    idCountryTeam NUMBER(10) PRIMARY KEY,
    idContinent NUMBER(10) CONSTRAINT countryTeam_idContinent_nn NOT NULL,
    nameCountryTeam VARCHAR(32) CONSTRAINT countryTeam_name_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE CountryTeam
IS 'Repository for storing the information of the country team';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN CountryTeam.idCountryTeam
IS 'Unique identifier of the CountryTeam Table.';

COMMENT ON COLUMN CountryTeam.idContinent
IS 'Reference to Continent Table.';

COMMENT ON COLUMN CountryTeam.nameCountryTeam
IS 'Name of the country of the team.';

-- Audit Fields 
COMMENT ON COLUMN CountryTeam.userCreation
IS 'User who creates the CountryTeam Table record.';

COMMENT ON COLUMN CountryTeam.dateCreation
IS 'Date of creation of the CountryTeam Table record.';

COMMENT ON COLUMN CountryTeam.lastUser
IS 'Last user to modify a record in the CountryTeam Table.';

COMMENT ON COLUMN CountryTeam.lastDate
IS 'Last modification date of the record in the CountryTeam Table.';

-------------------------------------------------------------------------------------------

-- Team
CREATE TABLE Team(
    idTeam NUMBER(10) PRIMARY KEY,
    idCountryTeam NUMBER(10) CONSTRAINT team_idCountryTeam_nn NOT NULL,
    idGroupEvent NUMBER(10) CONSTRAINT team_idGroupEvent_nn NOT NULL,
    nameTeam VARCHAR(32) CONSTRAINT team_name_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Team
IS 'Repository for storing the information of the team';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Team.idTeam
IS 'Unique identifier of the Team Table.';

COMMENT ON COLUMN Team.idCountryTeam
IS 'Reference to CountryTeam Table.';

COMMENT ON COLUMN Team.idGroupEvent
IS 'Reference to GroupEvent Table.';

COMMENT ON COLUMN Team.nameTeam
IS 'Name of the team.';

-- Audit Fields 
COMMENT ON COLUMN Team.userCreation
IS 'User who creates the Team Table record.';

COMMENT ON COLUMN Team.dateCreation
IS 'Date of creation of the Team Table record.';

COMMENT ON COLUMN Team.lastUser
IS 'Last user to modify a record in the Team Table.';

COMMENT ON COLUMN Team.lastDate
IS 'Last modification date of the record in the Team Table.';

-------------------------------------------------------------------------------------------

-- GroupStats
CREATE TABLE GroupStats(
    idStats NUMBER(10) PRIMARY KEY,
    idTeam NUMBER(10) CONSTRAINT groupStats_idTeam_nn NOT NULL,
    wonMatches NUMBER(10) CONSTRAINT groupStats_wonMatches_nn NOT NULL,
    tiedMatches NUMBER(10) CONSTRAINT groupStats_tiedMatches_nn NOT NULL,
    lostMatches NUMBER(10) CONSTRAINT groupStats_lostMatches_nn NOT NULL,
    goalsScored NUMBER(10) CONSTRAINT groupStats_goalsScored_nn NOT NULL,
    goalsReceived NUMBER(10) CONSTRAINT groupStats_goalsReceived_nn NOT NULL,
    fairPlayPoints NUMBER(10) CONSTRAINT groupStats_fairPlayPoints_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE GroupStats
IS 'Repository for storing the information of the stats of each team on depending on their group';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN GroupStats.idStats
IS 'Unique identifier of the GroupStats Table.';

COMMENT ON COLUMN GroupStats.idTeam
IS 'Reference to Team Table.';

COMMENT ON COLUMN GroupStats.wonMatches
IS 'Amount of won matches of the team on their group';

COMMENT ON COLUMN GroupStats.tiedMatches
IS 'Amount of tied matches of the team on their group';

COMMENT ON COLUMN GroupStats.lostMatches
IS 'Amount of lost matches of the team on their group';

COMMENT ON COLUMN GroupStats.goalsScored
IS 'Amount of goals scored of the team on their group';

COMMENT ON COLUMN GroupStats.goalsReceived
IS 'Amount of goals received of the team on their group';

COMMENT ON COLUMN GroupStats.fairPlayPoints
IS 'Amount of fair play points of the team on their group';

-- Audit Fields 
COMMENT ON COLUMN GroupStats.userCreation
IS 'User who creates the GroupStats Table record.';

COMMENT ON COLUMN GroupStats.dateCreation
IS 'Date of creation of the GroupStats Table record.';

COMMENT ON COLUMN GroupStats.lastUser
IS 'Last user to modify a record in the GroupStats Table.';

COMMENT ON COLUMN GroupStats.lastDate
IS 'Last modification date of the record in the GroupStats Table.';

-------------------------------------------------------------------------------------------

CREATE TABLE SoccerMatchXStadium(
    idSoccerMatchXStadium NUMBER(10) PRIMARY KEY,
    idSoccerMatch NUMBER(10) CONSTRAINT soccerMatchXStadium_idSoccerMatch_nn NOT NULL,
    idStadium NUMBER(10) CONSTRAINT soccerMatchXStadium_idStadium_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE SoccerMatchXStadium
IS 'Repository for storing the information about the relationship between soccerMatch and stadium';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN SoccerMatchXStadium.idSoccerMatchXStadium
IS 'Unique identifier of the SoccerMatchXStadium Table.';

COMMENT ON COLUMN SoccerMatchXStadium.idSoccerMatch
IS 'Reference to SoccerMatch Table.';

COMMENT ON COLUMN SoccerMatchXStadium.idStadium
IS 'Reference to Stadium Table.';

-- Audit Fields 
COMMENT ON COLUMN SoccerMatchXStadium.userCreation
IS 'User who creates the SoccerMatchXStadium Table record.';

COMMENT ON COLUMN SoccerMatchXStadium.dateCreation
IS 'Date of creation of the SoccerMatchXStadium Table record.';

COMMENT ON COLUMN SoccerMatchXStadium.lastUser
IS 'Last user to modify a record in the SoccerMatchXStadium Table.';

COMMENT ON COLUMN SoccerMatchXStadium.lastDate
IS 'Last modification date of the record in the SoccerMatchXStadium Table.';

-------------------------------------------------------------------------------------------

-- ////////////////////////////////////// FOREING KEYS PART 1////////////////////////////////////
-- FK Event-Calendar
ALTER TABLE Event
    ADD CONSTRAINT fk_event_calendar FOREIGN KEY (idCalendar) REFERENCES Calendar(idCalendar);

-- FK GroupEvent-Event
ALTER TABLE GroupEvent
    ADD CONSTRAINT fk_group_event FOREIGN KEY (idEvent) REFERENCES Event(idEvent);

-- FK CountryTeam-Continent
ALTER TABLE CountryTeam
    ADD CONSTRAINT fk_countryTeam_continent FOREIGN KEY (idContinent) REFERENCES Continent(idContinent);

-- FK Team-CountryTeam
ALTER TABLE Team
    ADD CONSTRAINT fk_team_countryTeam FOREIGN KEY (idCountryTeam) REFERENCES CountryTeam(idCountryTeam);

-- FK Team-GroupEvent
ALTER TABLE Team 
    ADD CONSTRAINT fk_team_group FOREIGN KEY (idGroupEvent) REFERENCES GroupEvent(idGroupEvent);

-- FK GroupStats-Team
ALTER TABLE GroupStats 
    ADD CONSTRAINT fk_groupStats_team FOREIGN KEY (idTeam) REFERENCES Team(idTeam);

-- FK SoccerMatchXStadium-SoccerMatch
ALTER TABLE SoccerMatchXStadium
    ADD CONSTRAINT fk_soccerMatchXStadium_soccerMatch FOREIGN KEY (idSoccerMatch) REFERENCES SoccerMatch(idSoccerMatch);

-- FK SoccerMatchXStadium-Stadium
ALTER TABLE SoccerMatchXStadium
    ADD CONSTRAINT fk_soccerMatchXStadium_stadium FOREIGN KEY (idStadium) REFERENCES Stadium(idStadium);

 -- ////////////////////////////////////// SEQUENCES ////////////////////////////////////    

-- Gender
CREATE SEQUENCE s_gender
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- TypeIdentification
CREATE SEQUENCE s_typeIdentification
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Calendar
CREATE SEQUENCE s_calendar
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Continent
CREATE SEQUENCE s_continent
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Event
CREATE SEQUENCE s_event
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- GroupEvent
CREATE SEQUENCE s_groupEvent
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- CountryTeam
CREATE SEQUENCE s_countryTeam
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Team
CREATE SEQUENCE s_team
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- GroupStats
CREATE SEQUENCE s_groupStats
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- SoccerMatchXStadium
CREATE SEQUENCE s_soccerMatch_stadium
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;