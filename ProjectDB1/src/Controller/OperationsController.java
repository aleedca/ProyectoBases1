/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAccess.DA_News;
import Model.model_Account;
import Model.model_AdminCatalogs;
import Model.model_AdminMatches;
import Model.model_AdminPerson;
import Model.model_Login;
import Model.model_News;
import Model.model_Register;
import View.JF_AdminCatalogs;
import View.JF_AdminMatch;
import View.JF_AdminMatches;
import View.JF_AdminOptions;
import View.JF_AdminPerson;
import View.JF_EditAccount;
import View.JF_Login;
import View.JF_MyAccount;
import View.JF_Principal;
import View.JF_Register;
import View.JF_Request;
import View.JF_ScheduleMatch;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;


import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Mariana
 */

public class OperationsController implements ActionListener, ItemListener, ListSelectionListener{
    
    private final JF_Principal viewPrincipal;
    private final JF_Login viewLogin;
    private final JF_Register viewRegister;
    private final JF_AdminOptions viewMenuAdmin;
    private final JF_AdminPerson viewAdminPerson;
    private final JF_Request viewRequest;
    private final JF_MyAccount viewMyAccount;
    private final JF_EditAccount viewEditAccount;
    private final JF_AdminMatches viewAdminMatches;
    private final JF_ScheduleMatch viewScheduleMatch;
    private final JF_AdminMatch viewAdminMatch; 
    
    
    private final model_Login modelLogin;
    private final model_Register modelRegister;
    private final model_AdminPerson modelAdminPerson;
    private final model_News modelNews;
    private final model_Account accountModel;
    private final model_AdminMatches modelAdminMatches;
    
    private boolean flagRegister;
    private boolean flagAdminPerson;
    private boolean flagEditNews = false;
    
    private final RequestController requestController;
    private final AdminNewsController adminNewsController;
    private final AdminCatalogsController adminCatalogsController;
    
    
    //Constructor 2da version
    public OperationsController(JF_Principal principal) throws SQLException { 
        //View Principal
        this.viewPrincipal = principal;
        
        //View Login
        JF_Login login = new JF_Login();
        this.viewLogin = login;  
        
        //View Register
        JF_Register register = new JF_Register();
        this.viewRegister = register;
        
        //View AdminOptions
        JF_AdminOptions menuAdmin = new JF_AdminOptions();
        this.viewMenuAdmin = menuAdmin;
        
        //View AdminPerson
        JF_AdminPerson adminPerson = new JF_AdminPerson();
        this.viewAdminPerson = adminPerson;
        
        //View Request
        JF_Request request = new JF_Request();
        this.viewRequest = request;
        
        //View MyAccount
        JF_MyAccount myaccount = new JF_MyAccount();
        this.viewMyAccount = myaccount;
        
        //View EditAccount 
        this.viewEditAccount = new JF_EditAccount();
        
        //View Admin Matches
        JF_AdminMatches adminMatches = new JF_AdminMatches();
        this.viewAdminMatches = adminMatches;
        
        //View Admin Matches
        JF_ScheduleMatch scheduleMatch = new JF_ScheduleMatch();
        this.viewScheduleMatch = scheduleMatch;
        
        
        //View Admin Match
        JF_AdminMatch adminMatch = new JF_AdminMatch();
        this.viewAdminMatch = adminMatch;
               
        //Model Login
        model_Login validateLogin = new model_Login();
        this.modelLogin = validateLogin;  
         
        //Model Register
        model_Register validateRegister = new model_Register();
        this.modelRegister = validateRegister;
        
        //Model AdminPerson
        model_AdminPerson validateAdminPerson = new model_AdminPerson();
        this.modelAdminPerson = validateAdminPerson;
        
        //Model AdminNews
        model_News validateAdminNews = new model_News();
        this.modelNews = validateAdminNews;
        
        //Model MyAccount
        this.accountModel = new model_Account();
        
        //Model Admin Matches
        this.modelAdminMatches = new model_AdminMatches();
        
        //Request Controller
        RequestController controller = new RequestController();
        this.requestController = controller;
        
        //AdminNews Controller
        AdminNewsController adminNController = new AdminNewsController();
        this.adminNewsController = adminNController;
        
        //AdminCatalogs Controller
        AdminCatalogsController adminCatalogsController = new AdminCatalogsController();
        this.adminCatalogsController = adminCatalogsController;
        
        
        _init_(); 
        
        
        fillGenders();
        fillIdentificationTypes();     
        fillCountries();
        fillPositions();
        fillTeams();
        fillTypePerson();
        principal.showMostViewedNews();
        fillStadiums();
        
       

    }
    
    //Init de ActionListener, itemListener
    private void _init_(){
        //Principal
        viewPrincipal.getBtnLogin().addActionListener(this);
        viewPrincipal.getBtnSignUp().addActionListener(this);
        viewPrincipal.getBtnOpAdm().addActionListener(this);
        viewPrincipal.getBtnRequests().addActionListener(this);
        viewPrincipal.getBtnAccount().addActionListener(this);
        viewPrincipal.getBtnExit().addActionListener(this);
        
        //Login
        viewLogin.getBtnLogin().addActionListener(this);
        viewLogin.getBtnBack().addActionListener(this);
        
        //Register
        viewRegister.getBtnBack().addActionListener(this);
        viewRegister.getBtnCheckRegister().addActionListener(this);
        viewRegister.getBtnUploadPhoto().addActionListener(this);
        
        
        viewRegister.getCmbGender().addItemListener(this);
        viewRegister.getCmbTypeIdentification().addItemListener(this);
        viewRegister.getCmbCountry().addItemListener(this);
        viewRegister.getCmbProvince().addItemListener(this);
        viewRegister.getCmbCanton().addItemListener(this);
        viewRegister.getCmbDistrict().addItemListener(this);
        
        //AdminOptions
        viewMenuAdmin.getBtnBack().addActionListener(this);
        viewMenuAdmin.getBtnAdmiNoticias().addActionListener(this);
        viewMenuAdmin.getBtnAdmiPersonas().addActionListener(this);
        viewMenuAdmin.getBtnAdmiCatalogos().addActionListener(this);
        viewMenuAdmin.getBtnPartidos().addActionListener(this);
        
        //AdminMatches
        viewAdminMatches.getBtnScheduleMatch().addActionListener(this);
        viewAdminMatches.getBtnAdminScheduledMatch().addActionListener(this);
        viewAdminMatches.getBtnBack().addActionListener(this);
        
        //AdminScheduleMatch
        viewScheduleMatch.getBtnBack().addActionListener(this);
    
        
        //AdminMatch
        viewAdminMatch.getBtnBack().addActionListener(this);
        
        //AdminNews
        adminNewsController.getViewAdminNews().getRbtnAgregar().addActionListener(this);
        adminNewsController.getViewAdminNews().getRbtnEditar().addActionListener(this);
        
        adminNewsController.getViewAdminNews().getCmbEstado().addActionListener(this);
        adminNewsController.getViewAdminNews().getCmbTipo().addActionListener(this);
        
        adminNewsController.getViewAdminNews().getBtnAceptar().addActionListener(this);
        adminNewsController.getViewAdminNews().getBtnBack().addActionListener(this);
        adminNewsController.getViewAdminNews().getBtnCargarImagen().addActionListener(this);
        adminNewsController.getViewAdminNews().getTblNoticias().getSelectionModel().addListSelectionListener(this);
        
        //AdminCatalogOption
        adminCatalogsController.getViewAdminCatalogs().getBtnBack().addActionListener(this);
               
        //Request
        viewRequest.getBtnBackRequest().addActionListener(this);
        
        //MyAccount
        viewMyAccount.getBtnBackMyAccount().addActionListener(this);
        viewMyAccount.getBtnEditProfile().addActionListener(this);
        
        //EditAccount
        viewEditAccount.getBtnBack().addActionListener(this);
        viewEditAccount.getBtnConfirm().addActionListener(this);
        viewEditAccount.getBtnLoadPicture().addActionListener(this);
        
        
        //AdminPerson
        viewAdminPerson.getBtnBackAdminPerson().addActionListener(this);
        viewAdminPerson.getBtnAccept().addActionListener(this);
        viewAdminPerson.getBtnLoadPhoto().addActionListener(this);
        
        viewAdminPerson.getRbtnAdd().addActionListener(this);
        viewAdminPerson.getRbtnEdit().addActionListener(this);
        
        viewAdminPerson.getCmbGender().addItemListener(this);
        viewAdminPerson.getCmbTypeIdentification().addItemListener(this);
        viewAdminPerson.getCmbTypePosition().addItemListener(this);
        viewAdminPerson.getCmbTeam().addItemListener(this);
        viewAdminPerson.getCmbPerson().addItemListener(this);
        
        
        viewAdminPerson.getCmbCountry().addItemListener(this);
        viewAdminPerson.getCmbProvince().addItemListener(this);
        viewAdminPerson.getCmbCanton().addItemListener(this);
        viewAdminPerson.getCmbDistrict().addItemListener(this);
        
        //AdminCatalogs
        adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().addItemListener(this);
         
    }
    
    
    //-------- COMBO BOX FILLING --------------------------
    private void fillGenders(){
        viewRegister.getCmbGender().removeAllItems();
        viewAdminPerson.getCmbGender().removeAllItems();
        
        viewRegister.getCmbGender().addItem("Seleccione Género");
        viewAdminPerson.getCmbGender().addItem("Seleccione Género");
        for(int i=0; i<modelRegister.getGenders().size();i++){
            String nameGender = modelRegister.getGenders().get(i).getDescriptionGender();
            viewRegister.getCmbGender().addItem(nameGender );
            viewAdminPerson.getCmbGender().addItem(nameGender );
        }
    }
    
    private void fillIdentificationTypes(){
        viewRegister.getCmbTypeIdentification().removeAllItems();
        viewAdminPerson.getCmbTypeIdentification().removeAllItems();
        
        viewRegister.getCmbTypeIdentification().addItem("Seleccione Tipo");
        viewAdminPerson.getCmbTypeIdentification().addItem("Seleccione Tipo");
        for(int i=0; i< modelRegister.getIdentificationTypes().size();i++){
            String nameTypeIdentification = modelRegister.getIdentificationTypes().get(i).getNameTypeIdentification();
            viewRegister.getCmbTypeIdentification().addItem(nameTypeIdentification);
            viewAdminPerson.getCmbTypeIdentification().addItem(nameTypeIdentification);
        }
    }
    
    private void fillCountries(){
        viewRegister.getCmbCountry().removeAllItems();
        viewAdminPerson.getCmbCountry().removeAllItems();
        
        viewRegister.getCmbProvince().removeAllItems();
        viewRegister.getCmbProvince().setEnabled(false);
        
        viewAdminPerson.getCmbProvince().removeAllItems();
        viewAdminPerson.getCmbProvince().setEnabled(false);
        
        viewRegister.getCmbCanton().removeAllItems();
        viewRegister.getCmbCanton().setEnabled(false);
        
        viewAdminPerson.getCmbCanton().removeAllItems();
        viewAdminPerson.getCmbCanton().setEnabled(false);
        
        viewRegister.getCmbDistrict().removeAllItems();
        viewRegister.getCmbDistrict().setEnabled(false);
        
        viewAdminPerson.getCmbDistrict().removeAllItems();
        viewAdminPerson.getCmbDistrict().setEnabled(false);
        
        viewRegister.getCmbCountry().addItem("Seleccione País");
        viewAdminPerson.getCmbCountry().addItem("Seleccione País");
        for(int i=0; i<modelRegister.getCountries().size();i++){
            String nameCountry = modelRegister.getCountries().get(i).getNameCountry();
            viewRegister.getCmbCountry().addItem(nameCountry);
            viewAdminPerson.getCmbCountry().addItem(nameCountry);
        }
    }
    
