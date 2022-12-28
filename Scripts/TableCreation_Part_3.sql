/* File Name: TableCreation_Part_3
Description: This file contains the code to create tables, their sequences and associations.
Authors:
Isaac Araya Solano - 2018151703
Alexia Cerdas Aguilar - 2019026961
Nahomi Bolaños Valverde - 2022089165
Mariana Fernández Martínez - 2021104026
*/

-- ////////////////////////////////////// TABLE CREATION ////////////////////////////////////

-- News
CREATE TABLE News(
    idNews NUMBER(10) PRIMARY KEY,
    idState NUMBER(10) CONSTRAINT news_idState_nn NOT NULL
    idNewsType NUMBER(10) CONSTRAINT news_idNewsType_nn NOT NULL
    title VARCHAR(20) CONSTRAINT news_title_nn NOT NULL,
    publicationDate DATE CONSTRAINT news_publicationDate_nn NOT NULL,
    views NUMBER(32) CONSTRAINT news_views_nn NOT NULL,
    link VARCHAR(32) CONSTRAINT news_link_nn NOT NULL,
    --photo VARCHAR() CONSTRAINT news_photo_nn NOT NULL,
    text VARCHAR(70) CONSTRAINT news_text_nn NOT NULL
    userCreation VARCHAR(16) CONSTRAINT news_userCreation_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT news_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT news_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT news_dateCreation_nn NOT NULL,
);

-- Table Comment
COMMENT ON TABLE News
IS 'Repository for storing the information of the news';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN News.idNews
IS 'Unique identifier of the News Table.';

COMMENT ON COLUMN News.idState
IS 'Reference to State Table.';

COMMENT ON COLUMN News.idNewsType
IS 'Reference to idNewsType Table.';

COMMENT ON COLUMN News.title
IS 'News title.';

COMMENT ON COLUMN News.publicationDate
IS 'Date of publication of each news.';

COMMENT ON COLUMN News.views
IS 'Views of each news.';

COMMENT ON COLUMN News.link
IS 'Link of each news.';

--COMMENT ON COLUMN News.photo
--IS 'Photo of each news.';

COMMENT ON COLUMN News.text
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

-------------------------------------------------------------------------------------------

-- Change
CREATE TABLE Change(
    idChange NUMBER(10) PRIMARY KEY,
    idNews NUMBER(10) CONSTRAINT change_idNews_nn NOT NULL,
    idBlog NUMBER(10) CONSTRAINT change_idBlog_nn NOT NULL,
    username VARCHAR(10) CONSTRAINT change_username_nn NOT NULL,
    currentText VARCHAR(70) CONSTRAINT change_currentText_nn NOT NULL,
    previousText VARCHAR(70) CONSTRAINT change_previousText_nn NOT NULL,
    descriptionChange VARCHAR(16) CONSTRAINT change_description_nn NOT NULL,
    date DATE CONSTRAINT change_date_nn NOT NULL,
    hour TIME CONSTRAINT change_hour_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT change_userCreation_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT change_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT change_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT change_dateCreation_nn NOT NULL
);

-- Table Comment
COMMENT ON TABLE Change
IS 'Repository for storing the information of the change';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Change.idChange
IS 'Unique identifier of the Change Table.';

COMMENT ON COLUMN Change.idNews
IS 'Reference to News Table.';

COMMENT ON COLUMN Change.idBlog
IS 'Reference to Blog Table.';

COMMENT ON COLUMN Change.username
IS 'Username that made the change.';

COMMENT ON COLUMN Change.currentText
IS 'Text after the change.';

COMMENT ON COLUMN Change.previousText
IS 'Text before the change.';

COMMENT ON COLUMN Change.descriptionChange
IS 'Description of the change.';

COMMENT ON COLUMN Change.date
IS 'Date of the change.';

COMMENT ON COLUMN Change.hour
IS 'Hour of the change.';

-- Audit Fields 
COMMENT ON COLUMN Change.userCreation
IS 'User who creates the Change Table record.';

COMMENT ON COLUMN Change.dateCreation
IS 'Date of creation of the Change Table record.';

COMMENT ON COLUMN Change.lastUser
IS 'Last user to modify a record in the Change Table.';

COMMENT ON COLUMN Change.lastDate
IS 'Last modification date of the record in the Change Table.';
-------------------------------------------------------------------------------------------

