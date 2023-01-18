/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;



import Objects.News;
import Objects.NewsStatus;
import Objects.NewsType;
import java.math.BigDecimal;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Alexia
 */
public class DA_News {
    
    //-----------------------GET FUNCTIONS-----------------------
    public static ArrayList<News> getNews() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getNews(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<News> newsArr = new ArrayList<>();
        while(rs.next()){
            News news = new News();
            
            news.setIdNews(rs.getInt("idNews"));
            news.setNewsType(rs.getString("descriptionNewsType"));
            news.setNewsStatus(rs.getString("descriptionNewsStatus"));
            news.setTitle(rs.getString("title"));
            news.setPublicationDate(rs.getString("publicationDate"));
            news.setLink(rs.getString("linkNews"));
            news.setPhoto(rs.getString("photo"));
            news.setText(rs.getString("textNews"));
            news.setViews(rs.getInt("viewsNews"));
            newsArr.add(news);
        }

        return newsArr;
    }
    
    public static ArrayList<News> getInfoNews(int idNews) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getInfoNews(?,?)}");
        sql.setInt(1, idNews);
        sql.registerOutParameter(2, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(2);
        ArrayList<News> newsArr = new ArrayList<>();
        while(rs.next()){
            News news = new News();
            
            news.setIdNews(rs.getInt("idNews"));
            news.setIdNewsType(rs.getInt("idNewsType"));
            news.setIdNewsStatus(rs.getInt("idNewsStatus"));
            news.setTitle(rs.getString("title"));
            news.setPhoto(rs.getString("photo"));
            news.setText(rs.getString("textNews"));
            newsArr.add(news);
        }

        return newsArr;
    }
    
    
    public static ArrayList<NewsStatus> getNewsStatus() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getNewsStatus(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<NewsStatus> arrayNewsStatus = new ArrayList<>();
        while(rs.next()){
            NewsStatus newsStatus = new NewsStatus();
            
            newsStatus.setIdNewsStatus(rs.getInt("idNewsStatus"));
            newsStatus.setDescriptionNewsStatus(rs.getString("descriptionNewsStatus"));
            arrayNewsStatus.add(newsStatus);
        }

        return arrayNewsStatus;
    }
    
    
    public static ArrayList<NewsType> getNewsType() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getNewsType(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<NewsType> arrayNewsType = new ArrayList<>();
        while(rs.next()){
            NewsType newsType = new NewsType();
            
            newsType.setIdNewsType(rs.getInt("idNewsType"));
            newsType.setDescriptionNewsType(rs.getString("descriptionNewsType"));
            arrayNewsType.add(newsType);
        }

        return arrayNewsType;
    }
    
    public static ArrayList<News> getMostViewedNews() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getMostViewedNews(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<News> mostViewedNews = new ArrayList<>();
        while(rs.next()){
            News news = new News();
            
            news.setTitle(rs.getString("title"));
            news.setViews(rs.getInt("viewsNews"));
           
            mostViewedNews.add(news);
        }
        
        return mostViewedNews;
    }
    
    public static ArrayList<News> getLastNews() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getLastNews(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<News> lastNews = new ArrayList<>();
        while(rs.next()){
            News news = new News();
            
            news.setTitle(rs.getString("title"));
            news.setPublicationDate(rs.getString("publicationDate"));
           
            lastNews.add(news);
        }
        
        return lastNews;
    }
    
    //-------------INSERTS----------------------
    
    public static int insertNews(int idNewsStatus, int idNewsType, String title, Date publicationDate, String link, 
        String photo, String text) throws SQLException {
        
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call insertNews(?,?,?,?,?,?,?,?)}");
        publicationDate = new java.util.Date();
        
        sql.setInt(1, idNewsStatus);
        sql.setInt(2, idNewsType);
        sql.setString(3, title);
        sql.setDate(4, new java.sql.Date(publicationDate.getTime()));
        sql.setString(5, link);
        sql.setString(6, photo);
        sql.setString(7, text);
        sql.registerOutParameter(8, OracleTypes.NUMBER);
        sql.execute();
        
        int idNews = ((BigDecimal) sql.getObject(8)).intValue();
        return idNews; 
    }
    
    public static void insertUserXNews(int idNews, String username) throws SQLException {
        
        Connection conn = sysConnection.getConexion();
        PreparedStatement sql = conn.prepareCall("{call insertUserXNews(?,?)}");
        
        sql.setString(1, username);
        sql.setInt(2, idNews);

        sql.execute();
    }
    
    //-------------------UPDATES----------------
    
    public static int updateStatus(int idNews, int idNewsStatus) throws SQLException{
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateStatus(?,?,?)}");
        //Input parameters
        sql.setInt(1, idNews);
        sql.setInt(2, idNewsStatus);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    public static int updateType(int idNews, int idNewsType) throws SQLException{
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateType(?,?,?)}");
        //Input parameters
        sql.setInt(1, idNews);
        sql.setInt(2, idNewsType);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    public static int updateTitle(int idNews, String title) throws SQLException{
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateTitle(?,?,?)}");
        //Input parameters
        sql.setInt(1, idNews);
        sql.setString(2, title);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    public static int updateText(int idNews, String text) throws SQLException{
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updateText(?,?,?)}");
        //Input parameters
        sql.setInt(1, idNews);
        sql.setString(2, text);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
    
    public static int updatePhoto(int idNews, String photo) throws SQLException{
        Connection conn = sysConnection.getConexion();

        CallableStatement sql = conn.prepareCall("{ call updatePhoto(?,?,?)}");
        //Input parameters
        sql.setInt(1, idNews);
        sql.setString(2, photo);

        //Output parameter
        sql.registerOutParameter(3, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(3)).intValue();
        return result;
    }
   
}
