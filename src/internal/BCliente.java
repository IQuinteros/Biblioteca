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
    String fecha;
    
    ArrayList<String> Correos = new ArrayList();
    ArrayList<String> Direcciones = new ArrayList();
    ArrayList<String> Telefonos = new ArrayList();
    

    public BCliente(int id, String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String fecha) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fecha = fecha;
    }
    
    public void InitLists(ArrayList<String> correos, ArrayList<String> direcciones, ArrayList<String> telefonos){
        Correos = correos;
        Direcciones = direcciones;
        Telefonos = telefonos;
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

    public ArrayList<String> getCorreos() {
        return Correos;
    }

    public ArrayList<String> getDirecciones() {
        return Direcciones;
    }

    public ArrayList<String> getTelefonos() {
        return Telefonos;
    }

    public String getFecha() {
        return fecha;
    }
    
    
    
    public static boolean AddClient(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, ArrayList<String> Correos, ArrayList<String> Telefonos, ArrayList<String> Direcciones, boolean checkSizes, String customID){
        if(Correos == null || Telefonos == null || Direcciones == null){
            return false;
        }
        // copiar, pegar pero cambiando las consultas sql, esto es para añadir los distintos correos de los clientes, direccioes y telefonos etc... , hacer esto pa los trabajadores
        if(checkSizes && (Correos.size() <= 0 || Telefonos.size() <= 0 || Direcciones.size() <= 0)){
            return false;
        }
        
        ArrayList<String> queries = new ArrayList<>();
        
        queries.add("INSERT INTO Cliente VALUES (NULL, '"+rut+"', '"+nombre+"', '"+apellidoPaterno+"', '"+apellidoMaterno+"', '"+fechaNacimiento+"') "
                + "ON DUPLICATE KEY UPDATE rut = VALUES(rut), nombre = VALUES(nombre), apellido_paterno = VALUES(apellido_paterno), apellido_materno = VALUES(apellido_materno), fecha_nacimiento = VALUES(fecha_nacimiento);");
        
        for (int i = 0; i < Correos.size(); i++) {
            queries.add("INSERT INTO Correo VALUES (NULL, '"+Correos.get(i)+"');");
            if(customID != null && !customID.equals("")){
                queries.add("INSERT INTO Cliente_Correo VALUES (NULL, "+customID+", (SELECT MAX(id) FROM Correo));");
            }
            else{
                queries.add("INSERT INTO Cliente_Correo VALUES (NULL, (SELECT MAX(id) FROM Cliente), (SELECT MAX(id) FROM Correo));");
            }
        }
        
        for (int i = 0; i < Telefonos.size(); i++) {
            queries.add("INSERT INTO Telefono VALUES (NULL, '"+Telefonos.get(i)+"');");
            if(customID != null && !customID.equals("")){
                queries.add("INSERT INTO Cliente_Telefono VALUES (NULL, "+customID+", (SELECT MAX(id) FROM Telefono));");
            }
            else{
                queries.add("INSERT INTO Cliente_Telefono VALUES (NULL, (SELECT MAX(id) FROM Cliente), (SELECT MAX(id) FROM Telefono));");
            }
        }
        
        for (int i = 0; i < Direcciones.size(); i++) {
            queries.add("INSERT INTO Direccion VALUES (NULL, '"+Direcciones.get(i)+"');");
            if(customID != null && !customID.equals("")){
                queries.add("INSERT INTO Cliente_Direccion VALUES (NULL, "+customID+", (SELECT MAX(id) FROM Direccion));");
            }
            else{
                queries.add("INSERT INTO Cliente_Direccion VALUES (NULL, (SELECT MAX(id) FROM Cliente), (SELECT MAX(id) FROM Direccion));");
            }
        }
        
        return BConnector.ExecuteBatch(queries);
    }
    
    public static BCliente GetClienteByRut(String rut){//copiar y pegar, para buscar clientes y obtener todos sus datos, para 1 solo , hacer esto con los trabajadores
        ResultSet result = BConnector.ExecuteQueryResult("SELECT * FROM Cliente WHERE rut = '" + rut + "';");
                
        try{
            if(result.next())
            {
                BCliente newClient = new BCliente(result.getInt("id"), result.getString("rut"), result.getString("nombre"),
                    result.getString("apellido_paterno"), result.getString("apellido_materno"), result.getString("fecha_nacimiento"));
                
                ResultSet correos = BConnector.ExecuteQueryResult("SELECT correo FROM Correo c " +
                    "INNER JOIN Cliente_Correo rel on rel.correo_id = c.id " +
                    "INNER JOIN Cliente cl on cl.id = rel.cliente_id " +
                    "WHERE cl.rut = '"+rut+"'");
                
                ArrayList<String> Correos = new ArrayList();
                while(correos.next()){
                    Correos.add(correos.getString("correo"));
                }
                
                ResultSet direcciones = BConnector.ExecuteQueryResult("SELECT direccion FROM Direccion c " +
                    "INNER JOIN Cliente_Direccion rel on rel.direccion_id = c.id " +
                    "INNER JOIN Cliente cl on cl.id = rel.cliente_id " +
                    "WHERE cl.rut = '"+rut+"'");
                
                ArrayList<String> Direcciones = new ArrayList();
                while(direcciones.next()){
                    Direcciones.add(direcciones.getString("direccion"));
                }
                
                ResultSet telefonos = BConnector.ExecuteQueryResult("SELECT telefono FROM Telefono c " +
                    "INNER JOIN Cliente_Telefono rel on rel.telefono_id = c.id " +
                    "INNER JOIN Cliente cl on cl.id = rel.cliente_id " +
                    "WHERE cl.rut = '"+rut+"'");
                
                ArrayList<String> Telefonos = new ArrayList();
                while(telefonos.next()){
                    Telefonos.add(telefonos.getString("telefono"));
                }
                
                newClient.InitLists(Correos, Direcciones, Telefonos);
                
                return newClient;
            }
            else{
                return null;
            }
        }
        catch(Exception e){
            System.out.println("ERROR BCliente: " +  e.getMessage());
            return null;
        }
    }
    
    public static ArrayList<BCliente> GetAllClientes(){
        ResultSet result = BConnector.ExecuteQueryResult("SELECT id, rut, nombre, apellido_paterno, apellido_materno, fecha_nacimiento FROM Cliente");
        
        ArrayList<BCliente> toReturn = new ArrayList<>();
        
        try{
            while(result.next()){
                BCliente cliente = new BCliente(result.getInt("id"), 
                            result.getString("rut"), result.getString("nombre"),
                            result.getString("apellido_paterno"), result.getString("apellido_materno"), result.getString("fecha_nacimiento"));
                
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
