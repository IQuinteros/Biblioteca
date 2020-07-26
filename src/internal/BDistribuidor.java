
package internal;

import java.sql.ResultSet;
import java.util.ArrayList;

public class BDistribuidor {
    
    int id;
    String rut;
    String nombre_empresa;
    String año_inicio;
    String direccion;
    String Telefono_id;
    String correo_id;
    
    String direccionString;
    String telefonoString;
    String correoString;

    public BDistribuidor(int id, String rut, String nombre_empresa, String año_inicio, String direccion, String Telefono_id, String correo_id) {
        this.id = id;
        this.rut = rut;
        this.nombre_empresa = nombre_empresa;
        this.año_inicio = año_inicio;
        this.direccion = direccion;
        this.Telefono_id = Telefono_id;
        this.correo_id = correo_id;
    }
    
    private void InitStrings(String newDireccion, String newTelefono, String newCorreo){
        direccionString = newDireccion;
        telefonoString = newTelefono;
        correoString = newCorreo;
    }
    
    public String getFullName(){
        return "(" + rut + ") " + nombre_empresa;
    }

    public int getId() {
        return id;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public String getAño_inicio() {
        return año_inicio;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono_id() {
        return Telefono_id;
    }

    public String getCorreo_id() {
        return correo_id;
    }

    public String getDireccionString() {
        return direccionString;
    }

    public String getTelefonoString() {
        return telefonoString;
    }

    public String getCorreoString() {
        return correoString;
    }
    
    
    
    public static boolean AddDistribuidor(String rut, String nombre_empresa, String año_inicio, String direccion,String telefono,String correo, String direccion_id, String telefono_id, String correo_id){
        
        ArrayList<String> consultas = new ArrayList();
        
        if(direccion_id != null && !direccion_id.equals("") && telefono_id != null && !telefono_id.equals("") && correo_id != null && !correo_id.equals("")){
            consultas.add("UPDATE Direccion SET direccion = '"+direccion+"';");
            consultas.add("UPDATE Telefono SET telefono = '"+telefono+"';");
            consultas.add("UPDATE Correo SET correo = '"+correo+"';");
        }
        else{        
            consultas.add("INSERT INTO Direccion VALUES(NULL, '"+direccion+"');");
            consultas.add("INSERT INTO Telefono VALUES(NULL, '"+telefono+"');");
            consultas.add("INSERT INTO Correo VALUES(NULL, '"+correo+"');");
        }
        
        consultas.add("insert into Distribuidor values(null,'"+rut+"','"+nombre_empresa+"','"+año_inicio+"',(SELECT MAX(id) FROM Direccion), (SELECT MAX(id) FROM Telefono), (SELECT MAX(id) FROM Correo))"
                + " on duplicate key update nombre_empresa = VALUES(nombre_empresa), año_inicio = VALUES(año_inicio)");
        
        return BConnector.ExecuteBatch(consultas);
    }
    
    public static BDistribuidor GetDistribuidorByRut(String rut){
        ResultSet result = BConnector.ExecuteQueryResult("SELECT d.*, dir.direccion, tel.telefono, cor.correo FROM `Distribuidor` d\n" +
                                                            "INNER JOIN Direccion dir on dir.id = d.direccion_id\n" +
                                                            "INNER JOIN Telefono tel on tel.id = d.telefono_id\n" +
                                                            "INNER JOIN Correo cor on cor.id = d.correo_id\n" +
                                                            "WHERE rut = '"+rut+"';");
                
        try{
            if(result.next())
            {
                BDistribuidor newDistribuidor = new BDistribuidor(result.getInt("id"), 
                            result.getString("rut"), result.getString("nombre_empresa"),
                            result.getString("año_inicio"), result.getString("direccion_id"),
                            result.getString("telefono_id"), result.getString("correo_id"));
               
                newDistribuidor.InitStrings(result.getString("direccion"), result.getString("telefono"), result.getString("correo"));
                
                return newDistribuidor;
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
    
    public static ArrayList<BDistribuidor> GetAllDistribuidores(){
        ResultSet result = BConnector.ExecuteQueryResult("SELECT id, rut, nombre_empresa, año_inicio, direccion_id, telefono_id, correo_id FROM Distribuidor");
        
        ArrayList<BDistribuidor> toReturn = new ArrayList<>();
        
        try{
            while(result.next()){
                BDistribuidor Distribuidor = new BDistribuidor(result.getInt("id"), 
                            result.getString("rut"), result.getString("nombre_empresa"),
                            result.getString("año_inicio"), result.getString("direccion_id"),
                            result.getString("telefono_id"), result.getString("correo_id"));
                
                toReturn.add(Distribuidor);
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