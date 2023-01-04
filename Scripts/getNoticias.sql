CREATE OR REPLACE PROCEDURE getNews(curNews OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNews FOR
    SELECT idNews, idNewsStatus, idNewsType, title, publicationDate, viewsNews, linkNews, photo, textNews
    FROM News;
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