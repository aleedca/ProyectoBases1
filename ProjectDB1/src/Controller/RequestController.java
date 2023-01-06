/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAccess.DA_GroupList;
import DataAccess.DA_NewsList;
import DataAccess.DA_TeamList;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nahomy
 */
public class RequestController {
    private final DA_TeamList admT = new DA_TeamList();
    private final DA_GroupList admG = new DA_GroupList();
    private final DA_NewsList admN = new DA_NewsList();
    private final Cargador cargador = new Cargador();
    
    
    
    public DefaultTableModel showTeamList(String teamName, String playerFstName, String playerSndName, String playerFstLastName, String playerSndLastName, String position) throws SQLException{
        System.out.println("Llamando cargador...");
        return cargador.showTeamList(admT.getTeamList(teamName,playerFstName,playerSndName,playerFstLastName,playerSndLastName,position));
   
    }
    
    public DefaultTableModel showGroupList(String teamName, String matchDate, String stadium, String teamFlag)throws SQLException{
        return cargador.showGroupList(admG.getGroupList(teamName,matchDate,stadium,teamFlag));
    }
    
     public DefaultTableModel showNewsList(String author, String authorLastname, String newsDate, String newsEvent)throws SQLException{
        return cargador.showNewsList(admN.getNewsList(author, authorLastname,  newsDate, newsEvent));
    }
}
