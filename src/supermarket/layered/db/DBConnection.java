/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author sachinthadilshan
 */
public class DBConnection {
    private Connection connection;
    private static DBConnection dBConnection;
    
    private DBConnection(){
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket","root","Liyanage36@");
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println(e);
        }    
    }
    
    public static DBConnection getInstance(){
        if(dBConnection==null){
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
}
