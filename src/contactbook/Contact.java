/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactbook;

/**
 *
 * @author User
 */
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNo;

    Contact()
    {

    }

    Contact(int id, String firstName, String lastName, String phoneNo)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
    }
    
    int getId(){
        return this.id;
    }
    
    String getFirstName(){
        return this.firstName;
    }

    String getLastName(){
        return this.lastName;
    }

    String getFullname(){
        return this.firstName + " " + this.lastName;
    }

    String getPhoneNo(){
        return this.phoneNo;
    }
}
