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
    String fechaContratacion;

    public BTrabajador(int id, String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaContratacion) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaContratacion = fechaContratacion;
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

    public String getFechaContratacion() {
        return fechaContratacion;
    }
    
    public static ArrayList<BTrabajador> GetAllTrabajadores(){
        ResultSet result = BConnector.ExecuteQueryResult("SELECT id, rut, nombre, apellido_paterno, apellido_materno, fecha_contratacion FROM Trabajador");
        
        ArrayList<BTrabajador> toReturn = new ArrayList<>();
        
        try{
            while(result.next()){
                BTrabajador trabajador = new BTrabajador(result.getInt("id"), 
                            result.getString("rut"), result.getString("nombre"),
                            result.getString("apellido_paterno"), result.getString("apellido_materno"),
                            result.getString("fecha_contratacion"));
                
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
