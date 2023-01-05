/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.util.ArrayList;


/**
 *
 * @author Isaac
 */
public class News {
    private int idNews;
    private int idNewsStatus;
    private int idNewsType;
    
    private String title;
    private String author;
    private String publicationDate;
    private String link;
    private String photo;
    private String text;
    
    private int views;
    private float rateNumber;
    private ArrayList<NewsComment> comments;

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }
    
    public int getIdNewsStatus() {
        return idNewsStatus;
    }

    public void setIdNewsStatus(int idNewsStatus) {
        this.idNewsStatus = idNewsStatus;
    }
    
    public int getIdNewsType() {
        return idNews;
    }

    public void setIdNewsType(int idNewsType) {
        this.idNewsType = idNewsType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getPublicationDate() {
        return author;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public float getRateNumber() {
        return rateNumber;
    }

    public void setRateNumber(float rateNumber) {
        this.rateNumber = rateNumber;
    }

    public ArrayList<NewsComment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<NewsComment> comments) {
        this.comments = comments;
    }
    
}
