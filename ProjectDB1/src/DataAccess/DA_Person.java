/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Objects.Player;
import Objects.TeamWorker;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Mariana
 */
public class DA_Person {
    private static ResultSet rsAdminPerson;
            
    //GETTER AND SETTER
    public ResultSet getRsAdminPerson() {
        return rsAdminPerson;
    }

    public static void setRsAdminPerson(ResultSet rs) {
        rsAdminPerson = rs;
    }
    
    
    public static void insertUserPerson(String username, String userType,String password, int identification, 
            String firstName, String secondName,String firstLastName, String secondLastName, String photo, 
            int idTypeIdentification, int idGender, String mail, 
            int phoneNumber, int idDistrict, String address) throws SQLException
    {
        Connection conn = sysConnection.getConexion();
                

        PreparedStatement sql = conn.prepareStatement("{ call insertUserPerson(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        //Input parameters
        sql.setString(1,username);
        sql.setString(2, userType);
        sql.setString(3, password);
        sql.setInt(4, identification);
        sql.setString(5, firstName);
        
        if("".equals(secondName)){
            sql.setString(6, "N/A");
        }else{
            sql.setString(6, secondName);
        }
        
        sql.setString(7, firstLastName);
        
        
        if("".equals(secondLastName)){
            sql.setString(8, "N/A");
        }else{
            sql.setString(8, secondLastName);
        }

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
        System.out.println("El resultado de la validacion es: "+ result);
        return result;   
    }
    
    public static int validateIdentification(int identification) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call  validateIdentAlreadyExists(?,?)}");
        //Input parameters
        sql.setInt(1, identification);
        
