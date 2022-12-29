--- UserType
INSERT INTO UserType(idUserType, descriptionUserType, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_usertype.nextval, 'Administrador', NULL, NULL, NULL, NULL);

INSERT INTO UserType(idUserType, descriptionUserType, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_usertype.nextval, 'Usuario', NULL, NULL, NULL, NULL);

--- NewsType
INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_newsType.nextval, 'Opinion', NULL, NULL, NULL, NULL);

INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_newsType.nextval, 'Historia', NULL, NULL, NULL, NULL);

INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_newsType.nextval, 'Reseña', NULL, NULL, NULL, NULL);

INSERT INTO NewsType(idNewsType, descriptionNewsType, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_newsType.nextval, 'Fichajes', NULL, NULL, NULL, NULL);

--- Province
INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_province.nextval, 1,'San José', NULL, NULL, NULL, NULL);

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
VALUES (s_province.nextval, 1,'Limón', NULL, NULL, NULL, NULL);

------------------------------------------------------------------------------------------

INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_province.nextval, 2,'Mendoza', NULL, NULL, NULL, NULL);

-------------------------------------------------------------------------------------------

INSERT INTO Province(idProvince, idCountry, nameProvince, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_province.nextval, 3,'Barcelona', NULL, NULL, NULL, NULL);

-------------------------------------------------------------------------------------------

--- Canton
INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 1,'Escazú', NULL, NULL, NULL, NULL);

INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 2,'Flores', NULL, NULL, NULL, NULL);

INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 2,'Barva', NULL, NULL, NULL, NULL);

INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 3,'Oreamuno', NULL, NULL, NULL, NULL);
INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 3,'Jiménez', NULL, NULL, NULL, NULL);

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

------------------------------------------------------------------------------------------

INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 8,'Santa Rosa', NULL, NULL, NULL, NULL);

INSERT INTO Canton(idCanton, idProvince, nameCanton, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 9,'Cataluña', NULL, NULL, NULL, NULL);

--- District
-- Escazú
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 1,'San Antonio', NULL, NULL, NULL, NULL);
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 1,'San Rafael', NULL, NULL, NULL, NULL);

-- Flores
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 2,'Barrantes', NULL, NULL, NULL, NULL);

-- Barva
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 3,'San Pablo', NULL, NULL, NULL, NULL);

-- Oreamuno
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 4,'Cipreses', NULL, NULL, NULL, NULL);

-- Jiménez
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 5,'Pejibaye', NULL, NULL, NULL, NULL);
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval, 5,'Tucurrique', NULL, NULL, NULL, NULL);

-- Atenas
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval,6,'Escobal', NULL, NULL, NULL, NULL);

--- Santa Cruz
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval,7,'Tamarindo', NULL, NULL, NULL, NULL);
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval,7,'Cartagena', NULL, NULL, NULL, NULL);

-- Bagaces
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval,8,'La Fortuna', NULL, NULL, NULL, NULL);
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval,8,'Mogote', NULL, NULL, NULL, NULL);

--- Esparza
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval,9,'Espíritu Santo', NULL, NULL, NULL, NULL);

-- Buenos Aires
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval,10, 'Boruca', NULL, NULL, NULL, NULL);

-- Talamanca
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval,11, 'Sixaola', NULL, NULL, NULL, NULL);
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval,11, 'Cahuita', NULL, NULL, NULL, NULL);

--- Santa Rosa
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval,12, 'Villa Cabecera', NULL, NULL, NULL, NULL);

--- Cataluña
INSERT INTO District(idDistrict, idCanton, nameDistrict, userCreation, lastUser, lastDate, dateCreation)
VALUES (s_canton.nextval,12, 'Guardiola', NULL, NULL, NULL, NULL);




