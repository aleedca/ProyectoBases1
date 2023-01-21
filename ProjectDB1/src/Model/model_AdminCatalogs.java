/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Catalogs;
import DataAccess.DA_News;
import Objects.Canton;
import Objects.Continent;
import Objects.Country;
import Objects.CountryTeam;
import Objects.District;
import Objects.Event;
import Objects.Gender;
import Objects.NewsStatus;
import Objects.NewsType;
import Objects.Position;
import Objects.Province;
import Objects.TypeIdentification;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexia
 */
public class model_AdminCatalogs {
    private int idTypeIdentification;
    private String nameTpeIdentification;
    private ArrayList<TypeIdentification> identificationTypes;
    
    private int idCountry;
    private String nameCountry;
    private ArrayList<Country> countries;
    
    private int idProvince;
    private String nameProvince;
    private ArrayList<Province> provinces;
    
    private int idCanton;
    private String nameCanton;
    private ArrayList<Canton> cantons;
    
    private int idDistrict;
    private String nameDistrict;
    private ArrayList<District> districts;
    
    private int event;
    private ArrayList<Event> events;
    
    private int idPosition;
    private String descriptionPosition;
    private ArrayList<Position> positions;
    
    private int status;
    private ArrayList<NewsStatus> newsStatus;
    
    private int type;
    private ArrayList<NewsType> newsType;
    
    private int idGender;
    private String descriptionGender;
    private ArrayList<Gender> genders;
    
    private int idContinent;
    private String nameContinent;
    private ArrayList<Continent> continents;
    
    private int idCountryTeam;
    private String nameCountryTeam;
    private ArrayList<CountryTeam> countryTeams;

    private int resultDeleteGender;
    private int resultDeleteTypeIdentification;
    private int resultDeleteCountry;
    private int resultDeleteProvince;
    
    public model_AdminCatalogs(){
        try {
            this.genders = DA_Catalogs.getGender();
            
            this.identificationTypes = DA_Catalogs.getTypeIdentification();
            
            this.countries = DA_Catalogs.getCountry();
            
            this.provinces = DA_Catalogs.getProvince();
            
            this.cantons = DA_Catalogs.getCanton();
            
            this.districts = DA_Catalogs.getDistrict();
                      
            this.events = DA_Catalogs.getEvent();
            
            this.positions = DA_Catalogs.getPosition();
            
            this.newsStatus = DA_News.getNewsStatus();
            
            this.newsType = DA_News.getNewsType();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    //--------------------------- LOAD -------------------------------------
    public void loadGenders(){
        try {
            this.genders = DA_Catalogs.getGender();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }

    public void loadIdentificationTypes (){
        try {
            this.identificationTypes = DA_Catalogs.getTypeIdentification();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }

    public void loadCountries  (){
        try {
            this.countries = DA_Catalogs.getCountry();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }

    public void loadProvinces (){
        try {
            this.provinces = DA_Catalogs.getProvince();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }
    
    public void loadCantons (){
        try {
            this.cantons = DA_Catalogs.getCanton();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }

    public void loadDistricts  (){
        try {
            this.districts = DA_Catalogs.getDistrict();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }

    public void loadEvents (){
        try {
            this.events = DA_Catalogs.getEvent();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }

    public void loadNewsStatus  (){
        try {
            this.newsStatus = DA_News.getNewsStatus();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }

    public void loadNewsType  (){
        try {
            this.newsType = DA_News.getNewsType();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }
    

    //---------------------------------------------------------------
    
    public void insertGender(){
        try {
            DA_Catalogs.insertGender(descriptionGender);
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }
    
    //------------- UPDATE -------------------------------
    public void updateGender(){
        try {
            DA_Catalogs.updateGender(this.idGender, this.descriptionGender);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void updateTypeIdentification(){
      try{
        DA_Catalogs.updateTypeIdentification(this.idTypeIdentification, this.nameTpeIdentification);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void updateCountry(){
      try{
        DA_Catalogs.updateCountry(this.idCountry, this.nameCountry);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void updateProvince(){
      try{
        DA_Catalogs.updateProvince(this.idProvince, this.idCountry, this.nameProvince);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void updateCanton(){
      try{
        DA_Catalogs.updateCanton(this.idCanton, this.idProvince, this.nameCanton);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void updateDistrict(){
      try{
        DA_Catalogs.updateDistrict(this.idDistrict, this.idCanton, this.nameDistrict);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void updatePosition(){
      try{
        DA_Catalogs.updatePosition(this.idPosition, this.descriptionPosition);
      }catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void updateContinent(){
      try{
        DA_Catalogs.updateContinent(this.idContinent, this.nameContinent);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void updateCountryTeam(){
      try{
        DA_Catalogs.updateCountryTeam(this.idCountryTeam, this.idContinent, this.nameCountryTeam);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    //------------------------ DELETES ---------------------------------------
    public boolean deleteGender(){
        try {
            this.resultDeleteGender = DA_Catalogs.deleteGender(this.idGender);
            
            if(this.resultDeleteGender == 0){
                return true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
       return false;
    }

    
    
    //----------- GETTERS AND SETTERS ----------------
       
}
