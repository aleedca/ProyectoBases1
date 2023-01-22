/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.model_AdminCatalogs;
import View.JF_AdminCatalogs;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexia
 */
public class AdminCatalogsController {
    private final JF_AdminCatalogs viewAdminCatalogs;
    private final model_AdminCatalogs modelAdminCatalogs;
    
    //Constructor
    public AdminCatalogsController() { 
        //View AdminCatalogs
        JF_AdminCatalogs adminCatalogs = new JF_AdminCatalogs();
        this.viewAdminCatalogs = adminCatalogs;  
        
        //Model AdminCatalogs
        model_AdminCatalogs validateNews = new model_AdminCatalogs();
        this.modelAdminCatalogs = validateNews;
        
    }

    public JF_AdminCatalogs getViewAdminCatalogs() {
        return viewAdminCatalogs;
    }

    public model_AdminCatalogs getModelAdminCatalogs() {
        return modelAdminCatalogs;
    }

    
    public void fillCatalogs(){
        viewAdminCatalogs.getCmbSelect().removeAllItems();
        this.modelAdminCatalogs.loadCatalogs();
        int id;
        String idStr;
       
        DefaultTableModel modelTable = (DefaultTableModel) viewAdminCatalogs.getTblOpciones().getModel();
        modelTable.setRowCount(0); 
        
        if("Género".equals(viewAdminCatalogs.getCmbCatalogo().getSelectedItem().toString())){
            for(int i=0; i< modelAdminCatalogs.getGenders().size();i++){
                Object[] row = {modelAdminCatalogs.getGenders().get(i).getDescriptionGender()};
                modelTable.addRow(row);
                
                id = modelAdminCatalogs.getGenders().get(i).getIdGender();
                idStr = String.valueOf(id);
                viewAdminCatalogs.getCmbSelect().addItem(idStr);
            }
        }
        
        if("Tipo de Identificación".equals(viewAdminCatalogs.getCmbCatalogo().getSelectedItem().toString())){
            for(int i=0; i< modelAdminCatalogs.getIdentificationTypes().size();i++){
                Object[] row = {modelAdminCatalogs.getIdentificationTypes().get(i).getNameTypeIdentification()};
                modelTable.addRow(row);
                
                id = modelAdminCatalogs.getIdentificationTypes().get(i).getIdTypeIdentification();
                idStr = String.valueOf(id);
                viewAdminCatalogs.getCmbSelect().addItem(idStr);
            }
        }
        
        if("Posición".equals(viewAdminCatalogs.getCmbCatalogo().getSelectedItem().toString())){
            for(int i=0; i< modelAdminCatalogs.getPositions().size();i++){
                Object[] row = {modelAdminCatalogs.getPositions().get(i).getDescriptionPersonPosition()};
                modelTable.addRow(row);
                
                id = modelAdminCatalogs.getPositions().get(i).getIdPersonPosition();
                idStr = String.valueOf(id);
                viewAdminCatalogs.getCmbSelect().addItem(idStr);
            }
        }
        
        if("Continente".equals(viewAdminCatalogs.getCmbCatalogo().getSelectedItem().toString())){
            for(int i=0; i< modelAdminCatalogs.getContinents().size();i++){
                Object[] row = {modelAdminCatalogs.getContinents().get(i).getNameContinent()};
                modelTable.addRow(row);
                
                id = modelAdminCatalogs.getContinents().get(i).getIdContinent();
                idStr = String.valueOf(id);
                viewAdminCatalogs.getCmbSelect().addItem(idStr);
            }
        }
         
        if("País".equals(viewAdminCatalogs.getCmbCatalogo().getSelectedItem().toString())){
            for(int i=0; i< modelAdminCatalogs.getCountries().size();i++){
                Object[] row = {modelAdminCatalogs.getCountries().get(i).getNameCountry()};
                modelTable.addRow(row);
                
                id = modelAdminCatalogs.getCountries().get(i).getIdCountry();
                idStr = String.valueOf(id);
                viewAdminCatalogs.getCmbSelect().addItem(idStr);
            }
        }
        
        if("Provincia".equals(viewAdminCatalogs.getCmbCatalogo().getSelectedItem().toString())){
            for(int i=0; i< modelAdminCatalogs.getProvinces().size();i++){
                Object[] row = {modelAdminCatalogs.getProvinces().get(i).getNameProvince()};
                modelTable.addRow(row);
            }
        }
        
        if("Cantón".equals(viewAdminCatalogs.getCmbCatalogo().getSelectedItem().toString())){
            for(int i=0; i< modelAdminCatalogs.getCantons().size();i++){
                Object[] row = {modelAdminCatalogs.getCantons().get(i).getNameCanton()};
                modelTable.addRow(row);
            }
            
            for(int i=0; i< modelAdminCatalogs.getProvinces().size();i++){
                viewAdminCatalogs.getCmbSelect().addItem(modelAdminCatalogs.getProvinces().get(i).getNameProvince());
            }
        }
        
        if("Distrito".equals(viewAdminCatalogs.getCmbCatalogo().getSelectedItem().toString())){
            for(int i=0; i< modelAdminCatalogs.getDistricts().size();i++){
                Object[] row = {modelAdminCatalogs.getDistricts().get(i).getNameDistrict()};
                modelTable.addRow(row);
            }
            
            for(int i=0; i< modelAdminCatalogs.getCantons().size();i++){
                viewAdminCatalogs.getCmbSelect().addItem(modelAdminCatalogs.getCantons().get(i).getNameCanton());
            }
        }
        
        
        if("País de Equipo".equals(viewAdminCatalogs.getCmbCatalogo().getSelectedItem().toString())){
            for(int i=0; i< modelAdminCatalogs.getCountryTeams().size();i++){
                Object[] row = {modelAdminCatalogs.getCountryTeams().get(i).getNameCountryTeam()};
                modelTable.addRow(row);
            }
            
            for(int i=0; i< modelAdminCatalogs.getContinents().size();i++){
                viewAdminCatalogs.getCmbSelect().addItem(modelAdminCatalogs.getContinents().get(i).getNameContinent());
            }
        }
       
        
        if("Estado de Noticia".equals(viewAdminCatalogs.getCmbCatalogo().getSelectedItem().toString())){
            for(int i=0; i< modelAdminCatalogs.getNewsStatus().size();i++){
                Object[] row = {modelAdminCatalogs.getNewsStatus().get(i).getDescriptionNewsStatus()};
                modelTable.addRow(row);
            }
        }
        
        if("Tipo de Noticia".equals(viewAdminCatalogs.getCmbCatalogo().getSelectedItem().toString())){
            for(int i=0; i< modelAdminCatalogs.getNewsType().size();i++){
                Object[] row = {modelAdminCatalogs.getNewsType().get(i).getDescriptionNewsType()};
                modelTable.addRow(row);
            }
        }
    }
}
