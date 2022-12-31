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

import javax.swing.JOptionPane;


/**
 *
 * @author Mariana
 */

public class OperationsController implements ActionListener{
    private JF_Principal viewPrincipal;
    private JF_Login viewLogin;
    private JF_Register viewRegister;
    
    private model_Login modelLogin;
    private model_Register modelRegister;
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
        model_Login validarLogin = new model_Login();
        this.modelLogin = validarLogin;  
        
        //Model Register
        model_Register validarRegister = new model_Register();
        this.modelRegister = validarRegister;
        
        
        _init_(); 
    }
    
    //Init de ActionListener
    public void _init_(){
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
                
                viewPrincipal.getBtnCuenta().setVisible(true);
                viewPrincipal.getBtnSalir().setVisible(true);
                
                viewPrincipal.setTxtLblBienvenido("BIENVENIDO/A "+" "+modelLogin.getUsernameLogin());
                viewPrincipal.getLblBienvenido().setVisible(true);
                
                //**NOTA: Validar username y password***
                if(modelLogin.validarUsername() == true && modelLogin.validarPassword() == true){ //Es true -> Admin
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
            modelRegister.setFoto("src/Images/prueba.jpg");
            
            viewRegister.setLocationRelativeTo(viewRegister);
            modelRegister.setImageLabel(viewRegister.getLblAvatar());
        }
        
        if(e.getSource() == viewRegister.getBtnVerificarRegistro()){
            modelRegister.setPrimerNombre(viewRegister.getTxtNombre());
            modelRegister.setSegundoNombre(viewRegister.getTxtSegundoNombre());
            modelRegister.setPrimerApellido(viewRegister.getTxtPrimerApellido());
            modelRegister.setSegundoApellido(viewRegister.getTxtSegundoApellido());
            
            modelRegister.setTipoIdentificacion(viewRegister.getCmbTipoIdentificacion());
            modelRegister.setIdentificacion(viewRegister.getTxtIdentificacion());
            
            modelRegister.setUsernameRegister(viewRegister.getTxtUsername());
            modelRegister.setPasswordRegister(viewRegister.getTxtPassword());
            
            modelRegister.setTipoTelefono(viewRegister.getCmbTipoTelefono());
            modelRegister.setTelefono(viewRegister.getTxtTelefono());
            modelRegister.setCorreo(viewRegister.getTxtCorreo());
            
            modelRegister.setGenero(viewRegister.getCmbGenero());
            modelRegister.setPais(viewRegister.getCmbPais());
            modelRegister.setProvincia(viewRegister.getCmbProvincia());
            modelRegister.setCanton(viewRegister.getCmbCanton());
            modelRegister.setDistrito(viewRegister.getCmbDistrito());
            modelRegister.setDireccion(viewRegister.getTxtDireccionExacta());
            
            flagRegister = true;
            if(modelRegister.validarCamposVacios(modelRegister.getPrimerNombre(), modelRegister.getPrimerApellido(),
                                                modelRegister.getIdentificacion(), modelRegister.getUsernameRegister(), 
                                                modelRegister.getPasswordRegister(), modelRegister.getCorreo(), modelRegister.getTelefono(), 
                                                modelRegister.getDireccion(), modelRegister.getFoto()) == true)
            {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios solicitados", "Error", JOptionPane.WARNING_MESSAGE);
                //viewRegister.cleanAll();
                flagRegister = false;
            }else{
                              
                if(modelRegister.validarFormatoCadena(modelRegister.getPrimerNombre()) == false ||  modelRegister.validarFormatoCadena(modelRegister.getPrimerApellido())== false)
                {
                    
                    JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Nombre y Primer Apellido", "Error", JOptionPane.WARNING_MESSAGE);
                    
              
                    if(modelRegister.validarFormatoCadena(modelRegister.getPrimerNombre()) == false){
                        System.out.println("Nombre");
                        viewRegister.cleanPrimerNombre();
                    }
                    
                    if(modelRegister.validarFormatoCadena(modelRegister.getPrimerApellido()) == false){
                        System.out.println("Apellido");
                        viewRegister.cleanPrimerApellido();
                    }
                    
                                     
                    flagRegister = false;
                }
                
                
                if(modelRegister.validarSegundoNombre(modelRegister.getSegundoNombre()) || modelRegister.validarSegundoApellido(modelRegister.getSegundoApellido())){
                    
                    if(modelRegister.validarSegundoNombre(modelRegister.getSegundoNombre())){
                        System.out.println("SegundoNombre no nulo");
                        
                        if(modelRegister.validarFormatoCadena(modelRegister.getSegundoNombre()) == false){
                            
                            JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Segundo Nombre", "Error", JOptionPane.WARNING_MESSAGE);
                            
                            System.out.println("SegundoNombre");
                            viewRegister.cleanSegundoNombre();
                            flagRegister = false;
                        }
                    }
                    
                    if(modelRegister.validarSegundoApellido(modelRegister.getSegundoApellido())){
                        System.out.println("SegundoApellido no nulo");
                        
                        if(modelRegister.validarFormatoCadena(modelRegister.getSegundoApellido()) == false){
                            
                            JOptionPane.showMessageDialog(null, "Formato inválido. \nRecuerde solo ingresar letras en el Segundo Apellido", "Error", JOptionPane.WARNING_MESSAGE);
                            
                            System.out.println("SegundoApellido");
                            viewRegister.cleanSegundoApellido();
                            flagRegister = false;
                        }   
                    }
                    
                }
                
                
                if(modelRegister.validarFormatCorreo(modelRegister.getCorreo()) == false){ 
                    JOptionPane.showMessageDialog(null, "Formato de correo no válido", "Error", JOptionPane.WARNING_MESSAGE);
                    viewRegister.cleanCorreo();
                    flagRegister = false;
                }
                
                
                if(modelRegister.validarFormatUsername(modelRegister.getUsernameRegister()) == false){
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese únicamente letras, números o el caracter _ para crear su username.\nDebe tener al menos 5 caracteres y sin espacios.", "Error", JOptionPane.WARNING_MESSAGE);
                    viewRegister.cleanUsername();
                    flagRegister = false;
                }
                
                if(modelRegister.validarFormatPassword(modelRegister.getPasswordRegister()) == false){
                    JOptionPane.showMessageDialog(null, "Formato de contraseña incorrecta.\nDebe contener entre 4 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula.", "Error", JOptionPane.WARNING_MESSAGE);
                    viewRegister.cleanPassword();
                    flagRegister = false;
                }
                
                if(modelRegister.validarFormatoDireccion(modelRegister.getDireccion()) == false){
                    JOptionPane.showMessageDialog(null, "Dirección no válida.\nDebe contener un mínimo de 50 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
                    viewRegister.cleanDireccion();
                    flagRegister = false;
                }
                
                if(modelRegister.validarFoto(modelRegister.getFoto())){
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
        viewPrincipal.getBtnCuenta().setVisible(false);
        viewPrincipal.getBtnSalir().setVisible(false);
        viewPrincipal.getLblBienvenido().setVisible(false);
        
        viewPrincipal.setVisible(true);
     }
  
}
