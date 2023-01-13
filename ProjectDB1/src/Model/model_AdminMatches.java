/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Catalogs;
import Objects.Stadium;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahomy
 */
public class model_AdminMatches {
    
    private int stadium;
    private ArrayList<Stadium> stadiums;
    
    
    
    //BUILDER 

    public model_AdminMatches() {
        
        try {
            this.stadiums = DA_Catalogs.getStadium();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(model_AdminMatches.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //--------------GETTERS AND SETTERS--------------

    public int getStadium() {
        return stadium;
    }

    public ArrayList<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadium(int stadium) {
        this.stadium = stadium;
    }

    public void setStadiums(ArrayList<Stadium> stadiums) {
        this.stadiums = stadiums;
    }
    
    
}
