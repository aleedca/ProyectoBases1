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

        sql.execute();
    }
    
    
    public static int validateUserAlreadyExists(String username) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call  validateUserAlreadyExists(?,?)}");
        //Input parameters
        sql.setString(1, username);
        
        //Output parameter
        sql.registerOutParameter(2, OracleTypes.NUMBER);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(2)).intValue();
        return result;   
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
    

    
    public static int insertPlayer(int identification, String firstName, String secondName,
            String firstLastName, String secondLastName, String photo, 
            int idPosition, int idTypeIdentification, int idGender, int idTeam, String birthdate, 
            int numTShirt, int phoneNumber, String mail, int idDistrict, String address) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call insertPlayer(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        //Input parameters
        sql.setInt(1, identification);
        sql.setString(2, firstName);
        sql.setString(3, secondName);
        sql.setString(4, firstLastName);
        sql.setString(5, secondLastName);
        sql.setString(6, photo);
      
        sql.setInt(7, idPosition);
        sql.setInt(8, idTypeIdentification);
        sql.setInt(9, idGender);
        sql.setInt(10, idTeam);
        
        sql.setString(11, birthdate);
        sql.setInt(12, numTShirt);
        sql.setInt(13, phoneNumber);
        
        sql.setString(14, mail);
        sql.setInt(15, idDistrict);
        sql.setString(16, address);
        
        //Output parameter
        sql.registerOutParameter(17, OracleTypes.NUMBER);
        System.out.println("Entro a la ejecucion");
        sql.execute();

        int result = ((BigDecimal) sql.getObject(17)).intValue();
        System.out.println("Termino la ejecucion");
        return result;  
    }
    

    public static int insertTeamWorker(int identification, int idTeam, String firstName, String secondName,
            String firstLastName, String secondLastName, String photo, 
            int idPosition, int idTypeIdentification, int idGender, int phoneNumber, 
            int idDistrict, String mail, String address) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call insertTeamWorker(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        //Input parameters
        sql.setInt(1, identification);
        sql.setInt(2, idTeam);
        sql.setString(3, firstName);
        sql.setString(4, secondName);
        sql.setString(5, firstLastName);
        sql.setString(6, secondLastName);
        sql.setString(7, photo);
      
        sql.setInt(8, idPosition);
        sql.setInt(9, idTypeIdentification);
        sql.setInt(10, idGender);

        sql.setInt(11, phoneNumber);
        sql.setInt(12, idDistrict);
        sql.setString(13, mail);
        sql.setString(14, address);
        
        //Output parameter
        sql.registerOutParameter(15, OracleTypes.NUMBER);
        System.out.println("Entro a la ejecucion");
        sql.execute();

        int result = ((BigDecimal) sql.getObject(15)).intValue();
        System.out.println("Termino la ejecucion");
        return result;  
    }
    
    
    
    
    
    
    
    
    
}
