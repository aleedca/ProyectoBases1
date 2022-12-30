/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
    
        
    private void setImageLabel(JLabel labelName, String imageDirectory){
        ImageIcon image = new ImageIcon(imageDirectory);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        System.out.println("Entré aquí");
        //this.repaint();
    }
    
    
    
}
