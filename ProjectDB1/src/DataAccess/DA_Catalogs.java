/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Objects.Canton;
import Objects.Country;
import Objects.CountryTeam;
import Objects.District;
import Objects.Event;
import Objects.Gender;
import Objects.Group;
import Objects.Position;
import Objects.Province;
import Objects.Stadium;
import Objects.Team;
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
            
            province.setIdCountry(rs.getInt("idCountry"));
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
            canton.setIdProvince(rs.getInt("idProvince"));
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
            
            district.setIdCanton(rs.getInt("idCanton"));
            district.setIdDistrict(rs.getInt("idDistrict"));
            district.setNameDistrict(rs.getString("nameDistrict"));
            districts.add(district);
        }

        return districts;
    }
     
    public static ArrayList<Position> getPosition() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getPosition(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Position> positions = new ArrayList<>();
        while(rs.next()){
            Position position = new Position();
            
            position.setIdPersonPosition(rs.getInt("idPersonPosition"));
            position.setDescriptionPersonPosition(rs.getString("descriptionPersonPosition"));
            
            positions.add(position);
        }

        return positions;
    }
    
    public static ArrayList<Event> getEvent() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getEvent(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Event> events = new ArrayList<>();
        while(rs.next()){
            Event event = new Event();
            
            event.setIdEvent(rs.getInt("idEvent"));
            event.setTypeEvent(rs.getString("typeEvent"));
            
            events.add(event);
        }

        return events;
    }
    
    
    public static ArrayList<Group> getGroup() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getGroupEvent(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Group> groups = new ArrayList<>();
        
        while(rs.next()){
            Group group = new Group();    
            group.setIdGroup(rs.getInt("idGroupEvent"));
            group.setDescriptionGroup(rs.getString("descriptionGroupEvent"));
            groups.add(group);
        }

        return groups;
    }
    

    public static ArrayList<Team> getTeam() throws SQLException {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{call getTeam(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();

        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Team> teams = new ArrayList<>();
        while(rs.next()){
            Team team = new Team();

            team.setIdTeam(rs.getInt("idTeam"));
            team.setNameTeam(rs.getString("nameTeam"));

            teams.add(team);
        }

        return teams;
    }
           
    public static ArrayList<CountryTeam> getCountryTeam() throws SQLException {
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{call getCountryTeam(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();

        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<CountryTeam> countryTeams = new ArrayList<>();
        while(rs.next()){
            CountryTeam countryTeam = new CountryTeam();

            countryTeam.setIdCountryTeam(rs.getInt("idCountryTeam"));
            countryTeam.setIdContinent(rs.getInt("idContinent"));
            countryTeam.setNameCountryTeam(rs.getString("nameCountryTeam"));

            countryTeams.add(countryTeam);
        }

        return countryTeams;
    }
        
    public static ArrayList<Stadium> getStadium() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getStadium(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Stadium> stadiums = new ArrayList<>();
        while(rs.next()){
            Stadium stadium = new Stadium();
            
            stadium.setIdStadium(rs.getInt("idStadium"));
            stadium.setIdCountry(rs.getInt("idCountry"));
            stadium.setNameStadium(rs.getString("nameStadium"));
            
            
            stadiums.add(stadium);
        }

        return stadiums;
    }   
       
}
