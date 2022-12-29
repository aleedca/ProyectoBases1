CREATE PROCEDURE removeAll (pidEvent IN NUMBER) AS
---vnIdGroupEvent NUMBER(10);
BEGIN
    DELETE FROM Event 
    WHERE EXISTS
    (
    SELECT idEvent 
    FROM Event E 
    INNER JOIN GroupEvent GE ON e.idEvent = ge.idEvent
    INNER JOIN Team T ON t.idGroupEvent = ge.idGroupEvent
    WHERE e.idEvent = pidEvent
    );
    COMMIT;
END removeAll;

