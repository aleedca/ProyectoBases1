/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.time.LocalDateTime;

/**
 *
 * @author Mariana
 */
public class Person {
    private int idPerson;
    private int idPersonPosition;
    private int idAddress;
    private int idTypeIdentification;
    private int idGender;
    
    private int identification;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String photo;
    
    private String userCreation;
    private LocalDateTime dateCreation;
    private String lastUser;
    private LocalDateTime lastDate;

    //------------- BUILDERS -----------------
    public Person() {
    }

    public Person(int idPerson, int idPersonPosition, int idAddress, int idTypeIdentification, int idGender, int identification, String firstName, String secondName, String firstLastName, String secondLastName, String photo, String userCreation, LocalDateTime dateCreation, String lastUser, LocalDateTime lastDate) {
        this.idPerson = idPerson;
        this.idPersonPosition = idPersonPosition;
        this.idAddress = idAddress;
        this.idTypeIdentification = idTypeIdentification;
        this.idGender = idGender;
        this.identification = identification;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.photo = photo;
        this.userCreation = userCreation;
        this.dateCreation = dateCreation;
        this.lastUser = lastUser;
        this.lastDate = lastDate;
    }
    
    


    
    
    //GETTERS AND SETTERS

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdPersonPosition() {
        return idPersonPosition;
    }

    public void setIdPersonPosition(int idPersonPosition) {
        this.idPersonPosition = idPersonPosition;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }
    

    public int getIdTypeIdentification() {
        return idTypeIdentification;
    }

    public void setIdTypeIdentification(int idTypeIdentification) {
        this.idTypeIdentification = idTypeIdentification;
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }

    public LocalDateTime getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDateTime lastDate) {
        this.lastDate = lastDate;
    }
    

    
}
