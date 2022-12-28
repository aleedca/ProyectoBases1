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

-- Table News
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
    user VARCHAR(16) CONSTRAINT change_user_nn NOT NULL,
    previousText VARCHAR(70) CONSTRAINT change_previousText_nn NOT NULL,
    descriptionChange VARCHAR(16) CONSTRAINT change_description_nn NOT NULL,
    date DATE CONSTRAINT change_date_nn NOT NULL,
    hour TIME CONSTRAINT change_hour_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT change_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT change_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT change_dateCreation_nn NOT NULL
);

-- Blog
CREATE TABLE Blog(
    idBlog NUMBER(10) PRIMARY KEY,
    user VARCHAR(16) CONSTRAINT blog_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT blog_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT blog_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT blog_dateCreation_nn NOT NULL
);

-- State
CREATE TABLE State(
    idState NUMBER(10) PRIMARY KEY,
    user VARCHAR(16) CONSTRAINT state_user_nn NOT NULL,
    description VARCHAR(16) CONSTRAINT state_description_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT state_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT state_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT state_dateCreation_nn NOT NULL
);

-- NewsType
CREATE TABLE NewsType(
    idNewsType NUMBER(10) PRIMARY KEY,
    user VARCHAR(16) CONSTRAINT newsType_user_nn NOT NULL,
    description VARCHAR(16) CONSTRAINT newsType_description_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT newsType_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT newsType_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT newsType_dateCreation_nn NOT NULL
);

-- Rating
CREATE TABLE Rating(
    idRating NUMBER(10) PRIMARY KEY,
    userUsername VARCHAR(16) CONSTRAINT rating_userUsername_nn NOT NULL,
    idNews NUMBER(10) CONSTRAINT rating_idNews_nn NOT NULL,
    rating NUMBER(10) CONSTRAINT rating_description_nn NOT NULL,
    user VARCHAR(16) CONSTRAINT rating_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT rating_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT rating_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT rating_dateCreation_nn NOT NULL
);

-- FavoriteNews
CREATE TABLE FavoriteNews(
    idFavoriteNews NUMBER(10) PRIMARY KEY,
    userUsername VARCHAR(16) CONSTRAINT favoriteNews_userUsername_nn NOT NULL,
    idNews NUMBER(10) CONSTRAINT favoriteNews_idNews_nn NOT NULL,
    user VARCHAR(16) CONSTRAINT favoriteNews_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT favoriteNews_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT favoriteNews_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT favoriteNews_dateCreation_nn NOT NULL
);

-- Comment
CREATE TABLE Comment(
    idComment NUMBER(10) PRIMARY KEY,
    userUsername VARCHAR(16) CONSTRAINT comment_userUsername_nn NOT NULL,
    idNews NUMBER(10) CONSTRAINT comment_idNews_nn NOT NULL,
    text VARCHAR(20) CONSTRAINT comment_text_nn NOT NULL,
    user VARCHAR(16) CONSTRAINT comment_user_nn NOT NULL,
    lastUser VARCHAR(16) CONSTRAINT comment_lastUser_nn NOT NULL,
    lastDate DATE CONSTRAINT comment_lastDate_nn NOT NULL,
    dateCreation DATE CONSTRAINT comment_dateCreation_nn NOT NULL
);

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



 
 
 
 
 
 
 
 
