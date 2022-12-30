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
    ArrayList<NewsComment> comments;
    
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
    
}
