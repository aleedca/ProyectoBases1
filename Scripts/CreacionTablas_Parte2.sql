-- ////////////////////////////////////// CREACION TABLAS PART 2////////////////////////////////////
-- Country
CREATE TABLE Country(
    idCountry NUMBER(10) PRIMARY KEY,
    nameCountry VARCHAR(32) CONSTRAINT country_name_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT country_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT country_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT country_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT country_dateCreation_nn NOT NULL
);

-- Stadium
CREATE TABLE Stadium(
    idStadium NUMBER(10) PRIMARY KEY,
    idCountry NUMBER(10) CONSTRAINT stadium_idCountry_nn NOT NULL, 
    nameStadium VARCHAR(32) CONSTRAINT stadium_name_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT stadium_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT stadium_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT stadium_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT stadium_dateCreation_nn NOT NULL
);

-- Province
CREATE TABLE Province(
    idProvince NUMBER(10) PRIMARY KEY,
    idCountry NUMBER(10) CONSTRAINT province_idCountry_nn NOT NULL, 
    nameProvince VARCHAR(32) CONSTRAINT province_name_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT province_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT province_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT province_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT province_dateCreation_nn NOT NULL
);

-- Canton
CREATE TABLE Canton(
    idCanton NUMBER(10) PRIMARY KEY,
    idProvince NUMBER(10) CONSTRAINT canton_idProvince_nn NOT NULL,
    nameCanton VARCHAR(32) CONSTRAINT canton_name_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT canton_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT canton_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT canton_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT canton_dateCreation_nn NOT NULL
);

-- District
CREATE TABLE District(
    idDistrict NUMBER(10) PRIMARY KEY,
    idCanton NUMBER(10) CONSTRAINT district_idCanton_nn NOT NULL,
    nameDistrict VARCHAR(32) CONSTRAINT district_name_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT district_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT district_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT district_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT district_dateCreation_nn NOT NULL
);

-- Address
CREATE TABLE Address(
    idAddress NUMBER(10) PRIMARY KEY,
    idDistrict NUMBER(10) CONSTRAINT address_idDistrict_nn NOT NULL, 
    descriptionAddress VARCHAR(32) CONSTRAINT address_description_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT address_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT address_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT address_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT address_dateCreation_nn NOT NULL
);

----------------------------------------------------------------------------------------------------
-- Mail
CREATE TABLE Mail(
    idMail NUMBER(10) PRIMARY KEY,
    idPerson NUMBER(10) CONSTRAINT mail_idPerson_nn NOT NULL,
    descriptionMail VARCHAR(32) CONSTRAINT mail_description_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT mail_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT mail_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT mail_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT mail_dateCreation_nn NOT NULL
);

-- Phone
CREATE TABLE Phone(
    idPhone NUMBER(10) PRIMARY KEY,
    phoneNumer NUMBER(8) CONSTRAINT phone_phoneNumber_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT phone_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT phone_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT phone_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT phone_dateCreation_nn NOT NULL
);

-- PersonXPhone
CREATE TABLE PersonXPhone(
    idPersonXPhone NUMBER(10) PRIMARY KEY,
    idPerson NUMBER(10) CONSTRAINT phone_idPerson_nn NOT NULL,
    idPhone NUMBER(10) CONSTRAINT phone_idPhone_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT phone_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT phone_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT phone_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT phone_dateCreation_nn NOT NULL
);

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
    userCreation VARCHAR(16) CONSTRAINT playerxsoccermatchxteam_userCreation_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT playerxsoccermatchxteam_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT playerxsoccermatchxteam_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT playerxsoccermatchxteam_dateCreation_nn NOT NULL
);

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

