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
public class Menu {
    void showMenu()
    {
        System.out.println("1. Add new contact");
        System.out.println("2. Search by name");
        System.out.println("3. Search by number");
        System.out.println("4. Show all contacts");
        System.out.println("5. Delete contact");
        System.out.println("6. Exit");
    }

    Contactstore cs = new Contactstore();
    boolean control=true;

    void selectedMenu(int choice)
    {
        switch(choice)
        {
            case 1:
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
                cs.addContact(phoneNo, firstName, lastName);
                break;
            }
            case 2:
            {
                System.out.print("Search by name(first/last/full):");
                Scanner sn = new Scanner(System.in);
                String serachterm = sn.nextLine();
                ArrayList<Contact> filteredName = cs.searchByName(serachterm);
                for(Contact c : filteredName)
                {
                    System.out.println(c.getId()+" "+c.getFullname()+" "+c.getPhoneNo());
                }       
                break;
            }
            case 3:
            {
                System.out.print("Search by number(11 Digit):");
                Scanner sn = new Scanner(System.in);
                String serachterm = sn.nextLine();
                ArrayList<Contact> filteredNumber = cs.searchByNumber(serachterm);
                for(Contact c : filteredNumber)
                {
                    System.out.println(c.getId()+" "+c.getFullname()+" "+c.getPhoneNo());
                }

                break;
            }
            case 4:
            {
                System.out.println("All contacts");
                ArrayList<Contact> allContacts = cs.getAllContacts();
                for(Contact c : allContacts)
                {
                    System.out.println(c.getId()+" "+c.getFullname()+" "+c.getPhoneNo());
                }
                break;
            }
            case 5:
            {
                System.out.println("Delete Contact");
                System.out.println("1.Delete by name");
                System.out.println("2.Delete by phone number.");
                System.out.println("3.Back");
                System.out.print("Enter your choice:");
                Scanner input=new Scanner(System.in);
                int deleteChoice=input.nextInt();
                switch(deleteChoice)
                {
                    case 1:
                    {
                        
                    }
                    case 2:
                    {
                        
                    }
                    case 3:
                    {
                        
                    }
                    default:
                        System.out.println("your selected menu is not valid");
                }

                break;
            }
            case 6:
            {
                System.out.println("Have a nice day.....");
                break;
            }
            default :
                System.out.println("your choice is not valid");
        }
    }
    boolean isValid(int c)
    {
        return !(c < '1' || c > '7');
    }
}
