/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;

/**
 * 
 * @author marcos
 */
public class ETL {
    private JDBC jdbc;

    public ETL() {
        jdbc = new JDBC("dataminingdba","12345678",3306,"contaminantes");
        //jdbc = new JDBC("dataminingdba","12345678",3308,"contaminantes");
        jdbc.createConnection();
    }
    
    public void extract(){

        File directory = new File("../pph/");
        File[] contents = directory.listFiles();
        for ( File f : contents) {
            System.out.println(f.getName());
        }
    }
        
    public void transform(){
        
    }
    
    public void load(){
        
    }
}
