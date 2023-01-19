/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Catalogs;
import DataAccess.DA_MyAccount;
import Objects.Account;
import Objects.Gender;
import View.JF_EditAccount;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Isaac
 */
public class model_Account {
    
    private String usernameValidated;
    private Account accountLogged;
    private ArrayList<Gender> genders;
    private String photo = "";
    private final JFileChooser file = new JFileChooser();
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");

    public model_Account() {
        
    }
    
    
    private void getInfo(){
        try {
            this.accountLogged = DA_MyAccount.getAccountInfo(this.usernameValidated);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private void getInfoGenders(){
        try {
            this.genders = DA_Catalogs.getGender();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateProfileInformation(String pUsername, String pPassword, String pName, String pName2, String pLastName, String pLastName2, int pGender, String pEmail, int pPhone, String pPhoto){
        try {
            DA_MyAccount.updateAccount(pUsername, pPassword, pName, pName2, pLastName, pLastName2, pGender, pEmail, pPhone, pPhoto);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public boolean selectPhoto(JF_EditAccount editAccount){
        file.setFileFilter(this.filter);
        file.showOpenDialog(editAccount);
        try{
            photo = file.getSelectedFile().getPath();
            return true;
        }catch(NullPointerException e){
            System.out.println("No se ha seleccionado ningún fichero");
        } 
        
        return false;
    }

    public String getUsernameValidated() {
        return usernameValidated;
    }

    public void setUsernameValidated(String usernameValidated) {
        this.usernameValidated = usernameValidated;
        this.getInfo();
        this.getInfoGenders();
    }

    public Account getAccountLogged() {
        return accountLogged;
    }
    
    public ArrayList<Gender> getGenders(){
        return this.genders;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}
