-- Event
EXEC insertEvent ('Mundial de Futbol Qatar 2022');

-- Groups
EXEC insertGroupEvent (1, 'Grupo A');
EXEC insertGroupEvent (1, 'Grupo B');

-- CountryTeam
EXEC insertCountryTeam (3, 'Espana');
EXEC insertCountryTeam (3, 'Francia');
EXEC insertCountryTeam (3, 'Alemania');
EXEC insertCountryTeam (3, 'Portugal');
EXEC insertCountryTeam (2, 'Brasil');
EXEC insertCountryTeam (2, 'Argentina');
EXEC insertCountryTeam (2, 'Uruguay');
EXEC insertCountryTeam (2, 'Costa Rica');

-- Team
EXEC insertTeam(1, 1, 'Espana');
EXEC insertTeam(2, 2, 'Francia');
EXEC insertTeam(3, 1, 'Alemania');
EXEC insertTeam(4, 2, 'Portugal');
EXEC insertTeam(5, 1, 'Brasil');
EXEC insertTeam(6, 2, 'Argentina');
EXEC insertTeam(7, 1, 'Uruguay');
EXEC insertTeam(8, 2, 'Costa Rica');

-- GroupStats
EXEC insertGroupStats (1, 2, 1, 1, 20, 15, 10);
EXEC insertGroupStats (2, 2, 1, 1, 20, 15, 10);
EXEC insertGroupStats (3, 1, 1, 2, 10, 20, 10);
EXEC insertGroupStats (4, 1, 1, 2, 10, 20, 10);
EXEC insertGroupStats (5, 0, 1, 3, 5, 20, 10);
EXEC insertGroupStats (6, 0, 1, 3, 5, 20, 10);
EXEC insertGroupStats (7, 0, 0, 4, 2, 20, 10);
EXEC insertGroupStats (8, 0, 0, 4, 2, 20, 10);

--- SoccerMatch
EXEC insertSoccerMatch(1, '04-08-2023 15:35');
EXEC insertSoccerMatch(1, '10-10-2023 10:30');
EXEC insertSoccerMatch(2, '12-10-2023 8:00');
EXEC insertSoccerMatch(2, '14-11-2023 15:40');
EXEC insertSoccerMatch(3, '15-02-2023 14:30');
EXEC insertSoccerMatch(3, '23-11-2023 18:00');
EXEC insertSoccerMatch(4, '10-10-2023 10:30');
EXEC insertSoccerMatch(4, '30-01-2023 18:10');
EXEC insertSoccerMatch(5, '05-08-2023 13:30');
EXEC insertSoccerMatch(5, '9-06-2023 10:30');
EXEC insertSoccerMatch(6, '19-03-2023 12:30');
EXEC insertSoccerMatch(6, '17-09-2023 13:00');

--- UserPerson
EXEC insertUserPerson('admin02', 1,'Admin002', 408920922, 'Pedro', 'N/A', 'Rivera', 'N/A', 'Foto Perfil', 11, 2, 3, 'pedro@gmail.com', 63921230, 2, '100 metros al Oeste de la Municipalidad de San Antonio.');

EXEC insertUserPerson('admin01', 'Administrador','Admin001', 305260877, 'Lucia', 'N/A', 'Rodriguez', 'N/A', 'FotoPerfil', 11, 1, 1, 'luchi@gmail.com', 77909041, 6, '200 metros al Este de la plaza Las Flores.');

-- TeamWorker
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
--- Player    
DECLARE numberOutput NUMBER(10);

