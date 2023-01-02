CREATE OR REPLACE PROCEDURE getGender(curGender OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curGender FOR
    SELECT idGender, descriptionGender
    FROM Gender;

END getGender;