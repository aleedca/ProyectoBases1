/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.model_Account;
import Model.model_AdminPerson;
import Model.model_Login;
import Model.model_Register;
import View.JF_AdminOptions;
import View.JF_AdminPerson;
import View.JF_EditAccount;
import View.JF_Login;
import View.JF_MyAccount;
import View.JF_Principal;
import View.JF_Register;
import View.JF_Request;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.JOptionPane;


/**
 *
 * @author Mariana
 */

public class OperationsController implements ActionListener, ItemListener{
    private final JF_Principal viewPrincipal;
    private final JF_Login viewLogin;
    private final JF_Register viewRegister;
    private final JF_AdminOptions viewMenuAdmin;
    private final JF_AdminPerson viewAdminPerson;
    private final JF_Request viewRequest;
    private final JF_MyAccount viewMyAccount;
    private final JF_EditAccount viewEditAccount;
    
    private final model_Login modelLogin;
    private final model_Register modelRegister;
    private final model_AdminPerson modelAdminPerson;
    private final model_Account accountModel;
    
    private boolean flagRegister;
    private boolean flagAdminPerson;
    
    private final RequestController requestController;
    private final AdminNewsController adminNewsController;
    
    
    //Constructor 2da version
    public OperationsController(JF_Principal principal) { 
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
               
        //Modelo Login
        model_Login validateLogin = new model_Login();
        this.modelLogin = validateLogin;  
         
        //Model Register
        model_Register validateRegister = new model_Register();
        this.modelRegister = validateRegister;
        
        //Model AdminPerson
        model_AdminPerson validateAdminPerson = new model_AdminPerson();
        this.modelAdminPerson = validateAdminPerson;
        
        //Model MyAccount
        this.accountModel = new model_Account();
        
        //Request Controller
        RequestController controller = new RequestController();
        this.requestController = controller;
        
        //AdminNews Controller
        AdminNewsController adminNController = new AdminNewsController();
        this.adminNewsController = adminNController;
        
        
        _init_(); 
        
        fillGenders();
        fillIdentificationTypes();     
        fillCountries();
        fillPositions();
        fillTeams();

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
        
        //AdminNewsOption
        adminNewsController.getViewAdminNews().getRbtnAgregar().addActionListener(this);
        adminNewsController.getViewAdminNews().getRbtnEditar().addActionListener(this);
        adminNewsController.getViewAdminNews().getRbtnEliminar().addActionListener(this);
        
        adminNewsController.getViewAdminNews().getCmbEstado().addActionListener(this);
        adminNewsController.getViewAdminNews().getCmbTipo().addActionListener(this);
        
        adminNewsController.getViewAdminNews().getBtnAceptar().addActionListener(this);
        adminNewsController.getViewAdminNews().getBtnBack().addActionListener(this);
               
        //Request
        viewRequest.getBtnBackRequest().addActionListener(this);
        
        //MyAccount
        viewMyAccount.getBtnBackMyAccount().addActionListener(this);
        viewMyAccount.getBtnEditProfile().addActionListener(this);
        
        
        //AdminPerson
        viewAdminPerson.getBtnBackAdminPerson().addActionListener(this);
        viewAdminPerson.getBtnAccept().addActionListener(this);
        viewAdminPerson.getBtnLoadPhoto().addActionListener(this);
        
        viewAdminPerson.getCmbGender().addItemListener(this);
        viewAdminPerson.getCmbTypeIdentification().addItemListener(this);
        viewAdminPerson.getCmbTypePosition().addItemListener(this);
        viewAdminPerson.getCmbTeam().addItemListener(this);
        
        
        viewAdminPerson.getCmbCountry().addItemListener(this);
        viewAdminPerson.getCmbProvince().addItemListener(this);
        viewAdminPerson.getCmbCanton().addItemListener(this);
        viewAdminPerson.getCmbDistrict().addItemListener(this);
         
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
            requestController.fillPositions(viewRequest);
            requestController.fillEvents(viewRequest);
            viewRequest.setVisible(true);
            viewPrincipal.setVisible(false); 
        }
        
        if(e.getSource() == viewPrincipal.getBtnAccount()){
            accountModel.setUsernameValidated(model_Login.getUsernameLogin());
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
                
            }
           
            
            if(flagRegister == true){
                modelRegister.inserUser();
                
                JOptionPane.showMessageDialog(null, "Felicidades, su cuenta se creó correctamte.\nInicie sesión para comenzar a disfrutar de nuestra aplicación" );
                viewRegister.cleanAll();
                viewRegister.setVisible(false);
                viewPrincipal.getBtnSignUp().setVisible(false);
                
                viewPrincipal.setVisible(true);
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
        
        if(e.getSource() == viewMenuAdmin.getBtnAdmiPersonas()){                    
            viewMenuAdmin.setVisible(false);
            viewAdminPerson.setVisible(true);
        }
        
        //-------------- SCREEN AdminNews -----------------------
        if(e.getSource() == adminNewsController.getViewAdminNews().getBtnBack()){
            adminNewsController.getViewAdminNews().setVisible(false);
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
            viewMyAccount.setVisible(false);
            viewEditAccount.setVisible(true);
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
                
                if(modelAdminPerson.validateEmptyFieldsAdminPerson()){
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios solicitados", "Error", JOptionPane.WARNING_MESSAGE);
                    flagAdminPerson = false;
                }
                else{
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
                                flagRegister = false;
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
                    
                    if(viewAdminPerson.validateTxtDateOfBirth()){
                        JOptionPane.showMessageDialog(null, "Debe ingresar una fecha de nacimiento", "Error", JOptionPane.WARNING_MESSAGE);
                        flagAdminPerson = false;
                    }
                    
                    
                }//VALIDATE EMPTY FIELDS
                
                if(flagAdminPerson == true){
                    
                    if("Jugador".equals(viewAdminPerson.getTxtCmbPerson())){
                        modelAdminPerson.inserPlayer();
                        
                    }else{
                        modelAdminPerson.inserTeamWorker();
                        System.out.println("Es TemWorker");
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
 
            }//SELECT BUTTON ADD
            
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
  
}
