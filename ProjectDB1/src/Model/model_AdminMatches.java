/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Catalogs;
import DataAccess.DA_SoccerMatch;
import Objects.Group;
import Objects.Stadium;
import Objects.Team;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Nahomy
 */
public class model_AdminMatches {
    private String date;
    private String hour;
    private int team;
    
    private int stadium;
    private ArrayList<Stadium> stadiums;
    
    
    
    private int group;
    private ArrayList<Group> groups;
    
    private int resultInsertMatch;
    private int resultGroupExist;
    private int resultTeamExist;
    private int resultSoccerMatchExist;
    
    //BUILDER 

    public model_AdminMatches() {
        try {
            
            this.stadiums = DA_Catalogs.getStadium();
            
            this.groups = DA_Catalogs.getGroup();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void fillMatch(){
    
    
    }
    
    public boolean insertMatch(){
        try {
            
            this.resultInsertMatch = DA_SoccerMatch.insertSoccerMatch(stadium, date, hour);
            
            if(this.resultInsertMatch == 0){
                return true;
            }
                        
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return false;
    }
    
    public boolean validateGroupExist(){
        try {
            this.resultGroupExist = DA_SoccerMatch.validateGroupExist();
            
            if(this.resultGroupExist == 0){
                return true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return false;
    }
    
    public boolean validateTeamExist(){
        try {
            this.resultTeamExist = DA_SoccerMatch.validateTeamExist();
            
            if(this.resultTeamExist == 0){
                return true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return false;
    }
    
    
    public boolean validateSoccerMatchExist(){
        try {
            this.resultSoccerMatchExist = DA_SoccerMatch.validateSoccerMatchExist();
            
            if(this.resultSoccerMatchExist == 0){
                return true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return false;
    }
    
    
    
    
    //--------------GETTERS AND SETTERS--------------

    public int getStadium() {
        return stadium;
    }

    public ArrayList<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadium(int stadium) {
        this.stadium = stadium;
    }

    public void setStadiums(ArrayList<Stadium> stadiums) {
        this.stadiums = stadiums;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

}
