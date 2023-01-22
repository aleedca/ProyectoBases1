/*
TO DO:
 Person -> 20
 Team -> 10
 News -> 10
 Comentarios -> 5
 Reviews -> 5
 Favoritos -> 5
*/

-- FOR TESTING
CREATE OR REPLACE PROCEDURE insertCountry
AS
BEGIN
    INSERT INTO Country (idCountry, nameCountry, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_country.NEXTVAL, 'Costa Rica', NULL, NULL, NULL, NULL);
    
    INSERT INTO Country (idCountry, nameCountry, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_country.NEXTVAL, 'Argentina', NULL, NULL, NULL, NULL);
    
    INSERT INTO Country (idCountry, nameCountry, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_country.NEXTVAL, 'Espana', NULL, NULL, NULL, NULL);
    COMMIT;
END insertCountry;

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
    VALUES (s_personPosition.NEXTVAL, 'Tecnico', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, 'Cuerpo Tecnico', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, 'Arbitro', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, 'Arbitro de linea', NULL, NULL, NULL, NULL);
    
    INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_personPosition.NEXTVAL, 'Espectador', NULL, NULL, NULL, NULL);
    
    COMMIT;
END insertPersonPosition;

CREATE OR REPLACE PROCEDURE insertTypeIdentification
AS
BEGIN
    INSERT INTO TypeIdentification (idTypeIdentification, nameTypeIdentification, typeMask, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_typeIdentification.NEXTVAL, 'Cedula', 'X-XXXX-XXXX', NULL, NULL, NULL, NULL);
    
    INSERT INTO TypeIdentification (idTypeIdentification, nameTypeIdentification, typeMask, userCreation, lastUser, lastDate, dateCreation) 
    VALUES (s_typeIdentification.NEXTVAL, 'Pasaporte','X-XXXX-XXXX', NULL, NULL, NULL, NULL);
    COMMIT;
END insertTypeIdentification;

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

CREATE OR REPLACE PROCEDURE insertStadium
AS
BEGIN
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.NEXTVAL, 1, 'Estadio Nacional', NULL, NULL, NULL, NULL);
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.NEXTVAL, 1, 'Estadio Ricardo Saprissa Ayma', NULL, NULL, NULL, NULL);
    
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.NEXTVAL, 2, 'La Bombonera', NULL, NULL, NULL, NULL); 
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.NEXTVAL, 2, 'Luna Park', NULL, NULL, NULL, NULL);
    
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.NEXTVAL, 3, 'Santiago Bernabeu', NULL, NULL, NULL, NULL);
    INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_stadium.NEXTVAL, 3, 'CampNou', NULL, NULL, NULL, NULL);
    COMMIT;
END insertStadium;

CREATE OR REPLACE PROCEDURE insertNewsStatus
AS
BEGIN
    INSERT INTO NewsStatus(idNewsStatus, descriptionNewsStatus, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_newsStatus.NEXTVAL, 'Publicado', NULL, NULL, NULL, NULL);
    
    INSERT INTO NewsStatus(idNewsStatus, descriptionNewsStatus, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_newsStatus.NEXTVAL, 'Pendiente', NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsStatus;

CREATE OR REPLACE PROCEDURE insertNewsType
AS
BEGIN
    INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsType.nextval, 'Opinion', NULL, NULL, NULL, NULL);
    
    INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsType.nextval, 'Historia', NULL, NULL, NULL, NULL);
    
    INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsType.nextval, 'Resena', NULL, NULL, NULL, NULL);
    
    INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_newsType.nextval, 'Fichajes', NULL, NULL, NULL, NULL);
    COMMIT;
END insertNewsType;

CREATE OR REPLACE PROCEDURE insertContinent
AS
BEGIN
    INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_continent.NEXTVAL, 'Africa', NULL, NULL, NULL, NULL);
    
    INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_continent.NEXTVAL, 'America', NULL, NULL, NULL, NULL);
    
    INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_continent.NEXTVAL, 'Europa', NULL, NULL, NULL, NULL);
    
    INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_continent.NEXTVAL, 'Asia', NULL, NULL, NULL, NULL);
    
    INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
    VALUES(s_continent.NEXTVAL, 'Europa', NULL, NULL, NULL, NULL);
    COMMIT;
