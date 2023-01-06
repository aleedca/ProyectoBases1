/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Model.NewsList;
import Model.TeamList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Nahomy
 */
public class DA_NewsList {
    
    public static ArrayList<NewsList> getNewsList(String author, String authorLastname, String newsDate, String newsEvent) throws SQLException {
        Connection conn = sysConnection.getConexion();
        CallableStatement sql = conn.prepareCall("{call getNewsList(?,?,?,?)}");
        
        
        // input parameters
        System.out.println("Comienza if-anidados");
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
        
        System.out.println("Termina if-anidados");
        
        
        // output parameters
        sql.registerOutParameter(7, OracleTypes.REF_CURSOR);
        
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(7);

        System.out.println("Obtuvo el objeto");
        ArrayList<NewsList> newsList = new ArrayList<>();
        System.out.println("Creo el arraylist");
        
        
        while(rs.next()){
            System.out.println("Entro al while");
            NewsList news = new NewsList();

            news.setAuthor(rs.getString("firstName")); 
            news.setAuthor(rs.getString("lastName")); 
            news.setTitle(rs.getString("title"));
            news.setNewsDate(rs.getString("publicationDate"));
            news.setTypeNews(rs.getString("descriptionNewsType"));
            

            newsList.add(news);
            System.out.println(news.toString());
        }
        System.out.println("Termina ejecucion");
        return newsList;
    }
            
    
}
