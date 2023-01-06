/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Nahomy
 */
public class Event {
    private int idEvent;
    private String typeEvent;
    private String userCreation;
    private String lastUser;
    private String lastDate;
    private String dateCreation; 

    public Event() {
    }

    public Event(int idEvent, String typeEvent, String userCreation, String lastUser, String lastDate, String dateCreation) {
        this.idEvent = idEvent;
        this.typeEvent = typeEvent;
        this.userCreation = userCreation;
        this.lastUser = lastUser;
        this.lastDate = lastDate;
        this.dateCreation = dateCreation;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public void setTypeEvent(String typeEvent) {
        this.typeEvent = typeEvent;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public String getTypeEvent() {
        return typeEvent;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public String getLastUser() {
        return lastUser;
    }

    public String getLastDate() {
        return lastDate;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    @Override
    public String toString() {
        return "Event{" + "idEvent=" + idEvent + ", typeEvent=" + typeEvent + ", userCreation=" + userCreation + ", lastUser=" + lastUser + ", lastDate=" + lastDate + ", dateCreation=" + dateCreation + '}';
    }
    
    
}
