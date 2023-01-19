/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Mariana
 */
public class DA_SoccerMatch {
    
    public static int insertSoccerMatch(int idStadium, String date, String hour) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call insertSoccerMatch(?,?)}");
        String dateHour = date+" "+hour;
        //Input parameters
        sql.setInt(1, idStadium);
        sql.setString(2, dateHour);
        
        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(3)).intValue();
        System.out.println("El resultado de la validacion es: "+ result);
        return result;   
    }
    
    
    
}
