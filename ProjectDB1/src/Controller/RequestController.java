/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAccess.DA_TeamList;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nahomy
 */
public class RequestController {
    private final DA_TeamList admT = new DA_TeamList();
    private final Cargador cargador = new Cargador();
    
    
    
    public DefaultTableModel showTeamList(String teamName, String playerFstName, String playerSndName, String playerFstLastName, String playerSndLastName, String position) throws SQLException{
        
        return cargador.showTeamList(admT.getTeamList(teamName,playerFstName,playerSndName,playerFstLastName,playerSndLastName,position));
   
    }
}
