/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Mariana
 */
public class model_Login {
    private String usernameLogin;
    private String passwordLogin;
    
    
    //--------- METODOS -------------------
    public boolean validarCampos(){
        if(this.usernameLogin.isEmpty() || this.passwordLogin.isEmpty()){
            return true;
        }
       
        return false;
    }
    
    public boolean validarUsername(){ //Falta realizar la validación de si es Admin o Usuario
        return false;
    }
    
    public boolean validarPassword(){ //Falta realizar la validación de si es Admin o Usuario
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
   
}
