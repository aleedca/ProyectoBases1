/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Objects.NewsList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;


public class DA_NewsList {
    
    public static ArrayList<NewsList> getNewsList(String author, String authorLastname, String newsDate, String newsEvent) throws SQLException {
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call getNewsList(?,?,?,?)}");
       
        // input parameters
        if (author!=""){
          sql.setString(1, author);  
        } else if (author==""){
          sql.setString(1, null);  
        }
        
        if (authorLastname!=""){
          sql.setString(2, authorLastname);  
        } else if (authorLastname==""){
          sql.setString(2, null);  
        }
        
        if (newsDate!=""){
          sql.setString(3, newsDate);  
        } else if (newsDate==""){
          sql.setString(3, "N/A");  
        }
        
        if (newsEvent!=""){
          sql.setString(4, newsEvent); 
        } else if (newsEvent==""){
          sql.setString(4, null);  
        }
        
        // output parameters
        sql.registerOutParameter(7, OracleTypes.REF_CURSOR);
        
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(7);
        ArrayList<NewsList> newsList = new ArrayList<>();

        while(rs.next()){
            NewsList news = new NewsList();

            news.setAuthor(rs.getString("firstName")); 
            news.setAuthor(rs.getString("lastName")); 
            news.setTitle(rs.getString("title"));
            news.setNewsDate(rs.getString("publicationDate"));
            news.setTypeNews(rs.getString("descriptionNewsType"));
            
            newsList.add(news);
        }
        return newsList;
    }
            
    
}
