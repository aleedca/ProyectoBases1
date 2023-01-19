/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Catalogs;
import DataAccess.DA_SoccerMatch;
import Objects.Gender;
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
    private int stadium;
    private ArrayList<Stadium> stadiums;
    
    private int gender;
    private ArrayList<Gender> genders;
    
    private int team;
    private ArrayList<Team> teams;
    
    private int group;
    private ArrayList<Group> groups;
    
    private int resultInsertMatch;
    
    //BUILDER 

    public model_AdminMatches() {
        try {
            this.stadiums = DA_Catalogs.getStadium();
        } catch (SQLException ex) {
            Logger.getLogger(model_AdminMatches.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fillScheduleMatch(){
        try {
            this.genders = DA_Catalogs.getGender();

            this.teams = DA_Catalogs.getTeam();

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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public ArrayList<Gender> getGenders() {
        return genders;
    }

    public void setGenders(ArrayList<Gender> genders) {
        this.genders = genders;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
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
