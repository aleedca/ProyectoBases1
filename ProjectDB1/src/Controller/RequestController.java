/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAccess.DA_GroupList;
import DataAccess.DA_NewsList;
import DataAccess.DA_TeamList;
import Model.model_Request;
import View.JF_Request;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class RequestController {
    
    private final DA_TeamList admT = new DA_TeamList();
    private final DA_GroupList admG = new DA_GroupList();
    private final DA_NewsList admN = new DA_NewsList();
    private final Cargador cargador = new Cargador();
    
    //private final JF_Request viewRequest = new JF_Request();
    
    private final model_Request modelRequest = new model_Request();



    
    public DefaultTableModel showTeamList(String teamName, String playerFstName, String playerSndName, String playerFstLastName, String playerSndLastName, String position) throws SQLException{
        return cargador.showTeamList(admT.getTeamList(teamName,playerFstName,playerSndName,playerFstLastName,playerSndLastName,position));
    }
    
    public DefaultTableModel showGroupList(String teamName, String matchDate, String stadium, String teamFlag)throws SQLException{
        return cargador.showGroupList(admG.getGroupList(teamName,matchDate,stadium,teamFlag));
    }
    
     public DefaultTableModel showNewsList(String author, String authorLastname, String newsDate, String newsEvent)throws SQLException{
        return cargador.showNewsList(admN.getNewsList(author, authorLastname,  newsDate, newsEvent));
    }
     
    //-------- COMBO BOX FILLING --------------------------
    public void fillPositions(JF_Request viewRequest){
        viewRequest.getCmbPosition().removeAllItems();
        
        viewRequest.getCmbPosition().addItem("Seleccione Posición");
        for(int i=0; i<modelRequest.getPositions().size();i++){
           viewRequest.getCmbPosition().addItem(modelRequest.getPositions().get(i).getDescriptionPersonPosition());
        }
    }
    
     public void fillEvents(JF_Request viewRequest){
        viewRequest.getCmbEvent().removeAllItems();
        
        viewRequest.getCmbEvent().addItem("Seleccione Evento");
         for(int i=0; i<modelRequest.getEvents().size();i++){
           viewRequest.getCmbEvent().addItem(modelRequest.getEvents().get(i).getTypeEvent());
        }
    }
     
     public void fillCountryTeams(JF_Request viewRequest){
        viewRequest.getCbmTeamFlag().removeAllItems();
        
        viewRequest.getCbmTeamFlag().addItem("Seleccione la bandera");
         for(int i=0; i<modelRequest.getCountryTeams().size();i++){
           viewRequest.getCbmTeamFlag().addItem(modelRequest.getCountryTeams().get(i).getNameCountryTeam());
           System.out.println(modelRequest.getCountryTeams().get(i).getNameCountryTeam());
           //aquí debería ir algo que me ayude a relacionar el get Flag con la imagen de parametros y la muestre 
        }
    }
}
