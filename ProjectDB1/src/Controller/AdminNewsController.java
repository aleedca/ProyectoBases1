/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import DataAccess.DA_News;
import Model.model_News;
import Objects.News;
import View.JF_AdminNews;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mariana
 */

public final class AdminNewsController {
    
    private final JF_AdminNews viewAdminNews;
    private final model_News modelNews;
    
    //Constructor 2da version
    public AdminNewsController() { 
        //View AdminNews
        JF_AdminNews adminNews = new JF_AdminNews();
        this.viewAdminNews = adminNews;  
        
        //Model News
        model_News validateNews = new model_News();
        this.modelNews = validateNews;

        fillAdminNews(); 
        fillStatus();
        fillNewsType();

    }


    public JF_AdminNews getViewAdminNews() {
        return viewAdminNews;
    }
    
    public void fillStatus(){
        modelNews.loadNewsStatusArr();
        viewAdminNews.getCmbEstado().removeAllItems();
        
        viewAdminNews.getCmbEstado().addItem("Seleccione Estado");
        for(int i=0; i<modelNews.getNewsStatusArr().size();i++){
           viewAdminNews.getCmbEstado().addItem(modelNews.getNewsStatusArr().get(i).getDescriptionNewsStatus());
        }
    }
    
    public void fillNewsType(){
        modelNews.loadNewsTypeArr();
        viewAdminNews.getCmbTipo().removeAllItems();

        viewAdminNews.getCmbTipo().addItem("Seleccione Tipo");        
        for(int i=0; i<modelNews.getNewsTypeArr().size();i++){
           viewAdminNews.getCmbTipo().addItem(modelNews.getNewsTypeArr().get(i).getDescriptionNewsType());
        }
    
    }
    
    public void fillAdminNews(){
        try{
            modelNews.loadNewsArr();

            ArrayList<News> newsArr = modelNews.getNewsArr();

            
            DefaultTableModel modelTable = (DefaultTableModel) viewAdminNews.getTblNoticias().getModel();
            modelTable.setRowCount(0);


            for(int i = 0; i < newsArr.size(); i++){
                Vector row = new Vector();
                row.add(newsArr.get(i).getIdNews());
                row.add(newsArr.get(i).getTitle());
                row.add(newsArr.get(i).getNewsStatus());
                row.add(newsArr.get(i).getPublicationDate());
                row.add(newsArr.get(i).getNewsType());
                row.add(newsArr.get(i).getViews());
                modelTable.addRow(row);
            }
        }catch(Exception ex){
            System.out.println("error "+ex);
        }
    }
    
    public void fillUpdateAdminNews(int index){
        ArrayList<News> newsArr;
        
        try {
            newsArr = DA_News.getInfoNews(index);
            
            viewAdminNews.getCmbEstado().setSelectedIndex(newsArr.get(0).getIdNewsStatus());
            viewAdminNews.getCmbTipo().setSelectedIndex(newsArr.get(0).getIdNewsType());
            viewAdminNews.getTxtTitulo().setText(newsArr.get(0).getTitle());
            viewAdminNews.getTxtTexto().setText(newsArr.get(0).getText());
            modelNews.setPhoto(newsArr.get(0).getPhoto());
            viewAdminNews.setImageLabel(modelNews.getPhoto());
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void showView(){ 
        viewAdminNews.setVisible(true);
    }

}
