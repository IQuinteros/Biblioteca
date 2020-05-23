/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import visual.VHome;

/**
 *
 * @author RemoteUser
 */
public class index {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VHome homePage = new VHome();
        
        homePage.pack();
        homePage.setLocationRelativeTo(null); 
        
        homePage.show();
        
    }
    
}
