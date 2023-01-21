/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;


import Objects.Continent;
import Objects.TeamXGroup;
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
        System.out.println("El resultado del insertSoccerMatch es: "+ result);
        return result;   
    }
    
    public static void insertPlayerXMatchXTeam(int idSoccerMatch, int idTeam1, int idTeam2) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        PreparedStatement sql = conn.prepareStatement("{call insertPlayerXMatchXTeam(?,?,?)}");
        //INPUT
        sql.setInt(1, idSoccerMatch);
        sql.setInt(2, idTeam1);
        sql.setInt(3, idTeam2);

        sql.execute();
    }

    
    public static void updateSoccerMatch(int idPlayer, int YellowCards, int redCards, int offsides, int corners, int saves, int goals) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        PreparedStatement sql = conn.prepareStatement("{call updateSoccerMatch(?,?,?,?,?,?,?)}");
        //INPUT
        sql.setInt(1, idPlayer);
        sql.setInt(2, YellowCards);
        sql.setInt(3, redCards);
        sql.setInt(4, offsides);
        sql.setInt(5, corners);
        sql.setInt(6, saves);
        sql.setInt(7, goals);

        sql.execute();
    }
    
    
    
    
    
    public static ArrayList<TeamXGroup> getTeamXGroup() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getTeamXGroup(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<TeamXGroup> teamsxgroups = new ArrayList<>();
        while(rs.next()){
            TeamXGroup teamXgroup = new TeamXGroup();
            
            teamXgroup.setIdTeamXGroup(rs.getInt("idTeamXGroup"));
            teamXgroup.setIdTeam(rs.getInt("idTeam"));
            teamXgroup.setIdGroup(rs.getInt("idGroupEvent"));
            teamsxgroups.add(teamXgroup);
        }

        return teamsxgroups;
    }
    
    
    public static ArrayList<Continent> getContinet() throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getContinent(?)}");
        
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Continent> continents = new ArrayList<>();
        while(rs.next()){
            Continent continent = new Continent();
            
            continent.setIdContinent(rs.getInt("idContinent"));
            continent.setNameContinent(rs.getString("nameContinent"));
            continents.add(continent);
        }

        return continents;
    }
    
    
    public static void insertTeam(int idCountryTeam, String nameTeam, String flag) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        PreparedStatement sql = conn.prepareStatement("{call insertTeam(?,?,?)}");
        //INPUT
        sql.setInt(1, idCountryTeam);
        sql.setString(2, nameTeam);
        sql.setString(3, flag);

        sql.execute();
    }
    
    
    
    
    
    
    
    
    //------------------ VALIDATIONS ---------------------------------------
    
    public static int validateGroupExist() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call validateGroupExist(?)}");
        
        //Output parameter
        sql.registerOutParameter(1, OracleTypes.NUMBER);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(1)).intValue();
        System.out.println("El resultado de la validacion de GRUPOS es: "+ result);
        return result;   
    }
    
    public static int validateTeamExist() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call validateTeamExist(?)}");
        
        //Output parameter
        sql.registerOutParameter(1, OracleTypes.NUMBER);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(1)).intValue();
        System.out.println("El resultado de la validacion de EQUIPOS es: "+ result);
        return result;   
    }
    
    
    public static int validateSoccerMatchExist() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call validateSoccerMatchExist(?)}");
        
        //Output parameter
        sql.registerOutParameter(1, OracleTypes.NUMBER);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(1)).intValue();
        System.out.println("El resultado de la validacion de PARTIDOS es: "+ result);
        return result;   
    }
    
    
    
    
    
    
}
