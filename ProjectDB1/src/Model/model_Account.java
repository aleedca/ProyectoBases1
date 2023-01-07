/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_MyAccount;
import Objects.Account;
import java.sql.SQLException;

/**
 *
 * @author Isaac
 */
public class model_Account {
    
    private String usernameValidated;
    private Account accountLogged;

    public model_Account() {
        try {
            this.accountLogged = DA_MyAccount.getAccountInfo(this.usernameValidated);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
      

    public String getUsernameValidated() {
        return usernameValidated;
    }

    public void setUsernameValidated(String usernameValidated) {
        this.usernameValidated = usernameValidated;
    }
    
    
    
    
}
