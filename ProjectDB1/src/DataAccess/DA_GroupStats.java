/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

/**
 *
 * @author Isaac
 */


import Objects.Group;
import Objects.TeamGroupStats;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;


public class DA_GroupStats {
    
    public static Group getGroupStats(int pGroupId) throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getGroupStats(?,?)}");
        
        sql.setInt(1, pGroupId); 
        sql.registerOutParameter(2,OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(2);      
        ArrayList<TeamGroupStats> groupArray = new ArrayList<>();
       
        while(rs.next()){
            
            String teamName = rs.getString("nameTeam");
            int wonMatches = rs.getInt("wonMatches");
            int drawMatches = rs.getInt("tiedMatches");
            int lostMatches = rs.getInt("lostMatches");
            int goalsScored = rs.getInt("goalsScored");
            int goalsReceived = rs.getInt("goalsReceived");
            int fairPlayPoints  =rs.getInt("fairPlayPoints");
            
            TeamGroupStats teamForGroup = new TeamGroupStats(teamName, wonMatches, drawMatches, lostMatches, goalsScored, goalsReceived, fairPlayPoints);
            groupArray.add(teamForGroup);
        }
        
        Group group = new Group();
        
        for(int i = 0; i < groupArray.size(); i++){
            if(i == 0){
                group.setTeam1(groupArray.get(i));
            }
            else if(i == 1){
                group.setTeam2(groupArray.get(i));
            }
            else if(i == 2){
                group.setTeam3(groupArray.get(i));
            }
            else if(i == 3){
                group.setTeam4(groupArray.get(i));
            }
        }
        
        return group; 
  
    }
}
