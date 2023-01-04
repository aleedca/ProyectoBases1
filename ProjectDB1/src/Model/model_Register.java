
package Model;

import DataAccess.DA_Catalogs;
import DataAccess.DA_Person;
import Objects.Canton;
import Objects.Country;
import Objects.District;
import Objects.Gender;
import Objects.Province;
import Objects.TypeIdentification;
import View.JF_Register;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Mariana
 */
public class model_Register {
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private int identification;
    private String mail;
    private String usernameRegister;
    private String passwordRegister;
    private int phone;
    private String address;
    private String photo;
    
    private int gender;
    private ArrayList<Gender> genders;
    
    private int typeIdentification;
    private ArrayList<TypeIdentification> identificationTypes;
    
    private int country;
    private ArrayList<Country> countries;
    
    private int province;
    private ArrayList<Province> provinces;
    
    private int canton;
    private ArrayList<Canton> cantons;
    
    private int district;
    private ArrayList<District> districts;
    
    private final JFileChooser file = new JFileChooser();
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");;
    
    
    //------------ Builder ----------------------
    public model_Register() {
        
        try {
            this.genders = DA_Catalogs.getGender();
            
            this.identificationTypes = DA_Catalogs.getTypeIdentification();
            
            this.countries = DA_Catalogs.getCountry();
            
            this.provinces = DA_Catalogs.getProvince();
            
            this.cantons = DA_Catalogs.getCanton();
            
            this.districts = DA_Catalogs.getDistrict();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        
    }
    
    
    //--------- METHODS -------------------  
    
    //-------------- VALIDATIONS -------------------------------------
    public boolean validateEmptyFields(String firstName, String firstLastName, 
            String username, String password, String mail, String address){
        
        if(firstName.isEmpty() || firstLastName.isEmpty() || address.isEmpty()){
            return true;
        }else{
            if(username.isEmpty() || password.isEmpty() || mail.isEmpty()){
                return true;
            }
        }
       
        return false;
    }
    
    // La contraseña debe tener al entre 4 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula.
    //NO puede tener otros símbolos.
    private static final String PASSWORD_REGEX = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{4,16}$";
    
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
    
    public boolean validateFormatPassword(String password){
        if (PASSWORD_PATTERN.matcher( password).matches()) {
            return true;
	}
        
        return false;
    }
    
    
    public boolean validateFormatUsername(String username){
        String regex = "^[A-Za-z0-9_]{5,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(username);
        
        if (mather.matches()) {
            return true;
        } 
        
        return false;
    }
    
    public boolean validateFormatMail(String mail){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(mail);
        
        if (mather.find() == true) {
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
            return true;
        } 
        
        return false;
    }
    
    public boolean validarFormatoDireccion(String address){
        String regex = "^[A-Za-z\\s\\d\\#,.ÑñáéíóúÁÉÍÓÚ]{20,200}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(address);
        
        if (mather.matches()) {
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
  
    public void inserUser(){
        try {   
            System.out.println("Entro a llamar a la base");
            DA_Person.insertUserPerson(this.usernameRegister, this.passwordRegister, this.identification, this.firstName,
                    this.secondName, this.firstLastName, this.secondLastName, this.photo, 
                    this.country, this.typeIdentification, this.gender, this.mail, this.phone, 
                    this.district, this.address);
        
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    
    public boolean selectPhoto(JF_Register register){
        file.setFileFilter(this.filter);
        file.showOpenDialog(register);
        try{
            photo = file.getSelectedFile().getPath();
            return true;
        }catch(NullPointerException e){
            System.out.println("No se ha seleccionado ningún fichero");
        } 
        
        return false;
    }
    
    
    public void setImageLabel(JLabel labelName){
        ImageIcon image = new ImageIcon(this.photo);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH));
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

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getTypeIdentification() {
        return typeIdentification;
    }

    public void setTypeIdentification(int typeIdentification) {
        this.typeIdentification = typeIdentification;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCanton() {
        return canton;
    }

    public void setCanton(int canton) {
        this.canton = canton;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
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

    public ArrayList<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(ArrayList<Province> provinces) {
        this.provinces = provinces;
    }

    public ArrayList<Canton> getCantons() {
        return cantons;
    }

    public void setCantons(ArrayList<Canton> cantons) {
        this.cantons = cantons;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<District> districts) {
        this.districts = districts;
    }
    
    
    
 
}
