/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

/**
 *
 * @author RemoteUser
 */
public class BSession {
    
    private static BTrabajador CurrentTrabajador = null;
    
    public static void SetCurrentTrabajador(BTrabajador trabajador){
        CurrentTrabajador = trabajador;
    }
    
    public static void CloseSession(){
        CurrentTrabajador = null;
    }
    
    public static BTrabajador GetCurrentTrabajador(){
        return CurrentTrabajador;
    }
    
}
