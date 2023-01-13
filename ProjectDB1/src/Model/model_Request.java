/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Catalogs;
import Objects.CountryTeam;
import Objects.Event;
import Objects.Position;
import Objects.Stadium;
import java.sql.SQLException;
import java.util.ArrayList;





public class model_Request {
    
    private int stadium;
    private ArrayList<Stadium> stadiums;
    
    private int position;
    private ArrayList<Position> positions;
    
    private int event;
    private ArrayList<Event> events;
    
    private int countryTeam;
    private ArrayList<CountryTeam> countryTeams;

    //----------------- BUILDER ----------------- 
    public model_Request() {
        try {
            this.positions = DA_Catalogs.getPosition();
            
            this.events = DA_Catalogs.getEvent();
            
            this.countryTeams = DA_Catalogs.getCountryTeam();
            
            this.stadiums = DA_Catalogs.getStadium();
           
        } catch (SQLException ex) {
             System.out.println(ex);
        }
    }
    //--------------- VALIDATIONS ---------------
    
    
    
    //------------GETTERS AND SETTERS------------

    public int getPosition() {
        return position;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public int getEvent() {
        return event;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public int getCountryTeam() {
        return countryTeam;
    }

    public ArrayList<CountryTeam> getCountryTeams() {
        return countryTeams;
    }

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

    public void setCountryTeam(int countryTeam) {
        this.countryTeam = countryTeam;
    }

    public void setCountryTeams(ArrayList<CountryTeam> countryTeams) {
        this.countryTeams = countryTeams;
    }
    
    public void setPosition(int position) {
        this.position = position;
    }

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
   
}
