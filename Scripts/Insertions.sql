/*
 Person -> 20
 Team -> 10
 News -> 10
 Comentarios -> 5
 Reviews -> 5
 Favoritos -> 5

*/
-- Country
CREATE OR REPLACE PROCEDURE insertCountry
AS
BEGIN
    INSERT INTO Country (idCountry, nameCountry, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_country.NEXTVAL, 'Costa Rica', NULL, NULL, NULL, NULL);
    
    INSERT INTO Country (idCountry, nameCountry, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_country.NEXTVAL, 'Argentina', NULL, NULL, NULL, NULL);
    
    INSERT INTO Country (idCountry, nameCountry, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_country.NEXTVAL, 'Espa�a', NULL, NULL, NULL, NULL);
    COMMIT;
END insertCountry;

-- PersonPosition
CREATE OR REPLACE PROCEDURE insertPersonPosition
AS
BEGIN
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, 'Portero', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, 'Defensa', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, 'Mediocampista', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, 'Delantero', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, 'Extremo', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, 'Lateral', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, 'T�cnico', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, 'Cuerpo T�cnico', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, '�rbitro', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, '�rbitro de l�nea', NULL, NULL, NULL, NULL);
    COMMIT;
END insertPersonPosition;

--TypeIdentification
CREATE OR REPLACE PROCEDURE insertTypeIdentification
AS
BEGIN
    INSERT INTO TypeIdentification (idTypeIdentification, nameTypeIdentification, typeMask, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_typeIdentification.NEXTVAL, 'C�dula', 'X-XXXX-XXXX', NULL, NULL, NULL, NULL);
    
    INSERT INTO TypeIdentification (idTypeIdentification, nameTypeIdentification, typeMask, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_typeIdentification.NEXTVAL, 'Pasaporte','X-XXXX-XXXX', NULL, NULL, NULL, NULL);
    COMMIT;
END insertTypeIdentification;

-- Gender
CREATE OR REPLACE PROCEDURE insertGender
AS
BEGIN
    INSERT INTO Gender (idGender, descriptionGender, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_gender.NEXTVAL, 'Femenino', NULL, NULL, NULL, NULL);
    
    INSERT INTO Gender (idGender, descriptionGender, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_gender.NEXTVAL, 'Masculino', NULL, NULL, NULL, NULL);
    
    INSERT INTO Gender (idGender, descriptionGender, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_gender.NEXTVAL, 'Otro', NULL, NULL, NULL, NULL);
    COMMIT;
END insertGender;

-- Stadium
CREATE OR REPLACE PROCEDURE insertStadium
AS
BEGIN
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.NEXTVAL, 1, 'Estadio Nacional', NULL, NULL, NULL, NULL);
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.NEXTVAL, 1, 'Estadio Ricardo Saprissa Aym�', NULL, NULL, NULL, NULL);
    
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.NEXTVAL, 2, 'La Bombonera', NULL, NULL, NULL, NULL); 
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.NEXTVAL, 2, 'Luna Park', NULL, NULL, NULL, NULL);
    
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.NEXTVAL, 3, 'Santiago Bernab�u', NULL, NULL, NULL, NULL);
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.NEXTVAL, 3, 'CampNou', NULL, NULL, NULL, NULL);
    COMMIT;
END insertStadium;

-- NewsStatus
CREATE OR REPLACE PROCEDURE insertNewsStatus
AS
BEGIN
    INSERT INTO NewsStatus(idNewsStatus, descriptionNewsStatus, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_newsStatus.NEXTVAL, 'Publicado', NULL, NULL, NULL, NULL);
    
    INSERT INTO NewsStatus(idNewsStatus, descriptionNewsStatus, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_newsStatus.NEXTVAL, 'Pendiente', NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsStatus;

-- Continent
CREATE OR REPLACE PROCEDURE insertContinent
AS
BEGIN
    INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_continent.NEXTVAL, '�frica', NULL, NULL, NULL, NULL);
    
    INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_continent.NEXTVAL, 'Am�rica', NULL, NULL, NULL, NULL);
    
    INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_continent.NEXTVAL, 'Europa', NULL, NULL, NULL, NULL);
    
    INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_continent.NEXTVAL, 'Asia', NULL, NULL, NULL, NULL);
    
    INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_continent.NEXTVAL, 'Europa', NULL, NULL, NULL, NULL);
    COMMIT;
END insertContinent;

-- UserType
CREATE OR REPLACE PROCEDURE insertUserType
AS
BEGIN
    INSERT INTO UserType(idUserType, descriptionUserType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_usertype.nextval, 'Administrador', NULL, NULL, NULL, NULL);
    
    INSERT INTO UserType(idUserType, descriptionUserType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_usertype.nextval, 'Usuario', NULL, NULL, NULL, NULL);
    COMMIT;
