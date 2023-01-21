/* File Name: TableCreation
Description: This file contains the creation of the tables, sequences and foreing keys
Authors:
Isaac Araya Solano - 2018151703
Alexia Cerdas Aguilar - 2019026961
Nahomi Bolanos Valverde - 2022089165
Mariana Fernandez Martinez - 2021104026
*/

-- ////////////////////////////////////// TABLE CREATION ////////////////////////////////////
-- ParameterTable        
CREATE TABLE ParameterTable (
   idParameterTable NUMBER(10) PRIMARY KEY,
   nameParameter VARCHAR2(32) CONSTRAINT parameter_name_nn NOT NULL,
   valueParameter NUMBER(10) CONSTRAINT parameter_value_nn NOT NULL,
   userCreation VARCHAR2(16),
   lastUser VARCHAR2(16),
   lastDate DATE,
   dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE ParameterTable
IS 'Repository for storing the information of a ParameterTable.';
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

-- Parameter Sequence
CREATE SEQUENCE s_parameter
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------  
--Person
CREATE TABLE Person (
   idPerson NUMBER(10) PRIMARY KEY,
   identification NUMBER(9)CONSTRAINT person_identification_nn NOT NULL,
   firstName VARCHAR2(32) CONSTRAINT person_firstname_nn NOT NULL,
   secondName VARCHAR2(32),
   firstLastName VARCHAR2(32) CONSTRAINT person_fstlastname_nn NOT NULL,
   secondLastName VARCHAR2(32),
   photo VARCHAR2(128) CONSTRAINT person_photo_nn NOT NULL,
   idPersonPosition NUMBER(10) CONSTRAINT person_idpersonposition_nn NOT NULL,
   idAddress NUMBER(10) CONSTRAINT person_idaddress_nn NOT NULL,
   idTypeIdentification NUMBER(10) CONSTRAINT person_idtypeident_nn NOT NULL,
   idGender NUMBER(10) CONSTRAINT person_idgender_nn NOT NULL,
   userCreation VARCHAR2(16),
   lastUser VARCHAR2(16),
   lastDate DATE,
   dateCreation DATE
);

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

COMMENT ON COLUMN Person.idPersonPosition
IS 'Reference to the PersonPosition Table.';

COMMENT ON COLUMN Person.idAddress
IS 'Reference to the Address Table.';

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

-- Person Sequence
CREATE SEQUENCE s_person
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------    
-- Player
CREATE TABLE Player (
   idPerson NUMBER(10) PRIMARY KEY,
   idTeam NUMBER(10) CONSTRAINT player_idTeam_nn NOT NULL, 
   birthdate DATE CONSTRAINT player_birthdate_nn NOT NULL,
   tShirtNum NUMBER(3) CONSTRAINT player_tshirtnum_nn NOT NULL,
   userCreation VARCHAR2(16),
   lastUser VARCHAR2(16),
   lastDate DATE,
   dateCreation DATE
);

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

---------------------------------------------------------------------    
-- TeamWorker

CREATE TABLE TeamWorker (
   idPerson NUMBER(10) PRIMARY KEY,
   idTeam NUMBER(10) CONSTRAINT teamworker_idTeam_nn NOT NULL,
   userCreation VARCHAR2(16),
   lastUser VARCHAR2(16),
   lastDate DATE,
   dateCreation DATE
);

-- Table Comment
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

---------------------------------------------------------------------    

-- Country
CREATE TABLE Country(
    idCountry NUMBER(10) PRIMARY KEY,
    nameCountry VARCHAR2(32) CONSTRAINT country_nameCountry_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- Country Sequence
CREATE SEQUENCE s_country
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------    
-- Gender
CREATE TABLE Gender(
    idGender NUMBER(10) PRIMARY KEY,
    descriptionGender VARCHAR2(32) CONSTRAINT gender_descriptionGender_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- Gender Sequence
CREATE SEQUENCE s_gender
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

--------------------------------------------------------------------- 
-- TypeIdentification
CREATE TABLE TypeIdentification(
    idTypeIdentification NUMBER(10) PRIMARY KEY,
    nameTypeIdentification VARCHAR2(16) CONSTRAINT typeIdentification_name_nn NOT NULL,
    typeMask VARCHAR2(16) CONSTRAINT typeIdentification_typeMask_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE TypeIdentification
IS 'Repository for storing the information of type identification';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN TypeIdentification.idTypeIdentification
IS 'Unique identifier of the TypeIdentification Table.';

COMMENT ON COLUMN TypeIdentification.nameTypeIdentification
IS 'Name of the TypeIdentification.';

COMMENT ON COLUMN TypeIdentification.typeMask
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

-- TypeIdentification Sequence
CREATE SEQUENCE s_typeIdentification
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------    
-- PersonPosition    
CREATE TABLE PersonPosition (
   idPersonPosition NUMBER(10) PRIMARY KEY,
   descriptionPersonPosition VARCHAR2(32) CONSTRAINT personPosition_description_nn NOT NULL,
   userCreation VARCHAR2(16),
   lastUser VARCHAR2(16),
   lastDate DATE,
   dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE PersonPosition
IS 'Repository for storing the information of a PersonPosition.';
-- Comment on attributes
COMMENT ON COLUMN PersonPosition.idPersonPosition
IS 'Unique identifier of the PersonPosition Table.';

COMMENT ON COLUMN PersonPosition.descriptionPersonPosition
IS 'Description of the position a person has.';

--Audit Fields
COMMENT ON COLUMN PersonPosition.userCreation
IS 'User who creates the PersonPosition Table record.';

COMMENT ON COLUMN PersonPosition.lastUser
IS 'Last user to modify a record in the PersonPosition Table.';

COMMENT ON COLUMN PersonPosition.lastDate
IS 'Last modification date of the record in the PersonPosition Table.';

COMMENT ON COLUMN PersonPosition.dateCreation
IS 'Date of creation of the PersonPosition Table record.';

-- PersonPosition Sequence
CREATE SEQUENCE s_personPosition
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------    
-- Mail
CREATE TABLE Mail(
    idMail NUMBER(10) PRIMARY KEY,
    idPerson NUMBER(10) CONSTRAINT mail_idPerson_nn NOT NULL,
    descriptionMail VARCHAR2(32) CONSTRAINT mail_descriptionMail_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- Mail Sequence
CREATE SEQUENCE s_mail
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------    
-- Phone
CREATE TABLE Phone(
    idPhone NUMBER(10) PRIMARY KEY,
    phoneNumber NUMBER(8) CONSTRAINT phone_phoneNumber_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- Phone Sequence
CREATE SEQUENCE s_phone
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------
-- PersonXPhone
CREATE TABLE PersonXPhone(
    idPersonXPhone NUMBER(10) PRIMARY KEY,
    idPerson NUMBER(10) CONSTRAINT phone_idPerson_nn NOT NULL,
    idPhone NUMBER(10) CONSTRAINT phone_idPhone_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- PersonXPhone Sequence
CREATE SEQUENCE s_personxphone
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------    
-- UserType
CREATE TABLE UserType (
   idUserType NUMBER(10) PRIMARY KEY,
   descriptionUserType VARCHAR2(32) CONSTRAINT usertype_description_nn NOT NULL,
   userCreation VARCHAR2(16),
   lastUser VARCHAR2(16),
   lastDate DATE,
   dateCreation DATE
);

-- Table Comment
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

-- UserType Sequence
CREATE SEQUENCE s_usertype
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------    
-- UserPerson
CREATE TABLE UserPerson (
   username VARCHAR2(32) PRIMARY KEY,
   idUserType NUMBER(10) CONSTRAINT userperson_idusertype_nn NOT NULL,
   idPerson NUMBER(10) CONSTRAINT userperson_idperson_nn NOT NULL,
   passwordUser VARCHAR2(32) CONSTRAINT userperson_passworduser_nn NOT NULL,
   userCreation VARCHAR2(16),
   lastUser VARCHAR2(16),
   lastDate DATE,
   dateCreation DATE
);

COMMENT ON TABLE UserPerson
IS 'Repository for storing the information of a UserPerson.';
-- Comment on attributes
COMMENT ON COLUMN UserPerson.username
IS 'Unique identifier of the UserPerson Table.';

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
    
---------------------------------------------------------------------
-- NewsType
CREATE TABLE NewsType(
    idNewsType NUMBER(10) PRIMARY KEY,
    descriptionNewsType VARCHAR2(32) CONSTRAINT newsType_description_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE NewsType
IS 'Repository for storing the information of the News Type';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN NewsType.idNewsType
IS 'Unique identifier of the NewsType Table.';

COMMENT ON COLUMN NewsType.descriptionNewsType
IS 'Description of the NewsType';

-- Audit Fields 
COMMENT ON COLUMN NewsType.userCreation
IS 'User who creates the NewsType Table record.';

COMMENT ON COLUMN NewsType.dateCreation
IS 'Date of creation of the NewsType Table record.';

COMMENT ON COLUMN NewsType.lastUser
IS 'Last user to modify a record in the NewsType Table.';

COMMENT ON COLUMN NewsType.lastDate
IS 'Last modification date of the record in the NewsType Table.';

-- NewsType Sequence
CREATE SEQUENCE s_newsType
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-------------------------------------------------------------------------------------------
-- NewsStatus
CREATE TABLE NewsStatus(
    idNewsStatus NUMBER(10) PRIMARY KEY,
    descriptionNewsStatus VARCHAR2(32) CONSTRAINT newsStatus_description_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE NewsStatus
IS 'Repository for storing the information of the status';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN NewsStatus.idNewsStatus
IS 'Unique identifier of the NewsStatus Table.';

COMMENT ON COLUMN NewsStatus.descriptionNewsStatus
IS 'Description of the Status';

-- Audit Fields 
COMMENT ON COLUMN NewsStatus.userCreation
IS 'User who creates the NewsStatus Table record.';

COMMENT ON COLUMN NewsStatus.dateCreation
IS 'Date of creation of the NewsStatus Table record.';

COMMENT ON COLUMN NewsStatus.lastUser
IS 'Last user to modify a record in the NewsStatus Table.';

COMMENT ON COLUMN NewsStatus.lastDate
IS 'Last modification date of the record in the NewsStatus Table.';

-- Status Sequence
CREATE SEQUENCE s_newsStatus
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

--------------------------------------------------------------------- 
-- News
CREATE TABLE News(
    idNews NUMBER(10) PRIMARY KEY,
    idNewsStatus NUMBER(10) CONSTRAINT news_idNewsStatus_nn NOT NULL,
    idNewsType NUMBER(10) CONSTRAINT news_idNewsType_nn NOT NULL,
    title VARCHAR2(128) CONSTRAINT news_title_nn NOT NULL,
    publicationDate DATE,
    viewsNews NUMBER(32) CONSTRAINT news_viewsNews_nn NOT NULL,
    linkNews VARCHAR2(128) CONSTRAINT news_linkNews_nn NOT NULL,
    photo VARCHAR2(128) CONSTRAINT news_photo_nn NOT NULL,
    textNews VARCHAR2(1024) CONSTRAINT news_textNews_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE News
IS 'Repository for storing the information of the news';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN News.idNews
IS 'Unique identifier of the News Table.';

COMMENT ON COLUMN News.idNewsStatus
IS 'Reference to State Table.';

COMMENT ON COLUMN News.idNewsType
IS 'Reference to idNewsType Table.';

COMMENT ON COLUMN News.title
IS 'News title.';

COMMENT ON COLUMN News.publicationDate
IS 'Date of publication of each news.';

COMMENT ON COLUMN News.viewsNews
IS 'Views of each news.';

COMMENT ON COLUMN News.linkNews
IS 'Link of each news.';

COMMENT ON COLUMN News.photo
IS 'Photo of each news.';

COMMENT ON COLUMN News.textNews
IS 'Text of each news.';

-- Audit Fields 
COMMENT ON COLUMN News.userCreation
IS 'User who creates the News Table record.';

COMMENT ON COLUMN News.dateCreation
IS 'Date of creation of the News Table record.';

COMMENT ON COLUMN News.lastUser
IS 'Last user to modify a record in the News Table.';

COMMENT ON COLUMN News.lastDate
IS 'Last modification date of the record in the News Table.';

-- News Sequence
CREATE SEQUENCE s_news
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------
-- Blog
CREATE TABLE Blog(
    idBlog NUMBER(10) PRIMARY KEY,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Blog
IS 'Repository for storing the information of the blog';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Blog.idBlog 
IS 'Unique identifier of the Blog Table.';

-- Audit Fields 
COMMENT ON COLUMN Blog.userCreation
IS 'User who creates the Blog Table record.';

COMMENT ON COLUMN Blog.dateCreation
IS 'Date of creation of the Blog Table record.';

COMMENT ON COLUMN Blog.lastUser
IS 'Last user to modify a record in the Blog Table.';

COMMENT ON COLUMN Blog.lastDate
IS 'Last modification date of the record in the Blog Table.';

-- Blog Sequence
CREATE SEQUENCE s_blog
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

--------------------------------------------------------------------- 
-- NewsChange
CREATE TABLE NewsChange(
    idNewsChange NUMBER(10) PRIMARY KEY,
    idNews NUMBER(10) CONSTRAINT newschange_idNews_nn NOT NULL,
    idBlog NUMBER(10) CONSTRAINT newschange_idBlog_nn NOT NULL,
    username VARCHAR2(32) CONSTRAINT newschange_username_nn NOT NULL,
    currentText VARCHAR2(256) CONSTRAINT newschange_currentText_nn NOT NULL,
    previousText VARCHAR2(256) CONSTRAINT newschange_previousText_nn NOT NULL,
    descriptionNewsChange VARCHAR2(32) CONSTRAINT newschange_description_nn NOT NULL,
    dateHour DATE CONSTRAINT newschange_dateHour_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE NewsChange
IS 'Repository for storing the information of the change';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN NewsChange.idNewsChange
IS 'Unique identifier of the NewsChange Table.';

COMMENT ON COLUMN NewsChange.idNews
IS 'Reference to News Table.';

COMMENT ON COLUMN NewsChange.idBlog
IS 'Reference to Blog Table.';

COMMENT ON COLUMN NewsChange.username
IS 'Username that made the change.';

COMMENT ON COLUMN NewsChange.currentText
IS 'Text after the change.';

COMMENT ON COLUMN NewsChange.previousText
IS 'Text before the change.';

COMMENT ON COLUMN NewsChange.descriptionNewsChange
IS 'Description of the change.';

COMMENT ON COLUMN NewsChange.dateHour
IS 'Date and hour of the change.';

-- Audit Fields 
COMMENT ON COLUMN NewsChange.userCreation
IS 'User who creates the NewsChange Table record.';

COMMENT ON COLUMN NewsChange.dateCreation
IS 'Date of creation of the NewsChange Table record.';

COMMENT ON COLUMN NewsChange.lastUser
IS 'Last user to modify a record in the NewsChange Table.';

COMMENT ON COLUMN NewsChange.lastDate
IS 'Last modification date of the record in the NewsChange Table.';

-- NewsChange Sequence
CREATE SEQUENCE s_newsChange
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;
--------------------------------------------------------------------- 
-- UserXNews    
CREATE TABLE UserXNews (
   idUserXNews NUMBER(10) PRIMARY KEY,
   username VARCHAR2(32) CONSTRAINT userxnews_username_nn NOT NULL,
   idNews NUMBER(10) CONSTRAINT userxnews_idnews_nn NOT NULL,
   userCreation VARCHAR2(16),
   lastUser VARCHAR2(16),
   lastDate DATE,
   dateCreation DATE
);

-- Table Comment
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

-- UserXNews Sequence
CREATE SEQUENCE s_userxnews
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------    
-- Rating
CREATE TABLE Rating(
    idRating NUMBER(10) PRIMARY KEY,
    username VARCHAR2(32) CONSTRAINT rating_username_nn NOT NULL,
    idNews NUMBER(10) CONSTRAINT rating_idNews_nn NOT NULL,
    rating NUMBER(1) CONSTRAINT rating_rating_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Rating
IS 'Repository for storing the information of the Rating';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Rating.idRating
IS 'Unique identifier of the Rating Table.';

COMMENT ON COLUMN Rating.username
IS 'Reference to UserPerson Table.';

COMMENT ON COLUMN Rating.idNews
IS 'Reference to News Table.';

COMMENT ON COLUMN Rating.rating
IS 'Rating number.';

-- Audit Fields 
COMMENT ON COLUMN Rating.userCreation
IS 'User who creates the Rating Table record.';

COMMENT ON COLUMN Rating.dateCreation
IS 'Date of creation of the Rating Table record.';

COMMENT ON COLUMN Rating.lastUser
IS 'Last user to modify a record in the Rating Table.';

COMMENT ON COLUMN Rating.lastDate
IS 'Last modification date of the record in the Rating Table.';


-- Rating Sequence
CREATE SEQUENCE s_rating
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------    
-- NewsComment
CREATE TABLE NewsComment(
    idNewsComment NUMBER(10) PRIMARY KEY,
    username VARCHAR2(32) CONSTRAINT newscomment_username_nn NOT NULL,
    idNews NUMBER(10) CONSTRAINT newscomment_idNews_nn NOT NULL,
    textNewsComment VARCHAR2(128) CONSTRAINT newscomment_text_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE NewsComment
IS 'Repository for storing the information of the Comment';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN NewsComment.idNewsComment
IS 'Unique identifier of the NewsComment Table.';

COMMENT ON COLUMN NewsComment.username
IS 'Reference to UserPerson Table.';

COMMENT ON COLUMN NewsComment.idNews
IS 'Reference to News Table.';

COMMENT ON COLUMN NewsComment.textNewsComment
IS 'Text of each comment';

-- Audit Fields 
COMMENT ON COLUMN NewsComment.userCreation
IS 'User who creates the NewsComment Table record.';

COMMENT ON COLUMN NewsComment.dateCreation
IS 'Date of creation of the NewsComment Table record.';

COMMENT ON COLUMN NewsComment.lastUser
IS 'Last user to modify a record in the NewsComment Table.';

COMMENT ON COLUMN NewsComment.lastDate
IS 'Last modification date of the record in the NewsComment Table.';

-- NewsComment Sequence
CREATE SEQUENCE s_newsComment
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------
-- FavoriteNews
CREATE TABLE FavoriteNews(
    idFavoriteNews NUMBER(10) PRIMARY KEY,
    username VARCHAR2(32) CONSTRAINT favoriteNews_username_nn NOT NULL,
    idNews NUMBER(10) CONSTRAINT favoriteNews_idNews_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE FavoriteNews
IS 'Repository for storing the information of the FavoriteNews';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN FavoriteNews.idFavoriteNews
IS 'Unique identifier of the FavoriteNews Table.';

COMMENT ON COLUMN FavoriteNews.username
IS 'Reference to UserPerson Table.';

COMMENT ON COLUMN FavoriteNews.idNews
IS 'Reference to News Table.';

-- Audit Fields 
COMMENT ON COLUMN FavoriteNews.userCreation
IS 'User who creates the FavoriteNews Table record.';

COMMENT ON COLUMN FavoriteNews.dateCreation
IS 'Date of creation of the FavoriteNews Table record.';

COMMENT ON COLUMN FavoriteNews.lastUser
IS 'Last user to modify a record in the FavoriteNews Table.';

COMMENT ON COLUMN FavoriteNews.lastDate
IS 'Last modification date of the record in the FavoriteNews Table.';

-- FavoriteNews Sequence
CREATE SEQUENCE s_favoriteNews
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------
-- Stadium
CREATE TABLE Stadium(
    idStadium NUMBER(10) PRIMARY KEY,
    idAddress NUMBER(10) CONSTRAINT stadium_idAddress_nn NOT NULL, 
    nameStadium VARCHAR2(32) CONSTRAINT stadium_name_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Stadium
IS 'Repository to store the information of the stadiums of the event.';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Stadium.idStadium
IS 'Unique identifier of the Stadium Table.';

COMMENT ON COLUMN Stadium.idAddress
IS 'Reference to Address Table';

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

-- Stadium Sequence
CREATE SEQUENCE s_stadium
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------
-- Province
CREATE TABLE Province(
    idProvince NUMBER(10) PRIMARY KEY,
    idCountry NUMBER(10) CONSTRAINT province_idCountry_nn NOT NULL, 
    nameProvince VARCHAR2(32) CONSTRAINT province_name_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- Province Sequence
CREATE SEQUENCE s_province
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------
-- Canton
CREATE TABLE Canton(
    idCanton NUMBER(10) PRIMARY KEY,
    idProvince NUMBER(10) CONSTRAINT canton_idProvince_nn NOT NULL,
    nameCanton VARCHAR2(32) CONSTRAINT canton_name_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- Canton Sequence
CREATE SEQUENCE s_canton
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------
-- District
CREATE TABLE District(
    idDistrict NUMBER(10) PRIMARY KEY,
    idCanton NUMBER(10) CONSTRAINT district_idCanton_nn NOT NULL,
    nameDistrict VARCHAR2(32) CONSTRAINT district_name_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- District Sequence
CREATE SEQUENCE s_district
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------
-- Address
CREATE TABLE Address(
    idAddress NUMBER(10) PRIMARY KEY,
    idDistrict NUMBER(10) CONSTRAINT address_idDistrict_nn NOT NULL, 
    descriptionAddress VARCHAR2(256) CONSTRAINT address_description_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- Address Sequence
CREATE SEQUENCE s_address
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------
-- SoccerMatch
CREATE TABLE SoccerMatch(
    idSoccerMatch NUMBER(10) PRIMARY KEY,
    idStadium NUMBER(10) CONSTRAINT soccermatch_idStadium_nn NOT NULL,
    dateHour DATE CONSTRAINT soccermatch_dateHour_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE SoccerMatch
IS 'Repository for storing the information of the SoccerMatch';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN SoccerMatch.idSoccerMatch
IS 'Unique identifier of the SoccerMatch Table.';

COMMENT ON COLUMN SoccerMatch.idStadium
IS 'Reference to Stadium Table.';

COMMENT ON COLUMN SoccerMatch.dateHour
IS 'Date and hour of the Soccer Match.';

-- Audit Fields 
COMMENT ON COLUMN SoccerMatch.userCreation
IS 'User who creates the SoccerMatch Table record.';

COMMENT ON COLUMN SoccerMatch.dateCreation
IS 'Date of creation of the SoccerMatch Table record.';

COMMENT ON COLUMN SoccerMatch.lastUser
IS 'Last user to modify a record in the SoccerMatch Table.';

COMMENT ON COLUMN SoccerMatch.lastDate
IS 'Last modification date of the record in the SoccerMatch Table.';

-- SoccerMatch Sequence
CREATE SEQUENCE s_soccerMatch
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

---------------------------------------------------------------------
-- PlayerXSoccerMatchXTeam
CREATE TABLE PlayerXSoccerMatchXTeam(
    idPlayerXMatchXTeam NUMBER(10) PRIMARY KEY,
    idPerson NUMBER(10) CONSTRAINT pxsmxt_idPerson_nn NOT NULL, 
    idSoccerMatch NUMBER(10) CONSTRAINT pxsmxt_idSoccerMatch_nn NOT NULL, 
    idTeam NUMBER(10) CONSTRAINT pxsmxt_idTeam_nn NOT NULL, 
    yellowCards NUMBER(1) CONSTRAINT pxsmxt_yellowCards_nn NOT NULL,
    redCards NUMBER(1) CONSTRAINT pxsmxt_redCards_nn NOT NULL,
    offsides NUMBER(2) CONSTRAINT pxsmxt_offsides_nn NOT NULL,
    corners NUMBER(2) CONSTRAINT pxsmxt_corners_nn NOT NULL,
    goals NUMBER(2) CONSTRAINT pxsmxt_goals_nn NOT NULL,
    saves NUMBER(2) CONSTRAINT pxsmxt_saves_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- PlayerXSoccerMatchXTeam Sequence
CREATE SEQUENCE s_player_soccerMatch_team
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-------------------------------------------------------------------------------------------
-- Event
CREATE TABLE Event(
    idEvent NUMBER(10) PRIMARY KEY,
    typeEvent VARCHAR2(32) CONSTRAINT event_typeEvent_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE Event
IS 'Repository for storing the information of the event';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Event.idEvent
IS 'Unique identifier of the Event Table.';

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

-- Event Sequence
CREATE SEQUENCE s_event
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

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
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- GroupStats Sequence
CREATE SEQUENCE s_groupStats
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-------------------------------------------------------------------------------------------
-- Team
CREATE TABLE Team(
    idTeam NUMBER(10) PRIMARY KEY,
    idCountryTeam NUMBER(10) CONSTRAINT team_idCountryTeam_nn NOT NULL,
    nameTeam VARCHAR2(32) CONSTRAINT team_name_nn NOT NULL,
    flag VARCHAR2(128) CONSTRAINT team_flag_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

COMMENT ON COLUMN Team.nameTeam
IS 'Name of the team.';

COMMENT ON COLUMN Team.flag
IS 'Photo of the flag of the team.';

-- Audit Fields 
COMMENT ON COLUMN Team.userCreation
IS 'User who creates the Team Table record.';

COMMENT ON COLUMN Team.dateCreation
IS 'Date of creation of the Team Table record.';

COMMENT ON COLUMN Team.lastUser
IS 'Last user to modify a record in the Team Table.';

COMMENT ON COLUMN Team.lastDate
IS 'Last modification date of the record in the Team Table.';

-- Team Sequence
CREATE SEQUENCE s_team
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-------------------------------------------------------------------------------------------
-- GroupEvent
CREATE TABLE GroupEvent(
    idGroupEvent NUMBER(10) PRIMARY KEY,
    idEvent NUMBER(10) CONSTRAINT groupEvent_idEvent_nn NOT NULL,
    descriptionGroupEvent VARCHAR2(32) CONSTRAINT groupEvent_description_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- GroupEvent Sequence
CREATE SEQUENCE s_groupEvent
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-------------------------------------------------------------------------------------------
-- TeamXGroup
CREATE TABLE TeamXGroup(
    idTeamXGroup NUMBER(10) PRIMARY KEY,
    idTeam NUMBER(10),
    idGroupEvent NUMBER(10),
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
    lastDate DATE,
    dateCreation DATE
);

-- Table Comment
COMMENT ON TABLE TeamXGroup
IS 'Repository for storing the relation between team and group.';

--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN TeamXGroup.idTeamXGroup
IS 'Unique identifier of the Team Table.';

COMMENT ON COLUMN TeamXGroup.idTeam
IS 'Reference to Team Table.';

COMMENT ON COLUMN TeamXGroup.idGroupEvent
IS 'Reference to GroupEvent Table.';

-- Audit Fields 
COMMENT ON COLUMN TeamXGroup.userCreation
IS 'User who creates the Team Table record.';

COMMENT ON COLUMN TeamXGroup.dateCreation
IS 'Date of creation of the Team Table record.';

COMMENT ON COLUMN TeamXGroup.lastUser
IS 'Last user to modify a record in the Team Table.';

COMMENT ON COLUMN TeamXGroup.lastDate
IS 'Last modification date of the record in the Team Table.';

-- Team Sequence
CREATE SEQUENCE s_teamxgroup
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;



-------------------------------------------------------------------------------------------
-- CountryTeam
CREATE TABLE CountryTeam(
    idCountryTeam NUMBER(10) PRIMARY KEY,
    idContinent NUMBER(10) CONSTRAINT countryTeam_idContinent_nn NOT NULL,
    nameCountryTeam VARCHAR2(32) CONSTRAINT countryTeam_name_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- CountryTeam Sequence
CREATE SEQUENCE s_countryTeam
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-------------------------------------------------------------------------------------------
-- Continent
CREATE TABLE Continent(
    idContinent NUMBER(10) PRIMARY KEY,
    nameContinent VARCHAR2(32) CONSTRAINT continent_name_nn NOT NULL,
    userCreation VARCHAR2(16),
    lastUser VARCHAR2(16),
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

-- Continent Sequence
CREATE SEQUENCE s_continent
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;
----------------------------------------------------------------------------------------------------

-- ////////////////////////////////////// FOREING KEYS ////////////////////////////////////
--Person foreing keys
ALTER TABLE Person
    ADD CONSTRAINT fk_person_personposition FOREIGN KEY (idPersonPosition) REFERENCES PersonPosition(idPersonPosition);
    
ALTER TABLE Person
    ADD CONSTRAINT fk_person_address FOREIGN KEY (idAddress) REFERENCES Address(idAddress);

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

  
-----------------------------------------------------------------------------------
-- FK Mail-Person
ALTER TABLE Mail
    ADD CONSTRAINT fk_mail_person FOREIGN KEY (idPerson) REFERENCES Person(idPerson);

-- FK PersonXPhone-Person
ALTER TABLE PersonXPhone
    ADD CONSTRAINT fk_personxphone_person FOREIGN KEY (idPerson) REFERENCES Person(idPerson);

-- FK PersonXPhone-Phone
ALTER TABLE PersonXPhone
    ADD CONSTRAINT fk_personxphone_phone FOREIGN KEY (idPhone) REFERENCES Phone(idPhone);
    
-----------------------------------------------------------------------------------
-- FK News-NewsStatus
ALTER TABLE News
    ADD CONSTRAINT fk_news_newsStatus FOREIGN KEY (idNewsStatus) REFERENCES NewsStatus(idNewsStatus);
-- FK News-NewsType
ALTER TABLE News
    ADD CONSTRAINT fk_news_newstype FOREIGN KEY (idNewsType) REFERENCES NewsType(idNewsType);
    
    
-- FK NewsChange-News
ALTER TABLE NewsChange
    ADD CONSTRAINT fk_newsChange_news FOREIGN KEY (idNews) REFERENCES News(idNews);
-- FK NewsChange-Blog
ALTER TABLE NewsChange
    ADD CONSTRAINT fk_newsChange_blog FOREIGN KEY (idBlog) REFERENCES Blog(idBlog);


-- FK Rating-UserPerson
ALTER TABLE Rating
    ADD CONSTRAINT fk_rating_userPerson FOREIGN KEY (username) REFERENCES UserPerson(username);
-- FK Rating-News
ALTER TABLE Rating
    ADD CONSTRAINT fk_rating_news FOREIGN KEY (idNews) REFERENCES News(idNews);

-- FK FavoriteNews-UserPerson
ALTER TABLE FavoriteNews
    ADD CONSTRAINT fk_favoriteNews_userPerson FOREIGN KEY (username) REFERENCES UserPerson(username);

-- FK FavoriteNews-News
ALTER TABLE FavoriteNews
    ADD CONSTRAINT fk_favoriteNews_news FOREIGN KEY (idNews) REFERENCES News(idNews);


-- FK NewsComment-UserPerson
ALTER TABLE NewsComment
    ADD CONSTRAINT fk_newsComment_userPerson FOREIGN KEY (username) REFERENCES UserPerson(username);

-- FK NewsComment-News
ALTER TABLE NewsComment
    ADD CONSTRAINT fk_newsComment_news FOREIGN KEY (idNews) REFERENCES News(idNews);
    
-----------------------------------------------------------------------------------------
-- FK Stadium-Country
ALTER TABLE Stadium
    ADD CONSTRAINT fk_stadium_address FOREIGN KEY (idAddress) REFERENCES Address(idAddress);

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
    
-----------------------------------------------------------------------------------------
-- FK PlayerXSoccerMatchXTeam-Player
ALTER TABLE PlayerXSoccerMatchXTeam
    ADD CONSTRAINT fk_PxMxT_player FOREIGN KEY (idPerson) REFERENCES Player(idPerson);

-- FK PlayerXSoccerMatchXTeam-SoccerMatch
ALTER TABLE PlayerXSoccerMatchXTeam
    ADD CONSTRAINT fk_PxMxT_soccermatch FOREIGN KEY (idSoccerMatch) REFERENCES SoccerMatch(idSoccerMatch);

-- FK PlayerXSoccerMatchXTeam-Team
ALTER TABLE PlayerXSoccerMatchXTeam
    ADD CONSTRAINT fk_PxMxT_team FOREIGN KEY (idTeam) REFERENCES Team(idTeam);
    
-- FK SoccerMatch-Stadium
ALTER TABLE SoccerMatch
    ADD CONSTRAINT fk_soccermatch_stadium FOREIGN KEY (idStadium) REFERENCES Stadium(idStadium);
    
-----------------------------------------------------------------------------------------------------------------
-- FK GroupEvent-Event
ALTER TABLE GroupEvent
    ADD CONSTRAINT fk_group_event FOREIGN KEY (idEvent) REFERENCES Event(idEvent);

-- FK CountryTeam-Continent
ALTER TABLE CountryTeam
    ADD CONSTRAINT fk_countryTeam_continent FOREIGN KEY (idContinent) REFERENCES Continent(idContinent);

-- FK Team-CountryTeam
ALTER TABLE Team
    ADD CONSTRAINT fk_team_countryTeam FOREIGN KEY (idCountryTeam) REFERENCES CountryTeam(idCountryTeam);

-- FK TeamXGroup-Team
ALTER TABLE TeamXGroup 
    ADD CONSTRAINT fk_teamgroup_team FOREIGN KEY (idTeam) REFERENCES Team(idTeam);

-- FK TeamXGroup-Group
ALTER TABLE TeamXGroup 
    ADD CONSTRAINT fk_teamgroup_group FOREIGN KEY (idGroupEvent) REFERENCES GroupEvent(idGroupEvent);

-- FK GroupStats-Team
ALTER TABLE GroupStats 
    ADD CONSTRAINT fk_groupStats_team FOREIGN KEY (idTeam) REFERENCES Team(idTeam);

        