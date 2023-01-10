/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.model_AdminCatalogs;
import View.JF_AdminCatalogs;
import javax.swing.DefaultListModel;

/**
 *
 * @author Alexia
 */
public class AdminCatalogsController {
    private final JF_AdminCatalogs viewAdminCatalogs;
    private final model_AdminCatalogs modelAdminCatalogs;
    
    //Constructor
    public AdminCatalogsController() { 
        //View AdminNews
        JF_AdminCatalogs viewAdminCatalogs = new JF_AdminCatalogs();
        this.viewAdminCatalogs = viewAdminCatalogs;  
        
        //Model News
        model_AdminCatalogs validateNews = new model_AdminCatalogs();
        this.modelAdminCatalogs = validateNews;
        
        fillCatalogs();
    }

    public JF_AdminCatalogs getViewAdminCatalogs() {
        return viewAdminCatalogs;
    }
    
    public void fillCatalogs(){
        viewAdminCatalogs.getLstOpciones().removeAll();
        DefaultListModel listModel = (DefaultListModel) viewAdminCatalogs.getLstOpciones().getModel();
        
        if(viewAdminCatalogs.getCmbCatalogo()=="Género"){
            for(int i=0; i< modelAdminCatalogs.getGenders().size();i++){
                listModel.addElement(modelAdminCatalogs.getGenders().get(i).getDescriptionGender());
            }
        }
        else if(viewAdminCatalogs.getCmbCatalogo()=="Tipo de Identificación"){
            for(int i=0; i< modelAdminCatalogs.getIdentificationTypes().size();i++){
                listModel.addElement(modelAdminCatalogs.getIdentificationTypes().get(i).getNameTypeIdentification());
            }
        }
        else if(viewAdminCatalogs.getCmbCatalogo()=="Posición"){
            for(int i=0; i< modelAdminCatalogs.getPositions().size();i++){
                listModel.addElement(modelAdminCatalogs.getPositions().get(i).getDescriptionPersonPosition());
            }
        }
        else if(viewAdminCatalogs.getCmbCatalogo()=="País"){
            for(int i=0; i< modelAdminCatalogs.getPositions().size();i++){
                listModel.addElement(modelAdminCatalogs.getPositions().get(i).getDescriptionPersonPosition());
            }
        }
        else if(viewAdminCatalogs.getCmbCatalogo()=="Provincia"){
            for(int i=0; i< modelAdminCatalogs.getProvinces().size();i++){
                listModel.addElement(modelAdminCatalogs.getProvinces().get(i).getNameProvince());
            }
        }
        else if(viewAdminCatalogs.getCmbCatalogo()=="Cantón"){
            for(int i=0; i< modelAdminCatalogs.getCantons().size();i++){
                listModel.addElement(modelAdminCatalogs.getCantons().get(i).getNameCanton());
            }
        }
        else if(viewAdminCatalogs.getCmbCatalogo()=="Distrito"){
            for(int i=0; i< modelAdminCatalogs.getDistricts().size();i++){
                listModel.addElement(modelAdminCatalogs.getDistricts().get(i).getNameDistrict());
            }
        }
        else if(viewAdminCatalogs.getCmbCatalogo()=="Estado de Noticia"){
            for(int i=0; i< modelAdminCatalogs.getNewsStatus().size();i++){
                listModel.addElement(modelAdminCatalogs.getNewsStatus().get(i).getDescriptionNewsStatus());
            }
        }
        else if(viewAdminCatalogs.getCmbCatalogo()=="Tipo de Noticia"){
            for(int i=0; i< modelAdminCatalogs.getNewsType().size();i++){
                listModel.addElement(modelAdminCatalogs.getNewsType().get(i).getDescriptionNewsType());
            }
        }
    }
}
