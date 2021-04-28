package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Edwin y Marcos
 */
public class JDBC {
    private final String driver;
    private final String url;
    private final String user;
    private final String password;
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
    
    public int FindIdElementoByClave(String clave){
        int id_elemento=0;
        try {
            Statement st =  con.createStatement();
            ResultSet rs = st.executeQuery("select id_elemento from elementos where clave='"+clave+"'; ");
            while(rs.next()){
                id_elemento = rs.getInt("id_elemento");
            }
            return id_elemento;
        } catch (SQLException ex) {  
            System.out.println("Id elemento not found");
            return -1;
        }
    }
    
    public int FindIdEstacionByClaveEst(String claveEstacion){
        int id_estacion=0;
        try {
            Statement st =  con.createStatement();
            ResultSet rs = st.executeQuery("select id_estacion from estacion where clave_estacion='"+claveEstacion+"'; ");
            while(rs.next()){
                id_estacion = rs.getInt("id_estacion");
            }
            return id_estacion;
        } catch (SQLException ex) {  
            System.out.println("Id estacion not found");
            return -1;
        }
    }
    
    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error closing onnection");
        }
    }
       
}
