/* File Name: Triggers
Description: This file contains the triggers for each table created.
Authors:
Isaac Araya Solano - 2018151703
Alexia Cerdas Aguilar - 2019026961
Nahomi Bolanos Valverde - 2022089165
Mariana Fernandez Martinez - 2021104026
*/
-- Permission
GRANT CREATE ANY TRIGGER TO proyectoBD;

-- Gender
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertGender
BEFORE INSERT
ON proyectoBD.Gender
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertGender;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateGender
BEFORE UPDATE
ON proyectoBD.Gender
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateGender;

-- TypeIdentification
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertTypeIdentification
BEFORE INSERT
ON proyectoBD.TypeIdentification
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertTypeIdentification;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateTypeIdentification
BEFORE UPDATE
ON proyectoBD.TypeIdentification
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateTypeIdentification;

-- Continent
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertContinent
BEFORE INSERT
ON proyectoBD.Continent
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertContinent;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateContinent
BEFORE UPDATE
ON proyectoBD.Continent
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateContinent;

-- Event
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertEvent
BEFORE INSERT
ON proyectoBD.Event
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertEvent;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateEvent
BEFORE UPDATE
ON proyectoBD.Event
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateEvent;

-- GroupEvent
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertGroupEvent
BEFORE INSERT
ON proyectoBD.GroupEvent
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertGroupEvent;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateGroupEvent
BEFORE UPDATE
ON proyectoBD.GroupEvent
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateGroupEvent;

-- CountryTeam
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertCountryTeam
BEFORE INSERT
ON proyectoBD.CountryTeam
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertCountryTeam;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateCountryTeam
BEFORE UPDATE
ON proyectoBD.CountryTeam
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateCountryTeam;

-- Team
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertTeam
BEFORE INSERT
ON proyectoBD.Team
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertTeam;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateTeam
BEFORE UPDATE
ON proyectoBD.Team
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateTeam;

-- GroupStats
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertGroupStats
BEFORE INSERT
ON proyectoBD.GroupStats
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertGroupStats;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateGroupStats
BEFORE UPDATE
ON proyectoBD.GroupStats
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateGroupStats;

-- Country
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertCountry
BEFORE INSERT
ON proyectoBD.Country
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertCountry;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateCountry
BEFORE UPDATE
ON proyectoBD.Country
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateCountry;

-- Stadium
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertStadium
BEFORE INSERT
ON proyectoBD.Stadium
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertStadium;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateStadium
BEFORE UPDATE
ON proyectoBD.Stadium
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateStadium;

-- Province
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertProvince
BEFORE INSERT
ON proyectoBD.Province
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertProvince;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateProvince
BEFORE UPDATE
ON proyectoBD.Province
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateProvince;

-- Canton
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertCanton
BEFORE INSERT
ON proyectoBD.Canton
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertCanton;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateCanton
BEFORE UPDATE
ON proyectoBD.Canton
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateCanton;

-- District
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertDistrict
BEFORE INSERT
ON proyectoBD.District
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertDistrict;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateDistrict
BEFORE UPDATE
ON proyectoBD.District
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateDistrict;

-- Address
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertAddress
BEFORE INSERT
ON proyectoBD.Address
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertAddress;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateAddress
BEFORE UPDATE
ON proyectoBD.Address
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateAddress;

----------------------------------------------------------------------------------------
-- Mail
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertMail
BEFORE INSERT
ON proyectoBD.Mail
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertMail;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateMail
BEFORE UPDATE
ON proyectoBD.Mail
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateMail;

-- Phone
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertPhone
BEFORE INSERT
ON proyectoBD.Phone
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertPhone;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdatePhone
BEFORE UPDATE
ON proyectoBD.Phone
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdatePhone;

-- PersonXPhone
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertPersonXPhone
BEFORE INSERT
ON proyectoBD.PersonXPhone
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertPersonXPhone;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdatePersonXPhone
BEFORE UPDATE
ON proyectoBD.PersonXPhone
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdatePersonXPhone;

-- PlayerXSoccerMatchXTeam
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertPlayerXMatchXTeam
BEFORE INSERT
ON proyectoBD.PlayerXSoccerMatchXTeam
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertPlayerXMatchXTeam;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdatePlayerXMatchXTeam
BEFORE UPDATE
ON proyectoBD.PlayerXSoccerMatchXTeam
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdatePlayerXMatchXTeam;

