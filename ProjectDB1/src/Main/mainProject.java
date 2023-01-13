/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;


import Controller.OperationsController;
import View.JF_Principal;
import java.sql.SQLException;


/**
 *
 * @author Mariana
 */
public class mainProject {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
            JF_Principal principal = new JF_Principal();
            
            OperationsController controlador = new OperationsController(principal);
            
            controlador.showView();
    }
    
}
