/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Mariana
 */
public class Canton {
    private int idProvince;
    private int idCanton;
    private String nameCanton;
    
    //GETTERS AND SETTERS
    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public int getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(int idCanton) {
        this.idCanton = idCanton;
    }

    public String getNameCanton() {
        return nameCanton;
    }

    public void setNameCanton(String nameCanton) {
        this.nameCanton = nameCanton;
    }

    @Override
    public String toString() {
        return "Canton{" + "idProvince=" + idProvince + ", idCanton=" + idCanton + ", nameCanton=" + nameCanton + '}';
    }
    
    
    
    
}
