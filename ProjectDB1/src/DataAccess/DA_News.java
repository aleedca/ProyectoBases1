/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Objects.News;
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
            news.setIdNewsStatus(rs.getInt("idNewsStatus"));
            news.setIdNewsType(rs.getInt("idNewsType"));
            
            news.setPublicationDate(rs.getString("publicationDate")); // date a string?
            news.setViews(rs.getInt("views"));
            news.setLink(rs.getString("link"));
            news.setPhoto(rs.getString("photo"));
            news.setAuthor(rs.getString("author"));
            news.setText(rs.getString("text"));
            
            newsArr.add(news);
            System.out.println(news.toString());
        }

        return newsArr;
    }
}
