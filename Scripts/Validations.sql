---codError OUT NUMBER

CREATE OR REPLACE PROCEDURE verifyUser(pUsername IN NUMBER, pPassword IN VARCHAR2) AS
vnUsername NUMBER;
vcPasssword VARCHAR2;
    CURSOR curVerifyUser IS
    SELECT username, passwordUser
    FROM UserPerson 
    WHERE (username = pUsername)AND(passwordUser = pPassword);
    
    BEGIN
        OPEN curVerifyUser;
        LOOP
            FETCH curVerifyUser INTO vnUsername, vcPasssword;
                dbms_output.put_line(vnUsername|| '-' || vcPasssword);
            EXIT WHEN curVerifyUser%NOTFOUND;
        END LOOP;
    CLOSE curVerifyUser;
END verifyUser;

------------------- INSERTIONS TESTING ----------------------------------------
EXEC insertUserPerson(admin01,1, Admin001, 305380824, Mariana, 
            NULL, Fernández, Martínez, 'scr/Images/prueba.jpg', 11, 
            1,1, 'mfernandezmar3@gmail.com', 86262341,
            6, 'Una direccion');
            
EXEC insertUserPerson(usuario01, 2, Usuario012, 109320123, Julio, 
            NULL, Hernández, NULL, 'Una foto', 11, 2, 
            1,2, 'mfernandezmar3@gmail.com', 86262341,
            18, 'Unadirecciondeotropais');
            
EXEC insertUserPerson(usuario02, 2, Usuario03, 801230456, Rosa, 
            NULL, Arias, NULL, 'Una foto', 11, 3, 
            2,3, 'mfernandezmar3@gmail.com', 86262341,
            18, 'Unadirecciondeotropais')
            
            