-- Blog
CREATE TABLE Blog(
    idBlog NUMBER(10) PRIMARY KEY,
    userCreation VARCHAR(16) CONSTRAINT blog_userCreation_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT blog_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT blog_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT blog_dateCreation_nn NOT NULL
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
-------------------------------------------------------------------------------------------

-- State
CREATE TABLE State(
    idState NUMBER(10) PRIMARY KEY,
    descriptionState VARCHAR(16) CONSTRAINT state_description_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT state_userCreation_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT state_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT state_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT state_dateCreation_nn NOT NULL
);

-- Table Comment
COMMENT ON TABLE State
IS 'Repository for storing the information of the state';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN State.idState
IS 'Unique identifier of the State Table.';

COMMENT ON COLUMN State.descriptionState
IS 'Description of the State';

-- Audit Fields 
COMMENT ON COLUMN State.userCreation
IS 'User who creates the State Table record.';

COMMENT ON COLUMN State.dateCreation
IS 'Date of creation of the State Table record.';

COMMENT ON COLUMN State.lastUser
IS 'Last user to modify a record in the State Table.';

COMMENT ON COLUMN State.lastDate
IS 'Last modification date of the record in the State Table.';
-------------------------------------------------------------------------------------------

-- NewsType
CREATE TABLE NewsType(
    idNewsType NUMBER(10) PRIMARY KEY,
    descriptionNewsType VARCHAR(16) CONSTRAINT newsType_description_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT newsType_userCreation_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT newsType_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT newsType_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT newsType_dateCreation_nn NOT NULL
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
-------------------------------------------------------------------------------------------

-- Rating
CREATE TABLE Rating(
    idRating NUMBER(10) PRIMARY KEY,
    userUsername VARCHAR(16) CONSTRAINT rating_userUsername_nn NOT NULL,
    idNews NUMBER(10) CONSTRAINT rating_idNews_nn NOT NULL,
    rating NUMBER(10) CONSTRAINT rating_description_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT rating_userCreation_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT rating_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT rating_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT rating_dateCreation_nn NOT NULL
);

-- Table Comment
COMMENT ON TABLE Rating
IS 'Repository for storing the information of the Rating';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Rating.idRating
IS 'Unique identifier of the Rating Table.';

COMMENT ON COLUMN Rating.userUsername
IS 'Reference to User Table.';

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
-------------------------------------------------------------------------------------------

-- FavoriteNews
CREATE TABLE FavoriteNews(
    idFavoriteNews NUMBER(10) PRIMARY KEY,
    userUsername VARCHAR(16) CONSTRAINT favoriteNews_userUsername_nn NOT NULL,
    idNews NUMBER(10) CONSTRAINT favoriteNews_idNews_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT favoriteNews_userCreation_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT favoriteNews_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT favoriteNews_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT favoriteNews_dateCreation_nn NOT NULL
);

-- Table Comment
COMMENT ON TABLE FavoriteNews
IS 'Repository for storing the information of the FavoriteNews';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN FavoriteNews.idFavoriteNews
IS 'Unique identifier of the FavoriteNews Table.';

COMMENT ON COLUMN FavoriteNews.userUsername
IS 'Reference to User Table.';

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
-------------------------------------------------------------------------------------------

-- Comment
CREATE TABLE Comment(
    idComment NUMBER(10) PRIMARY KEY,
    userUsername VARCHAR(16) CONSTRAINT comment_userUsername_nn NOT NULL,
    idNews NUMBER(10) CONSTRAINT comment_idNews_nn NOT NULL,
    text VARCHAR(20) CONSTRAINT comment_text_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT comment_userCreation_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT comment_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT comment_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT comment_dateCreation_nn NOT NULL
);

-- Table Comment
COMMENT ON TABLE Comment
IS 'Repository for storing the information of the Comment';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN Comment.idComment
IS 'Unique identifier of the Comment Table.';

COMMENT ON COLUMN Comment.userUsername
IS 'Reference to User Table.';

COMMENT ON COLUMN Comment.idNews
IS 'Reference to News Table.';

COMMENT ON COLUMN Comment.text
IS 'Text of each comment';

-- Audit Fields 
COMMENT ON COLUMN Comment.userCreation
IS 'User who creates the Comment Table record.';

COMMENT ON COLUMN Comment.dateCreation
IS 'Date of creation of the Comment Table record.';

COMMENT ON COLUMN Comment.lastUser
IS 'Last user to modify a record in the Comment Table.';

COMMENT ON COLUMN Comment.lastDate
IS 'Last modification date of the record in the Comment Table.';
-------------------------------------------------------------------------------------------

-- SoccerMatch
CREATE TABLE SoccerMatch(
    idSoccerMatch NUMBER(10) PRIMARY KEY,
    date DATE CONSTRAINT soccerMatch_date_nn NOT NULL,
    hour TIME CONSTRAINT soccerMatch_hour_nn NOT NULL,
    userCreation VARCHAR(16) CONSTRAINT soccerMatch_userCreation_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT soccerMatch_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT soccerMatch_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT soccerMatch_dateCreation_nn NOT NULL
);

-- Table Comment
COMMENT ON TABLE SoccerMatch
IS 'Repository for storing the information of the SoccerMatch';
--------------- Comment on Attributes -------------------------------------
COMMENT ON COLUMN SoccerMatch.idSoccerMatch
IS 'Unique identifier of the SoccerMatch Table.';

COMMENT ON COLUMN SoccerMatch.date
IS 'Date of the Soccer Match.';

COMMENT ON COLUMN SoccerMatch.hour
IS 'Hour of the Soccer Match.';


-- Audit Fields 
COMMENT ON COLUMN SoccerMatch.userCreation
IS 'User who creates the SoccerMatch Table record.';

COMMENT ON COLUMN SoccerMatch.dateCreation
IS 'Date of creation of the SoccerMatch Table record.';

COMMENT ON COLUMN SoccerMatch.lastUser
IS 'Last user to modify a record in the SoccerMatch Table.';

COMMENT ON COLUMN SoccerMatch.lastDate
IS 'Last modification date of the record in the SoccerMatch Table.';

-------------------------------------------------------------------------------------------------

-- ////////////////////////////////////// FOREING KEYS PART 3////////////////////////////////////
-- FK News-State
ALTER TABLE News
    ADD CONSTRAINT fk_news_state FOREIGN KEY (idState) REFERENCES State(idState);
-- FK News-NewsType
ALTER TABLE News
    ADD CONSTRAINT fk_news_newstype FOREIGN KEY (idNewsType) REFERENCES NewsType(idNewsType);
    
    
-- FK Change-News
ALTER TABLE Change
    ADD CONSTRAINT fk_change_news FOREIGN KEY (idNews) REFERENCES News(idNews);
-- FK Change-Blog
ALTER TABLE Change
    ADD CONSTRAINT fk_change_blog FOREIGN KEY (idBlog) REFERENCES Blog(idBlog);


-- FK Rating-User
ALTER TABLE Rating
    ADD CONSTRAINT fk_rating_user FOREIGN KEY (userUsername) REFERENCES User(username);
-- FK Rating-News
ALTER TABLE Rating
    ADD CONSTRAINT fk_rating_news FOREIGN KEY (idNews) REFERENCES News(idNews);


-- FK FavoriteNews-User
ALTER TABLE FavoriteNews
    ADD CONSTRAINT fk_favoriteNews_user FOREIGN KEY (userUsername) REFERENCES User(username);

-- FK FavoriteNews-News
ALTER TABLE FavoriteNews
    ADD CONSTRAINT fk_favoriteNews_news FOREIGN KEY (idNews) REFERENCES News(idNews);


-- FK Comment-User
ALTER TABLE Comment
    ADD CONSTRAINT fk_comment_user FOREIGN KEY (userUsername) REFERENCES User(username);

-- FK Comment-News
ALTER TABLE Comment
    ADD CONSTRAINT fk_comment_news FOREIGN KEY (idNews) REFERENCES News(idNews);


-- ////////////////////////////////////// SEQUENCES ////////////////////////////////////
-- News
CREATE SEQUENCE s_news
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Change
CREATE SEQUENCE s_change
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Blog
CREATE SEQUENCE s_blog
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- State
CREATE SEQUENCE s_state
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- NewsType
CREATE SEQUENCE s_newsType
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Rating
CREATE SEQUENCE s_rating
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- FavoriteNews
CREATE SEQUENCE s_favoriteNews
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- Comment
CREATE SEQUENCE s_comment
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

-- SoccerMatch
CREATE SEQUENCE s_soccerMatch
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;



 
 
 
 
 
 
 
 
