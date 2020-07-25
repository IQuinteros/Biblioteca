/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import internal.BConnector;
import visual.*;

/**
 *
 * @author RemoteUser
 */
public class index {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BConnector.Init("azeak623_biblioteca", "162.241.148.182", "azeak623_inacap", "inacap123");
        
        VLogin loginPage = new VLogin();
        
        loginPage.pack();
        loginPage.setLocationRelativeTo(null); 
        
        loginPage.setVisible(true);
        
    }
    
}
