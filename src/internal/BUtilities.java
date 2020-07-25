/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import javax.swing.JFrame;

/**
 *
 * @author RemoteUser
 */
public class BUtilities {
    
    public static boolean IsTextValid(String text){
        if(text == null){
            return false;
        }
        
        if(text.equals("")){
            return false;
        }
        
        return true;
    }
    
    public static void OpenFrame(JFrame frame){
        frame.pack();
        frame.setLocationRelativeTo(null); 
        
        frame.setVisible(true);
    }
    
}
