/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactbook;

import java.util.ArrayList;

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
    
    void addContact(String phoneNo, String firstName, String lastName)
    {
        //contacts[contact_cnt++]=Addcontact(int id,String first_name,String last_name,String phone_no);
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
}