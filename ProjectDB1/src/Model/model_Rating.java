/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_News;
import Objects.News;
import View.JF_Rating;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Isaac
 */
public class model_Rating {
    private String username;
    private int rate = 0;
    private News news;
    private DA_News dataAccessNews = new DA_News();

    public model_Rating() {
    }

    public model_Rating(int rate, News news) {
        this.rate = rate;
        this.news = news;
    }

    public int getRate() {
        return rate;
    }
    
    public boolean submitRate(){
        try{
            if(this.rate > 0){
                this.dataAccessNews.rateANews(this.username, this.news.getIdNews(), this.rate);
                return true;
            }            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return false;
    }

    public void setRate(String username, JF_Rating ratingView, int rate) {
        this.username = username;
        this.rate = rate;
        selectARating(ratingView);
    }
    
    public void selectARating(JF_Rating ratingView){
        ratingView.setRatingIcons(this.rate);
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
