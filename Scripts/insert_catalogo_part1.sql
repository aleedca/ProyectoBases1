/*
 Person -> 20
 Team -> 10
 News -> 10
 Comentarios -> 5
 Reviews -> 5
 Favoritos -> 5

*/
-- paises
INSERT INTO Country (idCountry, nameCountry, userCreation, lastUser, lastDate, dateCreation) 
VALUES (s_country.NEXTVAL, 'Costa Rica', NULL, NULL, NULL, NULL);
INSERT INTO Country (idCountry, nameCountry, userCreation, lastUser, lastDate, dateCreation) 
VALUES (s_country.NEXTVAL, 'Argentina', NULL, NULL, NULL, NULL);
INSERT INTO Country (idCountry, nameCountry, userCreation, lastUser, lastDate, dateCreation) 
VALUES (s_country.NEXTVAL, 'España', NULL, NULL, NULL, NULL);

-- posiciones
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
VALUES (s_personPosition.NEXTVAL, 'Técnico', NULL, NULL, NULL, NULL);
INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
VALUES (s_personPosition.NEXTVAL, 'Cuerpo Técnico', NULL, NULL, NULL, NULL);
INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
VALUES (s_personPosition.NEXTVAL, 'Árbitro', NULL, NULL, NULL, NULL);
INSERT INTO PersonPosition (idPersonPosition, descriptionPersonPosition, userCreation, lastUser, lastDate, dateCreation) 
VALUES (s_personPosition.NEXTVAL, 'Árbitro de lÃ­nea', NULL, NULL, NULL, NULL);

--TypeIdentification
INSERT INTO TypeIdentification (idTypeIdentification, nameTypeIdentification, typeMask, userCreation, lastUser, lastDate, dateCreation) 
VALUES (s_typeIdentification.NEXTVAL, 'Cédula', 'X-XXXX-XXXX', NULL, NULL, NULL, NULL);
INSERT INTO TypeIdentification (idTypeIdentification, typeMask, userCreation, lastUser, lastDate, dateCreation) 
VALUES (s_typeIdentification.NEXTVAL, 'Pasaporte','X-XXXX-XXXX', NULL, NULL, NULL, NULL);

--Gender
INSERT INTO Gender (idGender, descriptionGender, userCreation, lastUser, lastDate, dateCreation) 
VALUES (s_gender.NEXTVAL, 'Femenino', NULL, NULL, NULL, NULL);
INSERT INTO Gender (idGender, descriptionGender, userCreation, lastUser, lastDate, dateCreation) 
VALUES (s_gender.NEXTVAL, 'Masculino', NULL, NULL, NULL, NULL);
INSERT INTO Gender (idGender, descriptionGender, userCreation, lastUser, lastDate, dateCreation) 
VALUES (s_gender.NEXTVAL, 'Otro', NULL, NULL, NULL, NULL);