    private void fillProvinces(int country){
        viewRegister.getCmbProvince().setEnabled(true);
        viewRegister.getCmbProvince().removeAllItems();
        
        viewAdminPerson.getCmbProvince().setEnabled(true);
        viewAdminPerson.getCmbProvince().removeAllItems();
        
        viewRegister.getCmbProvince().addItem("Seleccione Provincia");
        viewAdminPerson.getCmbProvince().addItem("Seleccione Provincia");
        for(int i=0; i<modelRegister.getProvinces().size();i++){
            if(country == modelRegister.getProvinces().get(i).getIdCountry()){
                String nameProvince = modelRegister.getProvinces().get(i).getNameProvince();
                viewRegister.getCmbProvince().addItem(nameProvince);
                viewAdminPerson.getCmbProvince().addItem(nameProvince);
            }  
        }
    }
    
    private void fillCantons(int province){
        viewRegister.getCmbCanton().setEnabled(true);
        viewRegister.getCmbCanton().removeAllItems();
        
        viewAdminPerson.getCmbCanton().setEnabled(true);
        viewAdminPerson.getCmbCanton().removeAllItems();
        
        viewRegister.getCmbCanton().addItem("Seleccione Cantón");
        viewAdminPerson.getCmbCanton().addItem("Seleccione Cantón");
        for(int i=0; i<modelRegister.getCantons().size();i++){
            if(province == modelRegister.getCantons().get(i).getIdProvince()){
                String nameCanton = modelRegister.getCantons().get(i).getNameCanton();
                viewRegister.getCmbCanton().addItem(nameCanton);
                viewAdminPerson.getCmbCanton().addItem(nameCanton);
            }
        }
    }
    
    private void fillDistricts(int canton){
        viewRegister.getCmbDistrict().setEnabled(true);
        viewRegister.getCmbDistrict().removeAllItems();
        
        viewAdminPerson.getCmbDistrict().setEnabled(true);
        viewAdminPerson.getCmbDistrict().removeAllItems();
        
        viewRegister.getCmbDistrict().addItem("Seleccione Distrito");
        viewAdminPerson.getCmbDistrict().addItem("Seleccione Distrito");
        for(int i=0; i<modelRegister.getDistricts().size();i++){
            if(canton == modelRegister.getDistricts().get(i).getIdCanton()){
                String nameDistrict = modelRegister.getDistricts().get(i).getNameDistrict();
                viewRegister.getCmbDistrict().addItem(nameDistrict);
                viewAdminPerson.getCmbDistrict().addItem(nameDistrict);
            }
        }
    }
    
    private void fillPositions(){
        viewAdminPerson.getCmbTypePosition().removeAllItems();
        
        viewAdminPerson.getCmbTypePosition().addItem("Seleccione Posición");
        for(int i=0; i<modelAdminPerson.getPositions().size();i++){
            String namePosition = modelAdminPerson.getPositions().get(i).getDescriptionPersonPosition();
            viewAdminPerson.getCmbTypePosition().addItem(namePosition);
        }
    }
    
    private void fillTeams(){
        viewAdminPerson.getCmbTeam().removeAllItems();
        
        viewAdminPerson.getCmbTeam().addItem("Seleccione Equipo");
        for(int i=0; i<modelAdminPerson.getTeams().size();i++){
            String nameTeam = modelAdminPerson.getTeams().get(i).getNameTeam();
            viewAdminPerson.getCmbTeam().addItem(nameTeam);
        }
    }
    
    private void fillTypePerson(){ 
        viewAdminPerson.getCmbPerson().removeAllItems();
        viewAdminPerson.getCmbPerson().addItem("Jugador");
        viewAdminPerson.getCmbPerson().addItem("Cuerpo Técnico");
    }
    
    private String fillFullName(String firstName, String firstLastName , String secondName, String secondLastName){
        String full;
        if(!"N/A".equals(secondName) && !"N/A".equals(secondLastName)){
            full = firstName+" "+secondName+" "+firstLastName+" "+secondLastName;
        }else{

            if(!"N/A".equals(secondName)){
                full = firstName+" "+secondName+" "+firstLastName;              
            }else{
                if(!"N/A".equals(secondLastName)){
                    full = firstName+" "+firstLastName+" "+secondLastName;
                }else{
                    full = firstName+" "+firstLastName;
                }
            }
        }
        return full;
    } 
    
    
    private void fillPerson(){
        String firstName;
        String secondName;
        String firstLastName;
        String secondLastName;
        String fullName;
        
        viewAdminPerson.getCmbPerson().removeAllItems();
        viewAdminPerson.getCmbPerson().addItem("Seleccione Persona"); 

        //PLAYER
        for(int i=0; i<modelAdminPerson.getPlayersComboBox().size();i++){      
            firstName = modelAdminPerson.getPlayersComboBox().get(i).getFirstName();
            secondName = modelAdminPerson.getPlayersComboBox().get(i).getSecondName();
            firstLastName = modelAdminPerson.getPlayersComboBox().get(i).getFirstLastName();
            secondLastName = modelAdminPerson.getPlayersComboBox().get(i).getSecondLastName();
            
            fullName = fillFullName(firstName, firstLastName, secondName, secondLastName);
            viewAdminPerson.getCmbPerson().addItem(fullName); 
        }
        
        //TEAMWORKER
        for(int i=0; i<modelAdminPerson.getTeamWorkersComboBox().size();i++){
            firstName = modelAdminPerson.getTeamWorkersComboBox().get(i).getFirstName();
            secondName = modelAdminPerson.getTeamWorkersComboBox().get(i).getSecondName();
            firstLastName = modelAdminPerson.getTeamWorkersComboBox().get(i).getFirstLastName();
            secondLastName = modelAdminPerson.getTeamWorkersComboBox().get(i).getSecondLastName();
            
            fullName = fillFullName(firstName, firstLastName, secondName, secondLastName);
            viewAdminPerson.getCmbPerson().addItem(fullName); 
        }
        
    }
    
    
    private void fillPlayerInformation(){
        String name, secondName, firstLastName, secondLastName,typeIdentification ;
        int idTypeIdentification, identification, idGender;
        String gender;
        String team;
        int idTeam;
        String position;
        int idPosition;
        int numTShirt;
        String mail;
        String address;
        int phoneNumber;
        String birthdate;
        String country;
        int idCountry;
        String province;
        int idProvince;
        String canton;
        int idCanton;
        String district;
        int idDistrict;
        
    
        for(int i=0; i<modelAdminPerson.getPlayersInfo().size();i++){
            name = modelAdminPerson.getPlayersInfo().get(i).getFirstName();
            viewAdminPerson.setTxtName(name);
            
            secondName = modelAdminPerson.getPlayersInfo().get(i).getSecondName();
            if(!"N/A".equals(secondName) && secondName != null){
                viewAdminPerson.setTxtSecondName(secondName);
            }else{
                viewAdminPerson.cleanSecondName();
            }
   
            firstLastName = modelAdminPerson.getPlayersInfo().get(i).getFirstLastName();
            viewAdminPerson.setTxtFirstLastName(firstLastName);
            
            secondLastName = modelAdminPerson.getPlayersInfo().get(i).getSecondLastName();
            if(!"N/A".equals(secondLastName) && secondLastName != null){
                viewAdminPerson.setTxtSecondLastName(secondLastName);
            }else{
                viewAdminPerson.cleanSecondLastName();
            }

            idTypeIdentification = modelAdminPerson.getPlayersInfo().get(i).getIdTypeIdentification();
            for(int j=0; j< modelRegister.getIdentificationTypes().size();j++){
                if(idTypeIdentification == modelRegister.getIdentificationTypes().get(j).getIdTypeIdentification()){
                    typeIdentification = modelRegister.getIdentificationTypes().get(j).getNameTypeIdentification();
                    viewAdminPerson.setTypeIdentification(typeIdentification);
                }
            }

            identification = modelAdminPerson.getPlayersInfo().get(i).getIdentification();
            viewAdminPerson.setTxtIdentification(identification);
           
            numTShirt = modelAdminPerson.getPlayersInfo().get(i).getNumTShirt();
            viewAdminPerson.setSpnNumCamisa(numTShirt);
            
            mail = modelAdminPerson.getPlayersInfo().get(i).getMail();
            viewAdminPerson.setTxtMail(mail);
            
            address = modelAdminPerson.getPlayersInfo().get(i).getDescriptonAddress();
            viewAdminPerson.setTxtAddress(address);
            
            phoneNumber = modelAdminPerson.getPlayersInfo().get(i).getPhoneNumber();
            viewAdminPerson.setTxtPhone(phoneNumber);
            
            birthdate = modelAdminPerson.getPlayersInfo().get(i).getBirthdate();
            viewAdminPerson.setTxtBirthDate(birthdate);
            
            idGender = modelAdminPerson.getPlayersInfo().get(i).getIdGender();
            for(int g=0; g<modelRegister.getGenders().size();g++){
                if(idGender == modelRegister.getGenders().get(g).getIdGender()){
                    gender = modelRegister.getGenders().get(g).getDescriptionGender();
                    viewAdminPerson.setGender(gender);
                }
            }
            
            idTeam = modelAdminPerson.getPlayersInfo().get(i).getIdTeam();
            for(int k=0; k<modelAdminPerson.getTeams().size();k++){
                if(idTeam == modelAdminPerson.getTeams().get(k).getIdTeam()){
                    team = modelAdminPerson.getTeams().get(k).getNameTeam();
                    viewAdminPerson.setTeam(team);
                }
            }
            
            idPosition = modelAdminPerson.getPlayersInfo().get(i).getIdPersonPosition();
            for(int h=0; h<modelAdminPerson.getPositions().size();h++){
                if(idPosition == modelAdminPerson.getPositions().get(h).getIdPersonPosition()){
                    position = modelAdminPerson.getPositions().get(h).getDescriptionPersonPosition();
                    viewAdminPerson.setPosition(position);
                }
            }
            
            
            idCountry = modelAdminPerson.getPlayersInfo().get(i).getIdCountry();
            for(int l=0; l<modelRegister.getCountries().size();l++){
                if(idCountry == modelRegister.getCountries().get(l).getIdCountry()){
                    country = modelRegister.getCountries().get(l).getNameCountry();
                    viewAdminPerson.setCountry(country);
                }
            }
            
            idProvince =  modelAdminPerson.getPlayersInfo().get(i).getIdProvince();
            for(int p=0; p<modelRegister.getProvinces().size();p++){
                if(idProvince == modelRegister.getProvinces().get(p).getIdProvince()){
                    province = modelRegister.getProvinces().get(p).getNameProvince();
                    viewAdminPerson.setProvince(province);
                }
            }
            
            idCanton = modelAdminPerson.getPlayersInfo().get(i).getIdCanton();
            for(int m=0; m<modelRegister.getCantons().size();m++){
                if(idCanton == modelRegister.getCantons().get(m).getIdCanton()){
                    canton = modelRegister.getCantons().get(m).getNameCanton();
                    viewAdminPerson.setCmbCanton(canton);
                }
            }
            
            idDistrict = modelAdminPerson.getPlayersInfo().get(i).getIdDistrict();
            for(int n=0; n<modelRegister.getDistricts().size();n++){
                if(idDistrict == modelRegister.getDistricts().get(n).getIdDistrict()){
                    district = modelRegister.getDistricts().get(n).getNameDistrict();
                    viewAdminPerson.setCmbDistrict(district);
                }
            }
            
        }
    }
    
   
    private void fillTeamWorkerInformation(){
        String name;
        String secondName;
        String firstLastName;
        String secondLastName;        
        String typeIdentification;
        int idTypeIdentification;
        int identification;
        String gender;
        int idGender;        
        String team;
        int idTeam;
        String position;
        int idPosition;
        String mail;
        String address;
        int phoneNumber;
        String country;
        int idCountry;
        String province;
        int idProvince;
        String canton;
        int idCanton;
        String district;
        int idDistrict;
        
    
        for(int i=0; i<modelAdminPerson.getTeamWorkersInfo().size();i++){
            name = modelAdminPerson.getTeamWorkersInfo().get(i).getFirstName();
            viewAdminPerson.setTxtName(name);
            
            secondName = modelAdminPerson.getTeamWorkersInfo().get(i).getSecondName();
            if(!"N/A".equals(secondName) && secondName != null){
                viewAdminPerson.setTxtSecondName(secondName);
            }else{
                viewAdminPerson.cleanSecondName();
            }
   
            firstLastName = modelAdminPerson.getTeamWorkersInfo().get(i).getFirstLastName();
            viewAdminPerson.setTxtFirstLastName(firstLastName);
            
            secondLastName = modelAdminPerson.getTeamWorkersInfo().get(i).getSecondLastName();
            if(!"N/A".equals(secondLastName) && secondLastName != null){
                viewAdminPerson.setTxtSecondLastName(secondLastName);
            }else{
                viewAdminPerson.cleanSecondLastName();
            }

            idTypeIdentification = modelAdminPerson.getTeamWorkersInfo().get(i).getIdTypeIdentification();
            for(int j=0; j< modelRegister.getIdentificationTypes().size();j++){
                if(idTypeIdentification == modelRegister.getIdentificationTypes().get(j).getIdTypeIdentification()){
                    typeIdentification = modelRegister.getIdentificationTypes().get(j).getNameTypeIdentification();
                    viewAdminPerson.setTypeIdentification(typeIdentification);
                }
            }

            identification = modelAdminPerson.getTeamWorkersInfo().get(i).getIdentification();
            viewAdminPerson.setTxtIdentification(identification);
           
            
            mail = modelAdminPerson.getTeamWorkersInfo().get(i).getMail();
            viewAdminPerson.setTxtMail(mail);
            
            address = modelAdminPerson.getTeamWorkersInfo().get(i).getDescriptonAddress();
            viewAdminPerson.setTxtAddress(address);
            
            phoneNumber = modelAdminPerson.getTeamWorkersInfo().get(i).getPhoneNumber();
            viewAdminPerson.setTxtPhone(phoneNumber);
            
            
            idGender = modelAdminPerson.getTeamWorkersInfo().get(i).getIdGender();
            for(int g=0; g<modelRegister.getGenders().size();g++){
                if(idGender == modelRegister.getGenders().get(g).getIdGender()){
                    gender = modelRegister.getGenders().get(g).getDescriptionGender();
                    viewAdminPerson.setGender(gender);
                }
            }
            
            idTeam = modelAdminPerson.getTeamWorkersInfo().get(i).getIdTeam();
            for(int k=0; k<modelAdminPerson.getTeams().size();k++){
                if(idTeam == modelAdminPerson.getTeams().get(k).getIdTeam()){
                    team = modelAdminPerson.getTeams().get(k).getNameTeam();
                    viewAdminPerson.setTeam(team);
                }
            }
            
            idPosition = modelAdminPerson.getTeamWorkersInfo().get(i).getIdPersonPosition();
            for(int h=0; h<modelAdminPerson.getPositions().size();h++){
                if(idPosition == modelAdminPerson.getPositions().get(h).getIdPersonPosition()){
                    position = modelAdminPerson.getPositions().get(h).getDescriptionPersonPosition();
                    viewAdminPerson.setPosition(position);
                }
            }
            
            
            idCountry = modelAdminPerson.getTeamWorkersInfo().get(i).getIdCountry();
            for(int l=0; l<modelRegister.getCountries().size();l++){
                if(idCountry == modelRegister.getCountries().get(l).getIdCountry()){
                    country = modelRegister.getCountries().get(l).getNameCountry();
                    viewAdminPerson.setCountry(country);
                }
            }
            
            idProvince =  modelAdminPerson.getTeamWorkersInfo().get(i).getIdProvince();
            for(int p=0; p<modelRegister.getProvinces().size();p++){
                if(idProvince == modelRegister.getProvinces().get(p).getIdProvince()){
                    province = modelRegister.getProvinces().get(p).getNameProvince();
                    viewAdminPerson.setProvince(province);
                }
            }
            
            idCanton = modelAdminPerson.getTeamWorkersInfo().get(i).getIdCanton();
            for(int m=0; m<modelRegister.getCantons().size();m++){
                if(idCanton == modelRegister.getCantons().get(m).getIdCanton()){
                    canton = modelRegister.getCantons().get(m).getNameCanton();
                    viewAdminPerson.setCmbCanton(canton);
                }
            }
            
            idDistrict = modelAdminPerson.getTeamWorkersInfo().get(i).getIdDistrict();
            for(int n=0; n<modelRegister.getDistricts().size();n++){
                if(idDistrict == modelRegister.getDistricts().get(n).getIdDistrict()){
                    district = modelRegister.getDistricts().get(n).getNameDistrict();
                    viewAdminPerson.setCmbDistrict(district);
                }
            }
            
        }
    }
    
