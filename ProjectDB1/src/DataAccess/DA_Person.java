/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Mariana
 */
public class DA_Person {
    
    public static void insertPerson(int identification, String firstName, String secondName,String firstLastName, 
            String secondLastName, String photo, int idPersonPosition,  int idCountry, int idTypeIdentification, int idGender) throws SQLException
    {
        Connection conn = sysConnection.getConexion();
        
        //PreparedStatement sql = conn.prepareStatement("{}");
        
        //sql.setString(firstName);
    
    }
    
    
}
