/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.model_Login;
import View.JF_Login;
import View.JF_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Mariana
 */

public class OperationsController implements ActionListener{
    private JF_Login viewLogin;
    private model_Login modelLogin;
    private JF_Principal viewPrincipal;
        
    //Constructor 2da version
    public OperationsController(JF_Principal principal) { 
        this.viewPrincipal = principal;
        
        
        JF_Login login = new JF_Login();
        this.viewLogin = login;  
        
        model_Login validarLogin = new model_Login();
        this.modelLogin = validarLogin;  
        
        
        _init_(); 
    }
    
    //SETTERS

    public void setViewLogin(JF_Login viewLogin) {
        this.viewLogin = viewLogin;
    }
    
  
    // inicia el binding con la vista
    public void _init_(){
        viewPrincipal.getBtnIniciarSesion().addActionListener(this);
        viewPrincipal.getBtnRegistrar().addActionListener(this);
        viewPrincipal.getBtnOpAdm().addActionListener(this);
        viewPrincipal.getBtnCuenta().addActionListener(this);
        viewPrincipal.getBtnSalir().addActionListener(this);
        
        
        viewLogin.getBtnLogin().addActionListener(this);
        viewLogin.getBtnBack().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == viewPrincipal.getBtnIniciarSesion()){    
            System.out.println("Entro Iniciar Sesion");
            viewLogin.setVisible(true);
            viewPrincipal.setVisible(false);
        }
        
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
            
                //**Validar username y password***
            
                if(modelLogin.validarUsername() == true && modelLogin.validarPassword() == true){ //Es true -> Admin
                        //Frame de Admin
                }else{
                    //Frame Usuario     
                    viewPrincipal.getBtnIniciarSesion().setVisible(false);
                    viewPrincipal.getBtnRegistrar().setVisible(false);
                    viewPrincipal.getBtnCuenta().setVisible(true);
                    viewPrincipal.getBtnSalir().setVisible(true);
                    
                    viewPrincipal.setVisible(true);    
                }    
            }
        }
        
        
        if(e.getSource() == viewLogin.getBtnBack()){
            viewPrincipal.setVisible(true); 
            viewLogin.setVisible(false);
        }
        
        if(e.getSource() == viewPrincipal.getBtnSalir()){
            viewPrincipal.setVisible(false);
            viewPrincipal.getBtnSalir().setVisible(false);
            viewPrincipal.getBtnIniciarSesion().setVisible(true);
            viewPrincipal.setVisible(true);
        }
        
    }
    
    
     public void showView()
     { 
        viewPrincipal.getBtnOpAdm().setVisible(false);
        viewPrincipal.getBtnCuenta().setVisible(false);
        viewPrincipal.getBtnSalir().setVisible(false);
        viewPrincipal.setVisible(true);
     }
  
}
