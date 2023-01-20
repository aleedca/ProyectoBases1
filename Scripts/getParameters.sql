--getInfoParameters(nameParameter)
--getParameters
--updateParameters(...)

CREATE OR REPLACE PROCEDURE getParameters (curParameter OUT SYS_REFCURSOR) IS
BEGIN
    OPEN curParameter FOR
    SELECT nameParameter, valueParameter
    FROM ParameterTable;
END getParameters;

CREATE OR REPLACE PROCEDURE getInfoParameters(pNameParameter IN VARCHAR, pidParameter OUT NUMBER, curParameter OUT SYS_REFCURSOR) IS
BEGIN
    SELECT idParameterTable
    INTO pidParameter
    FROM ParameterTable
    WHERE nameParameter = pNameParameter;

    OPEN curParameter FOR
    SELECT nameParameter, valueParameter
    FROM ParameterTable
    WHERE nameParameter = pNameParameter;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        pidParameter := SQLCODE;   
END getInfoParameters;

CREATE OR REPLACE PROCEDURE updateParameter(pIdParameter IN NUMBER, pNameParameter IN VARCHAR, pValueParameter IN NUMBER, codResult OUT NUMBER) AS
BEGIN
    UPDATE ParameterTable
    SET nameParameter = pNameParameter
    WHERE idParameterTable = pIdParameter;
    
    UPDATE ParameterTable
    SET valueParameter = pValueParameter
    WHERE idParameterTable = pIdParameter;
    
    codResult:= 0;
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updateParameter;

--procedimiento que valide si el nombre ya existe