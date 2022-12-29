-- Stadium
INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_stadium.NEXTVAL, 1, 'Estadio Nacional', NULL, NULL, NULL, NULL);
INSERT INTO Stadium(idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_stadium.NEXTVAL, 1, 'Estadio Ricardo Saprissa Aymá¡', NULL, NULL, NULL, NULL);

INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_stadium.NEXTVAL, 2, 'La Bombonera', NULL, NULL, NULL, NULL); 
INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_stadium.NEXTVAL, 2, 'Luna Park', NULL, NULL, NULL, NULL);

INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_stadium.NEXTVAL, 3, 'Santiago Bernabéu', NULL, NULL, NULL, NULL);
INSERT INTO Stadium(idStadium, idCountry, nameStadium, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_stadium.NEXTVAL, 3, 'CampNou', NULL, NULL, NULL, NULL);

-- NewsStatus
INSERT INTO NewsStatus(idNewsStatus, descriptionNewsStatus, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_newsStatus.NEXTVAL, 'Publicado', NULL, NULL, NULL, NULL);

INSERT INTO NewsStatus(idNewsStatus, descriptionNewsStatus, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_newsStatus.NEXTVAL, 'Pendiente', NULL, NULL, NULL, NULL);

-- Continent
INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_continent.NEXTVAL, 'África', NULL, NULL, NULL, NULL);

INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_continent.NEXTVAL, 'América', NULL, NULL, NULL, NULL);

INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_continent.NEXTVAL, 'Europa', NULL, NULL, NULL, NULL);

INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_continent.NEXTVAL, 'Asia', NULL, NULL, NULL, NULL);

INSERT INTO Continent(idContinent, nameContinent, userCreation, lastUser, lastDate, dateCreation)
VALUES(s_continent.NEXTVAL, 'Europa', NULL, NULL, NULL, NULL);