-- News
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertNews
BEFORE INSERT
ON proyectoBD.News
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertNews;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateNews
BEFORE UPDATE
ON proyectoBD.News
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateNews;

-- NewsChange
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertNewsChange
BEFORE INSERT
ON proyectoBD.NewsChange
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertNewsChange;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateNewsChange
BEFORE UPDATE
ON proyectoBD.NewsChange
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateNewsChange;

-- NewsStatus
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertNewsStatus
BEFORE INSERT
ON proyectoBD.NewsStatus
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertNewsStatus;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateNewsStatus
BEFORE UPDATE
ON proyectoBD.NewsStatus
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateNewsStatus;

-- NewsType
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertNewsType
BEFORE INSERT
ON proyectoBD.NewsType
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertNewsType;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateNewsType
BEFORE UPDATE
ON proyectoBD.NewsType
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateNewsType;

-- Rating
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertRating
BEFORE INSERT
ON proyectoBD.Rating
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertRating;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateRating
BEFORE UPDATE
ON proyectoBD.Rating
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateRating;

-- FavoriteNews
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertFavoriteNews
BEFORE INSERT
ON proyectoBD.FavoriteNews
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertFavoriteNews;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateFavoriteNews
BEFORE UPDATE
ON proyectoBD.FavoriteNews
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateFavoriteNews;

-- NewsComment
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertNewsComment
BEFORE INSERT
ON proyectoBD.NewsComment
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertNewsComment;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateNewsComment
BEFORE UPDATE
ON proyectoBD.NewsComment
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateNewsComment;

-- SoccerMatch
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertSoccerMatch
BEFORE INSERT
ON proyectoBD.SoccerMatch
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertSoccerMatch;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateSoccerMatch
BEFORE UPDATE
ON proyectoBD.SoccerMatch
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateSoccerMatch;

--Person
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertPerson
BEFORE INSERT
ON proyectoBD.Person
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertPerson;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdatePerson
BEFORE UPDATE
ON proyectoBD.Person
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdatePerson;

--Player
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertPlayer
BEFORE INSERT
ON proyectoBD.Player
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertPlayer;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdatePlayer
BEFORE UPDATE
ON proyectoBD.Player
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdatePlayer;

--TeamWorker
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertTeamWorker
BEFORE INSERT
ON proyectoBD.TeamWorker
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertTeamWorker;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateTeamWorker
BEFORE UPDATE
ON proyectoBD.TeamWorker
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateTeamWorker;

--UserType
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertUserType
BEFORE INSERT
ON proyectoBD.UserType
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertUserType;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateUserType
BEFORE UPDATE
ON proyectoBD.UserType
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateUserType;

--UserPerson
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertUserPerson
BEFORE INSERT
ON proyectoBD.UserPerson
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertUserPerson;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateUserPerson
BEFORE UPDATE
ON proyectoBD.UserPerson
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateUserPerson;

-- UserXNews
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertUserXNews
BEFORE INSERT
ON proyectoBD.UserXNews
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertUserXNews;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateUserXNews
BEFORE UPDATE
ON proyectoBD.UserXNews
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateUserXNews;

-- ParameterTable 
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertParameterTable
BEFORE INSERT
ON proyectoBD.ParameterTable
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertParameterTable;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateParameterTable
BEFORE UPDATE
ON proyectoBD.ParameterTable
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateParameterTable;

-- PersonPosition 
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertPersonPosition
BEFORE INSERT
ON proyectoBD.PersonPosition
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertPersonPosition;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdatePersonPosition
BEFORE UPDATE
ON proyectoBD.PersonPosition
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdatePersonPosition;

-- Blog
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertBlog
BEFORE INSERT
ON proyectoBD.Blog
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertBlog;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateBlog
BEFORE UPDATE
ON proyectoBD.Blog
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateBlog;

-- TeamXGroup
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertTeamXGroup
BEFORE INSERT
ON proyectoBD.TeamXGroup
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertTeamXGroup;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateTeamXGroup
BEFORE UPDATE
ON proyectoBD.TeamXGroup
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateTeamXGroup;