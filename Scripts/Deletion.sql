/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Drop Tables
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

DROP TABLE PlayerXSoccerMatchXTeam;
DROP TABLE ParameterTable;

DROP TABLE Player;
DROP TABLE TeamWorker;
DROP TABLE PersonXPhone;

DROP TABLE NewsChange;
DROP TABLE Blog;
DROP TABLE FavoriteNews;
DROP TABLE Rating;
DROP TABLE UserXNews;
DROP TABLE NewsComment;
DROP TABLE News;
DROP TABLE NewsType;
DROP TABLE NewsStatus;

DROP TABLE UserPerson;
DROP TABLE UserType;

DROP TABLE TeamXGroup;

DROP TABLE Mail;
DROP TABLE Person;
DROP TABLE PersonPosition; 

DROP TABLE Phone;
DROP TABLE Gender;
DROP TABLE TypeIdentification;

DROP TABLE SoccerMatch;
DROP TABLE GroupStats;
DROP TABLE Team;
DROP TABLE CountryTeam;
DROP TABLE Continent;


DROP TABLE Address;
DROP TABLE District;
DROP TABLE Canton;
DROP TABLE Province;
DROP TABLE Stadium;
DROP TABLE Country;


DROP TABLE GroupEvent;
DROP TABLE Event;

/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Drop Sequence
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

DROP SEQUENCE s_address;
DROP SEQUENCE s_blog;
DROP SEQUENCE s_canton;
DROP SEQUENCE s_continent;
DROP SEQUENCE s_country;
DROP SEQUENCE s_countryTeam;
DROP SEQUENCE s_district;
DROP SEQUENCE s_event;
DROP SEQUENCE s_mail;
DROP SEQUENCE s_news;
DROP SEQUENCE s_gender;
DROP SEQUENCE s_parameter;
DROP SEQUENCE s_groupEvent;
DROP SEQUENCE s_groupStats;
DROP SEQUENCE s_newsChange;
DROP SEQUENCE s_newsStatus;
DROP SEQUENCE s_favoriteNews;
DROP SEQUENCE s_person;
DROP SEQUENCE s_province;
DROP SEQUENCE s_phone;
DROP SEQUENCE s_rating;
DROP SEQUENCE s_stadium;
DROP SEQUENCE s_team;
DROP SEQUENCE s_typeIdentification;
DROP SEQUENCE s_userType;
DROP SEQUENCE s_userxnews;
DROP SEQUENCE s_soccermatch;
DROP SEQUENCE s_personxphone;
DROP SEQUENCE s_newsType;
DROP SEQUENCE s_newsComment;
DROP SEQUENCE s_personPosition;
DROP SEQUENCE s_teamxgroup;
DROP SEQUENCE s_player_soccermatch_team;

/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Drop Procedures
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

DROP PROCEDURE getCanton;
DROP PROCEDURE getCountry;
DROP PROCEDURE getDistrict;
DROP PROCEDURE getGender;
DROP PROCEDURE getProvince;
DROP PROCEDURE getTypeIdentification;
DROP PROCEDURE getCountryTeam;
DROP PROCEDURE getTeamList;
DROP PROCEDURE getGroupList;

DROP PROCEDURE insertCountryTeam;
DROP PROCEDURE insertTeam;
DROP PROCEDURE insertGroupEvent;
DROP PROCEDURE insertGroupStats;
DROP PROCEDURE insertEvent;

DROP PROCEDURE insertAddress;
DROP PROCEDURE insertCanton;
DROP PROCEDURE insertContinent;
DROP PROCEDURE insertCountry;
DROP PROCEDURE insertDistrict;
DROP PROCEDURE insertGender;
DROP PROCEDURE insertMail;
DROP PROCEDURE insertNewsStatus;
DROP PROCEDURE insertNewsType;

DROP PROCEDURE insertPlayer;
DROP PROCEDURE insertTeamWorker;
DROP PROCEDURE insertPersonPosition;
DROP PROCEDURE insertPersonXPhone;
DROP PROCEDURE insertPhone;
DROP PROCEDURE insertProvince;
DROP PROCEDURE insertStadium;
DROP PROCEDURE insertTypeIdentification;
DROP PROCEDURE insertUserType;
DROP PROCEDURE insertUserPerson;
DROP PROCEDURE insertPerson;

