/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;


import Objects.Continent;
import Objects.Match;
import Objects.MatchPlayer;
import Objects.PlayerStats;
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
        
        CallableStatement sql = conn.prepareCall("{call insertSoccerMatch(?,?,?)}");
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
    
    public static int getTeamUnits() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call validateNumberOfUnits(?)}");
        //Output parameter
        sql.registerOutParameter(1, OracleTypes.NUMBER);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(1)).intValue();
        return result;   
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

    public static void insertTeam(int idCountryTeam, String nameTeam, String flag) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        PreparedStatement sql = conn.prepareStatement("{call insertTeam(?,?,?)}");
        //INPUT
        sql.setInt(1, idCountryTeam);
        sql.setString(2, nameTeam);
        sql.setString(3, flag);

        sql.execute();
    }

    public static void generateRaffle(int TotalGroup) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        PreparedStatement sql = conn.prepareStatement("{call generateRaffle(?,?)}");
        //INPUT
        sql.setInt(1, TotalGroup);
        sql.setInt(2, 1);

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
    
    public static int validateEnoughPlayers(int idTeam) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call validateEnoughPlayers(?,?)}");
        
        //Output parameter
        sql.setInt(1, idTeam);
        sql.registerOutParameter(2, OracleTypes.NUMBER);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(2)).intValue();
        System.out.println("El resultado de la validacion de PARTIDOS es: "+ result);
        return result;   
    }
    
    public static ArrayList<Match> getTodayMatches() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getTodaySoccerMatches(?)}");
        
        //Output parameter
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Match> todayMatches = new ArrayList<>();
        Match tmpMatch = new Match();
        while(rs.next()){
            if("".equals(tmpMatch.getNameTeam1())){
               tmpMatch.setNameTeam1(rs.getString("nameteam"));
               tmpMatch.setHour(rs.getString("datehour").substring(11));
            }else if(!"".equals(tmpMatch.getNameTeam1()) && "".equals(tmpMatch.getNameTeam2())){
               tmpMatch.setNameTeam2(rs.getString("nameteam"));
               todayMatches.add(tmpMatch);
               tmpMatch = new Match();
            }
        }

        return todayMatches;
    }
    
    public static ArrayList<Match> getMatches() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getSoccerMatches(?)}");
        
        //Output parameter
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Match> Matches = new ArrayList<>();
        Match tmpMatch = new Match();
        while(rs.next()){
            if("".equals(tmpMatch.getNameTeam1())){
               tmpMatch.setIdMatch(rs.getInt("idSoccerMatch"));
               tmpMatch.setNameTeam1(rs.getString("nameteam"));
               tmpMatch.setDate(rs.getString("datehour").substring(0, 11));
               tmpMatch.setHour(rs.getString("datehour").substring(11));
               tmpMatch.setStadium(rs.getString("nameStadium"));
               tmpMatch.setGroupName(rs.getString("descriptionGroupEvent"));
               tmpMatch.setIdTeam1(rs.getInt("idTeam"));
            }else if(!"".equals(tmpMatch.getNameTeam1()) && "".equals(tmpMatch.getNameTeam2())){
               tmpMatch.setNameTeam2(rs.getString("nameteam"));
               tmpMatch.setIdTeam2(rs.getInt("idTeam"));
               Matches.add(tmpMatch);
               tmpMatch = new Match();
            }
        }

        return Matches;
    }
    
    
    public static boolean raffledPerformed() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call validateRaffledPerformed(?)}");
        
        //Output parameter
        sql.registerOutParameter(1, OracleTypes.NUMBER);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(1)).intValue();

        if(result == 1){
            return true;
        }else{
            return false;
        }
    }
    
    public static ArrayList<MatchPlayer> getPlayersFromATeam(int idTeam) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getPlayersFromATeam(?,?)}");
        
        //Output parameter
        sql.setInt(1, idTeam);
        sql.registerOutParameter(2, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(2);
        ArrayList<MatchPlayer> players = new ArrayList<>();
        
        while(rs.next()){
            MatchPlayer player = new MatchPlayer();
            
            player.setIdPlayer(rs.getInt("idPerson"));
            player.setFullName(rs.getString("fullName"));
            
            players.add(player);   
        }
        return players;
    }

    //getPlayerStatsXMatch
    
    
    public static PlayerStats getPlayerStatsXMatch(int idPlayer, int idMatch) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getPlayerStatsXMatch(?,?,?)}");
        
        //Output parameter
        sql.setInt(1, idPlayer);
        sql.setInt(2, idMatch);
        sql.registerOutParameter(3, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(3);
        
        rs.next();
        PlayerStats stats = new PlayerStats();
        
        stats.setRedCards(rs.getInt("redcards"));
        stats.setGoals(rs.getInt("goals"));
        stats.setYellowCards(rs.getInt("yellowcards"));
        stats.setSaves(rs.getInt("saves"));
        stats.setCorners(rs.getInt("corners"));
        stats.setOffsides(rs.getInt("offsides"));
        
        return stats;
    }
    
    public static void updateSoccerMatch(int idMatch, int idPlayer, int yellowcards, int redcards, int offsides, int corners, int saves, int goals) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call updateSoccerMatch(?,?,?,?,?,?,?,?)}");
        
        //Output parameter
        sql.setInt(1, idMatch);
        sql.setInt(2, idPlayer);
        sql.setInt(3, yellowcards);
        sql.setInt(4, redcards);
        sql.setInt(5, offsides);
        sql.setInt(6, corners);
        sql.setInt(7, saves);
        sql.setInt(8, goals);
        sql.execute();
    }
    
}
