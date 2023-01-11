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
public class Player extends Person {
    private String birthdate;
    private int numTShirt;
    private int idTeam;
    
    //--------------- BUILDER ---------------------------

    public Player() {
    }

    public Player(String birthdate, int numTShirt, int idTeam, int idPerson, int idPersonPosition, int idAddress, int idTypeIdentification, int idGender, int identification, String firstName, String secondName, String firstLastName, String secondLastName, String photo, String mail, int phoneNumber, int idCountry, int idProvince, int idCanton, int idDistrict, String userCreation, LocalDateTime dateCreation, String lastUser, LocalDateTime lastDate) {
        super(idPerson, idPersonPosition, idAddress, idTypeIdentification, idGender, identification, firstName, secondName, firstLastName, secondLastName, photo, mail, phoneNumber, idCountry, idProvince, idCanton, idDistrict, userCreation, dateCreation, lastUser, lastDate);
        this.birthdate = birthdate;
        this.numTShirt = numTShirt;
        this.idTeam = idTeam;
    }
     
    
    
    //GETTERS AND SETTERS
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getNumTShirt() {
        return numTShirt;
    }

    public void setNumTShirt(int numTShirt) {
        this.numTShirt = numTShirt;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }


    
    


    
    
    
}
