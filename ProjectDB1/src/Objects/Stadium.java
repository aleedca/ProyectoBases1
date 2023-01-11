/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.time.LocalDateTime;

/**
 *
 * @author Nahomy
 */
public class Stadium {
    
    private int idStadium;
    private int idCountry;
    private String nameStadium;
            
    private String userCreation;
    private LocalDateTime dateCreation;
    private String lastUser;
    private LocalDateTime lastDate;
    
    
     //GETTERS AND SETTERS

    public int getIdStadium() {
        return idStadium;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public String getNameStadium() {
        return nameStadium;
    }

    public void setIdStadium(int idStadium) {
        this.idStadium = idStadium;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public void setNameStadium(String nameStadium) {
        this.nameStadium = nameStadium;
    }
    
    //TO STRING

    @Override
    public String toString() {
        return "Stadium{" + "idStadium=" + idStadium + ", idCountry=" + idCountry + ", nameStadium=" + nameStadium + ", userCreation=" + userCreation + ", dateCreation=" + dateCreation + ", lastUser=" + lastUser + ", lastDate=" + lastDate + '}';
    }
    
    
  
    
}
