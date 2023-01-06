/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;


import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Mariana
 */
public class DA_Person {
    
    public static void insertUserPerson(String username, String password, int identification, 
            String firstName, String secondName,String firstLastName, String secondLastName, String photo, 
            int idTypeIdentification, int idGender, String mail, 
            int phoneNumber, int idDistrict, String address) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        PreparedStatement sql = conn.prepareStatement("{ call insertUserPerson(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        //Input parameters
        sql.setString(1,username);
        sql.setInt(2, 2);
        sql.setString(3, password);
        sql.setInt(4, identification);
        sql.setString(5, firstName);
        sql.setString(6, secondName);
        sql.setString(7, firstLastName);
        sql.setString(8, secondLastName);
        sql.setString(9, photo);
        sql.setInt(10, 11);
        sql.setInt(11, idTypeIdentification);
        sql.setInt(12, idGender);
        sql.setString(13, mail);
        sql.setInt(14, phoneNumber);
        sql.setInt(15, idDistrict);
        sql.setString(16, address);
        
        System.out.println("Entro a la ejecucion");
        sql.execute();
        System.out.println("Termino la ejecucion");
    }
    
    
    public static int validateUserType(String username, String password) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call  validateUser(?,?,?)}");
        //Input parameters
        sql.setString(1, username);
        sql.setString(2, password);
        
        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();
        
        System.out.println(sql.getObject(3));
        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;   
        
        /*Codigo para probar esta funcion
            try {
            int resultUserType = validateUserType("mario97_AK", "patitoW80");
            System.out.println("\nEl resultado es: "+resultUserType);

            }catch (SQLException ex) {
                System.out.println(ex);
            }
        */
    }
    
    
}
