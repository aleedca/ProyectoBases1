/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.model_Register;
import View.JF_AdminPerson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


/**
 *
 * @author Mariana
 */

public class OperationsControllerAlexia implements ActionListener{
    private final JF_AdminPerson viewAdminPerson;
    private final model_Register modelRegister;
    private boolean flagRegister;
        
    
    //Constructor 2da version
    public OperationsControllerAlexia() { 
        //View AdminPerson
        JF_AdminPerson adminPerson = new JF_AdminPerson();
        this.viewAdminPerson = adminPerson;  

        //Model Register
        model_Register validateRegister = new model_Register();
        this.modelRegister = validateRegister;
        
        
        _init_(); 

    }
    
    //Init de ActionListener
    private void _init_(){
        //AdminPerson
        viewAdminPerson.getBtnAceptar().addActionListener(this);
        
    }
    
   
    //-------------------------------------------------------------------------------------------------------
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    
     public void showView()
     { 
        
        viewAdminPerson.setVisible(true);
     }
  
}
