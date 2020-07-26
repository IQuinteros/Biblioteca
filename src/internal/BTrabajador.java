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
public class BTrabajador {
    int id;
    String rut;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;

    String password;
    String fechaContratacion;
    
    ArrayList<String> Correos = new ArrayList();
    ArrayList<String> Direcciones = new ArrayList();
    ArrayList<String> Telefonos = new ArrayList();

    public BTrabajador(int id, String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String password, String fechaContratacion) {

        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.password = password;
        this.fechaContratacion = fechaContratacion;
    }
    
    public void InitLists(ArrayList<String> correos, ArrayList<String> direcciones, ArrayList<String> telefonos){
        Correos = correos;
        Direcciones = direcciones;
        Telefonos = telefonos;
    }
    
    public String getFullNameCode(){
        return "(" + rut + ") " + nombre + " " + apellidoPaterno;
    }

    public int getId() {
        return id;
    }

    public String getRut() {
        return rut;
    }
    
    public String getFullName(){
        return nombre + " " + apellidoPaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    
    public String getPassword() {
        return password;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }
    
     public ArrayList<String> getCorreos() {
        return Correos;
    }

    public ArrayList<String> getDirecciones() {
        return Direcciones;
    }

    public ArrayList<String> getTelefonos() {
        return Telefonos;
    }
    
     public static boolean AddTrabajador(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String password, String fechaContratacion, ArrayList<String> Correos, ArrayList<String> Telefonos, ArrayList<String> Direcciones, boolean checkSizes){
        if(Correos == null || Telefonos == null || Direcciones == null){
            return false;
        }
        // copiar, pegar pero cambiando las consultas sql, esto es para añadir los distintos correos de los clientes, direccioes y telefonos etc... , hacer esto pa los trabajadores
        if(checkSizes && (Correos.size() <= 0 || Telefonos.size() <= 0 || Direcciones.size() <= 0)){
            return false;
        }
        
        ArrayList<String> queries = new ArrayList<>();
        
        queries.add("INSERT INTO Cliente VALUES (NULL, '"+rut+"', '"+nombre+"', '"+apellidoPaterno+"', '"+apellidoMaterno+"','"+password+"' '"+fechaContratacion+"') "
                + "ON DUPLICATE KEY UPDATE rut = VALUES(rut), nombre = VALUES(nombre), apellido_paterno = VALUES(apellido_paterno), apellido_materno = VALUES(apellido_materno), password = VALUES(password), fecha_contratacion = VALUES(fecha_contratacion);");
        
        for (int i = 0; i < Correos.size(); i++) {
            queries.add("INSERT INTO Correo VALUES (NULL, '"+Correos.get(i)+"');");
            queries.add("INSERT INTO Trabajador_Correo VALUES (NULL, (SELECT MAX(id) FROM Trabajador), (SELECT MAX(id) FROM Correo));");
        }
        
        for (int i = 0; i < Telefonos.size(); i++) {
            queries.add("INSERT INTO Telefono VALUES (NULL, '"+Telefonos.get(i)+"');");
            queries.add("INSERT INTO Trabajador_Telefono VALUES (NULL, (SELECT MAX(id) FROM Trabajador), (SELECT MAX(id) FROM Telefono));");
        }
        
        for (int i = 0; i < Direcciones.size(); i++) {
            queries.add("INSERT INTO Direccion VALUES (NULL, '"+Direcciones.get(i)+"');");
            queries.add("INSERT INTO Trabajador_Direccion VALUES (NULL, (SELECT MAX(id) FROM Trabajador), (SELECT MAX(id) FROM Direccion));");
        }
        
        return BConnector.ExecuteBatch(queries);
    }
    
         public static BTrabajador GetTrabajadorByRut(String rut){//copiar y pegar, para buscar clientes y obtener todos sus datos, para 1 solo , hacer esto con los trabajadores
        ResultSet result = BConnector.ExecuteQueryResult("SELECT * FROM Trabajador WHERE rut = '" + rut + "';");
                
        try{
            if(result.next())
            {
                BTrabajador newTrabajador = new BTrabajador(result.getInt("id"), result.getString("rut"), result.getString("nombre"),
                    result.getString("apellido_paterno"), result.getString("apellido_materno"), result.getString("password"),
                        result.getString("fecha_nacimiento"));
                
                ResultSet correos = BConnector.ExecuteQueryResult("SELECT correo FROM Correo c " +
                    "INNER JOIN Trabajador_Correo rel on rel.correo_id = c.id " +
                    "INNER JOIN Trabajador cl on cl.id = rel.cliente_id " +
                    "WHERE cl.rut = '"+rut+"'");
                
                ArrayList<String> Correos = new ArrayList();
                while(correos.next()){
                    Correos.add(correos.getString("correo"));
                }
                
                ResultSet direcciones = BConnector.ExecuteQueryResult("SELECT direccion FROM Direccion c " +
                    "INNER JOIN Trabajador_Direccion rel on rel.direccion_id = c.id " +
                    "INNER JOIN Trabaajdor cl on cl.id = rel.cliente_id " +
                    "WHERE cl.rut = '"+rut+"'");
                
                ArrayList<String> Direcciones = new ArrayList();
                while(direcciones.next()){
                    Direcciones.add(direcciones.getString("direccion"));
                }
                
                ResultSet telefonos = BConnector.ExecuteQueryResult("SELECT telefono FROM Telefono c " +
                    "INNER JOIN Trabajador_Telefono rel on rel.telefono_id = c.id " +
                    "INNER JOIN Trabajador cl on cl.id = rel.cliente_id " +
                    "WHERE cl.rut = '"+rut+"'");
                
                ArrayList<String> Telefonos = new ArrayList();
                while(telefonos.next()){
                    Telefonos.add(telefonos.getString("telefono"));
                }
                
                newTrabajador.InitLists(Correos, Direcciones, Telefonos);
                
                return newTrabajador;
            }
            else{
                return null;
            }
        }
        catch(Exception e){
            System.out.println("ERROR BTrabajador: " +  e.getMessage());
            return null;
        }
    }
     
    public static ArrayList<BTrabajador> GetAllTrabajadores(){
        ResultSet result = BConnector.ExecuteQueryResult("SELECT id, rut, nombre, apellido_paterno, apellido_materno, fecha_contratacion, password FROM Trabajador");
        
        ArrayList<BTrabajador> toReturn = new ArrayList<>();
        
        try{
            while(result.next()){
                BTrabajador trabajador = new BTrabajador(result.getInt("id"), 
                            result.getString("rut"), result.getString("nombre"),
                            result.getString("apellido_paterno"), result.getString("apellido_materno"),
                            result.getString("fecha_contratacion"),
                            result.getString("password"));
                
                toReturn.add(trabajador);
            }
            BConnector.CloseConnection();
            return toReturn;
        }
        catch(Exception e){
            BConnector.CloseConnection();
            return null;
        }
        
    }
    
}
