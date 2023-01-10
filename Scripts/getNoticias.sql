CREATE OR REPLACE PROCEDURE getNews(curNews OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNews FOR
    SELECT idNews, NewsType.descriptionNewsType, NewsStatus.descriptionNewsStatus, title, publicationDate, viewsNews, linkNews, photo, textNews
    FROM News 
    INNER JOIN NewsStatus ON News.idNewsStatus = NewsStatus.idNewsStatus
    INNER JOIN NewsType ON News.idNewsType = NewsType.idNewsType;
END getNews;

CREATE OR REPLACE FUNCTION getNewsRating(pIdNews IN NUMBER) RETURN NUMBER
IS
BEGIN
    DECLARE avgRating NUMBER;
    BEGIN
        SELECT AVG(rating) INTO avgRating FROM Rating
        WHERE pIdNews = Rating.idNews;
        RETURN avgRating;
    END;
END getNewsRating;

--esto va en getCatalogs
CREATE OR REPLACE PROCEDURE getNewsStatus(curNewsStatus OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNewsStatus FOR
    SELECT idNewsStatus, descriptionNewsStatus
    FROM NewsStatus;
END getNewsStatus;

--esto va en getCatalogs
CREATE OR REPLACE PROCEDURE getNewsType(curNewsType OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNewsType FOR
    SELECT idNewsType, descriptionNewsType
    FROM NewsType;
END getNewsType;