END insertContinent;

CREATE OR REPLACE PROCEDURE insertUserType
AS
BEGIN
    INSERT INTO UserType(idUserType, descriptionUserType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_usertype.nextval, 'Administrador', NULL, NULL, NULL, NULL);
    
    INSERT INTO UserType(idUserType, descriptionUserType, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_usertype.nextval, 'Usuario', NULL, NULL, NULL, NULL);
    COMMIT;
END insertUserType;

CREATE OR REPLACE PROCEDURE insertProvince
AS
BEGIN
    INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, 1,'San Jose', NULL, NULL, NULL, NULL);
    
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
    VALUES (s_province.nextval, 1,'Limon', NULL, NULL, NULL, NULL);
    
    INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, 2,'Mendoza', NULL, NULL, NULL, NULL);

    INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_province.nextval, 3,'Barcelona', NULL, NULL, NULL, NULL);
    COMMIT;
END insertProvince;

CREATE OR REPLACE PROCEDURE insertCanton
AS
BEGIN
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 1,'Escazu', NULL, NULL, NULL, NULL);
    
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 2,'Flores', NULL, NULL, NULL, NULL);
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 2,'Barva', NULL, NULL, NULL, NULL);
    
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 3,'Oreamuno', NULL, NULL, NULL, NULL);
    INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_canton.nextval, 3,'Jimenez', NULL, NULL, NULL, NULL);
    
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
    VALUES (s_canton.nextval, 9,'Catalunya', NULL, NULL, NULL, NULL);
    COMMIT;
END insertCanton;

CREATE OR REPLACE PROCEDURE insertDistrict
AS
BEGIN
    -- Escazï¿½
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
    
    -- Jimï¿½nez
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
    VALUES (s_district.nextval,9,'Espiritu Santo', NULL, NULL, NULL, NULL);
    
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
    
    --- Cataluï¿½a
    INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
    VALUES (s_district.nextval,13, 'Guardiola', NULL, NULL, NULL, NULL);
    COMMIT;
END insertDistrict;

-- DECLARES
DECLARE outputNumber NUMBER(10);
BEGIN
insertTeamWorker (10000001, 1, 'Sara','Maria', 'Corrales', 'Coto', 'fotoSaraMaria',8,1,1,23455787,13,'sarita09@hotmail.com', 'Panaderia Juan 175mts al oeste, casa amarilla',outputNumber);
insertTeamWorker (20000002, 2, 'Mariana','Sofia','Smith',NULL, 'fotoMarianaSofia',7,1,1, 98765465, 4, 'marianasth@gmail.com', 'Centro educativo san juan, 200mts al norte y 100mts al sur',outputNumber);
insertTeamWorker (30000003, 3, 'Daniela', NULL,'Arguedas', 'Garcia', 'fotoDanielaArguedas',8,1,1,  67678989, 5,'daniarguedas78@gmail.com', 'De las eólicas para abajito', outputNumber);
insertTeamWorker (40000004, 4, 'Alana', NULL,'Ruiz', 'Fernandez', 'fotoAlanaRuiz',7,1,1, 22345019, 1,'alanaruiz67@gmail.com', 'De la iglesia jose mar, a la derecha hasta pegar con cerca, mano izquierda porton azul', outputNumber);
insertTeamWorker (50000005, 5, 'Carlos', NULL ,'Cerdas', 'Rodriguez', 'fotoCarlosCerdas',8,1,2, 45679093, 10,'carlitoscr@gmail.com', 'Cerca de las ruinas, 600 mts al oeste', outputNumber);
insertTeamWorker (60000006, 6, 'Jose', NULL ,'Williams', NULL, 'fotoJoseWilliams',7,1,2, 56783232, 7,'williamsj@hotmail.com', 'Del mall lincoln, cerca del cole de Moravia', outputNumber);
insertTeamWorker (70000007, 7, 'Thomas', NULL ,'Miller', 'Jhonson', 'fotoThomasMiller',8,1,2, 90908989, 3,'thomeM@gmail.com', 'De la panaderia Calvito, 100 mts al sur', outputNumber);
insertTeamWorker (80000008, 8, 'Mateo', NULL ,'Hernandez', NULL, 'fotoMateoHernandez',7,1,2, 26268787, 9, 'mateito17@gmail.com', 'De la entrada de disneyland, residencial las flores, casa CD9', outputNumber);
END;
  
