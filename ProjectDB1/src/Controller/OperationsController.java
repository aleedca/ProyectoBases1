/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ValidarLogin;
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
    private ValidarLogin validarLogin;
    private JF_Principal viewPrincipal;
        
    //Constructor 2da version
    public OperationsController(JF_Principal principal, ValidarLogin validarLogin) { //JF_Login login
        this.viewPrincipal = principal;
        JF_Login login = new JF_Login();
        this.viewLogin = login;  
        this.validarLogin = validarLogin;  
        _init_(); 
    }
    
    //SETTERS

    public void setViewLogin(JF_Login viewLogin) {
        this.viewLogin = viewLogin;
    }
    
    
    

    // inicia el binding con la vista
    public void _init_(){
        viewPrincipal.getBtnIniciarSesion().addActionListener(this);
        viewLogin.getBtnLogin().addActionListener(this);
        //viewLogin.getBtnBack().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if("Iniciar Sesión".equals(e.getActionCommand())){
            System.out.println("Correcto");
            
            viewLogin.setVisible(true);
            
            viewPrincipal.dispose();
        }
        
        if("LOGIN".equals(e.getActionCommand())){
            validarLogin.setUsernameLogin(viewLogin.getTxtUsernameLogin());
            validarLogin.setPasswordLogin(viewLogin.getTxtPasswordLogin());
            
            if(validarLogin.validarCampos()){
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos solicitados", "Error", JOptionPane.WARNING_MESSAGE);
                viewLogin.cleanUsernameLogin();
                viewLogin.cleanPasswordLogin();
            }else{
                viewLogin.cleanUsernameLogin();
                viewLogin.cleanPasswordLogin();
            
                //JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            
                //**Validar username y password***
            
                if(validarLogin.validarUsername() == true && validarLogin.validarPassword() == true){ //Es true -> Admin
                        //Frame de Admin
                }else{
                        //Frame Usuario
                }    
            }
        } //Cierre del 1er IF-ELSE
        
        
        System.out.println(e.getActionCommand());
        
    }
    
    
     public void showView()
     { 
        viewPrincipal.setVisible(true);
     }
    
    /*
        private OperationsModel modelo;
    private PantallaPrincipal vista;

    //constructor
    public OperationsController(OperationsModel modelo, PantallaPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
        _init_();        
    }
    
    // inicia el binding con la vista
    private void _init_ (){
        vista.btnMultiplicar.addActionListener(this);
        vista.btnSumar.addActionListener(this);
        
        vista.setTitle("Multiplicar");
    }
        @Override
    public void actionPerformed(ActionEvent e) {
        modelo.setNumero1(Integer.parseInt(vista.txfValor1.getText()));
        modelo.setNumero2(Integer.parseInt(vista.txfValor2.getText()));
        modelo.multiplicar();
        vista.setResultado(String.valueOf(modelo.getResultado()));
    }
    


    
    public void showView (){ vista.setVisible(true);}
    */
}
