/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Catalogs;
import DataAccess.DA_Person;
import Objects.Position;
import Objects.Team;
import View.JF_AdminPerson;
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
 * @author Mariana
 */
public class model_AdminPerson {
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private int identification;
    private String mail;
    private int phone;
    private String address;
    private int gender;
    private int typeIdentification;
    private int country;
    private int province;
    private int canton;
    private int district;
    private String photo;
    private String dateOfBirth;
    private int numTShirt;
    private int resultInsertPerson;
    
    private int position;
    private ArrayList<Position> positions;
    
    private int team;
    private ArrayList<Team> teams;
   
    
    private final JFileChooser file = new JFileChooser();
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");;
    
    //-------- BUILDER ---------
    public model_AdminPerson(){
        
        try {
            this.positions = DA_Catalogs.getPosition();
            
            this.teams = DA_Catalogs.getTeam();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //--------- METHODS ---------------------------
    public boolean validateEmptyFieldsAdminPerson() {
        if(this.firstName.isEmpty() || this.firstLastName.isEmpty()){
            return true;
        }else{
            if(this.address.isEmpty() || this.mail.isEmpty()){
                return true;
            }
        }
       
        return false;
    }
     
    public boolean selectPhotoAdminPerson(JF_AdminPerson adminPerson){
        file.setFileFilter(this.filter);
        file.showOpenDialog(adminPerson);
        try{
            photo = file.getSelectedFile().getPath();
            return true;
        }catch(NullPointerException e){
            System.out.println("No se ha seleccionado ningún fichero");
        } 
        
        return false;
    }
    
    public void setImageAdminPerson(JLabel labelName){
        ImageIcon image = new ImageIcon(this.photo);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
    }
    
      
    public void inserPlayer(){
        try {   
            this.resultInsertPerson = DA_Person.insertPlayer(identification, firstName, secondName, firstLastName, secondLastName, photo, 
                    position, typeIdentification, gender, team, 
                    this.dateOfBirth, numTShirt, phone, mail, district, address);
        
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void inserTeamWorker(){
        try {   
            this.resultInsertPerson = DA_Person.insertTeamWorker(identification, firstName, secondName, firstLastName, 
                    secondLastName, photo, position, typeIdentification, gender, 
                    team, phone, district, mail, address);
        
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    //GETTERS AND SETTERS
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

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getTypeIdentification() {
        return typeIdentification;
    }

    public void setTypeIdentification(int typeIdentification) {
        this.typeIdentification = typeIdentification;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCanton() {
        return canton;
    }

    public void setCanton(int canton) {
        this.canton = canton;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getNumTShirt() {
        return numTShirt;
    }

    public void setNumTShirt(int numTShirt) {
        this.numTShirt = numTShirt;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public FileNameExtensionFilter getFilter() {
        return filter;
    }

    public void setFilter(FileNameExtensionFilter filter) {
        this.filter = filter;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    public int getResultInsertPerson() {
        return resultInsertPerson;
    }
    
    
    

    
    
    
    
}