    public void fillStadiums(){
        viewScheduleMatch.getCbmStadium().removeAllItems();
        
        viewScheduleMatch.getCbmStadium().addItem("Seleccione el estadio");
         for(int i=0; i<modelAdminMatches.getStadiums().size();i++){
           viewScheduleMatch.getCbmStadium().addItem(modelAdminMatches.getStadiums().get(i).getNameStadium());
        }
    }
    
    
    //-------------------------------------------------------------------------------
    
    //------------ VALIDATIONS AND CREATE REGISTER ---------------------------
    private void registerValidations(){
        if(modelRegister.validateEmptyFields() == true)
        {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios solicitados", "Error", JOptionPane.WARNING_MESSAGE);
            flagRegister = false;
        }else{

            if(modelRegister.validateFormatString(modelRegister.getFirstName()) == false ||  modelRegister.validateFormatString(modelRegister.getFirstLastName())== false)
            {

                JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Nombre y Primer Apellido", "Error", JOptionPane.WARNING_MESSAGE);


                if(modelRegister.validateFormatString(modelRegister.getFirstName()) == false){
                    viewRegister.cleanFirstName();
                }

                if(modelRegister.validateFormatString(modelRegister.getFirstName()) == false){
                    viewRegister.cleanFirstLastName();
                }


                flagRegister = false;
            }


            if(modelRegister.validateSecondName(modelRegister.getSecondName()) || modelRegister.validateSecondLastName(modelRegister.getSecondLastName())){

                if(modelRegister.validateSecondName(modelRegister.getSecondName())){

                    if(modelRegister.validateFormatString(modelRegister.getSecondName()) == false){

                        JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Segundo Nombre", "Error", JOptionPane.WARNING_MESSAGE);

                        viewRegister.cleanSecondName();
                        flagRegister = false;
                    }
                }

                if(modelRegister.validateSecondLastName(modelRegister.getSecondLastName())){

                    if(modelRegister.validateFormatString(modelRegister.getSecondLastName()) == false){

                        JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Segundo Apellido", "Error", JOptionPane.WARNING_MESSAGE);

                        viewRegister.cleanSecondLastName();
                        flagRegister = false;
                    }   
                }

            }


            if(modelRegister.validateFormatMail(modelRegister.getMail()) == false){ 
                JOptionPane.showMessageDialog(null, "Formato de correo no válido", "Error", JOptionPane.WARNING_MESSAGE);
                viewRegister.cleanMail();
                flagRegister = false;
            }


            if(modelRegister.validateFormatUsername() == false){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese únicamente letras, números o el caracter _ para crear su username.\nDebe tener al menos 5 caracteres y sin espacios.", "Error", JOptionPane.WARNING_MESSAGE);
                viewRegister.cleanUsername();
                flagRegister = false;
            }

            if(modelRegister.validateFormatPassword() == false){
                JOptionPane.showMessageDialog(null, "Formato de contraseña incorrecta.\nDebe contener entre 4 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula.", "Error", JOptionPane.WARNING_MESSAGE);
                viewRegister.cleanPassword();
                flagRegister = false;
            }

            if(modelRegister.validateFormatAddress(modelRegister.getAddress()) == false){
                JOptionPane.showMessageDialog(null, "Dirección no válida.\nDebe contener un mínimo de 50 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
                viewRegister.cleanAddress();
                flagRegister = false;
            }

            if(modelRegister.validatePhoto(modelRegister.getPhoto())){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una foto", "Error", JOptionPane.WARNING_MESSAGE);
                flagRegister = false;
            }

            if(viewRegister.validateTxtPhone()){
                JOptionPane.showMessageDialog(null, "Debe ingresar un número de teléfono", "Error", JOptionPane.WARNING_MESSAGE);
                flagRegister = false;
            }

            if(viewRegister.validateTxtIdentification()){
                JOptionPane.showMessageDialog(null, "Debe ingresar una identificación", "Error", JOptionPane.WARNING_MESSAGE);
                flagRegister = false;
            }

            if(modelLogin.userAlreadyExists()){
                JOptionPane.showMessageDialog(null, "Username ya existente. Debe ingresar un username diferente", "Error", JOptionPane.WARNING_MESSAGE);
                viewRegister.cleanUsername();
                flagRegister = false;
            }

        }
    }//END REGISTERVALIDATONS
    
    private void createUser(){
        modelRegister.inserUser();

        JOptionPane.showMessageDialog(null, "Felicidades, su cuenta se creó correctamte.\nInicie sesión para comenzar a disfrutar de nuestra aplicación" );
        viewRegister.cleanAll();

        fillGenders();
        fillIdentificationTypes();     
        fillCountries();


        modelRegister.setPhoto("src/Images/avatar.png");
        viewRegister.setLocationRelativeTo(viewRegister);
        modelRegister.setImageLabel(viewRegister.getLblAvatar());
        viewRegister.repaint();  


        viewRegister.setVisible(false);
        viewPrincipal.getBtnSignUp().setVisible(false);
        viewPrincipal.setVisible(true);
    }
    
    //------------ VALIDATIONS LOGIN ---------------------------
    private void loginValidations(){
        if(modelLogin.validarCampos()){
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos solicitados", "Error", JOptionPane.WARNING_MESSAGE);

            viewLogin.cleanUsernameLogin();
            viewLogin.cleanPasswordLogin();
        }else{            
            viewLogin.cleanUsernameLogin();
            viewLogin.cleanPasswordLogin();

            if(modelLogin.userExists() == true){
                viewLogin.setVisible(false);

                viewPrincipal.getBtnLogin().setVisible(false);
                viewPrincipal.getBtnSignUp().setVisible(false);

                viewPrincipal.getBtnRequests().setVisible(true);
                viewPrincipal.getBtnAccount().setVisible(true);
                viewPrincipal.getBtnExit().setVisible(true);

                viewPrincipal.setTxtLblWelcome("BIENVENIDO/A "+" "+modelLogin.getUsernameLogin());
                viewPrincipal.getLblWelcome().setVisible(true);

                if(modelLogin.validateUserType() == true){ //Es true -> Admin
                    //Frame de Admin                         
                    viewPrincipal.getBtnOpAdm().setVisible(true);
                }

                viewPrincipal.setVisible(true);   

            }else{
                JOptionPane.showMessageDialog(null, "El usuario ingresado no existe. Intente nuevamente");
            }      
        }
    }//END LOGINVALIDATIONS
    
    
    //------------ VALIDATIONS ADMINNEWS ---------------------------
    private void adminNewsValidationsInsert(String choice1, String choice2){
      if(modelNews.validateEmptyFields() && modelNews.validatePhoto() && choice1 != "Seleccione Estado" && choice2 != "Seleccione Tipo"){
            modelNews.insertNews();
            adminNewsController.fillAdminNews();
            adminNewsRestore();
            JOptionPane.showMessageDialog(null, "Noticia creada con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios solicitados", "Error", JOptionPane.WARNING_MESSAGE);            
        }
    }
    
    private void adminNewsValidationsUpdate(String choice1, String choice2){
        if(modelNews.validateEmptyFields() && modelNews.validatePhoto() && choice1 != "Seleccione Estado" && choice2 != "Seleccione Tipo"){
            modelNews.updateNews();
            adminNewsController.fillAdminNews();
            adminNewsRestore();
            updateNewsSuccessful();
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios solicitados", "Error", JOptionPane.WARNING_MESSAGE);            
        }
    }
    
    private void adminNewsRestore(){
        adminNewsController.fillNewsType();
        adminNewsController.fillStatus();

        adminNewsController.getViewAdminNews().clearAll();
        modelNews.setPhoto("src/Images/avatar.png");
        adminNewsController.getViewAdminNews().setLocationRelativeTo(adminNewsController.getViewAdminNews());
        modelNews.setImageLabel(adminNewsController.getViewAdminNews().getLblImagen());
        adminNewsController.getViewAdminNews().repaint();
    }
    
    //------------ VALIDATIONS AND CREATE ADMIN PERSON ---------------------------
    private void adminPersonValidations(){
        if(modelAdminPerson.validateEmptyFieldsAdminPerson()){
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios solicitados", "Error", JOptionPane.WARNING_MESSAGE);
            flagAdminPerson = false;
        }else{
            if(modelRegister.validateFormatString(modelAdminPerson.getFirstName()) == false ||  modelRegister.validateFormatString(modelAdminPerson.getFirstLastName())== false)
            {
                JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Nombre y Primer Apellido", "Error", JOptionPane.WARNING_MESSAGE);


                if(modelRegister.validateFormatString(modelAdminPerson.getFirstName()) == false){
                    viewAdminPerson.cleanFirstName();
                }

                if(modelRegister.validateFormatString(modelAdminPerson.getFirstLastName()) == false){
                    viewAdminPerson.cleanFirstLastName();
                }


                flagAdminPerson = false;
            }


            if(modelRegister.validateSecondName(modelAdminPerson.getSecondName()) || modelRegister.validateSecondLastName(modelAdminPerson.getSecondLastName())){

                if(modelRegister.validateSecondName(modelAdminPerson.getSecondName())){
                    if(modelRegister.validateFormatString(modelAdminPerson.getSecondName()) == false){

                        JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Segundo Nombre", "Error", JOptionPane.WARNING_MESSAGE);

                        viewAdminPerson.cleanSecondName();
                        flagAdminPerson = false;
                    }    
                }

                if(modelRegister.validateSecondLastName(modelAdminPerson.getSecondLastName())){

                    if(modelRegister.validateFormatString(modelAdminPerson.getSecondLastName()) == false){

                        JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Segundo Apellido", "Error", JOptionPane.WARNING_MESSAGE);

                        viewAdminPerson.cleanSecondLastName();
                        flagAdminPerson = false;
                    }   
                }
            }

            if(modelRegister.validateFormatMail(modelAdminPerson.getMail()) == false){ 
                JOptionPane.showMessageDialog(null, "Formato de correo no válido", "Error", JOptionPane.WARNING_MESSAGE);
                viewAdminPerson.cleanMail();
                flagAdminPerson = false;
            }


            if(modelRegister.validateFormatAddress(modelAdminPerson.getAddress()) == false){
                JOptionPane.showMessageDialog(null, "Dirección no válida.\nDebe contener un mínimo de 50 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
                viewAdminPerson.cleanAddress();
                flagAdminPerson = false;
            }


            if(modelRegister.validatePhoto(modelAdminPerson.getPhoto())){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una foto", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }


            if("Seleccione Distrito".equals(viewAdminPerson.getSelectedDistrict()))
            {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un distrito", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }

            if("Seleccione Género".equals(viewAdminPerson.getSelectedGender())){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un género", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }

            if("Seleccione Tipo".equals(viewAdminPerson.getSelectedTypeIdentification())){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de identificación", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }

            if("Seleccione Posición".equals(viewAdminPerson.getSelectedPosition())){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de posición", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }

            if("Seleccione Equipo".equals(viewAdminPerson.getSelectedTeam())){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }

            if(viewAdminPerson.validateTxtPhone()){
                JOptionPane.showMessageDialog(null, "Debe ingresar un número de teléfono", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }

            if(viewAdminPerson.validateTxtIdentification()){
                JOptionPane.showMessageDialog(null, "Debe ingresar una identificación", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }

            if("Jugador".equals(viewAdminPerson.getTxtCmbPerson())){
                if(viewAdminPerson.validateTxtDateOfBirth()){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una fecha de nacimiento", "Error", JOptionPane.WARNING_MESSAGE);
                    flagAdminPerson = false;
                }
            }
        }//VALIDATE EMPTY FIELDS
    }
    
    
    private void createPerson(){
        if("Jugador".equals(viewAdminPerson.getTxtCmbPerson())){
            modelAdminPerson.inserPlayer();
        }else{
            modelAdminPerson.inserTeamWorker();
        }

        if(modelAdminPerson.getResultInsertPerson() == 0){
            JOptionPane.showMessageDialog(null, "Se ha creado la persona");
            viewAdminPerson.setVisible(false);
            viewMenuAdmin.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Lo sentimos, no se logro crear la persona", "Error", JOptionPane.WARNING_MESSAGE);
        }

        viewAdminPerson.cleanAll();

        fillGenders();
        fillIdentificationTypes();     
        fillCountries();
        fillPositions();
        fillTeams();

        modelAdminPerson.setPhoto("src/Images/avatar.png");
        viewAdminPerson.setLocationRelativeTo(viewAdminPerson);
        modelAdminPerson.setImageAdminPerson(viewAdminPerson.getLblAvatar());
        viewAdminPerson.repaint();
    }
    

    //------------- UPDATES ADMIN PERSON ---------------------------
    private void updatesTeamWorker(int idPerson, int i){
        String secondName, secondLastName;
        String country, province, canton, district,typeIdentification,gender, team, position;
        int idTypeIdentification, idGender, idTeam, idPosition, idCountry, idProvince, idCanton, idDistrict;
        
        if(!viewAdminPerson.getTxtName().equals(modelAdminPerson.getTeamWorkersInfo().get(i).getFirstName())){
            System.out.println("Si actualiza primer nombre");
            modelAdminPerson.updateFirstName(idPerson, viewAdminPerson.getTxtName());
            flagAdminPerson = false;
        }

        if(viewAdminPerson.getTxtSecondName().isEmpty()){
            secondName = "N/A";
        }else{
            secondName = viewAdminPerson.getTxtSecondName();
        }

        if(!secondName.equals(modelAdminPerson.getTeamWorkersInfo().get(i).getSecondName())){
            System.out.println("Si actualiza second nombre");
            modelAdminPerson.updateSecondName(idPerson, secondName);
            flagAdminPerson = false;
        }


        if(!viewAdminPerson.getTxtFirstLastName().equals(modelAdminPerson.getTeamWorkersInfo().get(i).getFirstLastName())){
            System.out.println("Si actualiza primer apellido");
            modelAdminPerson.updateFirstLastName(idPerson, viewAdminPerson.getTxtFirstLastName());
            flagAdminPerson = false;
        }


        if(viewAdminPerson.getTxtSecondLastName().isEmpty()){
            secondLastName = "N/A";
        }else{
            secondLastName = viewAdminPerson.getTxtSecondLastName();
        }

        if(!secondLastName.equals(modelAdminPerson.getTeamWorkersInfo().get(i).getSecondLastName())){
            modelAdminPerson.updateSecondLastName(idPerson, secondLastName);
            flagAdminPerson = false;
        }
        
        if(viewAdminPerson.getTxtIdentification() != modelAdminPerson.getTeamWorkersInfo().get(i).getIdentification()){
            modelAdminPerson.updateIdentification(idPerson, viewAdminPerson.getTxtIdentification());
            flagAdminPerson = false;
        }
        
        if(!viewAdminPerson.getTxtMail().equals(modelAdminPerson.getTeamWorkersInfo().get(i).getMail())){
            modelAdminPerson.updateMail(idPerson, viewAdminPerson.getTxtMail());
            flagAdminPerson = false;
        }
        
        if(viewAdminPerson.getTxtPhone() != modelAdminPerson.getTeamWorkersInfo().get(i).getPhoneNumber()){
            modelAdminPerson.updatePhone(idPerson, viewAdminPerson.getTxtPhone());
            flagAdminPerson = false;
        }
        
        
        if(!viewAdminPerson.getTxtAddress().equals(modelAdminPerson.getTeamWorkersInfo().get(i).getDescriptonAddress())){
            modelAdminPerson.updateAddress(idPerson, viewAdminPerson.getTxtAddress());
            flagAdminPerson = false;
        }
        
        //TYPE IDENTIFICATION
        idTypeIdentification = modelAdminPerson.getTeamWorkersInfo().get(i).getIdTypeIdentification();
        typeIdentification = "";
        for(int j=0; j< modelRegister.getIdentificationTypes().size();j++){
            if(idTypeIdentification == modelRegister.getIdentificationTypes().get(j).getIdTypeIdentification())
            {
                typeIdentification = modelRegister.getIdentificationTypes().get(j).getNameTypeIdentification();
            }
        }

        if(!typeIdentification.equals(viewAdminPerson.getSelectedTypeIdentification())){
            for(int j=0; j< modelRegister.getIdentificationTypes().size();j++){
                if(viewAdminPerson.getSelectedTypeIdentification().equals(modelRegister.getIdentificationTypes().get(j).getNameTypeIdentification())){         
                    idTypeIdentification = modelRegister.getIdentificationTypes().get(j).getIdTypeIdentification();
                    modelAdminPerson.updateTypeIdentification(idPerson, idTypeIdentification);
                    flagAdminPerson = false;
                }
            }
        }        
        
        //GENDER
        idGender = modelAdminPerson.getTeamWorkersInfo().get(i).getIdGender();
        gender = "";
        for(int n=0; n< modelRegister.getGenders().size();n++){
            if(idGender == modelRegister.getGenders().get(n).getIdGender())
            {
                gender = modelRegister.getGenders().get(n).getDescriptionGender();
            }
        }
        
        if(!gender.equals(viewAdminPerson.getSelectedGender())){
            for(int j=0; j< modelRegister.getGenders().size();j++){
                if(viewAdminPerson.getSelectedGender().equals(modelRegister.getGenders().get(j).getDescriptionGender())){         
                    idGender = modelRegister.getGenders().get(j).getIdGender();
                    modelAdminPerson.updateGender(idPerson, idGender);
                    flagAdminPerson = false;
                }
            }
        }  
        
        //TEAM
        idTeam = modelAdminPerson.getTeamWorkersInfo().get(i).getIdTeam();
        team = "";
        for(int k=0; k<modelAdminPerson.getTeams().size();k++){
            if(idTeam == modelAdminPerson.getTeams().get(k).getIdTeam()){
                team = modelAdminPerson.getTeams().get(k).getNameTeam();
            }            
        }
  
        if(!team.equals(viewAdminPerson.getSelectedTeam())){
            for(int f=0; f< modelAdminPerson.getTeams().size();f++){
                if(viewAdminPerson.getSelectedTeam().equals(modelAdminPerson.getTeams().get(f).getNameTeam())){         
                    idTeam = modelAdminPerson.getTeams().get(f).getIdTeam();
                    modelAdminPerson.updateTeam(idPerson, idTeam);
                    flagAdminPerson = false;
                }
            }
        }      
        
        //POSITION
        idPosition = modelAdminPerson.getTeamWorkersInfo().get(i).getIdPersonPosition();
        position = "";
        for(int k=0; k<modelAdminPerson.getPositions().size();k++){
            if(idPosition == modelAdminPerson.getPositions().get(k).getIdPersonPosition()){
                position = modelAdminPerson.getPositions().get(k).getDescriptionPersonPosition();
            }            
        }

        if(!position.equals(viewAdminPerson.getSelectedPosition())){
            for(int f=0; f< modelAdminPerson.getPositions().size();f++){
                if(viewAdminPerson.getSelectedPosition().equals(modelAdminPerson.getPositions().get(f).getDescriptionPersonPosition())){         
                    idPosition = modelAdminPerson.getPositions().get(f).getIdPersonPosition();
                    modelAdminPerson.updatePosition(idPerson, idPosition);
                    flagAdminPerson = false;
                }
            }
        }
        
        //DISTRICT
        idDistrict = modelAdminPerson.getTeamWorkersInfo().get(i).getIdDistrict();
        district = "";
        for(int j=0; j< modelRegister.getDistricts().size();j++){
            if(idDistrict == modelRegister.getDistricts().get(j).getIdDistrict())
            {
                district = modelRegister.getDistricts().get(j).getNameDistrict();
            }
        }

        if(!district.equals(viewAdminPerson.getSelectedDistrict())){
            for(int j=0; j< modelRegister.getDistricts().size();j++){
                if(viewAdminPerson.getSelectedDistrict().equals(modelRegister.getDistricts().get(j).getNameDistrict())){         
                    idDistrict = modelRegister.getDistricts().get(j).getIdDistrict();
                    modelAdminPerson.updateDistrict(idPerson, idDistrict);
                    flagAdminPerson = false;
                }
            }
        }  
        
        //CANTON
        idCanton = modelAdminPerson.getTeamWorkersInfo().get(i).getIdCanton();
        canton = "";
        for(int j=0; j< modelRegister.getCantons().size();j++){
            if(idCanton == modelRegister.getCantons().get(j).getIdCanton())
            {
                canton = modelRegister.getCantons().get(j).getNameCanton();
            }
        }

        if(!canton.equals(viewAdminPerson.getSelectedCanton())){
            for(int j=0; j< modelRegister.getCantons().size();j++){
                if(viewAdminPerson.getSelectedCanton().equals(modelRegister.getCantons().get(j).getNameCanton())){         
                    idCanton = modelRegister.getCantons().get(j).getIdCanton();
                    modelAdminPerson.updateCanton(idPerson, idCanton);
                    flagAdminPerson = false;
                }
            }
        }
        
        //PROVINCE
        idProvince = modelAdminPerson.getTeamWorkersInfo().get(i).getIdProvince();
        province = "";
        for(int j=0; j< modelRegister.getProvinces().size();j++){
            if(idProvince == modelRegister.getProvinces().get(j).getIdProvince())
            {
                province = modelRegister.getProvinces().get(j).getNameProvince();
            }
        }

        if(!province.equals(viewAdminPerson.getSelectedProvince())){
            for(int j=0; j< modelRegister.getProvinces().size();j++){
                if(viewAdminPerson.getSelectedProvince().equals(modelRegister.getProvinces().get(j).getNameProvince())){         
                    idProvince = modelRegister.getProvinces().get(j).getIdProvince();
                    modelAdminPerson.updateProvince(idPerson, idProvince);
                    flagAdminPerson = false;
                }
            }
        }
 
        //COUNTRY
        idCountry = modelAdminPerson.getTeamWorkersInfo().get(i).getIdCountry();
        country = "";
        for(int j=0; j< modelRegister.getCountries().size();j++){
            if(idCountry == modelRegister.getCountries().get(j).getIdCountry())
            {
                country = modelRegister.getCountries().get(j).getNameCountry();
            }
        }

        if(!country.equals(viewAdminPerson.getSelectedCountry())){
            for(int j=0; j< modelRegister.getCountries().size();j++){
                if(viewAdminPerson.getSelectedCountry().equals(modelRegister.getCountries().get(j).getNameCountry())){         
                    idCountry = modelRegister.getCountries().get(j).getIdCountry();
                    modelAdminPerson.updateCountry(idPerson, idCountry);
                    flagAdminPerson = false;
                }
            }
        }  
        
    }
    
    
    private void updatesPlayer(int idPerson, int i){
        String secondName, secondLastName, birthdate, combination ;
        String country, province, canton, district,typeIdentification,gender, team, position;
        int idTypeIdentification, idGender, idTeam, idPosition, idCountry, idProvince, idCanton, idDistrict;


        if(!viewAdminPerson.getTxtName().equals(modelAdminPerson.getPlayersInfo().get(i).getFirstName())){
            System.out.println("Si actualiza primer nombre");
            modelAdminPerson.updateFirstName(idPerson, viewAdminPerson.getTxtName());
            flagAdminPerson = false;
        }

        if(viewAdminPerson.getTxtSecondName().isEmpty()){
            secondName = "N/A";
        }else{
            secondName = viewAdminPerson.getTxtSecondName();
        }

        if(!secondName.equals(modelAdminPerson.getPlayersInfo().get(i).getSecondName())){
            System.out.println("Si actualiza second nombre");
            modelAdminPerson.updateSecondName(idPerson, secondName);
            flagAdminPerson = false;
        }


        if(!viewAdminPerson.getTxtFirstLastName().equals(modelAdminPerson.getPlayersInfo().get(i).getFirstLastName())){
            System.out.println("Si actualiza primer apellido");
            modelAdminPerson.updateFirstLastName(idPerson, viewAdminPerson.getTxtFirstLastName());
            flagAdminPerson = false;
        }


        if(viewAdminPerson.getTxtSecondLastName().isEmpty()){
            secondLastName = "N/A";
        }else{
            secondLastName = viewAdminPerson.getTxtSecondLastName();
        }

        if(!secondLastName.equals(modelAdminPerson.getPlayersInfo().get(i).getSecondLastName())){
            modelAdminPerson.updateSecondLastName(idPerson, secondLastName);
            flagAdminPerson = false;
        }
        
        if(viewAdminPerson.getTxtIdentification() != modelAdminPerson.getPlayersInfo().get(i).getIdentification()){
            modelAdminPerson.updateIdentification(idPerson, viewAdminPerson.getTxtIdentification());
            flagAdminPerson = false;
        }
        
        if(!viewAdminPerson.getTxtMail().equals(modelAdminPerson.getPlayersInfo().get(i).getMail())){
            modelAdminPerson.updateMail(idPerson, viewAdminPerson.getTxtMail());
            flagAdminPerson = false;
        }
        
        if(viewAdminPerson.getTxtPhone() != modelAdminPerson.getPlayersInfo().get(i).getPhoneNumber()){
            modelAdminPerson.updatePhone(idPerson, viewAdminPerson.getTxtPhone());
            flagAdminPerson = false;
        }
        
        
        if(!viewAdminPerson.getTxtAddress().equals(modelAdminPerson.getPlayersInfo().get(i).getDescriptonAddress())){
            modelAdminPerson.updateAddress(idPerson, viewAdminPerson.getTxtAddress());
            flagAdminPerson = false;
        }
        
        
        //TYPE IDENTIFICATION
        idTypeIdentification = modelAdminPerson.getPlayersInfo().get(i).getIdTypeIdentification();
        typeIdentification = "";
        for(int j=0; j< modelRegister.getIdentificationTypes().size();j++){
            if(idTypeIdentification == modelRegister.getIdentificationTypes().get(j).getIdTypeIdentification())
            {
                typeIdentification = modelRegister.getIdentificationTypes().get(j).getNameTypeIdentification();
            }
        }

        if(!typeIdentification.equals(viewAdminPerson.getSelectedTypeIdentification())){
            for(int j=0; j< modelRegister.getIdentificationTypes().size();j++){
                if(viewAdminPerson.getSelectedTypeIdentification().equals(modelRegister.getIdentificationTypes().get(j).getNameTypeIdentification())){         
                    idTypeIdentification = modelRegister.getIdentificationTypes().get(j).getIdTypeIdentification();
                    modelAdminPerson.updateTypeIdentification(idPerson, idTypeIdentification);
                    flagAdminPerson = false;
                }
            }
        }        
        
        //GENDER
        idGender = modelAdminPerson.getPlayersInfo().get(i).getIdGender();
        gender = "";
        for(int n=0; n< modelRegister.getGenders().size();n++){
            if(idGender == modelRegister.getGenders().get(n).getIdGender())
            {
                gender = modelRegister.getGenders().get(n).getDescriptionGender();
            }
        }
        
        if(!gender.equals(viewAdminPerson.getSelectedGender())){
            for(int j=0; j< modelRegister.getGenders().size();j++){
                if(viewAdminPerson.getSelectedGender().equals(modelRegister.getGenders().get(j).getDescriptionGender())){         
                    idGender = modelRegister.getGenders().get(j).getIdGender();
                    modelAdminPerson.updateGender(idPerson, idGender);
                    flagAdminPerson = false;
                }
            }
        }  
        
        //TEAM
        idTeam = modelAdminPerson.getPlayersInfo().get(i).getIdTeam();
        team = "";
        for(int k=0; k<modelAdminPerson.getTeams().size();k++){
            if(idTeam == modelAdminPerson.getTeams().get(k).getIdTeam()){
                team = modelAdminPerson.getTeams().get(k).getNameTeam();
            }            
        }
            
        System.out.println("Seleccionado:" +viewAdminPerson.getSelectedTeam());
        if(!team.equals(viewAdminPerson.getSelectedTeam())){
            for(int f=0; f< modelAdminPerson.getTeams().size();f++){
                if(viewAdminPerson.getSelectedTeam().equals(modelAdminPerson.getTeams().get(f).getNameTeam())){         
                    idTeam = modelAdminPerson.getTeams().get(f).getIdTeam();
                    modelAdminPerson.updateTeam(idPerson, idTeam);
                    flagAdminPerson = false;
                }
            }
        }      
        
        //POSITION
        idPosition = modelAdminPerson.getPlayersInfo().get(i).getIdPersonPosition();
        position = "";
        for(int k=0; k<modelAdminPerson.getPositions().size();k++){
            if(idPosition == modelAdminPerson.getPositions().get(k).getIdPersonPosition()){
                position = modelAdminPerson.getPositions().get(k).getDescriptionPersonPosition();
            }            
        }
            
        System.out.println("Seleccionado:" +viewAdminPerson.getSelectedPosition());
        if(!position.equals(viewAdminPerson.getSelectedPosition())){
            for(int f=0; f< modelAdminPerson.getPositions().size();f++){
                if(viewAdminPerson.getSelectedPosition().equals(modelAdminPerson.getPositions().get(f).getDescriptionPersonPosition())){         
                    idPosition = modelAdminPerson.getPositions().get(f).getIdPersonPosition();
                    modelAdminPerson.updatePosition(idPerson, idPosition);
                    flagAdminPerson = false;
                }
            }
        }
        
        //DISTRICT
        idDistrict = modelAdminPerson.getPlayersInfo().get(i).getIdDistrict();
        district = "";
        for(int j=0; j< modelRegister.getDistricts().size();j++){
            if(idDistrict == modelRegister.getDistricts().get(j).getIdDistrict())
            {
                district = modelRegister.getDistricts().get(j).getNameDistrict();
            }
        }

        if(!district.equals(viewAdminPerson.getSelectedDistrict())){
            for(int j=0; j< modelRegister.getDistricts().size();j++){
                if(viewAdminPerson.getSelectedDistrict().equals(modelRegister.getDistricts().get(j).getNameDistrict())){         
                    idDistrict = modelRegister.getDistricts().get(j).getIdDistrict();
                    modelAdminPerson.updateDistrict(idPerson, idDistrict);
                    flagAdminPerson = false;
                }
            }
        }  
        
        //CANTON
        idCanton = modelAdminPerson.getPlayersInfo().get(i).getIdCanton();
        canton = "";
        for(int j=0; j< modelRegister.getCantons().size();j++){
            if(idCanton == modelRegister.getCantons().get(j).getIdCanton())
            {
                canton = modelRegister.getCantons().get(j).getNameCanton();
            }
        }

        if(!canton.equals(viewAdminPerson.getSelectedCanton())){
            for(int j=0; j< modelRegister.getCantons().size();j++){
                if(viewAdminPerson.getSelectedCanton().equals(modelRegister.getCantons().get(j).getNameCanton())){         
                    idCanton = modelRegister.getCantons().get(j).getIdCanton();
                    modelAdminPerson.updateCanton(idPerson, idCanton);
                    flagAdminPerson = false;
                }
            }
        }
        
        //PROVINCE
        idProvince = modelAdminPerson.getPlayersInfo().get(i).getIdProvince();
        province = "";
        for(int j=0; j< modelRegister.getProvinces().size();j++){
            if(idProvince == modelRegister.getProvinces().get(j).getIdProvince())
            {
                province = modelRegister.getProvinces().get(j).getNameProvince();
            }
        }

        if(!province.equals(viewAdminPerson.getSelectedProvince())){
            for(int j=0; j< modelRegister.getProvinces().size();j++){
                if(viewAdminPerson.getSelectedProvince().equals(modelRegister.getProvinces().get(j).getNameProvince())){         
                    idProvince = modelRegister.getProvinces().get(j).getIdProvince();
                    modelAdminPerson.updateProvince(idPerson, idProvince);
                    flagAdminPerson = false;
                }
            }
        }
 
        //COUNTRY
        idCountry = modelAdminPerson.getPlayersInfo().get(i).getIdCountry();
        country = "";
        for(int j=0; j< modelRegister.getCountries().size();j++){
            if(idCountry == modelRegister.getCountries().get(j).getIdCountry())
            {
                country = modelRegister.getCountries().get(j).getNameCountry();
            }
        }

        if(!country.equals(viewAdminPerson.getSelectedCountry())){
            for(int j=0; j< modelRegister.getCountries().size();j++){
                if(viewAdminPerson.getSelectedCountry().equals(modelRegister.getCountries().get(j).getNameCountry())){         
                    idCountry = modelRegister.getCountries().get(j).getIdCountry();
                    modelAdminPerson.updateCountry(idPerson, idCountry);
                    flagAdminPerson = false;
                }
            }
        }  
        
        //NUMTSHIRT
        if(viewAdminPerson.getSpnNumTShirt() != modelAdminPerson.getPlayersInfo().get(i).getNumTShirt()){
            modelAdminPerson.updateNumTShirt(idPerson, viewAdminPerson.getSpnNumTShirt());
            flagAdminPerson = false;
        }

        //BIRTHDATE
        birthdate = modelAdminPerson.getPlayersInfo().get(i).getBirthdate();
        combination = birthdate.substring(8, 10)+"-"+birthdate.substring(5, 7)+"-"+birthdate.substring(0,4);
        if(!viewAdminPerson.getTxtDateOfBirth().equals(combination)){
            modelAdminPerson.updateBirthDate(idPerson, viewAdminPerson.getTxtDateOfBirth());
            flagAdminPerson = false;
        }
        
}//END UPDATEPLAYER   
    
    
    private boolean updateSuccessful(){
        
        if(modelAdminPerson.getResultUpdateFirstName() == 0 && modelAdminPerson.getResultUpdateSecondName() == 0 &&  modelAdminPerson.getResultUpdateDistrict()==0){
            if( modelAdminPerson.getResultUpdateFirstLastName() == 0 && modelAdminPerson.getResultUpdateSecondLastName() == 0 && modelAdminPerson.getResultUpdateCanton()==0){
                if( modelAdminPerson.getResultUpdateTypeIdentification() == 0 && modelAdminPerson.getResultUpdateIdentification() ==0 &&  modelAdminPerson.getResultUpdateProvince()==0){
                    if(modelAdminPerson.getResultUpdateMail()==0 && modelAdminPerson.getResultUpdatePhone() == 0 &&  modelAdminPerson.getResultUpdateCountry()==0){
                        if( modelAdminPerson.getResultUpdateTeam()==0 && modelAdminPerson.getResultUpdatePosition()==0){
                            if(modelAdminPerson.getResultUpdateGender()==0 &&  modelAdminPerson.getResultUpdateAddress()==0){
                                if(modelAdminPerson.getResultUpdateBirthdate()==0 && modelAdminPerson.getResultUpdateNumTShirt()==0){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
    
        return false;
    }
    
    //------------- UPDATES ADMIN NEWS ---------------------------   
    
    private boolean updateNewsSuccessful(){
        //actualizar news correctamente
        if(modelNews.getResultUpdateStatus() == 0 && modelNews.getResultUpdateType() == 0 && modelNews.getResultUpdateTitle() == 0 && modelNews.getResultUpdateText() == 0 && modelNews.getResultUpdatePhoto() == 0){
            return true;
        }
        return false;
    }
    
    //----------------SHOW MORE VIEWED AND LAST NEWS ----------------------------------
    
    
    //-------------------------------------------------------------------------------------------------------
    
    @Override
    public void itemStateChanged(ItemEvent e){
        //COUNTRY -> REGISTER
        if( e.getSource() == viewRegister.getCmbCountry()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewRegister.getSelectedCountry();
                
                
                if(!"Seleccione País".equals(choice)){
                    
                    for(int i=0; i<modelRegister.getCountries().size();i++){
                        if( choice.equals(modelRegister.getCountries().get(i).getNameCountry())){
                            int idCountrySeleted = modelRegister.getCountries().get(i).getIdCountry();
                            modelRegister.setCountry(idCountrySeleted);
                            fillProvinces(idCountrySeleted);
                        }
                    }
                    
                }else{
                    viewRegister.getCmbProvince().removeAllItems();
                    viewRegister.getCmbProvince().setEnabled(false);
                    
                    viewRegister.getCmbCanton().removeAllItems();
                    viewRegister.getCmbCanton().setEnabled(false);
                    
                    viewRegister.getCmbDistrict().removeAllItems();
                    viewRegister.getCmbDistrict().setEnabled(false);
                }
            }
        }
        
        //COUNTRY -> ADMINPERSON
        if( e.getSource() == viewAdminPerson.getCmbCountry()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewAdminPerson.getSelectedCountry();
                
                
                if(!"Seleccione País".equals(choice)){
                    
                    for(int i=0; i<modelRegister.getCountries().size();i++){
                        if( choice.equals(modelRegister.getCountries().get(i).getNameCountry())){
                            int idCountrySeleted = modelRegister.getCountries().get(i).getIdCountry();
                            modelAdminPerson.setCountry(idCountrySeleted);
                            fillProvinces(idCountrySeleted);
                        }
                    }
                    
                }else{
                    viewAdminPerson.getCmbProvince().removeAllItems();
                    viewAdminPerson.getCmbProvince().setEnabled(false);
                    
                    viewAdminPerson.getCmbCanton().removeAllItems();
                    viewAdminPerson.getCmbCanton().setEnabled(false);
                    
                    viewAdminPerson.getCmbDistrict().removeAllItems();
                    viewAdminPerson.getCmbDistrict().setEnabled(false);
                    
                }
            }
        
        }
        
        
        //PROVINCE -> REGISTER
        if( e.getSource() == viewRegister.getCmbProvince()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewRegister.getSelectedProvince();
                
                
                if(!"Seleccione Provincia".equals(choice)){
                    
                    for(int i=0; i<modelRegister.getProvinces().size();i++){
                        if( choice.equals(modelRegister.getProvinces().get(i).getNameProvince())){
                            int idProvinceSeleted = modelRegister.getProvinces().get(i).getIdProvince();
                            modelRegister.setProvince(idProvinceSeleted);
                            fillCantons(idProvinceSeleted);
                        }
                    }
                    
                }else{
                    viewRegister.getCmbCanton().removeAllItems();
                    viewRegister.getCmbCanton().setEnabled(false);
                    
                    viewRegister.getCmbDistrict().removeAllItems();
                    viewRegister.getCmbDistrict().setEnabled(false);
                }
            }
        
        }
        
        //PROVINCE -> ADMINPERSON
        if( e.getSource() == viewAdminPerson.getCmbProvince()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewAdminPerson.getSelectedProvince();
                
                
                if(!"Seleccione Provincia".equals(choice)){
                    
                    for(int i=0; i<modelRegister.getProvinces().size();i++){
                        if( choice.equals(modelRegister.getProvinces().get(i).getNameProvince())){
                            int idProvinceSeleted = modelRegister.getProvinces().get(i).getIdProvince();
                            modelAdminPerson.setProvince(idProvinceSeleted);
                            fillCantons(idProvinceSeleted);
                        }
                    }
                    
                }else{
                    viewAdminPerson.getCmbCanton().removeAllItems();
                    viewAdminPerson.getCmbCanton().setEnabled(false);
                                                           
                    viewAdminPerson.getCmbDistrict().removeAllItems();
                    viewAdminPerson.getCmbDistrict().setEnabled(false);
                }
            }
        
        }
        
        
        //CANTON -> REGISTER
        if( e.getSource() == viewRegister.getCmbCanton()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewRegister.getSelectedCanton();
                
                
                if(!"Seleccione Cantón".equals(choice)){
                    
                    for(int i=0; i<modelRegister.getCantons().size();i++){
                        if( choice.equals(modelRegister.getCantons().get(i).getNameCanton())){
                            int idCantonSeleted = modelRegister.getCantons().get(i).getIdCanton();
                            modelRegister.setCanton(idCantonSeleted);
                            fillDistricts(idCantonSeleted);
                        }
                    }
                    
                }else{
                    viewRegister.getCmbDistrict().removeAllItems();
                    viewRegister.getCmbDistrict().setEnabled(false);
                }
            }
        
        }
        
        //CANTON -> ADMINPERSON
        if( e.getSource() == viewAdminPerson.getCmbCanton()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewAdminPerson.getSelectedCanton();
                
                
                if(!"Seleccione Cantón".equals(choice)){
                    
                    for(int i=0; i<modelRegister.getCantons().size();i++){
                        if( choice.equals(modelRegister.getCantons().get(i).getNameCanton())){
                            int idCantonSeleted = modelRegister.getCantons().get(i).getIdCanton();
                            modelAdminPerson.setCanton(idCantonSeleted);
                            fillDistricts(idCantonSeleted);
                        }
                    }
                    
                }else{
                    viewAdminPerson.getCmbDistrict().removeAllItems();
                    viewAdminPerson.getCmbDistrict().setEnabled(false);
                }
            }
        
        }
        
        
        //DISTRICT -> REGISTER
        if( e.getSource() == viewRegister.getCmbDistrict()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewRegister.getSelectedDistrict();     
                if(!"Seleccione Distrito".equals(choice)){
                    for(int i=0; i<modelRegister.getDistricts().size();i++){
                        if( choice.equals(modelRegister.getDistricts().get(i).getNameDistrict())){
                            modelRegister.setDistrict(modelRegister.getDistricts().get(i).getIdDistrict());
                        }    
                    } 
                }
            }
        }
        
        //DISTRICT -> ADMINPERSON
        if( e.getSource() == viewAdminPerson.getCmbDistrict()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewAdminPerson.getSelectedDistrict();
                if(!"Seleccione Distrito".equals(choice)){
                    for(int i=0; i<modelRegister.getDistricts().size();i++){
                        if( choice.equals(modelRegister.getDistricts().get(i).getNameDistrict())){
                            modelAdminPerson.setDistrict(modelRegister.getDistricts().get(i).getIdDistrict());
                        }    
                    }    
                }
            }
        }
        

        //TYPEIDENTIFICATION -> REGISTER
        if( e.getSource() == viewRegister.getCmbTypeIdentification()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewRegister.getSelectedTypeIdentification();  
                if(!"Seleccione Tipo".equals(choice)){
                    for(int i=0; i<modelRegister.getIdentificationTypes().size();i++){
                        if( choice.equals(modelRegister.getIdentificationTypes().get(i).getNameTypeIdentification())){
                            modelRegister.setTypeIdentification(modelRegister.getIdentificationTypes().get(i).getIdTypeIdentification());
                        }       
                    } 
                }
            }
        }
        
        //TYPEIDENTIFICAION -> ADMINPERSON
        if( e.getSource() == viewAdminPerson.getCmbTypeIdentification()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewAdminPerson.getSelectedTypeIdentification();
                if(!"Seleccione Tipo".equals(choice)){
                    for(int i=0; i<modelRegister.getIdentificationTypes().size();i++){
                        if(choice.equals(modelRegister.getIdentificationTypes().get(i).getNameTypeIdentification())){    
                            modelAdminPerson.setTypeIdentification(modelRegister.getIdentificationTypes().get(i).getIdTypeIdentification());
                        }    
                    }  
                }
            }
        }
        
        
        //GENDER -> REGISTER
        if(e.getSource() == viewRegister.getCmbGender()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewRegister.getSelectedGender();
                if(!"Seleccione Género".equals(choice)){
                    for(int i=0; i<modelRegister.getGenders().size();i++){
                        if( choice.equals(modelRegister.getGenders().get(i).getDescriptionGender())){
                            modelRegister.setGender(modelRegister.getGenders().get(i).getIdGender());
                        }    
                    }   
                }
            }
        }
        
        //GENDER -> ADMINPERSON
        if(e.getSource() == viewAdminPerson.getCmbGender()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewAdminPerson.getSelectedGender();    
                if(!"Seleccione Género".equals(choice)){
                                    
                    for(int i=0; i<modelRegister.getGenders().size();i++){
                        if( choice.equals(modelRegister.getGenders().get(i).getDescriptionGender())){
                            modelAdminPerson.setGender(modelRegister.getGenders().get(i).getIdGender());
                        }    
                    } 
                } 
            }
        }
        
        //POSITION -> ADMINPERSON
        if(e.getSource() == viewAdminPerson.getCmbTypePosition()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewAdminPerson.getSelectedPosition();    
                if(!"Seleccione Posición".equals(choice)){
                                    
                    for(int i=0; i<modelAdminPerson.getPositions().size();i++){
                        if( choice.equals(modelAdminPerson.getPositions().get(i).getDescriptionPersonPosition())){
                            modelAdminPerson.setPosition(modelAdminPerson.getPositions().get(i).getIdPersonPosition());
                        }    
                    } 
                } 
            }
        }
        
        //TEAM -> ADMINPERSON
        if(e.getSource() == viewAdminPerson.getCmbTeam()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewAdminPerson.getSelectedTeam();    
                if(!"Seleccione Equipo".equals(choice)){
                                    
                    for(int i=0; i<modelAdminPerson.getTeams().size();i++){
                        if( choice.equals(modelAdminPerson.getTeams().get(i).getNameTeam())){
                            int idTeam = modelAdminPerson.getTeams().get(i).getIdTeam();
                            System.out.println("Id de Team: " + idTeam);
                            modelAdminPerson.setTeam(idTeam);
                        }    
                    }
                    
                } 
            }
        }
        
        //PERSON -> ADMINPERSON
        if(e.getSource() == viewAdminPerson.getCmbPerson()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String firstName;
                String secondName;
                String firstLastName;
                String secondLastName;
                String fullName;
                String choice = viewAdminPerson.getSelectedPerson();
                
                if(viewAdminPerson.getRbtnEdit().isSelected()){
                    if(!"Seleccione Persona".equals(choice)){
                        
                        //PLAYERS
                        for(int i=0; i<modelAdminPerson.getPlayersComboBox().size();i++){
                            firstName = modelAdminPerson.getPlayersComboBox().get(i).getFirstName();
                            secondName = modelAdminPerson.getPlayersComboBox().get(i).getSecondName();
                            firstLastName = modelAdminPerson.getPlayersComboBox().get(i).getFirstLastName();
                            secondLastName = modelAdminPerson.getPlayersComboBox().get(i).getSecondLastName();
                            
                            fullName = fillFullName(firstName, firstLastName, secondName, secondLastName);
                            
                            if(choice.equals(fullName)){
                                int idPerson = modelAdminPerson.getPlayersComboBox().get(i).getIdPerson();
                                modelAdminPerson.getPersonInformation(idPerson);
                                viewAdminPerson.deshabilitarOpciones(true);
                                fillPlayerInformation();
                            }
                        }
                        
                        //TEAMWORKER
                        for(int i=0; i<modelAdminPerson.getTeamWorkersComboBox().size();i++){
                            firstName = modelAdminPerson.getTeamWorkersComboBox().get(i).getFirstName();
                            secondName = modelAdminPerson.getTeamWorkersComboBox().get(i).getSecondName();
                            firstLastName = modelAdminPerson.getTeamWorkersComboBox().get(i).getFirstLastName();
                            secondLastName = modelAdminPerson.getTeamWorkersComboBox().get(i).getSecondLastName();

                            fullName = fillFullName(firstName, firstLastName, secondName, secondLastName);
                            
                            if(choice.equals(fullName)){
                                int idPerson = modelAdminPerson.getTeamWorkersComboBox().get(i).getIdPerson();
                                modelAdminPerson.getPersonInformation(idPerson);
                                viewAdminPerson.deshabilitarOpciones(false);
                                fillTeamWorkerInformation();
                            }
                        }
                         
                    }else{
                        viewAdminPerson.cleanAll();
                        
                        viewAdminPerson.setTypeIdentification("Seleccione Tipo");
                        viewAdminPerson.setTeam("Seleccione Equipo");
                        viewAdminPerson.setPosition("Seleccione Posición");
                        viewAdminPerson.setGender("Seleccione Género");
                    }
                 
                }
            
                
            
            }
        
        }
        
        
        
        //XD LOL
        if(e.getSource() == adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                adminCatalogsController.fillCatalogs();
            }
        }

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //-------------- SCREEN PRINCIPAL ----------------------        
        if(e.getSource() == viewPrincipal.getBtnLogin()){    
            viewLogin.setVisible(true);
            viewPrincipal.setVisible(false);
        }
        
                
        if(e.getSource() == viewPrincipal.getBtnSignUp()){
            viewRegister.setVisible(true);
            viewPrincipal.setVisible(false);
        }
        
        if(e.getSource() == viewPrincipal.getBtnOpAdm()){
            viewMenuAdmin.setVisible(true);
            viewPrincipal.setVisible(false);
        }
        
        if(e.getSource() == viewPrincipal.getBtnRequests()){
            requestController.fillStadiums(viewRequest);
            requestController.fillCountryTeams(viewRequest);
            requestController.fillPositions(viewRequest);
            requestController.fillEvents(viewRequest);
            viewRequest.setVisible(true);
            viewPrincipal.setVisible(false); 
        }
        
        if(e.getSource() == viewPrincipal.getBtnAccount()){
            accountModel.setUsernameValidated(model_Login.getUsernameLogin());
            viewMyAccount.UpdateInfo(accountModel.getAccountLogged());
            viewMyAccount.setVisible(true);
            viewPrincipal.setVisible(false); 
        }
        
        
               
        if(e.getSource() == viewPrincipal.getBtnExit()){
            viewPrincipal.setVisible(false);
            
            viewPrincipal.getLblWelcome().setVisible(false);
            viewPrincipal.getBtnRequests().setVisible(false);
            viewPrincipal.getBtnOpAdm().setVisible(false);
            viewPrincipal.getBtnAccount().setVisible(false);
            viewPrincipal.getBtnExit().setVisible(false);
            
            viewPrincipal.getBtnLogin().setVisible(true);
            viewPrincipal.getBtnSignUp().setVisible(true);
                        
            viewPrincipal.setVisible(true);
        }
        
        //-------------- SCREEN LOGIN ----------------------  
        if(e.getSource() == viewLogin.getBtnLogin()){
            modelLogin.setUsernameLogin(viewLogin.getTxtUsernameLogin());
            modelLogin.setPasswordLogin(viewLogin.getTxtPasswordLogin());
            loginValidations();
        }
                
        if(e.getSource() == viewLogin.getBtnBack()){
            viewPrincipal.setVisible(true); 
            viewLogin.setVisible(false);
        }
        
        
        //------ SCREEN REGISTRO ---------------------
        
        if(e.getSource() == viewRegister.getBtnBack()){
            viewPrincipal.setVisible(true);
            viewRegister.setVisible(false);
        }
        
        if(e.getSource() == viewRegister.getBtnUploadPhoto()){
            if(modelRegister.selectPhoto(viewRegister)){
                viewRegister.setLocationRelativeTo(viewRegister);
                modelRegister.setImageLabel(viewRegister.getLblAvatar());
                viewRegister.repaint();
            }
        }
        
        if(e.getSource() == viewRegister.getBtnCheckRegister()){
            modelRegister.setFirstName(viewRegister.getTxtName());
            modelRegister.setSecondName(viewRegister.getTxtSecondName());
            modelRegister.setFirstLastName(viewRegister.getTxtFirstLastName());
            modelRegister.setSecondLastName(viewRegister.getTxtSecondLastName());
            
            modelRegister.setUsernameRegister(viewRegister.getTxtUsername());
            modelRegister.setPasswordRegister(viewRegister.getTxtPassword());
            
            modelRegister.setIdentification(viewRegister.getTxtIdentification());
            modelRegister.setPhone(viewRegister.getTxtPhone());
            
            modelRegister.setMail(viewRegister.getTxtMail());
            modelRegister.setAddress(viewRegister.getTxtAddress());
                      
            flagRegister = true;
            registerValidations(); //VALIDATIONS           
            if(flagRegister == true){
                createUser();
            }
        }
        
        //-------------- SCREEN AdminOptions -----------------------
        if(e.getSource() == viewMenuAdmin.getBtnBack()){
            viewMenuAdmin.setVisible(false);
            viewPrincipal.getBtnLogin().setVisible(false);
            viewPrincipal.getBtnSignUp().setVisible(false);
                
            viewPrincipal.getBtnRequests().setVisible(true);
            viewPrincipal.getBtnAccount().setVisible(true);
            viewPrincipal.getBtnExit().setVisible(true);
            
            viewPrincipal.setTxtLblWelcome("BIENVENIDO/A "+" "+modelLogin.getUsernameLogin());
            viewPrincipal.getLblWelcome().setVisible(true);
            viewPrincipal.getBtnOpAdm().setVisible(true);
            
            viewPrincipal.setVisible(true);
        }
        
        if(e.getSource() == viewMenuAdmin.getBtnAdmiNoticias()){
            viewMenuAdmin.setVisible(false);
            this.adminNewsController.showView();
        }
        
        if(e.getSource() == viewMenuAdmin.getBtnPartidos()){
            viewMenuAdmin.setVisible(false);
            this.viewAdminMatches.setVisible(true);
        }
        
        
        if(e.getSource() == viewMenuAdmin.getBtnAdmiPersonas()){                    
            viewMenuAdmin.setVisible(false);
            viewAdminPerson.setVisible(true);
        }
        
        if(e.getSource() == viewMenuAdmin.getBtnAdmiCatalogos()){                    
            viewMenuAdmin.setVisible(false);
            adminCatalogsController.getViewAdminCatalogs().setVisible(true);
        }
        
        //-------------- SCREEN AdminNews -----------------------
        if(e.getSource() == adminNewsController.getViewAdminNews().getBtnBack()){
            adminNewsController.getViewAdminNews().setVisible(false);
            this.viewMenuAdmin.setVisible(true);
        }
        
        if(e.getSource() == adminNewsController.getViewAdminNews().getBtnAceptar()){
            String choice1 = adminNewsController.getViewAdminNews().getCmbEstado().getSelectedItem().toString();
            String choice2 = adminNewsController.getViewAdminNews().getCmbTipo().getSelectedItem().toString();
            
            modelNews.setIdNewsStatus(adminNewsController.getViewAdminNews().getCmbEstado().getSelectedIndex());
            modelNews.setIdNewsType(adminNewsController.getViewAdminNews().getCmbTipo().getSelectedIndex());
            modelNews.setNewsTitle(adminNewsController.getViewAdminNews().getTxtTitulo().getText());
            modelNews.setPublicationDate(modelNews.getPublicationDate());
            modelNews.setNewsText(adminNewsController.getViewAdminNews().getTxtTexto().getText());
            
            if(adminNewsController.getViewAdminNews().getRbtnAgregar().isSelected()){
                adminNewsValidationsInsert(choice1, choice2);
            }
            
            if(adminNewsController.getViewAdminNews().getRbtnEditar().isSelected()){
                adminNewsValidationsUpdate(choice1, choice2);
            }
            flagEditNews = false;
            adminNewsController.getViewAdminNews().getRbtnAgregar().setSelected(true);
        }
        
        if(e.getSource() == adminNewsController.getViewAdminNews().getRbtnAgregar()){
            adminNewsRestore();
            flagEditNews = false;
        }

        if(e.getSource() == adminNewsController.getViewAdminNews().getRbtnEditar()){
            flagEditNews = true;
        }

        if(e.getSource() == adminNewsController.getViewAdminNews().getBtnCargarImagen()){
            if(modelNews.selectPhoto(adminNewsController.getViewAdminNews())){
                adminNewsController.getViewAdminNews().setLocationRelativeTo(adminNewsController.getViewAdminNews());
                modelNews.setImageLabel(adminNewsController.getViewAdminNews().getLblImagen());
                adminNewsController.getViewAdminNews().repaint();
            }
        }
        
        
        //-------------- SCREEN AdminCatalogs -----------------------
        if(e.getSource() == adminCatalogsController.getViewAdminCatalogs().getBtnBack()){
            adminCatalogsController.getViewAdminCatalogs().setVisible(false);
            this.viewMenuAdmin.setVisible(true);
        }
        
        
        //----------- SCREEN Request -------------------------
        if(e.getSource() == viewRequest.getBtnBackRequest()){
            viewRequest.setVisible(false);
            viewPrincipal.getBtnLogin().setVisible(false);
            viewPrincipal.getBtnSignUp().setVisible(false);
                
            viewPrincipal.getBtnRequests().setVisible(true);
            viewPrincipal.getBtnAccount().setVisible(true);
            viewPrincipal.getBtnExit().setVisible(true);
            
            viewPrincipal.setTxtLblWelcome("BIENVENIDO/A "+" "+modelLogin.getUsernameLogin());
            viewPrincipal.getLblWelcome().setVisible(true);
            
            if(modelLogin.getResultUserType() == 0){
                viewPrincipal.getBtnOpAdm().setVisible(true);
            }
            
            viewPrincipal.setVisible(true);
        }
        
        //----------- Screen MyAccount -------------------------
        if(e.getSource() == viewMyAccount.getBtnBackMyAccount()){
            viewMyAccount.setVisible(false);
            viewPrincipal.getBtnLogin().setVisible(false);
            viewPrincipal.getBtnSignUp().setVisible(false);
                
            viewPrincipal.getBtnRequests().setVisible(true);
            viewPrincipal.getBtnAccount().setVisible(true);
            viewPrincipal.getBtnExit().setVisible(true);
            
            viewPrincipal.setTxtLblWelcome("BIENVENIDO/A "+" "+modelLogin.getUsernameLogin());
            viewPrincipal.getLblWelcome().setVisible(true);
            
            if(modelLogin.getResultUserType() == 0){
                viewPrincipal.getBtnOpAdm().setVisible(true);
            }
            
            viewPrincipal.setVisible(true);
        }
        
        if(e.getSource() == viewMyAccount.getBtnEditProfile()){
            viewEditAccount.UpdateInfo(accountModel.getAccountLogged());
            viewMyAccount.setVisible(false);
            viewEditAccount.setVisible(true);
        }
        
        //----------- Screen EditAccount -------------------------
        if(e.getSource() == viewEditAccount.getBtnBack()){
            viewEditAccount.setVisible(false);
            viewMyAccount.setVisible(true);
        }
        
        if(e.getSource() == viewEditAccount.getBtnConfirm()){
            //falta llamar el procedimiento de update
            accountModel.setUsernameValidated(model_Login.getUsernameLogin());
            viewMyAccount.UpdateInfo(accountModel.getAccountLogged());
            viewEditAccount.setVisible(false);
            viewMyAccount.setVisible(true);
        }
                
        //-------------- SCREEN AdminPerson -----------------------
        if(e.getSource() == viewAdminPerson.getBtnBackAdminPerson()){
            viewAdminPerson.cleanAll();
            viewAdminPerson.setVisible(false);
            viewMenuAdmin.setVisible(true);
        }
        
        if(e.getSource() == viewAdminPerson.getBtnLoadPhoto()){
            if(modelAdminPerson.selectPhotoAdminPerson(viewAdminPerson)){
                viewAdminPerson.setLocationRelativeTo(viewAdminPerson);
                modelAdminPerson.setImageAdminPerson(viewAdminPerson.getLblAvatar());
                viewAdminPerson.repaint();
            }
        }
        
        if(e.getSource() == viewAdminPerson.getRbtnAdd()){
            fillTypePerson();
        }
        
        if(e.getSource() == viewAdminPerson.getRbtnEdit()){
            viewAdminPerson.esconderMostrarTodo(true);
            viewAdminPerson.setTxtLblPerson("Persona:");
            viewAdminPerson.deshabilitarOpciones(false);
            modelAdminPerson.getPerson();
            fillPerson();
        }
        
        if(e.getSource() == viewAdminPerson.getBtnAccept()){ 
            modelAdminPerson.setFirstName(viewAdminPerson.getTxtName());
            modelAdminPerson.setSecondName(viewAdminPerson.getTxtSecondName());
            modelAdminPerson.setFirstLastName(viewAdminPerson.getTxtFirstLastName());
            modelAdminPerson.setSecondLastName(viewAdminPerson.getTxtSecondLastName());
            modelAdminPerson.setMail(viewAdminPerson.getTxtMail());
            modelAdminPerson.setAddress(viewAdminPerson.getTxtAddress());
            
            modelAdminPerson.setIdentification(viewAdminPerson.getTxtIdentification());
            modelAdminPerson.setPhone(viewAdminPerson.getTxtPhone());
            modelAdminPerson.setDateOfBirth(viewAdminPerson.getTxtDateOfBirth());
            modelAdminPerson.setNumTShirt(viewAdminPerson.getSpnNumTShirt());
            
            flagAdminPerson = true;
            //Add
            if(viewAdminPerson.getRbtnAdd().isSelected()){
                adminPersonValidations(); //Is going to validate
                if(flagAdminPerson == true){
                    createPerson();
                }
            }//SELECT BUTTON ADD
            
            if(viewAdminPerson.getRbtnEdit().isSelected()){
                String firstName;
                String secondName;
                String firstLastName;
                String secondLastName;
                String fullName; 
                int idPerson = -1;
                String choice = viewAdminPerson.getSelectedPerson();
                
                
                //PLAYER
                for(int j=0; j<modelAdminPerson.getPlayersComboBox().size();j++){
                    firstName = modelAdminPerson.getPlayersComboBox().get(j).getFirstName();
                    secondName = modelAdminPerson.getPlayersComboBox().get(j).getSecondName();
                    firstLastName = modelAdminPerson.getPlayersComboBox().get(j).getFirstLastName();
                    secondLastName = modelAdminPerson.getPlayersComboBox().get(j).getSecondLastName();
                    
                    fullName = fillFullName(firstName, firstLastName, secondName, secondLastName);

                    if(choice.equals(fullName)){
                        idPerson = modelAdminPerson.getPlayersComboBox().get(j).getIdPerson();
                    }
                }
                
                if(idPerson != -1){
                    for(int i=0; i<modelAdminPerson.getPlayersInfo().size();i++){
                        adminPersonValidations(); //Is going to validate
                        
                        if(flagAdminPerson == true){                            
                            updatesPlayer(idPerson, i);
                            if(flagAdminPerson == false){
                                
                                if(updateSuccessful()){
                                    JOptionPane.showMessageDialog(null, "La actualización se realizó con éxito", "Actualización", JOptionPane.INFORMATION_MESSAGE);                       
                                }else{
                                    JOptionPane.showMessageDialog(null, "Lo sentimos, no se logró realizar la actualización", "Error", JOptionPane.WARNING_MESSAGE);                       
                                }
                                                               
                            }else{
                                JOptionPane.showMessageDialog(null, "No se realizó ninguna actualización", "Actualización", JOptionPane.INFORMATION_MESSAGE);                      
                            }    
                        }                        
                    }
                }else{
                    //TEAMWORKER
                    for(int m=0; m<modelAdminPerson.getTeamWorkersComboBox().size();m++){
                        firstName = modelAdminPerson.getTeamWorkersComboBox().get(m).getFirstName();
                        secondName = modelAdminPerson.getTeamWorkersComboBox().get(m).getSecondName();
                        firstLastName = modelAdminPerson.getTeamWorkersComboBox().get(m).getFirstLastName();
                        secondLastName = modelAdminPerson.getTeamWorkersComboBox().get(m).getSecondLastName();
                    
                        fullName = fillFullName(firstName, firstLastName, secondName, secondLastName);

                        if(choice.equals(fullName)){
                            idPerson = modelAdminPerson.getTeamWorkersComboBox().get(m).getIdPerson();
                        }
                    }
                    
                    for(int p=0; p<modelAdminPerson.getTeamWorkersInfo().size();p++){
                        adminPersonValidations(); //Is going to validate
                        if(flagAdminPerson == true){                            
                            updatesTeamWorker(idPerson, p);
                            if(flagAdminPerson == false){
                                
                                if(updateSuccessful()){
                                    JOptionPane.showMessageDialog(null, "La actualización se realizó con éxito", "Actualización", JOptionPane.INFORMATION_MESSAGE);                       
                                }else{
                                    JOptionPane.showMessageDialog(null, "Lo sentimos, no se logró realizar la actualización", "Error", JOptionPane.WARNING_MESSAGE);                       
                                }
         
                            }else{
                                JOptionPane.showMessageDialog(null, "No se realizó ninguna actualización", "Actualización", JOptionPane.INFORMATION_MESSAGE);                      
                            }    
                        }                      
                    }
                          
                }
  
            } //SELECT BUTTON EDIT
            
        }
        
        //-------------- SCREEN AdminMatches -----------------------
        if(e.getSource() == viewAdminMatches.getBtnScheduleMatch()){
            viewAdminMatches.setVisible(false);
            viewScheduleMatch.setVisible(true);
        }
        
        if(e.getSource() == viewAdminMatches.getBtnAdminScheduledMatch()){
            viewAdminMatches.setVisible(false);
            viewAdminMatch.setVisible(true);
        }
        
        if(e.getSource() == viewAdminMatches.getBtnBack()){
            viewAdminMatches.setVisible(false);
            viewMenuAdmin.setVisible(true);
        }
        
        //-------------- SCREEN ScheduleMatch -----------------------
        
        if(e.getSource() == viewScheduleMatch.getBtnBack()){
            viewScheduleMatch.setVisible(false);
            viewAdminMatches.setVisible(true);
        }
        
        //-------------- SCREEN AdminMatche -----------------------
        if(e.getSource() == viewAdminMatch.getBtnBack()){
            viewAdminMatch.setVisible(false);
            viewAdminMatches.setVisible(true);
        }
    }
        
    
    public void showView()
     { 
        viewPrincipal.getBtnOpAdm().setVisible(false);
        viewPrincipal.getBtnRequests().setVisible(false);
        viewPrincipal.getBtnAccount().setVisible(false);
        viewPrincipal.getBtnExit().setVisible(false);
        viewPrincipal.getLblWelcome().setVisible(false);
        
        viewPrincipal.setVisible(true);
     }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource() == adminNewsController.getViewAdminNews().getTblNoticias().getSelectionModel() && flagEditNews){
            if(adminNewsController.getViewAdminNews().getTblNoticias().getRowCount() > 0){
                System.out.println("antes");
                int index = (int) adminNewsController.getViewAdminNews().getTblNoticias().getValueAt(adminNewsController.getViewAdminNews().getTblNoticias().getSelectedRow(),0);
                System.out.println("despues");
                adminNewsController.fillUpdateAdminNews(index);
            }
        }
        else{
            //modelNews.setIdNews(0);
            //adminNewsController.getViewAdminNews().getTblNoticias().clearSelection();
        }
    }
  
}
