/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;


import Objects.AuthorReview;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Isaac
 */
public class DA_Stats {
    
    public static int getTotalPublishedNews() throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getTotalPublishedNews(?)}");
        
        sql.registerOutParameter(1,OracleTypes.NUMBER);
        sql.execute();
        
        int result = ((BigDecimal) sql.getObject(1)).intValue();
        
        return result;
    }
    
    public static ArrayList<AuthorReview> getAverageRating() throws SQLException{
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getAverageReviewsAuthor(?)}");
        sql.registerOutParameter(1,OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(2);
        ArrayList<AuthorReview> authorReviews = new ArrayList<>();
        while(rs.next()){
            AuthorReview authorRating = new AuthorReview();
            
            authorRating.setUsername(rs.getString("username"));
            authorRating.setAverageRating(rs.getInt("average"));
            
            authorReviews.add(authorRating);
        }
        
        return authorReviews;
    }
    
    
    
}
