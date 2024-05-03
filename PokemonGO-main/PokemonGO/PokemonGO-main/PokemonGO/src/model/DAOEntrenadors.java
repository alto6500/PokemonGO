/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alto6500
 */
public class DAOEntrenadors {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String PROTOCOL = "jdbc:mysql:";
    static final String HOST = "127.0.0.1";
    static final String BD_NAME = "";
    static final String USER = "";
    static final String PASSWORD = "";
    static final String PARAMS = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    ArrayList<Entrenador> listado = new ArrayList<>();
    public static void loadDriver() throws ClassNotFoundException {
        Class.forName(DRIVER);
    }
    
    public static Connection getConnection() throws SQLException {
        final String BD_URL = String.format("%s//%s/%s?%s", PROTOCOL, HOST, BD_NAME, PARAMS);        
        Connection conn = null;
        conn = DriverManager.getConnection(BD_URL, USER, PASSWORD);
        return conn;
    }   

    public void AltaEntrenador(Entrenador en){
        if (listado.contains(en)){
            System.out.println("Entrenador ya existente");
        }else {
            listado.add(en);
        }
    }
    
    public Entrenador ExisteixEntrenador(String name){
        if (listado.){
            System.out.println("Entrenador ya existente");
        }else {
            return Entrenador en;
        }
    }
    
    public void esborrarEntrenador(String name){
      Scanner sc = new Scanner(System.in);
        Connection conn;
        int counter = 0;
        try{
            conn = getConnection();
            if(conn != null){
            Statement stmt = conn.createStatement();      
                String query = "DELETE FROM ENTRENADORES  WHERE NAME=?";
                System.out.println(query);
                PreparedStatement preparedQuery = conn.prepareStatement(query);
                preparedQuery.setNString(1, name);
                int RowsAffected = stmt.executeUpdate(query);
                System.out.println("Parametros afectados " + RowsAffected);
                stmt.close();
                conn.close();
            }
    }catch(SQLException ex){
        Logger.getLogger(DAOEntrenadors.class.getName());
        }
    }
}