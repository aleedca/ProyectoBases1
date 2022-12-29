CREATE PROCEDURE removeAll (pidEvent IN NUMBER) AS
---vnIdGroupEvent NUMBER(10);
BEGIN

    DELETE FROM News
    WHERE EXISTS
    (SELECT e.idEvent FROM News N
    INNER JOIN SoccerMatch SM ON sm.idSoccerMatch = ewm.idSoccerMatch
    INNER JOIN Pla GE ON ge.idGroupEvent = t.idGroupEvent
    INNER JOIN Event E ON e.idEvent = ge.idEvent
    WHERE e.idEvent = pidEvent);
   


   
    DELETE FROM PlayerXSoccerMatchXTeam 
    WHERE EXISTS
    (SELECT e.idEvent FROM PlayerXSoccerMatchXTeam PMT 
    INNER JOIN Team T ON t.idTeam = pmt.idTeam
    INNER JOIN GroupEvent GE ON ge.idGroupEvent = t.idGroupEvent
    INNER JOIN Event E ON e.idEvent = ge.idEvent
    WHERE e.idEvent = pidEvent);



  

    

    DELETE FROM Event 
    WHERE EXISTS
    (SELECT idEvent 
    FROM Event E 
    INNER JOIN GroupEvent GE ON e.idEvent = ge.idEvent
    INNER JOIN Team T ON t.idGroupEvent = ge.idGroupEvent
    WHERE e.idEvent = pidEvent);
    
    COMMIT;
END removeAll;

