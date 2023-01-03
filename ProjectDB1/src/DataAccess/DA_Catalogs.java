/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Objects.Canton;
import Objects.Country;
import Objects.District;
import Objects.Gender;
import Objects.Province;
import Objects.TypeIdentification;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Mariana
 */
public class DA_Catalogs {
    
    public static ArrayList<Gender> getGender() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getGender(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Gender> genders = new ArrayList<>();
        while(rs.next()){
            Gender gender = new Gender();
            
            gender.setIdGender(rs.getInt("idGender"));
            gender.setDescriptionGender(rs.getString("descriptionGender"));
            genders.add(gender);
        }

        return genders;
    }
    
    
    public static ArrayList<TypeIdentification> getTypeIdentification() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getTypeIdentification(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<TypeIdentification> identificationTypes = new ArrayList<>();
        while(rs.next()){
            TypeIdentification typeIdentification = new TypeIdentification();
            
            typeIdentification.setIdTypeIdentification(rs.getInt("idTypeIdentification"));
            typeIdentification.setNameTypeIdentification(rs.getString("nameTypeIdentification"));
            identificationTypes.add(typeIdentification);
        }

        return identificationTypes;
    }
    
    
    public static ArrayList<Country> getCountry() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getCountry(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Country> countries = new ArrayList<>();
        while(rs.next()){
            Country country = new Country();
            
            country.setIdCountry(rs.getInt("idCountry"));
            country.setNameCountry(rs.getString("nameCountry"));
            countries.add(country);
        }

        return countries;
    }
    
    public static ArrayList<Province> getProvince() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getProvince(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Province> provinces = new ArrayList<>();
        while(rs.next()){
            Province province = new Province();
            
            province.setIdProvince(rs.getInt("idProvince"));
            province.setNameProvince(rs.getString("nameProvince"));
            provinces.add(province);
        }

        return provinces;
    }
    
    
    public static ArrayList<Canton> getCanton() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getCanton(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Canton> cantons = new ArrayList<>();
        while(rs.next()){
            Canton canton = new Canton();
            
            canton.setIdCanton(rs.getInt("idCanton"));
            canton.setNameCanton(rs.getString("nameCanton"));
            cantons.add(canton);
        }

        return cantons;
    }
    
    public static ArrayList<District> getDistrict() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getDistrict(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<District> districts = new ArrayList<>();
        while(rs.next()){
            District district = new District();
            
            district.setIdDistrict(rs.getInt("idDistrict"));
            district.setNameDistrict(rs.getString("nameDistrict"));
            districts.add(district);
        }

        return districts;
    }
    
    
    
    
}
