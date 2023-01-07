/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Objects.News;
import Objects.NewsStatus;
import Objects.NewsType;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            news.setPublicationDate(rs.getString("publicationDate")); // date a string?
            news.setViews(rs.getInt("viewsNews"));
            news.setLink(rs.getString("linkNews"));
            news.setPhoto(rs.getString("photo"));
            news.setText(rs.getString("textNews"));
            newsArr.add(news);
            System.out.println(news.toString());
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
    
    
    
    
    
}
