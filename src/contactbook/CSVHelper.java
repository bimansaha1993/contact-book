/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CSVHelper {
    public static void clearCSV(String filePath) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(CSVHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeToCSV(String filepath, ArrayList<Contact> csvcontacts){
        FileWriter fileWriter;
        try{
            fileWriter = new FileWriter(filepath);
            fileWriter.append("Id,First Name,Last Name,Phone Number");
            fileWriter.append("\n");
            for(Contact c : csvcontacts){
                fileWriter.append(String.valueOf(c.getId()+","+c.getFirstName()+","+c.getLastName()+","+c.getPhoneNo()));
                fileWriter.append("\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(CSVHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Contact> readFromCSV(String filepath) {
        try {
            BufferedReader reader = null;
            ArrayList<Contact> allContacts = new ArrayList<Contact>();
            String line;
            reader = new BufferedReader(new FileReader(filepath));
            reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if(fields.length > 0) {
                    Contact c = new Contact(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3]);
                    allContacts.add(c);
                }
            }
            reader.close();
            return allContacts;
        } catch (IOException ex) {
            Logger.getLogger(CSVHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
