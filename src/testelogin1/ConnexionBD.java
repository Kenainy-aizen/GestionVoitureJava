/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testelogin1;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author kenainy
 */
public class ConnexionBD {
    
    Connection conn=null;
    public static Connection conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/venteVoiture","root","kenainy11");
                if(conn != null) {
                    System.out.println("Connexion a la base de donne a ete etablie avec succes");
                } else {
                    System.out.println("Probleme de connexion a la base");
                }
            return conn;
                }
        catch(Exception e) {
             System.out.println("--> SQLException : " + e);
             return null;
        }
    }
}

