/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Objects.MostViewedNews;
import Objects.News;
import Objects.NewsStatus;
import Objects.NewsType;
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
            news.setViews(rs.getInt("viewsNews"));
            news.setLink(rs.getString("linkNews"));
            news.setPhoto(rs.getString("photo"));
            news.setText(rs.getString("textNews"));
            newsArr.add(news);
        }

        return newsArr;
    }
    
    public static ArrayList<News> getInfoNews(int idNews) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getNews(?)}");
        sql.setInt(1, idNews);
        sql.registerOutParameter(2, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
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
    
    public static void insertNews(int idNewsStatus, int idNewsType, String title, Date publicationDate, String link, 
        String photo, String text) throws SQLException {
        
        Connection conn = sysConnection.getConexion();
        PreparedStatement sql = conn.prepareCall("{call insertNews(?,?,?,?,?,?,?)}");
        publicationDate = new java.util.Date();
        
        //Input parameters
        sql.setInt(1, idNewsStatus);
        sql.setInt(2, idNewsType);
        sql.setString(3, title);
        sql.setDate(4, new java.sql.Date(publicationDate.getTime()));
        sql.setString(5, link);
        sql.setString(6, photo);
        sql.setString(7, text);

        sql.execute();
    }
    
    public static ArrayList<MostViewedNews> getMostViewedNews() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getMostViewedNews(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<MostViewedNews> MostViewedNews = new ArrayList<>();
        while(rs.next()){
            MostViewedNews news = new MostViewedNews();
            
            news.setTitle(rs.getString("title"));
            news.setViews(rs.getInt("viewsNews"));
           
            MostViewedNews.add(news);
        }

        return MostViewedNews;
    }
    
    
    
}
