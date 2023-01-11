/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Mariana
 */
public class Country {
    private int idCountry;
    private String nameCountry;
    
    //GETTERS AND SETTERS
    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }
    
    //TO STRING

    @Override
    public String toString() {
        return "Country{" + "idCountry=" + idCountry + ", nameCountry=" + nameCountry + '}';
    }
    
    
}
