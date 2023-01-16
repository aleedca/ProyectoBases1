/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Objects.Team;
import Objects.TeamList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;


public class DA_TeamList {
    
    public static ArrayList<TeamList> getTeamList(String teamName, String playerFstName, String playerSndName, String playerFstLastName, String playerSndLastName, String position) throws SQLException {
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call getTeamList(?,?,?,?,?,?,?)}");
        
        // input parameters
        if (teamName!=""){
          sql.setString(1, teamName);  
        } else if (teamName==""){
          sql.setString(1, null);  
        }
        
        if (playerFstName!=""){
          sql.setString(2, playerFstName);  
        } else if (playerFstName==""){
          sql.setString(2, null);  
        }
        
        if (playerSndName!=""){
          sql.setString(3, playerSndName);  
        } else if (playerSndName==""){
          sql.setString(3, "N/A");  
        }
        
        if (playerFstLastName!=""){
          sql.setString(4, playerFstLastName); 
        } else if (playerFstLastName==""){
          sql.setString(4, null);  
        }
        
        if (playerSndLastName!=""){
          sql.setString(5, playerSndLastName);
        } else if (playerSndLastName==""){
          sql.setString(5, "N/A");  
        }
        
        if (position!=""){
          sql.setString(6, position);
        } else{
          sql.setString(6, null);  
        }
        
        // output parameters
        sql.registerOutParameter(7, OracleTypes.REF_CURSOR);
        
        sql.execute();
        
        
        ResultSet rs = (ResultSet) sql.getObject(7);
        ArrayList<TeamList> teamList = new ArrayList<>();
        
        while(rs.next()){
            TeamList team = new TeamList();

            team.setFirstName(rs.getString("firstName"));
            team.setSecondName(rs.getString("secondName"));
            team.setFirstLastname(rs.getString("firstLastname"));
            team.setSecondLastname(rs.getString("secondLastname"));
            team.setPhoto(rs.getString("photo"));
            team.setPosition(rs.getString("descriptionPersonPosition"));

            teamList.add(team);
        }
        return teamList;
    }
    
}
