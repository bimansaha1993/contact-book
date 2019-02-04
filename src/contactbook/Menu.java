/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactbook;

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
        System.out.println("Enter your choice: ");
    }

    //Contact c=new Contact();
    void selectedMenu(int c)
    {
        switch(c)
        {
            case '1':
            {
                System.out.println("Add new record: ");
                System.out.println("First Name:");
                Scanner firstname=new Scanner(System.in);
                System.out.println("Last name:");
                Scanner lasttname=new Scanner(System.in);
                System.out.println("Phone Nmber:");
                Scanner phoneno=new Scanner(System.in);
                break;
            }
            case '2':
            {
                System.out.println("Search by name");
                
                break;
            }
            case '3':
            {
                System.out.println("Search by number");
                break;
            }
            case '4':
            {
                System.out.println("show all contacts");
                break;
            }
            case '5':
            {
                System.out.println("delete contact");
                break;
            }
            case '6':
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
