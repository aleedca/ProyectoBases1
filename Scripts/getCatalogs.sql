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

CREATE OR REPLACE PROCEDURE getEvent (curEvent OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curEvent FOR
    SELECT idEvent, typeEvent
    FROM Event;
END getEvent;


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




