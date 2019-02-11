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
        System.out.println();
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
                System.out.println("Contact has been added.");
                System.out.println();
                break;
            }
            case 2:
            {
                System.out.print("Search by name(first/last/full):");
                Scanner sn = new Scanner(System.in);
                String serachterm = sn.nextLine();
                ArrayList<Contact> filteredName = cs.searchContact(serachterm);
                for(Contact c : filteredName)
                {
                    System.out.println(c.getId()+" "+c.getFullName()+" "+c.getPhoneNo());
                }
                System.out.println();
                break;
            }
            case 3:
            {
                System.out.print("Search by number(11 Digit):");
                Scanner sn = new Scanner(System.in);
                String serachterm = sn.nextLine();
                ArrayList<Contact> filteredNumber = cs.searchContact(serachterm);
                for(Contact c : filteredNumber)
                {
                    System.out.println(c.getId()+" "+c.getFullName()+" "+c.getPhoneNo());
                }
                System.out.println();
                break;
            }
            case 4:
            {
                System.out.println("All contacts");
                ArrayList<Contact> allContacts = cs.getAllContacts();
                for(Contact c : allContacts)
                {
                    System.out.println(c.getId()+" "+c.getFullName()+" "+c.getPhoneNo());
                }
                System.out.println();
                break;
            }
            case 5:
            {
                boolean deleteControl=true;
                while(deleteControl){
                    System.out.println("Delete Contact");
                    System.out.println("1.Delete by name");
                    System.out.println("2.Delete by phone number.");
                    System.out.println("3.Back");
                    System.out.println();
                    System.out.print("Enter your choice:");
                    Scanner input=new Scanner(System.in);
                    int deleteChoice=input.nextInt();
                    System.out.println();
                    switch(deleteChoice)
                    {
                        case 1:
                        {
                            System.out.print("Name:");
                            Scanner dn = new Scanner(System.in);
                            String deleteName = dn.nextLine();
                            ArrayList<Contact> filteredName = cs.searchContact(deleteName);
                            for(Contact c : filteredName)
                            {
                                System.out.println(c.getId()+" "+c.getFullName()+" "+c.getPhoneNo());
                            }
                            System.out.println();
                            System.out.print("Enter FullName/FirstName/LastName You Wanted to Delete:");
                            Scanner name = new Scanner(System.in);
                            String Name = name.nextLine();
                            System.out.println();
                            cs.deleteContact(Name);
                            break;
                        }
                        case 2:
                        {
                            System.out.print("Number:");
                            Scanner dnu = new Scanner(System.in);
                            String deleteNumber = dnu.nextLine();
                            ArrayList<Contact> filteredNumber = cs.searchContact(deleteNumber);
                            for(Contact c : filteredNumber)
                            {
                                System.out.println(c.getId()+" "+c.getFullName()+" "+c.getPhoneNo());
                            }
                            System.out.println();
                            System.out.print("Enter FullNumber You Wanted to Delete:");
                            Scanner number = new Scanner(System.in);
                            String Number = number.nextLine();
                            System.out.println();
                            cs.deleteContact(Number);
                            break;
                        }
                        case 3:
                        {
                            System.out.println("Contact Deleted Successfully");
                            System.out.println();
                            deleteControl=false;
                            break;
                        }
                        default:
                            System.out.println("your selected menu is not valid");
                            System.out.println();
                    }
                }
                break;
            }
            case 6:
            {
                System.out.println("Have a nice day.....");
                control=false;
                break;
            }
            default :
                System.out.println("your choice is not valid");
        }
    }
}
