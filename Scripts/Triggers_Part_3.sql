/* File Name: Triggers_Part_3
Description: This file contains the triggers for each table created in part 3.
Authors:
Isaac Araya Solano - 2018151703
Alexia Cerdas Aguilar - 2019026961
Nahomi Bolaños Valverde - 2022089165
Mariana Fernández Martínez - 2021104026
*/

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

-- Change
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertChange
BEFORE INSERT
ON proyectoBD.Change
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertChange;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateChange
BEFORE UPDATE
ON proyectoBD.Change
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateChange;

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

-- State
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertState
BEFORE INSERT
ON proyectoBD.State
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertState;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateState
BEFORE UPDATE
ON proyectoBD.State
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateState;

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

-- Comment
CREATE OR REPLACE TRIGGER proyectoBD.beforeInsertComment
BEFORE INSERT
ON proyectoBD.Comment
FOR EACH ROW
BEGIN
    :new.userCreation:=USER;
    :new.dateCreation:=SYSDATE;
END beforeInsertComment;

CREATE OR REPLACE TRIGGER proyectoBD.beforeUpdateComment
BEFORE UPDATE
ON proyectoBD.Comment
FOR EACH ROW
BEGIN
    :new.lastUser:=USER;
    :new.lastDate:=SYSDATE;
END beforeUpdateComment;

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
