/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author RemoteUser
 */
public class BCliente {
    int id;
    String rut;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;

    public BCliente(int id, String rut, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }
    
    public String getFullNameCode(){
        return "(" + rut + ") " + nombre + " " + apellidoPaterno;
    }
    
    public String getFullName(){
        return nombre + " " + apellidoPaterno;
    }

    public int getId() {
        return id;
    }

    public String getRut() {
        return rut;
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
    
    public static boolean AddClient(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, ArrayList<String> Correos, ArrayList<String> Telefonos, ArrayList<String> Direcciones){
        if(Correos == null || Telefonos == null || Direcciones == null){
            return false;
        }
        
        if(Correos.size() <= 0 || Telefonos.size() <= 0 || Direcciones.size() <= 0){
            return false;
        }
        
        ArrayList<String> queries = new ArrayList<>();
        
        queries.add("INSERT INTO Cliente VALUES (NULL, '"+rut+"', '"+nombre+"', '"+apellidoPaterno+"', '"+apellidoMaterno+"', '"+fechaNacimiento+"');");
        
        for (int i = 0; i < Correos.size(); i++) {
            queries.add("INSERT INTO Correo VALUES (NULL, '"+Correos.get(i)+"');");
            queries.add("INSERT INTO Cliente_Correo VALUES (NULL, (SELECT MAX(id) FROM Cliente), (SELECT MAX(id) FROM Correo));");
        }
        
        for (int i = 0; i < Telefonos.size(); i++) {
            queries.add("INSERT INTO Telefono VALUES (NULL, '"+Telefonos.get(i)+"');");
            queries.add("INSERT INTO Cliente_Telefono VALUES (NULL, (SELECT MAX(id) FROM Cliente), (SELECT MAX(id) FROM Telefono));");
        }
        
        for (int i = 0; i < Direcciones.size(); i++) {
            queries.add("INSERT INTO Direccion VALUES (NULL, '"+Direcciones.get(i)+"');");
            queries.add("INSERT INTO Cliente_Direccion VALUES (NULL, (SELECT MAX(id) FROM Cliente), (SELECT MAX(id) FROM Direccion));");
        }
        
        return BConnector.ExecuteBatch(queries);
    }
    
    public static ArrayList<BCliente> GetAllClientes(){
        ResultSet result = BConnector.ExecuteQueryResult("SELECT id, rut, nombre, apellido_paterno, apellido_materno FROM Cliente");
        
        ArrayList<BCliente> toReturn = new ArrayList<>();
        
        try{
            while(result.next()){
                BCliente cliente = new BCliente(result.getInt("id"), 
                            result.getString("rut"), result.getString("nombre"),
                            result.getString("apellido_paterno"), result.getString("apellido_materno"));
                
                toReturn.add(cliente);
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
