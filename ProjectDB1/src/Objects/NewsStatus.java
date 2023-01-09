/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Alexia
 */
public class NewsStatus {
    private int idNewsStatus;
    private String descriptionNewsStatus;

    public int getIdNewsStatus() {
        return idNewsStatus;
    }

    public void setIdNewsStatus(int idNewsStatus) {
        this.idNewsStatus = idNewsStatus;
    }

    public String getDescriptionNewsStatus() {
        return descriptionNewsStatus;
    }

    public void setDescriptionNewsStatus(String descriptionNewsStatus) {
        this.descriptionNewsStatus = descriptionNewsStatus;
    }

    @Override
    public String toString() {
        return "NewsStatus{" + "idNewsStatus=" + idNewsStatus + ", descriptionNewsStatus=" + descriptionNewsStatus + '}';
    }
    
}