DECLARE numberOutput NUMBER(10);
BEGIN
insertPlayer (105670888, 'Toni', NULL, 'Kroos', NULL, 'Foto Jugador', 3, 1, 2, 3, '04-01-1990', 8, 67892345,'tonito@hotmail.com', 2,'De la calle#33 50 metros al Norte.', numberOutput);     
insertPlayer (809910128, 'Luka', NULL, 'Modric', NULL, 'Foto Jugador', 3, 1, 2, 7, '09-09-1985', 10, 78491355,'modric@yahoo.com', 2,'De la calle#45 100 metros al Sur.', numberOutput);
insertPlayer (901440988, 'Vinicius', NULL, 'Junior', NULL, 'Foto Jugador', 4, 2, 2, 5, '12-07-2000', 20, 83671123,'junior@gmail.com', 2,'De la calle#55 200 metros al Oeste.', numberOutput);  
insertPlayer (704100224, 'Kylian', NULL, 'Mbappé', NULL, 'Foto Jugador', 4, 2, 2, 2, '20-12-1998', 10, 87332385,'kMbappe@gmail.com', 2,'De la calle#33 500 metros al Este.', numberOutput); 
insertPlayer (804440333, 'Vinicius', 'Juan', 'Junior', 'De Oliviera', 'Foto Jugador', 4, 2, 2, 5, '12-07-2000', 20, 83671123,'junior@gmail.com', 2,'De la calle#55 200 metros al Oeste.', numberOutput);  
END;

DECLARE numberOutput NUMBER(10);
BEGIN
insertNews(1, 1, 'Messi Campeon', TO_DATE('04-01-2023 15:33', 'DD-MM-YYYY HH24:MI'), 'linkEjemplo', 'fotomessi', 'Messi campeon del mundo, su actuacion ha sido espectacular en el campo y fuera de ella, gran jugador y persona. Dio todo por un país y sus seguidores.', numberOutput);
insertNews(2, 4, 'Ronaldo lo ficha un equipo de Arabia Saudita', NULL, 'linkEjemplo', 'fotoronaldo', 'El Al-Nassr es un grande de Arabia, un historico de la Liga de su país, pero no juega esta temporada la Liga de Campeones asiática, pero CR se mostró ilusionado por su nuevo reto: Estoy encantado con una nueva experiencia en una liga diferente y un país diferente, la visión que tiene Al Nassr es muy inspiradora. Estoy muy emocionado de unirme a mis compañeros de equipo y de ayudar a lograr más éxitos', numberOutput);
insertNews(2, 2, 'DiMaria y su camino a la copa', NULL, 'linkEjemplo', 'fotodimaria', 'Por eso, yo al fútbol le debo todo". Y cómo comenzó en el deporte? Su madre, Diana, se estaba volviendo loca con su hijo hiperactivo, "no paraba de correr", y un pediatra le recomendó que hiciera fútbol. Al tiempo de romperla en su club de barrio, comenzó a ir a las Inferiores de Rosario Central. El predio quedaba a nueve kilometros de su casa, y como no tenían auto, la madre pedaleaba con su bicicleta todos los días para llevar a ángel al entrenamiento.', numberOutput);
END;

-- EXECUTES
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

EXECUTE insertEvent ('Mundial de Futbol Qatar 2022');

EXECUTE insertGroupEvent (1, 'Grupo A');
EXECUTE insertGroupEvent (1, 'Grupo B');

