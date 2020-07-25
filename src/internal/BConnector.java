/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author RemoteUser
 */
public class BConnector {
    //private Connection connector;
    
    private static String database = "";
    private static String dbIP = "54.87.109.124";
    private static String userName = "temp1";
    private static String userPass = "temp1";
    
    private static Connection connectionRef;
    
    public static void Init(String databaseName, String ip, String newUserName, String newUserPass){
        database = databaseName;
        dbIP = ip;
        userName = newUserName;
        userPass = newUserPass;
    }
    
    public static Connection getConnection(){
        Connection conexion;
        
        /*parametros para la conexion*/
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://"+dbIP+":3306/" + database;
        String usuario = userName;
        String clave = userPass;

        /*procedimiento de la conexion*/
        try{
            Class.forName(driver);

            conexion = DriverManager.getConnection(url,usuario,clave);

            if(conexion.isClosed()){
                return null;
            }
            else{
                return conexion;
            }
        } catch (Exception ex){
            return null;
        }
    }
    
    public static boolean ExecuteQuery(String query){
        try{
            connectionRef = getConnection();
            PreparedStatement statement = connectionRef.prepareStatement(query);
            
            statement.execute();
            
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public static void CloseConnection(){
        try{
            connectionRef.close();
        }
        catch(Exception e){
            
        }
    }
    
    public static ResultSet ExecuteQueryResult(String query){
        try{
            ResultSet result;
            connectionRef = getConnection();
            Statement statement = connectionRef.createStatement();
            
            result = statement.executeQuery(query);
            
            return result;
        }
        catch(Exception e){
            return null;
        }
    }
    
    public static boolean ExecuteBatch(ArrayList<String> queries){
         try{
            connectionRef = getConnection();
            Statement statement = connectionRef.createStatement();
            
             for (int i = 0; i < queries.size(); i++) {
                 statement.addBatch(queries.get(i));
             }
            
            statement.executeBatch();
            
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
}
