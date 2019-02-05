/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactbook;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Contactbook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    // TODO code application logic here
        int choice;
        Menu m = new Menu();
        while(m.control){
            m.showMenu();
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your choice(1-6):");
            choice = input.nextInt();
            m.selectedMenu(choice);
            /*ArrayList<Contact> allContacts = cs.getAllContacts();
            for(Contact c : allContacts) {
                System.out.println(c.getId() + " " + c.getFullname() + " " + c.getPhoneNo());
            }*/
            
        }
    }
}
