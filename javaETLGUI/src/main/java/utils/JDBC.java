/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class JDBC {
    private String driver;
    private String url;
    private String user;
    private String password;
    private Connection con;
    
    public JDBC(String user,String password,int port,String dbname) {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:"+Integer.toString(port)+"/"+dbname;
        this.user = user;
        this.password = password;
    }

    public void createConnection(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            System.out.println("Connection success");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connection fail");
        }
    }
    
    public void createQuery(String query){
        try {
            Statement st =  con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection(){
        
    }
       
}
