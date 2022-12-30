/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controller.OperationsController;
import Model.ValidarLogin;
import View.JF_Login;
import View.JF_Principal;

/**
 *
 * @author Mariana
 */
public class mainProject {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JF_Principal principal = new JF_Principal();
        ValidarLogin validarLogin = new ValidarLogin();
        //JF_Login login = new JF_Login();
        OperationsController controlador = new OperationsController(principal, validarLogin);
        controlador.showView();
        
        /*
        PantallaPrincipal vista = new PantallaPrincipal();
        OperationsModel modelo = new OperationsModel();
        
        controlador.showView();*/
        
    }
    
    
    
}
