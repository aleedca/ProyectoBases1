
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
    public boolean validarCamposVacios(String primerNombre, String primerApellido, String identificacion, 
            String username, String password, String correo, String telefono, String direccion, String foto){
        
        if(primerNombre.isEmpty() || primerApellido.isEmpty() || identificacion.isEmpty() || direccion.isEmpty()){
            return true;
        }else{
            if(username.isEmpty() || password.isEmpty() ||correo.isEmpty() || telefono.isEmpty()){
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
    
    public boolean validarFormatPassword(String password){
        if (PASSWORD_PATTERN.matcher( password).matches()) {
            System.out.println("Contrasenna valida");
            return true;
	}
        
        return false;
    }
    
    
    public boolean validarFormatUsername(String username){
        String regex = "^[A-Za-z0-9_]{5,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(username);
        
        if (mather.matches()) {
            System.out.println("Username valido");
            return true;
        } 
        
        return false;
    }
    
    public boolean validarFormatCorreo(String correo){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        
        if (mather.find() == true) {
            System.out.println("Correo valido");
            return true;
        } 
         
        return false;
    }
    
    
    public boolean validarSegundoNombre(String segundoNombre){
        if(segundoNombre.isEmpty()){
             return false;
        }
        return true;
    }
    
    public boolean validarSegundoApellido(String segundoApellido){
        if(segundoApellido.isEmpty()){
             return false;
        }
        
        return true;
    }
    
    
    
    public boolean validarFormatoCadena(String cadena){
        String regex = "^[A-Za-z\\ÑñáéíóúÁÉÍÓÚ]{3,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(cadena);
        
        if (mather.matches()) {
            System.out.println("Cadena valida");
            return true;
        } 
        
        return false;
    }
    
    public boolean validarFormatoDireccion(String direccion){
        String regex = "^[A-Za-z\\s\\d\\#,.ÑñáéíóúÁÉÍÓÚ]{50,200}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(direccion);
        
        if (mather.matches()) {
            System.out.println("Direccion valida");
            return true;
        } 
        
        return false;
    }
    
    public boolean validarFoto(String foto){
        if(foto == null){
            return true;
        }
        
       return false;
    }
   
        
    public void setImageLabel(JLabel labelName){
        ImageIcon image = new ImageIcon(this.foto);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        //System.out.println("Entré aquí");
        //this.repaint();
    }
    
    
    //GETTERS AND SETTERS
    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public String getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(String tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
     
}
