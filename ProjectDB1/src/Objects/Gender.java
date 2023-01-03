/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Mariana
 */
public class Gender {
    private int idGender;
    private String descriptionGender;
    
    
    
    //GETTERS AND SETTERS
    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public String getDescriptionGender() {
        return descriptionGender;
    }

    public void setDescriptionGender(String descriptionGender) {
        this.descriptionGender = descriptionGender;
    }

    @Override
    public String toString() {
        return "Gender{" + "idGender=" + idGender + ", descriptionGender=" + descriptionGender + '}';
    }
     
    
    
}
