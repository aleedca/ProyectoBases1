/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Isaac
 */
public class DA_Stats {
    
    public static int getTotalPublishedNews() throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        
        
        CallableStatement sql = conn.prepareCall("{call getTotalPublishedNews(?)}");
        
        sql.registerOutParameter(1,OracleTypes.NUMBER);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(1)).intValue();
        
        return result;
    }
    
    public static float getAverageRating() throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getAverageReviewsAuthor(?)}");
        sql.registerOutParameter(1,OracleTypes.REF_CURSOR);
        sql.execute();
        
        float result = ((BigDecimal) sql.getObject(2)).intValue();
        
        return result;
    }
    
    
    
}
