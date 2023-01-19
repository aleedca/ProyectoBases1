/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Isaac
 */
public class Account {
    
    private String username;
    private String password;
    private String firstName;
    private String sndName;
    private String firstLastName;
    private String sndLastName;
    private int identification;
    private String gender;
    private String email;
    private int phoneNumber;
    private String photoUrl;
    
    public Account(){
        this.username = "";
        this.password = "";
        this.firstName = "";
        this.sndName = "";
        this.firstLastName = "";
        this.sndLastName = "";
        this.identification = 0;
        this.gender = "";
        this.email = "";
        this.phoneNumber = 0;
        this.photoUrl = "";
    }

    public Account(String username, String password, String firstName, String sndName, String firstLastName, String sndLastName, int identification, String gender, String email, int phoneNumber, String pPhotoUrl) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.sndName = sndName;
        this.firstLastName = firstLastName;
        this.sndLastName = sndLastName;
        this.identification = identification;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.photoUrl = pPhotoUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSndName() {
        return sndName;
    }

    public void setSndName(String sndName) {
        this.sndName = sndName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSndLastName() {
        return sndLastName;
    }

    public void setSndLastName(String sndLastName) {
        this.sndLastName = sndLastName;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    
}
