/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Image;
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
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String tipoIdentificacion;
    private String identificacion;
    private String correo;
    private String usernameRegister;
    private String passwordRegister;
    private String tipoTelefono;
    private String telefono;
    private String genero;
    private String pais;
    private String provincia;
    private String canton;
    private String distrito;
    private String direccion;
    private String foto;
    
    
    //--------- METODOS -------------------    
    public boolean validarCamposVacios(){
        if(this.primerNombre.isEmpty() || this.primerApellido.isEmpty() || this.identificacion.isEmpty()){
            if(this.usernameRegister.isEmpty() || this.passwordRegister.isEmpty() ||this.correo.isEmpty()){
                if(this.telefono.isEmpty() || this.direccion.isEmpty()){
                    return true;
                }
            }
        }
       
        return false;
    }
    
    
    // 4-8 character password requiring numbers and alphabets of both cases
    private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$";
    
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
    
    public boolean validarFormatPassword(String password){
        if (PASSWORD_PATTERN.matcher(password).matches()) {
		return true;
	}
        
        return false;
    }
    
    public boolean validarFormatUsername(String username){
        if(username.length() >= 5){
            return true;
        }
        
        return false;
    }
    
    public boolean validarFormatCorreo(String correo){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        
        if (mather.find() == true) {
            return true;
        } 
         
        return false;
    }
    
    
    public boolean validarFormatoTelefono(String telefono){
        String regex = "^\\d{4}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(telefono);
        
        if (mather.matches()) {
            return true;
        } 
        
        return false;
    }
   
        
    private void setImageLabel(JLabel labelName, String imageDirectory){
        ImageIcon image = new ImageIcon(imageDirectory);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        System.out.println("Entré aquí");
        //this.repaint();
    }
     
}
