CREATE OR REPLACE PROCEDURE insertGroupEvent (pIdEvent IN NUMBER, pDescription IN VARCHAR2) AS
BEGIN
    INSERT INTO GroupEvent (idGroupEvent, idEvent, descriptionGroupEvent, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_groupEvent.nextval, pIdEvent, pDescription, NULL, NULL, NULL, NULL);
    COMMIT;
END insertGroupEvent;

CREATE OR REPLACE PROCEDURE insertGroupStats (pIdTeam IN NUMBER, pWonMatches IN NUMBER, pTiedMatches IN NUMBER, pLostMatches IN NUMBER, pGoalsScored IN NUMBER, pGoalsReceived IN NUMBER, pFairPlayPoints IN NUMBER) AS
BEGIN
    INSERT INTO GroupStats (idStats, idTeam, wonMatches, tiedMatches, lostMatches, goalsScored, goalsReceived, fairPlayPoints, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_groupstats.nextval, pIdTeam, pWonMatches, pTiedMatches, pLostMatches, pGoalsScored, pGoalsReceived, pFairPlayPoints, NULL, NULL, NULL, NULL);
    COMMIT;
END insertGroupStats;


CREATE OR REPLACE PROCEDURE insertMail (pIdPerson IN NUMBER, pDescription IN VARCHAR2) AS
BEGIN
    INSERT INTO Mail (idMail, idPerson, descriptionMail, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_mail.nextval, pidPerson, pDescription, NULL, NULL, NULL, NULL);
    COMMIT;
END insertMail;

CREATE OR REPLACE PROCEDURE insertNews (pIdNewsStatus IN NUMBER, pIdNewsType IN NUMBER, pTitle IN VARCHAR2, pPublicationDate IN DATE, pViewsNews IN NUMBER, pLinkNews IN VARCHAR2, pPhoto IN VARCHAR2, pTextNews IN VARCHAR2) AS
BEGIN
    INSERT INTO News (idNews, idNewsStatus, idNewsType, title, publicationDate, viewsNews, linkNews, photo, textNews, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_news.nextval, pIdNewsStatus, pIdNewsType, pTitle, pPublicationDate, pViewsNews, pLinkNews, pPhoto, pTextNews, NULL, NULL, NULL, NULL);
    COMMIT;
END insertNews;

CREATE OR REPLACE PROCEDURE insertNewsChange (pIdNews IN NUMBER, pIdBlog IN NUMBER, pUsername IN VARCHAR2, pCurrentText IN VARCHAR2, pPreviousText IN VARCHAR2, pDescriptionNewsChange IN VARCHAR2, pDateHour IN DATE) AS
BEGIN
    INSERT INTO NewsChange (idNewsChange, idNews, idBlog, username, currentText, previousText, descriptionNewsChange, dateHour, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newschange.nextval, pIdNews, pIdBlog, pUsername, pCurrentText, pPreviousText, pDescriptionNewsChange, pDateHour, NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsChange;


CREATE OR REPLACE PROCEDURE insertEventWorkerXMatch (pIdPerson IN NUMBER, pIdSoccerMatch IN NUMBER) AS
BEGIN
    INSERT INTO NewsChange (idEventWorkerXSoccerMatch, idPerson, idSoccerMatch, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_eventworkerxsoccermatch.nextval, pIdPerson, pIdSoccerMatch, NULL, NULL, NULL, NULL);
    COMMIT;
END insertEventWorkerXMatch;

