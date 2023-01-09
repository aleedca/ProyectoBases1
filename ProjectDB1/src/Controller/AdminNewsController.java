/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.model_News;
import Objects.News;
import Objects.NewsStatus;
import Objects.NewsType;
import View.JF_AdminNews;
import View.JF_AdminPerson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mariana
 */

public class AdminNewsController{
    //private final 
    /*private final JF_AdminPerson viewAdminPerson;
    private final model_Register modelRegister;*/
    
    private final JF_AdminNews viewAdminNews;
    private final model_News modelNews;
    
    private boolean flagRegister;
        
    
    //Constructor 2da version
    public AdminNewsController() { 
        /*View AdminPerson
        JF_AdminPerson adminPerson = new JF_AdminPerson();
        this.viewAdminPerson = adminPerson;  

        //Model Register
        model_Register validateRegister = new model_Register();
        this.modelRegister = validateRegister;*/
        
        //View AdminNews
        JF_AdminNews adminNews = new JF_AdminNews();
        this.viewAdminNews = adminNews;  
        
        //Model News
        model_News validateNews = new model_News();
        this.modelNews = validateNews;
        
        fillAdminNews(); 
        fillAdminNewsStatus();
        fillAdminNewsType();

    }

    public JF_AdminNews getViewAdminNews() {
        return viewAdminNews;
    }
    
    public void fillAdminNews(){
        viewAdminNews.getTblNoticias().removeAll();
        ArrayList<News> newsArr = modelNews.getNewsArr();
        DefaultTableModel modelTable = (DefaultTableModel) viewAdminNews.getTblNoticias().getModel();
        
        for(int i = 0; i < newsArr.size(); i++){
            Vector row = new Vector();
            row.add(newsArr.get(i).getNewsStatus());
            row.add(newsArr.get(i).getTitle());
            row.add(newsArr.get(i).getViews());
            row.add(newsArr.get(i).getPublicationDate());
            row.add(newsArr.get(i).getNewsType());
            row.add(newsArr.get(i).getRateNumber());
            modelTable.addRow(row);
        }
    }
    
    public void fillAdminNewsStatus(){
        viewAdminNews.getCmbEstado().removeAllItems();
        ArrayList<NewsStatus> newsStatusArr = modelNews.getNewsStatusArr();
        
        for(int i = 0; i < newsStatusArr.size(); i++){
            viewAdminNews.getCmbEstado().addItem(newsStatusArr.get(i).getDescriptionNewsStatus());
        }
    }
    
    public void fillAdminNewsType(){
        viewAdminNews.getCmbTipo().removeAllItems();
        ArrayList<NewsType> newsTypeArr = modelNews.getNewsTypeArr();
        
        for(int i = 0; i < newsTypeArr.size(); i++){
            viewAdminNews.getCmbEstado().addItem(newsTypeArr.get(i).getDescriptionNewsType());
        }
    }
    
    public void showView(){ 
        viewAdminNews.setVisible(true);
    }
}