EXECUTE insertCountryTeam (3, 'Espana');
EXECUTE insertCountryTeam (3, 'Francia');
EXECUTE insertCountryTeam (3, 'Alemania');
EXECUTE insertCountryTeam (3, 'Portugal');
EXECUTE insertCountryTeam (2, 'Brasil');
EXECUTE insertCountryTeam (2, 'Argentina');
EXECUTE insertCountryTeam (2, 'Uruguay');
EXECUTE insertCountryTeam (2, 'Costa Rica');

EXECUTE insertTeam(1, 1, 'Espana');
EXECUTE insertTeam(2, 2, 'Francia');
EXECUTE insertTeam(3, 1, 'Alemania');
EXECUTE insertTeam(4, 2, 'Portugal');
EXECUTE insertTeam(5, 1, 'Brasil');
EXECUTE insertTeam(6, 2, 'Argentina');
EXECUTE insertTeam(7, 1, 'Uruguay');
EXECUTE insertTeam(8, 2, 'Costa Rica');

EXECUTE insertGroupStats (1, 2, 1, 1, 20, 15, 10);
EXECUTE insertGroupStats (2, 2, 1, 1, 20, 15, 10);
EXECUTE insertGroupStats (3, 1, 1, 2, 10, 20, 10);
EXECUTE insertGroupStats (4, 1, 1, 2, 10, 20, 10);
EXECUTE insertGroupStats (5, 0, 1, 3, 5, 20, 10);
EXECUTE insertGroupStats (6, 0, 1, 3, 5, 20, 10);
EXECUTE insertGroupStats (7, 0, 0, 4, 2, 20, 10);
EXECUTE insertGroupStats (8, 0, 0, 4, 2, 20, 10);

EXECUTE insertSoccerMatch(1, '04-08-2023 15:35');
EXECUTE insertSoccerMatch(1, '10-10-2023 10:30');
EXECUTE insertSoccerMatch(2, '12-10-2023 8:00');
EXECUTE insertSoccerMatch(2, '14-11-2023 15:40');
EXECUTE insertSoccerMatch(3, '15-02-2023 14:30');
EXECUTE insertSoccerMatch(3, '23-11-2023 18:00');
EXECUTE insertSoccerMatch(4, '10-10-2023 10:30');
EXECUTE insertSoccerMatch(4, '30-01-2023 18:10');
EXECUTE insertSoccerMatch(5, '05-08-2023 13:30');
EXECUTE insertSoccerMatch(5, '9-06-2023 10:30');
EXECUTE insertSoccerMatch(6, '19-03-2023 12:30');
EXECUTE insertSoccerMatch(6, '17-09-2023 13:00');

EXEC insertUserPerson('admin02', 1,'Admin002', 408920922, 'Pedro', 'N/A', 'Rivera', 'N/A', 'Foto Perfil', 11, 2, 3, 'pedro@gmail.com', 63921230, 2, '100 metros al Oeste de la Municipalidad de San Antonio.');
EXEC insertUserPerson('admin01', 'Administrador','Admin001', 305260877, 'Lucia', 'N/A', 'Rodriguez', 'N/A', 'FotoPerfil', 11, 1, 1, 'luchi@gmail.com', 77909041, 6, '200 metros al Este de la plaza Las Flores.');

EXEC insertPlayerXMatchXTeam(2, 5, 7);

EXEC insertUserXNews('admin01', 0);
EXEC insertUserXNews('admin01', 1);
EXEC insertUserXNews('admin01', 2);

EXEC insertFavoriteNews('mario97_AK', 1);
EXEC insertFavoriteNews('admin02', 2);
EXEC insertFavoriteNews('admin01', 3);

EXEC insertRating('admin02', 1, 3);
EXEC insertRating('mario97_AK', 2, 3);
EXEC insertRating('admin01', 3, 5);

EXEC insertNewsComment(1, 'mario97_AK', 'Merecida la copa, todo un campeon');
EXEC insertNewsComment(2, 'mario97_AK', 'Un ejemplo a seguir, buena historia del fideo!');
EXEC insertNewsComment(3, 'mario97_AK', 'Realmente es el mejor contrato en la historia del futbol?');