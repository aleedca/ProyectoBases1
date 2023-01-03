/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.model_Login;
import Model.model_Register;
import View.JF_Login;
import View.JF_Principal;
import View.JF_Register;
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
        System.out.println("\n");
        //fillProvinces();
//        fillCantons();
//        fillDistricts();
    }
    
    //Init de ActionListener
    private void _init_(){
        //Principal
        viewPrincipal.getBtnIniciarSesion().addActionListener(this);
        viewPrincipal.getBtnRegistrar().addActionListener(this);
        viewPrincipal.getBtnOpAdm().addActionListener(this);
        viewPrincipal.getBtnCuenta().addActionListener(this);
        viewPrincipal.getBtnSalir().addActionListener(this);
        
        //Login
        viewLogin.getBtnLogin().addActionListener(this);
        viewLogin.getBtnBack().addActionListener(this);
        
        //Register
        viewRegister.getBtnBack().addActionListener(this);
        viewRegister.getBtnVerificarRegistro().addActionListener(this);
        viewRegister.getBtnCargarFoto().addActionListener(this);
        
        viewRegister.getCmbPais().addItemListener(this);
        viewRegister.getCmbProvincia().addItemListener(this);
        viewRegister.getCmbCanton().addItemListener(this);
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
                System.out.println(choice);
                
                if(!"Seleccione País".equals(choice)){
                    
                    for(int i=0; i<modelRegister.getCountries().size();i++){
                        if( choice.equals(modelRegister.getCountries().get(i).getNameCountry())){
                            fillProvinces(modelRegister.getCountries().get(i).getIdCountry());
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
                System.out.println(choice);
                
                if(!"Seleccione Provincia".equals(choice)){
                    
                    for(int i=0; i<modelRegister.getProvinces().size();i++){
                        if( choice.equals(modelRegister.getProvinces().get(i).getNameProvince())){
                            fillCantons(modelRegister.getProvinces().get(i).getIdProvince());
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
                System.out.println(choice);
                
                if(!"Seleccione Cantón".equals(choice)){
                    
                    for(int i=0; i<modelRegister.getCantons().size();i++){
                        if( choice.equals(modelRegister.getCantons().get(i).getNameCanton())){
                            fillDistricts(modelRegister.getCantons().get(i).getIdCanton());
                        }
                    }
                    
                }else{
                    viewRegister.getCmbDistrito().removeAllItems();
                    viewRegister.getCmbDistrito().setEnabled(false);
                }
            }
        
        }
        
        

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //-------------- PANTALLA PRINCIPAL ----------------------
        /*NOTA: FALTA EL BOTON DE 'MI CUENTA' Y DE 'MENU ADMIN'*/
        
        if(e.getSource() == viewPrincipal.getBtnIniciarSesion()){    
            viewLogin.setVisible(true);
            viewPrincipal.setVisible(false);
        }
        
                
        if(e.getSource() == viewPrincipal.getBtnRegistrar()){
            viewRegister.setVisible(true);
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
                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                viewLogin.cleanUsernameLogin();
                viewLogin.cleanPasswordLogin();
                viewLogin.setVisible(false);
            
                viewPrincipal.getBtnIniciarSesion().setVisible(false);
                viewPrincipal.getBtnRegistrar().setVisible(false);
                
                viewPrincipal.getBtnConsultas().setVisible(true);
                viewPrincipal.getBtnCuenta().setVisible(true);
                viewPrincipal.getBtnSalir().setVisible(true);
                
                viewPrincipal.setTxtLblBienvenido("BIENVENIDO/A "+" "+modelLogin.getUsernameLogin());
                viewPrincipal.getLblBienvenido().setVisible(true);
                
                //**NOTA: Validar username y password***
                if(modelLogin.validateUsername() == true && modelLogin.validatePassword() == true){ //Es true -> Admin
                    //Frame de Admin                         
                    viewPrincipal.getBtnOpAdm().setVisible(true);
                }
  
                viewPrincipal.setVisible(true);   
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
            
            modelRegister.setTypeIdentification(viewRegister.getSelectedTypeIdentification());
            modelRegister.setIdentification(viewRegister.getTxtIdentificacion());
            
            modelRegister.setUsernameRegister(viewRegister.getTxtUsername());
            modelRegister.setPasswordRegister(viewRegister.getTxtPassword());
            
            
            modelRegister.setPhone(viewRegister.getTxtTelefono());
            modelRegister.setMail(viewRegister.getTxtCorreo());
            
            modelRegister.setGender(viewRegister.getSelectedGender());
            modelRegister.setCountry(viewRegister.getSelectedCountry());
            modelRegister.setProvince(viewRegister.getSelectedProvince());
            modelRegister.setCanton(viewRegister.getSelectedCanton());
            modelRegister.setDistrict(viewRegister.getSelectedDistrict());
            modelRegister.setAddress(viewRegister.getTxtDireccionExacta());
            
            flagRegister = true;
            if(modelRegister.validateEmptyFields(modelRegister.getFirstName(), modelRegister.getFirstLastName(),
                                                modelRegister.getIdentification(), modelRegister.getUsernameRegister(), 
                                                modelRegister.getPasswordRegister(), modelRegister.getMail(), modelRegister.getPhone(), 
                                                modelRegister.getAddress()) == true)
            {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios solicitados", "Error", JOptionPane.WARNING_MESSAGE);
                //viewRegister.cleanAll();
                flagRegister = false;
            }else{
                              
                if(modelRegister.validateFormatString(modelRegister.getFirstName()) == false ||  modelRegister.validateFormatString(modelRegister.getFirstLastName())== false)
                {
                    
                    JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Nombre y Primer Apellido", "Error", JOptionPane.WARNING_MESSAGE);
                    
              
                    if(modelRegister.validateFormatString(modelRegister.getFirstName()) == false){
                        System.out.println("Nombre");
                        viewRegister.cleanPrimerNombre();
                    }
                    
                    if(modelRegister.validateFormatString(modelRegister.getFirstName()) == false){
                        System.out.println("Apellido");
                        viewRegister.cleanPrimerApellido();
                    }
                    
                                     
                    flagRegister = false;
                }
                
                
                if(modelRegister.validateSecondName(modelRegister.getSecondName()) || modelRegister.validateSecondLastName(modelRegister.getSecondLastName())){
                    
                    if(modelRegister.validateSecondName(modelRegister.getSecondName())){
                        System.out.println("SegundoNombre no nulo");
                        
                        if(modelRegister.validateFormatString(modelRegister.getSecondName()) == false){
                            
                            JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Segundo Nombre", "Error", JOptionPane.WARNING_MESSAGE);
                            
                            System.out.println("SegundoNombre");
                            viewRegister.cleanSegundoNombre();
                            flagRegister = false;
                        }
                    }
                    
                    if(modelRegister.validateSecondLastName(modelRegister.getSecondLastName())){
                        System.out.println("SegundoApellido no nulo");
                        
                        if(modelRegister.validateFormatString(modelRegister.getSecondLastName()) == false){
                            
                            JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Segundo Apellido", "Error", JOptionPane.WARNING_MESSAGE);
                            
                            System.out.println("SegundoApellido");
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
                JOptionPane.showMessageDialog(null, "Felicidades, su cuenta se creó correctamte.\nInicie sesión para comenzar a disfrutar de nuestra aplicación" );
                viewRegister.cleanAll();
                viewRegister.setVisible(false);
                viewPrincipal.getBtnRegistrar().setVisible(false);
                
                viewPrincipal.setVisible(true);
            }
                
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
