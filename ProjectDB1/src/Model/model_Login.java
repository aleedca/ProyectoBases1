/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Person;
import java.sql.SQLException;


/**
 *
 * @author Mariana
 */
public class model_Login {
    private static String usernameLogin;
    private String passwordLogin;
    private int resultUserType;
    
    
    //--------- METODOS -------------------
    public boolean validarCampos(){
        if(this.usernameLogin.isEmpty() || this.passwordLogin.isEmpty()){
            return true;
        }
       
        return false;
    }
    
    public boolean userAlreadyExists(String username){
        try {
            this.resultUserType = DA_Person.validateUserAlreadyExists(username);
            System.out.println("Lo que le dio la base: "+ this.resultUserType);
            
            if(this.resultUserType != 0){ //Si es diferente de 0, quiere decir, que no existe
                return false;// Si el username no existe en la base -> return false
            }else{
                return true; //Si ya existe return true
            }
                     
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return false; 
    }
   
    
    
    
    public boolean userExists(){
        try {
            this.resultUserType = DA_Person.validateUserType(this.usernameLogin, this.passwordLogin);
            
            if(this.resultUserType != 0 && this.resultUserType != 1){
                return false;
            }else{
                return true;
            }
                     
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return false;
    }
    
    
    public boolean validateUserType(){ 
        try {
            this.resultUserType = DA_Person.validateUserType(this.usernameLogin, this.passwordLogin);
            
            if (this.resultUserType == 0) {
                return true;
            } else {
                return false;
            }
                     
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return false;
    }
    

    
    //------------ GETTERS AND SETTERS ----------------------

    public static String getUsernameLogin() {
        return usernameLogin;
    }

    public void setUsernameLogin(String usernameLogin) {
        this.usernameLogin = usernameLogin;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    public int getResultUserType() {
        return resultUserType;
    }

    public void setResultUserType(int resultUserType) {
        this.resultUserType = resultUserType;
    }
    
    
   
}