DROP PROCEDURE insertSoccerMatch;
DROP PROCEDURE insertTeam1;
DROP PROCEDURE insertTeam2;
DROP PROCEDURE insertPlayerXMatchXTeam;

DROP PROCEDURE insertFavoriteNews;
DROP PROCEDURE insertNewsComment;
DROP PROCEDURE insertRating;
DROP PROCEDURE insertUserxNews;
DROP PROCEDURE insertNews;
DROP PROCEDURE insertNewsChange;
DROP PROCEDURE insertParameterTable;

DROP PROCEDURE decryptionPassword;
DROP PROCEDURE encryptionPassword;

DROP PROCEDURE getAccountInformation;
DROP PROCEDURE getEvent;
DROP PROCEDURE getGroupEvent;
DROP PROCEDURE getGroupStats;
DROP PROCEDURE getInfoNews;

DROP PROCEDURE getLastNews;
DROP PROCEDURE getMostViewedNews;
DROP PROCEDURE getNews;
DROP PROCEDURE getNewsStatus;
DROP PROCEDURE getNewsType;
DROP PROCEDURE getPersonInformation;
DROP PROCEDURE getPlayer;
DROP PROCEDURE getPosition;
DROP PROCEDURE getStadium;
DROP PROCEDURE getTeam;
DROP PROCEDURE getTeamWorker;
DROP PROCEDURE getTeamXGroup;

DROP PROCEDURE updateAddress;
DROP PROCEDURE updateBirthdate;
DROP PROCEDURE updateCanton;
DROP PROCEDURE updateCountry;
DROP PROCEDURE updateDistrict;
DROP PROCEDURE updateFirstName;
DROP PROCEDURE updateFirstLastName;
DROP PROCEDURE updateGender;
DROP PROCEDURE updateIdentification;
DROP PROCEDURE updateMail;
DROP PROCEDURE updatePersonPosition;
DROP PROCEDURE updatePhone;
DROP PROCEDURE updateProvince;
DROP PROCEDURE updateSecondLastName;
DROP PROCEDURE updateSecondName;
DROP PROCEDURE updatePhoto;
DROP PROCEDURE updateStatus;
DROP PROCEDURE updateTeam;
DROP PROCEDURE updateText;
DROP PROCEDURE updateTitle;
DROP PROCEDURE updateTShirtNum;
DROP PROCEDURE updateType;
DROP PROCEDURE updateTypeIdentification;

DROP PROCEDURE validateGroupExist;
DROP PROCEDURE validateTeamExist;
DROP PROCEDURE validateIdentAlreadyExists;
DROP PROCEDURE validateIdentification;
DROP PROCEDURE validateSoccerMatchExist;
DROP PROCEDURE validateUser;
DROP PROCEDURE validateUserAlreadyExists;

/*
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Delete info from Tables
-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
*/

DELETE FROM NewsComment;
DELETE FROM FavoriteNews;
DELETE FROM UserXNews;
DELETE FROM Rating;
DELETE FROM NewsStatus;
DELETE FROM News;

DELETE FROM TeamWorker;
DELETE FROM PlayerXSoccerMatchXTeam;
DELETE FROM GroupStats;
DELETE FROM SoccerMatch;
DELETE FROM Player;
DELETE FROM PersonXPhone;
DELETE FROM UserPerson;
DELETE FROM Phone;
DELETE FROM Mail;

DELETE FROM Continent;
DELETE FROM UserType;
DELETE FROM NewsType;


DELETE FROM PersonPosition;
DELETE FROM TypeIdentification;
DELETE FROM Gender;
DELETE FROM Stadium;

DELETE FROM Team;
DELETE FROM CountryTeam;
DELETE FROM GroupEvent;
DELETE FROM Event;

DELETE FROM Person;
DELETE FROM Address;
DELETE FROM District;
DELETE FROM Canton;
DELETE FROM Province;
DELETE FROM Country;
