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