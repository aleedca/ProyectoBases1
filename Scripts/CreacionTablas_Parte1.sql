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

-- TypeIdentification
CREATE TABLE TypeIdentification(
    idTypeIdentification NUMBER(10) PRIMARY KEY,
    mask VARCHAR(16) CONSTRAINT typeIdentification_mask_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Calendar
CREATE TABLE Calendar(
    idCalendar NUMBER(10) PRIMARY KEY,
    descriptionCalendar VARCHAR(32) CONSTRAINT calendar_description_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- Continent
CREATE TABLE Continent(
    idContinent NUMBER(10) PRIMARY KEY,
    nameContinent VARCHAR(32) CONSTRAINT continent_name_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

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

-- CountryTeam
CREATE TABLE CountryTeam(
    idCountryTeam NUMBER(10) PRIMARY KEY,
    idContinent NUMBER(10) CONSTRAINT countryTeam_idContinent_nn NOT NULL,
    nameCountryTeam VARCHAR(32) CONSTRAINT countryTeam_name_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE

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

CREATE TABLE SoccerMatchXStadium(
    idSoccerMatchXStadium NUMBER(10) PRIMARY KEY,
    idSoccerMatch NUMBER(10) CONSTRAINT soccerMatchXStadium_idSoccerMatch_nn NOT NULL,
    idStadium NUMBER(10) CONSTRAINT soccerMatchXStadium_idStadium_nn NOT NULL,
    userCreation VARCHAR(16),
    lastUser VARCHAR(16),
    lastDate DATE,
    dateCreation DATE
);

-- ////////////////////////////////////// FOREING KEYS PARTE 1////////////////////////////////////
-- FK Event-Calendar
ALTER TABLE Event
    ADD CONSTRAINT fk_event_calendar FOREIGN KEY (idCalendar) REFERENCES Calendar(idCalendar);

-- FK Group-Event
ALTER TABLE GroupEvent
    ADD CONSTRAINT fk_group_event FOREIGN KEY (idEvent) REFERENCES Event(idEvent);

-- FK CountryTeam-Continent
ALTER TABLE CountryTeam
    ADD CONSTRAINT fk_countryTeam_continent FOREIGN KEY (idContinent) REFERENCES Continent(idContinent);

-- FK Team-CountryTeam
ALTER TABLE Team
    ADD CONSTRAINT fk_team_countryTeam FOREIGN KEY (idCountryTeam) REFERENCES CountryTeam(idCountryTeam);

-- FK Team-Group
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