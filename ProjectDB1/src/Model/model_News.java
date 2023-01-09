/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import DataAccess.DA_News;
<<<<<<< HEAD
import Objects.News;
=======
>>>>>>> 3a5143b3f9073c6da1340e25304080c5a997b539
import Objects.NewsStatus;
import Objects.NewsType;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alexia
 */
public class model_News {
    //atributos que aparecen el design de AdminNews
<<<<<<< HEAD
    private String newsTitle = getNewsTitle();
    private String newsText = getNewsText();
    private String photo = getPhoto();
=======
    private String newsTitle;
    private String newsText;
    private String photo;
>>>>>>> 3a5143b3f9073c6da1340e25304080c5a997b539
    
    private ArrayList<News> newsArr;
<<<<<<< HEAD
    private ArrayList<NewsStatus> newsStatusArr;
=======
    
    private String newsType;
    private ArrayList<NewsStatus> newsStatusArr;
    
    private String newsStatus;
>>>>>>> 3a5143b3f9073c6da1340e25304080c5a997b539
    private ArrayList<NewsType> newsTypeArr;

    public model_News(){
        try {
            this.newsArr = DA_News.getNews();
            
            this.newsStatusArr = DA_News.getNewsStatus();
            
            this.newsTypeArr = DA_News.getNewsType();
<<<<<<< HEAD
=======
                      
>>>>>>> 3a5143b3f9073c6da1340e25304080c5a997b539
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public boolean validateEmptyFields(String title, String text){
        if(title.isEmpty() || text.isEmpty()){return false;}
        return true;
    }
    
    public boolean validatePhoto(String photo){
        if(photo == null){return false;}
        return true;
    }

    // GETTERS AND SETTERS

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ArrayList<News> getNewsArr() {
        return newsArr;
    }

    public void setNewsArr(ArrayList<News> newsArr) {
        this.newsArr = newsArr;
    }

    public ArrayList<NewsStatus> getNewsStatusArr() {
        return newsStatusArr;
    }

    public void setNewsStatusArr(ArrayList<NewsStatus> newsStatusArr) {
        this.newsStatusArr = newsStatusArr;
    }

    public ArrayList<NewsType> getNewsTypeArr() {
        return newsTypeArr;
    }

    public void setNewsTypeArr(ArrayList<NewsType> newsTypeArr) {
        this.newsTypeArr = newsTypeArr;
    }
<<<<<<< HEAD

=======
    
    


    
    
    
>>>>>>> 3a5143b3f9073c6da1340e25304080c5a997b539
}