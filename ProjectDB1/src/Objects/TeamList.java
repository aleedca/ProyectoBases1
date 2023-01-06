/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;


public class TeamList {
    
    String firstName;
    String secondName;
    String firstLastname;
    String secondLastname;
    String photo; 
    String position;

    public TeamList() {
    }

    public TeamList(String firstName, String secondName, String firstLastname, String secondLastname, String photo, String position) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastname = firstLastname;
        this.secondLastname = secondLastname;
        this.photo = photo;
        this.position = position;
    }
    
    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstLastname() {
        return firstLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "TeamList{" + "firstName=" + firstName + ", secondName=" + secondName + ", firstLastname=" + firstLastname + ", secondLastname=" + secondLastname + ", position=" + position + ", photo=" + photo + '}';
    }

}
