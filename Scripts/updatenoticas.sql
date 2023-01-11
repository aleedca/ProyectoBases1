----------------------------------------- NEWS -----------------------------------------
-- Status
CREATE OR REPLACE PROCEDURE updateStatus(pIdNews IN NUMBER, pIdNewsStatus) AS
BEGIN
    UPDATE News
    SET idNewsStatus = pIdNewsStatus
    WHERE idNews = pIdNews;
    
    codResult:= 0;
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updateEstado;

-- Type
CREATE OR REPLACE PROCEDURE updateType(pIdNews IN NUMBER, pIdNewsType IN NUMBER) AS
BEGIN
    UPDATE News
    SET idNewsType = pIdNewsType
    WHERE idNews = pIdNews;
    
    codResult:= 0;
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updateType;

-- Title
CREATE OR REPLACE PROCEDURE updateTitle(pIdNews IN NUMBER, pTitle IN VARCHAR2) AS
BEGIN
    UPDATE News
    SET title = pTitle;
    WHERE idNews = pIdNews;
    
    codResult:= 0;
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updateTitle;

-- Text
CREATE OR REPLACE PROCEDURE updateText(pIdNews IN NUMBER, pText IN VARCHAR2) AS
BEGIN
    UPDATE News
    SET textNews = pText;
    WHERE idNews = pIdNews;
    
    codResult:= 0;
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updateText;

-- Photo
CREATE OR REPLACE PROCEDURE updatePhoto(pIdNews IN NUMBER, pPhoto IN VARCHAR2) AS
BEGIN
    UPDATE News
    SET photo = pPhoto;
    WHERE idNews = pIdNews;
    
    codResult:= 0;
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        codResult := SQLCODE;   
END updatePhoto;