END insertUserType;

-- NewsType
CREATE OR REPLACE PROCEDURE insertNewsType
AS
BEGIN
    INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsType.nextval, 'Opinion', NULL, NULL, NULL, NULL);
    
    INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsType.nextval, 'Historia', NULL, NULL, NULL, NULL);
    
    INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsType.nextval, 'Rese�a', NULL, NULL, NULL, NULL);
    
    INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsType.nextval, 'Fichajes', NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsType;

-- Province
CREATE OR REPLACE PROCEDURE insertProvince
AS
BEGIN
    INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, 1,'San Jos�', NULL, NULL, NULL, NULL);
    
    INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, 1,'Heredia', NULL, NULL, NULL, NULL);
    
    INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, 1,'Cartago', NULL, NULL, NULL, NULL);
    
    INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, 1,'Alajuela', NULL, NULL, NULL, NULL);
    
    INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, 1,'Guanacaste', NULL, NULL, NULL, NULL);
    
    INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, 1,'Puntarenas', NULL, NULL, NULL, NULL);
    
    INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, 1,'Lim�n', NULL, NULL, NULL, NULL);
    
    INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, 2,'Mendoza', NULL, NULL, NULL, NULL);

    INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, 3,'Barcelona', NULL, NULL, NULL, NULL);
    COMMIT;
END insertProvince;


-- Canton
CREATE OR REPLACE PROCEDURE insertCanton
AS
BEGIN
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 1,'Escaz�', NULL, NULL, NULL, NULL);
    
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 2,'Flores', NULL, NULL, NULL, NULL);
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 2,'Barva', NULL, NULL, NULL, NULL);
    
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 3,'Oreamuno', NULL, NULL, NULL, NULL);
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 3,'Jim�nez', NULL, NULL, NULL, NULL);
    
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 4,'Atenas', NULL, NULL, NULL, NULL);
    
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 5,'Santa Cruz', NULL, NULL, NULL, NULL);
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 5,'Bagaces', NULL, NULL, NULL, NULL);
    
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 6,'Esparza', NULL, NULL, NULL, NULL);
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 6,'Buenos Aires', NULL, NULL, NULL, NULL);
    
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 7,'Talamanca', NULL, NULL, NULL, NULL);
    
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 8,'Santa Rosa', NULL, NULL, NULL, NULL);
    
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 9,'Catalu�a', NULL, NULL, NULL, NULL);
    COMMIT;
END insertCanton;

CREATE OR REPLACE PROCEDURE insertDistrict
AS
BEGIN
    -- Escaz�
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval, 1,'San Antonio', NULL, NULL, NULL, NULL);
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval, 1,'San Rafael', NULL, NULL, NULL, NULL);
    
    -- Flores
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval, 2,'Barrantes', NULL, NULL, NULL, NULL);
    
    -- Barva
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval, 3,'San Pablo', NULL, NULL, NULL, NULL);
    
    -- Oreamuno
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval, 4,'Cipreses', NULL, NULL, NULL, NULL);
    
    -- Jim�nez
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval, 5,'Pejibaye', NULL, NULL, NULL, NULL);
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval, 5,'Tucurrique', NULL, NULL, NULL, NULL);
    
    -- Atenas
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval,6,'Escobal', NULL, NULL, NULL, NULL);
    
    --- Santa Cruz
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval,7,'Tamarindo', NULL, NULL, NULL, NULL);
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval,7,'Cartagena', NULL, NULL, NULL, NULL);
    
    -- Bagaces
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval,8,'La Fortuna', NULL, NULL, NULL, NULL);
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval,8,'Mogote', NULL, NULL, NULL, NULL);
    
    --- Esparza
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval,9,'Esp�ritu Santo', NULL, NULL, NULL, NULL);
    
    -- Buenos Aires
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval,10, 'Boruca', NULL, NULL, NULL, NULL);
    
    -- Talamanca
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval,11, 'Sixaola', NULL, NULL, NULL, NULL);
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval,11, 'Cahuita', NULL, NULL, NULL, NULL);
    
    --- Santa Rosa
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval,12, 'Villa Cabecera', NULL, NULL, NULL, NULL);
    
    --- Catalu�a
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval,12, 'Guardiola', NULL, NULL, NULL, NULL);
    COMMIT;
END insertDistrict;

-- Execute
EXECUTE insertCountry;
EXECUTE insertPersonPosition;
EXECUTE insertTypeIdentification;
EXECUTE insertGender;

EXECUTE insertStadium;
EXECUTE insertNewsStatus;
EXECUTE insertContinent;

EXECUTE insertUserType;
EXECUTE insertNewsType;
EXECUTE insertProvince;
EXECUTE insertCanton;
EXECUTE insertDistrict;