/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Mariana
 */
public class Province {
    private int idCountry;
    private int idProvince;
    private String nameProvince;
    
    //GETTERS AND SETTERS

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    @Override
    public String toString() {
        return "Province{" + "idCountry=" + idCountry + ", idProvince=" + idProvince + ", nameProvince=" + nameProvince + '}';
    }
    
    
    
    
}
