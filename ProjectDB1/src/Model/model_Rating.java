/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.JF_Rating;

/**
 *
 * @author Isaac
 */
public class model_Rating {
    
    private int rate = 0;
    private int idNews;
    private String title;

    public model_Rating() {
    }

    public model_Rating(int rate, String title) {
        this.rate = rate;
        this.title = title;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(JF_Rating ratingView, int rate) {
        this.rate = rate;
        selectARating(ratingView);
    }
    
    public void selectARating(JF_Rating ratingView){
        ratingView.setRatingIcons(this.rate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }
    
    
}
