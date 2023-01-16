/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Objects.GroupList;
import Objects.MostViewedNews;
import Objects.News;
import Objects.NewsList;
import Objects.TeamList;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class Cargador {
    
    public static void main (String [] args){
    }
    
    DefaultTableModel showTeamList(ArrayList<TeamList> teamList ){
        
        Object [] header = {"Primer nombre", "Segundo nombre", "Primer apellido", "Segundo apellido", "Foto", "Posicion"};
        
        DefaultTableModel dtm = new DefaultTableModel(header,teamList.size());
        
        for (int i = 0; i<dtm.getRowCount(); i++){
            TeamList teamlist = teamList.get(i);
            
            dtm.setValueAt(teamlist.getFirstName(), i, 0);
            dtm.setValueAt(teamlist.getSecondName(), i, 1);
            dtm.setValueAt(teamlist.getFirstLastname(), i, 2);
            dtm.setValueAt(teamlist.getSecondLastname(), i, 3);
            dtm.setValueAt(teamlist.getPhoto(), i, 4);
            dtm.setValueAt(teamlist.getPosition(), i, 5);
        }
        return dtm;
    }
    
    DefaultTableModel showGroupList(ArrayList<GroupList> groupList ){
        
        Object [] header = {"Equipo", "Fecha del partido", "Estadio", "Bandera"};
        
        DefaultTableModel dtm = new DefaultTableModel(header,groupList.size());
        
        for (int i = 0; i<dtm.getRowCount(); i++){
            GroupList group = groupList.get(i);
            
            dtm.setValueAt(group.getTeamName(), i, 0);
            dtm.setValueAt(group.getMatchDate(), i, 1);
            dtm.setValueAt(group.getStadium(), i, 2);
            dtm.setValueAt(group.getTeamFlag(), i, 3);
        }
        return dtm;
    }
    
    
    DefaultTableModel showNewsList(ArrayList<NewsList> newsList ){
        
        Object [] header = {"Autor", "Apellido", "Titulo", "Fecha de publicación", "Tipo de artículo"};
        
        DefaultTableModel dtm = new DefaultTableModel(header,newsList.size());
        
        for (int i = 0; i<dtm.getRowCount(); i++){
            NewsList news = newsList.get(i);
            
            dtm.setValueAt(news.getAuthor(), i, 0);
            dtm.setValueAt(news.getAuthorLastName(), i, 1);
            dtm.setValueAt(news.getTitle(), i, 2);
            dtm.setValueAt(news.getNewsDate(), i, 3);
            dtm.setValueAt(news.getTypeNews(), i, 4);
        }
        return dtm;
    }
    
    
    DefaultTableModel showMostViewedNews(ArrayList<MostViewedNews> mostViewedNews ){
        
        Object [] header = {"Noticia", "Visualizaciones"};
        
        DefaultTableModel dtm = new DefaultTableModel(header,mostViewedNews.size());
        
        for (int i = 0; i<dtm.getRowCount(); i++){
            MostViewedNews news = mostViewedNews.get(i);
            
            dtm.setValueAt(news.getTitle(), i, 0);
            dtm.setValueAt(news.getViews(), i, 1);
        }
        return dtm;
    }
    
    DefaultTableModel showLastNews(ArrayList<News> lastNews ){
        
        Object [] header = {"Noticia", "Publicación"};
        
        DefaultTableModel dtm = new DefaultTableModel(header,lastNews.size());
        
        for (int i = 0; i<dtm.getRowCount(); i++){
            News news = lastNews.get(i);
            
            dtm.setValueAt(news.getTitle(), i, 0);
            dtm.setValueAt(news.getPublicationDate(), i, 1);
        }
        return dtm;
    }
    
}
