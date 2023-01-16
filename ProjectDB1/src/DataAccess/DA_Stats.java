/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;


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
        
        sql.registerOutParameter(1,OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(2);      
        int quantity = 0;
        
        rs.next();
        
        
        return quantity;
    }
    
    
}
