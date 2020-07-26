/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
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
    
    public static ArrayList<String> ModelOfStringsToArrayList(DefaultListModel modelRef){
        
        ArrayList<String> toReturn = new ArrayList();
        for (int i = 0; i < modelRef.getSize(); i++) {
            toReturn.add((String)modelRef.get(i));
        }
        
        return toReturn;
        
    }
    
    public static String DateFormatString(String day, String month, String year){
        
        if(day == null){
            return "";
        }
        if(month == null){
            return "";
        }
        if(year == null){
            return "";
        }
        
        if(!day.equals("") && !month.equals("") && !year.equals("")){
            if(day.length() == 1){
                String preDay = day;
                day = "0";
                day += preDay;
            }
            
            if(month.length() == 1){
                String preMonth = month;
                month = "0";
                month += preMonth;
            }
            
            if(year.length() == 2){
                String preYear = year;
                year = "20";
                year += "preYear";
            }
            
            return day + "-" + month + "-" + year;
        }
        else{
            return "";
        }
        
    }
    
}
