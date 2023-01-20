/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Parameters;
import Objects.Parameter;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Alexia
 */
public class model_AdminParameters {
    private String name;
    private String value; 
    private int idParameter;
    
    private ArrayList<Parameter> parameters;
    private int resultUpdateParameter = 0;
    
    public void loadParameters(){
        try {
            this.parameters = DA_Parameters.getParameters();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }
    
    public boolean validateEmptyFields(){
        if(this.name.isEmpty() || this.value.isEmpty()){return false;}
        return true;
    }
    
    public void insertParameter(){
        try {
            DA_Parameters.insertParameter(this.name, Integer.parseInt(this.value));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateParameter(){
        try {
            this.resultUpdateParameter = DA_Parameters.updateParameter(this.idParameter, this.name, Integer.parseInt(this.value));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIdParameter() {
        return idParameter;
    }

    public void setIdParameter(int idParameter) {
        this.idParameter = idParameter;
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

    public int getResultUpdateParameter() {
        return resultUpdateParameter;
    }

    public void setResultUpdateParameter(int resultUpdateParameter) {
        this.resultUpdateParameter = resultUpdateParameter;
    }
    
    
    
}
