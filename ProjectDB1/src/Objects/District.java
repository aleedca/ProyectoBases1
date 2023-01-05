/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Mariana
 */
public class District {
    private int idCanton;
    private int idDistrict;
    private String nameDistrict;
    
    //GETTERS AND SETTERS

    public int getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(int idCanton) {
        this.idCanton = idCanton;
    }

    public int getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
    }

    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    @Override
    public String toString() {
        return "District{" + "idCanton=" + idCanton + ", idDistrict=" + idDistrict + ", nameDistrict=" + nameDistrict + '}';
    }
    
}
