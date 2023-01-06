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
    private String usernameLogin;
    private String passwordLogin;
    private int resultUserType;
    
    
    //--------- METODOS -------------------
    public boolean validarCampos(){
        if(this.usernameLogin.isEmpty() || this.passwordLogin.isEmpty()){
            return true;
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

    public String getUsernameLogin() {
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
