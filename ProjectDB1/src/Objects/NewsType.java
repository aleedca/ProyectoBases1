/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Alexia
 */
public class NewsType {
    private int idNewsType;
    private String descriptionNewsType;

    public int getIdNewsType() {
        return idNewsType;
    }

    public void setIdNewsType(int idNewsType) {
        this.idNewsType = idNewsType;
    }

    public String getDescriptionNewsType() {
        return descriptionNewsType;
    }

    public void setDescriptionNewsType(String descriptionNewsType) {
        this.descriptionNewsType = descriptionNewsType;
    }

    @Override
    public String toString() {
        return "NewsType{" + "idNewsType=" + idNewsType + ", descriptionNewsType=" + descriptionNewsType + '}';
    }
    
    
}
