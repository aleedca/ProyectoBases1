/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Objects.Account;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Isaac
 */
public class DA_MyAccount {
    
    
    
    public static Account getAccountInfo(String pUsername) throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getAccountInformation(?,?)}");
        
        sql.setString(1, pUsername); 
        sql.registerOutParameter(2,OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(2);      
        Account accountInformation = new Account();
        
        rs.next();
        
        String name = rs.getString("firstName");
        String name2 = rs.getString("secondName");
        String lastname1 = rs.getString("firstLastName");
        String lastname2 = rs.getString("secondLastName");
        
        accountInformation.setUsername(pUsername);
        
        accountInformation.setEmail(rs.getString("descriptionMail"));
        
        accountInformation.setPassword(rs.getString("passwordUser"));
        
        accountInformation.setGender(rs.getString("descriptionGender"));
        
        accountInformation.setIdentification(rs.getInt("identification"));
        
        accountInformation.setPhoneNumber(rs.getInt("phoneNumber"));
                
        accountInformation.setFirstName(name);
        
        accountInformation.setSndName(name2);
        
        accountInformation.setFirstLastName(lastname1);
        
        accountInformation.setSndLastName(lastname2);
        
        return accountInformation;
    }
    
}
