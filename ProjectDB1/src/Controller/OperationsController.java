/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAccess.DA_SoccerMatch;
import Model.model_Account;
import Model.model_AdminMatches;
import Model.model_AdminParameters;
import Model.model_AdminPerson;
import Model.model_Login;
import Model.model_News;
import Model.model_Rating;
import Model.model_Register;
import Model.model_Stats;
import Objects.Match;
import Objects.News;
import View.JF_AdminMatch;
import View.JF_AdminMatches;
import View.JF_AdminOptions;
import View.JF_AdminOther;
import View.JF_AdminParameters;
import View.JF_AdminPerson;
import View.JF_EditAccount;
import View.JF_Login;
import View.JF_MyAccount;
import View.JF_Principal;
import View.JF_Register;
import View.JF_Request;
import View.JF_AdminScheduleMatch;
import View.JF_GeneralStats;
import View.JF_GroupStats;
import View.JF_News;
import View.JF_Rating;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;


import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


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
    private final JF_AdminScheduleMatch viewScheduleMatch;
    private final JF_AdminMatch viewAdminMatch; 
    private final JF_AdminOther viewAdminOther;
    private final JF_News viewNews;
    private final JF_Rating viewRating;
    private final JF_GeneralStats viewStats;
    private final JF_GroupStats viewGroupStats;
    
    
    private final model_Login modelLogin;
    private final model_Register modelRegister;
    private final model_AdminPerson modelAdminPerson;
    private final model_News modelNews;
    private final model_Account accountModel;
    private final model_AdminMatches modelAdminMatches;
    private final model_AdminParameters modelAdminParameters;
    private final model_Rating ratingModel;
    private final model_Stats modelStats;
    
    private boolean flagRegister;
    private boolean flagAdminPerson;
    private boolean flagEditNews = false;
    private boolean flagEditParameter = false;
    private boolean flagAddCatalogs;
    private boolean flagEditCatalogs;
    private boolean flagAdminOther;
    private boolean newsOpened = false;
    private boolean matchOpened = false;
    private boolean raffledPerformed = false;
    private boolean matchSelected = false;
    private boolean playerSelected = false;
    
    private final RequestController requestController;
    private final AdminNewsController adminNewsController;
    private final AdminCatalogsController adminCatalogsController;
    private final AdminParametersController adminParametersController;
    
    
    //Constructor 2da version
    public OperationsController(JF_Principal principal) throws SQLException { 
        //View Principal
        this.viewPrincipal = principal;
        
        //View News
        this.viewNews = new JF_News();
        
        //View Stats
        this.viewStats = new JF_GeneralStats();
        
        //View Group Stats
        this.viewGroupStats = new JF_GroupStats();
        
        //View Rating
        this.viewRating = new JF_Rating();
        
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
        
        //View AdminOther
        JF_AdminOther adminOther = new JF_AdminOther();
        this.viewAdminOther = adminOther;

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
        JF_AdminScheduleMatch scheduleMatch = new JF_AdminScheduleMatch();
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
        
        //Model Admin Parameters
        this.modelAdminParameters = new model_AdminParameters();
        
        // Model Rating
        this.ratingModel = new model_Rating();
        
        // Model Stats
        this.modelStats = new model_Stats();
        
        //Request Controller
        RequestController controller = new RequestController();
        this.requestController = controller;
        
        //AdminNews Controller
        AdminNewsController adminNController = new AdminNewsController(modelNews);
        this.adminNewsController = adminNController;
        
        //AdminCatalogs Controller
        AdminCatalogsController adminCatalogsController = new AdminCatalogsController();
        this.adminCatalogsController = adminCatalogsController;
        
        //AdminParameters Controller
        AdminParametersController adminParametersController = new AdminParametersController();
        this.adminParametersController = adminParametersController;
        
        _init_(); 
        
        
        fillGenders();
        fillIdentificationTypes();     
        fillCountries();
        fillPositions();
        fillTeams();
        fillTypePerson();
        fillContinent();
        viewPrincipal.showMostViewedNews();
        viewPrincipal.showLastNews();
        modelAdminMatches.fillTodayMatches(viewPrincipal);
        adminCatalogsController.fillCatalogs();

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
        viewPrincipal.getTblMostViewedNews().getSelectionModel().addListSelectionListener(this);
        viewPrincipal.getTblLastNews().getSelectionModel().addListSelectionListener(this);
        viewPrincipal.getBtnShowStats().addActionListener(this);
        
        //ViewStats
        viewStats.getBtnBack().addActionListener(this);
        viewStats.getBtnGroupTable().addActionListener(this);
        viewStats.getCmbGender().addItemListener(this);
        viewStats.getCmbGroup().addItemListener(this);
        viewStats.getCmbTeam().addItemListener(this);
        viewStats.getCmbNewsEvent().addItemListener(this);
        viewStats.getBtnSearchAge().addActionListener(this);
        
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
        viewMenuAdmin.getBtnAdmiParametros().addActionListener(this);
        viewMenuAdmin.getBtnBitacora().addActionListener(this);
        viewMenuAdmin.getBtnAdmiOther().addActionListener(this);
        
        //AdminMatches
        viewAdminMatches.getBtnGroupRaffle().addActionListener(this);
        viewAdminMatches.getBtnScheduleMatch().addActionListener(this);
        viewAdminMatches.getBtnAdminScheduledMatch().addActionListener(this);
        viewAdminMatches.getBtnBack().addActionListener(this);
        
        //AdminScheduleMatch
        viewScheduleMatch.getBtnBack().addActionListener(this);
        viewScheduleMatch.getBtnSave().addActionListener(this);
        
        viewScheduleMatch.getCbmTeam1().addItemListener(this);
        viewScheduleMatch.getCbmTeam2().addItemListener(this);
        viewScheduleMatch.getCbmStadium().addItemListener(this);
        viewScheduleMatch.getCbmGroup().addItemListener(this);
        
        //AdminMatch
        viewAdminMatch.getBtnBack().addActionListener(this);
        viewAdminMatch.getBtnSaveInfo().addActionListener(this);
        viewAdminMatch.getCmbIdPlayer().addItemListener(this);
        viewAdminMatch.getCmbMatches().addItemListener(this);
        
        
        //AdminNews
        adminNewsController.getViewAdminNews().getRbtnAgregar().addActionListener(this);
        adminNewsController.getViewAdminNews().getRbtnEditar().addActionListener(this);
        
        adminNewsController.getViewAdminNews().getCmbEstado().addActionListener(this);
        adminNewsController.getViewAdminNews().getCmbTipo().addActionListener(this);
        
        adminNewsController.getViewAdminNews().getBtnAceptar().addActionListener(this);
        adminNewsController.getViewAdminNews().getBtnBack().addActionListener(this);
        adminNewsController.getViewAdminNews().getBtnCargarImagen().addActionListener(this);
        //adminNewsController.getViewAdminNews().getTblNoticias().getSelectionModel().addListSelectionListener(this);
 
        adminNewsController.getViewAdminNews().getCmbSelectNews().addItemListener(this);
        
        //AdminCatalogOption
        adminCatalogsController.getViewAdminCatalogs().getBtnBack().addActionListener(this);
               
        //AdminParameters
        adminParametersController.getViewAdminParameters().getBtnAceptar().addActionListener(this);
        adminParametersController.getViewAdminParameters().getBtnBack().addActionListener(this);
        adminParametersController.getViewAdminParameters().getRbtnAgregar().addActionListener(this);
        adminParametersController.getViewAdminParameters().getRbtnEditar().addActionListener(this);
        //adminParametersController.getViewAdminParameters().getTblParametros().getSelectionModel().addListSelectionListener(this);
        adminParametersController.getViewAdminParameters().getCmbSelectParameters().addItemListener(this);
        
        //Request
        viewRequest.getBtnBackRequest().addActionListener(this);
        
        //MyAccount
        viewMyAccount.getBtnBackMyAccount().addActionListener(this);
        viewMyAccount.getBtnEditProfile().addActionListener(this);
        
        //EditAccount
        viewEditAccount.getBtnBack().addActionListener(this);
        viewEditAccount.getBtnConfirm().addActionListener(this);
        viewEditAccount.getBtnLoadPicture().addActionListener(this);
        
        //News
       viewNews.getBtnBack().addActionListener(this);
       viewNews.getBtnComment().addActionListener(this);
       viewNews.getBtnRating().addActionListener(this);
       
       //Rating
       viewRating.getBtnBack().addActionListener(this);
       viewRating.getBtnConfirm().addActionListener(this);
       viewRating.getBtnStar1().addActionListener(this);
       viewRating.getBtnStar2().addActionListener(this);
       viewRating.getBtnStar3().addActionListener(this);
       viewRating.getBtnStar4().addActionListener(this);
       viewRating.getBtnStar5().addActionListener(this);
        
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
        adminCatalogsController.getViewAdminCatalogs().getCmbSelect().addItemListener(this);
        adminCatalogsController.getViewAdminCatalogs().getBtnAccept().addActionListener(this);
        
        adminCatalogsController.getViewAdminCatalogs().getRbtnAdd().addActionListener(this);
        adminCatalogsController.getViewAdminCatalogs().getRbtnDelete().addActionListener(this);
        adminCatalogsController.getViewAdminCatalogs().getRbtnEdit().addActionListener(this);
         
        
        //AdminOther
        viewAdminOther.getBtnBack().addActionListener(this);
        viewAdminOther.getBtnAdd().addActionListener(this);
        viewAdminOther.getBtnUploadFlag().addActionListener(this);
        viewAdminOther.getCmbContinent().addItemListener(this);
        viewAdminOther.getCmbCountry().addItemListener(this);
        
    }
    
    
    //-------- COMBO BOX FILLING --------------------------
    private void fillGenders(){
        viewRegister.getCmbGender().removeAllItems();
        viewAdminPerson.getCmbGender().removeAllItems();

        
        
        viewRegister.getCmbGender().addItem("Seleccione G??nero");
        viewAdminPerson.getCmbGender().addItem("Seleccione G??nero");
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
        viewAdminOther.getCmbCountry().removeAllItems();
        
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
        
        viewRegister.getCmbCountry().addItem("Seleccione Pa??s");
        viewAdminPerson.getCmbCountry().addItem("Seleccione Pa??s");
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
        
        viewRegister.getCmbCanton().addItem("Seleccione Cant??n");
        viewAdminPerson.getCmbCanton().addItem("Seleccione Cant??n");
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
        
        viewAdminPerson.getCmbTypePosition().addItem("Seleccione Posici??n");
        for(int i=0; i<modelAdminPerson.getPositions().size();i++){
            String namePosition = modelAdminPerson.getPositions().get(i).getDescriptionPersonPosition();
            viewAdminPerson.getCmbTypePosition().addItem(namePosition);
        }
    }
    
    private void fillTeam1(int idGroup){
        viewScheduleMatch.getCbmTeam1().setEnabled(true);
        viewScheduleMatch.getCbmTeam1().removeAllItems();
        
        int idGroupArr, idTeamArr, idTeam;
        String nameTeam;
        viewScheduleMatch.getCbmTeam1().addItem("Seleccione Equipo");

        for(int i=0; i<modelAdminMatches.getTeamxgroup().size();i++){

            idGroupArr = modelAdminMatches.getTeamxgroup().get(i).getIdGroup();

            if(idGroupArr == idGroup){

                idTeamArr = modelAdminMatches.getTeamxgroup().get(i).getIdTeam();

                for(int j=0; j<modelAdminPerson.getTeams().size();j++){
                    nameTeam = modelAdminPerson.getTeams().get(j).getNameTeam();
                    idTeam = modelAdminPerson.getTeams().get(j).getIdTeam();

                    if(idTeamArr == idTeam){
                        viewScheduleMatch.getCbmTeam1().addItem(nameTeam);
                    }  
                }
            }
        }
    }
    
    
    private void fillTeam2(int idGroup){
        viewScheduleMatch.getCbmTeam2().setEnabled(true);
        viewScheduleMatch.getCbmTeam2().removeAllItems();

        int idGroupArr, idTeamArr, idTeam;
        String nameTeam;
        
        String nameTeamSelected = viewScheduleMatch.getCbmTeam1().getSelectedItem().toString();
        
        viewScheduleMatch.getCbmTeam2().addItem("Seleccione Equipo");

        for(int i=0; i<modelAdminMatches.getTeamxgroup().size();i++){

            idGroupArr = modelAdminMatches.getTeamxgroup().get(i).getIdGroup();

            if(idGroupArr == idGroup){

                idTeamArr = modelAdminMatches.getTeamxgroup().get(i).getIdTeam();

                for(int j=0; j<modelAdminPerson.getTeams().size();j++){
                    nameTeam = modelAdminPerson.getTeams().get(j).getNameTeam();
                    idTeam = modelAdminPerson.getTeams().get(j).getIdTeam();

                    if(idTeamArr == idTeam && !nameTeam.equals(nameTeamSelected)){
                        viewScheduleMatch.getCbmTeam2().addItem(nameTeam);
                    }  
                }
            }
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
        viewAdminPerson.showPlayerOptions(true);
        viewAdminPerson.disableManagerOptions(false);
        viewAdminPerson.getCmbPerson().removeAllItems();
        viewAdminPerson.getCmbPerson().addItem("Seleccione Tipo Persona");
        viewAdminPerson.getCmbPerson().addItem("Jugador");
        viewAdminPerson.getCmbPerson().addItem("Cuerpo T??cnico");
        viewAdminPerson.getCmbPerson().addItem("Administrador");
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
        String firstName, secondName, firstLastName, secondLastName, fullName;
        
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
        String name, province, canton,secondName, firstLastName, secondLastName,typeIdentification, country, district,gender, team, position,  mail, address,  birthdate;
        int  idTypeIdentification, identification, idGender, idTeam, idPosition, numTShirt, phoneNumber, idCountry,idProvince, idCanton, idDistrict;  

    
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
        String name, secondName, firstLastName, secondLastName,typeIdentification, gender, team, position,  mail, address, country, province, canton, district;
        int idTypeIdentification, identification, idGender, idTeam, idPosition, phoneNumber, idCountry, idProvince, idCanton, idDistrict;

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
    
    private void fillStadiums(){
        viewScheduleMatch.getCbmStadium().removeAllItems();
        
        viewScheduleMatch.getCbmStadium().addItem("Seleccione Estadio");
         for(int i=0; i<modelAdminMatches.getStadiums().size();i++){
           viewScheduleMatch.getCbmStadium().addItem(modelAdminMatches.getStadiums().get(i).getNameStadium());
        }
    }
    
    private void fillGroup(){
        viewScheduleMatch.getCbmGroup().removeAllItems();
        
        viewScheduleMatch.getCbmGroup().addItem("Seleccione Grupo");
         for(int i=0; i<modelAdminMatches.getGroups().size();i++){
           viewScheduleMatch.getCbmGroup().addItem(modelAdminMatches.getGroups().get(i).getDescriptionGroup());
        }
    }
    
    private void fillCountryTeam(int idContinent){
        viewAdminOther.getCmbCountry().setEnabled(true);
        viewAdminOther.getCmbCountry().removeAllItems();
        String nameCountry;
        int idContinentArr;
        
        viewAdminOther.getCmbCountry().addItem("Seleccione Pa??s");
        for(int k=0; k<modelAdminMatches.getCountryTeams().size();k++){    
            nameCountry = modelAdminMatches.getCountryTeams().get(k).getNameCountryTeam();
            idContinentArr = modelAdminMatches.getCountryTeams().get(k).getIdContinent();   
            
            if(idContinent == idContinentArr){
                viewAdminOther.getCmbCountry().addItem(nameCountry);
            }     
        }
    
    }
    
    private void fillContinent(){
        viewAdminOther.getCmbContinent().removeAllItems();
        String nameContinent;
        
        viewAdminOther.getCmbContinent().addItem("Seleccione Continente");
        for(int i=0; i<modelAdminMatches.getContinents().size();i++){
            nameContinent = modelAdminMatches.getContinents().get(i).getNameContinent();
            viewAdminOther.getCmbContinent().addItem(nameContinent);
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

                JOptionPane.showMessageDialog(null, "Formato inv??lido. \nRecuerde solo ingresar letras en el Nombre y Primer Apellido", "Error", JOptionPane.WARNING_MESSAGE);


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

                        JOptionPane.showMessageDialog(null, "Formato inv??lido. \nRecuerde solo ingresar letras en el Segundo Nombre", "Error", JOptionPane.WARNING_MESSAGE);

                        viewRegister.cleanSecondName();
                        flagRegister = false;
                    }
                }

                if(modelRegister.validateSecondLastName(modelRegister.getSecondLastName())){

                    if(modelRegister.validateFormatString(modelRegister.getSecondLastName()) == false){

                        JOptionPane.showMessageDialog(null, "Formato inv??lido. \nRecuerde solo ingresar letras en el Segundo Apellido", "Error", JOptionPane.WARNING_MESSAGE);

                        viewRegister.cleanSecondLastName();
                        flagRegister = false;
                    }   
                }

            }


            if(modelRegister.validateFormatMail(modelRegister.getMail()) == false){ 
                JOptionPane.showMessageDialog(null, "Formato de correo no v??lido", "Error", JOptionPane.WARNING_MESSAGE);
                viewRegister.cleanMail();
                flagRegister = false;
            }


            if(modelRegister.validateFormatUsername(viewRegister.getTxtUsername()) == false){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese ??nicamente letras, n??meros o el caracter _ para crear su username.\nDebe tener al menos 5 caracteres y sin espacios.", "Error", JOptionPane.WARNING_MESSAGE);
                viewRegister.cleanUsername();
                flagRegister = false;
            }

            if(modelRegister.validateFormatPassword(viewRegister.getTxtPassword()) == false){
                JOptionPane.showMessageDialog(null, "Formato de contrase??a incorrecta.\nDebe contener entre 4 y 16 caracteres, al menos un d??gito, al menos una min??scula y al menos una may??scula.", "Error", JOptionPane.WARNING_MESSAGE);
                viewRegister.cleanPassword();
                flagRegister = false;
            }

            if(modelRegister.validateFormatAddress(modelRegister.getAddress()) == false){
                JOptionPane.showMessageDialog(null, "Direcci??n no v??lida.\nDebe contener un m??nimo de 50 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
                viewRegister.cleanAddress();
                flagRegister = false;
            }

            if(modelRegister.validatePhoto(modelRegister.getPhoto())){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una foto", "Error", JOptionPane.WARNING_MESSAGE);
                flagRegister = false;
            }

            if(viewRegister.validateTxtPhone()){
                JOptionPane.showMessageDialog(null, "Debe ingresar un n??mero de tel??fono", "Error", JOptionPane.WARNING_MESSAGE);
                flagRegister = false;
            }

            if(viewRegister.validateTxtIdentification()){
                JOptionPane.showMessageDialog(null, "Debe ingresar una identificaci??n", "Error", JOptionPane.WARNING_MESSAGE);
                flagRegister = false;
            }

            if(modelLogin.userAlreadyExists(viewRegister.getTxtUsername())){
                JOptionPane.showMessageDialog(null, "Username ya existente. Debe ingresar un username diferente", "Error", JOptionPane.WARNING_MESSAGE);
                viewRegister.cleanUsername();
                flagRegister = false;
            }
            
            
            if(modelRegister.identificationAlreadyExists(viewRegister.getTxtIdentification())== true){
                JOptionPane.showMessageDialog(null, "Identificaci??n ya existente. Debe ingresar una identificaci??n diferente", "Error", JOptionPane.WARNING_MESSAGE);
                viewRegister.cleanIdentification();
                flagRegister = false;
            }
            
        }
    }//END REGISTERVALIDATONS
    
    private void createUser(){
        modelRegister.inserUser();

        JOptionPane.showMessageDialog(null, "Felicidades, su cuenta se cre?? correctamte.\nInicie sesi??n para comenzar a disfrutar de nuestra aplicaci??n" );
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

                viewPrincipal.setTxtLblWelcome("BIENVENIDO/A"+" "+modelLogin.getUsernameLogin());
                viewPrincipal.getLblWelcome().setVisible(true);

                if(modelLogin.validateUserType() == true){ //Es true -> Admin
                    //Frame de Admin                         
                    viewPrincipal.getBtnOpAdm().setVisible(true);
                }
                modelLogin.setLogged(true);
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
            JOptionPane.showMessageDialog(null, "Noticia creada con ??xito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios solicitados", "Error", JOptionPane.WARNING_MESSAGE);            
        }
    }
    
    private void adminNewsValidationsUpdate(String choice1, String choice2){
        System.out.println(modelNews.validatePhoto());
        if(modelNews.validateEmptyFields() && modelNews.validatePhoto() && choice1 != "Seleccione Estado" && choice2 != "Seleccione Tipo"){
            adminNewsController.getViewAdminNews().getTblNoticias().clearSelection();
            modelNews.updateNews();
            adminNewsController.fillAdminNews();
            if(updateNewsSuccessful()){
                adminNewsRestore();
                JOptionPane.showMessageDialog(null, "Noticia editada con ??xito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);            
            }
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
    
    //------------ VALIDATIONS ADMINPARAMETERS ---------------------------    
    private void adminParametersValidationsInsert(){
        if(modelAdminParameters.validateEmptyFields()){
            modelAdminParameters.insertParameter();
            adminParametersController.fillAdminParameters();
            adminParametersController.getViewAdminParameters().clearAll();
            JOptionPane.showMessageDialog(null, "Par??metro creado con ??xito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios solicitados", "Error", JOptionPane.WARNING_MESSAGE);            
        }
        
    }
    
    private void adminParametersValidationsUpdate(){
        if(modelAdminParameters.validateEmptyFields()){
            modelAdminParameters.updateParameter();
            adminParametersController.fillAdminParameters();
            adminParametersController.getViewAdminParameters().clearAll();
            JOptionPane.showMessageDialog(null, "Par??metro creado con ??xito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios solicitados", "Error", JOptionPane.WARNING_MESSAGE);            
        }
    }
    
    //------------ VALIDATIONS AND CREATE ADMIN PERSON ---------------------------
    private void adminPersonValidations(){
        if(modelAdminPerson.validateEmptyFieldsAdminPerson()){
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios solicitados", "Error", JOptionPane.WARNING_MESSAGE);
            flagAdminPerson = false;
        }else{
            if(modelRegister.validateFormatString(modelAdminPerson.getFirstName()) == false ||  modelRegister.validateFormatString(modelAdminPerson.getFirstLastName())== false)
            {
                JOptionPane.showMessageDialog(null, "Formato inv??lido. \nRecuerde solo ingresar letras en el Nombre y Primer Apellido", "Error", JOptionPane.WARNING_MESSAGE);


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

                        JOptionPane.showMessageDialog(null, "Formato inv??lido. \nRecuerde solo ingresar letras en el Segundo Nombre", "Error", JOptionPane.WARNING_MESSAGE);

                        viewAdminPerson.cleanSecondName();
                        flagAdminPerson = false;
                    }    
                }

                if(modelRegister.validateSecondLastName(modelAdminPerson.getSecondLastName())){

                    if(modelRegister.validateFormatString(modelAdminPerson.getSecondLastName()) == false){

                        JOptionPane.showMessageDialog(null, "Formato inv??lido. \nRecuerde solo ingresar letras en el Segundo Apellido", "Error", JOptionPane.WARNING_MESSAGE);

                        viewAdminPerson.cleanSecondLastName();
                        flagAdminPerson = false;
                    }   
                }
            }

            if(modelRegister.validateFormatMail(modelAdminPerson.getMail()) == false){ 
                JOptionPane.showMessageDialog(null, "Formato de correo no v??lido", "Error", JOptionPane.WARNING_MESSAGE);
                viewAdminPerson.cleanMail();
                flagAdminPerson = false;
            }


            if(modelRegister.validateFormatAddress(modelAdminPerson.getAddress()) == false){
                JOptionPane.showMessageDialog(null, "Direcci??n no v??lida.\nDebe contener un m??nimo de 50 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
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

            if("Seleccione G??nero".equals(viewAdminPerson.getSelectedGender())){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un g??nero", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }

            if("Seleccione Tipo".equals(viewAdminPerson.getSelectedTypeIdentification())){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de identificaci??n", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }

            if(viewAdminPerson.validateTxtPhone()){
                JOptionPane.showMessageDialog(null, "Debe ingresar un n??mero de tel??fono", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }

            if(viewAdminPerson.validateTxtIdentification()){
                JOptionPane.showMessageDialog(null, "Debe ingresar una identificaci??n", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }
            
            if(modelRegister.identificationAlreadyExists(viewAdminPerson.getTxtIdentification())== true){
                JOptionPane.showMessageDialog(null, "Identificaci??n ya existente. Debe ingresar una identificaci??n diferente", "Error", JOptionPane.WARNING_MESSAGE);
                flagAdminPerson = false;
            }
            
        }//VALIDATE EMPTY FIELDS
    }
    
    private void validationsAdmin(){
        if(modelAdminPerson.validateAdminFields()){
            JOptionPane.showMessageDialog(null, "Por favor, complete el username y/o password solicitado.", "Error", JOptionPane.WARNING_MESSAGE);
        }

        if(modelRegister.validateFormatUsername(modelAdminPerson.getUsernameAdminPerson())== false){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese ??nicamente letras, n??meros o el caracter _ para crear su username.\nDebe tener al menos 5 caracteres y sin espacios.", "Error", JOptionPane.WARNING_MESSAGE);
            //FALTA CLEAN Username
            flagAdminPerson = false;
        }

        if(modelRegister.validateFormatPassword(modelAdminPerson.getPasswordAdminPerson())== false){
            JOptionPane.showMessageDialog(null, "Formato de contrase??a incorrecta.\nDebe contener entre 4 y 16 caracteres, al menos un d??gito, al menos una min??scula y al menos una may??scula.", "Error", JOptionPane.WARNING_MESSAGE);
            //FALTA CLEAN Password
            flagAdminPerson = false;
        }


        if(modelLogin.userAlreadyExists(modelAdminPerson.getUsernameAdminPerson())){
            JOptionPane.showMessageDialog(null, "Username ya existente. Debe ingresar un username diferente", "Error", JOptionPane.WARNING_MESSAGE);
            //FALTA CLEAN Username
            flagAdminPerson = false;
        }  
    
    
    }
    
    private void validationsPlayer(){
        if("Seleccione Posici??n".equals(viewAdminPerson.getSelectedPosition())){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de posici??n", "Error", JOptionPane.WARNING_MESSAGE);
            flagAdminPerson = false;
        }

        if("Seleccione Equipo".equals(viewAdminPerson.getSelectedTeam())){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo", "Error", JOptionPane.WARNING_MESSAGE);
            flagAdminPerson = false;
        }
        
        if(viewAdminPerson.validateTxtDateOfBirth()){
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha de nacimiento", "Error", JOptionPane.WARNING_MESSAGE);
            flagAdminPerson = false;
        }
    }
    
    private void validationStaff(){
        if("Seleccione Posici??n".equals(viewAdminPerson.getSelectedPosition())){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de posici??n", "Error", JOptionPane.WARNING_MESSAGE);
            flagAdminPerson = false;
        }

        if("Seleccione Equipo".equals(viewAdminPerson.getSelectedTeam())){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo", "Error", JOptionPane.WARNING_MESSAGE);
            flagAdminPerson = false;
        }
    }
    
    private void createPerson(){
        if("Jugador".equals(viewAdminPerson.getTxtCmbPerson())){
            modelAdminPerson.inserPlayer();
        }else{
            if("Cuerpo T??cnico".equals(viewAdminPerson.getTxtCmbPerson())){
                 modelAdminPerson.inserTeamWorker();
            }else{
                modelAdminPerson.inserUser();
            } 
        }

        if(modelAdminPerson.getResultInsertPerson() == 0){
            JOptionPane.showMessageDialog(null, "Se ha creado la persona");
        }else{
            JOptionPane.showMessageDialog(null, "Lo sentimos, no se logro crear la persona", "Error", JOptionPane.WARNING_MESSAGE);
        }

        viewAdminPerson.cleanAll();
        viewAdminPerson.setCmbPersona("Seleccione Tipo Persona");
        viewAdminPerson.setSpnNumCamisa(1);
        
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
    
    private void editPerson(){
        if(updateSuccessful()){
            JOptionPane.showMessageDialog(null, "La actualizaci??n se realiz?? con ??xito", "Actualizaci??n", JOptionPane.INFORMATION_MESSAGE);                           
        }else{
            JOptionPane.showMessageDialog(null, "Lo sentimos, no se logr?? realizar la actualizaci??n", "Error", JOptionPane.WARNING_MESSAGE);                       
        }
        
        viewAdminPerson.cleanAll();
        viewAdminPerson.setCmbPersona("Seleccione Persona");
        viewAdminPerson.setSpnNumCamisa(1);

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
    
    // ---------------- VALIDATIONS ADMIN MATCHES ----------------
    private boolean validateTeamExist(){
        if(modelAdminMatches.validateTeamExist() == false){
             JOptionPane.showMessageDialog(null, "Debe crear equipos antes de realizar alguna de estas acciones", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean validateGroupExist(){
        if(modelAdminMatches.validateGroupExist() == false){
            JOptionPane.showMessageDialog(null, "Debe crear grupos antes de realizar alguna de estas acciones", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private boolean validateSoccerMatchExist(){
        if(this.modelAdminMatches.validateSoccerMatchExist() == false){
             JOptionPane.showMessageDialog(null, "Por el momento no se puede administrador un partido ya que a??n no hay partidos programados.", "Error", JOptionPane.WARNING_MESSAGE);
             return false;
        }
        return true;
    }
    
    //----------------SHOW MORE VIEWED AND LAST NEWS ----------------------------------
    
    
    //-------------------------------------------------------------------------------------------------------
    
    @Override
    public void itemStateChanged(ItemEvent e){
        //COUNTRY -> REGISTER
        if( e.getSource() == viewRegister.getCmbCountry()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewRegister.getSelectedCountry();
                
                
                if(!"Seleccione Pa??s".equals(choice)){
                    
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
                
                
                if(!"Seleccione Pa??s".equals(choice)){
                    
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
        
        //ComboEvent Stats
        if(e.getSource() == viewStats.getCmbNewsEvent()){
            String selected;
            try{
                selected = viewStats.getCmbNewsEvent().getSelectedItem().toString();
            }catch(Exception ex){
                selected = "--------------";
            }
            
            if("--------------".equals(selected)){
                viewStats.getLblNewsEvent().setText("0");
            }else{
                modelStats.getNewsPublished(viewStats);
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
        
        // Admin Scheduled Match 
        
        if(e.getSource() == viewAdminMatch.getCmbMatches() && matchOpened){
            if(!"-----".equals(viewAdminMatch.getCmbMatches().getSelectedItem().toString())){
                modelAdminMatches.setSelectedMatch(viewAdminMatch);
                modelAdminMatches.fillListsOfPlayers(viewAdminMatch);
                viewAdminMatch.updateInfo(modelAdminMatches.getSelectedMatch());
                matchSelected = true;
            }else{
                viewAdminMatch.matchNotSelected();
                matchSelected = false;
            }
        }
        
        if(e.getSource() == viewAdminMatch.getCmbIdPlayer() && matchSelected){
            try{
                if(!"-----".equals(viewAdminMatch.getCmbIdPlayer().getSelectedItem().toString())){
                    modelAdminMatches.setIdPlayerSelected(Integer.parseInt(viewAdminMatch.getCmbIdPlayer().getSelectedItem().toString()));
                    modelAdminMatches.updateStats();
                    modelAdminMatches.getNameSelectedPlayer(viewAdminMatch);
                    viewAdminMatch.updateStats(modelAdminMatches.getCurrentStats());
                    this.playerSelected = true;
                
                }else{
                    viewAdminMatch.playerNotSelected();
                    this.playerSelected = false;
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        
        
        //CANTON -> REGISTER
        if( e.getSource() == viewRegister.getCmbCanton()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewRegister.getSelectedCanton();
                
                
                if(!"Seleccione Cant??n".equals(choice)){
                    
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
                
                
                if(!"Seleccione Cant??n".equals(choice)){
                    
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
                if(!"Seleccione G??nero".equals(choice)){
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
                if(!"Seleccione G??nero".equals(choice)){
                                    
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
                if(!"Seleccione Posici??n".equals(choice)){
                                    
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
                String firstName, secondName, firstLastName, secondLastName, fullName;
                String choice = viewAdminPerson.getSelectedPerson();
                
                
                if(viewAdminPerson.getRbtnAdd().isSelected()){
                    if("Jugador".equals(choice)){
                        viewAdminPerson.showPlayerOptions(true);
                        viewAdminPerson.disableManagerOptions(false);
                    }
                    
                    
                    if("Cuerpo T??cnico".equals(choice)){
                       viewAdminPerson.showTechnicalStaffOptions(true);
                       viewAdminPerson.disablePlayerOptions(false);
                       viewAdminPerson.disableManagerOptions(false);
                    }
                    
                    if("Administrador".equals(choice)){
                        viewAdminPerson.showManagerOptions(true);
                        viewAdminPerson.disablePlayerOptions(false);
                        viewAdminPerson.disableTechnicalStaffOptions(false);
                    }
                
                }

                //EDIT
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
                                viewAdminPerson.disableManagerOptions(false);
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
                                viewAdminPerson.disablePlayerOptions(false);
                                viewAdminPerson.disableManagerOptions(false);
                                fillTeamWorkerInformation();
                            }
                        }
                         
                    }else{
                        viewAdminPerson.cleanAll();
                        
                        viewAdminPerson.setTypeIdentification("Seleccione Tipo");
                        viewAdminPerson.setTeam("Seleccione Equipo");
                        viewAdminPerson.setPosition("Seleccione Posici??n");
                        viewAdminPerson.setGender("Seleccione G??nero");
                    }    
                }
            } 
        }
                
        //ADMIN SCHEDULE MATCH
        if(e.getSource() == viewScheduleMatch.getCbmGroup()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewScheduleMatch.getCbmGroup().getSelectedItem().toString();
                if(!"Seleccione Grupo".equals(choice)){
                    
                    for(int i=0; i<modelAdminMatches.getGroups().size();i++){
                        String nameGroup = modelAdminMatches.getGroups().get(i).getDescriptionGroup();
                        
                        if(choice.equals(nameGroup)){
                            int idGroup = modelAdminMatches.getGroups().get(i).getIdGroup();
                            fillTeam1(idGroup);
                        }                        
                    }
                    
                }else{
                    viewScheduleMatch.getCbmTeam1().removeAllItems();
                    viewScheduleMatch.getCbmTeam1().setEnabled(false);
                    
                    viewScheduleMatch.getCbmTeam2().removeAllItems();
                    viewScheduleMatch.getCbmTeam2().setEnabled(false);         
                }
            }     
        }
        
        
        //TEAM 1 -> ADMIN SCHEDULE MATCH
        if(e.getSource() == viewScheduleMatch.getCbmTeam1()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choiceGroup = viewScheduleMatch.getCbmGroup().getSelectedItem().toString();
                String choice = viewScheduleMatch.getCbmTeam1().getSelectedItem().toString();                                
                for(int i=0; i<modelAdminMatches.getGroups().size();i++){
                    String nameGroup = modelAdminMatches.getGroups().get(i).getDescriptionGroup();

                    if(choiceGroup.equals(nameGroup)){
                        int idGroup = modelAdminMatches.getGroups().get(i).getIdGroup();

                        if(!"Seleccione Equipo".equals(choice)){
                            fillTeam2(idGroup);
                        }

                    }                        
                }           
            }     
        }
        
        //CONTINENT -> ADMIN OTHER
        if(e.getSource() == viewAdminOther.getCmbContinent()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewAdminOther.getCmbContinent().getSelectedItem().toString();
                String nameContinent;
                int idContinent;
                
                if(!"Seleccione Continente".equals(choice)){
                    for(int i=0; i<modelAdminMatches.getContinents().size();i++){
                        nameContinent = modelAdminMatches.getContinents().get(i).getNameContinent();
                        if(choice.equals(nameContinent)){
                            idContinent = modelAdminMatches.getContinents().get(i).getIdContinent();
                            System.out.println(idContinent);
                            fillCountryTeam(idContinent);
                        }
                    }
                }else{
                    viewAdminOther.getCmbCountry().setEnabled(false);
                }     
            }   
        }
        
        //COUNTRYTEAM -> ADMIN OTHER
        if(e.getSource() == viewAdminOther.getCmbCountry()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewAdminOther.getCmbCountry().getSelectedItem().toString();
                String nameCountryTeam;
                int idCountryTeam;
                
                if(!"Seleccione Pa??s".equals(choice)){
                    for(int i=0; i<modelAdminMatches.getCountryTeams().size();i++){
                        nameCountryTeam = modelAdminMatches.getCountryTeams().get(i).getNameCountryTeam();
                        if(choice.equals(nameCountryTeam)){
                            idCountryTeam = modelAdminMatches.getCountryTeams().get(i).getIdCountryTeam();
                            modelAdminMatches.setIdCountryTeam(idCountryTeam);
                        }
                    }
                }    
            }   
        }
        
        if(e.getSource() == adminNewsController.getViewAdminNews().getCmbSelectNews()){
            if(adminNewsController.getViewAdminNews().getCmbSelectNews().getItemCount() > 0){
                int index = Integer.parseInt(adminNewsController.getViewAdminNews().getCmbSelectNews().getSelectedItem().toString());
                modelNews.setIdNews(index);
                adminNewsController.fillUpdateAdminNews(index);
            }
        }
        
        if(e.getSource() == adminParametersController.getViewAdminParameters().getCmbSelectParameters()){
            if(adminParametersController.getViewAdminParameters().getCmbSelectParameters().getItemCount() > 0){
                int index = Integer.parseInt(adminParametersController.getViewAdminParameters().getCmbSelectParameters().getSelectedItem().toString());
                modelAdminParameters.setIdParameter(index);
                adminParametersController.fillUpdateAdminParameters(index);
            }
        }
               

        //ADMIN CATALOGS
        if(e.getSource() == adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                adminCatalogsController.fillCatalogs();
            }
        }
        
        
        
        if(e.getSource() ==  adminCatalogsController.getViewAdminCatalogs().getCmbSelect()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice1 = adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString();
                String choice2 = adminCatalogsController.getViewAdminCatalogs().getCmbSelect().getSelectedItem().toString();
                int id = Integer.parseInt(choice2);
                
                if(adminCatalogsController.getViewAdminCatalogs().getRbtnAdd().isSelected() == false){
                    if("G??nero".equals(choice1)){
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getGenders().size();i++){
                            if(id == adminCatalogsController.getModelAdminCatalogs().getGenders().get(i).getIdGender()){
                                String gender = adminCatalogsController.getModelAdminCatalogs().getGenders().get(i).getDescriptionGender();
                                adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete(gender);
                            }
                        }
                    }

                    if("Posici??n".equals(choice1)){
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getPositions().size();i++){
                            if(id == adminCatalogsController.getModelAdminCatalogs().getPositions().get(i).getIdPersonPosition()){
                                String position = adminCatalogsController.getModelAdminCatalogs().getPositions().get(i).getDescriptionPersonPosition();
                                adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete(position);
                            }
                        }
                    }

                    if("Pa??s".equals(choice1)){
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getCountries().size();i++){
                            if(id == adminCatalogsController.getModelAdminCatalogs().getCountries().get(i).getIdCountry()){
                                String country = adminCatalogsController.getModelAdminCatalogs().getCountries().get(i).getNameCountry();
                                adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete(country);
                            }
                        }
                    }
                    
                    if("Continente".equals(choice1)){
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getContinents().size();i++){
                            if(id == adminCatalogsController.getModelAdminCatalogs().getContinents().get(i).getIdContinent()){
                                String continent = adminCatalogsController.getModelAdminCatalogs().getContinents().get(i).getNameContinent();
                                adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete(continent);
                            }
                        }
                    }
                    
                    
                    if("Provincia".equals(choice1)){
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getProvinces().size();i++){
                            if(id == adminCatalogsController.getModelAdminCatalogs().getProvinces().get(i).getIdProvince()){
                                String province = adminCatalogsController.getModelAdminCatalogs().getProvinces().get(i).getNameProvince();
                                adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete(province);
                            }
                        }
                    }
                    
                   if("Cant??n".equals(choice1)){
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getCantons().size();i++){
                            if(id == adminCatalogsController.getModelAdminCatalogs().getCantons().get(i).getIdCanton()){
                                String canton = adminCatalogsController.getModelAdminCatalogs().getCantons().get(i).getNameCanton();
                                adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete(canton);
                            }
                        }
                    }
                   
                   
                    if("Distrito".equals(choice1)){
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getDistricts().size();i++){
                            if(id == adminCatalogsController.getModelAdminCatalogs().getDistricts().get(i).getIdDistrict()){
                                String district = adminCatalogsController.getModelAdminCatalogs().getDistricts().get(i).getNameDistrict();
                                adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete(district);
                            }
                        }
                    }
                    
                    if("Pa??s de Equipo".equals(choice1)){
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getCountryTeams().size();i++){
                            if(id == adminCatalogsController.getModelAdminCatalogs().getCountryTeams().get(i).getIdCountryTeam()){
                                String countryTeam = adminCatalogsController.getModelAdminCatalogs().getCountryTeams().get(i).getNameCountryTeam();
                                adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete(countryTeam);
                            }
                        }
                    }
                   
                    
                    if("Tipo de Identificaci??n".equals(choice1)){
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getIdentificationTypes().size();i++){
                            if(id == adminCatalogsController.getModelAdminCatalogs().getIdentificationTypes().get(i).getIdTypeIdentification()){
                                String typeIdentification = adminCatalogsController.getModelAdminCatalogs().getIdentificationTypes().get(i).getNameTypeIdentification();
                                adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete(typeIdentification);
                            }
                        }
                    }
                    
                    if("Tipo de Noticia".equals(choice1)){
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getNewsType().size();i++){
                            if(id == adminCatalogsController.getModelAdminCatalogs().getNewsType().get(i).getIdNewsType()){
                                String newsType = adminCatalogsController.getModelAdminCatalogs().getNewsType().get(i).getDescriptionNewsType();
                                adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete(newsType);
                            }
                        }
                    }
                   
                    if("Estado de Noticia".equals(choice1)){
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getNewsStatus().size();i++){
                            if(id == adminCatalogsController.getModelAdminCatalogs().getNewsStatus().get(i).getIdNewsStatus()){
                                String newsStatus = adminCatalogsController.getModelAdminCatalogs().getNewsStatus().get(i).getDescriptionNewsStatus();
                                adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete(newsStatus);
                            }
                        }
                    }
 
                }//ADD SELECTED FALSE
            }
        }
        
    }//ITEM LISTENER
    
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
            modelLogin.setLogged(false);
            
            viewPrincipal.getLblWelcome().setVisible(false);
            viewPrincipal.getBtnRequests().setVisible(false);
            viewPrincipal.getBtnOpAdm().setVisible(false);
            viewPrincipal.getBtnAccount().setVisible(false);
            viewPrincipal.getBtnExit().setVisible(false);
            
            viewPrincipal.getBtnLogin().setVisible(true);
            viewPrincipal.getBtnSignUp().setVisible(true);
                        
            viewPrincipal.setVisible(true);
        }
        
        if(e.getSource() == viewPrincipal.getBtnShowStats()){
            this.modelStats.fillGenderStats(viewStats);
            this.modelStats.fillTeamStats(viewStats);
            this.modelStats.fillTblAverageReviews(viewStats);
            this.modelStats.fillEventStats(viewStats);
            this.modelStats.fillTopGoalers(viewStats);
            this.modelStats.fillTopKeepers(viewStats);
            this.modelStats.progressBar(viewStats);
            this.modelStats.fillDashboard(viewStats);
            this.viewPrincipal.setVisible(false);
            this.viewStats.setVisible(true);
        }
        
        //-----------------Screen Stats ----------------------------------
        if(e.getSource() == viewStats.getBtnBack()){
            viewStats.setVisible(false);
            viewPrincipal.setVisible(true);
        }
        
        if(e.getSource() == viewStats.getBtnSearchAge()){
            modelStats.fillTblAgeRange(viewStats);
        }
        
        if(e.getSource() == viewStats.getBtnGroupTable()){
            JOptionPane.showMessageDialog(null, "Esta funcionalidad no est?? implementada.", "Lo sentimos", JOptionPane.WARNING_MESSAGE);
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
        
        
        //------ SCREEN REGISTER---------------------
        
        if(e.getSource() == viewRegister.getBtnBack()){
            viewRegister.cleanAll();
            
            fillGenders();
            fillIdentificationTypes();     
            fillCountries();

            modelRegister.setPhoto("src/Images/avatar.png");
            viewRegister.setLocationRelativeTo(viewRegister);
            modelRegister.setImageLabel(viewRegister.getLblAvatar());
            viewRegister.repaint();  
            
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
        if(e.getSource() == viewMenuAdmin.getBtnAdmiOther()){
             viewMenuAdmin.setVisible(false);
             viewAdminOther.setVisible(true);
        }
        
        if(e.getSource() == viewMenuAdmin.getBtnBitacora()){
            JOptionPane.showMessageDialog(null, "Lo sentimos, esta opci??n no se encuentra implementada", "Informaci??n", JOptionPane.INFORMATION_MESSAGE);
        }
        
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
            modelAdminMatches.fillTodayMatches(viewPrincipal);
            
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
        
        if(e.getSource() == viewMenuAdmin.getBtnAdmiParametros()){                    
            viewMenuAdmin.setVisible(false);
            adminParametersController.getViewAdminParameters().setVisible(true);
        }
        
        //------------- SCREEN ADMIN OTHER ------------------
        if(e.getSource() == viewAdminOther.getBtnBack()){
            viewAdminOther.setVisible(false);
            viewMenuAdmin.setVisible(true);
        }
        
        if(e.getSource() == viewAdminOther.getBtnUploadFlag()){
            if(modelAdminMatches.selectPhoto(viewAdminOther)){
                viewAdminOther.setLocationRelativeTo(viewAdminOther);
                modelAdminMatches.setImageLabel(viewAdminOther.getLblFlag());
                viewRegister.repaint();
            }
        }
        
        if(e.getSource() == viewAdminOther.getBtnAdd()){
            flagAdminOther = true;
            modelAdminMatches.setNameTeam(viewAdminOther.getTxtNameTeam().getText());
            
        
            if(modelAdminMatches.getNameTeam().isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del equipo", "Error", JOptionPane.WARNING_MESSAGE);
            }else{
            
                if(modelRegister.validateFormatString(modelAdminMatches.getNameTeam()) == false){
                     JOptionPane.showMessageDialog(null, "Formato inv??lido. \nRecuerde solo ingresar letras en el nombre del equipo", "Error", JOptionPane.WARNING_MESSAGE);
                     flagAdminOther = false;
                }
                
                if(modelRegister.validatePhoto(modelAdminMatches.getFlag())){
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una foto", "Error", JOptionPane.WARNING_MESSAGE);
                    flagAdminOther = false;
                }
                
                
                 if("Seleccione Continente".equals(viewAdminOther.getCmbContinent().getSelectedItem().toString())){
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un continente", "Error", JOptionPane.WARNING_MESSAGE);
                    flagAdminOther = false;
                }
                
                
            }
            
            if(flagAdminOther == true){
                modelAdminMatches.insertTeam();
                
                JOptionPane.showMessageDialog(null, "Se ha insertado el equipo con ??xito");
                
                
                viewAdminOther.getTxtNameTeam().setText("");
                viewAdminOther.getCmbContinent().setSelectedItem("Seleccione Continente");
            }

        }
        
        
        
        //-------------- SCREEN AdminNews -----------------------
        if(e.getSource() == adminNewsController.getViewAdminNews().getBtnBack()){
            adminNewsController.getViewAdminNews().setVisible(false);
            this.viewMenuAdmin.setVisible(true);
            try{
                viewPrincipal.showMostViewedNews();
                viewPrincipal.showLastNews();
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        
        if(e.getSource() == adminNewsController.getViewAdminNews().getBtnAceptar()){
            String choice1 = adminNewsController.getViewAdminNews().getCmbEstado().getSelectedItem().toString();
            String choice2 = adminNewsController.getViewAdminNews().getCmbTipo().getSelectedItem().toString();
            
            modelNews.setIdNewsStatus(adminNewsController.getViewAdminNews().getCmbEstado().getSelectedIndex());
            modelNews.setIdNewsType(adminNewsController.getViewAdminNews().getCmbTipo().getSelectedIndex());
            modelNews.setNewsTitle(adminNewsController.getViewAdminNews().getTxtTitulo().getText());
            modelNews.setPublicationDate(modelNews.getPublicationDate());
            modelNews.setNewsText(adminNewsController.getViewAdminNews().getTxtTexto().getText());
            modelNews.setAuthor(model_Login.getUsernameLogin());
            
            if(adminNewsController.getViewAdminNews().getRbtnAgregar().isSelected()){
                adminNewsValidationsInsert(choice1, choice2);
            }
            
            if(adminNewsController.getViewAdminNews().getRbtnEditar().isSelected()){
                adminNewsValidationsUpdate(choice1, choice2);
            }
        }
        
        if(e.getSource() == adminNewsController.getViewAdminNews().getRbtnAgregar()){
            adminNewsRestore();
            flagEditNews = false;
            adminNewsController.getViewAdminNews().getLblInstruction().setVisible(false);
            adminNewsController.getViewAdminNews().getCmbSelectNews().setVisible(false);
        }

        if(e.getSource() == adminNewsController.getViewAdminNews().getRbtnEditar()){
            adminNewsController.getViewAdminNews().getLblInstruction().setVisible(true);
            adminNewsController.getViewAdminNews().getCmbSelectNews().setVisible(true);
            flagEditNews = true;
        }

        if(e.getSource() == adminNewsController.getViewAdminNews().getBtnCargarImagen()){
            if(modelNews.selectPhoto(adminNewsController.getViewAdminNews())){
                adminNewsController.getViewAdminNews().setLocationRelativeTo(adminNewsController.getViewAdminNews());
                modelNews.setImageLabel(adminNewsController.getViewAdminNews().getLblImagen());
                adminNewsController.getViewAdminNews().repaint();
            }
        }
        
        
        //-------------- SCREEN AdminParameters -----------------------
        if(e.getSource() == adminParametersController.getViewAdminParameters().getBtnBack()){
            adminParametersController.getViewAdminParameters().setVisible(false);
            this.viewMenuAdmin.setVisible(true);
        }
        
        if(e.getSource() == adminParametersController.getViewAdminParameters().getBtnAceptar()){
            modelAdminParameters.setName(adminParametersController.getViewAdminParameters().getTxtNombre().getText());
            modelAdminParameters.setValue(adminParametersController.getViewAdminParameters().getTxtValor().getText());
            
            if(adminParametersController.getViewAdminParameters().getRbtnAgregar().isSelected()){
                adminParametersValidationsInsert();
            }
            
            if(adminParametersController.getViewAdminParameters().getRbtnEditar().isSelected()){
                adminParametersValidationsUpdate();
            }
        }
        
        if(e.getSource() == adminParametersController.getViewAdminParameters().getRbtnAgregar()){
            adminParametersController.getViewAdminParameters().clearAll();
            flagEditParameter = false;
        }

        if(e.getSource() == adminParametersController.getViewAdminParameters().getRbtnEditar()){
            flagEditParameter = true;
            adminParametersController.getViewAdminParameters().getLblInstruction().setVisible(true);
            adminParametersController.getViewAdminParameters().getCmbSelectParameters().setVisible(true);
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
            viewEditAccount.getCmbGender().removeAllItems();
            for(int i = 0; i < accountModel.getGenders().size(); i++){
                String tmp = accountModel.getGenders().get(i).getDescriptionGender();
                viewEditAccount.getCmbGender().addItem(tmp);
            }
            viewEditAccount.UpdateInfo(accountModel.getAccountLogged());
            viewMyAccount.setVisible(false);
            viewEditAccount.setVisible(true);
        }
        
        //----------- Screen EditAccount -------------------------
        if(e.getSource() == viewEditAccount.getBtnBack()){
            viewEditAccount.setVisible(false);
            viewMyAccount.setVisible(true);
        }
        
        if(e.getSource() == viewEditAccount.getBtnLoadPicture()){
            if(accountModel.selectPhoto(viewEditAccount)){
                viewEditAccount.setImageLabel(accountModel.getPhoto());
            }
        }
        
        if(e.getSource() == viewEditAccount.getBtnConfirm()){
            String username = accountModel.getUsernameValidated();
            String password = viewEditAccount.getTextFieldPassword().getText();
            String firstName = viewEditAccount.getTextFieldName1().getText();
            String secondName = viewEditAccount.getTextFieldName2().getText();
            String firstLastName = viewEditAccount.getTextFieldLastName1().getText();
            String secondLastName = viewEditAccount.getTextFieldLastName2().getText();
            int genderIndex = viewEditAccount.getCmbGender().getSelectedIndex() + 1;
            String email = viewEditAccount.getTextFieldMail().getText();
            String tmpNumber = viewEditAccount.getTextFieldPhone().getText();
            String finalNumber = tmpNumber.substring(0,4) + tmpNumber.substring(5);
            int number = Integer.parseInt(finalNumber);
            String photoUrl = "";
            if("".equals(accountModel.getPhoto())){
                photoUrl = accountModel.getAccountLogged().getPhotoUrl();
            }
            else if(!"".equals(accountModel.getPhoto())) {
                photoUrl = accountModel.getPhoto();
            }
            
            accountModel.updateProfileInformation(username, password, firstName, secondName, firstLastName, secondLastName, genderIndex, email, number, photoUrl);
            //falta llamar el procedimiento de update
            accountModel.setUsernameValidated(model_Login.getUsernameLogin());
            viewMyAccount.UpdateInfo(accountModel.getAccountLogged());
            JOptionPane.showMessageDialog(viewEditAccount, "Actualizaci??n confirmada.");
            viewEditAccount.setVisible(false);
            viewMyAccount.setVisible(true);
        }
                
        //---------------- Screen news --------------------------------------
        if(e.getSource() == viewNews.getBtnBack()){
            viewNews.setVisible(false);
            viewPrincipal.setVisible(true);
            
            try{
                viewPrincipal.showMostViewedNews();
            }catch(Exception ex){
                System.out.println(ex);
            }
            
            try{
                viewPrincipal.showLastNews();
            }catch(Exception ex){
                System.out.println(ex);
            }
            
            this.newsOpened = false;
        }
        
        if(e.getSource() == viewNews.getBtnRating()){
            if(modelLogin.isLogged()){
                viewNews.setVisible(false);
                ratingModel.setNews(viewNews.getNewsInfo());
                viewRating.setTitle(viewNews.getNewsInfo().getTitle());        
                viewRating.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(viewNews, "Error: para calificar una noticia debe estar loggeado!");
            }
            
        }
        
        if(e.getSource() == viewNews.getBtnComment()){
            if(modelLogin.isLogged()){
                String textComment = viewNews.getTxtComment().getText();
                String username = this.modelLogin.getUsernameLogin();
                if(!"".equals(textComment)){
                    modelNews.insertCommentNews(username, textComment);
                    JOptionPane.showMessageDialog(viewNews, "Se ha agregado tu comentario!");
                    modelNews.loadNewsComment(viewNews);
                    viewNews.getTxtComment().setText("");
                }else{
                    JOptionPane.showMessageDialog(viewNews, "Error: No puede ingresar un comentario vac??o!");
                }
            }else{
                JOptionPane.showMessageDialog(viewNews, "Error: para comentar una noticia debe estar loggeado!");
                viewNews.getTxtComment().setText("");
            }
        }
        
        //---------------- Screen Rating --------------------------------------
        if(e.getSource() == viewRating.getBtnBack()){
            viewRating.setVisible(false);
            viewNews.setVisible(true);
            ratingModel.setRate(modelLogin.getUsernameLogin(),viewRating, 0);
        }
        
        if(e.getSource() == viewRating.getBtnConfirm() && modelLogin.isLogged()){
            if(ratingModel.submitRate()){
                this.modelNews.setSelectedNews(this.viewNews, ratingModel.getNews().getIdNews());
                viewRating.setVisible(false);
                viewNews.setVisible(true);
                ratingModel.setRate(modelLogin.getUsernameLogin(),viewRating, 0);
            }else{
                JOptionPane.showMessageDialog(viewRating, "Error: la calificaci??n debe ser como m??nimo de una estrella!");
            }
        }
        
        if(e.getSource() == viewRating.getBtnStar1()){
            ratingModel.setRate(modelLogin.getUsernameLogin(),viewRating, 1);
        }
        
        if(e.getSource() == viewRating.getBtnStar2()){
            ratingModel.setRate(modelLogin.getUsernameLogin(),viewRating, 2);
        }
        
        if(e.getSource() == viewRating.getBtnStar3()){
            ratingModel.setRate(modelLogin.getUsernameLogin(), viewRating, 3);
        }
        
        if(e.getSource() == viewRating.getBtnStar4()){
            ratingModel.setRate(modelLogin.getUsernameLogin(), viewRating, 4);
        }
        
        if(e.getSource() == viewRating.getBtnStar5()){
           ratingModel.setRate(modelLogin.getUsernameLogin(), viewRating, 5);
        }
        
        
        
        //-------------- SCREEN AdminPerson -----------------------
        if(e.getSource() == viewAdminPerson.getBtnBackAdminPerson()){
            viewAdminPerson.cleanAll();
            fillTypePerson();
            //viewAdminPerson.setCmbPersona("Seleccione Tipo Persona");
            viewAdminPerson.setSpnNumCamisa(1);
            viewAdminPerson.setRbtnAddSelected();
            viewAdminPerson.setRbtnEditSelected();
        
            fillGenders();
            fillIdentificationTypes();     
            fillCountries();
            fillPositions();
            fillTeams();

            modelAdminPerson.setPhoto("src/Images/avatar.png");
            viewAdminPerson.setLocationRelativeTo(viewAdminPerson);
            modelAdminPerson.setImageAdminPerson(viewAdminPerson.getLblAvatar());
            viewAdminPerson.repaint();
            
            
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
            viewAdminPerson.showPlayerOptions(true);
            viewAdminPerson.setTxtLblPerson("Persona:");
            viewAdminPerson.disableManagerOptions(false);
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
            
            modelAdminPerson.setUsernameAdminPerson(viewAdminPerson.getTxtUsername());
            modelAdminPerson.setPasswordAdminPerson(viewAdminPerson.getTxtPassword());
            String choice = viewAdminPerson.getSelectedPerson();
            
            flagAdminPerson = true;
            //Add
            if(viewAdminPerson.getRbtnAdd().isSelected()){
                adminPersonValidations(); //Is going to validate
                
                if("Administrador".equals(choice)){
                    validationsAdmin();
                }
                
                if("Jugador".equals(choice)){
                    validationsPlayer();
                }
                
                if("Cuerpo T??cnico".equals(choice)){
                    validationStaff();
                }
                
                if(flagAdminPerson == true){
                    createPerson();
                }
            }//SELECT BUTTON ADD
            
            if(viewAdminPerson.getRbtnEdit().isSelected()){
                String firstName, secondName, firstLastName, secondLastName, fullName;
                int idPerson = -1;
                
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
                        validationsPlayer();
                        
                        if(flagAdminPerson == true){                            
                            updatesPlayer(idPerson, i);
                            if(flagAdminPerson == false)
                            {
                                editPerson();                                   
                            }else{
                                JOptionPane.showMessageDialog(null, "No se realiz?? ninguna actualizaci??n", "Actualizaci??n", JOptionPane.INFORMATION_MESSAGE);                      
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
                        validationStaff();
                        if(flagAdminPerson == true){                            
                            updatesTeamWorker(idPerson, p);
                            if(flagAdminPerson == false){
                                 editPerson();       
                            }else{
                                JOptionPane.showMessageDialog(null, "No se realiz?? ninguna actualizaci??n", "Actualizaci??n", JOptionPane.INFORMATION_MESSAGE);                      
                            }    
                        }                      
                    }
                          
                }
  
            } //SELECT BUTTON EDIT
            
        }
        
        //-------------- SCREEN AdminMatches -----------------------
        if(e.getSource() == viewAdminMatches.getBtnGroupRaffle()){
            if(validateTeamExist() == true){
                try{
                    raffledPerformed = DA_SoccerMatch.raffledPerformed();
                }catch(SQLException ex){
                    System.out.println(ex);
                }
                if(!raffledPerformed){
                    modelAdminMatches.generateRaffle();
                }else{
                    JOptionPane.showMessageDialog(null, "La rifa ya ha sido efectuada.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }  
        }
        
        
        if(e.getSource() == viewAdminMatches.getBtnScheduleMatch()){
            if(validateGroupExist()== true && validateTeamExist()==true){
                viewAdminMatches.setVisible(false);
                
                modelAdminMatches.fillMatch();
                fillGroup();
                fillStadiums();
        
                viewScheduleMatch.setVisible(true);
            }
        }
        
        if(e.getSource() == viewAdminMatches.getBtnAdminScheduledMatch() && !matchOpened){
            if(validateSoccerMatchExist()){
                try{
                    this.modelAdminMatches.fillSoccerMatches(viewAdminMatch);
                }catch(Exception ex){
                    System.out.println(ex);
                }
                
                viewAdminMatches.setVisible(false);
                viewAdminMatch.setVisible(true);
                matchOpened = true;
            } 
        }
        
        if(e.getSource() == viewAdminMatches.getBtnBack()){
            viewAdminMatches.setVisible(false);
            viewMenuAdmin.setVisible(true);
        }
        
        //-------------- SCREEN AdminMatch -----------------------
        if(e.getSource() == viewAdminMatch.getBtnBack()){
            viewAdminMatch.setVisible(false);
            viewAdminMatches.setVisible(true);
            matchOpened = false;
            viewAdminMatch.matchNotSelected();
        }
        
        if(e.getSource() == viewAdminMatch.getBtnSaveInfo() && playerSelected){
            //aqui el update
            modelAdminMatches.submitUpdatedStats(viewAdminMatch);
        }
        
        //-------------- SCREEN ScheduleMatch -----------------------
        
        if(e.getSource() == viewScheduleMatch.getBtnBack()){
            viewScheduleMatch.setVisible(false);
            viewAdminMatches.setVisible(true);
        }
        
        
        if(e.getSource() == viewScheduleMatch.getBtnSave()){
            modelAdminMatches.setDate(viewScheduleMatch.getTxtMatchDate().getText());
            modelAdminMatches.setHour(viewScheduleMatch.getTxtMatchHour().getText());
          
            String nameStadium = viewScheduleMatch.getCbmStadium().getSelectedItem().toString();
            String Team1 = viewScheduleMatch.getCbmTeam1().getSelectedItem().toString();
            String Team2 = viewScheduleMatch.getCbmTeam2().getSelectedItem().toString();
                    
            for(int j=0; j<modelAdminPerson.getTeams().size();j++){
                if(Team1.equals(modelAdminPerson.getTeams().get(j).getNameTeam())){
                    modelAdminMatches.setTeam1(modelAdminPerson.getTeams().get(j).getIdTeam());
                }
                
                if(Team2.equals(modelAdminPerson.getTeams().get(j).getNameTeam())){
                    modelAdminMatches.setTeam2(modelAdminPerson.getTeams().get(j).getIdTeam());
                }
                   
            }
 
            for(int i=0; i<modelAdminMatches.getStadiums().size();i++){
                if(nameStadium.equals(modelAdminMatches.getStadiums().get(i).getNameStadium())){
                    modelAdminMatches.setStadium(modelAdminMatches.getStadiums().get(i).getIdStadium());
                }
            }
            
            System.out.println(modelAdminMatches.getStadium());
            System.out.println(modelAdminMatches.getDate());
            System.out.println(modelAdminMatches.getHour());
            System.out.println(modelAdminMatches.getTeam1());
            System.out.println(modelAdminMatches.getTeam2());
            
            if(modelAdminMatches.insertMatch()){
                JOptionPane.showMessageDialog(null, "Se ha registrado el partido con ??xito.");
                modelAdminMatches.fillTodayMatches(viewPrincipal);
            }else{
                JOptionPane.showMessageDialog(null, "No se logr?? registrar el partido", "Error", JOptionPane.WARNING_MESSAGE);
            }
        
        }
        
        
        
        
        // ---------------- SCREEN AdminCatalogs -------------------
        if(e.getSource() == adminCatalogsController.getViewAdminCatalogs().getBtnBack()){
            adminCatalogsController.getViewAdminCatalogs().setVisible(false);
            this.viewMenuAdmin.setVisible(true);
        }
        
        if(e.getSource() == adminCatalogsController.getViewAdminCatalogs().getRbtnAdd()){
            adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
            String catalog = adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString();
            adminCatalogsController.getViewAdminCatalogs().getLblOpciones().setText("Cat??logo ");
            
            if(!"Seleccione un cat??logo".equals(catalog)){
                
                adminCatalogsController.getViewAdminCatalogs().getTxtMask().setVisible(false);
                adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(false);
                adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(false);
                adminCatalogsController.getViewAdminCatalogs().getCmbSelectAdd().setVisible(false);
            
                adminCatalogsController.getViewAdminCatalogs().getLblOpciones().setText(adminCatalogsController.getViewAdminCatalogs().getLblOpciones().getText() + "" + catalog);
                adminCatalogsController.getViewAdminCatalogs().getLblAddEditDelete().setText("Agregar ");
                adminCatalogsController.getViewAdminCatalogs().getLblAddEditDelete().setText(adminCatalogsController.getViewAdminCatalogs().getLblAddEditDelete().getText() + "" + catalog);   
            
            
                if("Provincia".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione Pa??s");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelectAdd().setVisible(true);
                    
                }
                
                if("Cant??n".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione una Provincia");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelectAdd().setVisible(true);
                }
                
                
                if("Distrito".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione un Cant??n");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelectAdd().setVisible(true);
                }
                
                if("Pa??s de Equipo".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione un Pa??s de Equipo");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelectAdd().setVisible(true);
                }
                
                if("Tipo de Identificaci??n".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Indique la m??scara(formato)");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getTxtMask().setVisible(true);
                }
            }  
        }
        
        if(e.getSource() == adminCatalogsController.getViewAdminCatalogs().getRbtnEdit()){
            adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
            String catalog = adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString();
            adminCatalogsController.getViewAdminCatalogs().getLblOpciones().setText("Cat??logo ");
            
            if(!"Seleccione un cat??logo".equals(catalog)){
                adminCatalogsController.getViewAdminCatalogs().getTxtMask().setVisible(false);
                adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(false);
                adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(false);
                
                adminCatalogsController.getViewAdminCatalogs().getLblOpciones().setText(adminCatalogsController.getViewAdminCatalogs().getLblOpciones().getText() + "" + catalog);
                adminCatalogsController.getViewAdminCatalogs().getLblAddEditDelete().setText("Modificar ");
                adminCatalogsController.getViewAdminCatalogs().getLblAddEditDelete().setText(adminCatalogsController.getViewAdminCatalogs().getLblAddEditDelete().getText() + "" + catalog);
            
               if("G??nero".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el g??nero a editar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
               
                if("Posici??n".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione la posici??n a editar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Pa??s".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el pa??s a editar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Continente".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el continente a editar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Provincia".equals(catalog)){ 
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione la provincia a editar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Cant??n".equals(catalog)){ 
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el cant??n a editar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Distrito".equals(catalog)){ 
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el distrito a editar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Pa??s de Equipo".equals(catalog)){ 
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el pa??s de equipo a editar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Estado de Noticia".equals(catalog)){ 
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el estado de noticia a editar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Tipo de Noticia".equals(catalog)){ 
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el tipo de noticia a editar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }    
                
                if("Tipo de Identificaci??n".equals(catalog)){ 
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el tipo de identificaci??n a editar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }  
            }        
        }
        
        
        if(e.getSource() == adminCatalogsController.getViewAdminCatalogs().getRbtnDelete()){
            adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
            String catalog = adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString();
            adminCatalogsController.getViewAdminCatalogs().getLblOpciones().setText("Cat??logo ");
            
            if(!"Seleccione un cat??logo".equals(catalog)){
                adminCatalogsController.getViewAdminCatalogs().getTxtMask().setVisible(false);
                adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(false);
                adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(false);
                adminCatalogsController.getViewAdminCatalogs().getCmbSelectAdd().setVisible(false);
            
                adminCatalogsController.getViewAdminCatalogs().getLblOpciones().setText(adminCatalogsController.getViewAdminCatalogs().getLblOpciones().getText() + "" + catalog);
                adminCatalogsController.getViewAdminCatalogs().getLblAddEditDelete().setText("Eliminar ");
                adminCatalogsController.getViewAdminCatalogs().getLblAddEditDelete().setText(adminCatalogsController.getViewAdminCatalogs().getLblAddEditDelete().getText() + "" + catalog);
            
                if("G??nero".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el g??nero a eliminar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
               if("Posici??n".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione la posici??n a eliminar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
               
                if("Pa??s".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el pa??s a eliminar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
               
                if("Continente".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el continente a eliminar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Provincia".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione la provincia a eliminar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Cant??n".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el cant??n a eliminar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Distrito".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el distrito a eliminar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Pa??s de Equipo".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el pa??s de equipo a eliminar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
               
                if("Estado de Noticia".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el estado de noticia a eliminar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Tipo de Noticia".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el tipo de noticia a eliminar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
                if("Tipo de Identificaci??n".equals(catalog)){
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setText("Seleccione el tipo de identificaci??n a eliminar");
                    adminCatalogsController.getViewAdminCatalogs().getLblSelect().setVisible(true);
                    adminCatalogsController.getViewAdminCatalogs().getCmbSelect().setVisible(true);
                }
                
            }        
        }
        
             
        if(e.getSource() == adminCatalogsController.getViewAdminCatalogs().getBtnAccept()){
            flagAddCatalogs = false;
            flagEditCatalogs = false;
            String text = adminCatalogsController.getViewAdminCatalogs().getTxtAddEditDelete().getText();
            String idStr;
            int id;
            
            if(text.isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe completar el campo solicitado", "Error", JOptionPane.WARNING_MESSAGE);
            }else{
                if(adminCatalogsController.getViewAdminCatalogs().getRbtnAdd().isSelected()){
                    
                    if("G??nero".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setDescriptionGender(text);
                        adminCatalogsController.getModelAdminCatalogs().insertGender();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagAddCatalogs = true;
                    }
                    
                    
                    if("Posici??n".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setDescriptionPosition(text);
                        adminCatalogsController.getModelAdminCatalogs().insertPosition();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagAddCatalogs = true;
                    }
                    
                    if("Pa??s".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setNameCountry(text);
                        adminCatalogsController.getModelAdminCatalogs().insertCountry();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagAddCatalogs = true;
                    }
                    
                    if("Continente".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setNameContinent(text);
                        adminCatalogsController.getModelAdminCatalogs().insertContinent();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagAddCatalogs = true;
                    }
                    
                    
                    if("Tipo de Identificaci??n".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setNameTypeIdentification(text);  
                        System.out.println(text);
                        String mask = adminCatalogsController.getViewAdminCatalogs().getTxtMask().getText();
                        adminCatalogsController.getModelAdminCatalogs().setNameMask(mask);
                        adminCatalogsController.getModelAdminCatalogs().insertTypeIdentification();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.getViewAdminCatalogs().setTxtMask("");
                        adminCatalogsController.fillCatalogs();
                        flagAddCatalogs = true;
                    }
                    
                    if("Provincia".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        
                        String nameCountry = adminCatalogsController.getViewAdminCatalogs().getCmbSelectAdd().getSelectedItem().toString();
                        
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getCountries().size();i++){
                            if(nameCountry.equals(adminCatalogsController.getModelAdminCatalogs().getCountries().get(i).getNameCountry())){
                                int idCountry = adminCatalogsController.getModelAdminCatalogs().getCountries().get(i).getIdCountry();
                                adminCatalogsController.getModelAdminCatalogs().setIdCountry(idCountry);
                            }
                        }

                        adminCatalogsController.getModelAdminCatalogs().setNameProvince(text);
                        adminCatalogsController.getModelAdminCatalogs().insertProvince();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagAddCatalogs = true;
                    }
                    
                    if("Cant??n".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        
                        String nameProvince = adminCatalogsController.getViewAdminCatalogs().getCmbSelectAdd().getSelectedItem().toString();
                        
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getProvinces().size();i++){
                            if(nameProvince.equals(adminCatalogsController.getModelAdminCatalogs().getProvinces().get(i).getNameProvince())){
                                int idProvince = adminCatalogsController.getModelAdminCatalogs().getProvinces().get(i).getIdProvince();
                                adminCatalogsController.getModelAdminCatalogs().setIdProvince(idProvince);
                            }
                        }

                        adminCatalogsController.getModelAdminCatalogs().setNameCanton(text);
                        adminCatalogsController.getModelAdminCatalogs().insertCanton();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagAddCatalogs = true;
                    }
                    
                    if("Distrito".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        
                        String nameCanton = adminCatalogsController.getViewAdminCatalogs().getCmbSelectAdd().getSelectedItem().toString();
                        
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getCantons().size();i++){
                            if(nameCanton.equals(adminCatalogsController.getModelAdminCatalogs().getCantons().get(i).getNameCanton())){
                                int idCanton = adminCatalogsController.getModelAdminCatalogs().getCantons().get(i).getIdCanton();
                                adminCatalogsController.getModelAdminCatalogs().setIdCanton(idCanton);
                            }
                        }

                        adminCatalogsController.getModelAdminCatalogs().setNameDistrict(text);
                        adminCatalogsController.getModelAdminCatalogs().insertDistrict();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagAddCatalogs = true;
                    }
                    
                    
                   if("Pa??s de Equipo".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        
                        String nameContinent = adminCatalogsController.getViewAdminCatalogs().getCmbSelectAdd().getSelectedItem().toString();
                        
                        for(int i=0; i< adminCatalogsController.getModelAdminCatalogs().getContinents().size();i++){
                            if(nameContinent.equals(adminCatalogsController.getModelAdminCatalogs().getContinents().get(i).getNameContinent())){
                                int idContinent = adminCatalogsController.getModelAdminCatalogs().getContinents().get(i).getIdContinent();
                                adminCatalogsController.getModelAdminCatalogs().setIdContinent(idContinent);
                            }
                        }

                        adminCatalogsController.getModelAdminCatalogs().setNameCountryTeam(text);
                        adminCatalogsController.getModelAdminCatalogs().insertCountryTeam();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagAddCatalogs = true;
                    }

                    if("Estado de Noticia".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setDescriptionStatus(text);
                        adminCatalogsController.getModelAdminCatalogs().insertNewsStatus();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagAddCatalogs = true;
                    }
                    
                    if("Tipo de Noticia".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setDescriptionType(text);
                        adminCatalogsController.getModelAdminCatalogs().insertNewsType();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagAddCatalogs = true;
                    }
                   
                    if(flagAddCatalogs == true){
                        JOptionPane.showMessageDialog(null, "Se agreg?? de manera ??xitosa.");
                    }
                }//ADD
                
                if(adminCatalogsController.getViewAdminCatalogs().getRbtnEdit().isSelected()){
                    idStr = adminCatalogsController.getViewAdminCatalogs().getCmbSelect().getSelectedItem().toString();
                    id = Integer.parseInt(idStr);
                    
                    if("G??nero".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdGender(id);
                        adminCatalogsController.getModelAdminCatalogs().setDescriptionGender(text);
                        adminCatalogsController.getModelAdminCatalogs().updateGender();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagEditCatalogs = true;
                    }
                    
                    if("Posici??n".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdPosition(id);
                        adminCatalogsController.getModelAdminCatalogs().setDescriptionPosition(text);
                        adminCatalogsController.getModelAdminCatalogs().updatePosition();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagEditCatalogs = true;
                    }
                    
                    if("Continente".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdContinent(id);
                        adminCatalogsController.getModelAdminCatalogs().setNameContinent(text);
                        adminCatalogsController.getModelAdminCatalogs().updateContinent();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagEditCatalogs = true;
                    }
                    
                    if("Pa??s".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdCountry(id);
                        adminCatalogsController.getModelAdminCatalogs().setNameCountry(text);
                        adminCatalogsController.getModelAdminCatalogs().updateCountry();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagEditCatalogs = true;
                    }
                    
                    if("Pa??s de Equipo".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdCountryTeam(id);
                        adminCatalogsController.getModelAdminCatalogs().setNameCountryTeam(text);
                        adminCatalogsController.getModelAdminCatalogs().updateCountryTeam();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagEditCatalogs = true;
                    }
                    
                   if("Provincia".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdProvince(id);
                        adminCatalogsController.getModelAdminCatalogs().setNameProvince(text);
                        adminCatalogsController.getModelAdminCatalogs().updateProvince();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagEditCatalogs = true;
                    }
                   
                   if("Cant??n".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdCanton(id);
                        adminCatalogsController.getModelAdminCatalogs().setNameCanton(text);
                        adminCatalogsController.getModelAdminCatalogs().updateCanton();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagEditCatalogs = true;
                    }
                    
                   if("Distrito".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdDistrict(id);
                        adminCatalogsController.getModelAdminCatalogs().setNameDistrict(text);
                        adminCatalogsController.getModelAdminCatalogs().updateDistrict();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagEditCatalogs = true;
                    } 
                   
                    if("Tipo de Identificaci??n".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdTypeIdentification(id);
                        adminCatalogsController.getModelAdminCatalogs().setNameTypeIdentification(text);
                        adminCatalogsController.getModelAdminCatalogs().updateTypeIdentification();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagEditCatalogs = true;
                    } 
                   
                    
                    if("Tipo de Noticia".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdNewsType(id);
                        adminCatalogsController.getModelAdminCatalogs().setDescriptionType(text);
                        adminCatalogsController.getModelAdminCatalogs().updateNewsType();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagEditCatalogs = true;
                    } 
                    
                    
                    if("Estado de Noticia".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdNewsStatus(id);
                        adminCatalogsController.getModelAdminCatalogs().setDescriptionStatus(text);
                        adminCatalogsController.getModelAdminCatalogs().updateNewsStatus();
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                        adminCatalogsController.fillCatalogs();
                        flagEditCatalogs = true;
                    } 

                    if(flagEditCatalogs == true){
                        JOptionPane.showMessageDialog(null, "Se edit?? de manera ??xitosa.");
                    }
                    
                }//EDIT
                
                //DELETE
                if(adminCatalogsController.getViewAdminCatalogs().getRbtnDelete().isSelected()){
                    idStr = adminCatalogsController.getViewAdminCatalogs().getCmbSelect().getSelectedItem().toString();
                    id = Integer.parseInt(idStr);
                    
                    if("G??nero".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdGender(id);                        
                        
                        if(adminCatalogsController.getModelAdminCatalogs().deleteGender() == false){
                            JOptionPane.showMessageDialog(null, "El cat??logo se encuentra en uso. No se puede eliminar.", "Eliminaci??n", JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Se ha eliminado con ??xito.");
                            adminCatalogsController.fillCatalogs();
                            flagAddCatalogs = true;
                        }
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                    }
                    
                    
                    if("Posici??n".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdPosition(id);                        
                        
                        if(adminCatalogsController.getModelAdminCatalogs().deletePosition() == false){
                            JOptionPane.showMessageDialog(null, "El cat??logo se encuentra en uso. No se puede eliminar.", "Eliminaci??n", JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Se ha eliminado con ??xito.");
                            adminCatalogsController.fillCatalogs();
                            flagAddCatalogs = true;
                        }
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                    }
                    
                   if("Continente".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdContinent(id);                        
                        
                        if(adminCatalogsController.getModelAdminCatalogs().deleteContinent() == false){
                            JOptionPane.showMessageDialog(null, "El cat??logo se encuentra en uso. No se puede eliminar.", "Eliminaci??n", JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Se ha eliminado con ??xito.");
                            adminCatalogsController.fillCatalogs();
                            flagAddCatalogs = true;
                        }
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                    }
                   
                   
                    if("Pa??s".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdCountry(id);                        
                        
                        if(adminCatalogsController.getModelAdminCatalogs().deleteCountry() == false){
                            JOptionPane.showMessageDialog(null, "El cat??logo se encuentra en uso. No se puede eliminar.", "Eliminaci??n", JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Se ha eliminado con ??xito.");
                            adminCatalogsController.fillCatalogs();
                            flagAddCatalogs = true;
                        }
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                    }
                    
                    
                    if("Tipo de Identificaci??n".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdTypeIdentification(id);                        
                        
                        if(adminCatalogsController.getModelAdminCatalogs().deleteTypeIdentificaion() == false){
                            JOptionPane.showMessageDialog(null, "El cat??logo se encuentra en uso. No se puede eliminar.", "Eliminaci??n", JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Se ha eliminado con ??xito.");
                            adminCatalogsController.fillCatalogs();
                            flagAddCatalogs = true;
                        }
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                    }
                    
                    
                    if("Provincia".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdProvince(id);                        
                        
                        if(adminCatalogsController.getModelAdminCatalogs().deleteProvince() == false){
                            JOptionPane.showMessageDialog(null, "El cat??logo se encuentra en uso. No se puede eliminar.", "Eliminaci??n", JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Se ha eliminado con ??xito.");
                            adminCatalogsController.fillCatalogs();
                            flagAddCatalogs = true;
                        }
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                    }
                    
                    if("Cant??n".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdCanton(id);                        
                        
                        if(adminCatalogsController.getModelAdminCatalogs().deleteCanton() == false){
                            JOptionPane.showMessageDialog(null, "El cat??logo se encuentra en uso. No se puede eliminar.", "Eliminaci??n", JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Se ha eliminado con ??xito.");
                            adminCatalogsController.fillCatalogs();
                            flagAddCatalogs = true;
                        }
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                    }
                    
                    if("Distrito".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdDistrict(id);                        
                        
                        if(adminCatalogsController.getModelAdminCatalogs().deleteDistrict() == false){
                            JOptionPane.showMessageDialog(null, "El cat??logo se encuentra en uso. No se puede eliminar.", "Eliminaci??n", JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Se ha eliminado con ??xito.");
                            adminCatalogsController.fillCatalogs();
                            flagAddCatalogs = true;
                        }
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                    }
                    
                    
                    if("Pa??s de Equipo".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdCountryTeam(id);                        
                        
                        if(adminCatalogsController.getModelAdminCatalogs().deleteCountryTeam()== false){
                            JOptionPane.showMessageDialog(null, "El cat??logo se encuentra en uso. No se puede eliminar.", "Eliminaci??n", JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Se ha eliminado con ??xito.");
                            adminCatalogsController.fillCatalogs();
                            flagAddCatalogs = true;
                        }
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                    }
                    
                    
                   if("Estado de Noticia".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdNewsStatus(id);                        
                        
                        if(adminCatalogsController.getModelAdminCatalogs().deleteNewsStatus()== false){
                            JOptionPane.showMessageDialog(null, "El cat??logo se encuentra en uso. No se puede eliminar.", "Eliminaci??n", JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Se ha eliminado con ??xito.");
                            adminCatalogsController.fillCatalogs();
                            flagAddCatalogs = true;
                        }
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                    }
                   
                   
                   if("Tipo de Noticia".equals(adminCatalogsController.getViewAdminCatalogs().getCmbCatalogo().getSelectedItem().toString())){
                        adminCatalogsController.getModelAdminCatalogs().setIdNewsType(id);                        
                        
                        if(adminCatalogsController.getModelAdminCatalogs().deleteNewsType() == false){
                            JOptionPane.showMessageDialog(null, "El cat??logo se encuentra en uso. No se puede eliminar.", "Eliminaci??n", JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Se ha eliminado con ??xito.");
                            adminCatalogsController.fillCatalogs();
                            flagAddCatalogs = true;
                        }
                        adminCatalogsController.getViewAdminCatalogs().setTxtAddEditDelete("");
                    }
                    
                }//DELETE
            
            
            }
        }        
    }//ACTION PERFOMED
        
    
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
        
        if(e.getSource() == viewPrincipal.getTblLastNews().getSelectionModel() && !newsOpened){
            if( viewPrincipal.getTblLastNews().getRowCount() > 0){
                int index = viewPrincipal.getTblLastNews().getSelectedRow();
                News selectedNews = viewPrincipal.getController().getCargador().getLastNews().get(index);
                int newsIndex = selectedNews.getIdNews();
                this.modelNews.setSelectedNews(this.viewNews, newsIndex);
                this.modelNews.loadNewsComment(this.viewNews);
                this.viewPrincipal.setVisible(false);
                this.viewNews.setVisible(true);
                this.newsOpened = true;
            }
        }
        
        if(e.getSource() == viewPrincipal.getTblMostViewedNews().getSelectionModel() && !newsOpened){
            if( viewPrincipal.getTblMostViewedNews().getRowCount() > 0){
                int index = viewPrincipal.getTblMostViewedNews().getSelectedRow();
                News selectedNews = viewPrincipal.getController().getCargador().getMostViewedNews().get(index);
                int newsIndex = selectedNews.getIdNews();
                this.modelNews.setSelectedNews(this.viewNews, newsIndex);
                this.modelNews.loadNewsComment(this.viewNews);
                this.viewPrincipal.setVisible(false);
                this.viewNews.setVisible(true);
                this.newsOpened = true;
            }
        }
    }
  
}
