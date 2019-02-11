/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactbook;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author User
 */
public class Contactstore {
//    private ArrayList <Contact> contacts;
//    private int contactId;
    private String filepath;
    
    Contactstore() {
        this.filepath = "./CSV/contactbook.csv";
//        this.contacts = CSVHelper.readFromCSV(filepath)
//        this.contactId = 1;
    }
    
    void clearStore() {
        CSVHelper.clearCSV(this.filepath);
    }
    
    void addContact(String phoneNo, String firstName, String lastName)
    {   
        ArrayList<Contact> contacts = CSVHelper.readFromCSV(this.filepath);
        int id = contacts.size() > 0 ? contacts.get(contacts.size()-1).getId() + 1 : 1;
        Contact c = new Contact(id, firstName,lastName, phoneNo);///variable
        contacts.add(c);
        CSVHelper.writeToCSV(this.filepath, contacts);
    }

    /*Contact getContactById(int id)
    {
        for(Contact c : contacts)
        {
            if(c.getId() == id)
            {
                return c;
            }
        }
        return null;
    }*/

    ArrayList<Contact> getAllContacts()
    {
        ArrayList<Contact> contacts = CSVHelper.readFromCSV(this.filepath);
        return contacts;
    }

    ArrayList<Contact> searchContact(String searchTerm)
    {
        ArrayList<Contact> filteredContacts = new ArrayList<Contact>();
        ArrayList<Contact> contacts = CSVHelper.readFromCSV(this.filepath);
        for(Contact c : contacts)
        {
            if(c.getFullName().toLowerCase().contains(searchTerm.toLowerCase()) || c.getPhoneNo().contains(searchTerm))
            {
                filteredContacts.add(c);
            }
        }
        return filteredContacts;
    }
    
     /*ArrayList<Contact> searchByName(String searchTerm)
    {
        ArrayList<Contact> filteredName=new ArrayList<Contact>();
        for(Contact c : contacts){
            if(c.getFullName().toLowerCase().contains(searchTerm.toLowerCase())){
                filteredName.add(c);
            }
        }
        return filteredName;
    }
    
    ArrayList<Contact> searchByNumber(String searchTerm)
    {
        ArrayList<Contact> filteredNumber=new ArrayList<Contact>();
        for(Contact c : contacts){
            if( c.getPhoneNo().contains(searchTerm)){
                filteredNumber.add(c);
            }
        }
        return filteredNumber;
    }*/
    
    void deleteContactById(int id) {
        ArrayList<Contact> contacts = CSVHelper.readFromCSV(this.filepath);
        Iterator cIterator = contacts.iterator();
        while (cIterator.hasNext()) {
            Contact c = (Contact) cIterator.next();
            if(c.getId() == id)
            {
                cIterator.remove();
                break;
            }
        }
        CSVHelper.writeToCSV(this.filepath, contacts);
    }
    
    void deleteContact(String deleteterm) {
       
        ArrayList<Contact> filteredContacts = searchContact(deleteterm);
        for(Contact c : filteredContacts) {
            deleteContactById(c.getId());
        }
    }
}
