/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;


import Objects.GroupList;
import Objects.CountryTeam;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;


public class DA_GroupList {
    
    
            
    public static ArrayList<GroupList> getGroupList(String teamName, String matchDate, String stadium, String teamFlag) throws SQLException {
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call getGroupList(?,?,?,?,?)}");
        
        //Input parameters
        if (teamName!=""){
          sql.setString(2, teamName);  
        } else if (teamName==""){
          sql.setString(2, null);  
        }
        
        if (matchDate!=""){
          sql.setString(3, matchDate);  
        } else if (matchDate==""){
          sql.setString(3, null);  
        }
        
        if (stadium!=""){
          sql.setString(4, stadium);  
        } else if (stadium==""){
          sql.setString(4, null);  
        }
        
        if (teamFlag!=""){
          sql.setString(5, teamFlag);  
        } else if (teamFlag==""){
          sql.setString(5, null);  
        }
        
        //Output parameters
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<GroupList> groupList = new ArrayList<>();
        
        while(rs.next()){
            GroupList group = new GroupList();
            
            group.setTeamName(rs.getString("nameTeam"));
            group.setMatchDate(rs.getString("dateHour"));
            group.setStadium(rs.getString("nameStadium"));
            group.setTeamFlag(rs.getString("flag"));
            
            groupList.add(group);
        }
        return groupList;
    }
    
    //FALTA CORREGIR 
    public static ArrayList<CountryTeam> getCountryTeam() throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call getCountryTeam(?)}");
        
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<CountryTeam> countryTeam= new ArrayList<>();
        while(rs.next()){
            CountryTeam country = new CountryTeam();
            
            country.setIdCountryTeam(rs.getInt("idCountryTeam"));
            country.setIdContinent(rs.getInt("idContinent"));
            country.setNameCountryTeam(rs.getString("nameCountryTeam"));
            //country.setTeamFlag(rs.getString("flag"));
            
            countryTeam.add(country);
        }
        return countryTeam;
    }
}
