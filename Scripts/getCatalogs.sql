CREATE OR REPLACE PROCEDURE getEvent (curEvent OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curEvent FOR
    SELECT idEvent, typeEvent
    FROM Event;
END getEvent;

CREATE OR REPLACE PROCEDURE getGender(curGender OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curGender FOR
    SELECT idGender, descriptionGender
    FROM Gender;
END getGender;

CREATE OR REPLACE PROCEDURE getPosition (curPosition OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curPosition FOR
    SELECT idPersonPosition, descriptionPersonPosition
    FROM PersonPosition;
END getPosition;

CREATE OR REPLACE PROCEDURE getTypeIdentification(curTypeIdentification OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curTypeIdentification FOR
    SELECT idTypeIdentification, nameTypeIdentification
    FROM TypeIdentification;
END getTypeIdentification;


CREATE OR REPLACE PROCEDURE getCountry(curCountry OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curCountry FOR
    SELECT idCountry, nameCountry
    FROM Country;
END getCountry;


CREATE OR REPLACE PROCEDURE getProvince(curProvince OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curProvince FOR
    SELECT idCountry, idProvince, nameProvince
    FROM Province;
END getProvince;


CREATE OR REPLACE PROCEDURE getCanton(curCanton OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curCanton FOR
    SELECT idProvince, idCanton, nameCanton
    FROM Canton;
END getCanton;


CREATE OR REPLACE PROCEDURE getDistrict(curDistrict OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curDistrict FOR
    SELECT idCanton, idDistrict, nameDistrict
    FROM District;
END getDistrict;

CREATE OR REPLACE PROCEDURE getNewsStatus(curNewsStatus OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNewsStatus FOR
    SELECT idNewsStatus, descriptionNewsStatus
    FROM NewsStatus;
END getNewsStatus;

CREATE OR REPLACE PROCEDURE getNewsType(curNewsType OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNewsType FOR
    SELECT idNewsType, descriptionNewsType
    FROM NewsType;
END getNewsType;

CREATE OR REPLACE PROCEDURE getTeam(curTeam OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curTeam FOR
    SELECT idTeam, nameTeam
    FROM Team;
END getTeam;

CREATE OR REPLACE PROCEDURE getCountryTeam(curCountryTeam OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curCountryTeam FOR
    SELECT  idCountryTeam, idContinent, nameCountryTeam, flag
    FROM CountryTeam;
END getCountryTeam;

CREATE OR REPLACE PROCEDURE getNews(curNews OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curNews FOR
    SELECT idNews, NewsType.descriptionNewsType, NewsStatus.descriptionNewsStatus, title, publicationDate, viewsNews, linkNews, photo, textNews
    FROM News 
    INNER JOIN NewsStatus ON News.idNewsStatus = NewsStatus.idNewsStatus
    INNER JOIN NewsType ON News.idNewsType = NewsType.idNewsType;
END getNews;