        //Output parameter
        sql.registerOutParameter(2, OracleTypes.NUMBER);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(2)).intValue();
        System.out.println("El resultado de la validacion es: "+ result);
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
        
        if("".equals(secondName)){
            sql.setString(3, "N/A");
        }else{
            sql.setString(3, secondName);
        }
        
        sql.setString(4, firstLastName);
        
        if("".equals(secondLastName)){
            sql.setString(5, "N/A");
        }else{
            sql.setString(5, secondLastName);
        }       
        
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
        
        if("".equals(secondName)){
            sql.setString(4, "N/A");
        }else{
            sql.setString(4, secondName);
        }
        
        sql.setString(5, firstLastName);
        
        if("".equals(secondLastName)){
            sql.setString(6, "N/A");
        }else{
            sql.setString(6, secondLastName);
        }    
        
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
    
    //----------------- EDIT ADMINPERSON --------------------------------------
   
    public static int updateFirstName(int idPerson, String firstName) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateFirstName(?,?,?)}");
        //Input parameters
        sql.setInt(1, idPerson);
        sql.setString(2, firstName);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
   
    public static int updateSecondName(int idPerson, String secondName) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateSecondName(?,?,?)}");
        //Input parameters
        sql.setInt(1, idPerson);
        sql.setString(2, secondName);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    public static int updateFirstLastName(int idPerson, String firstLastName) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateFirstLastName(?,?,?)}");
        //Input parameters
        sql.setInt(1, idPerson);
        sql.setString(2, firstLastName);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    public static int updateSecondLastName(int idPerson, String secondLastName) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateSecondLastName(?,?,?)}");
        //Input parameters
        sql.setInt(1, idPerson);
        sql.setString(2, secondLastName);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    
    public static int updateTypeIdentification(int idPerson, int typeIdentification) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateTypeIdentification(?,?,?)}");
        //Input parameters
        sql.setInt(1, idPerson);
        sql.setInt(2, typeIdentification);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    
    public static int updateIdentification(int idPerson, int identification) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateIdentification(?,?,?)}");
        //Input parameters
        sql.setInt(1, idPerson);
        sql.setInt(2, identification);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result; 
    }
    
    public static int updateMail(int idPerson, String mail) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateMail(?,?,?)}");
        //Input parameters
        sql.setInt(1, idPerson);
        sql.setString(2, mail);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    
    public static int updateTeam(int idPerson, int idTeam) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateTeam(?,?,?)}");
        //Input parameters
        sql.setInt(1, idPerson);
        sql.setInt(2, idTeam);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    
    public static int updatePosition(int idPerson, int idPosition) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updatePersonPosition(?,?,?)}");
        //Input parameters
        sql.setInt(1, idPerson);
        sql.setInt(2, idPosition);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    
    public static int updatePhone(int idPerson, int phoneNumber) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updatePhone(?,?,?)}");
        //Input parameters
        sql.setInt(1, idPerson);
        sql.setInt(2, phoneNumber);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    
    public static int updateGender(int idPerson, int idGender) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateGender(?,?,?)}");
        //Input parameters
        sql.setInt(1, idPerson);
        sql.setInt(2, idGender);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    public static int updateAddress(int idPerson, String address) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateAddress(?,?,?)}");
        //Input parameters
        sql.setInt(1, idPerson);
        sql.setString(2, address);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    
    public static int updateDistrict(int idAddress, int idDistrict) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateDistrict(?,?,?)}");
        //Input parameters
        sql.setInt(1, idAddress);
        sql.setInt(2, idDistrict);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;  
    }
    
    
    public static int updateCanton(int idDistrict, int idCanton) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateCanton(?,?,?)}");
        //Input parameters
        sql.setInt(1, idDistrict);
        sql.setInt(2, idCanton);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;  
    }
    
    
    public static int updateProvince(int idCanton, int idProvince) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateProvince(?,?,?)}");
        //Input parameters
        sql.setInt(1,idCanton );
        sql.setInt(2, idProvince);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;  
    }
    
    
    public static int updateCountry(int idProvince, int idCountry) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateCountry(?,?,?)}");
        //Input parameters
        sql.setInt(1,idProvince );
        sql.setInt(2, idCountry);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;  
    }
    
    
    public static int updatePhoto(int idPerson, String photo) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updatePhoto(?,?,?)}");
        //Input parameters
        sql.setInt(1,idPerson );
        sql.setString(2, photo);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;  
    }
    
    public static int updateBirthDate(int idPerson, String birthdate) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateBirthDate(?,?,?)}");
        //Input parameters
        sql.setInt(1,idPerson );
        sql.setString(2, birthdate);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    public static int updateTShirtNum(int idPerson, int tShirtNum) throws SQLException
    {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateTShirtNum(?,?,?)}");
        //Input parameters
        sql.setInt(1,idPerson );
        sql.setInt(2, tShirtNum);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;   
    }
    
    //-------------------------------------------------------------------------------------------
    public static ArrayList<Player> getPlayer() throws SQLException 
    {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getPlayer(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Player> players = new ArrayList<>();
        while(rs.next()){
            Player player = new Player();
            
            player.setIdPerson(rs.getInt("idPerson"));
            player.setFirstName(rs.getString("firstName"));
            player.setSecondName(rs.getString("secondName"));
            player.setFirstLastName(rs.getString("firstLastName"));
            player.setSecondLastName(rs.getString("secondLastName"));
            
            players.add(player);
        }

        return players;
    }
    
    
    public static ArrayList<TeamWorker> getTeamWorker() throws SQLException 
    {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getTeamWorker(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<TeamWorker> teamWorkers = new ArrayList<>();
        while(rs.next()){
            TeamWorker teamWorker = new TeamWorker();
            
            teamWorker.setIdPerson(rs.getInt("idPerson"));
            teamWorker.setFirstName(rs.getString("firstName"));
            teamWorker.setSecondName(rs.getString("secondName"));
            teamWorker.setFirstLastName(rs.getString("firstLastName"));
            teamWorker.setSecondLastName(rs.getString("secondLastName"));
            
            teamWorkers.add(teamWorker);
        }

        return teamWorkers;
    }
    
    
    //------------------------------------------------------------------------------------
    
    
    public static ArrayList<Player> getPlayerInformation() throws SQLException{
            ArrayList<Player> players = new ArrayList<>();
            while(rsAdminPerson.next()){
                Player player = new Player();
            
                player.setFirstName(rsAdminPerson.getString("firstName"));
                player.setSecondName(rsAdminPerson.getString("secondName"));
                player.setFirstLastName(rsAdminPerson.getString("firstLastName"));
                player.setSecondLastName(rsAdminPerson.getString("secondLastName"));
                player.setIdentification(rsAdminPerson.getInt("identification"));
                player.setIdTypeIdentification(rsAdminPerson.getInt("idTypeIdentification"));
                player.setIdPersonPosition(rsAdminPerson.getInt("idPersonPosition"));
                player.setPhoto(rsAdminPerson.getString("photo"));
                player.setIdGender(rsAdminPerson.getInt("idGender"));
                player.setIdCountry(rsAdminPerson.getInt("idCountry"));
                player.setIdProvince(rsAdminPerson.getInt("idProvince"));
                player.setIdCanton(rsAdminPerson.getInt("idCanton"));
                player.setIdDistrict(rsAdminPerson.getInt("idDistrict"));
                player.setDescriptonAddress(rsAdminPerson.getString("descriptionAddress"));
                player.setMail(rsAdminPerson.getString("descriptionMail"));
                player.setPhoneNumber(rsAdminPerson.getInt("phoneNumber"));
                player.setIdTeam(rsAdminPerson.getInt("idTeam"));
                player.setBirthdate(rsAdminPerson.getString("birthdate"));
                player.setNumTShirt(rsAdminPerson.getInt("TshirtNum"));
            
                players.add(player);
                System.out.println(player.toString());
            }
            return players;
    }
    
    
    public static ArrayList<TeamWorker> getTeamWorkerInformation() throws SQLException 
    {
        ArrayList<TeamWorker> teamWorkers = new ArrayList<>();
        while(rsAdminPerson.next()){
            TeamWorker teamWorker = new TeamWorker();
            
            teamWorker.setFirstName(rsAdminPerson.getString("firstName"));
            teamWorker.setSecondName(rsAdminPerson.getString("secondName"));
            teamWorker.setFirstLastName(rsAdminPerson.getString("firstLastName"));
            teamWorker.setSecondLastName(rsAdminPerson.getString("secondLastName"));
            teamWorker.setIdentification(rsAdminPerson.getInt("identification"));
            teamWorker.setIdTypeIdentification(rsAdminPerson.getInt("idTypeIdentification"));
            teamWorker.setIdPersonPosition(rsAdminPerson.getInt("idPersonPosition"));
            teamWorker.setPhoto(rsAdminPerson.getString("photo"));
            teamWorker.setIdGender(rsAdminPerson.getInt("idGender"));
            teamWorker.setIdCountry(rsAdminPerson.getInt("idCountry"));
            teamWorker.setIdProvince(rsAdminPerson.getInt("idProvince"));
            teamWorker.setIdCanton(rsAdminPerson.getInt("idCanton"));
            teamWorker.setIdDistrict(rsAdminPerson.getInt("idDistrict"));
            teamWorker.setDescriptonAddress(rsAdminPerson.getString("descriptionAddress"));
            teamWorker.setMail(rsAdminPerson.getString("descriptionMail"));
            teamWorker.setPhoneNumber(rsAdminPerson.getInt("phoneNumber"));
            teamWorker.setIdTeam(rsAdminPerson.getInt("idTeam"));  

            teamWorkers.add(teamWorker);
            System.out.println(teamWorker.toString());
        }

        return teamWorkers;
    }
 
    public static int getPersonInformation(int idPerson) throws SQLException 
    {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getPersonInformation(?,?,?)}");
        //INPUT
        System.out.println("Parametro: "+idPerson);
        sql.setInt(1, idPerson);
        
        //OUTPUT
        sql.registerOutParameter(2, OracleTypes.REF_CURSOR);
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(2);
        setRsAdminPerson(rs);
        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }

}
