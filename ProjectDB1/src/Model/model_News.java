/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Objects.News;
import DataAccess.DA_News;
import Objects.NewsStatus;
import Objects.NewsType;
import View.JF_AdminNews;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Alexia
 */
public class model_News {
    //atributos que aparecen el design de AdminNews
    private String newsTitle;
    private String newsText;
    private String photo;
    private Date publicationDate;
    
    private int resultUpdateStatus= 0;
    private int resultUpdateType = 0;
    private int resultUpdateTitle = 0;
    private int resultUpdateText= 0;
    private int resultUpdatePhoto = 0;
    
    private String newsStr;
    private int idNews;
    private ArrayList<News> newsArr;
    
    private String newsType;
    private int idNewsType;
    private ArrayList<NewsStatus> newsStatusArr;
    
    private String newsStatus;
    private int idNewsStatus;
    private ArrayList<NewsType> newsTypeArr;
    
    private final JFileChooser file = new JFileChooser();
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");

    
    public void loadNewsArr(){
        try {
            this.newsArr = DA_News.getNews();
            this.newsStatusArr = DA_News.getNewsStatus();
            this.newsTypeArr = DA_News.getNewsType();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }
    
    public boolean validateEmptyFields(){
        if(this.newsTitle.isEmpty() || this.newsText.isEmpty()){return false;}
        return true;
    }
    
    public boolean validatePhoto(){
        if(this.photo == null){return false;}
        return true;
    }
    
    public void insertNews(){
        try {   
            DA_News.insertNews(this.idNewsStatus, this.idNewsType, this.newsTitle, this.publicationDate, "Unlink", "FotoNoticia", this.newsText);
        
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void updateNews(){
        try {
            this.resultUpdateStatus = DA_News.updateStatus(this.idNews, this.idNewsStatus);
            this.resultUpdateType = DA_News.updateType(this.idNews, this.idNewsType);
            this.resultUpdateStatus = DA_News.updateTitle(this.idNews, this.newsTitle);
            this.resultUpdateStatus = DA_News.updateText(this.idNews, this.newsText);
            this.resultUpdateStatus = DA_News.updatePhoto(this.idNews, this.photo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public boolean selectPhoto(JF_AdminNews adminNews){
        file.setFileFilter(this.filter);
        file.showOpenDialog(adminNews);
        try{
            photo = file.getSelectedFile().getPath();
            return true;
        }catch(NullPointerException e){
            System.out.println("No se ha seleccionado ningún fichero");
        } 
        
        return false;
    }
    
    
    public void setImageLabel(JLabel labelName){
        ImageIcon image = new ImageIcon(this.photo);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
    }
    
    // GETTERS AND SETTERS

    public int getResultUpdateStatus() {
        return resultUpdateStatus;
    }

    public void setResultUpdateStatus(int resultUpdateStatus) {
        this.resultUpdateStatus = resultUpdateStatus;
    }

    public int getResultUpdateType() {
        return resultUpdateType;
    }

    public void setResultUpdateType(int resultUpdateType) {
        this.resultUpdateType = resultUpdateType;
    }

    public int getResultUpdateTitle() {
        return resultUpdateTitle;
    }

    public void setResultUpdateTitle(int resultUpdateTitle) {
        this.resultUpdateTitle = resultUpdateTitle;
    }

    public int getResultUpdateText() {
        return resultUpdateText;
    }

    public void setResultUpdateText(int resultUpdateText) {
        this.resultUpdateText = resultUpdateText;
    }

    public int getResultUpdatePhoto() {
        return resultUpdatePhoto;
    }

    public void setResultUpdatePhoto(int resultUpdatePhoto) {
        this.resultUpdatePhoto = resultUpdatePhoto;
    }
    
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
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

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public int getIdNewsType() {
        return idNewsType;
    }

    public void setIdNewsType(int idNewsType) {
        this.idNewsType = idNewsType;
    }

    public int getIdNewsStatus() {
        return idNewsStatus;
    }

    public void setIdNewsStatus(int idNewsStatus) {
        this.idNewsStatus = idNewsStatus;
    }

}