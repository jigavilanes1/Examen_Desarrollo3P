/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jacqu
 */
public class Conexion {
    Connection conn;
    String url="jdbc:oracle:thin:@localhost:1521:xe";
    String user = "System";
    String pass = "12345";
    
    public Connection Conectar() throws ClassNotFoundException{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,user,pass);
        }catch(SQLException ex){
            System.out.println("Error al conectar!!");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return conn;
    }
    
    public void Cerrar(Connection conn){
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException ex){
                System.out.println("Error al cerrar!!");
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
