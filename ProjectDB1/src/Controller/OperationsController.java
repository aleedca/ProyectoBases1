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
        
        
        _init_(); 
        
        fillGenders();
        fillIdentificationTypes();     
        fillCountries();

    }
    
    //Init de ActionListener, itemListener
    private void _init_(){
        //Principal
        viewPrincipal.getBtnIniciarSesion().addActionListener(this);
        viewPrincipal.getBtnRegistrar().addActionListener(this);
        viewPrincipal.getBtnOpAdm().addActionListener(this);
        viewPrincipal.getBtnConsultas().addActionListener(this);
        viewPrincipal.getBtnCuenta().addActionListener(this);
        viewPrincipal.getBtnSalir().addActionListener(this);
        
        //Login
        viewLogin.getBtnLogin().addActionListener(this);
        viewLogin.getBtnBack().addActionListener(this);
        
        //Register
        viewRegister.getBtnBack().addActionListener(this);
        viewRegister.getBtnVerificarRegistro().addActionListener(this);
        viewRegister.getBtnCargarFoto().addActionListener(this);
        
        
        viewRegister.getCmbGenero().addItemListener(this);
        viewRegister.getCmbTipoIdentificacion().addItemListener(this);
        viewRegister.getCmbPais().addItemListener(this);
        viewRegister.getCmbProvincia().addItemListener(this);
        viewRegister.getCmbCanton().addItemListener(this);
        viewRegister.getCmbDistrito().addItemListener(this);
        
        //AdminOptions
        viewMenuAdmin.getBtnBack().addActionListener(this);
        
        //Request
        viewRequest.getBtnBackRequest().addActionListener(this);
        
        //MyAccount
        viewMyAccount.getBtnBackMyAccount().addActionListener(this);
         
    }
    
    
    //-------- COMBO BOX FILLING --------------------------
    private void fillGenders(){
        viewRegister.getCmbGenero().removeAllItems();
        for(int i=0; i<modelRegister.getGenders().size();i++){
           viewRegister.getCmbGenero().addItem(modelRegister.getGenders().get(i).getDescriptionGender());
        }
    }
    
    private void fillIdentificationTypes(){
        viewRegister.getCmbTipoIdentificacion().removeAllItems();
        
        for(int i=0; i< modelRegister.getIdentificationTypes().size();i++){
           viewRegister.getCmbTipoIdentificacion().addItem(modelRegister.getIdentificationTypes().get(i).getNameTypeIdentification());
        }
    }
    
    private void fillCountries(){
        viewRegister.getCmbPais().removeAllItems();
        
        viewRegister.getCmbProvincia().removeAllItems();
        viewRegister.getCmbProvincia().setEnabled(false);
        
        viewRegister.getCmbCanton().removeAllItems();
        viewRegister.getCmbCanton().setEnabled(false);
        
        viewRegister.getCmbDistrito().removeAllItems();
        viewRegister.getCmbDistrito().setEnabled(false);
        
        viewRegister.getCmbPais().addItem("Seleccione País");
        for(int i=0; i<modelRegister.getCountries().size();i++){
            viewRegister.getCmbPais().addItem(modelRegister.getCountries().get(i).getNameCountry());
        }
    }
    
    private void fillProvinces(int country){
        viewRegister.getCmbProvincia().setEnabled(true);
        viewRegister.getCmbProvincia().removeAllItems();
       
        viewRegister.getCmbProvincia().addItem("Seleccione Provincia");
        for(int i=0; i<modelRegister.getProvinces().size();i++){
            if(country == modelRegister.getProvinces().get(i).getIdCountry()){
                 viewRegister.getCmbProvincia().addItem(modelRegister.getProvinces().get(i).getNameProvince());
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
        viewRegister.getCmbDistrito().setEnabled(true);
        viewRegister.getCmbDistrito().removeAllItems();
 
        for(int i=0; i<modelRegister.getDistricts().size();i++){
            if(canton == modelRegister.getDistricts().get(i).getIdCanton()){
                viewRegister.getCmbDistrito().addItem(modelRegister.getDistricts().get(i).getNameDistrict());  
            }
        }
    }
    
    //-------------------------------------------------------------------------------------------------------
    
    @Override
    public void itemStateChanged(ItemEvent e){
        //COUNTRY
        if( e.getSource() == viewRegister.getCmbPais()){
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
                    viewRegister.getCmbProvincia().removeAllItems();
                    viewRegister.getCmbProvincia().setEnabled(false);
                }
            }
        
        }
        
        //PROVINCE
        if( e.getSource() == viewRegister.getCmbProvincia()){
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
                    viewRegister.getCmbDistrito().removeAllItems();
                    viewRegister.getCmbDistrito().setEnabled(false);
                }
            }
        
        }
        
        //DISTRICT
        if( e.getSource() == viewRegister.getCmbDistrito()){
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
        if( e.getSource() == viewRegister.getCmbTipoIdentificacion()){
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
        if(e.getSource() == viewRegister.getCmbGenero()){
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
        
        //-------------- PANTALLA PRINCIPAL ----------------------
        /*NOTA: FALTA EL BOTON DE 'MI CUENTA'*/
        
        if(e.getSource() == viewPrincipal.getBtnIniciarSesion()){    
            viewLogin.setVisible(true);
            viewPrincipal.setVisible(false);
        }
        
                
        if(e.getSource() == viewPrincipal.getBtnRegistrar()){
            viewRegister.setVisible(true);
            viewPrincipal.setVisible(false);
        }
        
        if(e.getSource() == viewPrincipal.getBtnOpAdm()){
            viewMenuAdmin.setVisible(true);
            viewPrincipal.setVisible(false);
        }
        
        if(e.getSource() == viewPrincipal.getBtnConsultas()){
            viewRequest.setVisible(true);
            viewPrincipal.setVisible(false); 
        }
        
        if(e.getSource() == viewPrincipal.getBtnCuenta()){
            viewMyAccount.setVisible(true);
            viewPrincipal.setVisible(false); 
        }
        
        
               
        if(e.getSource() == viewPrincipal.getBtnSalir()){
            viewPrincipal.setVisible(false);
            
            viewPrincipal.getLblBienvenido().setVisible(false);
            viewPrincipal.getBtnConsultas().setVisible(false);
            viewPrincipal.getBtnOpAdm().setVisible(false);
            viewPrincipal.getBtnCuenta().setVisible(false);
            viewPrincipal.getBtnSalir().setVisible(false);
            
            viewPrincipal.getBtnIniciarSesion().setVisible(true);
            viewPrincipal.getBtnRegistrar().setVisible(true);
                        
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
                    
                    viewPrincipal.getBtnIniciarSesion().setVisible(false);
                    viewPrincipal.getBtnRegistrar().setVisible(false);
                
                    viewPrincipal.getBtnConsultas().setVisible(true);
                    viewPrincipal.getBtnCuenta().setVisible(true);
                    viewPrincipal.getBtnSalir().setVisible(true);
                
                    viewPrincipal.setTxtLblBienvenido("BIENVENIDO/A "+" "+modelLogin.getUsernameLogin());
                    viewPrincipal.getLblBienvenido().setVisible(true);
                    
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
        
        if(e.getSource() == viewRegister.getBtnCargarFoto()){
            if(modelRegister.selectPhoto(viewRegister)){
                viewRegister.setLocationRelativeTo(viewRegister);
                modelRegister.setImageLabel(viewRegister.getLblAvatar());
                viewRegister.repaint();
            }
        }
        
        if(e.getSource() == viewRegister.getBtnVerificarRegistro()){
            modelRegister.setFirstName(viewRegister.getTxtNombre());
            modelRegister.setSecondName(viewRegister.getTxtSegundoNombre());
            modelRegister.setFirstLastName(viewRegister.getTxtPrimerApellido());
            modelRegister.setSecondLastName(viewRegister.getTxtSegundoApellido());
            
            modelRegister.setUsernameRegister(viewRegister.getTxtUsername());
            modelRegister.setPasswordRegister(viewRegister.getTxtPassword());
            
            modelRegister.setIdentification(viewRegister.getTxtIdentificacion());
            modelRegister.setPhone(viewRegister.getTxtTelefono());
            
            modelRegister.setMail(viewRegister.getTxtCorreo());
            modelRegister.setAddress(viewRegister.getTxtDireccionExacta());
                      
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
                        viewRegister.cleanPrimerNombre();
                    }
                    
                    if(modelRegister.validateFormatString(modelRegister.getFirstName()) == false){
                        viewRegister.cleanPrimerApellido();
                    }
                    
                                     
                    flagRegister = false;
                }
                
                
                if(modelRegister.validateSecondName(modelRegister.getSecondName()) || modelRegister.validateSecondLastName(modelRegister.getSecondLastName())){
                    
                    if(modelRegister.validateSecondName(modelRegister.getSecondName())){
                        
                        if(modelRegister.validateFormatString(modelRegister.getSecondName()) == false){
                            
                            JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Segundo Nombre", "Error", JOptionPane.WARNING_MESSAGE);

                            viewRegister.cleanSegundoNombre();
                            flagRegister = false;
                        }
                    }
                    
                    if(modelRegister.validateSecondLastName(modelRegister.getSecondLastName())){
                        
                        if(modelRegister.validateFormatString(modelRegister.getSecondLastName()) == false){
                            
                            JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Segundo Apellido", "Error", JOptionPane.WARNING_MESSAGE);
                            
                            viewRegister.cleanSegundoApellido();
                            flagRegister = false;
                        }   
                    }
                    
                }
                
                
                if(modelRegister.validateFormatMail(modelRegister.getMail()) == false){ 
                    JOptionPane.showMessageDialog(null, "Formato de correo no válido", "Error", JOptionPane.WARNING_MESSAGE);
                    viewRegister.cleanCorreo();
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
                    viewRegister.cleanDireccion();
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
                viewPrincipal.getBtnRegistrar().setVisible(false);
                
                viewPrincipal.setVisible(true);
            }
                
        }
        
        //-------------- PANTALLA DE AdminOptions -----------------------
        if(e.getSource() == viewMenuAdmin.getBtnBack()){
            viewMenuAdmin.setVisible(false);
            viewPrincipal.getBtnIniciarSesion().setVisible(false);
            viewPrincipal.getBtnRegistrar().setVisible(false);
                
            viewPrincipal.getBtnConsultas().setVisible(true);
            viewPrincipal.getBtnCuenta().setVisible(true);
            viewPrincipal.getBtnSalir().setVisible(true);
            
            viewPrincipal.setTxtLblBienvenido("BIENVENIDO/A "+" "+modelLogin.getUsernameLogin());
            viewPrincipal.getLblBienvenido().setVisible(true);
            viewPrincipal.getBtnOpAdm().setVisible(true);
            
            viewPrincipal.setVisible(true);
        }
        
        //----------- PANTALLA DE Request -------------------------
        if(e.getSource() == viewRequest.getBtnBackRequest()){
            viewRequest.setVisible(false);
            viewPrincipal.getBtnIniciarSesion().setVisible(false);
            viewPrincipal.getBtnRegistrar().setVisible(false);
                
            viewPrincipal.getBtnConsultas().setVisible(true);
            viewPrincipal.getBtnCuenta().setVisible(true);
            viewPrincipal.getBtnSalir().setVisible(true);
            
            viewPrincipal.setTxtLblBienvenido("BIENVENIDO/A "+" "+modelLogin.getUsernameLogin());
            viewPrincipal.getLblBienvenido().setVisible(true);
            
            if(modelLogin.getResultUserType() == 0){
                viewPrincipal.getBtnOpAdm().setVisible(true);
            }
            
            viewPrincipal.setVisible(true);
        }
        
        //----------- PANTALLA DE MyAccount -------------------------
        if(e.getSource() == viewMyAccount.getBtnBackMyAccount()){
            viewMyAccount.setVisible(false);
            viewPrincipal.getBtnIniciarSesion().setVisible(false);
            viewPrincipal.getBtnRegistrar().setVisible(false);
                
            viewPrincipal.getBtnConsultas().setVisible(true);
            viewPrincipal.getBtnCuenta().setVisible(true);
            viewPrincipal.getBtnSalir().setVisible(true);
            
            viewPrincipal.setTxtLblBienvenido("BIENVENIDO/A "+" "+modelLogin.getUsernameLogin());
            viewPrincipal.getLblBienvenido().setVisible(true);
            
            if(modelLogin.getResultUserType() == 0){
                viewPrincipal.getBtnOpAdm().setVisible(true);
            }
            
            viewPrincipal.setVisible(true);
        }
        
    }
    
    
     public void showView()
     { 
        
        viewPrincipal.getBtnOpAdm().setVisible(false);
        viewPrincipal.getBtnConsultas().setVisible(false);
        viewPrincipal.getBtnCuenta().setVisible(false);
        viewPrincipal.getBtnSalir().setVisible(false);
        viewPrincipal.getLblBienvenido().setVisible(false);
        
        viewPrincipal.setVisible(true);
     }
  
}
