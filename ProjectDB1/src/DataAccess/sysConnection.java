/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Mariana
 */
public class sysConnection {
        public static Connection getConexion(){
        try{
<<<<<<< HEAD
            String myDB = "jdbc:oracle:thin:@localhost:1521:BASES"; //Cambia por Services->ConexionBD(cuando se haga)->Properties->Database URL
=======
            String myDB = "jdbc:oracle:thin:@localhost:1521:DBPRUEBA"; //Cambia por Services->ConexionBD(cuando se haga)->Properties->Database URL
>>>>>>> 3b4464ff9059f6cc8138bb17ea8edf0bf4ecf794
            String user = "proyectoBD"; //Nombre del usuario de la BD
            String password = "proyectoBD"; //Contraseña de la BD
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            java.sql.Connection connection = DriverManager.getConnection(myDB, user, password);
            return connection;
        }catch(SQLException e){
            System.out.println("El error es: "+ e);
        return null;
        } //probando ando 
    }
}
