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
    
    private String newsType;
    private String newsStatus;
    private String title;
    private String author;
    private String publicationDate;
    private String link;
    private String photo;
    private String text;
    
    private int views;
    private int rateNumber;
    private ArrayList<NewsComment> comments;

    public News() {
    }
   
    public News(int idNews, String newsType, String newsStatus, String title, String author, String publicationDate, String photo, String text) {
        this.idNews = idNews;
        this.newsType = newsType;
        this.newsStatus = newsStatus;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.photo = photo;
        this.text = text;
    }

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public int getIdNewsStatus() {
        return idNewsStatus;
    }

    public void setIdNewsStatus(int idStatus) {
        this.idNewsStatus = idStatus;
    }

    public int getIdNewsType() {
        return idNewsType;
    }

    public void setIdNewsType(int idNewsType) {
        this.idNewsType = idNewsType;
    }
    
    public String getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(String newsStatus) {
        this.newsStatus = newsStatus;
    }
    
    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
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
        return publicationDate;
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

    public int getRateNumber() {
        return rateNumber;
    }

    public void setRateNumber(int rateNumber) {
        this.rateNumber = rateNumber;
    }

    public ArrayList<NewsComment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<NewsComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "News{" + "idNews=" + idNews + ", newsStatus=" + newsStatus + ", idNewsType=" + newsType + ", title=" + title + ", author=" + author + ", publicationDate=" + publicationDate + ", link=" + link + ", photo=" + photo + ", text=" + text + ", views=" + views + ", rateNumber=" + rateNumber + ", comments=" + comments + '}';
    }
    
    
}
