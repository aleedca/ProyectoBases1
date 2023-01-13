/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Catalogs;
import DataAccess.DA_Person;
import Objects.Player;
import Objects.Position;
import Objects.Team;
import Objects.TeamWorker;
import View.JF_AdminPerson;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private int resultUpdateFirstName = 0;
    private int resultUpdateSecondName = 0;
    private int resultUpdateFirstLastName = 0;
    private int resultUpdateSecondLastName = 0;
    private int resultUpdateTypeIdentification = 0;
    private int resultUpdateIdentification = 0;
    
    private int resultUpdatePhone = 0;
    private int resultUpdateMail = 0;
    private int resultUpdateAddress = 0;
    
    private int resultUpdateGender = 0;
        private int resultUpdateTeam = 0;
    private int resultUpdatePosition = 0;
    
    private int resultUpdateCountry = 0;
    private int resultUpdateProvince = 0;
    private int resultUpdateCanton= 0;
     private int resultUpdateDistrict = 0;
    
    
    private int resultUpdateNumTShirt = 0;
    private int resultUpdateBirthdate= 0;
    
    private int position;
    private ArrayList<Position> positions;
    
    private int team;
    private ArrayList<Team> teams;
    
    private ArrayList<Player> playersComboBox;
    private ArrayList<TeamWorker> teamWorkersComboBox;
    
    private ArrayList<Player> playersInfo;
    private ArrayList<TeamWorker> teamWorkersInfo;
    
    private int resultEditPerson;
   
    
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
            this.resultInsertPerson = DA_Person.insertTeamWorker(identification, team, firstName, secondName, firstLastName, secondLastName, photo, 
                    position, typeIdentification, gender, phone, district, mail, address);
        
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    public void getPerson(){
        try {
            this.playersComboBox = DA_Person.getPlayer();
            
            this.teamWorkersComboBox = DA_Person.getTeamWorker();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void getPersonInformation(int idPerson){
        try {
            this.resultEditPerson = DA_Person.getPersonInformation(idPerson);
            System.out.println("El resultado es: " + this.resultEditPerson);
            
            if(resultEditPerson == 0){
                System.out.println("Entro a cargar Player");
                this.playersInfo = DA_Person.getPlayerInformation();
            }else{
            
                if(resultEditPerson == 1){
                    System.out.println("Entro a cargar TeamWorker");
                    this.teamWorkersInfo = DA_Person.getTeamWorkerInformation();
                }
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    
    //----------------- UPDATES -----------------------------------
    public void updateFirstName(int idPerson, String name){
        try {
            System.out.println("Llama al DA");
            this.resultUpdateFirstName = DA_Person.updateFirstName(idPerson, name);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
   
    public void updateSecondName(int idPerson, String name){
        try {
            this.resultUpdateSecondName = DA_Person.updateSecondName(idPerson, name);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateFirstLastName(int idPerson, String name){
        try {
            this.resultUpdateFirstLastName = DA_Person.updateFirstLastName(idPerson, name);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateSecondLastName(int idPerson, String name){
        try {
            this.resultUpdateSecondLastName = DA_Person.updateSecondLastName(idPerson, name);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateIdentification(int idPerson, int ident){
        try {
            this.resultUpdateIdentification = DA_Person.updateIdentification(idPerson, ident);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateMail(int idPerson, String mail){
        try {
            this.resultUpdateMail = DA_Person.updateMail(idPerson, mail);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updatePhone(int idPerson, int phone){
        try {
            this.resultUpdatePhone = DA_Person.updatePhone(idPerson, phone);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateAddress(int idPerson, String address){
        try {
            this.resultUpdateAddress = DA_Person.updateAddress(idPerson, address);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateNumTShirt(int idPerson, int num){
        try {
            this.resultUpdateNumTShirt = DA_Person.updateTShirtNum(idPerson, num);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateBirthDate(int idPerson, String birthdate){
        try {
            this.resultUpdateBirthdate = DA_Person.updateBirthDate(idPerson, birthdate);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateTypeIdentification(int idPerson, int type){
        try {
            this.resultUpdateTypeIdentification = DA_Person.updateTypeIdentification(idPerson, type);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateGender(int idPerson, int gender){
        try {
            this.resultUpdateGender = DA_Person.updateGender(idPerson, gender);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateTeam(int idPerson, int team){
        try {
            this.resultUpdateTeam = DA_Person.updateTeam(idPerson, team);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updatePosition(int idPerson, int position){
        try {
            this.resultUpdatePosition = DA_Person.updatePosition(idPerson, position);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateCountry(int idPerson, int country){
        try {
            this.resultUpdateCountry = DA_Person.updateCountry(idPerson, country);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateProvince(int idPerson, int province){
        try {
            this.resultUpdateProvince = DA_Person.updateProvince(idPerson, province);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateCanton(int idPerson, int canton){
        try {
            this.resultUpdateCanton = DA_Person.updateCanton(idPerson, canton);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateDistrict(int idPerson, int district){
        try {
            this.resultUpdateDistrict = DA_Person.updateDistrict(idPerson, district);
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

    public ArrayList<Player> getPlayersComboBox() {
        return playersComboBox;
    }

    public void setPlayersComboBox(ArrayList<Player> playersComboBox) {
        this.playersComboBox = playersComboBox;
    }

    public ArrayList<TeamWorker> getTeamWorkersComboBox() {
        return teamWorkersComboBox;
    }

    public void setTeamWorkersComboBox(ArrayList<TeamWorker> teamWorkersComboBox) {
        this.teamWorkersComboBox = teamWorkersComboBox;
    }

    public ArrayList<Player> getPlayersInfo() {
        return playersInfo;
    }

    public void setPlayersInfo(ArrayList<Player> playersInfo) {
        this.playersInfo = playersInfo;
    }

    public ArrayList<TeamWorker> getTeamWorkersInfo() {
        return teamWorkersInfo;
    }

    public void setTeamWorkersInfo(ArrayList<TeamWorker> teamWorkersInfo) {
        this.teamWorkersInfo = teamWorkersInfo;
    }

    public int getResultEditPerson() {
        return resultEditPerson;
    }

    public void setResultEditPerson(int resultEditPerson) {
        this.resultEditPerson = resultEditPerson;
    }

    public int getResultUpdateFirstName() {
        return resultUpdateFirstName;
    }

    public void setResultUpdateFirstName(int resultUpdateFirstName) {
        this.resultUpdateFirstName = resultUpdateFirstName;
    }

    public int getResultUpdateSecondName() {
        return resultUpdateSecondName;
    }

    public void setResultUpdateSecondName(int resultUpdateSecondName) {
        this.resultUpdateSecondName = resultUpdateSecondName;
    }

    public int getResultUpdateFirstLastName() {
        return resultUpdateFirstLastName;
    }

    public void setResultUpdateFirstLastName(int resultUpdateFirstLastName) {
        this.resultUpdateFirstLastName = resultUpdateFirstLastName;
    }

    public int getResultUpdateSecondLastName() {
        return resultUpdateSecondLastName;
    }

    public void setResultUpdateSecondLastName(int resultUpdateSecondLastName) {
        this.resultUpdateSecondLastName = resultUpdateSecondLastName;
    }

    public int getResultUpdateTypeIdentification() {
        return resultUpdateTypeIdentification;
    }

    public void setResultUpdateTypeIdentification(int resultUpdateTypeIdentification) {
        this.resultUpdateTypeIdentification = resultUpdateTypeIdentification;
    }

    public int getResultUpdateIdentification() {
        return resultUpdateIdentification;
    }

    public void setResultUpdateIdentification(int resultUpdateIdentification) {
        this.resultUpdateIdentification = resultUpdateIdentification;
    }

    public int getResultUpdateGender() {
        return resultUpdateGender;
    }

    public void setResultUpdateGender(int resultUpdateGender) {
        this.resultUpdateGender = resultUpdateGender;
    }

    public int getResultUpdatePosition() {
        return resultUpdatePosition;
    }

    public void setResultUpdatePosition(int resultUpdatePosition) {
        this.resultUpdatePosition = resultUpdatePosition;
    }

    public int getResultUpdateCountry() {
        return resultUpdateCountry;
    }

    public void setResultUpdateCountry(int resultUpdateCountry) {
        this.resultUpdateCountry = resultUpdateCountry;
    }

    public int getResultUpdatePhone() {
        return resultUpdatePhone;
    }

    public void setResultUpdatePhone(int resultUpdatePhone) {
        this.resultUpdatePhone = resultUpdatePhone;
    }

    public int getResultUpdateMail() {
        return resultUpdateMail;
    }

    public void setResultUpdateMail(int resultUpdateMail) {
        this.resultUpdateMail = resultUpdateMail;
    }

    public int getResultUpdateAddress() {
        return resultUpdateAddress;
    }

    public void setResultUpdateAddress(int resultUpdateAddress) {
        this.resultUpdateAddress = resultUpdateAddress;
    }

    public int getResultUpdateTeam() {
        return resultUpdateTeam;
    }

    public void setResultUpdateTeam(int resultUpdateTeam) {
        this.resultUpdateTeam = resultUpdateTeam;
    }

    public int getResultUpdateNumTShirt() {
        return resultUpdateNumTShirt;
    }

    public void setResultUpdateNumTShirt(int resultUpdateNumTShirt) {
        this.resultUpdateNumTShirt = resultUpdateNumTShirt;
    }

    public int getResultUpdateBirthdate() {
        return resultUpdateBirthdate;
    }

    public void setResultUpdateBirthdate(int resultUpdateBirthdate) {
        this.resultUpdateBirthdate = resultUpdateBirthdate;
    }

    public int getResultUpdateProvince() {
        return resultUpdateProvince;
    }

    public void setResultUpdateProvince(int resultUpdateProvince) {
        this.resultUpdateProvince = resultUpdateProvince;
    }

    public int getResultUpdateCanton() {
        return resultUpdateCanton;
    }

    public void setResultUpdateCanton(int resultUpdateCanton) {
        this.resultUpdateCanton = resultUpdateCanton;
    }

    public int getResultUpdateDistrict() {
        return resultUpdateDistrict;
    }

    public void setResultUpdateDistrict(int resultUpdateDistrict) {
        this.resultUpdateDistrict = resultUpdateDistrict;
    }
    

}
