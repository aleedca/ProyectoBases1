/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Nahomy
 */
public class Position {
   private int idPersonPosition;
   private String descriptionPersonPosition;
   private String userCreation;
   private String lastUser;
   private String lastDate;
   private String dateCreation;

    public Position() {
    }

    public Position(int idPersonPosition, String descriptionPersonPosition, String userCreation, String lastUser, String lastDate, String dateCreation) {
        this.idPersonPosition = idPersonPosition;
        this.descriptionPersonPosition = descriptionPersonPosition;
        this.userCreation = userCreation;
        this.lastUser = lastUser;
        this.lastDate = lastDate;
        this.dateCreation = dateCreation;
    }

    public void setIdPersonPosition(int idPersonPosition) {
        this.idPersonPosition = idPersonPosition;
    }

    public void setDescriptionPersonPosition(String descriptionPersonPosition) {
        this.descriptionPersonPosition = descriptionPersonPosition;
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

    public int getIdPersonPosition() {
        return idPersonPosition;
    }

    public String getDescriptionPersonPosition() {
        return descriptionPersonPosition;
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
    
    
   
   
   
}
