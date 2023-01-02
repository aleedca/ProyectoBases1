/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;


import Controller.OperationsController;


import View.JF_Principal;

import Objects.Gender;
import DataAccess.DA_Catalogos;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Mariana
 */
public class mainProject {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*        
        
        JF_Principal principal = new JF_Principal();
        
        OperationsController controlador = new OperationsController(principal);
        
        controlador.showView();
        
        */
        
        try{
        ArrayList<Gender> genders = DA_Catalogos.getGender();
        genders.forEach(gender ->{
            System.out.println(gender.getDescriptionGender());
        });

        }catch(SQLException ex){
            System.out.println(ex);
        }

    }
    
}
