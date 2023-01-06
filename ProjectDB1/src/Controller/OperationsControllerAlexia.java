/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.model_Register;
import Model.model_News;
import Objects.News;
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

public class OperationsControllerAlexia implements ActionListener{
    //private final 
    /*private final JF_AdminPerson viewAdminPerson;
    private final model_Register modelRegister;*/
    
    private final JF_AdminNews viewAdminNews;
    private final model_News modelNews;
    
    private boolean flagRegister;
        
    
    //Constructor 2da version
    public OperationsControllerAlexia() { 
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
        
        _init_();
        fillAdminNews(); 

    }
    
    //Init de ActionListener
    private void _init_(){
        //viewAdminNews.getTblNoticias().addActionListener(this);
        viewAdminNews.getRbtnAgregar().addActionListener(this);
        viewAdminNews.getRbtnEditar().addActionListener(this);
        viewAdminNews.getRbtnEliminar().addActionListener(this);
        
        viewAdminNews.getCmbEstado().addActionListener(this);
        viewAdminNews.getCmbTipo().addActionListener(this);
        viewAdminNews.getTxtTitulo().addActionListener(this);
        //viewAdminNews.getTxtTexto().addActionListener(this);
        //viewAdminNews.getLblImagen().addActionListener(this);
        
        viewAdminNews.getBtnAceptar().addActionListener(this);
    }
    
    public void fillAdminNews(){
        viewAdminNews.getTblNoticias().removeAll();
        ArrayList<News> newsArr = new ArrayList<>();
        DefaultTableModel modelTable = (DefaultTableModel) viewAdminNews.getTblNoticias().getModel();
        
        for(int i = 0; i < newsArr.size(); i++){
            Vector row = new Vector();
            row.add(newsArr.get(i).getIdNews());
            row.add(newsArr.get(i).getTitle());
            row.add(newsArr.get(i).getViews());
            row.add(newsArr.get(i).getPublicationDate());
            modelTable.addRow(row);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewAdminNews.getBtnBack()){
            System.out.println("juju");
        }
    }
    
    public void showView(){ 
        viewAdminNews.setVisible(true);
    }
}
