/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Objects.TeamList;
import Objects.Gender;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Nahomy
 */
public class DA_TeamList {
    
    public static ArrayList<TeamList> getTeamList(String teamName, String playerFstName, String playerSndName, String playerFstLastName, String playerSndLastName, String position) throws SQLException {
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call getTeamList(?,?,?,?,?,?,?)}");
        
        System.out.println("Comienza if-anidados");
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
        
        System.out.println("Termina if-anidados");
        
        // output parameters
        sql.registerOutParameter(7, OracleTypes.REF_CURSOR);
        
        sql.execute();
        
        
        ResultSet rs = (ResultSet) sql.getObject(7);

        System.out.println("Obtuvo el objeto");
        ArrayList<TeamList> teamList = new ArrayList<>();
        System.out.println("Creo el arraylist");
        
        while(rs.next()){
            System.out.println("Entro al while");
            TeamList team = new TeamList();

            team.setFirstName(rs.getString("firstName"));
            team.setSecondName(rs.getString("secondName"));
            team.setFirstLastname(rs.getString("firstLastname"));
            team.setSecondLastname(rs.getString("secondLastname"));
            team.setPhoto(rs.getString("photo"));
            team.setPosition(rs.getString("descriptionPersonPosition"));

            teamList.add(team);
            System.out.println(team.toString());
        }
        System.out.println("Termina ejecucion");
        return teamList;
    }
    
}
