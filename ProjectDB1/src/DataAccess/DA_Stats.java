/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;


import Objects.AuthorReview;
import Objects.DashboardStats;
import Objects.PlayerStats;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public static ArrayList<PlayerStats> getTopGoalScorers() throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getTopNGoalScorer(?,?)}");
        
        sql.registerOutParameter(1,OracleTypes.NUMBER);
        sql.registerOutParameter(2,OracleTypes.REF_CURSOR);
        sql.execute();
        
        int topN = ((BigDecimal) sql.getObject(1)).intValue();
        
        ResultSet rs = (ResultSet) sql.getObject(2);
        ArrayList<PlayerStats> goalers = new ArrayList<>();
        int counter = 0;
        while(rs.next() && counter < topN){
            PlayerStats goaler = new PlayerStats();
            
            goaler.setName(rs.getString("fullName"));
            goaler.setGoals(rs.getInt("totalGoals"));
            
            goalers.add(goaler);
            counter++;
        }
        return goalers;
    }
    
    public static ArrayList<PlayerStats> getTopGoalKeepers() throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getTopNGoalKeepers(?,?)}");
        
        sql.registerOutParameter(1,OracleTypes.NUMBER);
        sql.registerOutParameter(2,OracleTypes.REF_CURSOR);
        sql.execute();
        
        int topN = ((BigDecimal) sql.getObject(1)).intValue();
        
        ResultSet rs = (ResultSet) sql.getObject(2);
        ArrayList<PlayerStats> keepers = new ArrayList<>();
        int counter = 0;
        while(rs.next() && counter < topN){
            PlayerStats keeper = new PlayerStats();
            
            keeper.setName(rs.getString("fullName"));
            keeper.setSaves(rs.getInt("totalSaves"));
            
            keepers.add(keeper);
            counter++;
        }
        return keepers;
    }
    
    public static ArrayList<Integer> getPlayedMatches() throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getPlayedMatches(?,?)}");
        
        sql.registerOutParameter(1,OracleTypes.NUMBER);
        sql.registerOutParameter(2,OracleTypes.NUMBER);
        sql.execute();
        
        int playedMatches = ((BigDecimal) sql.getObject(1)).intValue();
        int totalMatches = ((BigDecimal) sql.getObject(2)).intValue();
        
        ArrayList<Integer> matches = new ArrayList<>();
        matches.add(playedMatches);
        matches.add(totalMatches);
        return matches;
    }
    
    
    public static ArrayList<AuthorReview> getAverageRating() throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getAverageReviewsAuthor(?)}");
        sql.registerOutParameter(1,OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<AuthorReview> authorReviews = new ArrayList<>();
        while(rs.next()){
            AuthorReview authorRating = new AuthorReview();
            
            authorRating.setUsername(rs.getString("username"));
            authorRating.setAverageRating(rs.getInt("average"));
            
            authorReviews.add(authorRating);
        }
        
        return authorReviews;
    }
    
    public static ArrayList getAgeRangeTotals(int idGender, int idTeam) throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getTotalPlayersXAge(?,?,?)}");
        
        if(idGender == 0){
            sql.setString(1, null);
        }else{
            sql.setInt(1, idGender);
        }
        
        if(idTeam == 0){
            sql.setString(2, null);
        }else{
            sql.setInt(2, idTeam);
        }
        
        sql.registerOutParameter(3,OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(3);
        ArrayList quantities = new ArrayList();
        while(rs.next()){
            
            int quantity = rs.getInt("quantity");
            
            quantities.add(quantity);
        }
        
        return quantities;
    }
    
    public static DashboardStats getDashboardStats() throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getDashboardNumbers(?,?,?,?)}");
        sql.registerOutParameter(1,OracleTypes.NUMBER);
        sql.registerOutParameter(2,OracleTypes.NUMBER);
        sql.registerOutParameter(3,OracleTypes.NUMBER);
        sql.registerOutParameter(4,OracleTypes.NUMBER);
        sql.execute();
        
        float goals = ((BigDecimal) sql.getObject(1)).floatValue();
        float saves = ((BigDecimal) sql.getObject(2)).floatValue();
        float yellowCards = ((BigDecimal) sql.getObject(3)).floatValue();
        float redCards = ((BigDecimal) sql.getObject(4)).floatValue();
        
        DashboardStats stats = new DashboardStats();
        
        stats.setGoalsPerMatch(goals);
        stats.setRedCardsPerMatch(redCards);
        stats.setSavesPerMatch(saves);
        stats.setYellowCardsPerMatch(yellowCards);
        
        return stats;
    }
    
}