BEGIN
insertPlayer (105670888, 'Toni', NULL, 'Kroos', NULL, 'Foto Jugador', 3, 1, 2, 3, '04-01-1990', 8, 67892345,'tonito@hotmail.com', 2,'De la calle#33 50 metros al Norte.', numberOutput);     
insertPlayer (809910128, 'Luka', NULL, 'Modric', NULL, 'Foto Jugador', 3, 1, 2, 7, '09-09-1985', 10, 78491355,'modric@yahoo.com', 2,'De la calle#45 100 metros al Sur.', numberOutput);
insertPlayer (901440988, 'Vinicius', NULL, 'Junior', NULL, 'Foto Jugador', 4, 2, 2, 5, '12-07-2000', 20, 83671123,'junior@gmail.com', 2,'De la calle#55 200 metros al Oeste.', numberOutput);  
insertPlayer (704100224, 'Kylian', NULL, 'Mbappé', NULL, 'Foto Jugador', 4, 2, 2, 2, '20-12-1998', 10, 87332385,'kMbappe@gmail.com', 2,'De la calle#33 500 metros al Este.', numberOutput); 
insertPlayer (804440333, 'Vinicius', 'Juan', 'Junior', 'De Oliviera', 'Foto Jugador', 4, 2, 2, 5, '12-07-2000', 20, 83671123,'junior@gmail.com', 2,'De la calle#55 200 metros al Oeste.', numberOutput);  
END;
---EXEC insertPlayer (702210111, '', 'Juan', 'Junior', 'De Oliviera', 'Foto Jugador', 4, 2, 2, 5, TO_DATE('12-07-2000'), 20, 83671123,'junior@gmail.com', 2,'De la calle#55 200 metros al Oeste.');  

--- PlayerXMatchXTeam
EXEC insertPlayerXMatchXTeam(2, 5, 7);

---- NEWS
EXEC insertNews(1, 1, 'Messi Campeon', TO_DATE('04-01-2023 15:33', 'DD-MM-YYYY HH24:MI'), 'linkEjemplo', 'fotomessi', 'Messi campeon del mundo, su actuacion ha sido espectacular en el campo y fuera de ella, gran jugador y persona. Dio todo por un país y sus seguidores.');
EXEC insertNews(2, 4, 'Ronaldo lo ficha un equipo de Arabia Saudita', NULL, 'linkEjemplo', 'fotoronaldo', 'El Al-Nassr es un grande de Arabia, un historico de la Liga de su país, pero no juega esta temporada la Liga de Campeones asiática, pero CR se mostró ilusionado por su nuevo reto: Estoy encantado con una nueva experiencia en una liga diferente y un país diferente, la visión que tiene Al Nassr es muy inspiradora. Estoy muy emocionado de unirme a mis compañeros de equipo y de ayudar a lograr más éxitos');
EXEC insertNews(2, 2, 'DiMaria y su camino a la copa', NULL, 'linkEjemplo', 'fotodimaria', 'Por eso, yo al fútbol le debo todo". Y cómo comenzó en el deporte? Su madre, Diana, se estaba volviendo loca con su hijo hiperactivo, "no paraba de correr", y un pediatra le recomendó que hiciera fútbol. Al tiempo de romperla en su club de barrio, comenzó a ir a las Inferiores de Rosario Central. El predio quedaba a nueve kilometros de su casa, y como no tenían auto, la madre pedaleaba con su bicicleta todos los días para llevar a ángel al entrenamiento.');

--- UserXNews
EXEC insertUserXNews('admin02', 1);
EXEC insertUserXNews('mario97_AK', 2);
EXEC insertUserXNews('admin01', 3);

-- FavoriteNews
EXEC insertFavoriteNews('mario97_AK', 1);
EXEC insertFavoriteNews('admin02', 2);
EXEC insertFavoriteNews('admin01', 3);

--- Rating
EXEC insertRating('admin02', 1, 3);
EXEC insertRating('mario97_AK', 2, 3);
EXEC insertRating('admin01', 3, 5);

--- NewsComments
EXEC insertNewsComment(1, 'mario97_AK', 'Merecida la copa, todo un campeon');
EXEC insertNewsComment(2, 'mario97_AK', 'Un ejemplo a seguir, buena historia del fideo!');
EXEC insertNewsComment(3, 'mario97_AK', 'Realmente es el mejor contrato en la historia del futbol?');



            
            

