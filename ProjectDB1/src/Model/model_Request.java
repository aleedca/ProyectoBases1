/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Catalogs;
import Objects.Event;
import Objects.Position;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nahomy
 */
public class model_Request {
    
    private int position;
    private ArrayList<Position> positions;
    
    private int event;
    private ArrayList<Event> events;

    public model_Request() {
        try {
            this.positions = DA_Catalogs.getPosition();
            
            this.events = DA_Catalogs.getEvent();
           
        } catch (SQLException ex) {
             System.out.println(ex);
        }
    }
    
    
    //getters and setters

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
