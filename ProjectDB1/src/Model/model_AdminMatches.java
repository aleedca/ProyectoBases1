/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Catalogs;
import DataAccess.DA_SoccerMatch;
import Objects.Continent;
import Objects.CountryTeam;
import Objects.Group;
import Objects.Stadium;
import Objects.TeamXGroup;
import View.JF_AdminOther;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Nahomy
 */
public class model_AdminMatches {
    
    //Attributes to insert a Team -> ADMIN OTHER SCREEN
    private int idCountryTeam;
    private String nameTeam;
    private String flag;
    
    private ArrayList<Continent> continents;
    private ArrayList<CountryTeam> countryTeams;
    
    //--------------------------------------------------------
    
    private String date;
    private String hour;
    
    private int team1;
    private int team2;
        
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
    
    
    private final JFileChooser file = new JFileChooser();
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
   
    
    //BUILDER 

    public model_AdminMatches() {
        try {
            
            this.stadiums = DA_Catalogs.getStadium();
            
            this.groups = DA_Catalogs.getGroup();
            
            this.teamxgroup = DA_SoccerMatch.getTeamXGroup();
            
            this.continents = DA_SoccerMatch.getContinet();
            
            this.countryTeams = DA_Catalogs.getCountryTeam();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    //----------------------------------------------------------------------
        public boolean selectPhoto(JF_AdminOther teamRegister){
        file.setFileFilter(this.filter);
        file.showOpenDialog(teamRegister);
        try{
            flag = file.getSelectedFile().getPath();
            return true;
        }catch(NullPointerException e){
            System.out.println("No se ha seleccionado ningún fichero");
        } 
        
        return false;
    }
    
    
    public void setImageLabel(JLabel labelName){
        ImageIcon image = new ImageIcon(this.flag);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
    }
    
    
    //----------------------------------------------------------------------

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
            DA_SoccerMatch.insertTeam(idCountryTeam, nameTeam, flag);
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

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public ArrayList<Continent> getContinents() {
        return continents;
    }

    public void setContinents(ArrayList<Continent> continents) {
        this.continents = continents;
    }

    public ArrayList<CountryTeam> getCountryTeams() {
        return countryTeams;
    }

    public void setCountryTeams(ArrayList<CountryTeam> countryTeams) {
        this.countryTeams = countryTeams;
    }

    public int getIdCountryTeam() {
        return idCountryTeam;
    }

    public void setIdCountryTeam(int idCountryTeam) {
        this.idCountryTeam = idCountryTeam;
    }
    
    
    
    

}
