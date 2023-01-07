/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.model_Login;
import Model.model_Register;
import View.JF_AdminOptions;
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
    private final JF_Request viewRequest;
    private final JF_MyAccount viewMyAccount;
    
    private final model_Login modelLogin;
    private final model_Register modelRegister;
    private boolean flagRegister;
    
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
        
        //View Request
        JF_Request request = new JF_Request();
        this.viewRequest = request;
        
        //View Request
        JF_MyAccount myaccount = new JF_MyAccount();
        this.viewMyAccount = myaccount;
        
        //Modelo Login
        model_Login validateLogin = new model_Login();
        this.modelLogin = validateLogin;  
        
       
        //Model Register
        model_Register validateRegister = new model_Register();
        this.modelRegister = validateRegister;
        
        
        //Request Controller
        RequestController controller = new RequestController();
        this.requestController = controller;
        
        //AdminNews Controller
        AdminNewsController adminNewsController = new AdminNewsController();
        this.adminNewsController = adminNewsController;
        
        
        _init_(); 
        
        fillGenders();
        fillIdentificationTypes();     
        fillCountries();

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
         
    }
    
    
    //-------- COMBO BOX FILLING --------------------------
    private void fillGenders(){
        viewRegister.getCmbGender().removeAllItems();
        
        for(int i=0; i<modelRegister.getGenders().size();i++){
           viewRegister.getCmbGender().addItem(modelRegister.getGenders().get(i).getDescriptionGender());
        }
    }
    
    private void fillIdentificationTypes(){
        viewRegister.getCmbTypeIdentification().removeAllItems();
        
        for(int i=0; i< modelRegister.getIdentificationTypes().size();i++){
           viewRegister.getCmbTypeIdentification().addItem(modelRegister.getIdentificationTypes().get(i).getNameTypeIdentification());
        }
    }
    
    private void fillCountries(){
        viewRegister.getCmbCountry().removeAllItems();
        
        viewRegister.getCmbProvince().removeAllItems();
        viewRegister.getCmbProvince().setEnabled(false);
        
        viewRegister.getCmbCanton().removeAllItems();
        viewRegister.getCmbCanton().setEnabled(false);
        
        viewRegister.getCmbDistrict().removeAllItems();
        viewRegister.getCmbDistrict().setEnabled(false);
        
        viewRegister.getCmbCountry().addItem("Seleccione País");
        for(int i=0; i<modelRegister.getCountries().size();i++){
            viewRegister.getCmbCountry().addItem(modelRegister.getCountries().get(i).getNameCountry());
        }
    }
    
    private void fillProvinces(int country){
        viewRegister.getCmbProvince().setEnabled(true);
        viewRegister.getCmbProvince().removeAllItems();
       
        viewRegister.getCmbProvince().addItem("Seleccione Provincia");
        for(int i=0; i<modelRegister.getProvinces().size();i++){
            if(country == modelRegister.getProvinces().get(i).getIdCountry()){
                 viewRegister.getCmbProvince().addItem(modelRegister.getProvinces().get(i).getNameProvince());
            }  
        }
    }
    
    private void fillCantons(int province){
        viewRegister.getCmbCanton().setEnabled(true);
        viewRegister.getCmbCanton().removeAllItems();
        
        viewRegister.getCmbCanton().addItem("Seleccione Cantón");
        for(int i=0; i<modelRegister.getCantons().size();i++){
            if(province == modelRegister.getCantons().get(i).getIdProvince()){
                viewRegister.getCmbCanton().addItem(modelRegister.getCantons().get(i).getNameCanton());
            }
        }
    }
    
    private void fillDistricts(int canton){
        viewRegister.getCmbDistrict().setEnabled(true);
        viewRegister.getCmbDistrict().removeAllItems();
 
        for(int i=0; i<modelRegister.getDistricts().size();i++){
            if(canton == modelRegister.getDistricts().get(i).getIdCanton()){
                viewRegister.getCmbDistrict().addItem(modelRegister.getDistricts().get(i).getNameDistrict());  
            }
        }
    }
    
    //-------------------------------------------------------------------------------------------------------
    
    @Override
    public void itemStateChanged(ItemEvent e){
        //COUNTRY
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
                }
            }
        
        }
        
        //PROVINCE
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
                }
            }
        
        }
        
        //CANTON
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
        
        //DISTRICT
        if( e.getSource() == viewRegister.getCmbDistrict()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewRegister.getSelectedDistrict();
                
                for(int i=0; i<modelRegister.getDistricts().size();i++){
                    if( choice.equals(modelRegister.getDistricts().get(i).getNameDistrict())){
                        modelRegister.setDistrict(modelRegister.getDistricts().get(i).getIdDistrict());
                    }    
                }                
            }
        }
        
       
        //TypeIdentification
        if( e.getSource() == viewRegister.getCmbTypeIdentification()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewRegister.getSelectedTypeIdentification();
                
                for(int i=0; i<modelRegister.getIdentificationTypes().size();i++){
                    if( choice.equals(modelRegister.getIdentificationTypes().get(i).getNameTypeIdentification())){
                        modelRegister.setTypeIdentification(modelRegister.getIdentificationTypes().get(i).getIdTypeIdentification());
                    }    
                }                
            }
        }
        
        //Gender
        if(e.getSource() == viewRegister.getCmbGender()){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String choice = viewRegister.getSelectedGender();
                
                for(int i=0; i<modelRegister.getGenders().size();i++){
                    if( choice.equals(modelRegister.getGenders().get(i).getDescriptionGender())){
                        modelRegister.setGender(modelRegister.getGenders().get(i).getIdGender());
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
        
        //-------------- PANTALLA LOGIN ----------------------
        
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
        
        
        //------ PANTALLA DE REGISTRO ---------------------
        
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
            if(modelRegister.validateEmptyFields(modelRegister.getFirstName(), modelRegister.getFirstLastName(),
                                                modelRegister.getUsernameRegister(),modelRegister.getPasswordRegister(), 
                                                modelRegister.getMail(), modelRegister.getAddress()) == true)
            {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios solicitados", "Error", JOptionPane.WARNING_MESSAGE);
                //viewRegister.cleanAll();
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
                
                
                if(modelRegister.validateFormatUsername(modelRegister.getUsernameRegister()) == false){
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese únicamente letras, números o el caracter _ para crear su username.\nDebe tener al menos 5 caracteres y sin espacios.", "Error", JOptionPane.WARNING_MESSAGE);
                    viewRegister.cleanUsername();
                    flagRegister = false;
                }
                
                if(modelRegister.validateFormatPassword(modelRegister.getPasswordRegister()) == false){
                    JOptionPane.showMessageDialog(null, "Formato de contraseña incorrecta.\nDebe contener entre 4 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula.", "Error", JOptionPane.WARNING_MESSAGE);
                    viewRegister.cleanPassword();
                    flagRegister = false;
                }
                
                if(modelRegister.validarFormatoDireccion(modelRegister.getAddress()) == false){
                    JOptionPane.showMessageDialog(null, "Dirección no válida.\nDebe contener un mínimo de 50 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
                    viewRegister.cleanAddress();
                    flagRegister = false;
                }
                
                if(modelRegister.validatePhoto(modelRegister.getPhoto())){
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una foto", "Error", JOptionPane.WARNING_MESSAGE);
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
        
        //-------------- PANTALLA DE AdminOptions -----------------------
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
        
        //-------------- PANTALLA DE AdminNews -----------------------
        if(e.getSource() == adminNewsController.getViewAdminNews().getBtnBack()){
            System.out.println("entra");
            adminNewsController.getViewAdminNews().setVisible(false);
            this.viewMenuAdmin.setVisible(true);
        }
        
        //----------- PANTALLA DE Request -------------------------
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
        
        //----------- PANTALLA DE MyAccount -------------------------
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
