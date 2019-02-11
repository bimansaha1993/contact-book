/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactbook;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Contactbook {
    private static void runTest() {        
        Contactstore cs = new Contactstore();     
        cs.clearStore();
        
        System.out.println("************** Insertion Test ******************");
        
        cs.addContact("01750187821", "Biman", "Saha");
        cs.addContact("01755187821", "Nazmul", "Islam");
        cs.addContact("01750187821", "Sohel", "Rahman");
        cs.addContact("01756187821", "Uttam", "Saha");

        // Test allContacts method
        ArrayList<Contact> allContacts = cs.getAllContacts();
        for(Contact c : allContacts) {
            System.out.println(c.getId() + " " + c.getFullName() + " " + c.getPhoneNo());
        }
        
        System.out.println("***********************************************");

        
        System.out.println("************** Search Test ******************");
        //Test searchContact method
        ArrayList<Contact> filteredContacts = cs.searchContact("01750187821");
        for(Contact c : filteredContacts) {
            System.out.println(c.getId() + " " + c.getFullName() + " " + c.getPhoneNo());
        }

        System.out.println("***********************************************");

        
        System.out.println("************** Deletion Test ******************");
        
        // Test deleteContactByName method
        cs.deleteContact("Nazmul Islam");
        allContacts = cs.getAllContacts();
        for(Contact c : allContacts) {
            System.out.println(c.getId() + " " + c.getFullName() + " " + c.getPhoneNo());
        }
        
        System.out.println("***********************************************");
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        boolean testMode = false;
        
        if(testMode) {
            runTest();
        } else {        
            int choice;
            Menu m = new Menu();
            while(m.control){
                m.showMenu();
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your choice(1-6):");
                choice = input.nextInt();
                System.out.println();
                m.selectedMenu(choice);
                /*ArrayList<Contact> allContacts = cs.getAllContacts();
                for(Contact c : allContacts) {
                    System.out.println(c.getId() + " " + c.getFullname() + " " + c.getPhoneNo());
                }*/
            }
        }
    }
}
