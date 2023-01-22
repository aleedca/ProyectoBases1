/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Objects.Canton;
import Objects.Continent;
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
import java.math.BigDecimal;
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
    
    // GETTERS CATALOGS
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
    
    public static ArrayList<Continent> getContinent() throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getContinent(?)}");
        
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Continent> continents = new ArrayList<>();
        while(rs.next()){
            Continent continent = new Continent();
            
            continent.setIdContinent(rs.getInt("idContinent"));
            continent.setNameContinent(rs.getString("nameContinent"));
            continents.add(continent);
        }

        return continents;
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
            /*countryTeam.setTeamFlag(rs.getString("flag"));*/

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
       
    // INSERTIONS CATALOGS
    public static void insertGender(String descriptionGender) throws SQLException{      
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call insertGender(?)}");
        
        sql.setString(1, descriptionGender);
        sql.execute();
    }
    
    public static void insertTypeIdentification(String nameType, String nameMask) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call insertTypeIdentification(?,?)}");
        
        sql.setString(1, nameType);
        sql.setString(2, nameMask);
        sql.execute();
    }
    
    public static void insertCountry(String nameCountry) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call insertCountry(?)}");
        
        sql.setString(1, nameCountry);
        sql.execute();
    }
    
    public static void insertProvince(int idCountry, String nameProvince) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call insertProvince(?,?)}");
        
        sql.setInt(1, idCountry);
        sql.setString(2, nameProvince);
        sql.execute();
    }
    
    public static void insertCanton(int idProvince, String nameCanton) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call insertCanton(?,?)}");
        
        sql.setInt(1, idProvince);
        sql.setString(2, nameCanton);
        sql.execute();
    }
    
    public static void insertDistrict(int idCanton, String nameDistrict) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call insertDistrict(?,?)}");
        
        sql.setInt(1, idCanton);
        sql.setString(2, nameDistrict);
        sql.execute();
    }
    
    public static void insertPosition(String descriptionPosition) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call insertPosition(?)}");
        
        sql.setString(1, descriptionPosition);
        sql.execute();
    }
    
    public static void insertContinent(String nameContinent) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call insertContinent(?)}");
        
        sql.setString(1, nameContinent);
        sql.execute();
    }
    
    public static void insertCountryTeam(int idContinent, String nameCountryTeam) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call insertCountryTeam(?,?)}");
        
        sql.setInt(1, idContinent);
        sql.setString(2, nameCountryTeam);
        sql.execute();
    }
    
    // DELETIONS CATALOGS
    public static int deleteGender(int idGender) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call deleteGender(?,?)}");
        
        sql.setInt(1, idGender);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(2)).intValue();
        return result;
    }
    
    public static int deleteTypeIdentification(int idTypeIdentification) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call deleteTypeIdentification(?,?)}");
        
        sql.setInt(1, idTypeIdentification);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(2)).intValue();
        return result;
    }
    
    public static int deleteCountry(int idCountry) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call deleteCountry(?,?)}");
        
        sql.setInt(1, idCountry);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(2)).intValue();
        return result;
    }
    
    public static int deleteProvince(int idProvince) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call deleteProvince(?,?)}");
        
        sql.setInt(1, idProvince);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(2)).intValue();
        return result;
    }
    
    public static int deleteCanton(int idCanton) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call deleteCanton(?,?)}");
        
        sql.setInt(1, idCanton);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(2)).intValue();
        return result;
    }
    
    public static int deleteDistrict(int idDistrict) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call deleteDistrict(?,?)}");
        
        sql.setInt(1, idDistrict);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(2)).intValue();
        return result;
    }
    
    public static int deletePosition(int idPosition) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call deletePosition(?,?)}");
        
        sql.setInt(1, idPosition);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(2)).intValue();
        return result;
    }
    
    public static int deleteContinent(int idContinent) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call deleteContinent(?,?)}");
        
        sql.setInt(1, idContinent);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(2)).intValue();
        return result;
    }
    
    public static int deleteCountryTeam(int idCountryTeam) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call deleteCountryTeam(?,?)}");
        
        sql.setInt(1, idCountryTeam);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(2)).intValue();
        return result;
    }
    
    // UPDATE CATALOGS
    public static void updateGender(int idGender, String descriptionGender) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call updateGender(?,?)}");
        
        sql.setInt(1, idGender);
        sql.setString(2, descriptionGender);
        sql.execute();
    }
    
    public static void updateTypeIdentification(int idTypeIdentification, String nameTpeIdentification) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call updateTypeIdentification(?,?)}");
        
        sql.setInt(1, idTypeIdentification);
        sql.setString(2, nameTpeIdentification);
        sql.execute();
    }
    
    public static void updateCountry(int idCountry, String nameCountry) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call updateCountry(?,?)}");
        
        sql.setInt(1, idCountry);
        sql.setString(2, nameCountry);
        sql.execute();
    }
    
    public static void updateProvince(int idProvince, int idCountry, String nameProvince) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call updateProvince(?,?,?)}");
        
        sql.setInt(1, idProvince);
        sql.setInt(2, idCountry);
        sql.setString(3, nameProvince);
        sql.execute();
    }
    
    public static void updateCanton(int idCanton, int idProvince, String nameCanton) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call updateCanton(?,?,?)}");
        
        sql.setInt(1, idCanton);
        sql.setInt(2, idProvince);
        sql.setString(3, nameCanton);
        sql.execute();
    }
    
    public static void updateDistrict(int idDistrict, int idCanton, String nameDistrict) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call updateDistrict(?,?,?)}");
        
        sql.setInt(1, idDistrict);
        sql.setInt(2, idCanton);
        sql.setString(3, nameDistrict);
        sql.execute();
    }
    
    public static void updatePosition(int idPosition, String descriptionPosition) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call updatePosition(?,?)}");
        
        sql.setInt(1, idPosition);
        sql.setString(2, descriptionPosition);
        sql.execute();
    }
    
    public static void updateContinent(int idContinent, String nameContinent) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call updateContinent(?,?)}");
        
        sql.setInt(1, idContinent);
        sql.setString(2, nameContinent);
        sql.execute();
    }
    
    public static void updateCountryTeam(int idCountryTeam, int idContinent, String nameCountryTeam) throws SQLException{
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call updateCountryTeam(?,?,?)}");
        
        sql.setInt(1, idCountryTeam);
        sql.setInt(2, idContinent);
        sql.setString(3, nameCountryTeam);
        sql.execute();
    }
}
