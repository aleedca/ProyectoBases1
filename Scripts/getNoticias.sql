CREATE OR REPLACE PROCEDURE getNews(curNews OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNews FOR
    SELECT idNews, idNewsStatus, idNewsType, title, publicationDate, viewsNews, linkNews, photo, textNews
    FROM News;
END getNews;