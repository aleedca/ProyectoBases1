/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mariana
 */
public class sysConnection {
        public static Connection obtConexion(){
        try{
            String myDB = "jdbc:oracle:thin:@localhost:1521:demo"; //Cambia por Services->ConexionBD(cuando se haga)->Properties->Database URL
            String user = "proyectoBD"; //Nombre del usuario de la BD
            String password = "proyectoBD"; //Contraseña de la BD
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            java.sql.Connection connection = DriverManager.getConnection(myDB, user, password);
            return (Connection) connection;
        }catch(SQLException e){
            System.out.println("El erro es: "+ e);
        return null;
        } //probando ando 
    }
}
