
package Model;

import DataAccess.DA_Catalogs;
import Objects.Country;
import Objects.Gender;
import Objects.TypeIdentification;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 *
 * @author Mariana
 */
public class model_Register {
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String identification;
    private String mail;
    private String usernameRegister;
    private String passwordRegister;
    private String phone;
  
    private String province;
    private String canton;
    private String district;
    private String address;
    private String photo;
    
    private String gender;
    private ArrayList<Gender> genders;
    
    private String typeIdentification;
    private ArrayList<TypeIdentification> identificationTypes;
    
    private String country;
    private ArrayList<Country> countries;
    
    
    
    //------------ Builder ----------------------

    public model_Register() {
        
        try {
            this.genders = DA_Catalogs.getGender();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        
        try {
            this.identificationTypes = DA_Catalogs.getTypeIdentification();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        try {
            this.countries = DA_Catalogs.getCountry();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }
    
    
    //--------- METHODS -------------------  
    
    //-------------- VALIDATIONS -------------------------------------
    public boolean validateEmptyFields(String firstName, String firstLastName, String identification, 
            String username, String password, String mail, String phone, String address){
        
        if(firstName.isEmpty() || firstLastName.isEmpty() || identification.isEmpty() || address.isEmpty()){
            return true;
        }else{
            if(username.isEmpty() || password.isEmpty() || mail.isEmpty() || phone.isEmpty()){
                return true;
            }
        }
       
        System.out.println("Campos completos");
        return false;
    }
    
    // La contraseña debe tener al entre 4 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula.
    //NO puede tener otros símbolos.
    private static final String PASSWORD_REGEX = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{4,16}$";
    
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
    
    public boolean validateFormatPassword(String password){
        if (PASSWORD_PATTERN.matcher( password).matches()) {
            System.out.println("Password valida");
            return true;
	}
        
        return false;
    }
    
    
    public boolean validateFormatUsername(String username){
        String regex = "^[A-Za-z0-9_]{5,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(username);
        
        if (mather.matches()) {
            System.out.println("Username valido");
            return true;
        } 
        
        return false;
    }
    
    public boolean validateFormatMail(String mail){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(mail);
        
        if (mather.find() == true) {
            System.out.println("Correo valido");
            return true;
        } 
         
        return false;
    }
    
    
    public boolean validateSecondName(String secondName){
        if(secondName.isEmpty()){
             return false;
        }
        return true;
    }
    
    public boolean validateSecondLastName(String secondLastName){
        if(secondLastName.isEmpty()){
             return false;
        }
        
        return true;
    }
    
    public boolean validateFormatString(String sentence){
        String regex = "^[A-Za-z\\ÑñáéíóúÁÉÍÓÚ]{3,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(sentence);
        
        if (mather.matches()) {
            System.out.println("Cadena valida");
            return true;
        } 
        
        return false;
    }
    
    public boolean validarFormatoDireccion(String address){
        String regex = "^[A-Za-z\\s\\d\\#,.ÑñáéíóúÁÉÍÓÚ]{50,200}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(address);
        
        if (mather.matches()) {
            System.out.println("Direccion valida");
            return true;
        } 
        
        return false;
    }
    
    public boolean validatePhoto(String photo){
        if(photo == null){
            return true;
        }
        
       return false;
    }
    
    //----------------------------------------------------------------------------------------------------------
  
    public void setImageLabel(JLabel labelName){
        ImageIcon image = new ImageIcon(this.photo);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
    }
        
    //----------------GETTERS AND SETTERS----------------------------------------

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsernameRegister() {
        return usernameRegister;
    }

    public void setUsernameRegister(String usernameRegister) {
        this.usernameRegister = usernameRegister;
    }

    public String getPasswordRegister() {
        return passwordRegister;
    }

    public void setPasswordRegister(String passwordRegister) {
        this.passwordRegister = passwordRegister;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTypeIdentification() {
        return typeIdentification;
    }

    public void setTypeIdentification(String typeIdentification) {
        this.typeIdentification = typeIdentification;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    //-------------------------------------------------------------------
    
    public ArrayList<Gender> getGenders() {
        return genders;
    }

    public void setGenders(ArrayList<Gender> genders) {
        this.genders = genders;
    }

    public ArrayList<TypeIdentification> getIdentificationTypes() {
        return identificationTypes;
    }

    public void setIdentificationTypes(ArrayList<TypeIdentification> identificationTypes) {
        this.identificationTypes = identificationTypes;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }
    
    
    
 
}
