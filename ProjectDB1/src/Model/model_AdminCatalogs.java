/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccess.DA_Catalogs;
import DataAccess.DA_News;
import Objects.Canton;
import Objects.Country;
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

/**
 *
 * @author Alexia
 */
public class model_AdminCatalogs {
    private int typeIdentification;
    private ArrayList<TypeIdentification> identificationTypes;
    
    private int country;
    private ArrayList<Country> countries;
    
    private int province;
    private ArrayList<Province> provinces;
    
    private int canton;
    private ArrayList<Canton> cantons;
    
    private int district;
    private ArrayList<District> districts;
    
    private int event;
    private ArrayList<Event> events;
    
    private int position;
    private ArrayList<Position> positions;
    
    private int status;
    private ArrayList<NewsStatus> newsStatus;
    
    private int type;
    private ArrayList<NewsType> newsType;
    
    private int gender;
    private ArrayList<Gender> genders;
    
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

    public int getTypeIdentification() {
        return typeIdentification;
    }

    public void setTypeIdentification(int typeIdentification) {
        this.typeIdentification = typeIdentification;
    }

    public ArrayList<TypeIdentification> getIdentificationTypes() {
        return identificationTypes;
    }

    public void setIdentificationTypes(ArrayList<TypeIdentification> identificationTypes) {
        this.identificationTypes = identificationTypes;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public ArrayList<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(ArrayList<Province> provinces) {
        this.provinces = provinces;
    }

    public int getCanton() {
        return canton;
    }

    public void setCanton(int canton) {
        this.canton = canton;
    }

    public ArrayList<Canton> getCantons() {
        return cantons;
    }

    public void setCantons(ArrayList<Canton> cantons) {
        this.cantons = cantons;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public ArrayList<Gender> getGenders() {
        return genders;
    }

    public void setGenders(ArrayList<Gender> genders) {
        this.genders = genders;
    }
    
    
}
