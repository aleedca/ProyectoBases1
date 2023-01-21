/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAccess.DA_Parameters;
import Model.model_AdminParameters;
import Objects.Parameter;
import View.JF_AdminParameters;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexia
 */
public class AdminParametersController {
    private final JF_AdminParameters viewAdminParameters;
    private final model_AdminParameters modelParameters;
    
    public AdminParametersController(){
        JF_AdminParameters viewAdminParameters = new JF_AdminParameters();
        this.viewAdminParameters = viewAdminParameters;
        
        model_AdminParameters modelParameters = new model_AdminParameters();
        this.modelParameters = modelParameters;
        
        fillAdminParameters(); 
    }

    public JF_AdminParameters getViewAdminParameters() {
        return viewAdminParameters;
    }
    
    
    public void fillAdminParameters(){
        try{
            modelParameters.loadParameters();

            ArrayList<Parameter> parameters = modelParameters.getParameters();

            DefaultTableModel modelTable = (DefaultTableModel) viewAdminParameters.getTblParametros().getModel();
            modelTable.setRowCount(0);

            viewAdminParameters.getCmbSelectParameters().removeAllItems();

            for(int i = 0; i < parameters.size(); i++){
                Vector row = new Vector();
                Integer tmpIdParameters = parameters.get(i).getIdParameter();
                viewAdminParameters.getCmbSelectParameters().addItem(tmpIdParameters.toString());
                
                row.add(parameters.get(i).getIdParameter());
                row.add(parameters.get(i).getNameParameter());
                row.add(parameters.get(i).getValueParameter());
                modelTable.addRow(row);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void fillUpdateAdminParameters(int index){
        ArrayList<Parameter> parameters;
        System.out.println(index);
        
        try {
            parameters = DA_Parameters.getInfoParameter(index);
            System.out.println(parameters.get(0).getNameParameter());
            viewAdminParameters.getTxtNombre().setText(parameters.get(0).getNameParameter());
            viewAdminParameters.getTxtValor().setText(Integer.toString(parameters.get(0).getValueParameter()));
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void showView(){ 
        viewAdminParameters.setVisible(true);
    }
}
