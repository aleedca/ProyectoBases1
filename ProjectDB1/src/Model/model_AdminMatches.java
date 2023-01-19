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
import Objects.TeamXGroup;
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
    
    private int team1;
    private int team2;
    
    private int idContinent;
    private String nameCountry;
    private String nameTeam;
    private String flag;
    
    
    private int stadium;
    private ArrayList<Stadium> stadiums;
    private int group;
    private ArrayList<Group> groups;
    
    private ArrayList<TeamXGroup> teamxgroup;
    
    private int resultInsertMatch;
    private int resultGroupExist;
    private int resultTeamExist;
    private int resultSoccerMatchExist;
    private int resultinsertTeam;
    
    //BUILDER 

    public model_AdminMatches() {
        try {
            
            this.stadiums = DA_Catalogs.getStadium();
            
            this.groups = DA_Catalogs.getGroup();
            
            this.teamxgroup = DA_SoccerMatch.getTeamXGroup();

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
    
    public void insertTeam(){   
        try {
            DA_SoccerMatch.insertTeam(idContinent, nameCountry, nameTeam, flag);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getTeam1() {
        return team1;
    }

    public void setTeam1(int team1) {
        this.team1 = team1;
    }

    public int getTeam2() {
        return team2;
    }

    public void setTeam2(int team2) {
        this.team2 = team2;
    }

    public int getResultInsertMatch() {
        return resultInsertMatch;
    }

    public void setResultInsertMatch(int resultInsertMatch) {
        this.resultInsertMatch = resultInsertMatch;
    }

    public int getResultGroupExist() {
        return resultGroupExist;
    }

    public void setResultGroupExist(int resultGroupExist) {
        this.resultGroupExist = resultGroupExist;
    }

    public int getResultTeamExist() {
        return resultTeamExist;
    }

    public void setResultTeamExist(int resultTeamExist) {
        this.resultTeamExist = resultTeamExist;
    }

    public int getResultSoccerMatchExist() {
        return resultSoccerMatchExist;
    }

    public void setResultSoccerMatchExist(int resultSoccerMatchExist) {
        this.resultSoccerMatchExist = resultSoccerMatchExist;
    }

    public ArrayList<TeamXGroup> getTeamxgroup() {
        return teamxgroup;
    }

    public void setTeamxgroup(ArrayList<TeamXGroup> teamxgroup) {
        this.teamxgroup = teamxgroup;
    }

    public int getResultinsertTeam() {
        return resultinsertTeam;
    }

    public void setResultinsertTeam(int resultinsertTeam) {
        this.resultinsertTeam = resultinsertTeam;
    }
    
    
    
    

}
