-- ////////////////////////////////////// CREACION TABLAS PARTE 1////////////////////////////////////
-- Gender
CREATE TABLE Gender(
    idGender NUMBER(10) PRIMARY KEY,
    descriptionGender VARCHAR(16) CONSTRAINT gender_description_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT gender_user_nn,
    lastUser VARCHAR(16) CONSTRAINT gender_lastUser_nn,
    lastDate DATE CONSTRAINT gender_lastDate_nn,
    dateCreation DATE CONSTRAINT gender_dateCreation_nn
);

-- TypeIdentification
CREATE TABLE TypeIdentification(
    idTypeIdentification NUMBER(10) PRIMARY KEY,
    mask VARCHAR(16) CONSTRAINT typeIdentification_mask_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT typeIdentification_user_nn,
    lastUser VARCHAR(16) CONSTRAINT typeIdentification_lastUser_nn,
    lastDate DATE CONSTRAINT typeIdentification_lastDate_nn,
    dateCreation DATE CONSTRAINT typeIdentification_dateCreation_nn
);

-- Calendar
CREATE TABLE Calendar(
    idCalendar NUMBER(10) PRIMARY KEY,
    descriptionCalendar VARCHAR(16) CONSTRAINT calendar_description_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT calendar_user_nn,
    lastUser VARCHAR(16) CONSTRAINT calendar_lastUser_nn,
    lastDate DATE CONSTRAINT calendar_lastDate_nn,
    dateCreation DATE CONSTRAINT calendar_dateCreation_nn
);

-- Continent
CREATE TABLE Continent(
    idContinent NUMBER(10) PRIMARY KEY,
    nameContinent VARCHAR(16) CONSTRAINT continent_name_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT continent_user_nn,
    lastUser VARCHAR(16) CONSTRAINT continent_lastUser_nn,
    lastDate DATE CONSTRAINT continent_lastDate_nn,
    dateCreation DATE CONSTRAINT continent_dateCreation_nn
);

-- Event
CREATE TABLE Event(
    idEvent NUMBER(10) PRIMARY KEY,
    idCalendar NUMBER(10) CONSTRAINT event_idCalendar_nn NOT NULL,
    typeEvent VARCHAR(16) CONSTRAINT event_typeEvent_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT event_user_nn,
    lastUser VARCHAR(16) CONSTRAINT event_lastUser_nn,
    lastDate DATE CONSTRAINT event_lastDate_nn,
    dateCreation DATE CONSTRAINT event_dateCreation_nn
);

-- Group
CREATE TABLE GroupEvent(
    idGroupEvent NUMBER(10) PRIMARY KEY,
    idEvent NUMBER(10) CONSTRAINT groupEvent_idEvent_nn NOT NULL,
    descriptionGroupEvent VARCHAR(16) CONSTRAINT groupEvent_description_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT groupEvent_user_nn,
    lastUser VARCHAR(16) CONSTRAINT groupEvent_lastUser_nn,
    lastDate DATE CONSTRAINT groupEvent_lastDate_nn,
    dateCreation DATE CONSTRAINT groupEvent_dateCreation_nn
);

-- CountryTeam
CREATE TABLE CountryTeam(
    idCountryTeam NUMBER(10) PRIMARY KEY,
    idContinent NUMBER(10) CONSTRAINT countryTeam_idContinent_nn NOT NULL,
    nameCountryTeam VARCHAR(16) CONSTRAINT countryTeam_name_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT countryTeam_user_nn,
    lastUser VARCHAR(16) CONSTRAINT countryTeam_lastUser_nn,
    lastDate DATE CONSTRAINT countryTeam_lastDate_nn,
    dateCreation DATE CONSTRAINT countryTeam_dateCreation_nn
);

-- Team
CREATE TABLE Team(
    idTeam NUMBER(10) PRIMARY KEY,
    idCountryTeam NUMBER(10) CONSTRAINT team_idCountryTeam_nn NOT NULL,
    idGroupEvent NUMBER(10) CONSTRAINT team_idGroupEvent_nn NOT NULL,
    nameTeam VARCHAR(16) CONSTRAINT team_name_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT team_user_nn,
    lastUser VARCHAR(16) CONSTRAINT team_lastUser_nn,
    lastDate DATE CONSTRAINT team_lastDate_nn,
    dateCreation DATE CONSTRAINT team_dateCreation_nn
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
    userCreation VARCHAR(16) CONSTRAINT groupStats_user_nn,
    lastUser VARCHAR(16) CONSTRAINT groupStats_lastUser_nn,
    lastDate DATE CONSTRAINT groupStats_lastDate_nn,
    dateCreation DATE CONSTRAINT groupStats_dateCreation_nn
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