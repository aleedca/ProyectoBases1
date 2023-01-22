/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Catalogs;
import DataAccess.DA_Stats;
import Objects.AuthorReview;
import Objects.Event;
import Objects.Gender;
import Objects.PlayerStats;
import Objects.Team;
import View.JF_GeneralStats;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Isaac
 */
public class model_Stats {
    
    private int topNGoalScorers;
    private int topNGoalKeepers;
    private int totalMatches;
    private int matchesPlayed;
    private int totalGoalsScored;
    private int totalSaves;
    private int totalRedCards;
    private int totalYellowCards;

    public model_Stats() {
    }

    public void fillGenderStats(JF_GeneralStats viewStats){
        try{
            ArrayList<Gender> genders = DA_Catalogs.getGender();
            viewStats.getCmbGender().removeAllItems();
            viewStats.getCmbGender().addItem("--------------");
            
            for(int i = 0; i< genders.size(); i++){
                Gender gender = genders.get(i);
                viewStats.getCmbGender().addItem(gender.getDescriptionGender());
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
    }
    
    public void fillEventStats(JF_GeneralStats viewStats){
        try{
            ArrayList<Event> events = DA_Catalogs.getEvent();
            viewStats.getCmbNewsEvent().removeAllItems();
            viewStats.getCmbNewsEvent().addItem("--------------");
            
            for(int i = 0; i< events.size(); i++){
                Event event = events.get(i);
                viewStats.getCmbNewsEvent().addItem(event.getTypeEvent());
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
    }
    
    public void fillTeamStats(JF_GeneralStats viewStats){
        try{
            ArrayList<Team> teams = DA_Catalogs.getTeam();
            viewStats.getCmbTeam().removeAllItems();
            viewStats.getCmbTeam().addItem("--------------");
            
            for(int i = 0; i< teams.size(); i++){
                Team team = teams.get(i);
                viewStats.getCmbTeam().addItem(team.getNameTeam());
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void fillTblAgeRange(JF_GeneralStats viewStats){
        try{
            int idGender = viewStats.getCmbGender().getSelectedIndex();
            int idTeam = viewStats.getCmbTeam().getSelectedIndex();
            
            ArrayList quantities = DA_Stats.getAgeRangeTotals(idGender, idTeam);
            
            DefaultTableModel modelTable = (DefaultTableModel) viewStats.getTblAgeRange().getModel();
            modelTable.setRowCount(0);
            
            for(int i = 0; i < 6; i++){
                Vector row = new Vector();
                
                if(i == 0){
                    row.add("0-18");
                }else if(i == 1){
                    row.add("19-30");
                }else if(i == 2){
                    row.add("31-45");
                }else if(i == 3){
                    row.add("46-60");
                }else if(i == 4){
                    row.add("61-75");
                }else if(i == 5){
                    row.add("75 en adelante");
                }
                try{
                    row.add(quantities.get(i));
                }catch(Exception e){
                    row.add(0);
                }
                modelTable.addRow(row);
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void fillTblAverageReviews(JF_GeneralStats viewStats){
        try{
            ArrayList<AuthorReview> authorReviews = DA_Stats.getAverageRating();
            
            DefaultTableModel modelTable = (DefaultTableModel) viewStats.getTblAuthorReviews().getModel();
            modelTable.setRowCount(0);
            
            for(int i = 0; i < authorReviews.size(); i++){
                Vector row = new Vector();
                AuthorReview tmp = authorReviews.get(i);
                
                row.add(tmp.getUsername());
                row.add(tmp.getAverageRating());
                modelTable.addRow(row);
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void fillTopGoalers(JF_GeneralStats viewStats){
        try{
            ArrayList<PlayerStats> goalerStats = DA_Stats.getTopGoalScorers();
            
            DefaultTableModel modelTable = (DefaultTableModel) viewStats.getTableTopGoalScorers().getModel();
            modelTable.setRowCount(0);
            
            for(int i = 0; i < goalerStats.size(); i++){
                Vector row = new Vector();
                PlayerStats tmp = goalerStats.get(i);
                
                row.add(tmp.getName());
                row.add(tmp.getGoals());
                modelTable.addRow(row);
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void fillTopKeepers(JF_GeneralStats viewStats){
        try{
            ArrayList<PlayerStats> keeperStats = DA_Stats.getTopGoalKeepers();
            
            DefaultTableModel modelTable = (DefaultTableModel) viewStats.getTableTopGoalkeepers().getModel();
            modelTable.setRowCount(0);
            
            for(int i = 0; i < keeperStats.size(); i++){
                Vector row = new Vector();
                PlayerStats tmp = keeperStats.get(i);
                
                row.add(tmp.getName());
                row.add(tmp.getSaves());
                modelTable.addRow(row);
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void progressBar(JF_GeneralStats viewStats){
        try{
            ArrayList<Integer> matches = DA_Stats.getPlayedMatches();
            Integer value = matches.get(0);
            Integer maximum = matches.get(1); 
            
            viewStats.getProgressBarMatches().setMaximum(maximum);
            viewStats.getProgressBarMatches().setValue(value);
            
            String textForLabel = value.toString() + "/" + maximum.toString();
            
            viewStats.getLblQuantityMatches().setText(textForLabel);
            
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    
    public void getNewsPublished(JF_GeneralStats viewStats){
        try{
            Integer totalNews = DA_Stats.getTotalPublishedNews();
            
            
            viewStats.getLblNewsEvent().setText(totalNews.toString());
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
