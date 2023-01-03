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
public class NewsClass {
    private String TitleStr;
    private String AuthorStr;
    private String photoDirectory;
    private String newsBody;
    private float rateNumber;
    private ArrayList<NewsComment> comments;
    
    public NewsClass(){
        
    }
    
    public NewsClass(String pTitle, String pAuthor, String pPhoto, String pBody, float pRating, ArrayList<NewsComment> pComments){
        this.TitleStr = pTitle;
        this.AuthorStr = pAuthor;
        this.photoDirectory = pPhoto;
        this.newsBody = pBody;
        this.rateNumber = pRating;
        this.comments = pComments;
    }

    public String getTitleStr() {
        return TitleStr;
    }

    public void setTitleStr(String TitleStr) {
        this.TitleStr = TitleStr;
    }

    public String getAuthorStr() {
        return AuthorStr;
    }

    public void setAuthorStr(String AuthorStr) {
        this.AuthorStr = AuthorStr;
    }

    public String getPhotoDirectory() {
        return photoDirectory;
    }

    public void setPhotoDirectory(String photoDirectory) {
        this.photoDirectory = photoDirectory;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
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
