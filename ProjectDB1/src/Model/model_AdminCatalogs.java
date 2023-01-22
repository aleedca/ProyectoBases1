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
    private String nameTypeIdentification;
    private String nameMask;
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
    private int resultDeleteCanton;
    private int resultDeleteDistrict;    
    private int resultDeletePosition;
    private int resultDeleteContinent;
    private int resultDeleteCountryTeam;
    
    public model_AdminCatalogs(){
        
    }
    
    //--------------------------- LOAD -------------------------------------
    public void loadCatalogs(){
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
            
            this.continents = DA_Catalogs.getContinent();
            
            this.countryTeams = DA_Catalogs.getCountryTeam();
            
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
    
    public void insertTypeIdentification(){
      try{
        System.out.println("Entro al DA");
        DA_Catalogs.insertTypeIdentification(this.nameTypeIdentification, this.nameMask);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void insertCountry(){
      try{
        DA_Catalogs.insertCountry(this.nameCountry);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void insertProvince(){
      try{
        DA_Catalogs.insertProvince(this.idCountry, this.nameProvince);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void insertCanton(){
      try{
        DA_Catalogs.insertCanton(this.idProvince, this.nameCanton);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void insertDistrict(){
      try{
        DA_Catalogs.insertDistrict(this.idCanton, this.nameDistrict);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void insertPosition(){
      try{
        DA_Catalogs.insertPosition(this.descriptionPosition);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void insertContinent(){
      try{
        DA_Catalogs.insertContinent(this.nameContinent);
      } catch(SQLException ex){
        System.out.println(ex);
      }
    }

    public void insertCountryTeam(){
      try{
        DA_Catalogs.insertCountryTeam(this.idContinent, this.nameCountryTeam);
      } catch(SQLException ex){
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
        DA_Catalogs.updateTypeIdentification(this.idTypeIdentification, this.nameTypeIdentification);
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
        DA_Catalogs.updateProvince(this.idProvince, this.nameProvince);
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

    public boolean deleteTypeIdentificaion(){
      try {
        this.resultDeleteTypeIdentification = DA_Catalogs.deleteTypeIdentification(this.idTypeIdentification);

        if(this.resultDeleteTypeIdentification == 0){
          return true;
        }
      } catch (SQLException ex) {
          System.out.println(ex);
      }

      return false;
    }

    public boolean deleteCountry(){
      try{
        this.resultDeleteCountry = DA_Catalogs.deleteCountry(this.idCountry);
        if(this.resultDeleteCountry == 0){
          return true;
        }
      } catch (SQLException ex) {
          System.out.println(ex);
      }

      return false;
    }

    public boolean deleteProvince(){
      try{
        this.resultDeleteProvince = DA_Catalogs.deleteProvince(this.idProvince);
        if(this.resultDeleteProvince == 0){
          return true;
        }
      } catch (SQLException ex) {
          System.out.println(ex);
      }

      return false;
    }

    public boolean deleteCanton(){
      try{
        this.resultDeleteCanton = DA_Catalogs.deleteCanton(this.idCanton);
        if(this.resultDeleteCanton == 0){
          return true;
        }
      } catch (SQLException ex) {
          System.out.println(ex);
      }

      return false;
    }

    public boolean deleteDistrict(){
      try{
        this.resultDeleteDistrict = DA_Catalogs.deleteDistrict(this.idDistrict);
        if(this.resultDeleteDistrict == 0){
          return true;
        }
      } catch (SQLException ex) {
          System.out.println(ex);
      }

      return false;
    }

    public boolean deletePosition(){
      try{
        this.resultDeletePosition = DA_Catalogs.deletePosition(this.idPosition);
        if(this.resultDeletePosition == 0){
          return true;
        }
      } catch (SQLException ex) {
          System.out.println(ex);
      }

      return false;
    }

    public boolean deleteContinent(){
      try{
        this.resultDeleteContinent = DA_Catalogs.deleteContinent(this.idContinent);
        if(this.resultDeleteContinent == 0){
          return true;
        }
      } catch (SQLException ex) {
          System.out.println(ex);
      }

      return false;
    }

    public boolean deleteCountryTeam(){
      try{
        this.resultDeleteCountryTeam = DA_Catalogs.deleteCountryTeam(this.idCountryTeam);
        if(this.resultDeleteCountryTeam == 0){
          return true;
        }
      } catch (SQLException ex) {
          System.out.println(ex);
      }

      return false;
    }
    
    
    //----------- GETTERS AND SETTERS ----------------

    public int getIdTypeIdentification() {
        return idTypeIdentification;
    }

    public void setIdTypeIdentification(int idTypeIdentification) {
        this.idTypeIdentification = idTypeIdentification;
    }

    public String getNameTypeIdentification() {
        return nameTypeIdentification;
    }

    public void setNameTypeIdentification(String nameTypeIdentification) {
        this.nameTypeIdentification = nameTypeIdentification;
    }

    public String getNameMask() {
        return nameMask;
    }

    public void setNameMask(String nameMask) {
        this.nameMask = nameMask;
    }

    public ArrayList<TypeIdentification> getIdentificationTypes() {
        return identificationTypes;
    }

    public void setIdentificationTypes(ArrayList<TypeIdentification> identificationTypes) {
        this.identificationTypes = identificationTypes;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    public ArrayList<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(ArrayList<Province> provinces) {
        this.provinces = provinces;
    }

    public int getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(int idCanton) {
        this.idCanton = idCanton;
    }

    public String getNameCanton() {
        return nameCanton;
    }

    public void setNameCanton(String nameCanton) {
        this.nameCanton = nameCanton;
    }

    public ArrayList<Canton> getCantons() {
        return cantons;
    }

    public void setCantons(ArrayList<Canton> cantons) {
        this.cantons = cantons;
    }

    public int getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
    }

    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<District> districts) {
        this.districts = districts;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public String getDescriptionPosition() {
        return descriptionPosition;
    }

    public void setDescriptionPosition(String descriptionPosition) {
        this.descriptionPosition = descriptionPosition;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<NewsStatus> getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(ArrayList<NewsStatus> newsStatus) {
        this.newsStatus = newsStatus;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<NewsType> getNewsType() {
        return newsType;
    }

    public void setNewsType(ArrayList<NewsType> newsType) {
        this.newsType = newsType;
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public String getDescriptionGender() {
        return descriptionGender;
    }

    public void setDescriptionGender(String descriptionGender) {
        this.descriptionGender = descriptionGender;
    }

    public ArrayList<Gender> getGenders() {
        return genders;
    }

    public void setGenders(ArrayList<Gender> genders) {
        this.genders = genders;
    }

    public int getIdContinent() {
        return idContinent;
    }

    public void setIdContinent(int idContinent) {
        this.idContinent = idContinent;
    }

    public String getNameContinent() {
        return nameContinent;
    }

    public void setNameContinent(String nameContinent) {
        this.nameContinent = nameContinent;
    }

    public ArrayList<Continent> getContinents() {
        return continents;
    }

    public void setContinents(ArrayList<Continent> continents) {
        this.continents = continents;
    }

    public int getIdCountryTeam() {
        return idCountryTeam;
    }

    public void setIdCountryTeam(int idCountryTeam) {
        this.idCountryTeam = idCountryTeam;
    }

    public String getNameCountryTeam() {
        return nameCountryTeam;
    }

    public void setNameCountryTeam(String nameCountryTeam) {
        this.nameCountryTeam = nameCountryTeam;
    }

    public ArrayList<CountryTeam> getCountryTeams() {
        return countryTeams;
    }

    public void setCountryTeams(ArrayList<CountryTeam> countryTeams) {
        this.countryTeams = countryTeams;
    }

    public int getResultDeleteGender() {
        return resultDeleteGender;
    }

    public void setResultDeleteGender(int resultDeleteGender) {
        this.resultDeleteGender = resultDeleteGender;
    }

    public int getResultDeleteTypeIdentification() {
        return resultDeleteTypeIdentification;
    }

    public void setResultDeleteTypeIdentification(int resultDeleteTypeIdentification) {
        this.resultDeleteTypeIdentification = resultDeleteTypeIdentification;
    }

    public int getResultDeleteCountry() {
        return resultDeleteCountry;
    }

    public void setResultDeleteCountry(int resultDeleteCountry) {
        this.resultDeleteCountry = resultDeleteCountry;
    }

    public int getResultDeleteProvince() {
        return resultDeleteProvince;
    }

    public void setResultDeleteProvince(int resultDeleteProvince) {
        this.resultDeleteProvince = resultDeleteProvince;
    }

    public int getResultDeleteCanton() {
        return resultDeleteCanton;
    }

    public void setResultDeleteCanton(int resultDeleteCanton) {
        this.resultDeleteCanton = resultDeleteCanton;
    }

    public int getResultDeleteDistrict() {
        return resultDeleteDistrict;
    }

    public void setResultDeleteDistrict(int resultDeleteDistrict) {
        this.resultDeleteDistrict = resultDeleteDistrict;
    }

    public int getResultDeletePosition() {
        return resultDeletePosition;
    }

    public void setResultDeletePosition(int resultDeletePosition) {
        this.resultDeletePosition = resultDeletePosition;
    }

    public int getResultDeleteContinent() {
        return resultDeleteContinent;
    }

    public void setResultDeleteContinent(int resultDeleteContinent) {
        this.resultDeleteContinent = resultDeleteContinent;
    }

    public int getResultDeleteCountryTeam() {
        return resultDeleteCountryTeam;
    }

    public void setResultDeleteCountryTeam(int resultDeleteCountryTeam) {
        this.resultDeleteCountryTeam = resultDeleteCountryTeam;
    }
       
    
    
}
