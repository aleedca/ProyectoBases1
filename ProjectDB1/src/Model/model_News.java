/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Objects.News;
import DataAccess.DA_News;
import Objects.NewsComment;
import Objects.NewsStatus;
import Objects.NewsType;
import View.JF_AdminNews;
import View.JF_News;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexia
 */
public class model_News {
    //atributos que aparecen el design de AdminNews
    private String newsTitle;
    private String newsText;
    private String photo = "";
    private String author;
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
    private News selectedNews;
    
    private ArrayList<NewsComment> comments;
    
    private final JFileChooser file = new JFileChooser();
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");

    public void setSelectedNews(JF_News viewNews, int selectedNewsIndex) {
        try {
            //System.out.println("***************************************");
            //System.out.println(selectedNewsIndex);
            this.selectedNews = DA_News.getNewsSpecific(selectedNewsIndex);
            viewNews.UpdateInfo(this.selectedNews);
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }
    
    public void loadNewsArr(){
        try {
            this.newsArr = DA_News.getNews();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }
    
    public void loadNewsComment(JF_News newsView){
        try {
            this.comments = DA_News.getNewsComments(this.selectedNews.getIdNews());
            
            DefaultTableModel modelTable = (DefaultTableModel) newsView.getTblComments().getModel();
            modelTable.setRowCount(0);
            
            for(int i = 0; i < comments.size(); i++){
                Vector row = new Vector();
                
                row.add(comments.get(i).getUsername());
                row.add(comments.get(i).getCommentBody());
                modelTable.addRow(row);
            }
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }
    
    public boolean insertCommentNews(String username, String commentBody){
        try {
            DA_News.commentNews(this.selectedNews.getIdNews(), username, commentBody);
            return true;
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        return false;
    }
    
    public void loadNewsStatusArr(){
        try {
            this.newsStatusArr = DA_News.getNewsStatus();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }
    
    public void loadNewsTypeArr(){
        try {
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
        if("".equals(this.photo)){return false;}
        return true;
    }
    
    public void insertNews(){
        try {   
            this.idNews = DA_News.insertNews(this.idNewsStatus, this.idNewsType, this.newsTitle, this.publicationDate, "Unlink", this.photo, this.newsText);
            DA_News.insertUserXNews(this.idNews, this.author);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void updateNews(){
        try {
            this.resultUpdateStatus = DA_News.updateStatus(this.idNews, this.idNewsStatus);
            this.resultUpdateType = DA_News.updateType(this.idNews, this.idNewsType);
            this.resultUpdateTitle = DA_News.updateTitle(this.idNews, this.newsTitle);
            this.resultUpdateText = DA_News.updateText(this.idNews, this.newsText);
            this.resultUpdatePhoto = DA_News.updatePhoto(this.idNews, this.photo);
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
            System.out.println("No se ha seleccionado ning??n fichero");
        } 
        
        return false;
    }
    
    
    public void setImageLabel(JLabel labelName){
        ImageIcon image = new ImageIcon(this.photo);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
    }
    
    // GETTERS AND SETTERS
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

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