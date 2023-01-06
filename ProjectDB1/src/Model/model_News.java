/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Objects.News;
import DataAccess.DA_News;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alexia
 */
public class model_News {
    //atributos que aparecen el design de AdminNews
    private String newsStatus;
    private String newsType;
    private String newsTitle;
    private String newsText;
    private String photo;
    
    private String newsStr;
    private ArrayList<News> newsArr;

    public model_News(){
        try {
            this.newsArr = DA_News.getNews();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public boolean validateEmptyFields(String title, String text){
        if(title.isEmpty() || text.isEmpty()){return true;}
        return false;
    }
    
    public boolean validatePhoto(String photo){
        if(photo == null){return true;}
        return false;
    }

    // GETTERS AND SETTERS
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

    public String getNewsStr() {
        return newsStr;
    }

    public void setNewsStr(String newsStr) {
        this.newsStr = newsStr;
    }

    public ArrayList<News> getNewsArr() {
        return newsArr;
    }

    public void setNewsArr(ArrayList<News> newsArr) {
        this.newsArr = newsArr;
    }
    
    
}