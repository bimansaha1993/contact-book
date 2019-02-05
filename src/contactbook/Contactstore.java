/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactbook;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Contactstore {
    
    private ArrayList <Contact> contacts;
    private int contactId;
    
    Contactstore() {
        this.contacts = new ArrayList<Contact>();
        this.contactId = 0;
    }
    
    void addContact()//String phoneNo, String firstName, String lastName)
    {   
        System.out.println("Add new record: ");
        System.out.print("First Name:");
        Scanner fN = new Scanner(System.in);
        String firstName = fN.nextLine().trim();
        System.out.print("Last name:");
        Scanner lN = new Scanner(System.in);
        String lastName = lN.nextLine().trim();
        System.out.print("Phone Number:");
        Scanner pN = new Scanner(System.in);
        String phoneNo = pN.nextLine().trim();
        Contact c = new Contact(contactId, firstName,lastName, phoneNo);///variable
        this.contacts.add(c);
        this.contactId++;
    }

    Contact getContactById(int id)
    {
        for(Contact c : contacts)
        {
            if(c.getId() == id)
            {
                return c;
            }
        }
        return null;
    }

    ArrayList<Contact> getAllContacts()
    {
        return this.contacts;
    }

    ArrayList<Contact> searchContact(String searchTerm)
    {
        ArrayList<Contact> filteredContacts = new ArrayList<Contact>();
        for(Contact c : contacts)
        {
            if(searchTerm == c.getFullname() || searchTerm==c.getPhoneNo() || searchTerm==c.getFirstName() || searchTerm==c.getLastName())
            {
                filteredContacts.add(c);
            }
        }
        return filteredContacts;
    }
    
     ArrayList<Contact> searchByName(String searchTerm)
    {
        ArrayList<Contact> filteredName=new ArrayList<Contact>();
        for(Contact c : contacts){
            if(c.getFullname().toLowerCase().contains(searchTerm.toLowerCase())){
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
    }
    
    void deleteContactByName(String name) {
        ArrayList<Contact> filteredContacts = searchByName(name);
        for(Contact c : filteredContacts) {
            contacts.remove(c);
        }
    }
}
