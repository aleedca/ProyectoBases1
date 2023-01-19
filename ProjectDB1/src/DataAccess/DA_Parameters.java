/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Objects.Parameter;
import java.math.BigDecimal;
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
public class DA_Parameters {
    private static int resultIdInfo;

    public static int getResultIdInfo() {
        return resultIdInfo;
    }

    public static void setResultIdInfo(int result) {
        resultIdInfo = result;
    }
    
    public static ArrayList<Parameter> getParameters() throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getParameters(?)}");
        sql.registerOutParameter(1, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(1);
        ArrayList<Parameter> parameters = new ArrayList<>();
        while(rs.next()){
            Parameter parameter = new Parameter();
            
            parameter.setNameParameter(rs.getString("nameParameter"));
            parameter.setValueParameter(rs.getInt("valueParameter"));
            parameters.add(parameter);
        }

        return parameters;
    }
    
    public static ArrayList<Parameter> getInfoParameter(String name) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call getInfoParameter(?,?,?)}");
        sql.setString(1, name);
        sql.registerOutParameter(2, OracleTypes.NUMBER);
        sql.registerOutParameter(3, OracleTypes.REF_CURSOR);
        sql.execute();
        
        ResultSet rs = (ResultSet) sql.getObject(3);
        ArrayList<Parameter> parameters = new ArrayList<>();
        while(rs.next()){
            Parameter parameter = new Parameter();
            
            parameter.setIdParameter(rs.getInt("idParameterTable"));
            parameter.setNameParameter(rs.getString("nameParameter"));
            parameter.setValueParameter(rs.getInt("valueParameter"));
            parameters.add(parameter);
        }

        resultIdInfo = ((BigDecimal) sql.getObject(2)).intValue();
        return parameters;
    }
    
    public static int updateParameter(int idParameter, String name, int value) throws SQLException {
        Connection conn = sysConnection.getConexion();
        
        CallableStatement sql = conn.prepareCall("{call updateParameter(?,?,?,?)}");
        //Input parameters
        sql.setInt(1, idParameter);
        sql.setString(2, name);
        sql.setInt(2, value);

        //Output parameter
        sql.registerOutParameter(4, OracleTypes.NUMBER);
        sql.execute();

        int result = ((BigDecimal) sql.getObject(4)).intValue();
        return result;
    }
}
